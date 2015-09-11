package projectsc2015;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aidb
 */
public class Sentence {
    
    public String sentence;
    public String typo;
    public int typoIndex;
    public  ArrayList<CorrectWord> correctWords;
    public int id;
    
    public Sentence(int _id){
        id = _id;
    }
    
    public ArrayList<String> getNeighbourWords(int windowSize){
        return null;
    }
    
}
