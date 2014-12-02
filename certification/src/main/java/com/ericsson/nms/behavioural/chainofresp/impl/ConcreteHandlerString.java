package com.ericsson.nms.behavioural.chainofresp.impl;


public class ConcreteHandlerString extends Handler{

    @Override
    public void handleRequest(Object object){
        if(object instanceof String){
            System.out.println("Handled a String");
        }
        passToNext(object);
    }
}
