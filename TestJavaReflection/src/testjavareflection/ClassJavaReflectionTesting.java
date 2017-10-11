/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavareflection;

/**
 *
 * @author ASUS
 */
public class ClassJavaReflectionTesting extends SuperClass{
    private String s1 = "Hello world";
    private String s2 = "Hello world 2 ";
    private int n1 =15;
    
    public ClassJavaReflectionTesting(String s1, String s2, int n) {
        this.s1 = s1;
        this.s2 = s2;
    }
    
    public ClassJavaReflectionTesting(String s1){
        this.s1 = s1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
    
    public void Function1(){
        System.out.println("Function 1");
    }
    
    public void Function2(){
        System.out.println("Function 2");
    }
    public void Function3(){
        System.out.println("Function 3");
    }
    
}
