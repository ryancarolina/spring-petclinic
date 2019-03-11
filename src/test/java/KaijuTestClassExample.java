import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Ghyst on 6/2/2017.
 */
public class KaijuTestClassExample {
    public static Kaiju kaiju;

    @Before
    public void setUp(){
        kaiju = new Kaiju("CHROME");
        System.out.println(kaiju + " Unleashed!");
    }

    @Test
    public void petClinicAssertAddOwnerFormValidationTest(){
        //Set implicit wait
        kaiju.impWait(10);

        //Set the browser window size
        kaiju.setDimensionBrowserWindow(1440, 900);

        //Target URL
        kaiju.getUrl("http://localhost:9966/petclinic/");

        //Confirm link
        kaiju.waitForElementVisibleByPartialLinkText("Find owners", 30);

        //Click link
        kaiju.clickPartialLink("Find owners");

        //Confirm link
        kaiju.waitForElementVisibleByPartialLinkText("Add Owner", 30);

        //Click link
        kaiju.clickPartialLink("Add Owner");

        //Confirm button
        kaiju.waitForElementVisibleBySelector("#add-owner-form > div.form-actions > button", 30);

        //Click button
        kaiju.clickSelector("#add-owner-form > div.form-actions > button");

        //Assert string
        kaiju.assertTextTrue("may not be empty", "body");

    }

    @After
    public void killKaiju(){kaiju.killKaijuDriver();
    }
}
