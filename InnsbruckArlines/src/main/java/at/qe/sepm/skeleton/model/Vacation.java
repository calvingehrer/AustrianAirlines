package at.qe.sepm.skeleton.model;

import org.springframework.data.domain.Persistable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Vacation implements Persistable<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacationId;

    @ManyToOne(optional = false)
    private User user;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long vacationId) {
        this.vacationId = vacationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date beginningDate) {
        this.startDate = beginningDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endingDate) {
        this.endDate = endingDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public Long getId() {
        return this.getVacationId();
    }

    @Override
    public boolean isNew() {
        return (null == createDate);
    }

    @Override
    public String toString() {
        return "at.qe.sepm.skeleton.model.Holiday [id= " + getVacationId() + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.vacationId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Vacation)) {
            return false;
        }
        final Vacation other = (Vacation) obj;
        return Objects.equals(this.vacationId, other.getVacationId());
    }
}