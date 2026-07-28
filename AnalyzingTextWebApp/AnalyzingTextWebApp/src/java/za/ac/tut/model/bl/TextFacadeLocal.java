/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Text;

/**
 *
 * @author Innocent Mohoerane
 */
@Local
public interface TextFacadeLocal {

    void create(Text text);

    void edit(Text text);

    void remove(Text text);

    Text find(Object id);

    List<Text> findAll();

    List<Text> findRange(int[] range);

    int count();
    
    //Add more methods
    Integer shrtMessageLength(String shrtMsg);
    Integer totalNumVowels(String shrtMsg);
    Integer totalNumConsonants(String shrtMsg);
    String nonRepeatingLetters(String shrtMsg);
    String repeatingLetters(String shrtMsg);
    Text displayTheLongenstMessage();
}
