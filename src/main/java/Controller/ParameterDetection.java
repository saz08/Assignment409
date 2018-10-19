package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;

public class ParameterDetection {

    public MethodPOJO ClassParameter(MethodPOJO methodInfo){
    if(methodInfo.getParameters().size()>5){
        methodInfo.setParamTooLong(true);
    }

    return methodInfo;

    }
}
