/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


/**
 *
 * @author Vedavyas
 */
class TrieNode 
{
    char content; 
    boolean isEnd; 
    long count;  
    LinkedList<TrieNode> childList; 
 
    /* Constructor */
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}

class Trie
{
    private TrieNode root;
 
     /* Constructor */
    public Trie()
    {
        root = new TrieNode(' '); 
    }
 
    /* Function to insert word */
    public void insert(String word,long count)
    {
        if (isDictWord(word) == true)//if already exists 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            //current.count++;
        }
        current.isEnd = true;
        current.count=count;
    }
    
    /* Function to search for word */
    public boolean isDictWord(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    
    /* Function to return word count */
    public long countOfWord(String word){
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return 0;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return current.count;
        return -1;
        
    }
}    
 
public class DicGen {
    public Trie dict=new Trie();
    
    
    private void readFile(File file) {
 		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String sCurrentLine;
                        String[] tokensVal;
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
                                tokensVal = sCurrentLine.split("	");
                                //System.out.println("word: "+tokensVal[0]+" and WordCount: "+Long.parseLong(tokensVal[1]));
                                dict.insert(tokensVal[0].toLowerCase(), Long.parseLong(tokensVal[1]));
                                
                        }
		} catch (IOException e) {
			e.printStackTrace();
		} 
              
                //printKMostFreq (fp, k);
    }
    
        public void listFilesForFolder(final File folder) {
            String file;
            for (final File fileEntry : folder.listFiles()) {
                    file=fileEntry.getName();
                   // System.out.println("reading from: "+file);
                    readFile(fileEntry);
            
            }
             
            //System.out.println("Dictionary created");
         
        }
 //   public static void main1 (String []args){
//        System.out.println(" Enter the path of directory ...");
//        Scanner scn=new Scanner(System.in);
        public DicGen(){
        String dirpath="src/Directory"; //scn.next();
           // DicGen dic=new DicGen();
            final File folder = new File(dirpath);
           listFilesForFolder(folder);
            
            //Testing
          /*  String testWord="TH";
            if(dict.isDictWord(testWord)){
             System.out.println("wordcount of: "+testWord+ " is: " +dict.countOfWord(testWord));
            }else
              System.out.println(testWord+ " is not a word of dictionary " );  
           */ 
	}

    
}
