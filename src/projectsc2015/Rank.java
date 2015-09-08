/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author aidb
 */
public class Rank {
     ArrayList<CorrectWord> correctWords;
     int lr = 1;
     public Rank(ArrayList<CorrectWord> c){
         correctWords = c;
     }
     
    public  Stream<CorrectWord> rank(){
        calLexRank();
        return correctWords.stream().sorted((e1,e2) -> Integer.compare(e1.lexicalRank,e2.lexicalRank));
                
    }
     private void calLexRank(){
         
    //First sort By Ed then by word count and finally rank
    Comparator<CorrectWord> bylexicalEd = (e1, e2) -> Integer.compare(e1.lexicalEd ,e2.lexicalEd);
    
    Comparator<CorrectWord> byWordCount;
         byWordCount = (e1, e2) -> Integer.compare(e1.dictCount ,e2.dictCount);


    correctWords.stream().sorted(bylexicalEd.thenComparing(byWordCount))
            .forEach(e -> e.lexicalRank = lr++);
         
             
         
     }
}
