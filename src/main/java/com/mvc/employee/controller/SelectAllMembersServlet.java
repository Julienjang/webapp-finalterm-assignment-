package com.mvc.employee.controller;

import com.mvc.employee.model.dto.MemberDTO;
import com.mvc.employee.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/member/list")
public class SelectAllMembersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberService memberService = new MemberService();
        List<MemberDTO> memberList = memberService.selectAllMembers();

        for(MemberDTO member : memberList) {
            System.out.println(member);
        }

        /* 조회 결과 성공 여부에 따른 뷰 결정 */
        String path = "";
        if(memberList != null) {
            path = "/WEB-INF/views/member/memberList.jsp";
            request.setAttribute("memberList", memberList);
        } else {
            path = "/WEB-INF/common/errorPage.jsp";
            request.setAttribute("message", "멤버 목록 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
