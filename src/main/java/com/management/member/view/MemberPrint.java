package com.management.member.view;

import com.common.SearchCondition;
import com.mvc.employee.model.dto.MemberDTO;

import java.util.List;

public class MemberPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllMemberList(List<MemberDTO> allProductList) {

        // 1. 전체 조회한 목록 출력하는 메소드
        //    (조건) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.
        System.out.println("======== 전체 강사 목록 ========");
        if (allProductList.isEmpty()) {
            System.out.println("조회된 강사가 없습니다.");
        } else {
            for (MemberDTO product : allProductList) {
                System.out.println(product);
            }
        }
        System.out.println("=============================");

    }

    public void printMemberList(List<MemberDTO> productList, SearchCondition searchCondition) {

        // 2. 조건에 따라 조회한 목록을 출력하는 메소드
        //    (조건 1) SearchCondition 객체로 검색 조건이 무엇인지 출력하세요.
        //    (조건 2) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.
        System.out.println("======== 조건부 강사 목록 ========");
        System.out.println("조회 조건: " + searchCondition);
        if (productList.isEmpty()) {
            System.out.println("조회된 강사가 없습니다.");
        } else {
            for (MemberDTO product : productList) {
                System.out.println(product);
            }
        }
        System.out.println("=============================");

    }

    public void printSuccessMessage(String successCode) {

        // 3. 성공메시지를 출력하는 메소드
        //    (조건) 성공코드를 전달받아 성공을 알리는 메시지를 출력하세요.
        System.out.println("======== 성공 메시지 ========");
        switch (successCode) {
            case "SUCCESS_REGISTRATION":
                System.out.println("강사 등록이 성공적으로 완료되었습니다.");
                break;
            case "SUCCESS_MODIFICATION":
                System.out.println("강사 정보 수정이 성공적으로 완료되었습니다.");
                break;
            case "SUCCESS_DELETION":
                System.out.println("강사 삭제가 성공적으로 완료되었습니다.");
                break;
            default:
                System.out.println("알 수 없는 성공 코드입니다.");
                break;
        }
        System.out.println("=============================");

    }

    public void printErrorMessage(String errorCode) {

        // 4. 에러메시지를 출력하는 메소드
        //    (조건) 에러코드를 전달받아 에러를 알리는 메시지를 출력하세요.
        System.out.println("======== 에러 메시지 ========");
        switch (errorCode) {
            case "ERROR_INVALID_INPUT":
                System.out.println("유효하지 않은 입력입니다. 다시 확인해 주세요.");
                break;
            case "ERROR_PRODUCT_NOT_FOUND":
                System.out.println("강사를 찾을 수 없습니다.");
                break;
            case "ERROR_REGISTRATION_FAILED":
                System.out.println("강사 등록에 실패했습니다.");
                break;
            case "ERROR_MODIFICATION_FAILED":
                System.out.println("강사 정보 수정에 실패했습니다.");
                break;
            case "ERROR_DELETION_FAILED":
                System.out.println("강사 삭제에 실패했습니다.");
                break;
            default:
                System.out.println("알 수 없는 에러 코드입니다.");
                break;
        }
        System.out.println("=============================");
    }

}
