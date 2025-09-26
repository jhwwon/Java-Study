<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.company1.DBManager" %>

<%
    request.setCharacterEncoding("UTF-8");
    String memberId = request.getParameter("id");

    Connection conn = null;
    PreparedStatement pstmt = null;

    if (memberId == null || memberId.trim().isEmpty()) {
        out.println("<script>alert('삭제할 회원 ID가 없습니다.'); history.back();</script>");
        return;
    }

    try {
        conn = DBManager.getDBConnection();
        
        String sql = "DELETE FROM membertable WHERE ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberId);
        
        int result = pstmt.executeUpdate();
        
        if (result > 0) {
            out.println("<script>alert('" + memberId + " 회원 삭제가 완료되었습니다.'); location.href='member_list.jsp';</script>");
        } else {
            out.println("<script>alert('회원 삭제에 실패했습니다.'); history.back();</script>");
        }

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