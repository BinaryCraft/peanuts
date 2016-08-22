package co.za.marthinus.engelbrecht.peanuts;

import org.junit.Test;
import co.za.marthinus.engelbrecht.peanuts.api.MyPluginComponent;
import co.za.marthinus.engelbrecht.peanuts.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}