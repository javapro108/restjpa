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
@GeneratedValue(strategy = GenerationType.IDENTITY)
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

public long getCocID() {
	return cocID;
}

public void setCocID(long cocID) {
	this.cocID = cocID;
}

public long getCocContactID() {
	return cocContactID;
}

public void setCocContactID(long cocContactID) {
	this.cocContactID = cocContactID;
}

public Date getCocDate() {
	return cocDate;
}

public void setCocDate(Date cocDate) {
	this.cocDate = cocDate;
}

public String getCocUser() {
	return cocUser;
}

public void setCocUser(String cocUser) {
	this.cocUser = cocUser;
}

public String getCmdComment() {
	return cmdComment;
}

public void setCmdComment(String cmdComment) {
	this.cmdComment = cmdComment;
}

public Boolean getCmdPriority() {
	return cmdPriority;
}

public void setCmdPriority(Boolean cmdPriority) {
	this.cmdPriority = cmdPriority;
}


}
