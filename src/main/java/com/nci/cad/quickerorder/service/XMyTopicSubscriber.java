package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.utils.Observer;
import com.nci.cad.quickerorder.utils.Subject;

public class XMyTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public XMyTopicSubscriber(String nm){
        this.name=nm;
    }

    @Override
    public void update() {
            System.out.println(name+":: Consuming message::");
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}
