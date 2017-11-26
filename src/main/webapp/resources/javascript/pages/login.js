function hideActionError(){
    var infoStr=$("#invalidInfo").text();
    if($.trim(infoStr)=='' || $.trim(infoStr)=="${error_message.fail_info}" ||$.trim(infoStr)=="[]"){
        $("#invalidInfo").css({
            "color" : "#d97c00"
        }).text("欢迎使用人机交互后台系统");
    }
}

function changeImg(){
    document.getElementById('identity').src='login/identitycode?ts='+new Date().getTime();
}

function lostBlur(){
    $('#checkCode').blur(function(){
        var $verificationId = $('#verificationId').val();
        var $checkCode = $('#checkCode').val();
        var $passWord = $('#passWord').val();

        //if($checkCode.length == 5){
        //    $.ajax({
        //        type: "POST",
        //        url:'checkUserAndCode.htm',
        //        data:{
        //            'verificationId':$verificationId,
        //            'checkCode':$checkCode,
        //            'passWord':$passWord
        //        },
        //        cache: false,
        //        dataType:'json',
        //        async: false
        //    }).done(function(data){
        //        if (data.loginResult=="true") {
        //            $("#myModal").removeAttr("style");
        //        }else{
        //            $('#checkCodeDiv').removeClass("tips_message_right").addClass("tips_message_wrong").html("<em class=ico_info></em>&nbsp;"+data.fail_info);
        //            $("#myModal").attr("style","display:none");
        //        }
        //    }).fail(function(jqXHR, textStatus){
        //        $("#myModal").attr("style","display:none");
        //    }).always(function(){
        //    });
        //}
    });
}

$(document).ready(function() {
    lostBlur();
    hideActionError();
    $("#verificationId").focus();

    $("#loginForm").validate({
        debug:false,
        rules : {
            verificationId : {
                required : true,
                digits : true,
                rangelength : [ 1, 10 ]
            },
            passWord : {
                required : true
            },
            checkCode : {
                required : true,
                minlength : 5
            }
        },

        messages : {
            verificationId : {
                required : "<em class=ico_info></em>&nbsp;员工编号必须输入"
            },
            passWord : {
                required : "<em class=ico_info></em>&nbsp;密码必须输入"
            },
            checkCode : {
                required : "<em class=ico_info></em>&nbsp;校验码必须输入",
                minlength : "<em class=ico_info></em>&nbsp;检验码不能小于4位"
            }
        },

        errorClass: "tips_message_wrong",
        validClass: "tips_message_right",

        highlight: function(element, errorClass, validClass ) {
            $("."+element.name+".tips_message_info").removeClass(validClass).addClass(errorClass);
        },
        unhighlight: function(element, errorClass, validClass ) {
            $("."+element.name+".tips_message_info").removeClass(errorClass).html("<em class=ico_info></em>&nbsp;").addClass(validClass).show();
            $("#invalidInfo").fadeTo("slow",0.00);
        }
    });
});


function login(){
    var isSend=$('#isSend').val();
    isSend = 1;
    if(isSend==1){
        loginForm.submit()	;
    }else{
        var $verificationId = $('#verificationId').val();
        var $checkCode = $('#checkCode').val();
        var $passWord = $('#passWord').val();


        //if($checkCode.length == 5){
        //    $.ajax({
        //        type: "POST",
        //        url:'checkUserAndCode.htm',
        //        data:{
        //            'verificationId':$verificationId,
        //            'checkCode':$checkCode,
        //            'passWord':$passWord
        //        },
        //        cache: false,
        //        dataType:'json',
        //        async: false
        //    }).done(function(data){
        //        if (data.loginResult=="true") {
        //            $('#checkCodeDiv').attr("style","display:none");
        //        }else{
        //            //$('#checkCodeDiv').removeClass("tips_message_right").addClass("tips_message_wrong").html("<em class=ico_info></em>&nbsp;"+data.fail_info);
        //        }
        //    }).fail(function(jqXHR, textStatus){
        //    }).always(function(){
        //    });
        //}
    }
}