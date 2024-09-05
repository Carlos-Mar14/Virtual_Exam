package com.app.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Tere
 */
@Entity
@Table(name = "result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findByResultId", query = "SELECT r FROM Result r WHERE r.resultId = :resultId"),
    @NamedQuery(name = "Result.findByExecutionDate", query = "SELECT r FROM Result r WHERE r.executionDate = :executionDate"),
    @NamedQuery(name = "Result.findByScore", query = "SELECT r FROM Result r WHERE r.score = :score")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resultId")
    private Integer resultId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "execution_date")
    @Temporal(TemporalType.DATE)
    private Date executionDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private BigDecimal score;
    @JoinColumn(name = "examId", referencedColumnName = "examId")
    @ManyToOne(optional = false)
    private Exam examId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Users userId;

    public Result() {
    }

    public Result(Integer resultId) {
        this.resultId = resultId;
    }

    public Result(Integer resultId, Date executionDate, BigDecimal score) {
        this.resultId = resultId;
        this.executionDate = executionDate;
        this.score = score;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultId != null ? resultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.resultId == null && other.resultId != null) || (this.resultId != null && !this.resultId.equals(other.resultId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.examen_virtual.Result[ resultId=" + resultId + " ]";
    }

}
