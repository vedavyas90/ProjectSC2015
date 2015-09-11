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
public class ContextWord  extends Feature{

    
 /**
 *
 * @author aidb
     * @param feature feature is feature word(+ or - 3 context word)
     * @param confusedWord confused words are found from dictionary
 */
    public ContextWord(String feature,String confusedWord,int sId) {
        super(feature,confusedWord,sId);
    }
    
}
