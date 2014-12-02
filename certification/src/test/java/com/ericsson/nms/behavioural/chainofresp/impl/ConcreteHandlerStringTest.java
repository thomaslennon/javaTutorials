package com.ericsson.nms.behavioural.chainofresp.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcreteHandlerStringTest {

    @Test
    public void testHandleRequest_passInAString() throws Exception {
        ConcreteHandlerString stringHandler = new ConcreteHandlerString();
        String s = "";
        stringHandler.handleRequest(s);
    }
}