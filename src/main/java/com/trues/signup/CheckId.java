package com.trues.signup;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckId {
    public String step1;


    // Step1. 대문자를 소문자로 치환

    public String step1(String new_id)
    {
        return new_id.toLowerCase();
    }


    // Step2. 빈 문자열일 경우에 a 대입
    public String step2(String new_id)
    {
        return new_id.equals("") ? "a" : new_id;
    }



    // Step3. 한글, 특수기호 금지
    public static final String pattern2 = "^[A-Za-z-_[0-9]]{3,15}$"; // 영문, 숫자
    // "^[A-Za-z[0-9][-][_]$]{10,20}$"
    // "^[A-Za-z[0-9]$\\-_]{10,20}$"

    // 영어 소문자, 숫자, - _ 제외한 모든 문자 제거
//          "[^a-z0-9\\-_]*",""
//     		str = str.replaceAll("[^a-z0-9\\-_.]*","");


    public boolean idRegularExpressionChk(String newId) {
        boolean chk = false;


        // 영문, 숫자 (10~20 자리)
        Matcher match = Pattern.compile(pattern2).matcher(newId);

        if (match.find()) {

            chk = true;

        }
        return chk;
    }

//
//    // Step4. 최소 4글자, 최대 15글자
//    public String step4(String new_id)
//    {
//        return new_id.length() > 15 ? step2(new_id.substring(3, 15)) : new_id;
//    }





    // Step5. 아이디 공백 그 자체 제거
//    static boolean isStringEmpty(String str) {
//        return str == null || str.isEmpty();
//    }

    // 아이디 중간에 공백 제거
    public static String step5(String str) {
//        String str = "일이삼사오 육칠팔구십 일이삼사오 육칠팔구십";
//        System.out.println("공백 제거 전 문자열 길이는?" + str.length());

        String replaceStr = str.replace(" ", "");

//        System.out.println("replace()후 문자열:" + replaceStr);
//        System.out.println("replace()후 문자열 길이" + replaceStr.length());

        return replaceStr;
    }


    //Step4와 Step5를 합쳐봐?

//
//    public String six(String id) {
//        if(id.length() >= 16) {
//            id = id.substring(0,15).replaceAll("[.]$", "");
//        }
//
//        return id;
//    }



/////////// 여기서부터는 테스트 /////////////////////


    // 문자열에 공백 제거

//    public static void main2(String[] args) {
//
//        String str1 = null;
//        String str2 = "";
//        String str3 = " ";
//
//        System.out.println("str1 : " + isStringEmpty(str1)); // true
//        System.out.println("str2 : " + isStringEmpty(str2)); // true
//        System.out.println("str3 : " + isStringEmpty(str3)); // false
//
//    }




    // 문자열 길이 구하기1

//    public static void main1(String[] args) {
//        String s = "abcdefg";
//        int s_len = s.length();//길이 구하기
//
//        System.out.println("문자열길이 : " + s_len);
//    }

    // 문자열 길이 구하기2
//    JOptionPane jon = new JOptionPane(); //swing 패널
//    String s = "abcdefg";
//
//        if(s.length()>5) { //문자열 5이상일경우
//        jon.showMessageDialog(jon, "입력가능한 글자를 초과하였습니다.","오류",jon.ERROR_MESSAGE);
//    }
}


// 길이가 16자 이상이면
//        if(answer.length() >= 16) {
//                // new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
//                answer = answer.substring(0, 15);
//                // 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
//                answer = answer.replaceAll("[.]$","");
//                }

