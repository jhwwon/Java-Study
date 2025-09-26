<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .main-container {
        background-color: #fff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 300px;
    }
    h2 {
        color: #333;
        margin-bottom: 30px;
    }
    ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    li {
        margin-bottom: 15px;
    }
    a {
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        padding: 12px 24px;
        border-radius: 5px;
        font-weight: bold;
        display: block;
        transition: background-color 0.3s ease;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="main-container">
        <h2>메인 메뉴</h2>
        <ul>
            <li><a href="register.jsp">회원가입</a></li>
            <li><a href="member_list.jsp">회원 전체보기</a></li>
        </ul>
    </div>
</body>
</html>