<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import = "java.util.Map, java.util.Arrays" %>
<%!org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());%>
<%
Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
Object exceptionType = request.getAttribute("javax.servlet.error.exception_type");
String errorMessage = (String)request.getAttribute("javax.servlet.error.message");
String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
String requestParameters = (String)request.getAttribute("javax.servlet.forward.query_string");
String errorId = java.util.UUID.randomUUID().toString();
StringBuffer sb = new StringBuffer();
sb.append("errorId:").append(errorId);
sb.append(", statusCode:").append(statusCode);
sb.append(", requestUri:").append(requestUri);
sb.append(", requestParameters:").append(requestParameters);
sb.append(", exceptionType:").append(exceptionType);
sb.append(", errorMessage:").append(errorMessage);
sb.append(", clientIP:").append(request.getRemoteAddr());
sb.append(", exception:");
logger.error(sb.toString(), exception);
%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="../common/css.jsp"%>
<title><%=statusCode%>出错啦</title>
</head>
<body class="jh_error_bgColor jh_error_bdPad0">
<div class="jh_error_pic500">
	<h4 class="text-center ">抱歉，出错啦！！！</h4>
	<div class="text-center jh_t_mar01">
		<a href="javascript:history.back();" class="btn"><i
			class="icon-share-alt margin"></i>返回上一页</a> <a href="<c:url value="/"/>"><i
			class="icon-home margin"></i>返回首页</a>
	</div>
	<div class="jh_t_mar01 jh_error_500Content">
		<h4 class="text-error text-left">状态码：<%=statusCode%></h4>
		<%if(exceptionType != null){ %>
		<p>异常类型：<%=exceptionType%></p>
		<%} %>
		<form action='mailto:lixiaoliang.bupt@google.com'>
			<input name='subject' type='hidden' value='[<%=statusCode%>]管理后台异常错误' />
			<textarea name="body" rows="10" class="jh_error_textarea">错误码："<%=statusCode%>",
异常ID："<%=errorId %>",
异常类型："<%if(exceptionType != null){ %><%=exceptionType%><%} %>"
request: <%=request.toString() %></textarea>
			<p class="jh_t_mar01 text-right">
				<input type="submit" class="btn btn-primary jh_r_mar01" value="报告错误" />
			</p>
		</form>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>
<%@ include file="../common/stat.jsp"%>
</body>
</html>