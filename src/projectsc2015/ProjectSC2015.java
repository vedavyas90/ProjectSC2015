/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Vedavyas
 */
public class ProjectSC2015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DicGen dic = new DicGen();
        Utilities.dic = dic;
        WordCorrectionProcess wcp = new WordCorrectionProcess();
        wcp.correctWordErrors(10,Utilities.readTypos());
        
        SentencePreprocess spp = new SentencePreprocess(Utilities.readPhrases(),wcp);
        ArrayList<Sentence> sent = spp.getPreprocessedSentences();
       
    }
    
   
}
