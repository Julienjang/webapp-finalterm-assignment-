package com.management;

import com.management.member.view.MemberMenu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        do {
            System.out.println("====== Instructor Management System ======");
            System.out.println("수능 인강 강사 관리 프로그램에 접속하셨습니다.");
            System.out.println("=========================================");
            System.out.println("1. 강사 정보 관리");
            System.out.println("9. 프로그램 종료");
            System.out.println("====================================");
            System.out.println("원하는 관리 메뉴의 번호를 입력해 주세요 : ");

            Scanner sc = new Scanner(System.in);
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : new MemberMenu().displayMenu(); break;
                case 9 : System.out.println("프로그램을 종료합니다."); return;
                default : System.out.println("잘못된 번호입니다. 다시 입력해 주세요."); break;
            }

        } while(true);

    }


}
