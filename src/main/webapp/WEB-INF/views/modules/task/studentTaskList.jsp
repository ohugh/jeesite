<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>作业信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/task/tbTask/">作业信息列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tbTask" action="${ctx}/task/tbTask/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>作业题目：</label>
				<form:input path="taskTitle" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>hhaohao</th>
				<th>发布班级</th>
				<th>创建老师id</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="task:tbTask:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbTask">
			<tr>
				<td><a href="${ctx}/task/tbTask/form?id=${tbTask.id}">
					${tbTask.taskTitle}
				</a></td>
				<td>
					${fns:getDictLabel(tbTask.taskClass, '', '')}
				</td>
				<td>
					${tbTask.taskCreateId}
				</td>
				<td>
					<fmt:formatDate value="${tbTask.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbTask.remarks}
				</td>
				<shiro:hasPermission name="task:tbTask:edit"><td>
    				<a href="${ctx}/task/tbTasdasdasdasskform?id=${tbTask.id}">提交作业</a>
					<a href="${ctx}/task/tbTask/delete?id=${tbTask.id}" onclick="return confirmx('确认要删除该作业信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>