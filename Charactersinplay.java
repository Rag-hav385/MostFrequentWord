import java.util.ArrayList;
import edu.duke.*;
/**
 * Write a description of Charactersinplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charactersinplay {
    private ArrayList<String> myChar;
    private ArrayList<Integer>myfreq;
    
    public Charactersinplay(){
        this.myChar = new ArrayList<String>();
        this.myfreq = new ArrayList<Integer>();
        
    }
    
    public void update(String person){
        String name = person;
        int index = myChar.indexOf(name);
        
        if(index == -1){
            myChar.add(name);
            myfreq.add(1);
        }
        else{
            int value = myfreq.get(index);
            myfreq.set(index,value + 1);
        }
        
   
}
    
    public void findAllCharacters(){
        myChar.clear();
        myfreq.clear();
        FileResource fr = new FileResource();
        
        for(String s : fr.lines()){
        int enddex = s.indexOf('.');
        if(enddex != -1){
          s = s.substring(0 , enddex);
          update(s);
        
        }
        }
    }
    
    public void test(){
        findAllCharacters();
        
        for(int i = 0 ; i < myChar.size() ; i++){
            if(myfreq.get(i) > 1){
                System.out.println(myChar.get(i) + "\t" + myfreq.get(i));
            }
        }
    }
    
    public void charactersWithNumParts(int num1 , int num2){
        findAllCharacters();
        
        for(int i = 0 ; i < myChar.size() ; i++){
            if (myfreq.get(i) >= num1 && myfreq.get(i) < num2){
                System.out.println(myChar.get(i) + "\t" + myfreq.get(i));
            }
        }
    }
}
