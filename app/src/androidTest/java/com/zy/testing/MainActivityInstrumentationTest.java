package com.zy.testing;

/**
 * 项目名称：TestingExample
 * 类描述：
 * 创建人：liu zheng yang(youngforjob@163.com)
 * 创建时间：17/2/8 16:15
 * 修改时间：17/2/8 16:15
 * 修改备注：
 */

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private static final String STRING_TO_BE_TYPED = "LIU ZHENG YANG";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void sayHello111(){
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //设置文本

        onView(withText("Say hello!")).perform(click()); //找到文本设置点击

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        onView(withId(R.id.textView)).check(matches(withText(expectedText))); //比对文本
    }

    @Test
    public void  sayBye111(){

    }
}