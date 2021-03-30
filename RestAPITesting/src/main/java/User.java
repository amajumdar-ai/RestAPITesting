import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class User {
	
	    public static void main(String[] args) 
	    { 
	       
	        int length = 100; 
	        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
	        String numbers = "0123456789"; 
	                String symbols = "!@#$%^&*_=+-/.?<>)"; 
	  
	  
	        String values = Capital_chars + Small_chars + 
	                        numbers + symbols; 
	        String user=Capital_chars + Small_chars+numbers;
	  
	       
	        Random rndm_method = new Random(); 
	  
	        char[] password = new char[length]; 
	        char[] username=new char[length];
	  
	        for (int i = 0; i <length; i++) 
	        { 
	           
	            password[i] = 
	              values.charAt(rndm_method.nextInt(values.length())); 
	            username[i]=user.charAt(rndm_method.nextInt(user.length())); 
	            System.out.println("username is : "+username.toString() + " "+"password is :"+password.toString());
	  
	        } 
	       
	    } 
}