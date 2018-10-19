package Collector;

import Controller.*;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClassInfo extends VoidVisitorAdapter<List<ClassPOJO>> {

@Override
    public void visit(ClassOrInterfaceDeclaration md, List<ClassPOJO> list){
    super.visit(md,list);

    List<MethodPOJO> methodList = new ArrayList<MethodPOJO>();

    new MethodInfo().visit(md,methodList);
    ClassPOJO cPojo = new ClassPOJO();



    cPojo.setClassName(md.getNameAsString());
    cPojo.setLength(md.getEnd().get().line);
    cPojo.setMethods(methodList);
    cPojo.setFieldDeclarations(md.getFields());
    cPojo.setVariableDeclarators(md.findAll(VariableDeclarator.class));
    cPojo.setAllVariables(md.findAll(VariableDeclarator.class));

 //   cPojo.setVariableDeclarators();

    cPojo = new PrimitiveTypeDetection().PrimitiveDetection(cPojo);
    cPojo = new DataClassDetection().DataClassDetection(cPojo);
  //  cPojo = new TemporaryFieldDetection().TemporaryFieldDetection(cPojo);
    cPojo = new TemporaryFieldDetector().TemporaryFieldDetector(cPojo);

    list.add(cPojo);

    }

}
