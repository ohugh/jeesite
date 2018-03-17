<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回复信息管理</title>
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
		<li class="active"><a href="${ctx}/question/tbQuestions/">回复信息列表</a></li>
		<shiro:hasPermission name="question:tbQuestions:edit"><li><a href="${ctx}/question/tbQuestions/form">回复信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbQuestions" action="${ctx}/question/tbQuestions/" method="post" class="breadcrumb form-search">
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
				<th>提问id</th>
				<th>回复表id</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="question:tbQuestions:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbQuestions">
			<tr>
				<td><a href="${ctx}/question/tbQuestions/form?id=${tbQuestions.id}">
					${tbQuestions.questionId}
				</a></td>
				<td>
					${tbQuestions.messageId}
				</td>
				<td>
					<fmt:formatDate value="${tbQuestions.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbQuestions.remarks}
				</td>
				<shiro:hasPermission name="question:tbQuestions:edit"><td>
    				<a href="${ctx}/question/tbQuestions/form?id=${tbQuestions.id}">修改</a>
					<a href="${ctx}/question/tbQuestions/delete?id=${tbQuestions.id}" onclick="return confirmx('确认要删除该回复信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>