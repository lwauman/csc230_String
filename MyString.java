/*
 * Author: Lucas W. Auman
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class MyString {
    private char[] strChars;//holds chars of MyString object
    private int currLength;//holds the length of strChars
    
    //no arg constructor. Initializes strChars and currLength
    public MyString(){
        strChars = new char[0];
        currLength = strChars.length;
    }
    
    //Constructor that accepts a string. Initializes strChars and populates it
    //and initializes currLength
    public MyString(String str){
        strChars = new char[str.length()];
        currLength = str.length();
        for(int i=0; i<currLength; i++){
            strChars[i] = str.charAt(i);
        }
    }
    
    //Constructor that accepts a MyString object. Initalizes and populates strChars
    //and currLength such that this MyString is a copy of the parameter. 
    public MyString(MyString str){
        currLength = str.length();
        strChars = new char[currLength];
        for(int i=0; i<currLength; i++){
            strChars[i] = str.get(i);
        }
    }
    
    //Returns the lenght of strChars
    public int length(){
        return strChars.length;
    }
    
    //changes the length of CurrLength to the int that is passed. Generally used
    //when concat is used.
    private void ensureCapacity(int length){
        currLength = length;  
    }
    
    //returns a string representation of the MyString object
    public String toString(){
        String toString="";
        for(int i=0; i<strChars.length; i++){
            toString += String.valueOf(strChars[i]);
        }
        return toString;
    }
    
    //returns a new MyString object that is the combination of the two MyString
    //objects
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
    
    //returns a new MyString object that is the combination of the MyString object
    //and the string that was passed
    public MyString concat(String str){
        String tempHolder =""; //holds the combination of 
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
    
    //checks to see if the two MyString objects are the same. If so returns true
    //if not returns false
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
    
    /*
    compares two MyString objects. If they are equal returns 0, if the calling
    MyString object comes first alphabetically returns -1 and returns 1 if the
    calling MyString object comes after the parameter.
    */
    public int compareTo(MyString str){
       int index=0; 
       //checking length is needed to avoid out of bound errors
       //this block is used when the parameter has more characters than the calling object
       if(currLength < str.length()){ 
           while(index<currLength){
               if((int)strChars[index] < (int)str.get(index)){
                   return -1; //this means that the calling object came before the parameter
               }
               else if((int)strChars[index] > (int)str.get(index)){
                   return 1; //this means that the calling object came after the parameter
               }
               else
                   index++; //checks next index
           }
           //if it makes it to this point then it means that the calling object and the parameter 
           //are the same for all of the calling object's characters but the parameter has more characters.
           //for example: Lucas(calling object) and Lucas Auman(parameter)
           return -1; //calling object comes before parameter
       }
       //this is the same as above except the calling object has more characters than the parameter
       else if(str.length() < currLength){
           while(index<str.length()){
               if((int)strChars[index] < (int)str.get(index)){
                   return -1; 
                   
               }
               else if((int)strChars[index] > (int)str.get(index)){
                   return 1; 
               }
               else
                   index++;
           }
           return 1;
       }
       //this block is used when the calling object and parameter have the same number of characters
       else{
           while(index<currLength){
               if((int)strChars[index] < (int)str.get(index)){
                   return -1;
                   
               }
               else if((int)strChars[index] > (int)str.get(index)){
                   return 1;
               }
               else
                   index++;
           }
           //if it gets to this point then the calling object and the parameter are the same
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
    
    //converts all nonuppercase characters to uppercase
    public MyString toUpper(){
        for(int i=0; i<strChars.length; i++){
            //if the character value is between 97-122 (97 and 122 included)
            //this block is used and it converts it to uppercase.
            if((int)strChars[i]>=97 && (int)strChars[i]<=122){
                int temp = (int)strChars[i]-32; 
                char temp2 = (char)temp;
                strChars[i] = temp2;
            }
        }
        return this;
    }
    
    //converts all nonlowercase characters to lowercase
    public MyString toLower(){
        for(int i=0; i<strChars.length; i++){
            //if the character value is between 65-90 (65 and 90 included)
            //this block is used and it converts it to lowercase.
            if((int)strChars[i]>=65 && (int)strChars[i]<=90){
                int temp = (int)strChars[i]+32; 
                char temp2 = (char)temp;
                strChars[i] = temp2;
            }
        }
        return this;
    }

    /*
    When this method is called it checks to see if the calling MyString object
    contains the parameter. To do this it first checks if the parameter is larger 
    than the calling object becuase if that is true the calling object cannot contain 
    the parameter. Next, it loops through both the calling object's character array 
    and the parameter's character array. If two character are the same the count
    variable is incremented. If at any point the count variable is equal to the parameter
    length then a match was found and the initial index is returned. If two characters are
    the same and the inner loop keeps checking and it turns out that it isn't a match 
    the count variable is reset to 0 and the outer loop is incremented to check the 
    next character. If no match is found -1 is returned. 
    */
    public int indexOf(MyString str){
       int count=0;
       int index;
       int strLength = str.length();
       if(currLength < strLength){
           //if this is true them the calling object cannot contain the parameter
           index=-1;
       }
       else{
           //in the for loop below currLength-strLength+1 is needed to avoid
           //out of bound errors because in the nested if loop the two iterating 
           //variables are added togther
            for(int i=0; i<currLength-strLength+1; i++){
                for(int j=0; j<strLength; j++){
                    //the two iterating variables are added together to allow
                    //checking the index of both without incrementing the outerloop
                    if(strChars[i+j] == str.get(j)){
                        count++;
                        if(count == strLength){
                            return i; //match was found. i is the starting index
                        }
                    }
                    else{
                        //if this block is used it means that two characters matched
                        //but after continued looping didn't turn out to be the same
                        //example: Welcome(calling object) and mystring(parameter)
                        //would match at index 5 of calling object but at index 6 do not
                        count=0;
                        break; //breaks out to outer loop
                    }
                }
            }
        index=-1; //if it makes it this point then no match was found
       }
       return index;
    }
    
    //this method works the same as the method above with the one exception that
    //if a match is found the number that is returned is the ending index of the 
    //match. Meaning that if you are searching for mystring in Welcome to mystring
    //18 is returned. 
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
    
    /*
    This method takes any int and uses it to create a new MyString object. 
    First it calculates the new array size and populates it starting at 
    the index provided. 
    */
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
    
    /* 
    This method accepts two ints. The first marks where in strChars the new 
    MyString should start and the second marks where it should end. 
    */
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