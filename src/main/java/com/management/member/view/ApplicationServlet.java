package com.management.member.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        if ("1".equals(menu)) {
            response.sendRedirect("InstructorManagement.jsp");
        } else if ("9".equals(menu)) {
            // 프로그램 종료 로직
            // 웹 어플리케이션에서는 프로그램을 종료하는 것이 아닌,
            // 사용자를 종료 페이지나 메인 페이지 등으로 이동시키는 것이 일반적입니다.
            response.sendRedirect("exit.jsp"); // 예: exit.jsp로 리다이렉트
        } else {
            // 잘못된 입력 처리
            // 잘못된 입력을 처리하기 위해 사용자에게 오류 메시지를 보여주는 오류 페이지로 리다이렉트합니다.
            response.sendRedirect("error.jsp"); // 예: error.jsp로 리다이렉트
        }
    }
}
