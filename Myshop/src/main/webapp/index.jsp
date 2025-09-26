<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="shop.AppConfig, shop.UiHelper"%>
<header>
	<h2><%=AppConfig.APP_TITLE%></h2>
	<div><%=UiHelper.flash(request)%></div>
	<hr />
</header>

<main>
	<a href="product?action=list">상품 관리로 이동</a>
</main>

<hr />
<footer>
	<small>© Myshop</small>
</footer>
