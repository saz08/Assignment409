package Controller;

import POJOs.ClassPOJO;

public class LargeClassDetection {

    public ClassPOJO LargeClassDetection(ClassPOJO info){
        if(info.getLength()>100){
            info.setClassTooLong(true);
        }
        return info;
    }
}


