<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="../common/common.jsp"%>
  <title>员工信息</title>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="jh_content">
  <div class="row-fluid">
    <div class="span12">
      <div class="jh_moreContent">
        <div class="jh_addBox">
          <form class="form-horizontal" id="form" data-id="${employee.id }">
            <div class="jh_qf_box">
              <h5>员工信息 <a href="#" class="jh_editor03"><i class="icon-wrench margin"></i><span>编辑</span></a></h5>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">姓名：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${employee.name}</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">姓名：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="name" name="name" value="${employee.name}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">员工号：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${employee.jobNumber }</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">员工号：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="jobNumber" name="jobNumber" value="${employee.jobNumber}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
                <div class="control-group jh_form02 displayItem">
                    <label class="control-label muted">性别：</label>
                    <div class="controls">
									<span class="uneditable-input jh_uneditableInput">
										<span>${employee.gender?'男':'女' }</span>
									</span>
                    </div>
                </div>
                <div class="control-group jh_form02 hide hideItem">
                    <label class="control-label muted">性别：</label>
                    <div class="controls">
                        <label class="radio inline">
                            <input type="radio" name="gender" value="true" ${employee.gender?'checked':'' }/> 男
                        </label>
                        <label class="radio inline">
                            <input type="radio" name="gender" value="false" ${employee.gender?'':'checked' }/> 女
                        </label>
                    </div>
                </div>

              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">职位：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${employee.position}</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">职位：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="position" name="position" value="${employee.position}" />
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">所属部门：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${employee.org}</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">所属部门：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="org" name="org" value="${employee.org}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">邮箱：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${employee.email }</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">邮箱：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="email" name="email" value="${employee.email}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">电话：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">
										<span>${employee.mobile }</span>
									</span>
                </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">电话：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="mobile" name="mobile" value="${employee.mobile}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="control-group jh_form02 displayItem">
                <label class="control-label muted">出生日期：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <span id="phoneSpan" data-phone="${employee.birthday }">${employee.birthday}</span>
                                    </span>
                </div>
                  <div class="input-append jh_b_pad01">
                      <div class="input-append date form_datetime controls" data-type="date" id="date-birthday">
                          <fmt:formatDate value="${employee.birthday}" type="date" pattern="yyyy-MM-dd" var="theFormattedBirthday" />
                          <fmt:formatDate value="${nowDate}" type="date" pattern="yyyy-MM-dd" var="nowDate" />
                          <input id="birthday" size="10" data-format="yyyy-MM-dd" readonly="true" placeholder="请选择签约日期" required="true" value="${theFormattedBirthday==null?nowDate:theFormattedBirthday }" />
                          <span class="add-on"><i class="icon-calendar"></i></span>
                          <i class="validate-success"></i>
                          <span class="text-info"></span>
                          <span class="text-error"><i></i></span>
                      </div>
                  </div>
              </div>
              <div class="control-group jh_form02 hide hideItem">
                <label class="control-label muted">出生日期：</label>
                <div class="controls">
                                    <span class="uneditable-input jh_uneditableInput">
                                        <input type="text" id="birthday" name="birthday" value="${employee.birthday}"/>
                                        <i class="validate-success"></i>
                                        <span class="text-error"><i></i></span>
                                    </span>
                </div>
              </div>
              <div class="jh_b_mar01 text-center hide hideItem">
                <button type="button" class="btn jh_r_mar01 hide cancel" style="display: inline-block;">取消</button>
                <button type="submit" class="btn btn-primary hide submit" style="display: inline-block;">保存</button>
              </div>
            </div>
            <div class="jh_qf_box">
              <h5>权限信息</h5>
              <div class="alert">
                <button class="close" data-dismiss="alert" type="button">×</button>
                如要申请权限，请联系管理员
              </div>
              <div class="control-group jh_form02">
                <label class="control-label muted">角色：</label>
                <div class="controls">
									<span class="uneditable-input jh_uneditableInput">	
										<span>${rolesforprofile }</span>
									</span>
                </div>
              </div>
            </div>
          </form>
        </div>
        <!--提交--></div>
    </div>
  </div>
</div>
<%@ include file="../common/footer_and_fastnav.jsp"%>
<script src="/js/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/validate/jquery.validate.min-1.17.0.js"></script>
<script src="/js/validate/messages_zh.js"></script>
<script type="text/javascript">
  var _user_update_url = '<c:url value="/emploeyee/update" />';
  $.validator.addMethod("pattern", function(value, element, params){
    if(value!=""){
      return new RegExp(params).test(value);
    }else{
      return true;
    }
  }, '格式错误');
  $('#form').validate({
    highlight: function(element, errorClass, validClass) {
      $(element).siblings('span.text-info').hide();
      $(element).siblings('i').removeClass('jh_ico_right').addClass("jh_ico_error");
    },
    unhighlight: function(element, errorClass, validClass) {
      $(element).closest('.control-group').removeClass('error');
      $(element).siblings('span.text-error').hide();
      $(element).siblings('i').removeClass('hide');
      $(element).siblings('i').removeClass('jh_ico_error').addClass("jh_ico_right");
      $(element).siblings('span.text-info').show();
    },
    success: function(label) {
      $(label).closest('.control-group').removeClass('error');
      $(label).find('span.text-error').hide();
      $(label).find('span.text-info').show();
      $(label).find('i').removeClass('jh_ico_error').addClass("jh_ico_right");
      $(label).find('span.text-info').text('');
    },
    errorPlacement: function(error, element) {
      $(element).closest('.control-group').addClass('error');
      $(element).siblings('span.text-info').hide();
      $(element).siblings('span.text-error').show();
      $(element).siblings('i').removeClass("hide");
      $(element).siblings('i').removeClass('jh_ico_right').addClass("jh_ico_error");
      $(element).siblings('span.text-error').text(error.text());
    },
    submitHandler: function(form) {
      bootbox.confirm('确认保存吗？', function(result){
        bootbox.hideAll();
        if(!result){
          return;
        }
        save();
      });
    }
  });
  $('a.jh_editor03').click(function(event){
    event.preventDefault();
    var text = $(this).find('span:last').text();
    if(text == '编辑') {
      $(this).closest('form').find('input, textarea, button, select').removeAttr('disabled');
      $(this).closest('form').find('.displayItem').hide();
      $(this).closest('form').find('.hideItem').show();
      $(form).find('.text-error').hide();
      $(form).find('.text-info').show();
      $(this).find('span').text('取消');
    }else{
      cancelEdit($(this).closest('form'));
    }
    return false;
  });
  function cancelEdit(form){
    resetForm(form);
    $(form).find('input, textarea, button, select').prop('disabled','true');
    $(form).find('.displayItem').show();
    $(form).find('.hideItem').hide();
    $(form).find('a.jh_editor03 span').text('编辑');
  }
  function resetForm(form){
    $(form)[0].reset();
    $(form).find('div.error').removeClass('error');
    $(form).find('.jh_ico_error').removeClass('jh_ico_error');
    $(form).find('.text-error').hide();
    $(form).find('.text-info').show();
  }
  $('.cancel').click(function(){
    cancelEdit($(this).closest('form'));
  });
  //$('.submit').click(function(){
  function save(){
    var phone = $('#phone').val();
    var form = $('#form');
    $.ajax({
      type: "POST",
      url: _user_update_url,
      data: {
        phone: phone
      },
      dataType: 'json',
      cache: false,
      beforeSend: function() {}
    }).done(function(data) {
      if (data.success) {
        bootbox.alert('保存成功！');
        form.find('input, textarea, button, select').prop('disabled','true');
        form.find('.displayItem').show();
        form.find('.hideItem').hide();
        form.find('a.jh_editor03 span').text('编辑');
      }else{
        bootbox.alert(data.exception);
        return;
      }
    }).fail(function(jqXHR, textStatus) {
      bootbox.alert("系统错误，请稍后再试");
    }).always(function() {});
  }
</script>
<%@ include file="../common/stat.jsp"%>
</body>
</html>