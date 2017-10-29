/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentjavaoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;


/**
 *
 * @author ASUS
 */
public class AssignmentJavaOOP {

    /**
     * @param args the command line arguments
     */
    private static final String CLASS_FOLDER = "/Project/Java/JavaFileInput/";
    private static final String FILE_PATH = "F:\\Project\\Java\\JavaFileInput\\";
    private static final String COMAND_LINE = "javac ";
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        AssignmentJavaOOP obj = new AssignmentJavaOOP();
        obj.executeCommand(COMAND_LINE +  FILE_PATH +"*.java");
               
        Class reflectClass = getClassFromFile("Test");
        
        printName(reflectClass);
        printClassModifier(reflectClass);
        printInstanceVariables(reflectClass);
        printConstructor(reflectClass);
        printListOfMethods(reflectClass);
        
    }
    
    private String executeCommand(String comand){
        
        StringBuffer output = new StringBuffer();
        
        Process p;
        try {
            
            p = Runtime.getRuntime().exec(comand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while((line=reader.readLine())!= null){
                output.append(line + "\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return output.toString();
    }
    
    private static Class getClassFromFile(String fullClassName) throws Exception {
    URLClassLoader loader = new URLClassLoader(new URL[] {
            new URL("file://" + CLASS_FOLDER)
    });
    return loader.loadClass(fullClassName);
    }
    
    static void printName(Class reflectClass){             
        System.out.println("Name of the class : " +reflectClass.getSimpleName());
    }
    static void printInstanceVariables(Class reflectClass){
        Field[] fields = reflectClass.getDeclaredFields();
        if(fields.length == 1){
            System.out.println("There is 1 instance variable");
        }
        if(fields.length == 0){
            System.out.println("There is no instance variable");
        }
        else {
            System.out.println("There are "+fields.length+" instance variables");
        }
        int i =1;
        for(Field field : fields){
            System.out.print("Instance variable "+i+" : "+field.getName()
                                +" - Data type: ");
            if(field.getType().toString().equals("class java.lang.String")){
                System.out.print("String");
            }
            else System.out.print(field.getType());
            int instanceModifier = field.getModifiers();
            if(Modifier.isPrivate(instanceModifier))     {System.out.print(" - Instance Modifier : Private");}
            if(Modifier.isProtected(instanceModifier))   {System.out.print(" - Instance Modifier : Protected");}
            if(Modifier.isPublic(instanceModifier))      {System.out.print(" - Instance Modifier : Public");}
            if(Modifier.isStatic(instanceModifier))      {System.out.print(" - Instance Modifier : Static");}
            System.out.println("");
            
        }
    }
    
    static void printListOfMethods(Class reflectClass){        
        Method[] classMethods = reflectClass.getMethods();
        System.out.println("List of Methods");
        for(Method method : classMethods){
            System.out.print("Method Name : " + method.getName());           
            if(method.getName().startsWith("get")){
                System.out.print(" - Getter method");
            }
            else if(method.getName().startsWith("set")){
                System.out.print(" - Setter method");
            }
            else System.out.print(" - Normal method");
            if(method.getReturnType().toString().equals("class java.lang.String")){
                System.out.print(" - Return type : String");
            }
            else if(method.getReturnType().toString().equals("class java.lang.Class")){
                System.out.print("- Return type : Class");
            }
            else{
                System.out.print(" - Return type : " + method.getReturnType());
            }
            System.out.println("");
        }
    }
    
    static void printClassModifier(Class reflectClass){ 
        
        int modifier = reflectClass.getModifiers();
        
        if(Modifier.isAbstract(modifier))    {System.out.println("Class Modifier : Abstract");}
        if(Modifier.isFinal(modifier))       {System.out.println("Class Modifier : Final");}
        if(Modifier.isInterface(modifier))   {System.out.println("Class Modifier : Interface");}
        if(Modifier.isNative(modifier))      {System.out.println("Class Modifier : Native");}
        if(Modifier.isPrivate(modifier))     {System.out.println("Class Modifier : Private");}
        if(Modifier.isProtected(modifier))   {System.out.println("Class Modifier : Protected");}
        if(Modifier.isPublic(modifier))      {System.out.println("Class Modifier : Public");}
        if(Modifier.isStatic(modifier))      {System.out.println("Class Modifier : Static");}
        if(Modifier.isStrict(modifier))      {System.out.println("Class Modifier : Strict");}
        if(Modifier.isSynchronized(modifier)){System.out.println("Class Modifier : Synchronized");}
        if(Modifier.isTransient(modifier))   {System.out.println("Class Modifier : Transient");}
        if(Modifier.isVolatile(modifier))    {System.out.println("Class Modifier : Volatile");}
    }
    
    static void printConstructor(Class reflectClass){       
        Constructor[] constructors = reflectClass.getConstructors();
        if(constructors.length == 1){
            System.out.println("There is 1 construcor in this class");
        }
        else System.out.println("There are "+constructors.length+" constructors in this class");
        int i = 1;
        for(Constructor c : constructors){
            System.out.println("Constructor "+i+" info : ");
            Class[] parameterTypes = c.getParameterTypes();
            System.out.println("Number of parameter : "+parameterTypes.length);
            System.out.print("Type of each parameter : ");
            for(Class item : parameterTypes){
                System.out.print(item.getName().substring(item.getName().lastIndexOf(".")+1) + " ,");
            }
            System.out.println("");
            i+=1;
        }
    }
    
}
