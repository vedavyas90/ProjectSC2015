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
public class SentencePreprocess {

    WordCorrectionProcess wcp;
    ArrayList<Sentence> sentences;
    public SentencePreprocess(ArrayList<String> _sentences,WordCorrectionProcess _wcp) {
        this.wcp = _wcp;
        
    }

    public ArrayList<Sentence> getPreprocessedSentences() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
