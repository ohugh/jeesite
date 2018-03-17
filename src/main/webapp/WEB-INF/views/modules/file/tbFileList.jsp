<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>文件管理</title>
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
		<li class="active"><a href="${ctx}/file/tbFile/">文件列表</a></li>
		<shiro:hasPermission name="file:tbFile:edit"><li><a href="${ctx}/file/tbFile/form">文件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbFile" action="${ctx}/file/tbFile/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>文件名称</th>
				<th>文件类型</th>
				<th>文件路径</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="file:tbFile:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbFile">
			<tr>
				<td><a href="${ctx}/file/tbFile/form?id=${tbFile.id}">
					${tbFile.fileTitle}
				</a></td>
				<td>
					${tbFile.fileIden}
				</td>
				<td>
					${tbFile.filePath}
				</td>
				<td>
					<fmt:formatDate value="${tbFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbFile.remarks}
				</td>
				<shiro:hasPermission name="file:tbFile:edit"><td>
    				<a href="${ctx}/file/tbFile/form?id=${tbFile.id}">修改</a>
					<a href="${ctx}/file/tbFile/delete?id=${tbFile.id}" onclick="return confirmx('确认要删除该文件吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>