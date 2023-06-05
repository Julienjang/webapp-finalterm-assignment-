package com.mvc.employee.controller;

import com.mvc.employee.model.dto.MemberDTO;
import com.mvc.employee.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update")
public class UpdateMemberServlet extends HttpServlet {

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

        int result = new MemberService().updateMember(member);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            request.setAttribute("successCode", "updateMember");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 수정 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
}
