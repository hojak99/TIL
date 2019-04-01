import implement.NewString;
import org.junit.Assert;
import org.junit.Test;

public class NewStringTests {

    @Test
    public void 뉴_스트링_생성() {
        NewString newString = new NewString();
        Assert.assertEquals("", newString.getString());
    }
}
