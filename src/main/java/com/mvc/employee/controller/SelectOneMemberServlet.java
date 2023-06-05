package com.mvc.employee.controller;

import com.mvc.employee.model.dto.MemberDTO;
import com.mvc.employee.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/select")
public class SelectOneMemberServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 전달한 파라미터 꺼내기 */
        int memberId = Integer.parseInt(request.getParameter("memberId"));

        System.out.println("memberId : " + memberId);

        /* 사번을 이용해 사원 정보를 조회하는 비지니스 로직 호출 */
        MemberService memberService = new MemberService();
        MemberDTO selectedMember = memberService.selectOneMemberById(memberId);

        System.out.println("selectedMember : " + selectedMember);

        /* 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedMember != null) {
            path = "views/member/showMemberInfo.jsp";
            request.setAttribute("selectedMember", selectedMember);
        } else {
            path = "views/common/errorPage.jsp";
            request.setAttribute("message", "멤버 정보 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
