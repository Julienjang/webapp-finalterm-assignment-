package com.management.member.controller;

import com.common.SearchCondition;
import com.management.member.model.dto.MemberDTO;
import com.management.member.model.service.MemberService;
import com.management.member.view.MemberPrint;

import java.util.List;

public class MemberController {

    private MemberService memberService;
    private MemberPrint memberPrint;

    public MemberController() {
        this.memberService = new MemberService();
        this.memberPrint = new MemberPrint();
    }

    public void selectAllMembers() {
        List<MemberDTO> memberList = memberService.selectAllMembers();

        if (!memberList.isEmpty()) {
            memberPrint.printAllMemberList(memberList);
        } else {
            memberPrint.printErrorMessage("조회 결과가 없습니다.");
        }
    }

    public void selectMemberByCondition(SearchCondition searchCondition) {
        List<MemberDTO> memberList = memberService.selectMemberByCondition(searchCondition);

        if (!memberList.isEmpty()) {
            memberPrint.printMemberList(memberList, searchCondition);
        } else {
            memberPrint.printErrorMessage("No members found matching the given condition.");
        }
    }

    public void registerNewMember(MemberDTO member) {
        boolean result = memberService.registerNewMember(member);

        if (result) {
            memberPrint.printSuccessMessage("멤버 분류 등록이 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("멤버 분류 등록에 실패하였습니다.");
        }
    }

    public void modifyMemberInfo(MemberDTO member) {
        boolean result = memberService.modifyMemberInfo(member);

        if (result) {
            memberPrint.printSuccessMessage("멤버 분류명 수정이 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("멤버 분류명 수정에 실패하였습니다.");
        }
    }

    public void deleteMember(String memberCode) {
        boolean result = memberService.deleteMember(memberCode);

        if (result) {
            memberPrint.printSuccessMessage("제품분류 삭제가 완료되었습니다.");
        } else {
            memberPrint.printErrorMessage("제품분류 삭제에 실패하였습니다.");
        }
    }
}
