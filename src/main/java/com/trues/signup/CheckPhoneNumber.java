package com.trues.signup;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CheckPhoneNumber {
    //해쉬맵으로 지역 번호와 모바일 번호를 관리함
    static Map<String, String> map = new HashMap<>(){{
       put("02", "서울"); put("031", "경기"); put("032", "인천");
       put("033", "강원"); put("041", "충남"); put("042", "대전");
       put("043", "충북"); put("044", "세종"); put("051", "부산");
       put("052", "울산"); put("053", "대구"); put("054", "경북");
       put("055", "경남"); put("061", "전남"); put("062", "광주");
       put("063", "전북"); put("064", "제주"); put("067", "제주");
       put("011", "모바일"); put("016", "모바일"); put("017", "모바일");
       put("018", "모바일"); put("019", "모바일"); put("010", "모바일");
    }};

    //앞자리/중간자리/뒷자리 구분
    static String num1, num2, num3;
    //올바른 형태의 번호인지를 확인하여 boolean 값으로 체크하는 메소드
    public boolean checkNumber(String num){
        //번호 형태가 맞는지 체크
        if(isCorrect(num)){
            //전화번호 형태로 생성
            String number = getStringToPhoneNumber(num);
            StringTokenizer st = new StringTokenizer(number, "-");
            //번호 형식이 맞는지를 확인 xxx-xxxx-xxxx 
            if(st.countTokens() == 3){
                num1 = st.nextToken(); num2 = st.nextToken(); num3 = st.nextToken();
                //해쉬맵에 저장된 key값으로 각 자리 수에 맞는 번호를 가지고 있는지를 확인하여 True/False를 반환함
                if(map.containsKey(num1)){
                    if(num1.equals("02")){
                        if((num2.length() == 4 || num2.length() == 3) && num3.length() == 4)
                            return true;
                    }
                    else if(num1.equals("010")){
                        if(num2.length() == 4 && num3.length() == 4)
                            return true;
                    }
                    else{
                        if(num1.length() == 3 && num2.length() == 3 && num3.length() == 4)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    //정규표현식을 사용하여 하이픈(-)이 붙은 번호의 형태로 만들어주는 메소드
    public String getStringToPhoneNumber(String src){
        //서울일 때,
        if(src.startsWith("02")){
            return src.replaceAll("([0-9]{2})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        //대한민국 국가코드 82가 포함되어 있는 경우, (서울)
        else if(src.startsWith("822")){
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            sb.delete(0, 2);
            sb.insert(0, "0");
            num1 = String.valueOf(sb);
            src = num1;
            return src.replaceAll("([0-9]{2})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        //위와 동일하나, 나머지 지역 + 모바일
        else if(src.startsWith("82")){
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            sb.delete(0, 2);
            sb.insert(0, "0");
            num1 = String.valueOf(sb);
            src = num1;
            return src.replaceAll("([0-9]{3})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        //그 외의 케이스
        else{
            return src.replaceAll("([0-9]{3})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
    }
    //숫자와 하이픈(-)으로만 이루어져 있는지 체크하는 메소드
    public boolean isCorrect(String src){
        boolean checkNumber = src.matches("[0-9-]+");
        return checkNumber;
    }

    //완성되어 있는 번호의 앞에 어느 지역의 번호인지, 모바일인지를 알려주는 문자열을 추가하는 메소드
    public String getNumber(String src){
        String num = getStringToPhoneNumber(src);
        StringTokenizer st = new StringTokenizer(num, "-");
        return "(" + map.get(st.nextToken()) + ") " + num;
    }
}
