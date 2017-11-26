<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="../common/common.jsp"%>
  <title>员工列表-编辑员工</title>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<!--面包屑-->
<div class="jh_content">
  <ul class="breadcrumb">
    <li><a href="<c:url value="/employee/epm_list"/>">员工列表</a> <span
            class="divider">></span></li>
    <li class="active">编辑员工</li>
  </ul>
</div>

<div id="resultModal" class="modal hide" role="dialog">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"
            aria-hidden="true">&times;</button>
    <h3>操作结果</h3>
  </div>
  <div class="modal-body">
    <div class="control-group">
      <label class="control-label"><span id="resultText"></span> </label>
    </div>
  </div>
  <div class="modal-footer"><a href="<c:url value="/employee/epm_list"/>" class="btn primary">OK</a></div>
</div>
<!--content-->
<form class="form-horizontal" id="form_emp">
  <div class="jh_content">
    <div class="row-fluid">
      <div class="span12">
        <div class="jh_moreContent">
          <div class="jh_mcTit">编辑员工</div>
            <div class="jh_addBox">
              <ul class="nav nav-tabs" id="myTab">
                <li><a data-toggle="tab" href="#basicInfo" id="basicInfoTab">基本信息</a></li>
                <li class="active"><a data-toggle="tab" href="#role" id="roleTab">角色分配</a></li>
              </ul>
              <div id="myTabContent" class="tab-content jh_overflowVisible">
                <div id="basicInfo" class="tab-pane fade">
                  <!--基本信息-->
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">员工号：</label>
                    <div class="controls">
                      <input id="uid" type="text" value="${employee.jobNumber}" name="uid"  />
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">姓名：</label>
                    <div class="controls">
                      <input type="text" value="${employee.name}"  />
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">邮箱：</label>
                    <div class="controls">
                      <input type="text" value="${employee.email}"  />
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">所属部门：</label>
                    <div class="controls">
                      <input type="text" value="${employee.org}"  />
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">电话：</label>
                    <div class="controls">
                      <input type="text" value="${employee.mobile}"  />
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">职级：</label>
                    <div class="controls">
                      <input type="text" value="${employee.position}" name="position" />
                      <i class="jh_ico_error hide"></i>
                      <span class="text-error"></span>
                    </div>
                  </div>
                  <div class="control-group jh_form02">
                    <label class="control-label" for="inputEmail">状态：</label>
                    <div class="controls">
                      <label class="radio inline"><input type="radio" name="status" value="1" <c:if test="${users.status==true}">checked</c:if>/> 有效</label>
                      <label class="radio inline"><input type="radio" name="status" value="0" <c:if test="${users.status==false}">checked</c:if>/> 禁用</label>
                    </div>
                  </div>
                </div>
                <div id="role" class="tab-pane active">
                  <!--角色分配-->

                  <div class="alert jh_t_mar02 pending_opoition" id="cur_roles">
                    当前角色：
                    <c:forEach var="role" items="${roles}">
                      <strong class="text-info opoition_link" urId="${role.id}"
                              data-rid="${role.id}" value="${role.id}"
                              name="curRole"> ${role.name}<a
                              href="javascript:void(0)"><i
                              class="icon-minus-sign margin"></i></a>
                      </strong>
                    </c:forEach>
                  </div>
                  <div class="jh_qf_box">
                    <h5><input type="checkbox" class="role-checkall" name="chk_all_role" />全选</h5>
                    <div class="jh_b_mar01">
                      <c:forEach var="role" items="${roles}">
                        <label class="checkbox inline">
                          <td><input type="checkbox" name="role" value="${role.id}" data-name="${role.name}" />${role.name}</td>
                        </label>
                      </c:forEach>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          <div class="jh_qf_btn" id="update_emp_button">
            <button class="btn btn-primary btn-large" type="button" id="update_emp">确认提交</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
<%@ include file="../common/footer_and_fastnav.jsp"%>
<script src="/js/validate/jquery.validate.min-1.17.0.js"></script>
<script src="/js/validate/messages_zh.js"></script>
<jwr:script src="/js/bundle/base.js" />
<script>
  var _updateUserUrl = '<c:url value="/emp/edit"/>';
  $(document).ready(function(){
    //绑定动态生成代码事件
    $(document).on('click',$('cur_roles').find('a'),function(e){
      $('#role').find("input[name='role'][value='"+ $(e.target).closest('strong').data('rid')+ "']").attr('checked', false);
      $(e.target).closest('strong').remove();
    });
  });
  $(function() {
    var hash = window.location.hash.substring(1);
    $("input[type='checkbox']").prop('checked', false);

    $.each($("#cur_roles").find("strong"), function() {
      $("#role").find("input[name='role'][value='" + $(this).data("rid") + "']").prop('checked', true);
    });

    $('#role').find('input[name="role"]').click(function() {
      if ($(this).prop('checked')) {
        $('#cur_roles').append('<strong class="text-info" id="_role_toadd_'+ $(this).val()+ '" data-rid="'+ $(this).val() +'">'+ $(this).data('name')
        + '<a href="javascript:void(0)"><i class="icon-minus-sign margin"></i></a>'+ '</strong>');
        $('#cur_roles').find('a').click(function() {
          $(this).closest('strong').remove();
        });
      } else {
        $('#cur_roles').find("strong[value='" + $(this).val()+ "']").remove();
        $('#_role_toadd_' + $(this).val()).remove();
      }
    });


    });
    $('.role-checkall').click(function() {
      if ($(this).prop('checked')) {
        $('#cur_roles').find("strong").remove();
        $('#role').find('input[name="role"]')
                .prop('checked', true);
        $.each($("#role").find('input[name="role"]'),function() {
          $('#cur_roles').append('<strong class="text-info" id="_role_toadd_'+ $(this).val()+ '" data-rid="'+ $(this).val() +'">'+ $(this).data('name')
          + '<a href="javascript:void(0)"><i class="icon-minus-sign margin"></i></a>'+ '</strong>');
        });
      } else {
        $('#role').find('input[name="role"]').prop('checked', false);
        $('#cur_roles').find("strong").remove();
      }
    });
    $('#update_emp').click(function(){
      $('#myTab li:eq(0) a').tab('show');
      if ($("#form_emp").valid() == false) {
        return;
      }

      var roles = new Array();
      $("input:checkbox[name=role]:checked").each(function() {
        roles.push($(this).val());
      });
      roleStr = roles.join(",");
      var u = $('#basicInfo').find('input[name="uid"]').val();
      var position = $('#basicInfo').find('input[name="position"]').val();
      var status = $('#basicInfo').find('input[name="status"]:checked').val();
      $.post(_updateUserUrl, {
        'rid' : roleStr,
        'uid' : u,
        'position' : position,
        'status' : status
      }, function(data) {
        if (data > 0) {
          $("#resultText").text("更新成功");
        } else {
          $("#resultText").text("更新失败，请稍后再试");
        }
        $("#saveModal").modal("hide");
        $("#resultModal").modal("show");
      }, "json");
    });

    //验证用
//    $("#form_emp").validate({
//      rules:{
//        'position' : {
//          required: true,
//          number: true
//        }
//      },
//      messages: {
//        'position': {
//          required: "",
//          number: "",
//          range: ""
//        }
//      },
//      highlight: function(element, errorClass, validClass) {
//        $(element).siblings('i').removeClass('jh_ico_right').addClass("jh_ico_error");
//      },
//      unhighlight: function(element, errorClass, validClass) {
//        $(element).closest('.control-group').removeClass('error');
//        $(element).siblings('span.text-error').hide();
//        $(element).siblings('i').removeClass('hide');
//        $(element).siblings('i').removeClass('jh_ico_error').addClass("jh_ico_right");
//      },
//      success: function(label) {
//        $(label).closest('.control-group').removeClass('error');
//        $(label).find('span.text-error').hide();
//        $(label).find('i').removeClass('jh_ico_error').addClass("jh_ico_right");
//        $(label).find('span.text-info').text('');
//      },
//      errorPlacement: function(error, element) {
//        $(element).closest('.control-group').addClass('error');
//        $(element).siblings('span.text-error').show();
//        $(element).siblings('i').removeClass("hide");
//        $(element).siblings('i').removeClass('jh_ico_right').addClass("jh_ico_error");
//        $(element).siblings('span.text-error').text(error.text());
//      }
//    });
//  });

</script>
<%@ include file="../common/stat.jsp"%>
</body>
</html>
