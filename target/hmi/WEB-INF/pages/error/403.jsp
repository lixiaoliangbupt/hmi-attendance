<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>403禁止访问</title>
<%@ include file="../common/css.jsp"%>
</head>
<body class="jh_error_bgColor">
<%@ include file="../common/header.jsp"%>
<div class="jh_error_pic403">
        <h4 class="text-center ">抱歉，您没有权限访问，请申请权限后再试！！！</h4>
   <div class="text-center jh_t_mar01">
       <a href="javascript:history.back();" class="btn"><i class="icon-share-alt margin"></i>返回上一页</a>
       <a href="<c:url value="/"/>"><i class="icon-home margin"></i>返回首页</a>
       <address><a href="javascript:void(0)"><i class="icon-lock margin"></i>申请权限：邮件发送lashou_quanxian@lashou-inc.com</a></address>
   </div>
</div>
<div class="jh_b_save">
	<div class="jh_b_saveIn">如要申请权限，请联系 lashou_quanxian@lashou-inc.com ,标明工号、城市、部门、职位、角色（销售、编辑、编辑主管等）</div>
</div>
<%@ include file="../common/footer_and_fastnav.jsp"%>
<%@ include file="../common/stat.jsp"%>
</body>
</html>