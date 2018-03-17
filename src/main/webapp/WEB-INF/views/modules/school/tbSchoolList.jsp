<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学院信息管理</title>
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
		<li class="active"><a href="${ctx}/school/tbSchool/">学院信息列表</a></li>
		<shiro:hasPermission name="school:tbSchool:edit"><li><a href="${ctx}/school/tbSchool/form">学院信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbSchool" action="${ctx}/school/tbSchool/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>院系名称：</label>
				<form:input path="departmentName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>院系id</th>
				<th>院系名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="school:tbSchool:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbSchool">
			<tr>
				<td><a href="${ctx}/school/tbSchool/form?id=${tbSchool.id}">
					${tbSchool.id}
				</a></td>
				<td>
					${tbSchool.departmentName}
				</td>
				<td>
					<fmt:formatDate value="${tbSchool.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbSchool.remarks}
				</td>
				<shiro:hasPermission name="school:tbSchool:edit"><td>
    				<a href="${ctx}/school/tbSchool/form?id=${tbSchool.id}">修改</a>
					<a href="${ctx}/school/tbSchool/delete?id=${tbSchool.id}" onclick="return confirmx('确认要删除该学院信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>