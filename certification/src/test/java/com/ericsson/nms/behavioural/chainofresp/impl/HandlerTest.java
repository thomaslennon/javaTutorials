package com.ericsson.nms.behavioural.chainofresp.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandlerTest {

    boolean wasCalled;

    @Before
    public void setUp() throws Exception {
        wasCalled = false;
    }

    @After
    public void tearDown() throws Exception {
        wasCalled = true;
    }

    @Test
    public void handlingActionIsPassedOn() {
        Handler myHandler1 = new Handler() {
            @Override
            public void handleRequest(Object someObject) {
                wasCalled = true;
            }
        };

        new TempHandler(myHandler1).handleRequest(null);
        assertTrue(wasCalled);
    }

    @Test
    public void handlingActionIsNotPassedOn() {
        new TempHandler(null).handleRequest(null);
    }

}

class TempHandler extends Handler {
    public TempHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Object someObject) {
        super.handleRequest(someObject);
    }
}