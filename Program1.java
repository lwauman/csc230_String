/*
 * Author: 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class Program1 {

    public static void main(String[] args) {
        //replace <name> with your full name
        System.out.println("MyString implementation by Lucas Auman.");
        
        //anything below here will be erased
        String string1 = "Welcome to MyString.";
        System.out.println("Starting string: " + string1);
        
        MyString myString1 = new MyString(string1);
        System.out.println("MyString: " + myString1.toString());
        System.out.println("Last char: " + myString1.get(myString1.length()-1));
        
        MyString myString2 = new MyString();
        System.out.println("Empty MyString: " + myString2.toString());
        System.out.println("Last char: " + myString2.get(myString2.length()-1));
        
        myString2 = myString1.concat(myString2);
        System.out.println("New MyString: " + myString2.toString());
        System.out.println("Last char: " + myString2.get(myString2.length()-1));
        
        MyString myString3 = myString1.toUpper();
        System.out.println("Upper MyString: " + myString3.toString());
        myString3 = myString1.toLower();
        System.out.println("Lower MyString: " + myString3.toString());
        
        myString3 = myString1.concat("gnirtSyM");
        System.out.println("Concated MyString: " + myString3.toString());
        System.out.println("Substring: " + myString3.indexOf(new MyString("mystring")));
        
        MyString ms6 = new MyString("Lucas");
        System.out.println(ms6.substring(1,4));
        
        System.out.println("Testing completed!");
    }
    
}