package com.management.member.view;

import com.common.SearchCondition;
import com.management.member.controller.MemberController;
import com.mvc.employee.model.dto.MemberDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberMenu {

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        do {
            System.out.println("======== Member Info 관리 ========");
            System.out.println("인강 강사의 정보 관리 화면입니다.");
            System.out.println("===================================");
            System.out.println("1. 전체 강사 정보 조회");
            System.out.println("2. 조건부 강사 정보 조회");
            System.out.println("3. 신규 강사 정보 등록");
            System.out.println("4. 기존 강사 정보 수정");
            System.out.println("5. 인기없는 단종 강사 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("===================================");
            System.out.println("원하는 관리 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : memberController.selectAllMembers(request, response); break;
                case 2 : memberController.selectMemberByCondition(request, response, inputSearchCondition()); break;
                case 3 : memberController.registerNewMember(request, response, inputNewProductInfo()); break;
                case 4 : memberController.modifyMemberInfo(request, response, inputModifyProductInfo()); break;
                case 5 : memberController.deleteMember(request, response, inputProductCode().toString()); break;
                case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return;
                default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        } while(true);
    }

    private static SearchCondition inputSearchCondition() {

        Scanner sc = new Scanner(System.in);
        String searchOption = "";
        String searchValue = "";

        System.out.println("===================================");
        System.out.println("조회하고 싶은 조건을 선택하세요. ");
        System.out.println("===================================");
        System.out.println("1. 강사명으로 조회");
        System.out.println("2. 인강 사이트별 소속 강사 조회");
        System.out.println("3. 올해 런칭한 강사 조회");
        System.out.println("4. 강의 중단한 강사 조회");
        System.out.println("===================================");
        System.out.println("원하는 조건의 번호를 입력해 주세요 : ");
        int selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1 :
                sc.nextLine();
                searchOption = "productName";
                System.out.println("조회할 강사명을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 2 :
                sc.nextLine();
                searchOption = "salesStore";
                System.out.println("사이트 유형을 입력해 주세요(메가스터디 or 대성마이맥) : ");
                searchValue = sc.nextLine();
                break;
            case 3 :
                searchOption = "newProduct";
                break;
            case 4 :
                searchOption = "nonProduction";
                break;
            case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return null;
            default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        SearchCondition searchCondition = new SearchCondition();
        // 주석을 지우고 searchCondition 검색조건과 검색어를 searchCondition 객체에 setting 하세요.
        searchCondition.setSearchOption(searchOption);
        searchCondition.setSearchValue(searchValue);


        return searchCondition;
    }

    private static MemberDTO inputNewProductInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("등록할 새로운 강사 정보를 입력하세요. ");
        System.out.println("===================================");
        MemberDTO memberDTO = new MemberDTO();
        getProductInfo(memberDTO);
        System.out.println("===================================");

        return memberDTO;
    }

    private static MemberDTO inputModifyProductInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("수정할 강사 정보를 입력하세요. ");
        System.out.println("수정을 원하지 않는 정보는 SKIP을 입력하세요.");
        System.out.println("===================================");
        System.out.println("수정 대상 강사코드를 입력해 주세요 : ");
        String memberCode = sc.nextLine();

        MemberDTO memberDTO = new MemberDTO();
        // 주석을 지우고 받아온 제품 코드를 mebmberDTO 객체에 setting 하세요.
        memberDTO.setMemberCode(Integer.parseInt(memberCode));

        getProductInfo(memberDTO);

        System.out.println("강사의 소속코드를 입력해 주세요 : ");
        String teamCode  = sc.nextLine();
        System.out.println("강사의 활동여부를 입력해 주세요(Y:활동중 / H:휴강중 / N:은퇴) : ");
        String activeStatus = sc.nextLine().toUpperCase();

        // 주석을 지우고 받아온 활동 상태를 mebmberDTO 객체에 setting 하세요.
        memberDTO.setTeamCode(Integer.parseInt(teamCode));
        memberDTO.setActiveStatus(activeStatus);

        System.out.println("===================================");

        return memberDTO;
    }

    private static MemberDTO getProductInfo(MemberDTO memberDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.println("강사명을 입력해 주세요 : ");
        String memberName = sc.nextLine();
        System.out.println("강사의 구분코드를 입력해 주세요 : ");
        String divisionCode = sc.nextLine();
        System.out.println("강사의 연락처를 입력해 주세요 : ");
        String contact = sc.nextLine();
        System.out.println("강사의 런칭일울 입력해 주세요(2000형식) : ");
        String launchDate = sc.nextLine();
        System.out.println("강사의 수강생 수를 입력해 주세요 : ");
        String studentQuantity  = sc.nextLine();
        System.out.println("강사의 상세정보를 입력해 주세요 : ");
        String detailInfo  = sc.nextLine();

        // 주석을 지우고 받아온 정보들을 mebmberDTO 객체에 setting 하세요.
        memberDTO.setMemberName(memberName);
        memberDTO.setDivisionCode(divisionCode);
        memberDTO.setContact(contact);
        memberDTO.setLaunchDate(launchDate);
        memberDTO.setStudentQuantity(studentQuantity);
        memberDTO.setDetailInfo(detailInfo);

        return memberDTO;
    }

    private static Map<String, String> inputProductCode() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("삭제할 강사의 코드를 입력해 주세요 : ");
        String productCode = sc.nextLine();
        System.out.println("===================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode", productCode);

        return parameter;
    }
}
