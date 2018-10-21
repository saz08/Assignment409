package POJOs;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassPOJO {

    private String className;
    private int length;
    private boolean classTooLong, dataClass;
    private List<FieldDeclaration> fieldDeclarations;
    private List<VariableDeclarator> variableDeclarators;
    private Set<String> tempField;
    private List<VariableDeclarator> allVariables;
    private List<MethodPOJO> methods;
    private List<BlockStmt> blockStmts;
    private boolean lazyClass;
    private List<Statement> statements;


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

    public boolean isDataClass() {
        return dataClass;
    }
    public void setDataClass(boolean dataClass) {
        this.dataClass = dataClass;
    }

    public List<FieldDeclaration> getFieldDeclarations() {
        return fieldDeclarations;
    }
    public void setFieldDeclarations(List<FieldDeclaration> fieldDeclarations) { this.fieldDeclarations = fieldDeclarations; }

    public List<VariableDeclarator> getVariableDeclarators() {
        return variableDeclarators;
    }
    public void setVariableDeclarators(List<VariableDeclarator> variableDeclarators) { this.variableDeclarators = variableDeclarators; }

    public Set<String> getTempField() {
        return tempField;
    }
    public void setTempField(Set<String> tempField) { this.tempField = tempField; }

    public List<VariableDeclarator> getAllVariables() {
        return allVariables;
    }
    public void setAllVariables(List<VariableDeclarator> allVariables) {
        this.allVariables = allVariables;
    }

    public List<MethodPOJO> getMethods() {
        return methods;
    }
    public void setMethods(List<MethodPOJO> methods) {
        this.methods = methods;
    }

    public List<BlockStmt> getBlockStmts() { return blockStmts; }
    public void setBlockStmts(List<BlockStmt> blockStmts) { this.blockStmts = blockStmts; }

    public boolean isLazyClass() { return lazyClass; }
    public void setLazyClass(boolean lazyClass) { this.lazyClass = lazyClass; }

    public List<Statement> getStatements() { return statements; }
    public void setStatements(List<Statement> statements) { this.statements = statements; }

}
