import com.trues.signup.CheckId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIdTest {

    private CheckId id;

    @BeforeEach
    public void setUp(){
        System.out.println("set동작 확인");
        this.id = new CheckId();
    }

    @DisplayName("대문자를 소문자로 치환")
    @Test

    void testLetterChanger(){

        //given
        String letter = "aaaAAA";

        //when
        String res = id.step1(letter);

        //then
        Assertions.assertEquals("aaaaaa");
    }

}
