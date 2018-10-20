package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;

import java.util.HashSet;
import java.util.Set;

public class Temporary {

    public ClassPOJO Temporary(ClassPOJO info){

        Set<VariableDeclarator> isTempField = new HashSet<>();
        Set<VariableDeclarator> nonInitialVar = new HashSet<>();
        Set<VariableDeclarator> initialVar = new HashSet<>();
        Set<String> tempField = new HashSet<>();
        Set<Statement> ifOrSwitch = new HashSet<>();

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

        for(MethodPOJO methods : info.getMethods()){
            for(Statement statement : methods.getStatements()){
                if(statement.isIfStmt()||statement.isSwitchStmt()){
                    ifOrSwitch.add(statement);
                }
            }
            for(VariableDeclarator vd : nonInitialVar){
                if(ifOrSwitch.toString().contains(vd.toString())){
                        tempField.add(vd.toString());
                        methods.setHasTempVar(true);

                }
            }

        }
        info.setTempField(tempField);


        return info;
    }
}
