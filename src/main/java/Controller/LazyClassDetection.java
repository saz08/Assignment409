package Controller;

import POJOs.ClassPOJO;

public class LazyClassDetection {

    public ClassPOJO LazyClass(ClassPOJO info){

        if(info.getBlockStmts().size()<2){
            if(info.getMethods().size()<2){
                if(info.getStatements().size()<2){
                    info.setLazyClass(true);
                }
            }
        }


        return info;
    }



}
