package Controller;

import POJOs.MethodPOJO;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;

public class SwitchStmtDetector {

    public MethodPOJO SwitchStmtDetector(MethodPOJO methodInfo){

      for(Statement statement : methodInfo.getStatements()){
          if(statement.isSwitchStmt()){
//              SwitchStmt switchStmt = statement.asSwitchStmt();
//              Boolean isEnum = switchStmt.getSelector().calculateResolvedType().asReferenceType().getTypeDeclaration().isEnum();
//              if(isEnum){
//                  methodInfo.setSwitchEnum(isEnum);
//              }

              methodInfo.setSwitchStmt(true);

          }
      }


        return methodInfo;
    }

}