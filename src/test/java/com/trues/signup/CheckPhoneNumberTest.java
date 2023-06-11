package com.trues.signup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPhoneNumberTest {
    private CheckPhoneNumber cpn;
    @BeforeEach
    public void setUp(){
        System.out.println("setUp For Test");
        this.cpn = new CheckPhoneNumber();
    }
    @DisplayName("숫자와 하이픈(-)으로만 이루어진 번호 \"010-5555-5555\"를 정상적으로 처리하는가?")
    @Test
    void testNumberAndHyphen() {
        //given
        String number = "010-5555-5555";

        //when
        String res = cpn.getStringToPhoneNumber(number);

        //then
        Assertions.assertEquals("010-5555-5555", res);
    }
    @DisplayName("숫자와 하이픈(-) 외의 문자가 포함된 경우, 올바르지 않은 번호로 판단하는가?")
    @Test
    void testNumberAndHyphen2() {
        //given
        String number = "01a0-5555-5555";

        //when
        boolean flag = cpn.checkNumber(number);
        //then
        Assertions.assertEquals(false, flag);
    }

    @DisplayName("숫자만으로 이루어진 번호 \"01022222222\"를 처리할 수 있는가?")
    @Test
    void testOnlyNumbers() {
        //given
        String number = "01022222222";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("010-2222-2222", res);
    }

    @DisplayName("특정 번호 형식에 맞는 자릿수를 체크할 수 있는가? 02-xxxx-xxxx")
    @Test
    void testNumbersForm() {
        //given
        String number = "0229293939";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("02-2929-3939", res);
    }

    @DisplayName("특정 번호 형식에 맞는 자릿수를 체크할 수 있는가? 02-xxx-xxxx")
    @Test
    void testNumbersForm2() {
        //given
        String number = "022923939";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("02-292-3939", res);
    }
    @DisplayName("특정 번호 형식에 맞는 자릿수를 체크할 수 있는가? 017-xxx-xxxx")
    @Test
    void testNumbersForm3() {
        //given
        String number = "017-333-3333";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("017-333-3333", res);
    }

    @DisplayName("특정 번호 형식에 맞는 자릿수를 체크할 수 있는가? 010-xxxx-xxxx")
    @Test
    void testNumbersForm4() {
        //given
        String number = "010-3333-3333";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("010-3333-3333", res);
    }
    @DisplayName("대한민국 국가 번호 82가 포함된 번호를 처리하여 요구사항에 맞게 만들어 낼 수 있는가?")
    @Test
    void testCountryCode1() {
        //given
        String number = "821054443333";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("010-5444-3333", res);
    }
    @DisplayName("대한민국 국가 번호 82가 포함된 번호를 처리하여 요구사항에 맞게 만들어 낼 수 있는가?")
    @Test
    void testCountryCode2() {
        //given
        String number = "8223323939";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("02-332-3939", res);
    }
    @DisplayName("대한민국 국가 번호 82가 포함된 번호를 처리하여 요구사항에 맞게 만들어 낼 수 있는가?")
    @Test
    void testCountryCode3() {
        //given
        String number = "822-3323-3939";

        //when
        String res = cpn.getStringToPhoneNumber(number);
        //then
        Assertions.assertEquals("02-3323-3939", res);
    }
    @DisplayName("빈 문자열이 입력되었을 경우, 예외처리를 하였는가?")
    @Test
    void checkEmptyString() {
        //given
        String number = "";

        //when
        boolean flag = cpn.checkNumber(number);

        //then
        Assertions.assertEquals(false, flag);
    }
}