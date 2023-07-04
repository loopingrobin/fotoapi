package de.loopingrobin.fotoapi;

import de.loopingrobin.fotoapi.backend.ImageSizeChecker;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImageSizeCheckerTests {

    @Test
    public void sizeOfRightUrlShouldReturnEightThreeZeroTwo() {
        String imageUrl = "http://soerensen-foto-api.azurewebsites.net/images/placeholder1.png";
        var checker = new ImageSizeChecker();

        Assert.assertEquals(8302, checker.getImageSize(imageUrl));
    }

    @Test
    public void wrongUrlShouldReturnNevativeOne(){
        String imageUrl = "http://soerensen-foto-api.azurewebsites.net/images/placeholder101.png";
        var checker = new ImageSizeChecker();

        Assert.assertEquals(-1, checker.getImageSize(imageUrl));
    }

    @Test
    public void brokenUrlShouldReturnNevativeOne(){
        String imageUrl = "http://test";
        var checker = new ImageSizeChecker();

        Assert.assertEquals(-1, checker.getImageSize(imageUrl));
    }

    @Test
    public void emptyUrlShouldReturnNevativeOne(){
        String imageUrl = "";
        var checker = new ImageSizeChecker();

        Assert.assertEquals(-1, checker.getImageSize(imageUrl));
    }

    @Test
    public void noUrlShouldReturnNevativeOne(){
        String imageUrl = null;
        var checker = new ImageSizeChecker();

        Assert.assertEquals(-1, checker.getImageSize(imageUrl));
    }
}
