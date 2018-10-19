package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;
import com.google.errorprone.annotations.Var;

import java.util.*;

public class TemporaryFieldDetector {
//TESTING THIS CLASS BC ITS FULL OF SHIT. OTHER CLASS DETECTS STUFF BUT THIS DOESNT
    public ClassPOJO TemporaryFieldDetector(ClassPOJO info) {


//        Set<VariableDeclarator> isTempField = new HashSet<>();
        Set<VariableDeclarator> nonInitialVar = new HashSet<>();
        Set<VariableDeclarator> initialVar = new HashSet<>();
        Set<String> tempVar = new HashSet<>();
        HashMap<String,String> methodAndVar = new HashMap<>();

        for (FieldDeclaration field : info.getFieldDeclarations()) {
            for (VariableDeclarator variable : field.getVariables()) {
                if (variable.getInitializer().isPresent()) {
                    initialVar.add(variable);
                } else {
                    nonInitialVar.add(variable);
                }
            }
        }

// GO INTO METHODS

        for (MethodPOJO methods : info.getMethods()) {
            Set<Statement> fieldM = new HashSet<>();

//KEEP THIS
            //ADD ALL STATEMENTS TO A SET
            for(Statement statements : methods.getStatements()){
                fieldM.add(statements);
            }

            //IF STATEMENT CONTAINS INITIALIZED VAR, ADD TO ARRAY
            for(VariableDeclarator vD : initialVar){
                if(fieldM.toString().contains(vD.toString())) {
                        tempVar.add(vD.toString());
                        methodAndVar.put(fieldM.toString(),vD.toString());
                }
            }

            //IF STATEMENT CONTAINS UNINITIALIZED VAR, ADD TO ARRAY
            for(VariableDeclarator nonVd : nonInitialVar){
                if(fieldM.toString().contains(nonVd.toString())){
                        tempVar.add(nonVd.toString());
                        methodAndVar.put(fieldM.toString(),nonVd.toString());
                }
            }



            if(tempVar.size()>0){
                System.out.println("TEMP TEMP");
                methods.setHasTempVar(true);
            }

            System.out.println(tempVar + "TEMP VAR");

        }


        return info;
    }
}