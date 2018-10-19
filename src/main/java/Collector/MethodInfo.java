package Collector;

import Controller.LongMethodDetection;
import Controller.ParameterDetection;
import Controller.SwitchStmtDetector;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class MethodInfo extends VoidVisitorAdapter<List<MethodPOJO>> {

    @Override
    public void visit(MethodDeclaration md, List<MethodPOJO> list){
        super.visit(md,list);

//        int allStatements = md.getBody().get().findAll(Statement.class).size();
//        int blocks = md.getBody().get().findAll(BlockStmt.class).size();


        MethodPOJO mPojo = new MethodPOJO();

        List<Comment> comments = md.getAllContainedComments();
        List<Statement> statements =  md.getBody().get().findAll(Statement.class);
        statements.removeAll(md.getBody().get().findAll(BlockStmt.class));

//        List<SwitchStmt> switchStmts = md.getBody().get().findAll(SwitchStmt.class);
//
//        if(switchStmts.size()>0){
//            System.out.println("There is a switch statement in this class");
//        }

        mPojo.setMethodName(md.getNameAsString());
        mPojo.setLength(statements.size());
        mPojo.setParameters(md.getParameters());
        mPojo.setComments(comments);
        mPojo.setStatements(statements);
        mPojo.setMethodVariable(md.findAll(VariableDeclarator.class));
        mPojo.setAllParams(md.getParameters());
        mPojo.setAllMethodVars(md.findAll(VariableDeclarator.class));


        //findAll variableDeclarator.class , store that n loop through it for primitives




        mPojo = new LongMethodDetection().LongMethodDetection(mPojo);
        mPojo = new ParameterDetection().ClassParameter(mPojo);
        mPojo = new SwitchStmtDetector().SwitchStmtDetector(mPojo);


        list.add(mPojo);


    }


}
