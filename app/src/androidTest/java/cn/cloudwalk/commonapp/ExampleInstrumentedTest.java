package cn.cloudwalk.commonapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.cloudwalk.commonapp", appContext.getPackageName());
    }
    @Test
    public void bigDecimal() throws Exception {
        // Context of the app under test.
       double score = new BigDecimal(0.6543).setScale(4, BigDecimal.ROUND_UNNECESSARY).doubleValue();

    }
}
