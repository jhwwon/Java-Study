<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.company1.DBManager" %>

<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String grade = request.getParameter("grade");
    int point = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        System.out.println("=== 디버깅 시작 ===");
        System.out.println("받은 파라미터: " + id + ", " + name + ", " + password + ", " + grade);
        
        // 포인트 값 변환 및 예외 처리
        point = Integer.parseInt(request.getParameter("point"));
        System.out.println("포인트 변환 성공: " + point);

        // DB 연결
        System.out.println("DB 연결 시도 중...");
        conn = DBManager.getDBConnection();
        System.out.println("DB 연결 성공!");
        
        // SQL 쿼리 정의
        String sql = "INSERT INTO membertable (ID, NAME, PASSWORD, POINT, GRADE, REGDATE) VALUES (?, ?, ?, ?, ?, SYSDATE)";
        System.out.println("SQL 준비 완료");
        
        // 쿼리 실행
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, password);
        pstmt.setInt(4, point);
        pstmt.setString(5, grade);
        
        System.out.println("쿼리 실행 중...");
        int result = pstmt.executeUpdate();
        System.out.println("쿼리 실행 결과: " + result);
        
        if (result > 0) {
            out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='main.jsp';</script>");
        } else {
            out.println("<script>alert('회원가입에 실패했습니다.'); history.back();</script>");
        }

    } catch (NumberFormatException e) {
        System.out.println("숫자 변환 오류: " + e.getMessage());
        out.println("<script>alert('포인트는 숫자만 입력해주세요.'); history.back();</script>");
    } catch (SQLException e) {
        System.out.println("SQL 오류: " + e.getMessage());
        e.printStackTrace();
        out.println("<script>alert('SQL 오류가 발생했습니다: " + e.getMessage() + "'); history.back();</script>");
    } catch (Exception e) {
        System.out.println("기타 오류: " + e.getMessage());
        e.printStackTrace();
        out.println("<script>alert('오류가 발생했습니다: " + e.getMessage() + "'); history.back();</script>");
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            System.out.println("DB 연결 정리 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>