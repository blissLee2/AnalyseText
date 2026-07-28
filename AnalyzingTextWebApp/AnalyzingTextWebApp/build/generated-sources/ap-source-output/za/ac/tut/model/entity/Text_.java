package za.ac.tut.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-05-08T02:48:43")
@StaticMetamodel(Text.class)
public class Text_ { 

    public static volatile ListAttribute<Text, String> uniqueLetters;
    public static volatile SingularAttribute<Text, Integer> totNumVowels;
    public static volatile SingularAttribute<Text, String> shrtMessage;
    public static volatile SingularAttribute<Text, Integer> totNumConsonants;
    public static volatile SingularAttribute<Text, Long> id;
    public static volatile SingularAttribute<Text, Integer> shrtLength;
    public static volatile ListAttribute<Text, String> nonUniqueLetters;
    public static volatile SingularAttribute<Text, Date> creationDate;

}