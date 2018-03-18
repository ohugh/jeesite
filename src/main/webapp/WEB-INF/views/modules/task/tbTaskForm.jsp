<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

<head>
	<title>作业信息管理</title>
	<meta name="decorator" content="default"/>
		
	<script type="text/javascript">
	

		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/task/tbTask/">作业信息列表</a></li>
		<li class="active"><a href="${ctx}/task/tbTask/form?id=${tbTask.id}">作业信息<shiro:hasPermission name="task:tbTask:edit">${not empty tbTask.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="task:tbTask:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tbTask" action="${ctx}/task/tbTask/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">作业题目：</label>
			<div class="controls">
				<form:input path="taskTitle" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布班级：</label>
			<div class="controls">
			  <form:select path="taskClass">
				<form:option value="null" label="请选择         " />
                   <form:options items="${classNameList}" />
			  </form:select>
			  <span class="help-inline"><font color="red">*</font> </span>
			</div>
  		</div>
		<form:hidden path="teacherid" value="${teacherId}"/>
		
		<div class="control-group">
			<label class="control-label">作业内容：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="task:tbTask:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="发 布"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="取 消" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>