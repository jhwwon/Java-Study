<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    }
    .register-container {
        background-color: #fff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 350px;
    }
    h2 {
        color: #333;
        margin-bottom: 30px;
    }
    p {
        text-align: left;
        margin-bottom: 15px;
        font-weight: bold;
    }
    input[type="text"],
    input[type="password"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-top: 5px;
    }
    button[type="submit"] {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 4px;
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
</style>
<script>
    function validateForm() {
        const id = document.forms["registerForm"]["id"].value;
        const idRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+|~-]).{1,8}$/;
        
        if (!idRegex.test(id)) {
            alert("아이디는 영문자와 특수문자를 모두 포함해야 합니다.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
    <div class="register-container">
        <h2>회원가입</h2>
        <form name="registerForm" action="register_process.jsp" method="post" onsubmit="return validateForm()">
            <p>아이디 (8글자): <input type="text" name="id" maxlength="8" required></p>
            <p>이름 (10글자): <input type="text" name="name" maxlength="10" required></p>
            <p>비밀번호: <input type="password" name="password" required></p>
            <p>포인트: <input type="number" name="point" required oninput="if(this.value.length > 5) this.value = this.value.slice(0, 5);"></p>
            <input type="hidden" name="grade" value="user">
            <button type="submit">가입하기</button>
        </form>
    </div>
</body>
</html>