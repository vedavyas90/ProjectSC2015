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
    public Feature(String feat,String c){
        featureString = feat;
        confusedWord = c;
    }
    
}
