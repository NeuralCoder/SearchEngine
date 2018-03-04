package maven.archetype.quickstart.TermFrequency;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	   public static void main(String args[]) throws FileNotFoundException, IOException
	    {
		    
	        DocumentParser objparser = new DocumentParser();
	        objparser.parseFiles("F:\\Job\\Atigeo"); // give the location of source file
	        objparser.tfIdfCalculator();      
	    }
}
