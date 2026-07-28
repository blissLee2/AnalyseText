/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Innocent Mohoerane
 */
@Entity
public class Text implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shrtMessage;
    private Integer shrtLength;
    private Integer totNumVowels;
    private Integer totNumConsonants;
    @ElementCollection
    private List<String> uniqueLetters = new ArrayList<>();
    @ElementCollection
    private List<String> nonUniqueLetters = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Text() {
    }

    public Text(Long id, String shrtMessage, Integer shrtLength, Integer totNumVowels, Integer totNumConsonants, Date creationDate) {
        this.id = id;
        this.shrtMessage = shrtMessage;
        this.shrtLength = shrtLength;
        this.totNumVowels = totNumVowels;
        this.totNumConsonants = totNumConsonants;
        this.creationDate = creationDate;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShrtMessage() {
        return shrtMessage;
    }

    public void setShrtMessage(String shrtMessage) {
        this.shrtMessage = shrtMessage;
    }

    public Integer getShrtLength() {
        return shrtLength;
    }

    public void setShrtLength(Integer shrtLength) {
        this.shrtLength = shrtLength;
    }

    public Integer getTotNumVowels() {
        return totNumVowels;
    }

    public void setTotNumVowels(Integer totNumVowels) {
        this.totNumVowels = totNumVowels;
    }

    public Integer getTotNumConsonants() {
        return totNumConsonants;
    }

    public void setTotNumConsonants(Integer totNumConsonants) {
        this.totNumConsonants = totNumConsonants;
    }

    public List<String> getUniqueLetters() {
        return uniqueLetters;
    }

    public void setUniqueLetters(List<String> uniqueLetters) {
        this.uniqueLetters = uniqueLetters;
    }

    public List<String> getNonUniqueLetters() {
        return nonUniqueLetters;
    }

    public void setNonUniqueLetters(List<String> nonUniqueLetters) {
        this.nonUniqueLetters = nonUniqueLetters;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Text)) {
            return false;
        }
        Text other = (Text) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.model.entity.Text[ id=" + id + " ]";
    }
    
}
