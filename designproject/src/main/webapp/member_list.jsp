<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.company1.DBManager" %>
<%@ page import="java.sql.*, java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체보기</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e9ecef;
        margin: 0;
        padding: 40px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .list-container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 1000px;
        text-align: center;
    }
    h2 {
        color: #495057;
        margin-bottom: 30px;
        font-size: 2em;
        font-weight: 600;
        border-bottom: 2px solid #007bff;
        padding-bottom: 10px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 30px;
    }
    th, td {
        border: 1px solid #dee2e6;
        padding: 15px;
        text-align: center;
    }
    th {
        background-color: #007bff;
        color: white;
        font-weight: 700;
    }
    tr:nth-child(even) {
        background-color: #f8f9fa;
    }
    .action-btn {
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        color: white;
        text-decoration: none;
        display: inline-block;
        margin: 0 5px;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }
    .edit-btn {
        background-color: #28a745;
    }
    .delete-btn {
        background-color: #dc3545;
    }
    .action-btn:hover {
        opacity: 0.9;
        transform: scale(1.05);
    }
    .pagination {
        margin-top: 20px;
    }
    .pagination a {
        color: #007bff;
        text-decoration: none;
        padding: 8px 16px;
        border: 1px solid #ddd;
        margin: 0 4px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }
    .pagination a.active {
        background-color: #007bff;
        color: white;
        border: 1px solid #007bff;
    }
    .pagination a:hover:not(.active) {
        background-color: #e2e6ea;
    }
    .back-link {
        display: inline-block;
        margin-top: 30px;
        padding: 12px 25px;
        background-color: #6c757d;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }
    .back-link:hover {
        background-color: #5a6268;
    }
</style>
<script>
    function confirmDelete(id) {
        if (confirm("정말로 " + id + " 회원을 삭제하시겠습니까?")) {
            // ID 값을 URL로 보내기 전에 encodeURIComponent로 인코딩
            location.href = 'member_delete.jsp?id=' + encodeURIComponent(id);
        }
    }
</script>
</head>
<body>
    <div class="list-container">
        <h2>회원 전체보기</h2>

<%
    // 페이징 변수 설정
    int numPerPage = 5; // 한 페이지에 5명씩
    int totalRecord = 0; // 전체 회원 수
    int totalPage = 0;   // 전체 페이지 수
    int cPage = 1;       // 현재 페이지

    // 현재 페이지 정보 가져오기 (파라미터가 없으면 1페이지)
    String cPageStr = request.getParameter("cPage");
    if (cPageStr != null) {
        cPage = Integer.parseInt(cPageStr);
    }

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = DBManager.getDBConnection();

        // 1. 전체 회원 수 구하기
        String countSql = "SELECT COUNT(*) FROM membertable";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(countSql);
        if (rs.next()) {
            totalRecord = rs.getInt(1);
        }
        
        // 2. 전체 페이지 수 계산
        totalPage = (int) Math.ceil((double)totalRecord / numPerPage);

        // 3. 현재 페이지에 해당하는 데이터만 가져오는 쿼리 (Oracle ROWNUM 사용)
        int start = (cPage - 1) * numPerPage + 1;
        int end = cPage * numPerPage;
        
        String sql = "SELECT ID, NAME, GRADE, REGDATE FROM (SELECT ROWNUM as rnum, ID, NAME, GRADE, REGDATE FROM membertable ORDER BY REGDATE DESC) WHERE rnum BETWEEN " + start + " AND " + end;
        
        rs = stmt.executeQuery(sql);
%>
        <table>
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>등급</th>
                    <th>등록일</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
<%
        if (totalRecord == 0) {
            out.println("<tr><td colspan='5'>등록된 회원이 없습니다.</td></tr>");
        } else {
            while (rs.next()) {
                String memberId = rs.getString("ID");
                String memberName = rs.getString("NAME");
                String memberGrade = rs.getString("GRADE");
                Date regDate = rs.getDate("REGDATE");
%>
                <tr>
                    <td><%= memberId %></td>
                    <td><%= memberName %></td>
                    <td><%= memberGrade %></td>
                    <td><%= regDate %></td>
                    <td>
                        <a href="member_edit.jsp?id=<%= URLEncoder.encode(memberId, "UTF-8") %>" class="action-btn edit-btn">수정</a>
                        <a href="#" onclick="confirmDelete('<%= memberId %>')" class="action-btn delete-btn">삭제</a>
                    </td>
                </tr>
<%
            }
        }
%>
            </tbody>
        </table>
        
        <div class="pagination">
            <%
                for (int i = 1; i <= totalPage; i++) {
                    if (i == cPage) {
            %>
                        <a class="active"><%= i %></a>
            <%
                    } else {
            %>
                        <a href="member_list.jsp?cPage=<%= i %>"><%= i %></a>
            <%
                    }
                }
            %>
        </div>
        <a href="main.jsp" class="back-link">메인으로 돌아가기</a>
<%
    } catch (SQLException e) {
        out.println("<div class='list-container'>SQL 오류가 발생했습니다: " + e.getMessage() + "</div>");
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
    </div>
</body>
</html>