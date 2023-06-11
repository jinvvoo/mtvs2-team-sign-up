package com.trues.signup;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckId {


//    public boolean checkId (String id) {
//        return id;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


    //    String(문자열) 빈 값 체크하기
    //    public class StringEmptyCheck {


    // 대문자를 소문자로 치환

    private String step1(String new_id)
    {
        return new_id.toLowerCase();
    }


    // 빈 문자열일 경우에 a 대입
    private String step2(String new_id)
    {
        return new_id.equals("") ? "a" : new_id;
    }


    private String step3(String new_id)
    {
        return new_id.length() > 15 ? step2(new_id.substring(0, 15)) : new_id;
    }



    public static void main(String[] args) {

        String str1 = null;
        String str2 = "";
        String str3 = " ";

        System.out.println("str1 : " + isStringEmpty(str1)); // true
        System.out.println("str2 : " + isStringEmpty(str2)); // true
        System.out.println("str3 : " + isStringEmpty(str3)); // false

    }

    static boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }


    // 특수문자
    public static final String pattern2 = "^[A-Za-z[0-9]]{10,20}$"; // 영문, 숫자

    public boolean idRegularExpressionChk(String newPwd, String oldPwd, String userId) {
        boolean chk = false;


        // 영문, 숫자 (10~20 자리)
        Matcher match = Pattern.compile(pattern2).matcher(newPwd);

        if (match.find()) {

            chk = true;

        }
        return chk;
    }


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

