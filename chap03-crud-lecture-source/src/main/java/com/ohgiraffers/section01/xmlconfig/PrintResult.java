package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {


    /* 필기.
     *   사용자 -> 인포직원 -> 청소업체
     *   요청의 결과 <-     <-
     *  */
    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("전체 메뉴 조회의 결과는!!!");
        for(MenuDTO menu : menuList) {

            System.out.println(menu);

        }

    }

    public static void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "메뉴 전체 조회를 실패했습니다..."; break;
            case "selectOne" : errorMessage = "메뉴 코드로 메뉴 조회를 실패했습니다..."; break;
            case "insert" : errorMessage = " 신메뉴 등록에 실패했습니다..."; break;
            case "delete" : errorMessage = "메뉴 삭제에 실패했습니다...";break;
            case "update" : errorMessage = " 메뉴 업데이트에 실패했습니다..."; break;
        }

        System.out.println(errorMessage);

    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage="";
        switch (successCode){
            case "insert" : successMessage = "신규 메뉴 등록을 성공하였습니다"; break;
            case "delete" : successMessage = "메뉴 삭제를 성공하였습니다."; break;
            case "update" : successMessage = "메뉴 업데이트를 성공하였습니다.";break;
        }
        System.out.println(successMessage);

    }
}