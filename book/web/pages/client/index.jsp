<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		//加载
		$(function () {
			//绑定点击事件
			$("button.cart").click(function () {
				var bookId = $(this).attr("bookId");
				// location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;
				$.getJSON(
						"http://localhost:8080/book/cartServlet",
						"action=ajaxAddItem&id=" + bookId,
						function (data){
							$("#cart_totalCount").text("您的购物车中有" + data.totalCount + "件商品");
							$("#cart_lastName").text(data.lastName);
						}
				);
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user.username }">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>

				<c:if test="${not empty sessionScope.user.username }">
					<span>欢迎<span class="um_span">${ sessionScope.user.username }</span>光临尚硅谷书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>

				 &nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="${requestScope.page.url}" method="get">
					<input type="hidden" name="action" value="pageForPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">

				<c:if test="${empty sessionScope.lastName}">
					<span id="cart_totalCount"></span>
					<div>
						您刚刚将<span style="color: red" id="cart_lastName">购物车是空的</span>加入到了购物车中
					</div>
				</c:if>

				<c:if test="${not empty sessionScope.lastName}">
					<span id="cart_totalCount">                       </span>
					<div>
						您刚刚将<span style="color: #ff0000" id="cart_lastName">   </span>加入到了购物车中
					</div>
				</c:if>

			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="cart" bookId="${book.id}">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
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


	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>