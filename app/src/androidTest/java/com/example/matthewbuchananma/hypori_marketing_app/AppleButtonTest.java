package com.example.matthewbuchananma.hypori_marketing_app;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;

public class AppleButtonTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public AppleButtonTest() {
        super(MainActivity.class);
    }

    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testAppleButton () {
        Log.i("Test", "Opening Navigation Drawer.");
        solo.clickOnImageButton(0);
        Log.i("Result", "Navigation Drawer successfully opened.");
        Log.i("Test", "Opening Information fragment.");
        solo.clickOnImageButton(0);
        solo.clickOnMenuItem("The Hypori Client");
        Log.i("Scroll", "Scrolling down to focus on button.");
        solo.scrollDown();
        solo.scrollDown();
        solo.getView(R.id.trial_button_apple);
        Log.i("Test", "Pressing Apple trial button.");
        Log.i("Note", "Robotium will lose control of application once store/browser opens; " +
                "Test cannot return to app after pressing button.");
        solo.clickOnButton("Apple");
    }
}
