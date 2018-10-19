package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TemporaryFieldDetection {

    public ClassPOJO TemporaryFieldDetection(ClassPOJO info){

        ///.MATCHES NOT CONTAINS
        Set<VariableDeclarator> isTempField = new HashSet<>();
        Set<VariableDeclarator> nonInitialVar = new HashSet<>();
        Set<VariableDeclarator> initialVar = new HashSet<>();

        for (FieldDeclaration field : info.getFieldDeclarations()) {
            for (VariableDeclarator variable : field.getVariables()) {
                if(variable.getInitializer().isPresent()){
                    initialVar.add(variable);
                }
                else{
                    nonInitialVar.add(variable);
                }
            }
        }

        for (VariableDeclarator variable : initialVar){
            for (VariableDeclarator var : initialVar){
                if(variable.getInitializer().get().toString().matches(var.getNameAsString())){
                    isTempField.add(variable);
                    info.setHasTempField(true);
                }
            }
        }


        for(MethodPOJO methods : info.getMethods()){
            Set<VariableDeclarator> methodTempField = new HashSet<>();
            Set<VariableDeclarator> nonInitialVarM = new HashSet<>();
            Set<VariableDeclarator> initialVarM = new HashSet<>();

                for(VariableDeclarator methodVariable : methods.getMethodVariable()){
                    if(methodVariable.getInitializer().isPresent()){
                        initialVarM.add(methodVariable);
                    }
                    else{
                        nonInitialVarM.add(methodVariable);
                    }

            }
            for(VariableDeclarator variableDeclarator : initialVarM){
                for (VariableDeclarator variableDeclarator1 : initialVarM){
                    if(variableDeclarator.getInitializer().get().toString().matches(variableDeclarator1.getNameAsString())){
                        methodTempField.add(variableDeclarator);
                        methods.setHasTempVar(true);
                    }
                   
                }
            }
        }



        return info;
    }
}
