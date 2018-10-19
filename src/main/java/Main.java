import Collector.ClassInfo;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
  //  private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Assignment409/ReversePolish.java";
    private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Assignment409/BarnsleyFernTwo.java";

    // private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Assignment409/ExamplePojo.java";


    public static void main(String[] args) throws Exception{
        CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));

        List<ClassPOJO> classes = new ArrayList<>();
        new ClassInfo().visit(cu,classes);

        for(ClassPOJO info : classes){
            System.out.println("Name : " + info.getClassName());
            if(info.isClassTooLong()==true){
                System.out.println("This is a large class");
            }

            if(info.isDataClass()==true){
                System.out.println("This is a data class");
            }
            if(info.isHasTempField()==true){
                System.out.println("This class has temporary fields");
            }

            if(info.getAllVariables().size()>0) {
                if ((info.getVariableDeclarators().size()) / (info.getAllVariables().size()) > 0.6) {
                    System.out.println("CLASS PRIM OBSESSION");
                }
            }
            System.out.println("Primitive types in this class " + info.getVariableDeclarators()+"\n") ;


            for(MethodPOJO mPojo : info.getMethods()){
                System.out.println("Method Name " + mPojo.getMethodName() );

                if(mPojo.isMethodTooLong()==true){
                    System.out.println("This is a long method");
                }

                if(mPojo.isParamTooLong()==true){
                    System.out.println("The parameter list for this method is too long");
                }

                if(mPojo.getParameters().size()>0){
                    System.out.println("This method has primitive types as parameters : " + mPojo.getParameters());
                }

                if(mPojo.getAllParams().size()>0) {
                    if ((mPojo.getParameters().size()) / (mPojo.getAllParams().size()) > 0.6) {
                        System.out.println("PARAMETER PRIMITIVE OBSESSION");
                    }
                }

                if(mPojo.getMethodVariable().size()>0){
                    System.out.println("This method has primitive types : " + mPojo.getMethodVariable());
                }

                if(mPojo.getAllMethodVars().size()>0) {
                    if ((mPojo.getMethodVariable().size()) / (mPojo.getAllMethodVars().size()) > 0.6) {
                        System.out.println("METHOD PRIMITIVE OBSESSION");
                    }
                }

//                if(mPojo.getMethodVariable().size()>0){
//                    System.out.println("This method contains primitive types : " + mPojo.getMethodVariable());
//                }

                if(mPojo.isSwitchStmt()==true){
                    System.out.println("This method has a switch statement");
                }

                if(mPojo.isSwitchEnum()==true){
                    System.out.println("Switch statement is an ENUM");
                }

                if(mPojo.isHasTempVar()==true){
                    System.out.println("This method has a temporary variable");
                }

                System.out.println("\n");

            }






        }

    }
}
