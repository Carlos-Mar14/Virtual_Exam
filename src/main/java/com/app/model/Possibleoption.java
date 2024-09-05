package com.app.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Tere
 */
@Entity
@Table(name = "possibleoption")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possibleoption.findAll", query = "SELECT p FROM Possibleoption p"),
    @NamedQuery(name = "Possibleoption.findByPossibleOptionId", query = "SELECT p FROM Possibleoption p WHERE p.possibleOptionId = :possibleOptionId"),
    @NamedQuery(name = "Possibleoption.findByIsCorrect", query = "SELECT p FROM Possibleoption p WHERE p.isCorrect = :isCorrect")})
public class Possibleoption implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "possibleOptionId")
    private Integer possibleOptionId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "optionText")
    private String optionText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isCorrect")
    private boolean isCorrect;
    @JoinColumn(name = "questionId", referencedColumnName = "questionId")
    @ManyToOne(optional = false)
    private Question questionId;

    public Possibleoption() {
    }

    public Possibleoption(Integer possibleOptionId) {
        this.possibleOptionId = possibleOptionId;
    }

    public Possibleoption(Integer possibleOptionId, String optionText, boolean isCorrect) {
        this.possibleOptionId = possibleOptionId;
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

    public Integer getPossibleOptionId() {
        return possibleOptionId;
    }

    public void setPossibleOptionId(Integer possibleOptionId) {
        this.possibleOptionId = possibleOptionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possibleOptionId != null ? possibleOptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possibleoption)) {
            return false;
        }
        Possibleoption other = (Possibleoption) object;
        if ((this.possibleOptionId == null && other.possibleOptionId != null) || (this.possibleOptionId != null && !this.possibleOptionId.equals(other.possibleOptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.examen_virtual.Possibleoption[ possibleOptionId=" + possibleOptionId + " ]";
    }

}