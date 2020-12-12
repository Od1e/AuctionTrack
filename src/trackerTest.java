import java.io.IOException;

/**
 * This file is used specifically for testing the tracker Java class
 */


public class trackerTest {
    public static void main(String[] Args) throws IOException {
        tracker test = new tracker();
        test.readSite("https://www.shopgoodwill.com/Item/110502778");
        System.out.println(test.getSite());
        System.out.println(test.getUfendTime());
    }

}
