package maven.archetype.quickstart.TermFrequency;

import java.io.*;
import java.util.*;

public class DocumentParser {

	    //This variable will hold all terms of each document in an array.
	    public List<String[]> termsFiles= new ArrayList<String[]>();
	    public List<String> allTerms = new ArrayList<String>(); //to hold all terms
	    public List<double[]> tfidfArray = new ArrayList<double[]>();

	  
	     // Method to read files and store in array.
	     
	    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
	        File[] allfiles = new File(filePath).listFiles();
	        BufferedReader in = null;                           
	        for (File f : allfiles) {
	            if (f.getName().endsWith(".txt")) {              //retrieve only the *.pdf files
	                in = new BufferedReader(new FileReader(f)); //read the file line by line
	                StringBuilder sb = new StringBuilder();
	                String s = null;
	                while ((s = in.readLine()) != null) {         //while the text line is not empty add new string in the sb StringBuilder
	                    sb.append(s);
	                }
	                String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms and remove the punctuation(comas,semicolons)
	                for (String term : tokenizedTerms) {
	                    if (!allTerms.contains(term)) {  //avoid duplicate term entry
	                        allTerms.add(term);
	                    }
	                }
	                termsFiles.add(tokenizedTerms);
	            }
	        }

	    }
	    
	    
	     // Method to create termVector according to its tfidf score.
	     
	    public void tfIdfCalculator() {
	        double tf; //term frequency
	        double idf; //inverse document frequency
	        double tfidf=0; //term frequency inverse document frequency
            int count = 0;
	        for (String[] docTermsArray : termsFiles) {
	            double[] tfidfvectors = new double[allTerms.size()];
	            for (String terms : allTerms) {
	                tf = new TfIdf().computetf(docTermsArray,terms );
	                idf = new TfIdf().computeidf(termsFiles, terms);
	                tfidf = tf * idf;
	                tfidfvectors[count] = tfidf;
	                count++;
	            }
	            tfidfArray.add(tfidfvectors);  //storing document vectors;
	        }
	        
	    }

}
