<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>教师信息管理</title>
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
		<li class="active"><a href="${ctx}/teacher/tbTeacher/">教师信息列表</a></li>
		<shiro:hasPermission name="teacher:tbTeacher:edit"><li><a href="${ctx}/teacher/tbTeacher/form">教师信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbTeacher" action="${ctx}/teacher/tbTeacher/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="teacherName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>账号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>身份标识</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="teacher:tbTeacher:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbTeacher">
			<tr>
				<td><a href="${ctx}/teacher/tbTeacher/form?id=${tbTeacher.id}">
					${tbTeacher.account}
				</a></td>
				<td>
					${tbTeacher.teacherName}
				</td>
				<td>
					${fns:getDictLabel(tbTeacher.sex, 'sex', '')}
				</td>
				<td>
					${tbTeacher.identity}
				</td>
				<td>
					<fmt:formatDate value="${tbTeacher.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbTeacher.remarks}
				</td>
				<shiro:hasPermission name="teacher:tbTeacher:edit"><td>
    				<a href="${ctx}/teacher/tbTeacher/form?id=${tbTeacher.id}">修改</a>
					<a href="${ctx}/teacher/tbTeacher/delete?id=${tbTeacher.id}" onclick="return confirmx('确认要删除该教师信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>