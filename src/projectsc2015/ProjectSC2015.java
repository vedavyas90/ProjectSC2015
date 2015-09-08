/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.ArrayList;
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
        String typo = "ad";
        EditWords w = new EditWords();
        
        ArrayList<CorrectWord> dictWords;
        dictWords = new ArrayList<>();
        int [] threshold = {100,100};
        dictWords.addAll(w.editWords(typo, threshold));
       
       // for(CorrectWord s : dictWords)
        //    System.out.println(s.correctWord + " " + s.lexicalEd);
        Rank rank = new Rank(dictWords);
        Stream<CorrectWord> rankedWords = rank.rank();
        rankedWords.forEach(s ->
           System.out.println(s.correctWord + " " + s.lexicalEd + " " + s.lexicalRank));
        
    }
    
    
}
