package com.ericsson.nms.behavioural.chainofresp.impl;

public abstract class Handler {
    private Handler nextHandler = null;

    public Handler(){
    }

    public Handler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(){
        if(nextHandler==null){
            return;
        }
        nextHandler.handleRequest();
    }
}
