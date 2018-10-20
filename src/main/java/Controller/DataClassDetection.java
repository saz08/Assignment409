package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.List;

public class DataClassDetection {

    public ClassPOJO DataClassDetection(ClassPOJO classInfo) {
        List<MethodPOJO> getters = new ArrayList<>();
        List<MethodPOJO> setters = new ArrayList<>();

        for (MethodPOJO methodInfo : classInfo.getMethods()) {
            //CHECK METHOD HAS ONLY ONE STATEMENT
            if(methodInfo.getStatements().size()==1){
                for(Statement s : methodInfo.getStatements()){
                    if(s.isReturnStmt()){
                                getters.add(methodInfo);
                    }
                }
            }

            if(methodInfo.getStatements().size()==1 && !getters.contains(methodInfo)){
               for(Statement s: methodInfo.getStatements()){
                  setters.add(methodInfo);
               }
            }
        }

        if(getters.size() + setters.size() == classInfo.getMethods().size()){
            classInfo.setDataClass(true);
        }


        return classInfo;
    }
}

