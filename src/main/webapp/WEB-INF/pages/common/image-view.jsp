<%@ page language="java" pageEncoding="UTF-8"%>
<div class="modal jh_addPic_m hide" id="div-image-view"><div id="div-image-view-resizable">
    <button type="button" class="close">×</button>
    <div class="jh_addPic_xz" id="div-image-view-drag">
        <a href="#" class="jh_addPic_yt" download="">如果图片不清晰请点此链接下载原图</a>
    </div>
    <div class="control-group jh_form02 alsoresizable">
        <div id="div-image-view-resizable-loading" style="width: 64px; height: 64px; display: none; position: absolute; z-index: 999; left: 50%; top: 50%; margin-left: -32px; margin-top: -32px;">
            <img class="loading hide" src="<c:url value="/images/loading.gif"/>" width="64" height="64" /></div>
        <div class="item jh_addPic_h alsoresizable" id="div-image-view-resizable-img" style="width:640px;height:260px;position: relative;overflow: hidden;"></div>
    </div>
    <div>
        <input id="crm_imgbaseurl" type="hidden" value="${_crm_imgbaseurl}"/>
    </div>
</div></div>
<script>
    var _crm_url_img_view = '${_crm_imgbaseurl}';
    //小图路径
    var _url_small_img_view = '${imgbaseurl}';
</script>
<script src="/js/jquery.iviewer-1.1.js" ></script>
<script src="/js/jquery.mousewheel.min.js"></script>
<script>
    /**
     * image-view 图片浏览插件
     */
    // 图片预览
    $('.image-view').click(function(e){
        e.preventDefault();
        $(this).addClass("active");
        $('#div-image-view').show().center();
        $("#div-image-view").drag({
            handler:$('#div-image-view-drag'),
            opacity:0.7
        });
        $("#div-image-view img.loading").show();
        var imgUrl = $(this).find('img').data('url');
        $('#div-image-view-resizable-img').iviewer({
            src: imgUrl + "&compress=true",
            onStartLoad: function(){
                $('#div-image-view-resizable-loading').show();
            },
            onFinishLoad: function(){
                $('#div-image-view-resizable-loading').hide();
                $('#div-image-view-resizable').resizable({
                    alsoResize: "#div-image-view, #div-image-view .alsoresizable"
                });
                $('#div-image-view-resizable div.ui-icon-gripsmall-diagonal-se').addClass('ui-icon-grip-diagonal-se');
            }
        });
        $('#div-image-view-drag').find('a').prop('href', imgUrl);
        $('#div-image-view-drag').find('a').prop('download', imgUrl.substring(imgUrl.lastIndexOf('/') + 1));
    });
    $('#div-image-view button.close').click(function(){
        $('#div-image-view').hide();
        $('a.image-view.active').removeClass("active");
        $('#div-image-view-resizable-img').iviewer('destroy');
        $('#div-image-view-resizable-img').empty();
    });
    $(function(){
        /* var box = $('#message8');
        var top = box.offset().top;*/
        $(window).scroll(function(){
            /* if($(window).scrollTop() > top) {
             $(box).css({'top': $(window).scrollTop() + 'px', 'z-index': 999, 'position': 'absolute'});
             }else{
             $(box).css({'top': '', 'z-index': '', 'position': 'relative'});
             } */
            $('#div-image-view').css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
                    $(window).scrollTop()) + "px");
        });
    });
    $(document).keyup(function(e){
        var code = e.keyCode ? e.keyCode : e.which;
        if(code == 27){
        	$('#div-image-view').hide();
            $('a.image-view.active').removeClass("active")
            $('#div-image-view-resizable-img').iviewer('destroy');
            $('#div-image-view-resizable-img').empty();
        }
    });
</script>