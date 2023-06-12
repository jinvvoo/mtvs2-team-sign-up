package com.trues.signup;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckId {
    public String step1;


    // Step1. 대문자를 소문자로 치환
    // toLowerCase를 사용. 문자열을 소문자로 변환
    // 문자열이기 때문에 String 사용
    public String step1(String new_id)
    {
        return new_id.toLowerCase();
    }


    // Step2. 아이디 입력란이 공백일 시 a로 치환
    // equlas를 사용하여 공백을 찾아내고 a로 치환하였습니다.
    public String step2(String new_id)
    {
        return new_id.equals("") ? "a" : new_id;
    }



    // Step3. 한글, 특수기호 금지
    //        : 영어 소문자, 숫자, - _ 제외한 모든 문자 제거
    // step4. 글자수 최소 3, 최대 15로 제한
    // 정규식 패턴을 사용
    // 정규식을 사용하지 않는다면, 코드가 지저분해지고 구현이 훨씬 어려워진다.
    // 하지만, 정규식을 사용함으로써 코드가 간결해지고 더 쉽고 빠르게 구현할 수 있게 되었다.
    public static final String pattern2 = "^[A-Za-z-_[0-9]]{3,15}$"; // 영문, 숫자

    public boolean idRegularExpressionChk(String newId) {
        boolean chk = false;

        // 영문, 숫자 (3~15 자리)
        // 패턴을 이용해서 matcher가 해석을 할 수 있도록 정규식을 변환하는 작업
        // 이후 Matcher가 pattern2와 newId를 매칭하여 true or false 반환
        Matcher match = Pattern.compile(pattern2).matcher(newId);

        // find 로 찾아서 맞으면 true 틀리면 위에 디폴트값으로 false
        if (match.find()) {

            chk = true;

        }
        return chk;
    }


    // Step5. 아이디 중간에 공백 제거
    public static String step5(String str) {
        
        String replaceStr = str.replace(" ", "");
        return replaceStr;
    }




/////////// 여기서부터는 테스트 /////////////////////


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


    //Step4와 Step5를 합쳐봐?

//
//    public String six(String id) {
//        if(id.length() >= 16) {
//            id = id.substring(0,15).replaceAll("[.]$", "");
//        }
//
//        return id;
//    }




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

