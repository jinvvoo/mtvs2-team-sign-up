package com.trues;

import com.trues.signup.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CheckNicknameTest {

    @Test
    @DisplayName("닉네임이 중복되면 false를 반환해야 함")
    public void testCheckNickname_ExistingNickname_ReturnsFalse() {
        // given
        CheckNickname nicknameChecker = new CheckNickname();
        String existingNick = "existingNick";
        Users.nickSet.add(existingNick);

        // when
        boolean result = nicknameChecker.checkNick(existingNick);

        // then
        Assertions.assertFalse(result, "중복된 닉네임일 경우 false를 반환해야 합니다.");
    }

    @Test
    @DisplayName("닉네임에 공백이 있을 경우 false를 반환합니다.")
    public void testCheckNickname_NicknameWithSpace_ReturnsFalse() {
        // given
        CheckNickname nicknameChecker = new CheckNickname();
        String nicknameWithSpace = "nick with space";

        // when
        boolean result = nicknameChecker.checkNick(nicknameWithSpace);

        // then
        Assertions.assertFalse(result, "공백이 포함된 닉네임일 경우 false를 반환해야 합니다.");
    }

    @Test
    @DisplayName("닉네임이 3자 미만일 경우에 false를 반환합니다.")
    public void testCheckNickname_NicknameWithLessThan3Chars_ReturnsFalse() {
        // given
        CheckNickname nicknameChecker = new CheckNickname();
        String nicknameLessThan3Chars = "ab";

        // when
        boolean result = nicknameChecker.checkNick(nicknameLessThan3Chars);

        // then
        Assertions.assertFalse(result, "3글자 미만의 닉네임일 경우 false를 반환해야 합니다.");
    }

    @Test
    @DisplayName("Valid nickname should return true")
    public void testCheckNickname_ValidNickname_ReturnsTrue() {
        // given
        CheckNickname nicknameChecker = new CheckNickname();
        String validNickname = "validNickname";

        // when
        boolean result = nicknameChecker.checkNick(validNickname);

        // then
        Assertions.assertTrue(result, "유효한 닉네임일 경우 true를 반환해야 합니다.");
    }
}

class CheckNickname {
    public boolean checkNick(String nick) {
        return false;
    }
}