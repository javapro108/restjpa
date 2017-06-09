package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "tblContactComments", schema = "dbo")
public class TblContactComments{

@Id
@Column(name="cocID",length=18)
private long cocID;

@Column(name="cocContactID",length=18)
private long cocContactID;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="cocDate")
private Date cocDate;

@Column(name="cocUser",length=10)
private String cocUser;

@Column(name="cmdComment",length=100)
private String cmdComment;

@Column(name="cmdPriority")
private Boolean cmdPriority;
}
