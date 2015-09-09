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
        
        correctWordErrors();
       
    }
    
    public static void correctWordErrors(){
         ArrayList<String> typos = Utilities.readTypos();
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
       ArrayList<CorrectWord>  rankedWordsArray = rankedWords.filter(l -> l.lexicalRank <= 10).collect(Collectors.toCollection(ArrayList::new));
       
                
        
        if(Utilities.debug){
        rankedWords.forEach(s ->
           System.out.println(s.correctWord + " " + s.lexicalEd + " " + s.lexicalRank));
        }
        else{
            System.out.print(typo + "\t");
        for(int j =0; j< 10 && rankedWordsArray.size() >j ; ++ j)
           System.out.print(rankedWordsArray.get(j).correctWord + "\t" + rankedWordsArray.get(j).lexicalRank + "\t");
            System.out.println();
        }
        }
    }
}
