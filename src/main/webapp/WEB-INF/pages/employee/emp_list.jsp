<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="../common/common.jsp"%>
  <title>员工列表</title>
</head>
<body>
<%@ include file="../common/header.jsp"%>

<!--面包屑-->
<div class="jh_content">
  <ul class="breadcrumb">
    <li class="active">员工列表</li>
  </ul>
</div>
<div id="resultModal" class="modal hide" role="dialog">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>操作结果</h3>
  </div>
  <div class="modal-body">
    <div class="control-group">
      <label class="control-label"><span id="resultText"></span> </label>
    </div>
  </div>
  <div class="modal-footer"><a href="<c:url value="/employee/list?page=${curPage}"/>" class="btn primary">OK</a></div>
</div>

<!--content-->
<div class="jh_content">
  <div class="row-fluid">
    <div class="span12">
      <div class="jh_moreContent">
        <div class="jh_mcSearch" id="sel_users">
          <div class="jh_moreSearchBox pull-left">
            <span>批量操作：</span> <a href="javascript:void(0)" class="delete_users_batch"><i class="icon-ban-circle"></i>禁用用户</a>
          </div>
          <div class=" pull-right">
            <form id="user_search" action="<c:url value="/employee/list"/>" method="post">
              <input class="input-large" type="text" placeholder="按员工姓名\员工编号\员工邮箱" name="userinfo" value="${userinfo}">
              <button class="btn" type="submit"><i class="icon-search margin"></i>搜索</button>
            </form>
          </div>
        </div>

        <form>
          <div class="jh_table" id="saveModal">
            <table class="table table-bordered table-striped .row-fluid table-hover">
              <thead>
              <tr>
                <th><input type="checkbox" class="user-checkall" /></th>
                <th>员工号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>职级</th>
                <th>个人角色</th>
                <th>状态</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${users}" var="users" varStatus="u">
                <tr data-uid="${users.id}">
                  <c:if test="${users.status==1}" var="condition">
                    <td><input class="selection" type="checkbox" name="uid" value="${users.id}" /></td>
                  </c:if>
                  <c:if test="${users.status==2}">
                    <td><input class="selection" type="checkbox" disabled="disabled" name="uid" value="${users.id }" /></td>
                  </c:if>
                  <td>${users.jobNumber}</td>
                  <td>${users.name}</td>
                  <td>${users.email}</td>
                  <td>${users.position}</td>
                  <td>管理员</td>
                  <c:if test="${users.status==1}" var="condition">
                    <td><i class="jh_ico_right"></i></td>
                  </c:if>
                  <c:if test="${users.status==2}" var="condition">
                    <td class="text-error"><i class="jh_ico_disabled"></i></td>
                  </c:if>
                  <td class="jh_c_option">
                    <div class="dropdown">
                      <a id="drop1" class="dropdown-toggle" href="#" data-toggle="dropdown" role="button">
                        <i class="jh_optionIcon"></i>
                      </a>
                      <ul id="menu1" class="dropdown-menu  jh_position jh_arrowForMenu" aria-labelledby="drop1" role="menu">
                        <li role="presentation"><a href="<c:url value="/employee/edit/${users.id}"/>">编辑</a></li>
                        <li role="presentation" class="<c:if test="${users.status==1}" var="condition">disabled</c:if>">
                          <a href="javascript:void(0)" class="disable_user">禁用</a>
                        </li>
                        <li role="presentation" class="<c:if test="${users.status==2}" var="condition">disabled</c:if>">
                          <a href="javascript:void(0)" class="enable_user">取消禁用</a>
                        </li>
                      </ul>
                    </div>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="pagination pagination-right">
              <ul>
                <li class="<c:if test="${page=='1'}">disabled</c:if>">
                  <%-- <a href="<c:if test="${page!='1'}"><c:url value="/user/list?page=${page-1}"/></c:if>
                      <c:if test="${page=='1'}">javascript:void(0);</c:if>">&laquo;</a> --%>
                  <c:if test="${page!='1'}">
                    <a onclick="refClick(${page-1})">&laquo;</a>
                  </c:if>
                  <c:if test="${page=='1'}">
                    <a href="javascript:void(0);">&laquo;</a>
                  </c:if>
                </li>
                <c:forEach items="${pagecount}" var="pagecount" varStatus="p">
                  <li class="<c:if test="${page==pagecount}">active</c:if>">
                    <c:if test="${page==pagecount}">
                      <a href="javascript:void(0);">${pagecount}</a>
                    </c:if>
                    <c:if test="${page!=pagecount}">
                      <a onclick="refClick(${pagecount})">${pagecount}</a>
                    </c:if>
                  </li>
                </c:forEach>
                <li class="<c:if test="${page==maxPage}" >disabled</c:if>">
                  <c:if test="${page!=maxPage}">
                    <a onclick="refClick(${page+1})">»</a>
                  </c:if>
                  <c:if test="${page==maxPage}">
                    <a href="javascript:void(0);">»</a>
                  </c:if>
                </li>
              </ul>
            </div>

          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@ include file="../common/footer_and_fastnav.jsp"%>
<script>
  var disable_user_url = '<c:url value="/user/edit/disable/"/>';
  var enable_user_url = '<c:url value="/user/edit/enable/"/>';
  var list_url = '<c:url value="/user/list"/>';

  var role_id = '${roleid}';
  $('.user-checkall').click(function() {
    $(this).closest('table').find("input[type=checkbox]:not(:disabled)").prop('checked', this.checked);
  });
  var delete_user_url = '<c:url value="/user/edit/disable/batch"/>';
  $('a[data-toggle=tooltip]').tooltip();

  $('.delete_users_batch').click(function(){
    var str = new Array();
    $("input:checkbox[name=uid]:checked").each(function() {
      str.push($(this).val());
    });
    b = str.join(",");
    if (b == '') {
      bootbox.alert('请选择要禁用的组');
      return false;
    }
    $.post(delete_user_url, {'uid' : b}, function(data) {
      if (data > 0) {
        $("#resultText").text("禁用成功");
      } else {
        $("#resultText").text("禁用失败，请稍后再试");
      }
      $("#saveModal").modal("hide");
      $("#resultModal").modal("show");
    }, "json");
  });

  $('.disable_user').click(function(){
    var val=$(this).closest("tr").find('input[name="uid"]').val();
    if($(this).closest("li.disabled").length==1){
    }else{
      $.post(disable_user_url+ val,{ 'uid':val }, function(data) {
        if (data > 0) {
          $("#resultText").text("禁用成功");
          tr = $("tr[data-uid='" + val + "']");
          $(tr).find("td:first input").prop('disabled', true);
          $(tr).find("td:eq(5) i").removeClass("jh_ico_right").addClass("jh_ico_disabled");
          $(tr).find("td ul li:eq(1)").addClass("disabled");
          $(tr).find("td ul li:eq(2)").removeClass("disabled");
        } else {
          $("#resultText").text("禁用失败，请稍后再试");
        }
        $("#saveModal").modal("hide");
        $("#resultModal").modal("show");
      }, "json");
    }
  });

  $('.enable_user').click(function(){
    var val=$(this).closest("tr").find('input[name="uid"]').val();
    if($(this).closest("li.disabled").length==1){
    }else{
      $.post(enable_user_url+ val,{ 'uid':val }, function(data) {
        if (data > 0) {
          $("#resultText").text("操作成功");
          tr = $("tr[data-uid='" + val + "']");
          $(tr).find("td:first input").prop('disabled', false);
          $(tr).find("td:eq(5) i").removeClass("jh_ico_disabled").addClass("jh_ico_right");
          $(tr).find("td ul li:eq(1)").removeClass("disabled");
          $(tr).find("td ul li:eq(2)").addClass("disabled");
        } else {
          $("#resultText").text("操作失败，请稍后再试");
        }
        $("#saveModal").modal("hide");
        $("#resultModal").modal("show");
      }, "json");
    }
  });
  function refClick(pagecount){
    var role = '';
    if(role_id && role_id != ''){
      role = '&roleid='+role_id;
    }
    $('#user_search').attr("action", '<c:url value="/user/list?page="/>' + pagecount+role);
    $("#user_search").submit();
  }
</script>
<%@ include file="../common/stat.jsp"%>
</body>
</html>
