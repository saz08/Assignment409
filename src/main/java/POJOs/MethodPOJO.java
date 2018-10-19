package POJOs;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;

import java.util.List;
import java.util.Optional;

public class MethodPOJO {

    private String methodName;
    private int length;
    private List<Parameter> parameters;
    private boolean methodTooLong;
    private boolean paramTooLong;
    private boolean switchStmt;
    private boolean hasTempVar;
    private boolean switchEnum;

    public boolean isSwitchEnum() {
        return switchEnum;
    }

    public void setSwitchEnum(boolean switchEnum) {
        this.switchEnum = switchEnum;
    }

    public boolean isHasTempVar() {
        return hasTempVar;
    }

    public void setHasTempVar(boolean hasTempVar) {
        this.hasTempVar = hasTempVar;
    }

    private List<Comment> comments;
    private List<Statement> statements;
    private List<FieldDeclaration> methodField;
    private List<VariableDeclarator> methodVariable;

    public List<Parameter> getAllParams() {
        return allParams;
    }

    public void setAllParams(List<Parameter> allParams) {
        this.allParams = allParams;
    }

    private List<Parameter> allParams;

    public List<VariableDeclarator> getAllMethodVars() {
        return allMethodVars;
    }

    public void setAllMethodVars(List<VariableDeclarator> allMethodVars) {
        this.allMethodVars = allMethodVars;
    }

    private List<VariableDeclarator> allMethodVars;



    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }


    public boolean isMethodTooLong() {
        return methodTooLong;
    }
    public void setMethodTooLong(boolean methodTooLong) {
        this.methodTooLong = methodTooLong;
    }

    public boolean isParamTooLong() {
        return paramTooLong;
    }
    public void setParamTooLong(boolean paramTooLong) {
        this.paramTooLong = paramTooLong;
    }

    public boolean isSwitchStmt() {
        return switchStmt;
    }

    public void setSwitchStmt(boolean switchStmt) {
        this.switchStmt = switchStmt;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public List<FieldDeclaration> getMethodField() {
        return methodField;
    }

    public void setMethodField(List<FieldDeclaration> methodField) {
        this.methodField = methodField;
    }

    public List<VariableDeclarator> getMethodVariable() {
        return methodVariable;
    }

    public void setMethodVariable(List<VariableDeclarator> methodVariable) {
        this.methodVariable = methodVariable;
    }



}
