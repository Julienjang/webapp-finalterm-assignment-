package com.management.member.view;

import com.common.SearchCondition;
import com.management.member.controller.MemberController;
import com.management.member.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/InstructorManagement")
public class InstructorManagementServlet extends HttpServlet {
    private MemberController memberController = new MemberController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("menu");

        switch (action) {
            case "1":
                memberController.selectAllMembers(request, response);
                break;
            case "2":
                memberController.selectMemberByCondition(request, response, inputSearchCondition(request));
                break;
            case "3":
                memberController.registerNewMember(request, response, inputNewProductInfo(request));
                break;
            case "4":
                memberController.modifyMemberInfo(request, response, inputModifyProductInfo(request));
                break;
            case "5":
                memberController.deleteMember(request, response, inputProductCode(request).toString());
                break;
            case "9":
                // 상위 메뉴로 이동하는 코드를 여기에 작성하세요.
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                break;
        }
    }

    private SearchCondition inputSearchCondition(HttpServletRequest request) {
        String searchOption = request.getParameter("searchOption");
        String searchValue = request.getParameter("searchValue");

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setSearchOption(searchOption);
        searchCondition.setSearchValue(searchValue);

        return searchCondition;
    }

    private MemberDTO inputNewProductInfo(HttpServletRequest request) {
        MemberDTO memberDTO = new MemberDTO();
        getProductInfo(request, memberDTO);

        return memberDTO;
    }

    private MemberDTO inputModifyProductInfo(HttpServletRequest request) {
        String memberCode = request.getParameter("memberCode");
        String teamCode = request.getParameter("teamCode");
        String activeStatus = request.getParameter("activeStatus");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberCode(Integer.parseInt(memberCode));
        memberDTO.setTeamCode(Integer.parseInt(teamCode));
        memberDTO.setActiveStatus(activeStatus);

        getProductInfo(request, memberDTO);

        return memberDTO;
    }

    private void getProductInfo(HttpServletRequest request, MemberDTO memberDTO) {
        String memberName = request.getParameter("memberName");
        String divisionCode = request.getParameter("divisionCode");
        String contact = request.getParameter("contact");
        String launchDate = request.getParameter("launchDate");
        String studentQuantity = request.getParameter("studentQuantity");
        String detailInfo = request.getParameter("detailInfo");

        memberDTO.setMemberName(memberName);
        memberDTO.setDivisionCode(divisionCode);
        memberDTO.setContact(contact);
        memberDTO.setLaunchDate(launchDate);
        memberDTO.setStudentQuantity(studentQuantity);
        memberDTO.setDetailInfo(detailInfo);
    }

    private Map<String, String> inputProductCode(HttpServletRequest request) {
        String productCode = request.getParameter("productCode");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode", productCode);

        return parameter;
    }
}
