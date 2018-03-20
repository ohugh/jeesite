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
		<li><a href="${ctx}/task/tbTask/studentTasklist/">作业信息列表</a></li>
		<li class="active"><a href="${ctx}/task/tbTask/studentTaskform?id=${tbTask.id}">提交作业<shiro:hasPermission name="task:tbTask:edit"></shiro:hasPermission><shiro:lacksPermission name="task:tbTask:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tbTask" action="${ctx}/task/tbTask/studentTasksave" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">作业题目：</label>
			<div class="controls">
				<form:input path="taskTitle" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
				<!-- 
					<form:checkboxes path="taskClass" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
			 	-->
		
		<div class="control-group">
			<label class="control-label">作业内容：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		
		<form:hidden path="taskCreateId" value="${taskCreateId}"/>
		
		<div class="control-group">
			<label class="control-label">选择作业：</label>
			<div class="controls">
				<form:hidden id="taskFile" path="taskFile" htmlEscape="false" class="input-xlarge"/>
				<sys:ckfinder input="taskFile" type="files" uploadPath="/task/tbTask" selectMultiple="true"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="task:tbTask:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="取 消" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>