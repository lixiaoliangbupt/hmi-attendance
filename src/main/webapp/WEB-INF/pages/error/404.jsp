<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>404您访问的页面不存在</title>
<%@ include file="../common/css.jsp"%>
</head>
<body class="jh_error_bgColor">
<div class="jh_error_pic404">
	<h4 class="text-center ">抱歉，您访问的页面不存在！！！</h4>
	<div class="text-center jh_t_mar01">
		<a href="javascript:history.back();" class="btn"><i class="icon-share-alt margin"></i>返回上一页</a>
		<a href="<c:url value="/"/>"><i class="icon-home margin"></i>返回首页</a>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>
<%@ include file="../common/stat.jsp"%>
</body>
</html>