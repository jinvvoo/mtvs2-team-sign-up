package com.trues.signup;

import java.awt.datatransfer.DataFlavor;
import java.util.HashMap;

public class checkNick {
    private static DataFlavor request;
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("a", "nick");
        map.put("b", "chaz");
        map.put("c", "brown");

        // 단계 1: 닉네임 입력 값 가져오기
        String nickname = request.getParameter("nickname");
        // HttpServletRequest를 사용하는 것으로 가정.

        // 단계 2: 유효성 검사 수행

            // 값이 입력되지 않은 경우
        if (nickname.trim().isEmpty()) {
            System.out.println("닉네임을 입력하세요.");

            // 닉네임에 공백이 포함된 경우
        } else if (nickname.contains(" ")) {
            System.out.println("공백은 포함할 수 없습니다.");

            // 닉네임에 언더바(_)를 제외한 특수문자가 포함된 경우
        } else if (!nickname.matches("^[a-zA-Z0-9_]+$")) {
            System.out.println("특수문자를 사용할 수 없습니다.");

            // 닉네임이 3자 미만인 경우
        } else if (nickname.length() < 3) {
            System.out.println("닉네임은 최소 3자 이상이어야 합니다.");

            // 닉네임이 숫자로만 구성된 경우
        } else if (nickname.matches("^[0-9]+$")) {
            System.out.println("숫자로만 닉네임을 구현할 수 없습니다.");
            System.out.println(" 문자를 추가로 입력해주세요.");

            // 닉네임이 유효한 경우
        } else {
            System.out.println("사용할 수 있는 닉네임입니다.");
        }

    }


}
