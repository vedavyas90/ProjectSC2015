/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.ArrayList;

/**
 *
 * @author aidb
 */
public class FeatureSentenceMap {
    
    public ArrayList<Feature> getContextFeaturesForSentences(ArrayList<Sentence> sent){
        ArrayList<Feature> fs = new ArrayList<>();
        for(Sentence s : sent){
            for(CorrectWord confusedWord : s.correctWords){
                for(String feat : s.getNeighbourWords(3) ){
                Feature f = new ContextWord(feat,confusedWord.correctWord,s.id);
                fs.add(f);
            }
            }
            
        }
        return fs;
    }
    
}
