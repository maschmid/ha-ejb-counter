package com.redhat.xpaas.eap.deployments.servlet;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@Stateful
public class Counter {
    private long count;

    @PostConstruct
    public void onCreate() {
        count = 0;
    }
    
    public long increment() {
        count++;
        return count;
    }
}
