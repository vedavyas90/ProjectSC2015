/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

/**
 *
 * @author aidb
 */
public abstract class Feature {
    
    public String featureString;
    public String confusedWord;
    public int sentenceId;
    public Feature(String feat,String c,int sId){
        featureString = feat;
        confusedWord = c;
        sentenceId = sId;
    }
    
    public long getFeatureAndWordCount(){
        return 100;
    }
   
     public long getWordCount(){
        return 100;
    }
     
    /**
     *returns true if it crosses min. threshold
     * and passes chi-square test
     * @return
     */
    public boolean isValid(){
        return true;
    } 
   
   
}
