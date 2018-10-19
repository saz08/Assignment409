package POJOs;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.Statement;

import java.util.List;

public class ClassPOJO {

    private String className;
    private int length;
    private boolean classTooLong;
    private boolean paramTooLong;
    private boolean switchStatements;
    private boolean dataClass;
    private boolean hasTempField;
    private List<FieldDeclaration> fieldDeclarations;
    private List<VariableDeclarator> variableDeclarators;

    public List<VariableDeclarator> getAllVariables() {
        return allVariables;
    }

    public void setAllVariables(List<VariableDeclarator> allVariables) {
        this.allVariables = allVariables;
    }

    private List<VariableDeclarator> allVariables;
    private List<MethodPOJO> methods;
    private List<Statement> getterSetter;



    public List<VariableDeclarator> getVariableDeclarators() {
        return variableDeclarators;
    }

    public void setVariableDeclarators(List<VariableDeclarator> variableDeclarators) {
        this.variableDeclarators = variableDeclarators;
    }

    public List<FieldDeclaration> getFieldDeclarations() {
        return fieldDeclarations;
    }

    public void setFieldDeclarations(List<FieldDeclaration> fieldDeclarations) {
        this.fieldDeclarations = fieldDeclarations;
    }

    public List<MethodPOJO> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodPOJO> methods) {
        this.methods = methods;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isClassTooLong() {
        return classTooLong;
    }

    public void setClassTooLong(boolean classTooLong) {
        this.classTooLong = classTooLong;
    }

    public boolean isParamTooLong() {
        return paramTooLong;
    }

    public void setParamTooLong(boolean paramTooLong) {
        this.paramTooLong = paramTooLong;
    }

    public boolean isSwitchStatements() {
        return switchStatements;
    }

    public void setSwitchStatements(boolean switchStatements) {
        this.switchStatements = switchStatements;
    }

    public List<Statement> getGetterSetter() {
        return getterSetter;
    }

    public void setGetterSetter(List<Statement> getterSetter) {
        this.getterSetter = getterSetter;
    }


    public boolean isDataClass() {
        return dataClass;
    }

    public void setDataClass(boolean dataClass) {
        this.dataClass = dataClass;
    }

    public boolean isHasTempField() {
        return hasTempField;
    }

    public void setHasTempField(boolean hasTempField) {
        this.hasTempField = hasTempField;
    }



}
