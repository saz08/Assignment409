package Controller;

import POJOs.MethodPOJO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;

public class SwitchStmtDetector {

    public MethodPOJO SwitchStmtDetector(MethodPOJO methodInfo){

      for(Statement statement : methodInfo.getStatements()){
          if(statement.isSwitchStmt()){
              if(statement.asSwitchStmt().getSelector().calculateResolvedType().isReference()){
                  if(statement.asSwitchStmt().getSelector().calculateResolvedType().asReferenceType().getTypeDeclaration().isEnum()){
                      //USER DEFINED TYPE
                      methodInfo.setSwitchEnum(true);
                  }
                  else{
                      //switch statement here
                      methodInfo.setSwitchStmt(true);
                  }
              }


          }
      }


        return methodInfo;
    }

}