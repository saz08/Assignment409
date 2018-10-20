package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;

public class LongMethodDetection {

    public MethodPOJO LongMethodDetection(MethodPOJO info) {
    if(info.getLength()>10){
        info.setMethodTooLong(true);
    }
        return info;
    }





}
