<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		//加载
		$(function () {
			$("a.deleteClass").click(function () {
				var find = $(this).parent().parent().find("td:first").text();
				return confirm("你确定删除"+find+"吗?");
			});
			$("input.searchOfBtn").click(function () {
				var pageNo = $("#pn_input").val();

				if (pageNo < 1 || pageNo > ${requestScope.page.pageTotal}){
					alert("没有此页面");
					return false;
				} else {
					location.href = "${pageContext.getAttribute("basepath")}manager/bookServlet?action=page&pageNum=" + pageNo;
				}

			});
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNum=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>

		<div id="page_nav">
			<c:if test="${requestScope.page.pageNum > 1 }">
				<a href="${requestScope.page.url}&pageNum=1">首页</a>
				<a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum - 1}">上一页</a>
			</c:if>

			<c:choose>
				<%--总页数小于等于五--%>
				<c:when test="${requestScope.page.pageTotal <= 5}">
					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
						<c:if test="${requestScope.page.pageNum == i}">
							${i}
						</c:if>
						<c:if test="${requestScope.page.pageNum != i}">
							<a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
						</c:if>
					</c:forEach>
				</c:when>
				<%--总页数大于五--%>
				<c:when test="${requestScope.page.pageTotal > 5}">
					<c:choose>
						<%--前三个位置--%>
						<c:when test="${requestScope.page.pageNum <= 3}">
							<c:forEach begin="1" end="5" var="i">
								<c:if test="${requestScope.page.pageNum == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNum != i}">
									<a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<%--后三个位置--%>
						<c:when test="${requestScope.page.pageNum > requestScope.page.pageTotal-3}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
								<c:if test="${requestScope.page.pageNum == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNum != i}">
									<a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<%--其他位置--%>
						<c:otherwise>
							<c:forEach begin="${requestScope.page.pageNum-2}" end="${requestScope.page.pageNum+2}" var="i">
								<c:if test="${requestScope.page.pageNum == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNum != i}">
									<a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>


			<c:if test="${requestScope.page.pageNum < requestScope.page.pageTotal }">
				<a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum + 1}">下一页</a>
				<a href="${requestScope.page.url}&pageNum=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${param.pageNum}" name="pn" id="pn_input"/>页
			<input class="searchOfBtn" type="button" value="确定">
		</div>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>