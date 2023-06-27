package Practice_Project2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {
	
	    public static void main(String[] args) {
	    	//set a path for file creation
	        String filePath = "C:\\Users\\Anusha\\Desktop\\file\\filetxt1.txt";					

	        // Write to file
	        writeFileUsingFileOutputStream(filePath, "Hello welcome to File Handling");

	        // Read from file
	        String content = readFileUsingFileInputStream(filePath);
	        System.out.println("File content: " + content);

	        // Append to file
	        appendFileUsingFileOutputStream(filePath, " Appended content");

	        // Read from file again
	        content = readFileUsingFileInputStream(filePath);
	        System.out.println("Updated file content: " + content);
	    }

	   
	    public static void writeFileUsingFileOutputStream(String filePath, String content) 
	    {
	        try (FileOutputStream fos = new FileOutputStream(filePath)) 
	        {
	            fos.write(content.getBytes());
	            System.out.println("Content written to file successfully.");
	        } 
	        catch (IOException e) 
	       	{
	           	System.out.println("Error occurred while writing to the file: " + e.getMessage());
	       	}
	    }
	    

	   
	    public static String readFileUsingFileInputStream(String filePath) 
	    {
	        StringBuilder content = new StringBuilder();
	        try (FileInputStream fis = new FileInputStream(filePath)) 
	        {
	            int ch;
	            while ((ch = fis.read()) != -1) 
	            {
	                content.append((char) ch);
	            }
	        } 
	        catch (IOException e) 
	        {
	            System.out.println("Error while reading the file: " + e.getMessage());
	        }
	        return content.toString();
	    }
	    

	    public static void appendFileUsingFileOutputStream(String filePath, String content) 
	    {
	        try (FileOutputStream fos = new FileOutputStream(filePath, true)) 
	        {
	            fos.write(content.getBytes());
	            System.out.println("Content appended to file successfully.");
	        } 
	        catch (IOException e) 
	        {
	            System.out.println("Error while appending to the file: " + e.getMessage());
	        }
	    }
}


