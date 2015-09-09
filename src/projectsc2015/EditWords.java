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
public class EditWords {

    /**
     *Finds all dictionary words which are 
     *single unit edit distance from the typo
     *and return those words
     * @param typo
     * @param threshold 
     * signifies minimum value in the confusion matrices
     * @return
     */
    public ArrayList<CorrectWord> singleEditWords(boolean checkInDict,String typo, int threshold, int currentEd){
       
        //contains all dictionary words
        ArrayList<String> dictWords;
        dictWords = new ArrayList<>();
        
        dictWords.addAll(correctAdd(checkInDict,typo,threshold));
        dictWords.addAll(correctDel(checkInDict,typo,threshold));
        dictWords.addAll(correctSub(checkInDict,typo,threshold));
        
        //contains all dictionary words
        ArrayList<CorrectWord> correctWords;
        correctWords = new ArrayList<>();
        for(String s: dictWords ){
            correctWords.add(new CorrectWord(s,currentEd + 1));
        }
        
        
        return correctWords;
    }
    
    public ArrayList<CorrectWord> editWords(String typo, int []threshold){
        
        ArrayList<CorrectWord> dictWords;
        dictWords = new ArrayList<>();
        for(int i = 0; i< threshold.length;i++){
            if(i == 0 && i == threshold.length - 1)
                dictWords.addAll(singleEditWords(true,typo,threshold[i],0));
            else if(i == 0 && i != threshold.length - 1){
                dictWords.addAll(singleEditWords(false,typo,threshold[i],0));
            }
            else  if(i == threshold.length - 1){
                 dictWords.addAll(singleEditWords(true,dictWords,threshold[i],i));
            }
            else  if(i != threshold.length - 1){
                 dictWords.addAll(singleEditWords(false,dictWords,threshold[i],i));
            }
        }
        return dictWords;
    }
    
     public ArrayList<CorrectWord> singleEditWords(boolean checkInDict,ArrayList<CorrectWord> typo, int threshold, int currentEd){
        
        ArrayList<CorrectWord> dictWords;
        dictWords = new ArrayList<>();
        for(CorrectWord s:typo){  
          dictWords.addAll(singleEditWords(checkInDict,s.correctWord,threshold,currentEd));
        }  
         return dictWords;
    }
    
    //Take care of inadvertent additions made to the typo
     private ArrayList<String> correctAdd(boolean checkInDict,String t, int threshold){
         
        ArrayList<String> dictWords;
        dictWords = new ArrayList<>(); 
        String newWord;
        for(int i=0; i<t.length() - 1;++i){
            if(ConfusionMatrix.add[charToInt(t.charAt(i))][charToInt(t.charAt(i+1))] >= threshold){
                if(t.length() > i+2){
                   // String a = t.substring(0, i+1);
                   // String b = t.substring(i+2);
                    newWord = t.substring(0,i+1) + t.substring(i+2);
                }
                else
                    newWord = t.substring(0,i+1);
                
               if(checkInDict && Utilities.isDictWord(newWord))
                   dictWords.add(newWord);
               else if (!checkInDict)
                   dictWords.add(newWord);
            }
            
        }
        
        return dictWords;
     }
    
     //Take care of inadvertent deletions made to the typo
     private ArrayList<String> correctDel(boolean checkInDict,String t, int threshold){
         
        ArrayList<String> dictWords;
        dictWords = new ArrayList<>(); 
        String newWord;
        
        //Add character at beginning
        for(int i1=0; i1<26;++i1){
            newWord = intToChar(i1)+ t;
            if(Utilities.isDictWord(newWord))
                   dictWords.add(newWord);
        }
        
        for(int i=0; i<t.length();++i){
            for(int i1=0; i1<26;++i1){
            if(ConfusionMatrix.del[charToInt(t.charAt(i))][i1] >= threshold){
                if(t.length() > i+1){
                   newWord = t.substring(0,i+1) + intToChar(i1) +t.substring(i+1);
                }
                else
                    newWord = t.substring(0,i+1) + intToChar(i1);
               // if(newWord.equals("believe"))
              if(checkInDict && Utilities.isDictWord(newWord))
                   dictWords.add(newWord);
               else if (!checkInDict)
                   dictWords.add(newWord);
            }
            
         }
        }
        return dictWords;
     }
    
     
     //Take care of inadvertent substitutions made to the typo
     private ArrayList<String> correctSub(boolean checkInDict,String t, int threshold){
         
        ArrayList<String> dictWords;
        dictWords = new ArrayList<>(); 
        String newWord;
        char[] myNameChars = t.toCharArray();
        for(int i=0; i<t.length();++i){
            for(int i1=0; i1<26;++i1){
            if(ConfusionMatrix.sub[charToInt(t.charAt(i))][i1] >= threshold){
                
                myNameChars[i] = intToChar(i1);
                newWord = String.valueOf(myNameChars);
               myNameChars = t.toCharArray();
               
              if(checkInDict && Utilities.isDictWord(newWord))
                   dictWords.add(newWord);
               else if (!checkInDict)
                   dictWords.add(newWord);
            }
            
            }
        }
        
        return dictWords;
     }
    
     private int charToInt(char c){
         return c -'a';
     }
     
     private char intToChar(int i){
         return (char)(i + 'a');
     }
}
