<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//绑定
			$("a.delete").click(function () {
				var text = $(this).parent().parent().find("td:first").text();
				return confirm("是否确认删除" + text);
			})

			$("a.clear").click(function () {
				return confirm("是否清空购物车");
			})

			$(".update").change(function () {
				if (confirm("是否将" + $(this).parent().parent().find("td:first").text() + "的数量修改为" + this.value) ){
					//确认修改，跳转回
					var bookId = $(this).attr("bookId");

					location.href = "cartServlet?action=update&count=" + $(this).val() + "&id=" + bookId;
				}else {
					this.value = this.defaultValue;
				}
			})

		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

			<%@include file="/pages/common/success.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${sessionScope.cart.items}" var="book">
				<tr>
					<td>${book.value.name}</td>
					<td>
						<input class="update" bookId="${book.value.id}" style="width: 70px;" type="text" value="${book.value.count}">
					</td>
					<td>${book.value.price}</td>
					<td>${book.value.totalPrice}</td>
					<td><a class="delete" href="cartServlet?action=deleteItem&id=${book.value.id}">删除</a></td>
				</tr>
			</c:forEach>

		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clear" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

		<c:if test="${empty sessionScope.cart.items}">
			<div align="center">
				<a href="index.jsp">购物车没东西</a>
			</div>
		</c:if>



	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>