import main.util.EncryptUtil;
import org.junit.Assert;
import org.junit.Test;

public class EncryptTest {

    @Test
    public void encryptTest(){
        Assert.assertEquals(EncryptUtil.encrypt("whatseat"),EncryptUtil.encrypt("whatseat"));
        Assert.assertNotSame(EncryptUtil.encrypt("whatseats"),EncryptUtil.encrypt("whatseat"));
    }
}
