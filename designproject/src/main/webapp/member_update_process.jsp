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
        // 포인트 값 변환 및 예외 처리
        point = Integer.parseInt(request.getParameter("point"));

        // DB 연결
        conn = DBManager.getDBConnection();
        
        // SQL 쿼리 정의
        String sql = "UPDATE membertable SET NAME=?, PASSWORD=?, POINT=?, GRADE=? WHERE ID=?";
        
        // 쿼리 실행
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, password);
        pstmt.setInt(3, point);
        pstmt.setString(4, grade);
        pstmt.setString(5, id); // WHERE 절의 ID
        
        int result = pstmt.executeUpdate();
        
        if (result > 0) {
            out.println("<script>alert('" + id + " 회원의 정보가 성공적으로 수정되었습니다.'); location.href='member_list.jsp';</script>");
        } else {
            out.println("<script>alert('회원 정보 수정에 실패했습니다.'); history.back();</script>");
        }

    } catch (NumberFormatException e) {
        out.println("<script>alert('포인트는 숫자만 입력해주세요.'); history.back();</script>");
    } catch (SQLException e) {
        out.println("<script>alert('SQL 오류가 발생했습니다: " + e.getMessage() + "'); history.back();</script>");
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>