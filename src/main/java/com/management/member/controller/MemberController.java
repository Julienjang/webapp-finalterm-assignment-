package com.management.member.controller;

import com.common.SearchCondition;
import com.mvc.employee.model.dto.MemberDTO;
import com.management.member.model.service.MemberService;
import com.management.member.view.MemberPrint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberController {

    private MemberService memberService;
    private MemberPrint memberPrint;

    public MemberController() {
        this.memberService = new MemberService();
        this.memberPrint = new MemberPrint();
    }

    public void selectAllMembers(HttpServletRequest request, HttpServletResponse response) {
        List<MemberDTO> memberList = memberService.selectAllMembers();

        if (!memberList.isEmpty()) {
            memberPrint.printAllMemberList(memberList);
        } else {
            memberPrint.printErrorMessage("조회 결과가 없습니다.");
        }
    }

    public void selectMemberByCondition(HttpServletRequest request, HttpServletResponse response, SearchCondition searchCondition) {
        List<MemberDTO> memberList = memberService.selectMemberByCondition(searchCondition);

        if (!memberList.isEmpty()) {
            memberPrint.printMemberList(memberList, searchCondition);
        } else {
            memberPrint.printErrorMessage("No members found matching the given condition.");
        }
    }

    public void registerNewMember(HttpServletRequest request, HttpServletResponse response, MemberDTO member) {
        boolean result = memberService.registerNewMember(member);

        if (result) {
            memberPrint.printSuccessMessage("멤버 분류 등록이 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("멤버 분류 등록에 실패하였습니다.");
        }
    }

    public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response, MemberDTO member) {
        boolean result = memberService.modifyMemberInfo(member);

        if (result) {
            memberPrint.printSuccessMessage("멤버 분류명 수정이 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("멤버 분류명 수정에 실패하였습니다.");
        }
    }

    public void deleteMember(HttpServletRequest request, HttpServletResponse response, String memberCode) {
        boolean result = memberService.deleteMember(memberCode);

        if (result) {
            memberPrint.printSuccessMessage("제품분류 삭제가 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("제품분류 삭제에 실패하였습니다.");
        }
    }
}
