<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top main_nav"><div class="navbar-inner dropdown"><div class="jh_nav_bg"><div class="public_mar">
	<div class="jh_logo"><a href="<c:url value="/" context="/" />"><img src="<c:url value="/images/logo.jpg?_v=1.0"/>" title="首页" /></a></div>
	<div class="jh_nav">
		<a id="nav-toggle" href="#nav" aria-hidden="true" class="btn btn-warning navbar-toggle">
                    	<span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
	<div class="jh_nav_main" id="nav" role="navigation">
		<ul class="jh_nm_list nav navbar-nav color_sub_menu hide" id="ul-topnav">
			<li class="dropdown model">
				<a role="button" data-toggle="dropdown" class="js-activated" data-target="#" href="#">我(${employee.name}) <em><span class="caret"></span></em></a>
				<ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu">
					<li><a tabindex="-1" href="<c:url value="/employee/info" context="/" />" id="userprofile" >个人信息</a></li>
					<li><a tabindex="-1" href="<c:url value="/" context="/" />" id="faq" >常见问题解答 </a></li>
					<li><a tabindex="-1" href="<c:url value="/" context="/" />" id="history" >下载 </a></li>
					<li><a tabindex="-1" href="<c:url value="/" context="/" />" id="help" target="_blank">帮助</a></li>
					<li><a tabindex="-1" href="#" id="logout">退出</a></li>
				</ul>
			</li>
			<c:forEach var="menu" items="${menus }" varStatus="modelStatus">
				<li class="dropdown model">
					<a role="button" data-toggle="dropdown" class="js-activated" data-target="#" href="#">${menu.name}
					<em><span class="caret"></span></em></a>
					<ul class="dropdown-menu pull-left" role="menu" aria-labelledby="dropdownMenu">
					<c:forEach var="children"  items="${menu.children }">
						<li><a tabindex="-1" href="<c:url value="${children.resource.url}" context="/" />">${children.name}</a></li>
					</c:forEach>
					</ul> 
				</li>
			</c:forEach>
		</ul>
	</div></div>
</div></div></div></div>
