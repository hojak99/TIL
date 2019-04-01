import exceptions.NewStringIndexOutOfBoundsException;
import implement.NewString;
import org.junit.Assert;
import org.junit.Test;

public class NewStringTests {

    @Test
    public void 뉴_스트링_생성() {
        NewString newString = new NewString();
        Assert.assertEquals("", newString.getString());
    }

    @Test
    public void 뉴_스트링_생성자_equals_테스트() {
        String string = new String("Test");
        String afterString = new String(string);
        Assert.assertEquals(string, afterString);

        NewString newString = new NewString("Test");
        NewString afterNewString = new NewString(newString);
        Assert.assertEquals(newString, afterNewString);
    }

    @Test(expected = NewStringIndexOutOfBoundsException.class)
    public void 뉴_스트링_생성자_테스트() {
        NewString newString = new NewString("Test".toCharArray(), 0, 2);
        Assert.assertEquals("Te", newString.getString());
    }
}
