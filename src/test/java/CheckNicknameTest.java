import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;

public class CheckNicknameTest {

    @Test
    @DisplayName("닉네임이 중복되면 false를 반환합니다.")
    public void testCheckNick_ExistingNick_ReturnsFalse() {
        Users.nickSet.add("existingNick");

        boolean result = new Nickname().checkNick("existingNick");
        assertFalse(result);
    }

    @Test
    @DisplayName("닉네임에 공백이 있을 경우 false를 반환합니다.")
    public void testCheckNick_NicknameWithSpace_ReturnsFalse() {
        boolean result = new Nickname().checkNick("nick with space");
        assertFalse(result);
    }

    @Test
    @DisplayName("닉네임이 3자 미만일 경우에 false를 반환합니다.")
    public void testCheckNick_NicknameWithLessThan3Chars_ReturnsFalse() {
        boolean result = new Nickname().checkNick("ab");
        assertFalse(result);
    }

    @Test
    @DisplayName("닉네임이 유효하다면, true를 반환합니다.")
    public void testCheckNick_ValidNickname_ReturnsTrue() {
        boolean result = new Nickname().checkNick("validNickname");
        assertTrue(result);
    }
}

class Nickname {
    public boolean checkNick(String nick) {
        if (Users.nickSet.contains(nick)) {
            return false;
        }

        boolean hasSpace = nick.contains(" ");
        if (hasSpace) {
            return false;
        }

        if (nick.length() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}

class Users {
    static Set<String> nickSet = new HashSet<>();
}