package com.example.matthewbuchananma.hypori_marketing_app;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;

public class HMATest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public HMATest() {
        super(MainActivity.class);
    }

    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDrawer() {
        Log.i("Test", "Opening Navigation Drawer.");
        solo.clickOnImageButton(0);
        Log.i("Result", "Navigation Drawer successfully opened.");
        Log.i("Test", "Closing Navigation Drawer.");
        solo.clickOnImageButton(0);
        Log.i("Result", "Navigation Drawer successfully closed");
    }

    public void testInfoFragment() {
        Log.i("Test", "Opening Information fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("The Hypori Client");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Information fragment opened successfully.");
    }

    public void testSolutionFragment() {
        Log.i("Test", "Opening Solution fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("The Hypori Solution");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Solution fragment opened successfully.");
    }

    public void testBenefitsFragment() {
        Log.i("Test", "Opening Benefits fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("Key Benefits");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Benefits fragment opened successfully.");
    }

    public void testEnterpriseFragment() {
        Log.i("Test", "Opening Enterprise fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("Enterprise Class Solution");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Enterprise fragment opened successfully.");
    }

    public void testExperienceFragment() {
        Log.i("Test", "Opening Experience fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("Native Mobile Experience");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Enterprise fragment opened successfully.");
    }

    public void testContactFragment() {
        Log.i("Test", "Opening Contact fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("Contact About Hypori");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "Contact fragment opened successfully.");
    }

    public void testIWFragment() {
        Log.i("Test", "Opening IW fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("Intelligent Waves LLC");
        solo.scrollDown();
        solo.scrollDown();
        solo.scrollUp();
        solo.scrollUp();
        Log.i("Result", "IW fragment opened successfully.");
    }

    public void tearDown() {
        solo.finishOpenedActivities();
    }
}
