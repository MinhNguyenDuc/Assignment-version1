/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavareflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author ASUS
 */
public class TestJavaReflection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Class reflectClass = ClassJavaReflectionTesting.class;
        PrintName(reflectClass);
        PrintClassModifier(reflectClass);
        PrintSuperClass(reflectClass);
        PrintConstructor(reflectClass);
        System.out.println("");
        PrintListOfMethods(reflectClass);
        System.out.println("");
        PrintInstanceVariables(reflectClass);
    }   
    
    //Print Name of package and name of class
    static void PrintName(Class reflectClass){            
        String FullNameofClass = reflectClass.getName();
        System.out.println("Name of package : " + FullNameofClass.substring(0, FullNameofClass.indexOf(".")));
        System.out.println("Name of class : "+FullNameofClass.substring(FullNameofClass.indexOf(".")+1));
        
    }    
    
    //Print the modifier of the class
    static void PrintClassModifier(Class reflectClass){               
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
    
    //Print the super class of the recent class  
    static void PrintSuperClass(Class reflectClass){        
        Class superclass = reflectClass.getSuperclass();       
        String NameOfSuperClass = superclass.getName();
        System.out.println("SuperClass : " + NameOfSuperClass.substring(NameOfSuperClass.indexOf(".") +1));
        
        System.out.println("");
    } 
    
    //Print Constructor info
    static void PrintConstructor(Class reflectClass){       
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
    
    //Print list of Methods
    static void PrintListOfMethods(Class reflectClass){        
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
    
    //PrintListOfInstanceVariable
    static void PrintInstanceVariables(Class reflectClass){
        Field[] fields = reflectClass.getDeclaredFields();
        if(fields.length == 1){
            System.out.println("There is 1 instance variable");
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
    
}
