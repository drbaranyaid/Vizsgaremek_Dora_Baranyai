package privacyPolicy;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import pages.HomePage;
import pages.PrivacyPolicyPage;
import utils.Utils;

public class PrivacyPolicyTest extends BaseTest {

    @Test
    @DisplayName("TC14-Privacy Policy/verzió,Adatkezelési nyilatkozat használata")
    public void PrivacyTestVersionCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPrivacyPolicyButton();
        Utils utils=new Utils(driver);
        Utils.scrollDown(driver);
        PrivacyPolicyPage privacyPolicyPage=new PrivacyPolicyPage(driver);
        Assertions.assertTrue(driver.findElement(privacyPolicyPage.presentPolicy).getText().contains("on June 7, 2021, pursuant to the "));
        Assertions.assertEquals("This version was approved by Amanda Keton on June 7, 2021, pursuant to the Delegation of policy-making authority by the Board, and went into effect on June 25, 2021. Previous versions can be found below:",driver.findElement(privacyPolicyPage.presentPolicy).getText().trim());
    }

    @Test
    @DisplayName("TC15-Privacy Policy/tartalom,Adatkezelési nyilatkozat használata")
    public void PrivacyTestSummaryCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPrivacyPolicyButton();
        Utils utils=new Utils(driver);
        Utils.scrollDown(driver);
        PrivacyPolicyPage privacyPolicyPage=new PrivacyPolicyPage(driver);
        privacyPolicyPage.getTextFromSummary();
        String result="Privacy Policy\n"+"This is a summary of the Privacy Policy. To read the full terms, scroll down or click here.\n" +
                "Disclaimer: This summary is not a part of the Privacy Policy and is not a legal document. It is simply a handy reference for understanding the full Privacy Policy. Think of it as the user-friendly interface to our Privacy Policy.\n" +
                "\n" +
                "Because we believe that you shouldn’t have to provide personal information to participate in the free knowledge movement, you may:\n" +

                "Read, edit, or use any Wikimedia Site without registering an account.\n" +
                "Register for an account without providing an email address or real name.\n" +
                "Because we want to understand how Wikimedia Sites are used so we can make them better for you, we collect some information when you:\n" +

                "Make public contributions.\n" +
                "Register an account or update your user page.\n" +
                "Use the Wikimedia Sites.\n" +
                "Send us emails or participate in a survey or give feedback.\n" +
                "We are committed to:\n" +
                "Describing how your information may be used or shared in this Privacy Policy.\n" +
                "Using reasonable measures to keep your information secure.\n" +
                "Never selling your information or sharing it with third parties for marketing purposes.\n" +
                "Only sharing your information in limited circumstances, such as to improve the Wikimedia Sites, to comply with the law, or to protect you and others.\n" +
                "Retaining your data for the shortest possible time that is consistent with maintaining, understanding, and improving the Wikimedia Sites, and our obligations under applicable law.\n" +
                "Be aware:\n" +
                "Any content you add or any change that you make to a Wikimedia Site will be publicly and permanently available.\n" +
                "If you add content or make a change to a Wikimedia Site without logging in, that content or change will be publicly and permanently attributed to the IP address used at the time rather than a username.\n" +
                "Our community of volunteer editors and contributors is a self-policing body. Certain administrators of the Wikimedia Sites, who are chosen by the community, use tools that grant them limited access to nonpublic information about recent contributions so they may protect the Wikimedia Sites and enforce policies.\n" +
                "This Privacy Policy does not apply to all sites and services run by the Wikimedia Foundation, such as sites or services that have their own privacy policy (like the Wikimedia Shop) or sites or services run by third parties (like third-party developer projects on Wikimedia Cloud Services).\n" +
                "As part of our commitment to education and research around the world, we occasionally release public information and aggregated or non-personal information to the general public through data dumps and data sets.\n" +
                "For the protection of the Wikimedia Foundation and other users, if you do not agree with this Privacy Policy, you may not use the Wikimedia Sites.";
        Assertions.assertEquals(result, privacyPolicyPage.getTextFromSummary());
    }

}
