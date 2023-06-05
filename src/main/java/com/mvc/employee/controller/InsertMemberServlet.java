package com.mvc.employee.controller;

import com.mvc.employee.model.dto.MemberDTO;
import com.mvc.employee.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/insert")
public class InsertMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int memberCode = Integer.parseInt(request.getParameter("memberCode"));
        String memberName = request.getParameter("memberName");
        String launchDate = request.getParameter("launchDate");
        String divisionCode = request.getParameter("divisionCode");
        String detailInfo = request.getParameter("detailInfo");
        String studentQuantity = request.getParameter("studentQuantity");
        String contact = request.getParameter("contact");
        String teamCode = request.getParameter("teamCode");
        String activeStatus = request.getParameter("activeStatus");

        MemberService memberService = new MemberService();

        MemberDTO member = new MemberDTO();
        member.setMemberCode(memberCode);
        member.setMemberName(memberName);
        member.setLaunchDate(launchDate);
        member.setDivisionCode(divisionCode);
        member.setDetailInfo(detailInfo);
        member.setStudentQuantity(studentQuantity);
        member.setContact(contact);
        member.setTeamCode(teamCode);
        member.setActiveStatus(activeStatus);

        System.out.println("insert request member : " + member);

        int result = memberService.insertMember(member);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            request.setAttribute("successCode", "insertMember");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "신규 회원 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
}