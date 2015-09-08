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
public class CorrectWord {
    public String typo;
    public String correctWord;
    public int lexicalEd;
    public int lexicalRank;
    public int dictCount;
    
    public CorrectWord(String s, int ed){
        correctWord = s;
        lexicalEd = ed;
        dictCount = Utilities.countOfWord(s);
    }
    /*
    public CorrectWord(String s){
        correctWord = s;
    }
   */ 
}
