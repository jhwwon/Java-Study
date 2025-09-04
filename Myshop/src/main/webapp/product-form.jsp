<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="shop.Product" %>

<!-- 간단 헤더 (include 대신 직접 작성) -->
<header>
  <h2>MyShop 물류관리</h2>
  <hr/>
</header>

<main>
  <%
    Product p = (Product) request.getAttribute("product");
    boolean editing = (p != null && p.getId() != null);

    // 값 바인딩을 변수로 분리하면 따옴표 충돌/파싱 오류를 피할 수 있습니다.
    String nameVal = editing ? p.getName() : "";
    int priceVal = editing ? p.getPrice() : 0;
    int qtyVal   = editing ? p.getQuantity() : 0;
  %>

  <form action="product" method="post">
    <input type="hidden" name="action" value="<%= editing ? "update" : "create" %>" />
    <% if (editing) { %>
      <input type="hidden" name="id" value="<%= p.getId() %>" />
    <% } %>

    <div>
      <label>이름:
        <input type="text" name="name" value="<%= nameVal %>" />
      </label>
    </div>

    <div>
      <label>가격:
        <input type="number" name="price" value="<%= priceVal %>" />
      </label>
    </div>

    <div>
      <label>수량:
        <input type="number" name="quantity" value="<%= qtyVal %>" />
      </label>
    </div>

    <button type="submit"><%= editing ? "수정" : "등록" %></button>
  </form>
</main>

<!-- 간단 푸터 (include 대신 직접 작성) -->
<hr/>
<footer>
  <small>© Myshop</small>
</footer>
