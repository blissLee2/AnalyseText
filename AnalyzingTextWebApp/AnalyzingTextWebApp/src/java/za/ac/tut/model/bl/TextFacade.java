 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Text;

/**
 *
 * @author Innocent Mohoerane
 */
@Stateless
public class TextFacade extends AbstractFacade<Text> implements TextFacadeLocal {

    @PersistenceContext(unitName = "AnalyzingTextWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TextFacade() {
        super(Text.class);
    }

    @Override
    public Integer shrtMessageLength(String shrtMsg) {
        Integer msgLength = shrtMsg.length();
        
        return msgLength;
    }

    @Override
    public Integer totalNumVowels(String shrtMsg) {
        Integer cntA =0, cntE =0, cntI =0, cntO =0, cntU =0;
        String msg = shrtMsg.toLowerCase();
        
        for(int i=0;i<shrtMsg.length();i++){
            
        if(msg.charAt(i)=='a'){
            cntA++;
        }else if(msg.charAt(i)=='e'){
            cntE++;
        }else if(msg.charAt(i)=='i'){
            cntI++;
        }else if(msg.charAt(i)=='o'){
            cntO++;
        }else if(msg.charAt(i)=='u'){
            cntU++;
        }
        
        }
        
        Integer totVowel = cntA + cntE + cntI + cntO + cntU;
        
        return totVowel;
    }

    @Override
    public Integer totalNumConsonants(String shrtMsg) {
        Integer totVowels = totalNumVowels(shrtMsg);
        Integer totCons =0;
        
        for(int i=0;i<shrtMsg.length();i++){
            
            if(Character.isLetter(shrtMsg.charAt(i))){
                totCons++;
            }
        }
        
        Integer totalNumCon = totCons-totVowels;
        
        return totalNumCon;
    }

    @Override
    public String nonRepeatingLetters(String shrtMsg) {
        String result = " ";
        
        for(int i=0;i<shrtMsg.length();i++){
            String msg = shrtMsg.toLowerCase();
            char current = msg.charAt(i);
            
            if(Character.isLetter(current)){
                int count = 0;
                
                for(int c=0;c<shrtMsg.length();c++){
                    char compare = msg.charAt(c);
                    
                    if(current == compare){
                        count++;
                    }
                }
                if(count == 1){
                    result = result + current + " ";
                }
            }
        }
        return result;
    }

    @Override
    public String repeatingLetters(String shrtMsg) {
        String result = " ";
        
        for(int i=0;i<shrtMsg.length();i++){
            String msg = shrtMsg.toLowerCase();
            char current = msg.charAt(i);
            
            if(Character.isLetter(current)){
                int count = 0;
                
                for(int c=0;c<shrtMsg.length();c++){
                    char compare = msg.charAt(c);
                    
                    if(current == compare){
                        count++;
                    }
                }
                //if appears more than once
                if(count > 1){
                    if(result.indexOf(current) == -1)
                    result = result + current + " ";
                    
                }
                
            }
        }
        return result;
    }

    @Override
    public Text displayTheLongenstMessage() {
        String jpqlQuery = "SELECT t FROM Text t WHERE t.shrtLength = (SELECT MAX(tm.shrtLength) FROM Text tm )";
        Query query = em.createQuery(jpqlQuery);
        Text text = (Text)query.getSingleResult();
        
        return text;
        
    }
    
}
