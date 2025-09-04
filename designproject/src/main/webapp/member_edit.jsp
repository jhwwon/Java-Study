<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.company1.DBManager" %>

<%
    request.setCharacterEncoding("UTF-8");
    String memberId = request.getParameter("id");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String name = "";
    String password = "";
    int point = 0;
    String grade = "";

    if (memberId != null) {
        try {
            conn = DBManager.getDBConnection();
            String sql = "SELECT NAME, PASSWORD, POINT, GRADE FROM membertable WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                name = rs.getString("NAME");
                password = rs.getString("PASSWORD");
                point = rs.getInt("POINT");
                grade = rs.getString("GRADE");
            }
        } catch (SQLException e) {
            out.println("<script>alert('회원 정보를 불러오는 중 오류가 발생했습니다.'); history.back();</script>");
            return;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e9ecef;
        margin: 0;
        padding: 40px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    }
    .edit-container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 500px;
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
    form p {
        text-align: left;
        margin-bottom: 15px;
    }
    input[type="text"],
    input[type="password"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ced4da;
        border-radius: 5px;
        box-sizing: border-box;
        margin-top: 5px;
    }
    input[readonly] {
        background-color: #e9ecef;
        cursor: not-allowed;
    }
    button[type="submit"] {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 5px;
        background-color: #007bff;
        color: #fff;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
        margin-top: 20px;
    }
    button[type="submit"]:hover {
        background-color: #0056b3;
    }
    .back-link {
        display: block;
        margin-top: 20px;
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }
</style>
</head>
<body>
    <div class="edit-container">
        <h2>회원 정보 수정</h2>
        <form action="member_update_process.jsp" method="post">
            <p>아이디: <input type="text" name="id" value="<%= memberId %>" readonly></p>
            <p>이름: <input type="text" name="name" value="<%= name %>" required></p>
            <p>비밀번호: <input type="password" name="password" value="<%= password %>" required></p>
            <p>포인트: <input type="number" name="point" value="<%= point %>" required oninput="if(this.value.length > 5) this.value = this.value.slice(0, 5);"></p>
            <p>등급: <input type="text" name="grade" value="<%= grade %>" readonly></p>
            <button type="submit">수정 완료</button>
        </form>
        <a href="member_list.jsp" class="back-link">목록으로 돌아가기</a>
    </div>
</body>
</html>