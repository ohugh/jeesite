<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生信息管理</title>
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
		<li class="active"><a href="${ctx}/student/tbStudent/">学生信息列表</a></li>
		<shiro:hasPermission name="student:tbStudent:edit"><li><a href="${ctx}/student/tbStudent/form">学生信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbStudent" action="${ctx}/student/tbStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生账号：</label>
				<form:input path="account" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>学生账号</th>
				<th>学生姓名</th>
				<th>性别</th>
				<th>身份标识</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="student:tbStudent:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbStudent">
			<tr>
				<td><a href="${ctx}/student/tbStudent/form?id=${tbStudent.id}">
					${tbStudent.account}
				</a></td>
				<td>
					${tbStudent.studentName}
				</td>
				<td>
					${fns:getDictLabel(tbStudent.sex, 'sex', '')}
				</td>
				<td>
					${tbStudent.identity}
				</td>
				<td>
					<fmt:formatDate value="${tbStudent.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbStudent.remarks}
				</td>
				<shiro:hasPermission name="student:tbStudent:edit"><td>
    				<a href="${ctx}/student/tbStudent/form?id=${tbStudent.id}">修改</a>
					<a href="${ctx}/student/tbStudent/delete?id=${tbStudent.id}" onclick="return confirmx('确认要删除该学生信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>