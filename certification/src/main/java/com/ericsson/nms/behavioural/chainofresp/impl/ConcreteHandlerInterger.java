package com.ericsson.nms.behavioural.chainofresp.impl;


public class ConcreteHandlerInterger  extends Handler{

    @Override
    public void handleRequest(Object object){
        if(object instanceof Integer){
            System.out.println("Handled an integer");
        }
        passToNext(object);
    }

}
