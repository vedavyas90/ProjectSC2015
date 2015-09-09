/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aidb
 */
public class Utilities {
    
    static DicGen dic;
    static String typoPath = "src/TestData/words.txt";        
    public static boolean debug = false;
    public static boolean isDictWord(String s){
        //return true;
        return dic.dict.isDictWord(s);
    }
    public static long countOfWord(String s){
     //return 100;
        return dic.dict.countOfWord(s);
        
    }
    
    public static ArrayList<String> removeDuplicates(ArrayList<String> values){
        
        ArrayList<String> dictWords;
        dictWords = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<String>(values);
        for (String value : uniqueValues) {
            dictWords.add(value);
        }
        return dictWords;
    }
    
    public static ArrayList<String> readTypos(){
        return readFile(new File(typoPath));
    }
    
     private static ArrayList<String> readFile(File file) {
                ArrayList<String> inputs = new ArrayList<>();
 		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String sCurrentLine;
                        while ((sCurrentLine = br.readLine()) != null) {
				inputs.add(sCurrentLine);
                                
                        }
		} catch (IOException e) {
			e.printStackTrace();
		} 
                return inputs;
               
    }
}
