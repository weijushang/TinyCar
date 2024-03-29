/**
 * Isotope v1.5.25
 * An exquisite jQuery plugin for magical layouts
 * http://isotope.metafizzy.co
 *
 * Commercial use requires one-time purchase of a commercial license
 * http://isotope.metafizzy.co/docs/license.html
 *
 * Non-commercial use is licensed under the MIT License
 *
 * Copyright 2013 Metafizzy
 */
(function(a,b,c){"use strict";var d=a.document,e=a.Modernizr,f=function(a){return a.charAt(0).toUpperCase()+a.slice(1)},g="Moz Webkit O Ms".split(" "),h=function(a){var b=d.documentElement.style,c;if(typeof b[a]=="string")return a;a=f(a);for(var e=0,h=g.length;e<h;e++){c=g[e]+a;if(typeof b[c]=="string")return c}},i=h("transform"),j=h("transitionProperty"),k={csstransforms:function(){return!!i},csstransforms3d:function(){var a=!!h("perspective");if(a){var c=" -o- -moz- -ms- -webkit- -khtml- ".split(" "),d="@media ("+c.join("transform-3d),(")+"modernizr)",e=b("<style>"+d+"{#modernizr{height:3px}}"+"</style>").appendTo("head"),f=b('<div id="modernizr" />').appendTo("html");a=f.height()===3,f.remove(),e.remove()}return a},csstransitions:function(){return!!j}},l;if(e)for(l in k)e.hasOwnProperty(l)||e.addTest(l,k[l]);else{e=a.Modernizr={_version:"1.6ish: miniModernizr for Isotope"};var m=" ",n;for(l in k)n=k[l](),e[l]=n,m+=" "+(n?"":"no-")+l;b("html").addClass(m)}if(e.csstransforms){var o=e.csstransforms3d?{translate:function(a){return"translate3d("+a[0]+"px, "+a[1]+"px, 0) "},scale:function(a){return"scale3d("+a+", "+a+", 1) "}}:{translate:function(a){return"translate("+a[0]+"px, "+a[1]+"px) "},scale:function(a){return"scale("+a+") "}},p=function(a,c,d){var e=b.data(a,"isoTransform")||{},f={},g,h={},j;f[c]=d,b.extend(e,f);for(g in e)j=e[g],h[g]=o[g](j);var k=h.translate||"",l=h.scale||"",m=k+l;b.data(a,"isoTransform",e),a.style[i]=m};b.cssNumber.scale=!0,b.cssHooks.scale={set:function(a,b){p(a,"scale",b)},get:function(a,c){var d=b.data(a,"isoTransform");return d&&d.scale?d.scale:1}},b.fx.step.scale=function(a){b.cssHooks.scale.set(a.elem,a.now+a.unit)},b.cssNumber.translate=!0,b.cssHooks.translate={set:function(a,b){p(a,"translate",b)},get:function(a,c){var d=b.data(a,"isoTransform");return d&&d.translate?d.translate:[0,0]}}}var q,r;e.csstransitions&&(q={WebkitTransitionProperty:"webkitTransitionEnd",MozTransitionProperty:"transitionend",OTransitionProperty:"oTransitionEnd otransitionend",transitionProperty:"transitionend"}[j],r=h("transitionDuration"));var s=b.event,t=b.event.handle?"handle":"dispatch",u;s.special.smartresize={setup:function(){b(this).bind("resize",s.special.smartresize.handler)},teardown:function(){b(this).unbind("resize",s.special.smartresize.handler)},handler:function(a,b){var c=this,d=arguments;a.type="smartresize",u&&clearTimeout(u),u=setTimeout(function(){s[t].apply(c,d)},b==="execAsap"?0:100)}},b.fn.smartresize=function(a){return a?this.bind("smartresize",a):this.trigger("smartresize",["execAsap"])},b.Isotope=function(a,c,d){this.element=b(c),this._create(a),this._init(d)};var v=["width","height"],w=b(a);b.Isotope.settings={resizable:!0,layoutMode:"masonry",containerClass:"isotope",itemClass:"isotope-item",hiddenClass:"isotope-hidden",hiddenStyle:{opacity:0,scale:.001},visibleStyle:{opacity:1,scale:1},containerStyle:{position:"relative",overflow:"hidden"},animationEngine:"best-available",animationOptions:{queue:!1,duration:800},sortBy:"original-order",sortAscending:!0,resizesContainer:!0,transformsEnabled:!0,itemPositionDataEnabled:!1},b.Isotope.prototype={_create:function(a){this.options=b.extend({},b.Isotope.settings,a),this.styleQueue=[],this.elemCount=0;var c=this.element[0].style;this.originalStyle={};var d=v.slice(0);for(var e in this.options.containerStyle)d.push(e);for(var f=0,g=d.length;f<g;f++)e=d[f],this.originalStyle[e]=c[e]||"";this.element.css(this.options.containerStyle),this._updateAnimationEngine(),this._updateUsingTransforms();var h={"original-order":function(a,b){return b.elemCount++,b.elemCount},random:function(){return Math.random()}};this.options.getSortData=b.extend(this.options.getSortData,h),this.reloadItems(),this.offset={left:parseInt(this.element.css("padding-left")||0,10),top:parseInt(this.element.css("padding-top")||0,10)};var i=this;setTimeout(function(){i.element.addClass(i.options.containerClass)},0),this.options.resizable&&w.bind("smartresize.isotope",function(){i.resize()}),this.element.delegate("."+this.options.hiddenClass,"click",function(){return!1})},_getAtoms:function(a){var b=this.options.itemSelector,c=b?a.filter(b).add(a.find(b)):a,d={position:"absolute"};return c=c.filter(function(a,b){return b.nodeType===1}),this.usingTransforms&&(d.left=0,d.top=0),c.css(d).addClass(this.options.itemClass),this.updateSortData(c,!0),c},_init:function(a){this.$filteredAtoms=this._filter(this.$allAtoms),this._sort(),this.reLayout(a)},option:function(a){if(b.isPlainObject(a)){this.options=b.extend(!0,this.options,a);var c;for(var d in a)c="_update"+f(d),this[c]&&this[c]()}},_updateAnimationEngine:function(){var a=this.options.animationEngine.toLowerCase().replace(/[ _\-]/g,""),b;switch(a){case"css":case"none":b=!1;break;case"jquery":b=!0;break;default:b=!e.csstransitions}this.isUsingJQueryAnimation=b,this._updateUsingTransforms()},_updateTransformsEnabled:function(){this._updateUsingTransforms()},_updateUsingTransforms:function(){var a=this.usingTransforms=this.options.transformsEnabled&&e.csstransforms&&e.csstransitions&&!this.isUsingJQueryAnimation;a||(delete this.options.hiddenStyle.scale,delete this.options.visibleStyle.scale),this.getPositionStyles=a?this._translate:this._positionAbs},_filter:function(a){var b=this.options.filter===""?"*":this.options.filter;if(!b)return a;var c=this.options.hiddenClass,d="."+c,e=a.filter(d),f=e;if(b!=="*"){f=e.filter(b);var g=a.not(d).not(b).addClass(c);this.styleQueue.push({$el:g,style:this.options.hiddenStyle})}return this.styleQueue.push({$el:f,style:this.options.visibleStyle}),f.removeClass(c),a.filter(b)},updateSortData:function(a,c){var d=this,e=this.options.getSortData,f,g;a.each(function(){f=b(this),g={};for(var a in e)!c&&a==="original-order"?g[a]=b.data(this,"isotope-sort-data")[a]:g[a]=e[a](f,d);b.data(this,"isotope-sort-data",g)})},_sort:function(){var a=this.options.sortBy,b=this._getSorter,c=this.options.sortAscending?1:-1,d=function(d,e){var f=b(d,a),g=b(e,a);return f===g&&a!=="original-order"&&(f=b(d,"original-order"),g=b(e,"original-order")),(f>g?1:f<g?-1:0)*c};this.$filteredAtoms.sort(d)},_getSorter:function(a,c){return b.data(a,"isotope-sort-data")[c]},_translate:function(a,b){return{translate:[a,b]}},_positionAbs:function(a,b){return{left:a,top:b}},_pushPosition:function(a,b,c){b=Math.round(b+this.offset.left),c=Math.round(c+this.offset.top);var d=this.getPositionStyles(b,c);this.styleQueue.push({$el:a,style:d}),this.options.itemPositionDataEnabled&&a.data("isotope-item-position",{x:b,y:c})},layout:function(a,b){var c=this.options.layoutMode;this["_"+c+"Layout"](a);if(this.options.resizesContainer){var d=this["_"+c+"GetContainerSize"]();this.styleQueue.push({$el:this.element,style:d})}this._processStyleQueue(a,b),this.isLaidOut=!0},_processStyleQueue:function(a,c){var d=this.isLaidOut?this.isUsingJQueryAnimation?"animate":"css":"css",f=this.options.animationOptions,g=this.options.onLayout,h,i,j,k;i=function(a,b){b.$el[d](b.style,f)};if(this._isInserting&&this.isUsingJQueryAnimation)i=function(a,b){h=b.$el.hasClass("no-transition")?"css":d,b.$el[h](b.style,f)};else if(c||g||f.complete){var l=!1,m=[c,g,f.complete],n=this;j=!0,k=function(){if(l)return;var b;for(var c=0,d=m.length;c<d;c++)b=m[c],typeof b=="function"&&b.call(n.element,a,n);l=!0};if(this.isUsingJQueryAnimation&&d==="animate")f.complete=k,j=!1;else if(e.csstransitions){var o=0,p=this.styleQueue[0],s=p&&p.$el,t;while(!s||!s.length){t=this.styleQueue[o++];if(!t)return;s=t.$el}var u=parseFloat(getComputedStyle(s[0])[r]);u>0&&(i=function(a,b){b.$el[d](b.style,f).one(q,k)},j=!1)}}b.each(this.styleQueue,i),j&&k(),this.styleQueue=[]},resize:function(){this["_"+this.options.layoutMode+"ResizeChanged"]()&&this.reLayout()},reLayout:function(a){this["_"+this.options.layoutMode+"Reset"](),this.layout(this.$filteredAtoms,a)},addItems:function(a,b){var c=this._getAtoms(a);this.$allAtoms=this.$allAtoms.add(c),b&&b(c)},insert:function(a,b){this.element.append(a);var c=this;this.addItems(a,function(a){var d=c._filter(a);c._addHideAppended(d),c._sort(),c.reLayout(),c._revealAppended(d,b)})},appended:function(a,b){var c=this;this.addItems(a,function(a){c._addHideAppended(a),c.layout(a),c._revealAppended(a,b)})},_addHideAppended:function(a){this.$filteredAtoms=this.$filteredAtoms.add(a),a.addClass("no-transition"),this._isInserting=!0,this.styleQueue.push({$el:a,style:this.options.hiddenStyle})},_revealAppended:function(a,b){var c=this;setTimeout(function(){a.removeClass("no-transition"),c.styleQueue.push({$el:a,style:c.options.visibleStyle}),c._isInserting=!1,c._processStyleQueue(a,b)},10)},reloadItems:function(){this.$allAtoms=this._getAtoms(this.element.children())},remove:function(a,b){this.$allAtoms=this.$allAtoms.not(a),this.$filteredAtoms=this.$filteredAtoms.not(a);var c=this,d=function(){a.remove(),b&&b.call(c.element)};a.filter(":not(."+this.options.hiddenClass+")").length?(this.styleQueue.push({$el:a,style:this.options.hiddenStyle}),this._sort(),this.reLayout(d)):d()},shuffle:function(a){this.updateSortData(this.$allAtoms),this.options.sortBy="random",this._sort(),this.reLayout(a)},destroy:function(){var a=this.usingTransforms,b=this.options;this.$allAtoms.removeClass(b.hiddenClass+" "+b.itemClass).each(function(){var b=this.style;b.position="",b.top="",b.left="",b.opacity="",a&&(b[i]="")});var c=this.element[0].style;for(var d in this.originalStyle)c[d]=this.originalStyle[d];this.element.unbind(".isotope").undelegate("."+b.hiddenClass,"click").removeClass(b.containerClass).removeData("isotope"),w.unbind(".isotope")},_getSegments:function(a){var b=this.options.layoutMode,c=a?"rowHeight":"columnWidth",d=a?"height":"width",e=a?"rows":"cols",g=this.element[d](),h,i=this.options[b]&&this.options[b][c]||this.$filteredAtoms["outer"+f(d)](!0)||g;h=Math.floor(g/i),h=Math.max(h,1),this[b][e]=h,this[b][c]=i},_checkIfSegmentsChanged:function(a){var b=this.options.layoutMode,c=a?"rows":"cols",d=this[b][c];return this._getSegments(a),this[b][c]!==d},_masonryReset:function(){this.masonry={},this._getSegments();var a=this.masonry.cols;this.masonry.colYs=[];while(a--)this.masonry.colYs.push(0)},_masonryLayout:function(a){var c=this,d=c.masonry;a.each(function(){var a=b(this),e=Math.ceil(a.outerWidth(!0)/d.columnWidth);e=Math.min(e,d.cols);if(e===1)c._masonryPlaceBrick(a,d.colYs);else{var f=d.cols+1-e,g=[],h,i;for(i=0;i<f;i++)h=d.colYs.slice(i,i+e),g[i]=Math.max.apply(Math,h);c._masonryPlaceBrick(a,g)}})},_masonryPlaceBrick:function(a,b){var c=Math.min.apply(Math,b),d=0;for(var e=0,f=b.length;e<f;e++)if(b[e]===c){d=e;break}var g=this.masonry.columnWidth*d,h=c;this._pushPosition(a,g,h);var i=c+a.outerHeight(!0),j=this.masonry.cols+1-f;for(e=0;e<j;e++)this.masonry.colYs[d+e]=i},_masonryGetContainerSize:function(){var a=Math.max.apply(Math,this.masonry.colYs);return{height:a}},_masonryResizeChanged:function(){return this._checkIfSegmentsChanged()},_fitRowsReset:function(){this.fitRows={x:0,y:0,height:0}},_fitRowsLayout:function(a){var c=this,d=this.element.width(),e=this.fitRows;a.each(function(){var a=b(this),f=a.outerWidth(!0),g=a.outerHeight(!0);e.x!==0&&f+e.x>d&&(e.x=0,e.y=e.height),c._pushPosition(a,e.x,e.y),e.height=Math.max(e.y+g,e.height),e.x+=f})},_fitRowsGetContainerSize:function(){return{height:this.fitRows.height}},_fitRowsResizeChanged:function(){return!0},_cellsByRowReset:function(){this.cellsByRow={index:0},this._getSegments(),this._getSegments(!0)},_cellsByRowLayout:function(a){var c=this,d=this.cellsByRow;a.each(function(){var a=b(this),e=d.index%d.cols,f=Math.floor(d.index/d.cols),g=(e+.5)*d.columnWidth-a.outerWidth(!0)/2,h=(f+.5)*d.rowHeight-a.outerHeight(!0)/2;c._pushPosition(a,g,h),d.index++})},_cellsByRowGetContainerSize:function(){return{height:Math.ceil(this.$filteredAtoms.length/this.cellsByRow.cols)*this.cellsByRow.rowHeight+this.offset.top}},_cellsByRowResizeChanged:function(){return this._checkIfSegmentsChanged()},_straightDownReset:function(){this.straightDown={y:0}},_straightDownLayout:function(a){var c=this;a.each(function(a){var d=b(this);c._pushPosition(d,0,c.straightDown.y),c.straightDown.y+=d.outerHeight(!0)})},_straightDownGetContainerSize:function(){return{height:this.straightDown.y}},_straightDownResizeChanged:function(){return!0},_masonryHorizontalReset:function(){this.masonryHorizontal={},this._getSegments(!0);var a=this.masonryHorizontal.rows;this.masonryHorizontal.rowXs=[];while(a--)this.masonryHorizontal.rowXs.push(0)},_masonryHorizontalLayout:function(a){var c=this,d=c.masonryHorizontal;a.each(function(){var a=b(this),e=Math.ceil(a.outerHeight(!0)/d.rowHeight);e=Math.min(e,d.rows);if(e===1)c._masonryHorizontalPlaceBrick(a,d.rowXs);else{var f=d.rows+1-e,g=[],h,i;for(i=0;i<f;i++)h=d.rowXs.slice(i,i+e),g[i]=Math.max.apply(Math,h);c._masonryHorizontalPlaceBrick(a,g)}})},_masonryHorizontalPlaceBrick:function(a,b){var c=Math.min.apply(Math,b),d=0;for(var e=0,f=b.length;e<f;e++)if(b[e]===c){d=e;break}var g=c,h=this.masonryHorizontal.rowHeight*d;this._pushPosition(a,g,h);var i=c+a.outerWidth(!0),j=this.masonryHorizontal.rows+1-f;for(e=0;e<j;e++)this.masonryHorizontal.rowXs[d+e]=i},_masonryHorizontalGetContainerSize:function(){var a=Math.max.apply(Math,this.masonryHorizontal.rowXs);return{width:a}},_masonryHorizontalResizeChanged:function(){return this._checkIfSegmentsChanged(!0)},_fitColumnsReset:function(){this.fitColumns={x:0,y:0,width:0}},_fitColumnsLayout:function(a){var c=this,d=this.element.height(),e=this.fitColumns;a.each(function(){var a=b(this),f=a.outerWidth(!0),g=a.outerHeight(!0);e.y!==0&&g+e.y>d&&(e.x=e.width,e.y=0),c._pushPosition(a,e.x,e.y),e.width=Math.max(e.x+f,e.width),e.y+=g})},_fitColumnsGetContainerSize:function(){return{width:this.fitColumns.width}},_fitColumnsResizeChanged:function(){return!0},_cellsByColumnReset:function(){this.cellsByColumn={index:0},this._getSegments(),this._getSegments(!0)},_cellsByColumnLayout:function(a){var c=this,d=this.cellsByColumn;a.each(function(){var a=b(this),e=Math.floor(d.index/d.rows),f=d.index%d.rows,g=(e+.5)*d.columnWidth-a.outerWidth(!0)/2,h=(f+.5)*d.rowHeight-a.outerHeight(!0)/2;c._pushPosition(a,g,h),d.index++})},_cellsByColumnGetContainerSize:function(){return{width:Math.ceil(this.$filteredAtoms.length/this.cellsByColumn.rows)*this.cellsByColumn.columnWidth}},_cellsByColumnResizeChanged:function(){return this._checkIfSegmentsChanged(!0)},_straightAcrossReset:function(){this.straightAcross={x:0}},_straightAcrossLayout:function(a){var c=this;a.each(function(a){var d=b(this);c._pushPosition(d,c.straightAcross.x,0),c.straightAcross.x+=d.outerWidth(!0)})},_straightAcrossGetContainerSize:function(){return{width:this.straightAcross.x}},_straightAcrossResizeChanged:function(){return!0}},b.fn.imagesLoaded=function(a){function h(){a.call(c,d)}function i(a){var c=a.target;c.src!==f&&b.inArray(c,g)===-1&&(g.push(c),--e<=0&&(setTimeout(h),d.unbind(".imagesLoaded",i)))}var c=this,d=c.find("img").add(c.filter("img")),e=d.length,f="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==",g=[];return e||h(),d.bind("load.imagesLoaded error.imagesLoaded",i).each(function(){var a=this.src;this.src=f,this.src=a}),c};var x=function(b){a.console&&a.console.error(b)};b.fn.isotope=function(a,c){if(typeof a=="string"){var d=Array.prototype.slice.call(arguments,1);this.each(function(){var c=b.data(this,"isotope");if(!c){x("cannot call methods on isotope prior to initialization; attempted to call method '"+a+"'");return}if(!b.isFunction(c[a])||a.charAt(0)==="_"){x("no such method '"+a+"' for isotope instance");return}c[a].apply(c,d)})}else this.each(function(){var d=b.data(this,"isotope");d?(d.option(a),d._init(c)):b.data(this,"isotope",new b.Isotope(a,this,c))});return this}})(window,jQuery);

(function(e,t,n){"use strict";e.HoverDir=function(t,n){this.$el=e(n);this._init(t)};e.HoverDir.defaults={speed:300,easing:"ease",hoverDelay:0,inverse:false};e.HoverDir.prototype={_init:function(t){this.options=e.extend(true,{},e.HoverDir.defaults,t);this.transitionProp="all "+this.options.speed+"ms "+this.options.easing;this.support=Modernizr.csstransitions;this._loadEvents()},_loadEvents:function(){var t=this;this.$el.on("mouseenter.hoverdir, mouseleave.hoverdir",function(n){var r=e(this),i=r.find("div"),s=t._getDir(r,{x:n.pageX,y:n.pageY}),o=t._getStyle(s);if(n.type==="mouseenter"){i.hide().css(o.from);clearTimeout(t.tmhover);t.tmhover=setTimeout(function(){i.show(0,function(){var n=e(this);if(t.support){n.css("transition",t.transitionProp)}t._applyAnimation(n,o.to,t.options.speed)})},t.options.hoverDelay)}else{if(t.support){i.css("transition",t.transitionProp)}clearTimeout(t.tmhover);t._applyAnimation(i,o.from,t.options.speed)}})},_getDir:function(e,t){var n=e.width(),r=e.height(),i=(t.x-e.offset().left-n/2)*(n>r?r/n:1),s=(t.y-e.offset().top-r/2)*(r>n?n/r:1),o=Math.round((Math.atan2(s,i)*(180/Math.PI)+180)/90+3)%4;return o},_getStyle:function(e){var t,n,r={left:"0px",top:"-100%"},i={left:"0px",top:"100%"},s={left:"-100%",top:"0px"},o={left:"100%",top:"0px"},u={top:"0px"},a={left:"0px"};switch(e){case 0:t=!this.options.inverse?r:i;n=u;break;case 1:t=!this.options.inverse?o:s;n=a;break;case 2:t=!this.options.inverse?i:r;n=u;break;case 3:t=!this.options.inverse?s:o;n=a;break}return{from:t,to:n}},_applyAnimation:function(t,n,r){e.fn.applyStyle=this.support?e.fn.css:e.fn.animate;t.stop().applyStyle(n,e.extend(true,[],{duration:r+"ms"}))}};var r=function(e){if(t.console){t.console.error(e)}};e.fn.hoverdir=function(t){var n=e.data(this,"hoverdir");if(typeof t==="string"){var i=Array.prototype.slice.call(arguments,1);this.each(function(){if(!n){r("cannot call methods on hoverdir prior to initialization; "+"attempted to call method '"+t+"'");return}if(!e.isFunction(n[t])||t.charAt(0)==="_"){r("no such method '"+t+"' for hoverdir instance");return}n[t].apply(n,i)})}else{this.each(function(){if(n){n._init()}else{n=e.data(this,"hoverdir",new e.HoverDir(t,this))}})}return n}})(jQuery,window);

/*! sly 1.0.2 - 4th Aug 2013 | https://github.com/Darsain/sly */
(function(h,w,sa){function ma(f,aa,l){var ta,u,ua,x,L,w,S,na;function ba(){var a=0;e.old=h.extend({},e);s=F?0:B[c.horizontal?"width":"height"]();M=H[c.horizontal?"width":"height"]();n=F?f:q[c.horizontal?"outerWidth":"outerHeight"]();C.length=0;e.start=0;e.end=Math.max(n-s,0);r={};if(D){var j=k.length;y=q.children(c.itemSelector);k.length=0;var b=ca(q,c.horizontal?"paddingLeft":"paddingTop"),Va=ca(q,c.horizontal?"paddingRight":"paddingBottom"),aa=ca(y,c.horizontal?"marginLeft":"marginTop"),a=ca(y.slice(-1),
c.horizontal?"marginRight":"marginBottom"),va=0,m="none"!==y.css("float"),a=aa?0:a;n=0;y.each(function(a,j){var d=h(j),e=d[c.horizontal?"outerWidth":"outerHeight"](!0),f=ca(d,c.horizontal?"marginLeft":"marginTop"),d=ca(d,c.horizontal?"marginRight":"marginBottom"),g={el:j,size:e,half:e/2,start:n-(!a||c.horizontal?0:f),center:n-Math.round(s/2-e/2),end:n-s+e-(aa?0:d)};a||(va=-(I?Math.round(s/2-e/2):0)+b,n+=b);n+=e;!c.horizontal&&!m&&d&&(f&&0<a)&&(n-=Math.min(f,d));a===y.length-1&&(n+=Va);k.push(g)});
q[0].style[c.horizontal?"width":"height"]=n+"px";n-=a;e.start=va;e.end=I?k.length?k[k.length-1].center:va:Math.max(n-s,0);if(g.activeItem>=k.length||0===j&&0<k.length)oa(0<k.length?k.length-1:0)}e.center=Math.round(e.end/2+e.start/2);h.extend(g,wa(void 0));z.length&&0<M&&(c.dynamicHandle?(N=I?k.length?M*s/(s+k[k.length-1].center-k[0].center):M:M*s/n,N=A(Math.round(N),c.minHandleSize,M),z[0].style[c.horizontal?"width":"height"]=N+"px"):N=z[c.horizontal?"outerWidth":"outerHeight"](),p.end=M-N,T||la());
if(!F&&0<s){var l=e.start,j="";if(D)h.each(k,function(a,j){if(I||j.start+j.size>l)l=j[I?"center":"start"],C.push(l),l+=s});else for(;l-s<e.end;)C.push(l),l+=s;if(U[0]){for(a=0;a<C.length;a++)j+=c.pageBuilder.call(d,a);pa=U.html(j).children()}}J(A(e.dest,e.start,e.end));g.slideeSize=n;g.frameSize=s;g.sbSize=M;g.handleSize=N;v("load")}function J(a,j,ha){if(D&&b.released&&!ha){ha=wa(a);var f=a>e.start&&a<e.end;O?(f&&(a=k[ha.centerItem].center),I&&c.activateMiddle&&oa(ha.centerItem)):f&&(a=k[ha.firstItem].start)}b.init&&
b.slidee&&c.elasticBounds?a>e.end?a=e.end+(a-e.end)/6:a<e.start&&(a=e.start+(a-e.start)/6):a=A(a,e.start,e.end);ta=+new Date;u=0;ua=e.cur;x=a;L=a-e.cur;w=b.tweese||b.init&&!b.slidee;S=!w&&(j||b.init&&b.slidee||!c.speed);b.tweese=0;a!==e.dest&&(e.dest=a,v("change"),T||$());b.released&&!d.isPaused&&d.resume();h.extend(g,wa(void 0));Da();pa[0]&&r.page!==g.activePage&&(r.page=g.activePage,pa.removeClass(c.activeClass).eq(g.activePage).addClass(c.activeClass),v("activePage",r.page))}function $(){T?(S?
e.cur=x:w?(na=x-e.cur,e.cur=0.1>Math.abs(na)?x:e.cur+na*(b.released?c.swingSpeed:c.syncSpeed)):(u=Math.min(+new Date-ta,c.speed),e.cur=ua+L*jQuery.easing[c.easing](u/c.speed,u,0,1,c.speed)),x===e.cur?(e.cur=x,b.tweese=T=0):T=ia($),v("move"),F||(G?q[0].style[G]=ja+(c.horizontal?"translateX":"translateY")+"("+-e.cur+"px)":q[0].style[c.horizontal?"left":"top"]=-Math.round(e.cur)+"px"),!T&&b.released&&v("moveEnd"),la()):(T=ia($),b.released&&v("moveStart"))}function la(){z.length&&(p.cur=e.start===e.end?
0:((b.init&&!b.slidee?e.dest:e.cur)-e.start)/(e.end-e.start)*p.end,p.cur=A(Math.round(p.cur),p.start,p.end),r.hPos!==p.cur&&(r.hPos=p.cur,G?z[0].style[G]=ja+(c.horizontal?"translateX":"translateY")+"("+p.cur+"px)":z[0].style[c.horizontal?"left":"top"]=p.cur+"px"))}function Ea(){(!t.speed||e.cur===(0<t.speed?e.end:e.start))&&d.stop();Fa=b.init?ia(Ea):0;t.now=+new Date;t.pos=e.cur+(t.now-t.lastTime)/1E3*t.speed;J(b.init?t.pos:Math.round(t.pos));!b.init&&e.cur===e.dest&&v("moveEnd");t.lastTime=t.now}
function xa(a,j,b){"boolean"===P(j)&&(b=j,j=sa);j===sa?J(e[a],b):O&&"center"!==a||(j=d.getPos(j))&&J(j[a],b,!O)}function qa(a){return"undefined"!==P(a)?Q(a)?0<=a&&a<k.length?a:-1:y.index(a):-1}function ya(a){return qa(Q(a)&&0>a?a+k.length:a)}function oa(a){a=qa(a);if(!D||0>a)return!1;r.active!==a&&(y.eq(g.activeItem).removeClass(c.activeClass),y.eq(a).addClass(c.activeClass),r.active=g.activeItem=a,Da(),v("active",a));return a}function wa(a){a=A(Q(a)?a:e.dest,e.start,e.end);var j={},b=I?0:s/2;if(!F)for(var c=
0,d=C.length;c<d;c++){if(a>=e.end||c===C.length-1){j.activePage=C.length-1;break}if(a<=C[c]+b){j.activePage=c;break}}if(D){for(var d=c=b=!1,f=0,g=k.length;f<g;f++)if(!1===b&&a<=k[f].start+k[f].half&&(b=f),!1===d&&a<=k[f].center+k[f].half&&(d=f),f===g-1||a<=k[f].end+k[f].half){c=f;break}j.firstItem=Q(b)?b:0;j.centerItem=Q(d)?d:j.firstItem;j.lastItem=Q(c)?c:j.centerItem}return j}function Da(){var a=e.dest<=e.start,j=e.dest>=e.end,d=a?1:j?2:3;r.slideePosState!==d&&(r.slideePosState=d,V.is("button,input")&&
V.prop("disabled",a),W.is("button,input")&&W.prop("disabled",j),V.add(da)[a?"addClass":"removeClass"](c.disabledClass),W.add(X)[j?"addClass":"removeClass"](c.disabledClass));r.fwdbwdState!==d&&b.released&&(r.fwdbwdState=d,da.is("button,input")&&da.prop("disabled",a),X.is("button,input")&&X.prop("disabled",j));D&&(a=0===g.activeItem,j=g.activeItem>=k.length-1,d=a?1:j?2:3,r.itemsButtonState!==d&&(r.itemsButtonState=d,Y.is("button,input")&&Y.prop("disabled",a),Z.is("button,input")&&Z.prop("disabled",
j),Y[a?"addClass":"removeClass"](c.disabledClass),Z[j?"addClass":"removeClass"](c.disabledClass)))}function Ga(a,b,c){a=ya(a);b=ya(b);if(-1<a&&-1<b&&a!==b&&(!c||b!==a-1)&&(c||b!==a+1)){y.eq(a)[c?"insertAfter":"insertBefore"](k[b].el);var d=a<b?a:c?b:b-1,e=a>b?a:c?b+1:b,f=a>b;a===g.activeItem?r.active=g.activeItem=c?f?b+1:b:f?b:b-1:g.activeItem>d&&g.activeItem<e&&(r.active=g.activeItem+=f?1:-1);ba()}}function Ha(a,b){for(var c=0,d=E[a].length;c<d;c++)if(E[a][c]===b)return c;return-1}function Ia(a){return Math.round(A(a,
p.start,p.end)/p.end*(e.end-e.start))+e.start}function Ba(){b.history[0]=b.history[1];b.history[1]=b.history[2];b.history[2]=b.history[3];b.history[3]=b.delta}function Ja(a){b.released=0;b.source=a;b.slidee="slidee"===a}function Ka(a){if(!b.init){var d="touchstart"===a.type,f=a.data.source,g="slidee"===f;if(!("handle"===f&&(!c.dragHandle||p.start===p.end)))if(!g||(d?c.touchDragging:c.mouseDragging&&2>a.which))d||K(a,1),Ja(f),b.$source=h(a.target),b.init=0,b.touch=d,b.pointer=d?a.originalEvent.touches[0]:
a,b.initX=b.pointer.pageX,b.initY=b.pointer.pageY,b.initPos=g?e.cur:p.cur,b.start=+new Date,b.time=0,b.path=0,b.pathToInit=g?d?50:10:0,b.history=[0,0,0,0],b.initLoc=b[c.horizontal?"initX":"initY"],b.deltaMin=g?-b.initLoc:-p.cur,b.deltaMax=g?document[c.horizontal?"width":"height"]-b.initLoc:p.end-p.cur,(g?q:z).addClass(c.draggedClass),ea.on(d?La:Ma,Na),g&&(Oa=setInterval(Ba,10))}}function Na(a){b.released="mouseup"===a.type||"touchend"===a.type;b.pointer=b.touch?a.originalEvent[b.released?"changedTouches":
"touches"][0]:a;b.pathX=b.pointer.pageX-b.initX;b.pathY=b.pointer.pageY-b.initY;b.pathTotal=Math.sqrt(Math.pow(b.pathX,2)+Math.pow(b.pathY,2));b.delta=A(c.horizontal?b.pathX:b.pathY,b.deltaMin,b.deltaMax);if(!b.init&&b.pathTotal>b.pathToInit){if(b.slidee){if(c.horizontal?Math.abs(b.pathX)<Math.abs(b.pathY):Math.abs(b.pathX)>Math.abs(b.pathY)){za();return}b.$source.on(fa,Pa)}b.init=1;d.pause(1);v("moveStart")}b.init?(b.released?(b.touch||K(a),za(),c.releaseSwing&&b.slidee&&(b.swing=300*((b.delta-b.history[0])/
40),b.delta+=b.swing,b.tweese=10<Math.abs(b.swing))):K(a),J(b.slidee?Math.round(b.initPos-b.delta):Ia(b.initPos+b.delta))):b.released&&za()}function za(){b.init=0;clearInterval(Oa);ea.off(b.touch?La:Ma,Na);(b.slidee?q:z).removeClass(c.draggedClass);d.resume(1);e.cur===e.dest&&v("moveEnd")}function Qa(){d.stop();ea.off("mouseup",Qa)}function ga(a){K(a);switch(this){case X[0]:case da[0]:d.moveBy(X.is(this)?c.moveBy:-c.moveBy);ea.on("mouseup",Qa);break;case Y[0]:d.prev();break;case Z[0]:d.next();break;
case V[0]:d.prevPage();break;case W[0]:d.nextPage()}}function Ca(a){if(c.scrollBy&&e.start!==e.end)if(K(a,1),a=A(-a.originalEvent.wheelDelta||a.originalEvent.detail||a.originalEvent.deltaY,-1,1),D)d[O?"toCenter":"toStart"](A((O?g.centerItem:g.firstItem)+c.scrollBy*a,0,k.length));else d.slideBy(c.scrollBy*a)}function Wa(a){c.clickBar&&a.target===H[0]&&(K(a),J(Ia((c.horizontal?a.pageX-H.offset().left:a.pageY-H.offset().top)-N/2)))}function Xa(a){if(c.keyboardNavBy)switch(a.which){case c.horizontal?
37:38:K(a);d["pages"===c.keyboardNavBy?"prevPage":"prev"]();break;case c.horizontal?39:40:K(a),d["pages"===c.keyboardNavBy?"nextPage":"next"]()}}function Ya(){this.parentNode===q[0]&&d.activate(this)}function Za(){this.parentNode===U[0]&&d.activatePage(pa.index(this))}function $a(a){if(c.pauseOnHover)d["mouseenter"===a.type?"pause":"resume"](2)}function v(a,b){if(E[a]){ra=0;for(Ra=E[a].length;ra<Ra;ra++)E[a][ra].call(d,a,b)}}var c=h.extend({},ma.defaults,aa),d=this,Aa=0,F=Q(f),B=h(f),q=B.children().eq(0),
s=0,n=0,e={start:0,center:0,end:0,cur:0,dest:0},H=h(c.scrollBar).eq(0),z=H.children().eq(0),M=0,N=0,p={start:0,end:0,cur:0},U=h(c.pagesBar),pa=0,C=[],y=0,k=[],g={firstItem:0,lastItem:0,centerItem:0,activeItem:-1,activePage:0};aa="basic"===c.itemNav;var I="forceCentered"===c.itemNav,O="centered"===c.itemNav||I,D=!F&&(aa||O||I),Sa=c.scrollSource?h(c.scrollSource):B,ab=c.dragSource?h(c.dragSource):B,X=h(c.forward),da=h(c.backward),Y=h(c.prev),Z=h(c.next),V=h(c.prevPage),W=h(c.nextPage),E={},r={};na=
S=w=L=x=ua=u=ta=void 0;var t={},b={released:1},T=0,Oa=0,R=0,Fa=0,ra,Ra;F||(f=B[0]);d.frame=f;d.slidee=q[0];d.pos=e;d.rel=g;d.items=k;d.pages=C;d.isPaused=0;d.options=c;d.reload=ba;d.getPos=function(a){if(D)return a=qa(a),-1!==a?k[a]:!1;var b=q.find(a).eq(0);return b[0]?(a=c.horizontal?b.offset().left-q.offset().left:b.offset().top-q.offset().top,b=b[c.horizontal?"outerWidth":"outerHeight"](),{start:a,center:a-s/2+b/2,end:a-s+b,size:b}):!1};d.moveBy=function(a){t.speed=a;if(!b.init&&t.speed&&e.cur!==
(0<t.speed?e.end:e.start))t.lastTime=+new Date,t.startPos=e.cur,Ja("button"),b.init=1,v("moveStart"),ka(Fa),Ea()};d.stop=function(){"button"===b.source&&(b.init=0,b.released=1)};d.prev=function(){d.activate(g.activeItem-1)};d.next=function(){d.activate(g.activeItem+1)};d.prevPage=function(){d.activatePage(g.activePage-1)};d.nextPage=function(){d.activatePage(g.activePage+1)};d.slideBy=function(a,b){J(e.dest+a,b)};d.slideTo=function(a,b){J(a,b)};d.toStart=function(a,b){xa("start",a,b)};d.toEnd=function(a,
b){xa("end",a,b)};d.toCenter=function(a,b){xa("center",a,b)};d.getIndex=qa;d.activate=function(a,e){var f=oa(a);c.smart&&!1!==f&&(O?d.toCenter(f,e):f>=g.lastItem?d.toStart(f,e):f<=g.firstItem?d.toEnd(f,e):b.released&&!d.isPaused&&d.resume())};d.activatePage=function(a,b){Q(a)&&J(C[A(a,0,C.length-1)],b)};d.resume=function(a){if(c.cycleBy&&c.cycleInterval&&!("items"===c.cycleBy&&!k[0]||a<d.isPaused))d.isPaused=0,R?R=clearTimeout(R):v("resume"),R=setTimeout(function(){v("cycle");switch(c.cycleBy){case "items":d.activate(g.activeItem>=
k.length-1?0:g.activeItem+1);break;case "pages":d.activatePage(g.activePage>=C.length-1?0:g.activePage+1)}},c.cycleInterval)};d.pause=function(a){a<d.isPaused||(d.isPaused=a||100,R&&(R=clearTimeout(R),v("pause")))};d.toggle=function(){d[R?"pause":"resume"]()};d.set=function(a,b){h.isPlainObject(a)?h.extend(c,a):c.hasOwnProperty(a)&&(c[a]=b)};d.add=function(a,b){var c=h(a);D?("undefined"===P(b)||!k[0]?c.appendTo(q):k.length&&c.insertBefore(k[b].el),b<=g.activeItem&&(r.active=g.activeItem+=c.length)):
q.append(c);ba()};d.remove=function(a){if(D){if(a=ya(a),-1<a){y.eq(a).remove();var b=a===g.activeItem&&!(I&&c.activateMiddle);if(a<g.activeItem||g.activeItem>=k.length-1)r.active=--g.activeItem;ba();b&&d.activate(g.activeItem)}}else h(a).remove(),ba()};d.moveAfter=function(a,b){Ga(a,b,1)};d.moveBefore=function(a,b){Ga(a,b)};d.on=function(a,b){if("object"===P(a))for(var c in a){if(a.hasOwnProperty(c))d.on(c,a[c])}else if("function"===P(b)){c=a.split(" ");for(var e=0,f=c.length;e<f;e++)E[c[e]]=E[c[e]]||
[],-1===Ha(c[e],b)&&E[c[e]].push(b)}else if("array"===P(b)){c=0;for(e=b.length;c<e;c++)d.on(a,b[c])}};d.off=function(a,b){if(b instanceof Array)for(var c=0,e=b.length;c<e;c++)d.off(a,b[c]);else for(var c=a.split(" "),e=0,f=c.length;e<f;e++)if(E[c[e]]=E[c[e]]||[],"undefined"===P(b))E[c[e]].length=0;else{var g=Ha(c[e],b);-1!==g&&E[c[e]].splice(g,1)}};d.destroy=function(){ea.add(Sa).add(z).add(H).add(U).add(X).add(da).add(Y).add(Z).add(V).add(W).unbind("."+m);Y.add(Z).add(V).add(W).removeClass(c.disabledClass);
y&&y.eq(g.activeItem).removeClass(c.activeClass);U.empty();F||(B.unbind("."+m),q.add(z).css(G||(c.horizontal?"left":"top"),G?"none":0),h.removeData(f,m));Aa=0;return d};d.init=function(){if(!Aa){d.on(l);var a=z;F||(a=a.add(q),B.css("overflow","hidden"),!G&&"static"===B.css("position")&&B.css("position","relative"));G?ja&&a.css(G,ja):("static"===H.css("position")&&H.css("position","relative"),a.css({position:"absolute"}));if(c.forward)X.on(Ta,ga);if(c.backward)da.on(Ta,ga);if(c.prev)Y.on(fa,ga);if(c.next)Z.on(fa,
ga);if(c.prevPage)V.on(fa,ga);if(c.nextPage)W.on(fa,ga);Sa.on("DOMMouseScroll."+m+" mousewheel."+m,Ca);if(H[0])H.on(fa,Wa);if(D&&c.activateOn)B.on(c.activateOn+"."+m,"*",Ya);if(U[0]&&c.activatePageOn)U.on(c.activatePageOn+"."+m,"*",Za);ab.on(Ua,{source:"slidee"},Ka);if(z)z.on(Ua,{source:"handle"},Ka);ea.bind("keydown."+m,Xa);F||(B.on("mouseenter."+m+" mouseleave."+m,$a),B.on("scroll."+m,bb));ba();D?(oa(c.startAt),d[O?"toCenter":"toStart"](c.startAt)):J(c.startAt,1);if(c.cycleBy&&!F)d[c.startPaused?
"pause":"resume"]();Aa=1;return d}}}function P(f){return null==f?String(f):"object"===typeof f||"function"===typeof f?Object.prototype.toString.call(f).match(/\s([a-z]+)/i)[1].toLowerCase()||"object":typeof f}function K(f,h){f.preventDefault();h&&f.stopPropagation()}function Pa(f){K(f,1);h(this).off(f.type,Pa)}function bb(){this.scrollTop=this.scrollLeft=0}function Q(f){return!isNaN(parseFloat(f))&&isFinite(f)}function ca(f,h){return parseInt(f.css(h),10)||0}function A(f,h,l){return f<h?h:f>l?l:f}
for(var m="sly",ka=w.cancelAnimationFrame||w.cancelRequestAnimationFrame,ia=w.requestAnimationFrame,G,ja,ea=h(document),Ua="touchstart."+m+" mousedown."+m,Ma="mousemove."+m+" mouseup."+m,La="touchmove."+m+" touchend."+m,fa="click."+m,Ta="mousedown."+m,S=window,u=["moz","webkit","o"],la=0,L=0,Ba=u.length;L<Ba&&!ka;++L)ia=(ka=S[u[L]+"CancelAnimationFrame"]||S[u[L]+"CancelRequestAnimationFrame"])&&S[u[L]+"RequestAnimationFrame"];ka||(ia=function(f){var h=+new Date,l=Math.max(0,16-(h-la));la=h+l;return S.setTimeout(function(){f(h+
l)},l)},ka=function(f){clearTimeout(f)});var u=function(f){for(var h=0,l=$.length;h<l;h++){var m=$[h]?$[h]+f.charAt(0).toUpperCase()+f.slice(1):f;if(Ca.style[m]!==sa)return m}},$=["","webkit","moz","ms","o"],Ca=document.createElement("div");G=u("transform");ja=u("perspective")?"translateZ(0) ":"";w.Sly=ma;h.fn.sly=function(f,u){var l,A;if(!h.isPlainObject(f)){if("string"===P(f)||!1===f)l=!1===f?"destroy":f,A=Array.prototype.slice.call(arguments,1);f={}}return this.each(function(G,w){var x=h.data(w,
m);!x&&!l?h.data(w,m,(new ma(w,f,u)).init()):x&&l&&x[l]&&x[l].apply(x,A)})};ma.defaults={horizontal:0,itemNav:null,itemSelector:null,smart:0,activateOn:null,activateMiddle:0,scrollSource:null,scrollBy:0,dragSource:null,mouseDragging:0,touchDragging:0,releaseSwing:0,swingSpeed:0.2,elasticBounds:0,scrollBar:null,dragHandle:0,dynamicHandle:0,minHandleSize:50,clickBar:0,syncSpeed:0.5,pagesBar:null,activatePageOn:null,pageBuilder:function(f){return"<li>"+(f+1)+"</li>"},forward:null,backward:null,prev:null,
next:null,prevPage:null,nextPage:null,cycleBy:null,cycleInterval:5E3,pauseOnHover:0,startPaused:0,moveBy:300,speed:0,easing:"swing",startAt:0,keyboardNavBy:null,draggedClass:"dragged",activeClass:"active",disabledClass:"disabled"}})(jQuery,window);

/*! http://responsiveslides.com v1.54 by @viljamis */
(function(c,I,B){c.fn.responsiveSlides=function(l){var a=c.extend({auto:!0,speed:500,timeout:4E3,pager:!1,nav:!1,random:!1,pause:!1,pauseControls:!0,prevText:"Previous",nextText:"Next",maxwidth:"",navContainer:"",manualControls:"",namespace:"rslides",before:c.noop,after:c.noop},l);return this.each(function(){B++;var f=c(this),s,r,t,m,p,q,n=0,e=f.children(),C=e.size(),h=parseFloat(a.speed),D=parseFloat(a.timeout),u=parseFloat(a.maxwidth),g=a.namespace,d=g+B,E=g+"_nav "+d+"_nav",v=g+"_here",j=d+"_on",
w=d+"_s",k=c("<ul class='"+g+"_tabs "+d+"_tabs' />"),x={"float":"left",position:"relative",opacity:1,zIndex:2},y={"float":"none",position:"absolute",opacity:0,zIndex:1},F=function(){var b=(document.body||document.documentElement).style,a="transition";if("string"===typeof b[a])return!0;s=["Moz","Webkit","Khtml","O","ms"];var a=a.charAt(0).toUpperCase()+a.substr(1),c;for(c=0;c<s.length;c++)if("string"===typeof b[s[c]+a])return!0;return!1}(),z=function(b){a.before(b);F?(e.removeClass(j).css(y).eq(b).addClass(j).css(x),
n=b,setTimeout(function(){a.after(b)},h)):e.stop().fadeOut(h,function(){c(this).removeClass(j).css(y).css("opacity",1)}).eq(b).fadeIn(h,function(){c(this).addClass(j).css(x);a.after(b);n=b})};a.random&&(e.sort(function(){return Math.round(Math.random())-0.5}),f.empty().append(e));e.each(function(a){this.id=w+a});f.addClass(g+" "+d);l&&l.maxwidth&&f.css("max-width",u);e.hide().css(y).eq(0).addClass(j).css(x).show();F&&e.show().css({"-webkit-transition":"opacity "+h+"ms ease-in-out","-moz-transition":"opacity "+
h+"ms ease-in-out","-o-transition":"opacity "+h+"ms ease-in-out",transition:"opacity "+h+"ms ease-in-out"});if(1<e.size()){if(D<h+100)return;if(a.pager&&!a.manualControls){var A=[];e.each(function(a){a+=1;A+="<li><a href='#' class='"+w+a+"'>"+a+"</a></li>"});k.append(A);l.navContainer?c(a.navContainer).append(k):f.after(k)}a.manualControls&&(k=c(a.manualControls),k.addClass(g+"_tabs "+d+"_tabs"));(a.pager||a.manualControls)&&k.find("li").each(function(a){c(this).addClass(w+(a+1))});if(a.pager||a.manualControls)q=
k.find("a"),r=function(a){q.closest("li").removeClass(v).eq(a).addClass(v)};a.auto&&(t=function(){p=setInterval(function(){e.stop(!0,!0);var b=n+1<C?n+1:0;(a.pager||a.manualControls)&&r(b);z(b)},D)},t());m=function(){a.auto&&(clearInterval(p),t())};a.pause&&f.hover(function(){clearInterval(p)},function(){m()});if(a.pager||a.manualControls)q.bind("click",function(b){b.preventDefault();a.pauseControls||m();b=q.index(this);n===b||c("."+j).queue("fx").length||(r(b),z(b))}).eq(0).closest("li").addClass(v),
a.pauseControls&&q.hover(function(){clearInterval(p)},function(){m()});if(a.nav){g="<a href='#' class='"+E+" prev'>"+a.prevText+"</a><a href='#' class='"+E+" next'>"+a.nextText+"</a>";l.navContainer?c(a.navContainer).append(g):f.after(g);var d=c("."+d+"_nav"),G=d.filter(".prev");d.bind("click",function(b){b.preventDefault();b=c("."+j);if(!b.queue("fx").length){var d=e.index(b);b=d-1;d=d+1<C?n+1:0;z(c(this)[0]===G[0]?b:d);if(a.pager||a.manualControls)r(c(this)[0]===G[0]?b:d);a.pauseControls||m()}});
a.pauseControls&&d.hover(function(){clearInterval(p)},function(){m()})}}if("undefined"===typeof document.body.style.maxWidth&&l.maxwidth){var H=function(){f.css("width","100%");f.width()>u&&f.css("width",u)};H();c(I).bind("resize",function(){H()})}})}})(jQuery,this,0);

/*
 * jQuery EasyTabs plugin 3.2.0
 *
 * Copyright (c) 2010-2011 Steve Schwartz (JangoSteve)
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 * Date: Thu May 09 17:30:00 2013 -0500
 */
(function(a){a.easytabs=function(j,e){var f=this,q=a(j),i={animate:true,panelActiveClass:"active",tabActiveClass:"active",defaultTab:"li:first-child",animationSpeed:"normal",tabs:"> ul > li",updateHash:true,cycle:false,collapsible:false,collapsedClass:"collapsed",collapsedByDefault:true,uiTabs:false,transitionIn:"fadeIn",transitionOut:"fadeOut",transitionInEasing:"swing",transitionOutEasing:"swing",transitionCollapse:"slideUp",transitionUncollapse:"slideDown",transitionCollapseEasing:"swing",transitionUncollapseEasing:"swing",containerClass:"",tabsClass:"",tabClass:"",panelClass:"",cache:true,event:"click",panelContext:q},h,l,v,m,d,t={fast:200,normal:400,slow:600},r;f.init=function(){f.settings=r=a.extend({},i,e);r.bind_str=r.event+".easytabs";if(r.uiTabs){r.tabActiveClass="ui-tabs-selected";r.containerClass="ui-tabs ui-widget ui-widget-content ui-corner-all";r.tabsClass="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all";r.tabClass="ui-state-default ui-corner-top";r.panelClass="ui-tabs-panel ui-widget-content ui-corner-bottom"}if(r.collapsible&&e.defaultTab!==undefined&&e.collpasedByDefault===undefined){r.collapsedByDefault=false}if(typeof(r.animationSpeed)==="string"){r.animationSpeed=t[r.animationSpeed]}a("a.anchor").remove().prependTo("body");q.data("easytabs",{});f.setTransitions();f.getTabs();b();g();w();n();c();q.attr("data-easytabs",true)};f.setTransitions=function(){v=(r.animate)?{show:r.transitionIn,hide:r.transitionOut,speed:r.animationSpeed,collapse:r.transitionCollapse,uncollapse:r.transitionUncollapse,halfSpeed:r.animationSpeed/2}:{show:"show",hide:"hide",speed:0,collapse:"hide",uncollapse:"show",halfSpeed:0}};f.getTabs=function(){var x;f.tabs=q.find(r.tabs),f.panels=a(),f.tabs.each(function(){var A=a(this),z=A.children("a"),y=A.children("a").data("target");A.data("easytabs",{});if(y!==undefined&&y!==null){A.data("easytabs").ajax=z.attr("href")}else{y=z.attr("href")}y=y.match(/#([^\?]+)/)[1];x=r.panelContext.find("#"+y);if(x.length){x.data("easytabs",{position:x.css("position"),visibility:x.css("visibility")});x.not(r.panelActiveClass).hide();f.panels=f.panels.add(x);A.data("easytabs").panel=x}else{f.tabs=f.tabs.not(A);if("console" in window){console.warn("Warning: tab without matching panel for selector '#"+y+"' removed from set")}}})};f.selectTab=function(x,C){var y=window.location,B=y.hash.match(/^[^\?]*/)[0],z=x.parent().data("easytabs").panel,A=x.parent().data("easytabs").ajax;if(r.collapsible&&!d&&(x.hasClass(r.tabActiveClass)||x.hasClass(r.collapsedClass))){f.toggleTabCollapse(x,z,A,C)}else{if(!x.hasClass(r.tabActiveClass)||!z.hasClass(r.panelActiveClass)){o(x,z,A,C)}else{if(!r.cache){o(x,z,A,C)}}}};f.toggleTabCollapse=function(x,y,z,A){f.panels.stop(true,true);if(u(q,"easytabs:before",[x,y,r])){f.tabs.filter("."+r.tabActiveClass).removeClass(r.tabActiveClass).children().removeClass(r.tabActiveClass);if(x.hasClass(r.collapsedClass)){if(z&&(!r.cache||!x.parent().data("easytabs").cached)){q.trigger("easytabs:ajax:beforeSend",[x,y]);y.load(z,function(C,B,D){x.parent().data("easytabs").cached=true;q.trigger("easytabs:ajax:complete",[x,y,C,B,D])})}x.parent().removeClass(r.collapsedClass).addClass(r.tabActiveClass).children().removeClass(r.collapsedClass).addClass(r.tabActiveClass);y.addClass(r.panelActiveClass)[v.uncollapse](v.speed,r.transitionUncollapseEasing,function(){q.trigger("easytabs:midTransition",[x,y,r]);if(typeof A=="function"){A()}})}else{x.addClass(r.collapsedClass).parent().addClass(r.collapsedClass);y.removeClass(r.panelActiveClass)[v.collapse](v.speed,r.transitionCollapseEasing,function(){q.trigger("easytabs:midTransition",[x,y,r]);if(typeof A=="function"){A()}})}}};f.matchTab=function(x){return f.tabs.find("[href='"+x+"'],[data-target='"+x+"']").first()};f.matchInPanel=function(x){return(x&&f.validId(x)?f.panels.filter(":has("+x+")").first():[])};f.validId=function(x){return x.substr(1).match(/^[A-Za-z]+[A-Za-z0-9\-_:\.].$/)};f.selectTabFromHashChange=function(){var y=window.location.hash.match(/^[^\?]*/)[0],x=f.matchTab(y),z;if(r.updateHash){if(x.length){d=true;f.selectTab(x)}else{z=f.matchInPanel(y);if(z.length){y="#"+z.attr("id");x=f.matchTab(y);d=true;f.selectTab(x)}else{if(!h.hasClass(r.tabActiveClass)&&!r.cycle){if(y===""||f.matchTab(m).length||q.closest(y).length){d=true;f.selectTab(l)}}}}}};f.cycleTabs=function(x){if(r.cycle){x=x%f.tabs.length;$tab=a(f.tabs[x]).children("a").first();d=true;f.selectTab($tab,function(){setTimeout(function(){f.cycleTabs(x+1)},r.cycle)})}};f.publicMethods={select:function(x){var y;if((y=f.tabs.filter(x)).length===0){if((y=f.tabs.find("a[href='"+x+"']")).length===0){if((y=f.tabs.find("a"+x)).length===0){if((y=f.tabs.find("[data-target='"+x+"']")).length===0){if((y=f.tabs.find("a[href$='"+x+"']")).length===0){a.error("Tab '"+x+"' does not exist in tab set")}}}}}else{y=y.children("a").first()}f.selectTab(y)}};var u=function(A,x,z){var y=a.Event(x);A.trigger(y,z);return y.result!==false};var b=function(){q.addClass(r.containerClass);f.tabs.parent().addClass(r.tabsClass);f.tabs.addClass(r.tabClass);f.panels.addClass(r.panelClass)};var g=function(){var y=window.location.hash.match(/^[^\?]*/)[0],x=f.matchTab(y).parent(),z;if(x.length===1){h=x;r.cycle=false}else{z=f.matchInPanel(y);if(z.length){y="#"+z.attr("id");h=f.matchTab(y).parent()}else{h=f.tabs.parent().find(r.defaultTab);if(h.length===0){a.error("The specified default tab ('"+r.defaultTab+"') could not be found in the tab set ('"+r.tabs+"') out of "+f.tabs.length+" tabs.")}}}l=h.children("a").first();p(x)};var p=function(z){var y,x;if(r.collapsible&&z.length===0&&r.collapsedByDefault){h.addClass(r.collapsedClass).children().addClass(r.collapsedClass)}else{y=a(h.data("easytabs").panel);x=h.data("easytabs").ajax;if(x&&(!r.cache||!h.data("easytabs").cached)){q.trigger("easytabs:ajax:beforeSend",[l,y]);y.load(x,function(B,A,C){h.data("easytabs").cached=true;q.trigger("easytabs:ajax:complete",[l,y,B,A,C])})}h.data("easytabs").panel.show().addClass(r.panelActiveClass);h.addClass(r.tabActiveClass).children().addClass(r.tabActiveClass)}q.trigger("easytabs:initialised",[l,y])};var w=function(){f.tabs.children("a").bind(r.bind_str,function(x){r.cycle=false;d=false;f.selectTab(a(this));x.preventDefault?x.preventDefault():x.returnValue=false})};var o=function(z,D,E,H){f.panels.stop(true,true);if(u(q,"easytabs:before",[z,D,r])){var A=f.panels.filter(":visible"),y=D.parent(),F,x,C,G,B=window.location.hash.match(/^[^\?]*/)[0];if(r.animate){F=s(D);x=A.length?k(A):0;C=F-x}m=B;G=function(){q.trigger("easytabs:midTransition",[z,D,r]);if(r.animate&&r.transitionIn=="fadeIn"){if(C<0){y.animate({height:y.height()+C},v.halfSpeed).css({"min-height":""})}}if(r.updateHash&&!d){window.location.hash="#"+D.attr("id")}else{d=false}D[v.show](v.speed,r.transitionInEasing,function(){y.css({height:"","min-height":""});q.trigger("easytabs:after",[z,D,r]);if(typeof H=="function"){H()}})};if(E&&(!r.cache||!z.parent().data("easytabs").cached)){q.trigger("easytabs:ajax:beforeSend",[z,D]);D.load(E,function(J,I,K){z.parent().data("easytabs").cached=true;q.trigger("easytabs:ajax:complete",[z,D,J,I,K])})}if(r.animate&&r.transitionOut=="fadeOut"){if(C>0){y.animate({height:(y.height()+C)},v.halfSpeed)}else{y.css({"min-height":y.height()})}}f.tabs.filter("."+r.tabActiveClass).removeClass(r.tabActiveClass).children().removeClass(r.tabActiveClass);f.tabs.filter("."+r.collapsedClass).removeClass(r.collapsedClass).children().removeClass(r.collapsedClass);z.parent().addClass(r.tabActiveClass).children().addClass(r.tabActiveClass);f.panels.filter("."+r.panelActiveClass).removeClass(r.panelActiveClass);D.addClass(r.panelActiveClass);if(A.length){A[v.hide](v.speed,r.transitionOutEasing,G)}else{D[v.uncollapse](v.speed,r.transitionUncollapseEasing,G)}}};var s=function(z){if(z.data("easytabs")&&z.data("easytabs").lastHeight){return z.data("easytabs").lastHeight}var B=z.css("display"),y,x;try{y=a("<div></div>",{position:"absolute",visibility:"hidden",overflow:"hidden"})}catch(A){y=a("<div></div>",{visibility:"hidden",overflow:"hidden"})}x=z.wrap(y).css({position:"relative",visibility:"hidden",display:"block"}).outerHeight();z.unwrap();z.css({position:z.data("easytabs").position,visibility:z.data("easytabs").visibility,display:B});z.data("easytabs").lastHeight=x;return x};var k=function(y){var x=y.outerHeight();if(y.data("easytabs")){y.data("easytabs").lastHeight=x}else{y.data("easytabs",{lastHeight:x})}return x};var n=function(){if(typeof a(window).hashchange==="function"){a(window).hashchange(function(){f.selectTabFromHashChange()})}else{if(a.address&&typeof a.address.change==="function"){a.address.change(function(){f.selectTabFromHashChange()})}}};var c=function(){var x;if(r.cycle){x=f.tabs.index(h);setTimeout(function(){f.cycleTabs(x+1)},r.cycle)}};f.init()};a.fn.easytabs=function(c){var b=arguments;return this.each(function(){var e=a(this),d=e.data("easytabs");if(undefined===d){d=new a.easytabs(this,c);e.data("easytabs",d)}if(d.publicMethods[c]){return d.publicMethods[c](Array.prototype.slice.call(b,1))}})}})(jQuery);

(function(){function n(){}function r(e,t){this.path=e;if(typeof t!=="undefined"&&t!==null){this.at_2x_path=t;this.perform_check=false}else{this.at_2x_path=e.replace(/\.\w+$/,function(e){return"@2x"+e});this.perform_check=true}}function i(e){this.el=e;this.path=new r(this.el.getAttribute("src"),this.el.getAttribute("data-at2x"));var t=this;this.path.check_2x_variant(function(e){if(e)t.swap()})}var e=typeof exports=="undefined"?window:exports;var t={check_mime_type:true};e.Retina=n;n.configure=function(e){if(e==null)e={};for(var n in e)t[n]=e[n]};n.init=function(t){if(t==null)t=e;var n=t.onload||new Function;t.onload=function(){var e=document.getElementsByClassName("retina"),t=[],r,s;for(r=0;r<e.length;r++){s=e[r];t.push(new i(s))}n()}};n.isRetina=function(){var t="(-webkit-min-device-pixel-ratio: 1.5),                      (min--moz-device-pixel-ratio: 1.5),                      (-o-min-device-pixel-ratio: 3/2),                      (min-resolution: 1.5dppx)";if(e.devicePixelRatio>1)return true;if(e.matchMedia&&e.matchMedia(t).matches)return true;return false};e.RetinaImagePath=r;r.confirmed_paths=[];r.prototype.is_external=function(){return!!(this.path.match(/^https?\:/i)&&!this.path.match("//"+document.domain))};r.prototype.check_2x_variant=function(e){var n,i=this;if(this.is_external()){return e(false)}else if(!this.perform_check&&typeof this.at_2x_path!=="undefined"&&this.at_2x_path!==null){return e(true)}else if(this.at_2x_path in r.confirmed_paths){return e(true)}else{n=new XMLHttpRequest;n.open("HEAD",this.at_2x_path);n.onreadystatechange=function(){if(n.readyState!=4){return e(false)}if(n.status>=200&&n.status<=399){if(t.check_mime_type){var s=n.getResponseHeader("Content-Type");if(s==null||!s.match(/^image/i)){return e(false)}}r.confirmed_paths.push(i.at_2x_path);return e(true)}else{return e(false)}};n.send()}};e.RetinaImage=i;i.prototype.swap=function(e){function n(){if(!t.el.complete){setTimeout(n,5)}else{t.el.setAttribute("width",t.el.offsetWidth);t.el.setAttribute("height",t.el.offsetHeight);t.el.setAttribute("src",e)}}if(typeof e=="undefined")e=this.path.at_2x_path;var t=this;n()};if(n.isRetina()){n.init(e)}})();;
/*-----------------------------------------------------------------------------------*/
/*	LOADER
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

$('body').prepend('<div id="spinningSquaresG"><div id="spinningSquaresG_1" class="spinningSquaresG"></div><div id="spinningSquaresG_2" class="spinningSquaresG"></div><div id="spinningSquaresG_3" class="spinningSquaresG"></div><div id="spinningSquaresG_4" class="spinningSquaresG"></div><div id="spinningSquaresG_5" class="spinningSquaresG"></div><div id="spinningSquaresG_6" class="spinningSquaresG"></div><div id="spinningSquaresG_7" class="spinningSquaresG"></div><div id="spinningSquaresG_8" class="spinningSquaresG"></div></div>');
});

jQuery(window).load(function($){

	jQuery('body').find('#spinningSquaresG').remove();
	jQuery('.content-wrapper').animate({ 'opacity' : '1' }, 500);
	
	jQuery('#vertical, #vertical ul').height( jQuery(window).height() );
	
});
/*-----------------------------------------------------------------------------------*/
/*	HEADER
/*-----------------------------------------------------------------------------------*/
jQuery(window).load(function($){

	if( jQuery(window).width() > 767){
	
		jQuery('header').css({ 'min-height' : jQuery(window).height() });
		jQuery('header').wrapInner("<div class='header-wrap'></div>");
		
		var innerHeight = jQuery('.header-wrap').height();
		var documentHeight = jQuery(document).height();
		jQuery(window).scroll(function(){
			if( jQuery(window).scrollTop() < documentHeight - innerHeight ){
				jQuery('.header-wrap').css({ 'position' : 'fixed', 'top' : '0' });
			} else {
				jQuery('.header-wrap').css({ 'position' : 'absolute', 'top' : documentHeight - innerHeight });
			}
		});
		
	}
	
});
/*-----------------------------------------------------------------------------------*/
/*	MOBILE NAV
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	$('#mobile-nav').click(function(){
		$("html, body").animate({ scrollTop: 0 }, 200);
		setTimeout(function(){
			$('header').toggleClass('active');
			$('#mobile-nav').toggleClass('active');	
		}, 200);	
	});
	
});
/*-----------------------------------------------------------------------------------*/
/*	NAVIGATION ACTIVE
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	$('nav a[href^="' + location.pathname.split("/")[1] + '"]').addClass('active').parents('li').children('a').addClass('active');
	
});
/*-----------------------------------------------------------------------------------*/
/*	SLIDER
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	$(".rslides").responsiveSlides({
	  speed: 500,
	  timeout: 4000,
	  pager: true
	});
	
});
/*-----------------------------------------------------------------------------------*/
/*	ISOTOPE
/*-----------------------------------------------------------------------------------*/
jQuery(window).load(function($){
'use strict';

	jQuery('ul.grid').isotope({
		itemSelector : 'li',
		transformsEnabled : false
	});
	
	jQuery('.filters a').click(function(){
		var filter = jQuery(this).attr('data-href');
		jQuery('.filters li').removeClass('active');
		jQuery(this).parent().addClass('active');
		jQuery('ul.grid').isotope({ filter: filter });
		jQuery(window).trigger('resize');
		return false;
	});
	
	jQuery(window).smartresize(function(){
		jQuery('ul.grid').isotope('reLayout');
	});
	
	jQuery(window).trigger('resize');
	
	jQuery('header').height( jQuery(document).height() );
	
	jQuery(window).resize(function(){
		jQuery('header').height( jQuery(window).height() );
		setTimeout(function(){
			jQuery('header').height( jQuery(document).height() );
		}, 900);
		
		jQuery('#vertical, #vertical ul').height( jQuery(window).height() );

	});
	
});
/*-----------------------------------------------------------------------------------*/
/*	HOVER DIR
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	$(function(){
		$('ul.grid.portfolio li, .more-hover').each( function() { $(this).hoverdir(); } );
	});

});
/*-----------------------------------------------------------------------------------*/
/*	GALLERY HOVER
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	$('.gallery.animate li').hover(function(){
		$('.gallery li').not(this).stop().animate({ 'opacity' : '0.3' }, 200);
	}, function(){
		$('.gallery li').stop().animate({ 'opacity' : '1' }, 200);
	});
});
/*-----------------------------------------------------------------------------------*/
/*	AJAX PORTFOLIO
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';
	
	$('body').on('click', 'ul.grid li a, .gallery-wrapper a', function(){
		var url = $(this).attr('href');
		
		$('.filters').slideUp();
		
		$('.content-wrapper').prepend('<div id="spinningSquaresG"><div id="spinningSquaresG_1" class="spinningSquaresG"></div><div id="spinningSquaresG_2" class="spinningSquaresG"></div><div id="spinningSquaresG_3" class="spinningSquaresG"></div><div id="spinningSquaresG_4" class="spinningSquaresG"></div><div id="spinningSquaresG_5" class="spinningSquaresG"></div><div id="spinningSquaresG_6" class="spinningSquaresG"></div><div id="spinningSquaresG_7" class="spinningSquaresG"></div><div id="spinningSquaresG_8" class="spinningSquaresG"></div></div>');
		
		$.get(url, function(data){
			var filtered = jQuery(data).filter('section').removeClass('content');
			
			$(filtered).find(".rslides").responsiveSlides({
			  speed: 500,
			  timeout: 4000,
			  pager: true
			});
			
			$(filtered).imagesLoaded(function(){
				$('ul.grid, .gallery-wrapper').animate({ 'left' : '-100%', 'opacity' : '0' }, function(){
					$('ul.grid, .gallery-wrapper').css('max-height', '0px');
					$("html, body").animate({ scrollTop: 0 }, 200);
					$('#loader').html(filtered);
					$('#spinningSquaresG').remove();
					$('#loader').slideDown(function(){
						jQuery(window).trigger('resize');
					});
				});
			});
		});
		return false;
	});
	
	$('body').on('click', '.post-nav', function(){
		var url = $(this).attr('href');
		
		$('.content-wrapper').prepend('<div id="spinningSquaresG"><div id="spinningSquaresG_1" class="spinningSquaresG"></div><div id="spinningSquaresG_2" class="spinningSquaresG"></div><div id="spinningSquaresG_3" class="spinningSquaresG"></div><div id="spinningSquaresG_4" class="spinningSquaresG"></div><div id="spinningSquaresG_5" class="spinningSquaresG"></div><div id="spinningSquaresG_6" class="spinningSquaresG"></div><div id="spinningSquaresG_7" class="spinningSquaresG"></div><div id="spinningSquaresG_8" class="spinningSquaresG"></div></div>');
		
		$.get(url, function(data){
			var filtered = jQuery(data).filter('section').removeClass('content');
			
			$(filtered).find(".rslides").responsiveSlides({
			  speed: 500,
			  timeout: 4000,
			  pager: true
			});
			
			$(filtered).imagesLoaded(function(){
				$('#loader').animate({ 'left' : '-100%', 'opacity' : '0' }, function(){
					$("html, body").animate({ scrollTop: 0 }, 200);
					$('#spinningSquaresG').remove();
					$('#loader').html(filtered).animate({ 'left' : '0', 'opacity' : '1' });
				});
			});
		});
		return false;
	});
	
	$('body').on('click', 'a.close', function(){
	
	  $('.filters').slideDown();
		
		$('#loader').slideUp(function(){
			$('ul.grid, .gallery-wrapper').css('max-height', '');
			$('ul.grid, .gallery-wrapper').animate({ 'left' : '0', 'opacity' : '1' },function(){
				jQuery(window).trigger('resize');
			});
		});
		
		return false;
	});

});
/*-----------------------------------------------------------------------------------*/
/*	VERTICAL GALLERY
/*-----------------------------------------------------------------------------------*/
jQuery(window).load(function($){
'use strict';

if(jQuery('#vertical').length > 0){
	var sly = new Sly(jQuery('#vertical'), {
		horizontal: 1,
		itemNav: 'basic',
		smart: 1,
		activateOn: 'click',
		mouseDragging: 1,
		touchDragging: 1,
		releaseSwing: 1,
		startAt: 0,
		scrollBy: 1,
		activatePageOn: 'click',
		speed: 300,
		elasticBounds: 1,
		dragHandle: 1,
		dynamicHandle: 1,
		clickBar: 1,
	}).init();
	
	jQuery(window).resize(function(){
		sly.reload();
	});
}
	
});
/*-----------------------------------------------------------------------------------*/
/*	VEIW BACKGROUND
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

$('.view-background').click(function(){
	if( $('.content-wrapper').css('left') == '0px' ){
		$('.content-wrapper').animate({ 'left' : '-100%', 'opacity' : '0' });
		$('.view-background').html('<i class="icon-eye-open icon-2x"></i>');
	} else {
		$('.content-wrapper').animate({ 'left' : '0', 'opacity' : '1' });
		$('.view-background').html('<i class="icon-eye-close icon-2x"></i>');
	}
	return false;
});
	
});
/*-----------------------------------------------------------------------------------*/
/*	TABS
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

		$('.tab-container').easytabs();

});
/*-----------------------------------------------------------------------------------*/
/*	ALERTS
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

		$('.alert i').click(function(){
			$(this).parent().slideUp();
		});

});
/*-----------------------------------------------------------------------------------*/
/*	ACCORDION
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

		$('.accordion > dd.active').show();
		  
		$('.accordion > dt > a').click(function() {
			if( $(this).parent().hasClass('active') ){
				$(this).parents('.accordion').find('dt').removeClass('active');
				$(this).parents('.accordion').find('dd').removeClass('active').slideUp();
				return false;
			} else {
				$(this).parents('.accordion').find('dt').removeClass('active');
				$(this).parents('.accordion').find('dd').removeClass('active').slideUp();
				$(this).parent().addClass('active').next().addClass('active').slideDown();
				return false;
			}
		});

});
/*-----------------------------------------------------------------------------------*/
/*	CONTACT FORM
/*-----------------------------------------------------------------------------------*/
jQuery(document).ready(function($){
'use strict';

	//CONTACT FORM
		$('#contactform').submit(function(){
	
			var action = $(this).attr('action');
	
			$("#message").slideUp(750,function() {
			$('#message').hide();
	
	 		$('#submit').attr('disabled','disabled');
	
			$.post(action, {
				name: $('#name').val(),
				email: $('#email').val(),
				website: $('#website').val(),
				comments: $('#comments').val()
			},
				function(data){
					document.getElementById('message').innerHTML = data;
					$('#message').slideDown('slow');
					$('#submit').removeAttr('disabled');
					if(data.match('success') != null) $('#contactform').slideUp('slow');
					$(window).trigger('resize');
				}
			);
	
			});
	
			return false;
	
		});
	
});;