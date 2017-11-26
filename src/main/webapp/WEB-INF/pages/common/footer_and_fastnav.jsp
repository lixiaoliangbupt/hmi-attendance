<%@ page language="java" pageEncoding="UTF-8"%>
<!--快捷入口-->
<!-- <div class="jh_fastNav_out">
	<a href="#top" class="jh_top"></a>
    <div class="jh_fastNav">
        <div class="jh_fastNav_in">
            <ul class="jh_fastNav_list">
            	<li>
                	快捷<br />入口
                </li>
                <li>
                    <a href="#" class="jh_ico01" data-toggle="tooltip" data-original-title="需求管理"></a>
                </li>
                <li>
                    <a href="#" class="jh_ico02" data-toggle="tooltip" data-original-title="需求管理"></a>
                </li>
                <li>
                    <a href="#" class="jh_ico03" data-toggle="tooltip" data-original-title="需求管理"></a>
                </li>
            </ul>
        </div>
    </div>
</div> -->
<%@ include file="footer.jsp"%>
<script>
if((!window.chrome || navigator.userAgent.toLowerCase().indexOf('chrome') == -1) && navigator.userAgent.toLowerCase().indexOf('crios') == -1){
	bootbox.alert('亲，请使用系统专用浏览器，系统将跳转至专用浏览器下载页面', function(){
		window.location.href='http://www.google.com/chrome/browser/desktop/index.html';
	});
}
// 导航只显示有资源的
$('#ul-topnav li.model').find('ul').each(function(){
	if($(this).find('li').length == 0){
		$(this).parent().hide();
	}
});
$('#ul-topnav').show();
// 导航改为hover方式
// jQuery('li.dropdown').hover(function() {
// 	jQuery(this).find('.dropdown-menu').stop(true, true).show();
// 	jQuery(this).addClass('open');
// }, function() {
// 	jQuery(this).find('.dropdown-menu').stop(true, true).hide();
// 	jQuery(this).removeClass('open');
// });
// 退出确认
$('#logout').click(function(){
	bootbox.confirm('确认退出吗？', function(result){
		if(result){
			window.location.href = '<c:url value="/j_spring_security_logout" context="/" />';
		}
	});
});

$(document).ready(function(){
	// 支持导航hover方式
    $('.js-activated').dropdownHover();
    jQuery('li.dropdown').click(function() {
    	if(jQuery(this).find('.dropdown-menu').is(':visible')){
    		$('.dropdown-menu').stop(true, true).hide();
    		jQuery('li.dropdown').removeClass('open');
    	}else{
    		$('.dropdown-menu').stop(true, true).hide();
    		jQuery(this).find('.dropdown-menu').stop(true, true).show();
    		jQuery(this).addClass('open');
    	}
    });
	// 禁用有disabled类的链接
    /*$('li.disabled').find('a').bind('click', false);此方法会禁用掉用js插件写的分页 */
	$('a.disabled').bind('click', false);

	$('li.disabled').find('a').each(function(){
		if($(this).closest("ul.bootpag")){
		}else{
			$(this).bind('click',false);
		}
	});
	// 返回顶部
	$.scrollUp({
        scrollName: 'scrollUp', // Element ID
        topDistance: '100', // Distance from top before showing element (px)
        topSpeed: 300, // Speed back to top (ms)
        animation: 'fade', // Fade, slide, none
        animationInSpeed: 200, // Animation in speed (ms)
        animationOutSpeed: 200, // Animation out speed (ms)
        scrollText: '', // Text for element
        activeOverlay: false  // Set CSS color to display scrollUp active point, e.g '#00FFFF'
  	});

}); 
var navigation = responsiveNav("#nav", {
    customToggle: "#nav-toggle",
    init: function() {
        $("#nav").attr("style", "position:relative");
    },
    open: function() {
        $("#nav").attr("style", "position:absolute");
    },
    close: function() {
        $("#nav").attr("style", "position:absolute");
    }
});
</script>
