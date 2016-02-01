/*
 * Author: Lucas W. Auman
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class MyString {
    private char[] strChars;
    private int currLength;
    
    public MyString(){
        strChars = new char[0];
        currLength = strChars.length;
    }
    
    public MyString(String str){
        strChars = new char[str.length()];
        currLength = str.length();
        for(int i=0; i<currLength; i++){
            strChars[i] = str.charAt(i);
        }
    }
    
    public MyString(MyString str){
        currLength = str.length();
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = str.get(i);
        }
    }
    
    public int length(){
        return strChars.length;
    }
    
    private void ensureCapacity(int length){
        currLength = length;  
    }
    
    public String toString(){
        String toString="";
        for(int i=0; i<strChars.length; i++){
            toString += String.valueOf(strChars[i]);
        }
        return toString;
    }
    
    public MyString concat(MyString str){
        String tempHolder ="";
        for(char x:strChars){
            tempHolder += String.valueOf(x);
        }
        tempHolder += str.toString();
        ensureCapacity(tempHolder.length());
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = tempHolder.charAt(i);
        }
        return this;
    }
    
    public MyString concat(String str){
        String tempHolder ="";
        for(char x:strChars){
            tempHolder += String.valueOf(x);
        }
        tempHolder += str;
        ensureCapacity(tempHolder.length());
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = tempHolder.charAt(i);
        }
        return this;
    }
    
    public boolean equals(MyString str){
        boolean equals=false;
        if(currLength != str.length())
            equals = false;
        else{
            for(int i=0; i<currLength; i++){
                if(strChars[i] != str.get(i))
                        equals = false;
                else
                    equals = true;
            }  
        }
        return equals;
    }
    
    public int compareTo(MyString str){
       int count=0;
       
       if(currLength < str.length()){
           while(count<currLength){
               if((int)strChars[count] < (int)str.get(count)){
                   return -1;
                   
               }
               else if((int)strChars[count] > (int)str.get(count)){
                   return 1;
               }
               else
                   count++;
           }
           return -1;
       }
       
       else if(str.length() < currLength){
           while(count<str.length()){
               if((int)strChars[count] < (int)str.get(count)){
                   return -1;
                   
               }
               else if((int)strChars[count] > (int)str.get(count)){
                   return 1;
               }
               else
                   count++;
           }
           return 1;
       }
       
       else{
           while(count<currLength){
               if((int)strChars[count] < (int)str.get(count)){
                   return -1;
                   
               }
               else if((int)strChars[count] > (int)str.get(count)){
                   return 1;
               }
               else
                   count++;
           }
           return 0;
       }
    }
    //returns value at index in the char[] strChars;    
    public char get(int index){
        //this is only used when called by an empty MyString
        if(currLength == 0){ 
            return '\0'; //returns null char
        }
        else
            return strChars[index];
    }
    
    public MyString toUpper(){
        for(int i=0; i<strChars.length; i++){
            if((int)strChars[i]>=97 && (int)strChars[i]<=122){
                int temp = (int)strChars[i]-32; 
                char temp2 = (char)temp;
                strChars[i] = temp2;
            }
        }
        return this;
    }
    
    public MyString toLower(){
        for(int i=0; i<strChars.length; i++){
            if((int)strChars[i]>=65 && (int)strChars[i]<=90){
                int temp = (int)strChars[i]+32; 
                char temp2 = (char)temp;
                strChars[i] = temp2;
            }
        }
        return this;
    }

    public int indexOf(MyString str){
       int count=0;
       int index;
       int strLength = str.length();
       if(currLength < strLength){
           index=-1;
       }
       else{
            for(int i=0; i<currLength-strLength+1; i++){
                for(int j=0; j<strLength; j++){
                    if(strChars[i+j] == str.get(j)){
                        count++;
                        if(count == strLength){
                            return i; 
                        }
                    }
                    else{
                        count=0;
                        break;
                    }
                }
            }
        index=-1;
       }
       return index;
    }
    
    public int lastIndexOf(MyString str){
       int count=0;
       int index;
       int strLength = str.length();
       if(currLength < strLength){
           index=-1;
       }
       else{
            for(int i=0; i<currLength-strLength+1; i++){
                for(int j=0; j<strLength; j++){
                    if(strChars[i+j] == str.get(j)){
                        count++;
                        if(count == strLength){
                            return i+j; 
                        }
                    }
                    else{
                        count=0;
                        break;
                    }
                }
            }
        index=-1;
       }
       return index;
    }
    
    public MyString substring(int start){
        int newLength = currLength - start;
        char[] temp = new char[newLength];
        int count = 0;
        for(int i=start; i<currLength; i++){
            temp[count] = strChars[i];
            count++;
        }
        ensureCapacity(newLength);
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = temp[i];
        }
        return this;
    }
    
    public MyString substring(int start, int end){
        int newLength = end-start;
        char[] temp = new char[newLength];
        int count =0;
        for(int i=start; i<end; i++){
           temp[count] = strChars[i];
           count++;
        }
        ensureCapacity(newLength);
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = temp[i];
        }
        return this;
    }
}//end MyString