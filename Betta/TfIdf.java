package maven.archetype.quickstart.TermFrequency;

import java.util.*;



public class TfIdf {

    public double computetf(String[] totalterms, String term_to_verify) {
        double count = 0;                   //to count the overall occurrence of the term term_to_verify
        for (String s : totalterms) {
            if (s.equalsIgnoreCase(term_to_verify)) {
                count++;
            }
        }
        return count /(float)totalterms.length;
    }

    
    
 
    public double computeidf(List<String[]> files, String term) {
        double n = 0;
        for (String[] doc : files) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return 1+Math.log(files.size() / n);
    }
    

}
