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
                      //  for(FieldDeclaration f : classInfo.getFieldDeclarations()){
                        //    if(returnStmt.contains(f.getVariables().get(0).getNameAsString())){
                                getters.add(methodInfo);
                          //  }
                        //}
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


            //statement size one
        //look and if it is a return and also return name needs to match a field
        //for each field, if it matches the return name, must be a getter and add to getter list
        //setter statement size one, and not in the getter list
        //get statement, target is field, value is parameter passed in. value match parameter, target match field
        // add to setter list
        //if two sizes match the number of methods = data class


        return classInfo;
    }
}

