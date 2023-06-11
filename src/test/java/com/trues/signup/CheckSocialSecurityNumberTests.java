package com.trues.signup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckSocialSecurityNumberTests {

    CheckSocialSecurityNumber checkSocialSecurityNumber;
    @BeforeEach
    public void setUp() {
        checkSocialSecurityNumber = new CheckSocialSecurityNumber();
    }

    @DisplayName("정상적인 주민 번호 양식이 입력되었을 때 true가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest1() {
        String num1 = "000412";
        String num2 = "3";

        Assertions.assertTrue(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("영어가 입력되었을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest2() {
        String num1 = "a00412";
        String num2 = "3";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("특수 기호가 입력되었을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest3() {
        String num1 = "-00412";
        String num2 = "3";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("앞자리 수를 6글자가 아닌 수를 입력하였을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest4() {
        String num1 = "0200412";
        String num2 = "3";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("뒷자리 수를 1글자가 아닌 수를 입력하였을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest5() {
        String num1 = "000412";
        String num2 = "32";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("앞자리 수에서 원래 12월까지 입력할 수 있는 중간 자릿수를 13월을 입력하였을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest6() {
        String num1 = "001312";
        String num2 = "3";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("앞자리 수에서 원래 31일까지 입력할 수 있는 뒷 자릿수를 32일을 입력하였을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest7() {
        String num1 = "000432";
        String num2 = "3";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }

    @DisplayName("뒷자리 수에 1에서 4가 아닌 수를 입력하였을 때 false가 반환이 되는지")
    @Test
    public void socialSecurityNumberTest8() {
        String num1 = "000412";
        String num2 = "5";

        Assertions.assertFalse(checkSocialSecurityNumber.checkSocialSecurityNumber(num1, num2));
    }
}
