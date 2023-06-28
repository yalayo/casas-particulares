var ToolTipText = Class.create();
Object.extend(ToolTipText, {
	_initialized:false,
	_ie4:document.all,
	_ns6:document.getElementById&&!document.all,
	assocObj:null,
	options:{
		tipwidth:'', //default tooltip width
		tipbgcolor:'',  //tooltip bgcolor
		disappeardelay:3000, //tooltip disappear speed onMouseout (in miliseconds)
		vertical_offset:"-18px", //horizontal offset of tooltip from anchor link
		horizontal_offset:"-2px" //horizontal offset of tooltip from anchor link
	},
	init: function(){
		if (ToolTipText._initialized) return;
		if (ToolTipText._ie4||ToolTipText._ns6){
			new Insertion.Top(document.body,'<div id="fixedtipdiv" style="visibility:hidden;width:'+ToolTipText.options.tipwidth+';background-color:'+ToolTipText.options.tipbgcolor+'" onMouseout="ToolTipText.hide()"></div>');
			Event.observe("fixedtipdiv","click",function(e){try{CICPC.ELEMENT.triggerClick(ToolTipText.assocObj);}catch(ex){}},false);
			ToolTipText._initialized=true;
		}
	},
	show: function (menucontents, obj, e, tipwidth){
		ToolTipText.init();
		ToolTipText.assocObj=obj;
		if (window.event)
			event.cancelBubble=true;
		else if (e.stopPropagation) e.stopPropagation()
			ToolTipText.clearhide();
		dropmenuobj=document.getElementById? document.getElementById("fixedtipdiv") : fixedtipdiv;
		dropmenuobj.innerHTML=menucontents;
		if (ToolTipText._ie4||ToolTipText._ns6){
			ToolTipText.showhide(dropmenuobj.style, e, "visible", "hidden", tipwidth);
			dropmenuobj.x=ToolTipText.getposOffset(obj, "left");
			if (dropmenuobj.x>12){
				dropmenuobj.style.paddingLeft=(dropmenuobj.x -11)+"px";
				dropmenuobj.x=12;
			}
			dropmenuobj.y=ToolTipText.getposOffset(obj, "top");
			dropmenuobj.style.left=dropmenuobj.x-ToolTipText.clearbrowseredge(obj, "rightedge")+"px";
			dropmenuobj.style.top=dropmenuobj.y-ToolTipText.clearbrowseredge(obj, "bottomedge")+obj.offsetHeight+"px";
		}
		ToolTipText.delayhide();
	},
	hide: function(){
		if (typeof dropmenuobj!="undefined"){
			if (ToolTipText._ie4||ToolTipText._ns6)
				dropmenuobj.style.visibility="hidden"
			ToolTipText.assocObj=null;
		}
	},
	delayhide: function (){
		if (ToolTipText._ie4||ToolTipText._ns6)
			ToolTipText.delayhideTimer=setTimeout("ToolTipText.hide()",ToolTipText.options.disappeardelay)
	},
	clearhide: function (){
		if (typeof ToolTipText.delayhideTimer!="undefined")
			clearTimeout(ToolTipText.delayhideTimer)
	},
	getposOffset: function (what, offsettype){
		var totaloffset=(offsettype=="left")? what.offsetLeft : what.offsetTop;
		var parentEl=what.offsetParent;
		while (parentEl!=null){
			totaloffset=(offsettype=="left")? totaloffset+parentEl.offsetLeft : totaloffset+parentEl.offsetTop;
			parentEl=parentEl.offsetParent;
		}
		return totaloffset;
	},
	showhide: function (obj, e, visible, hidden, tipwidth){
		if (ToolTipText._ie4||ToolTipText._ns6)
			dropmenuobj.style.left=dropmenuobj.style.top=-500
		if (ToolTipText.options.tipwidth!=""){
			dropmenuobj.widthobj=dropmenuobj.style;
			dropmenuobj.widthobj.width=ToolTipText.options.tipwidth;
		}
		if (e.type=="click" && obj.visibility==hidden || e.type=="mouseover")
			obj.visibility=visible;
		else if (e.type=="click")
			obj.visibility=hidden;
	},
	iecompattest: function (){
		return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body;
	},
	clearbrowseredge: function (obj, whichedge){
		var edgeoffset=(whichedge=="rightedge")? parseInt(ToolTipText.options.horizontal_offset)*-1 : parseInt(ToolTipText.options.vertical_offset)*-1;
		if (whichedge=="rightedge"){
			var windowedge=ToolTipText._ie4 && !window.opera? ToolTipText.iecompattest().scrollLeft+ToolTipText.iecompattest().clientWidth-15 : window.pageXOffset+window.innerWidth-15;
			dropmenuobj.contentmeasure=dropmenuobj.offsetWidth;
			if (windowedge-dropmenuobj.x < dropmenuobj.contentmeasure)
				edgeoffset=dropmenuobj.contentmeasure-obj.offsetWidth;
		}
		else{
			var windowedge=ToolTipText._ie4 && !window.opera? ToolTipText.iecompattest().scrollTop+ToolTipText.iecompattest().clientHeight-15 : window.pageYOffset+window.innerHeight-18;
			dropmenuobj.contentmeasure=dropmenuobj.offsetHeight;
			if (windowedge-dropmenuobj.y < dropmenuobj.contentmeasure)
				edgeoffset=dropmenuobj.contentmeasure+obj.offsetHeight;
		}
		return edgeoffset;
	}
});
