<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List, shop.Product"%>

<!-- 간단 헤더 -->
<header>
	<h2>MyShop 물류관리</h2>
	<hr />
</header>

<main>
	<form method="get" action="product" style="margin-bottom: 8px;">
		<input type="hidden" name="action" value="search" /> <input
			type="text" name="q"
			value="<%=request.getAttribute("q") == null ? "" : request.getAttribute("q")%>"
			placeholder="상품명 검색" />
		<button type="submit">검색</button>
		<a href="product?action=list">전체보기</a>
	</form>
	<a href="product?action=new">상품 등록</a>
	<table border="1" cellpadding="6">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>가격</th>
			<th>수량</th>
			<th>작업</th>
		</tr>
		<%
		List<Product> list = (List<Product>) request.getAttribute("products");
		if (list != null) {
			for (Product p : list) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getQuantity()%></td>
			<td><a href="product?action=edit&id=<%=p.getId()%>">수정</a>
				<form action="product" method="post" style="display: inline">
					<input type="hidden" name="action" value="delete" /> <input
						type="hidden" name="id" value="<%=p.getId()%>" />
					<button type="submit">삭제</button>
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</main>

<!-- 간단 푸터 -->
<hr />
<footer>
	<small>© Myshop</small>
</footer>
