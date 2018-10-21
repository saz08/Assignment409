import Collector.ClassInfo;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "ImportedTests";

    public static void main(String[] args) throws Exception{

        List<File> files = new ArrayList<>();
        importFiles(FILE_PATH,files);

        List<ClassPOJO> classes = new ArrayList<>();

        TypeSolver javaParserTS = new JavaParserTypeSolver(new File("ImportedTests"));
        TypeSolver reflectionTS = new ReflectionTypeSolver();
        reflectionTS.setParent(reflectionTS);
        CombinedTypeSolver combinationSolver = new CombinedTypeSolver();
        combinationSolver.add(javaParserTS);
        combinationSolver.add(reflectionTS);
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinationSolver);
        ParserConfiguration parserConfiguration = new JavaParser().getStaticConfiguration().setSymbolResolver(symbolSolver);



        for(File f: files){
            CompilationUnit cu = JavaParser.parse(f);
            new ClassInfo().visit(cu,classes);
        }


        for(ClassPOJO info : classes){
            System.out.println("Name : " + info.getClassName());
            if(info.isClassTooLong()==true){
                System.out.println("This is a large class");
            }

            if(info.isDataClass()==true){
                System.out.println("This is a data class");
            }

            if(info.isLazyClass()==true){
                System.out.println("This is a lazy class");
            }

            if(info.getTempField().size()>0){
                System.out.println("This class has temporary fields of : " + info.getTempField());
            }

            if(info.getAllVariables().size()>0) {
                if ((info.getVariableDeclarators().size()) / (info.getAllVariables().size()) > 0.6) {
                    System.out.println("This class has Primitive Obsession");
                }
            }


            for(MethodPOJO mPojo : info.getMethods()){
                System.out.println("Method Name " + mPojo.getMethodName() );

                if(mPojo.isMethodTooLong()==true){
                    System.out.println("This is a long method");
                }

                if(mPojo.isParamTooLong()==true){
                    System.out.println("The parameter list for this method is too long");
                }


                if(mPojo.getAllParams().size()>0) {
                    if ((mPojo.getParameters().size()) / (mPojo.getAllParams().size()) > 0.6) {
                        System.out.println("This method has primitive obsession in parameters : " + mPojo.getParameters());
                    }
                }


                if(mPojo.getAllMethodVars().size()>0) {
                    if ((mPojo.getMethodVariable().size()) / (mPojo.getAllMethodVars().size()) > 0.6) {
                        System.out.println("This method has primitive obsession with : " +mPojo.getMethodVariable());
                    }
                }


                if(mPojo.isSwitchStmt()==true){
                    System.out.println("This method has a switch statement");
                }

                if(mPojo.isSwitchEnum()==true){
                    System.out.println("Switch statement type is an ENUM");
                }

                System.out.println("\n");

            }
        }

    }

    public static List<File> importFiles(String filePath, List<File> files){
        File fRoot = new File(filePath);
        File[] fileList = fRoot.listFiles();

        if(fileList == null){
            return files;
        }

        for(File f: fileList){
            if(f.isDirectory()){
                importFiles(f.getPath(),files);
            }
            else{
                if(f.getPath().contains(".java")){
                    files.add(f);
                }
            }
        }
        return files;
    }
}
