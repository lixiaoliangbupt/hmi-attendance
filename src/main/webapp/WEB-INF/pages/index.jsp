<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
  <meta content="yes" name="apple-mobile-web-app-capable">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta content="telephone=no" name="format-detection">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <title>后台登录系统</title>
  <link href="/css/base.css" rel="stylesheet" type="text/css" />

  <script src="/js/jquery-3.2.1.js"></script>
  <script src="/js/validate/jquery.validate.min-1.17.0.js" type="text/javascript"></script>
  <script src="/js/validate/messages_zh.js" type="text/javascript"></script>
  <script src="/js/pages/login.js" type="text/javascript"></script>
  <script>
    DD_belatedPNG.fix('.logo_bar,img,background');
  </script>
  <![endif]-->
  <!---->
</head>

<body>
<div class="logo_bar">
  <img src="img/dl-logo-name.png" class="logo_pic" />
</div>
<div class="unified_box">
  <div class="unified_line"></div>
  <div class="tab_content resetPad">
    <form class="form-horizontal" action="/login"  method="post" id="loginForm">
      <div class="alert text_center" id="invalidInfo">
        <strong></strong>
      </div>
      <div class="ico_log_in"></div>
      <div class="tab_c_info">
        <ul>
          <li>
            <label class="name">员工编号：</label>
            <div class="tab_form tab_formWidth">
              <input type="text" id="verificationId" name="verificationId" autocomplete="off" class="input_text" placeholder="输入员工编号" maxlength="10" />
            </div>
            <label class="verificationId tips_message_info" for="verificationId">
              <em class="login_ico_info"></em>&nbsp;1-10位数字
            </label>
          </li>
          <li>
            <label class="name">密码：</label>
            <div class="tab_form tab_formWidth">
              <input type="password" id="passWord" name="passWord" autocomplete="off" class="input_text" placeholder="输入密码" />
            </div>
            <label class="passWord tips_message_info" for="passWord">
              <em class="login_ico_info"></em>&nbsp;不能为空
            </label>
          </li>
          <li>
            <label class="name">验证码：</label>
            <div class="tab_form tab_formWidth">
              <input type="text"  maxlength="5" id="checkCode" name="checkCode" class="input_text_vc" align="absmiddle" placeholder="输入验证码" />
              <em class="ver_code">
                <a href="#" onClick="changeImg();">
                    <img title="点击刷新" src="login/identitycode" id="identity"  border="0" width="80px"/>
                </a>
              </em>
            </div>
            <label class="checkCode tips_message_info" for="checkCode" id="checkCodeDiv">
              <em class="login_ico_info"></em>&nbsp;不区分大小写
            </label>
          </li>

          <li class="clear_marBottom">
            <label class="name">&nbsp;</label>
            <div class="tab_form tab_formWidth">
              <label>
                <input type="checkbox" name="keepMoment" checked="true"> 记住密码一周
              </label>
            </div>
          </li>
          <li>
            <label class="name">&nbsp;</label>
            <div class="tab_form tab_formWidth">
              <input type="button" class="btn_unified_enter" value="登&nbsp;录" onclick="login()"/>
            </div>
          </li>
        </ul>
      </div>
      <input type="hidden" id="isSend" name="isSend" value="0" />

    </form>
  </div>
</div>
<div class="unified_box_footer"></div>
</body>
</html>