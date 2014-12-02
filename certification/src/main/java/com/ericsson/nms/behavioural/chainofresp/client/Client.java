package com.ericsson.nms.behavioural.chainofresp.client;

import com.ericsson.nms.behavioural.chainofresp.impl.ConcreteHandlerInterger;
import com.ericsson.nms.behavioural.chainofresp.impl.ConcreteHandlerString;
import com.ericsson.nms.behavioural.chainofresp.impl.Handler;

public class Client {
    Handler typesHandler;

    public Client(){
        typesHandler = new ConcreteHandlerInterger();
        typesHandler.setNextHandler(new ConcreteHandlerString());
    }

    public void dealWithStrings(){
        typesHandler.handleRequest("test");
    }

    public void dealWithIntegers(){
        typesHandler.handleRequest(new Integer(2));
    }

}
