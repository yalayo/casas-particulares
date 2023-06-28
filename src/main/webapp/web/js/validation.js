/*
* Really easy field validation with Prototype
* http://tetlaw.id.au/view/javascript/really-easy-field-validation
* Andrew Tetlaw
* Version 1.5.4.1 (2007-01-05)
* 
* Copyright (c) 2007 Andrew Tetlaw
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use, copy,
* modify, merge, publish, distribute, sublicense, and/or sell copies
* of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
* BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
* ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
* CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
* 
*/
var Validator = Class.create();

Validator.prototype = {
	initialize : function(className, error, test, options) {
		if(typeof test == 'function'){
			this.options = $H(options);
			this._test = test;
		} else {
			this.options = $H(test);
			this._test = function(){return true};
		}
		this.error = error || 'Validation failed.';
		this.className = className;
	},
	test : function(v, elm) {
		return (this._test(v,elm) && this.options.all(function(p){
			return Validator.methods[p.key] ? Validator.methods[p.key](v,elm,p.value) : true;
		}));
	}
}
Validator.methods = {
	pattern : function(v,elm,opt) {return Validation.get('IsEmpty').test(v) || opt.test(v)},
	ignoreDisabled : true,
	minLength : function(v,elm,opt) {return ((v=="") || (v.length >= opt))},
	maxLength : function(v,elm,opt) {return ((v=="") || (v.length <= opt))},
	min : function(v,elm,opt) {return v >= parseFloat(opt)}, 
	max : function(v,elm,opt) {return v <= parseFloat(opt)},
	notOneOf : function(v,elm,opt) {return $A(opt).all(function(value) {
		return v != value;
	})},
	oneOf : function(v,elm,opt) {return $A(opt).any(function(value) {
		return v == value;
	})},
	is : function(v,elm,opt) {return v == opt},
	isNot : function(v,elm,opt) {return v != opt},
	equalToField : function(v,elm,opt) {return v == $F(opt)},
	notEqualToField : function(v,elm,opt) {return v != $F(opt)},
	include : function(v,elm,opt) {return $A(opt).all(function(value) {
		return Validation.get(value).test(v,elm);
	})}
}

var Validation = Class.create();

Validation.prototype = {
	initialize : function(form, options, groupValidations){
		this.options = Object.extend({
			onSubmit : false,
			stopOnFirst : false,
			immediate : false,
			focusOnError : true,
			useTitles : false,
			suffix : "",
			ignoreDisabled : true,
			onFormValidate : function(result, form) {},
			onElementValidate : function(result, elm) {}
		}, options || {});
		this.groupValidations = groupValidations || [];
		this.form = $(form);
		if(this.options.onSubmit) Event.observe(this.form,'submit',this.onSubmit.bind(this),false);
		if(this.options.immediate) {
			var useTitles = this.options.useTitles;
			var callback = this.options.onElementValidate;
			Form.getElements(this.form).each(function(input) { // Thanks Mike!
				Event.observe(input, 'blur', function(ev) { Validation.validate(Event.element(ev),{useTitle : useTitles, onElementValidate : callback}); });
			});
		}
	},
	onSubmit :  function(ev){
		if(!this.validate()) Event.stop(ev);
	},
	validate : function() {
		Validation.clearMsgList();
		try {
			var result = false;
			var useTitles = this.options.useTitles;
			var _suffix = this.options.suffix;
			var callback = this.options.onElementValidate;
			var elms=Form.getElements(this.form);
			this.form.select(".cicpc_wysiwyg").each(function(elm){elms.push(elm);});
			
			elms.collect(function(elm) { 								
				if($(elm).hasClassName('border-error')) {
					elm.removeClassName('border-error');
				}
			});
			
			if(this.options.stopOnFirst) {
				result = elms.all(function(elm) { return Validation.validate(elm,{useTitle : useTitles, suffix : _suffix, onElementValidate : callback}); });
			} else {
				result = elms.collect(function(elm) { return Validation.validate(elm,{useTitle : useTitles, suffix : _suffix, onElementValidate : callback}); }).all();
			}
			if(!result && this.options.focusOnError) {
				var elementoError = Form.getElements(this.form).findAll(function(elm){return $(elm).hasClassName('validation-failed')}).first();
				
				Validation.focusElement(elementoError);
				elementoError.addClassName("border-error");
			}
			if (result)
				Validation.clearMsgList();
			if (result) result=this.validateGroups();
			this.options.onFormValidate(result, this.form);
			return result;
		}catch(e){
			return true;
		}
	},
	validateGroups:function(){
		var groups = $A(this.groupValidations);
		return groups.all(function(item){return Validation.validateGroup(this.form,item)}.bind(this));
	},
	reset : function() {
		Form.getElements(this.form).each(Validation.reset);
	}
}

Object.extend(Validation, {
	validate : function(elm, options){
		options = Object.extend({
			useTitle : false,
			suffix : "",
			ignoreDisabled : true,
			onElementValidate : function(result, elm) {}
		}, options || {});
		elm = $(elm);
		try{
		if (("SELECT"!=elm.tagName.toUpperCase())||(("SELECT"==elm.tagName.toUpperCase())&&(!elm.multiple)))
		elm.value=elm.value.strip();
		}catch(e){}
		var cn = elm.classNames();
		return result = cn.all(function(value) {
			if (options.suffix!="")
				value=value.substring(options.suffix.length);
			var test = Validation.test(value,elm,options);
			options.onElementValidate(test, elm);
			return test;
		});
	},
	test : function(name, elm, options) {
		if (typeof(elm)=="undefined")return true;
		var useTitle=options.useTitles;
		var v = Validation.get(name);
		var prop = '__advice'+name.camelize();
		try {
		var value=null;
		try{value=$F(elm);}catch(e){}
		if(null==value){
			try{
				if("DIV"==elm.tagName.toUpperCase()){
					value=CICPC._divSerializer(elm);
					if(null!=value)	value=value.stripTags().strip();
				}
			}catch(e){}
		}
		if(Validation.isVisible(elm,options.ignoreDisabled) && !v.test(value, elm)) {
			if(!elm[prop]) {
					var errorMsg = useTitle ? ((elm && elm.title) ? elm.title : v.error) : v.error;
					Validation.addErrorMsg(errorMsg,elm,name);
					
				window.scrollTo(0,0);
			}
			
			elm.addClassName('validation-failed');
			elm.addClassName("border-error");
			
			return false;
		} else {
			Validation.removeMsgById(elm.id, name);
			elm.removeClassName('validation-failed');
			
			if(elm.hasClassName('border-error')) {
				elm.removeClassName('border-error');
			}
			
			return true;
		}
		} catch(e) {
			throw(e)
		}
	},
	isVisible : function(elm,ignoreDisabled) {
		if (typeof(ignoreDisabled)=="undefined")
			ignoreDisabled=true;
		while(elm.tagName != 'BODY') {
			if(/*(!$(elm).visible())||*/((ignoreDisabled==true)&&($(elm).disabled))) return false;
			elm = elm.parentNode;
		}
		return true;
	},
	getAdvice : function(name, elm) {
		var obj = Validation.getMsgListObj();
		var eId = 'd_MsgList'+Validation.getElmID(elm)+"-"+name;
		var advice = $(eId);
		if (advice == null){
			var html = "<li id='"+eId+"'></li>";
			new Insertion.Top(obj,html);
			advice = $(eId);
		}
		return advice;
	},
	getElmID : function(elm) {
		if (elm == null)
			return "_";
		return elm.id ? elm.id : elm.name;
	},
	reset : function(elm) {
		elm = $(elm);
		var cn = elm.classNames();
		cn.each(function(value) {
			var prop = '__advice'+value.camelize();
			if(elm[prop]) {
				/*var advice = Validation.getAdvice(value, elm);
				advice.hide();*/
				Validation.removeMsgById(elm.id,value);
				elm[prop] = '';
			}
			elm.removeClassName('validation-failed');
			//elm.removeClassName('validation-passed');
		});
	},
	add : function(className, error, test, options) {
		var nv = {};
		nv[className] = new Validator(className, error, test, options);
		Object.extend(Validation.methods, nv);
	},
	addAllThese : function(validators) {
		var nv = {};
		$A(validators).each(function(value) {
				nv[value[0]] = new Validator(value[0], value[1], value[2], (value.length > 3 ? value[3] : {}));
			});
		Object.extend(Validation.methods, nv);
	},
	get : function(name) {
		return  Validation.methods[name] ? Validation.methods[name] : Validation.methods['_LikeNoIDIEverSaw_'];
	},
	methods : {
		'_LikeNoIDIEverSaw_' : new Validator('_LikeNoIDIEverSaw_','',{})
	},
	GROUP_AT_LEAST_ONE:0,
	GROUP_IF_ONE_ALL:1,
	GROUP_ALL_REQUIRED:2,
	GROUP_AT_LEAST_NCOUNT:3,
	validateGroup:function(form,group){
		group = Object.extend({ignoreDisabled: true}, group || {});
		var result = true;
		var elms = Form.getElements(form).findAll(function(elm){return ($(elm).hasClassName(group.className)&&Validation.isVisible(elm,group.ignoreDisabled))});
		if ((!elms)||(elms.length==0))
			return result;
		if (group.type==Validation.GROUP_AT_LEAST_ONE){
			if (typeof(group.msg)=="undefined")
				group.msg="Debe especificar un criterio de b&uacute;squeda.";
			result = elms.any(function(elm){
					return !Validation.get('IsSelEmpty').test(elm.value, elm);
				});
		} else if (group.type==Validation.GROUP_IF_ONE_ALL){
			if (typeof(group.msg)=="undefined")
				group.msg="Existen campos vac&iacute;os que son obligatorios, por favor, complete estos datos.";
			var any = false;
			if(group.ifNotEmpty){
				any = group.ifNotEmpty.split(",").any(function(objId){
						var obj=$(objId.strip());
						return !Validation.get('IsSelEmpty').test(obj.value, obj);
					});
			} else {
				any = elms.any(function(elm){
						return !Validation.get('IsSelEmpty').test(elm.value, elm);
					});
			}
			if (any)
				result = elms.all(function(elm){return !Validation.get('IsSelEmpty').test(elm.value,elm);});
		} else if (group.type==Validation.GROUP_ALL_REQUIRED){
			if (typeof(group.msg)=="undefined")
				group.msg="Existen campos vac&iacute;os que son obligatorios, por favor, complete estos datos.";
			result = elms.all(function(elm){return !Validation.get('IsSelEmpty').test(elm.value,elm);});
		} else if ((group.type==Validation.GROUP_AT_LEAST_NCOUNT)&&(typeof(group.count)!="undefined")){
			if (typeof(group.msg)=="undefined")
				group.msg="Debe introducir al menos "+group.count+" valores";
			var filledCount=0;
			elms.each(function(elm){if(!Validation.get('IsSelEmpty').test(elm.value, elm)){filledCount++;}});
			result=(filledCount>=group.count);
		}
		if (!result){
			//elms.invoke("removeClassName","validation-passed");
			elms.invoke("addClassName","validation-failed");
			Validation.focusElement(elms[0]);
			Validation.addErrorMsg(group.msg, elms[0]);
		}
		return result;
	},
	focusElement:function(elm){
		try {elm.focus();}catch(e){}
	},
	/* Errores */
	MSG_ERROR: 0,
	MSG_INFORMACION: 1,
	MSG_ADVERTENCIA: 2,
	MSG_STYLES: ['mensaje_error','mensaje_informacion','mensaje_advertencia'],
	MSG_LI_STYLES: ['cicpc-messages-error','cicpc-messages-info','cicpc-messages-warn'],
	MSG_TITLES: ['Error','Informaci&oacute;n','Advertencia'],
	SHOW_IF_EMPTY: 1,
	addErrorMsg: function (msg,elm,vname,tipo,msg_opts){
		if ("undefined"!=typeof(msg_opts)){
			if ((Validation.SHOW_IF_EMPTY == (msg_opts & Validation.SHOW_IF_EMPTY))&&(Validation.getErrorsCount()>0))
				return;
		}
		if (Validation.existsMessage(msg))
			return;
		if ((typeof(vname) == "undefined") || (vname==null))
			vname = "";
		if ((typeof(tipo) == "undefined") || (tipo==null))
			tipo = Validation.MSG_ERROR;
		var advice = Validation.getAdvice(vname, elm);
		advice.addClassName(Validation.MSG_LI_STYLES[tipo]);
		Element.update(advice,msg);
		var errorDesc = Validation.getMsgPanelObj();
		errorDesc.removeClassName('mensaje_advertencia');
		errorDesc.removeClassName('mensaje_informacion');
		errorDesc.removeClassName('mensaje_error');
		Element.show(errorDesc);
		Element.update(document.getElementsByClassName("header",errorDesc)[0], Validation.MSG_TITLES[tipo] + ":");
		errorDesc.addClassName(Validation.MSG_STYLES[tipo]);
		Validation.updateErrorsList();
	},
	clearMsgList: function (){
		var errorDesc = Validation.getMsgPanelObj();
		if (typeof(errorDesc) != "undefined"){
			errorDesc.removeClassName('mensaje_advertencia');
			errorDesc.removeClassName('mensaje_informacion');
			errorDesc.removeClassName('mensaje_error');
			Element.hide(errorDesc);
		}
		var obj = Validation.getMsgListObj();
		while (obj.childNodes.length>0)
			obj.removeChild(obj.childNodes[0]);
	},
	removeMsgById: function (id,vname){
		if (typeof(vname) == "undefined")
			vname = "";
		var obj = Validation.getMsgListObj();
		$A(obj.childNodes).any(function (item){
			if (item.id=="d_MsgList"+id+"-"+vname){
				obj.removeChild(item);
				Validation.updateErrorsList();
				return true;
			}
			return false;
		});
	},
	getErrorsCount: function(){
		var obj = Validation.getMsgListObj();
		return obj.childNodes.length;
	},
	updateErrorsList: function(){
		var errorDesc = Validation.getMsgPanelObj();
		if (Validation.getErrorsCount() > 1)
			errorDesc.addClassName('mensaje_noimg');
		else
			errorDesc.removeClassName('mensaje_noimg');
	},
	getMsgListObj: function(){
		return ($("d_MsgList") || $$(".d_MsgList")[0]);
	},
	existsMessage: function(msg){
		var msgs = $$(".d_MsgList li");
		var tDiv = document.createElement("div");
		tDiv.innerHTML=msg;
		var eMsg = tDiv.innerHTML;
		return msgs.any(function(item){return (item.innerHTML==eMsg);});
	},
	getMsgPanelObj: function(){
		return $$(".d_MsgPanel .desc")[0];
	}
});

Validation.add('IsEmpty', '', function(v) {
				return  ((v == null) || (v.length == 0)); // || /^\s+$/.test(v));
			});

Validation.add('IsSelEmpty', '', function(v, elm) {
					if (("undefined"!=typeof(elm))&&(null!=elm)){
						if ("SELECT"==elm.tagName.toUpperCase())
							return ((v == null) || (v.length == 0) || ("-1"==v));
						else if (("INPUT"==elm.tagName.toUpperCase())&&(("CHECKBOX"==elm.type.toUpperCase())))
							return !elm.checked;
					}
					return Validation.get('IsEmpty').test(v);
			});

/**
 * CODIGOS DE LOS CARACTERES PARA EXPRESIONES REGULARES
 * 
 * \x20 - [SPACE]
 * \xE1 - á
 * \xE9 - é
 * \xED - í
 * \xF3 - ó
 * \xFA - ú
 * \xF1 - ñ
 * \xD1 - Ñ
 * 
 */

Validation.addAllThese([
	['required', 'Existen campos vacíos que son obligatorios. Por favor, complete estos datos.', function(v) {
				return !Validation.get('IsEmpty').test(v);
			}],
	['validate-date-au', 'Existen campos escritos incorrectamente. Por favor, rectifique estos datos.', function(v) {
				if(Validation.get('IsEmpty').test(v)) return true;
				var regex = /^(\d{2})\/(\d{2})\/(\d{4})$/;
				if(!regex.test(v)) return false;
				var d = new Date(v.replace(regex, '$2/$1/$3'));
				return ( parseInt(RegExp.$2, 10) == (1+d.getMonth()) ) && 
							(parseInt(RegExp.$1, 10) == d.getDate()) && 
							(parseInt(RegExp.$3, 10) == d.getFullYear() );
			}],
	['validate-currency-dollar', 'Existen campos escritos incorrectamente. Por favor, rectifique estos datos.', function(v) {
				// [$]1[##][,###]+[.##]
				// [$]1###+[.##]
				// [$]0.##
				// [$].##
				return Validation.get('IsEmpty').test(v) ||  /^\$?\-?([1-9]{1}[0-9]{0,2}(\,[0-9]{3})*(\.[0-9]{0,2})?|[1-9]{1}\d*(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|(\.[0-9]{1,2})?)$/.test(v)
			}],
	['validate-selection', 'Existen campos vacíos que son obligatorios. Por favor, complete estos datos.', function(v,elm){
				return elm.options ? elm.selectedIndex > 0 : !Validation.get('IsEmpty').test(v);
			}],
	['validate-one-required', 'Existen campos vacíos que son obligatorios. Por favor, complete estos datos.', function (v,elm) {
				var p = elm.parentNode;
				var options = p.getElementsByTagName('INPUT');
				return $A(options).any(function(elm) {
					return $F(elm);
				});
			}]
]);

if("function"==typeof(fileLoaded))
	fileLoaded("js/validation.js");