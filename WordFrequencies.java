import java.util.ArrayList;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    
    private ArrayList<String> myword;
    private ArrayList<Integer>myfreq;
    
    public WordFrequencies(){
        myword = new ArrayList<String>();
        myfreq = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myword.indexOf(s);
            
            if(index == -1){
                myword.add(s);
                myfreq.add(1);
            }
            else{
                int value = myfreq.get(index);
                myfreq.set(index , value + 1);
            }
        }
    }
    
    public void getWordFrequencies(){
        findUnique();
        System.out.println("#Unique Words :"  + myword.size());
        
        // for(int k = 0 ; k < myword.size() ; k = k+1){
            // System.out.println(myfreq.get(k) + " \t " + myword.get(k));
        // }
    }
    
    public void findindexOfMax(){
        WordFrequencies wf = new WordFrequencies();
        wf.findUnique();
        int max = 0;
        String value = " ";
        for(int i = 0 ; i < myfreq.size() ; i++){
            if(myfreq.get(i) > max){
                max = myfreq.get(i);
                value = myword.get(i);
            }
            
        }
        System.out.println("The word that occurs most often and its count are: " + value + " "+ max);
    }
    
    public void getIndexOfMax(){
        findindexOfMax();
    }
}
