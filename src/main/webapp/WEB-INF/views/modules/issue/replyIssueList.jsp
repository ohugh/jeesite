<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>问题信息管理</title>
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
		<li class="active"><a href="${ctx}/issue/tbIssue/">解答问题列表</a></li>
		
	</ul>
	<form:form id="searchForm" modelAttribute="tbIssue" action="${ctx}/issue/tbIssue/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="issueTitle" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:select path="issueStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('issue')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>状态</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="issue:tbIssue:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbIssue">
			<tr>
				<td><a href="${ctx}/issue/tbIssue/form?id=${tbIssue.id}">
					${tbIssue.issueTitle}
				</a></td>
				<td>
					${fns:getDictLabel(tbIssue.issueStatus, 'issue', '')}
				</td>
				<td>
					<fmt:formatDate value="${tbIssue.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbIssue.remarks}
				</td>
				<shiro:hasPermission name="issue:tbIssue:edit"><td>
    				<a href="${ctx}/issue/tbIssue/replyform?id=${tbIssue.id}">解答</a>
					<a href="${ctx}/issue/tbIssue/delete?id=${tbIssue.id}" onclick="return confirmx('确认要删除该问题信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>