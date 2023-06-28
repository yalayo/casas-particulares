/**
 * RUZEE.Ellisis 0.1
 * (c) 2007 Steffen Rusitschka
 *
 * RUZEE.Ellipsis is freely distributable under the terms of an MIT-style license.
 * For details, see http://www.ruzee.com/
 */

Object.extend(Element, {
	doEllipsis: function (e){
		if (e.constructor == Array){
			e.each(Element.doEllipsis);
			return;
		}
		var w = e.getWidth() - 10000;
		var t = e.innerHTML;
		if((w==-10000)||(t=="")||(t.substr(0,4)=="<IMG")||(t.indexOf("...")>0))return;
		e.setAttribute("tooltip",t);
		e.innerHTML = "<span>" + t + "</span>";
		var s = e.down();
		var tt=false;
		while (t.length > 0 && s.getWidth() >= w) {
			t = t.substr(0, t.length - 1);
			s.innerHTML = t + "...";
			tt=true;
		}
		if (tt)
			Event.observe(e,"mouseover",function(e){
				var topGroup=this.ancestors().first().hasClassName("rich-pmenu-group-self-label");
				ToolTipText.show(this.getAttribute("tooltip"), this, e, '');
				if(ToolTipText._initialized)
					[$("fixedtipdiv")].invoke(((topGroup)?"addClassName":"removeClassName"),"topgroup");
			}.bindAsEventListener(e),false);
		e.removeClassName("ellipsis");
	}
});

function doUpdateEllipsis(selec){
	var selStr=".ellipsis";
	if(typeof(selec)!="undefined"){
		selStr=selec+" "+selStr;
	}
	var elms=$$(selStr);
	if (elms.length==0)
		return;
	Element.doEllipsis(elms);
	//setTimeout("doUpdateEllipsis()",10);
}

function updateEllipsis(elm){
	if("undefined"==typeof(elm))
		setTimeout("doUpdateEllipsis()",10);
	else if (!elm.getAttribute("_ellipsed")){
		elm.setAttribute("_ellipsed",true);
		setTimeout("doUpdateEllipsis('#"+elm.id+"')",10);
	}
}
function updateEllipsisTd(){
	setTimeout("doUpdateEllipsis('td')",10);
}

(function() {
  document.write('<style type="text/css">' +
    '.ellipsis { margin-right:-10000px; }</style>');
  Event.observe(window, "load", function() {
    updateEllipsis();
  });
})();

if("function"==typeof(fileLoaded))
	fileLoaded("js/ellipsis.js");