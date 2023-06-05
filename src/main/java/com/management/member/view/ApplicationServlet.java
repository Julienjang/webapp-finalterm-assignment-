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
        } else {
            // 잘못된 입력 처리
        }
    }
}
