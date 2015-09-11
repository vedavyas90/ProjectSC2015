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
 * @author aidb
 */
public class WordCorrectionProcess {
    
     public void correctWordErrors(int candidateCount,ArrayList<String> typos){
         
        for(String typo :typos){
        EditWords w = new EditWords();
        
        ArrayList<CorrectWord> dictWords;
        dictWords = new ArrayList<>();
        int [] threshold = {0,10,10};
        dictWords.addAll(w.editWords(typo, threshold));
       
       // for(CorrectWord s : dictWords)
        //    System.out.println(s.correctWord + " " + s.lexicalEd);
        
        Rank rank = new Rank(dictWords);
        Stream<CorrectWord> rankedWords = rank.rank();
        //int c = 0;
        //CorrectWord [] rankedWordsArray = rankedWords.toArray(size -> new CorrectWord[(int)(rankedWords.count())]);
       ArrayList<CorrectWord>  rankedWordsArray = rankedWords.filter(l -> l.lexicalRank <= candidateCount).collect(Collectors.toCollection(ArrayList::new));
       
       // if(returnCandidates)        
        //    return rankedWordsArray;
        
        if(Utilities.debug ){
        rankedWords.forEach(s ->
           System.out.println(s.correctWord + " " + s.lexicalEd + " " + s.lexicalRank));
        }
        else {
            System.out.print(typo + "\t");
        for(int j =0; j< 10 && rankedWordsArray.size() >j ; ++ j)
           System.out.print(rankedWordsArray.get(j).correctWord + "\t" + rankedWordsArray.get(j).lexicalRank + "\t");
            System.out.println();
        }
        }
        
    }
     
     public  ArrayList<CorrectWord> correctWordErrors(int candidateCount,String typo){
         
        
        EditWords w = new EditWords();
        
        ArrayList<CorrectWord> dictWords;
        dictWords = new ArrayList<>();
        int [] threshold = {0,10,10};
        dictWords.addAll(w.editWords(typo, threshold));
       
         
        Rank rank = new Rank(dictWords);
        Stream<CorrectWord> rankedWords = rank.rank();
        ArrayList<CorrectWord>  rankedWordsArray = rankedWords.filter(l -> l.lexicalRank <= candidateCount).collect(Collectors.toCollection(ArrayList::new));
        return rankedWordsArray;
        
     }
        
    
}
