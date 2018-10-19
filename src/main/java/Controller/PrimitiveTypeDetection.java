package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveTypeDetection {

    List<String> primitives = Arrays.asList(new String[]{"boolean", "byte", "char", "short", "int", "long", "float", "double"});

    public ClassPOJO PrimitiveDetection(ClassPOJO classes) {


        //COLLECT ALL VARIABLES
        List<VariableDeclarator> allVariables = new ArrayList<>();
        for(FieldDeclaration allFields : classes.getFieldDeclarations()){
            for(VariableDeclarator allVar : allFields.getVariables()){
                allVariables.add(allVar);
            }
        }

        //COLLECT PARAMETER
        for (MethodPOJO methodInfo : classes.getMethods()) {
            List<Parameter> allParam = new ArrayList<>();
            for (Parameter parameter : methodInfo.getParameters()) {
                    allParam.add(parameter);

            }

            //COLLECT ALL METHOD LEVEL
            List<VariableDeclarator> allMethod = new ArrayList<>();
            for(VariableDeclarator var : methodInfo.getMethodVariable()){
                    allMethod.add(var);
            }
            methodInfo.setAllParams(allParam);
            methodInfo.setAllMethodVars(allMethod);

        }
        classes.setAllVariables(allVariables);



        //COLLECT PRIMITIVE TYPES AT CLASS LEVEL
        List<VariableDeclarator> collectPrimitives = new ArrayList<>();
        for (FieldDeclaration field : classes.getFieldDeclarations()) {
            for (VariableDeclarator variable : field.getVariables()) {
                if (primitives.contains(variable.getTypeAsString())) {
                    collectPrimitives.add(variable);
                }
            }
        }

        //COLLECT PRIMITIVE TYPES AT PARAMETER LEVEL
        for (MethodPOJO methodInfo : classes.getMethods()) {
            List<Parameter> parameterPrimitive = new ArrayList<>();
            for (Parameter parameter : methodInfo.getParameters()) {
                if (primitives.contains(parameter.getTypeAsString())) {
                    parameterPrimitive.add(parameter);

                }
            }

            //COLLECT PRIMITIVE TYPES AT METHOD LEVEL
            List<VariableDeclarator> methodPrim = new ArrayList<>();
            for(VariableDeclarator var : methodInfo.getMethodVariable()){
                if(primitives.contains(var.getTypeAsString())){
                    methodPrim.add(var);

                }
            }
            methodInfo.setParameters(parameterPrimitive);
            methodInfo.setMethodVariable(methodPrim);
        }


        classes.setVariableDeclarators(collectPrimitives);

        return classes;

    }
}



