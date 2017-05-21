package web.app.jpamodel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "tblCompanyComments", schema = "dbo")
public class TblCompanyComments{
@Id
@Column(name="comOldID")
private long comOldID;

public long getComOldID() {
     return comOldID;
}

public void setComOldID(long comOldID) {
     this.comOldID = comOldID;
}



@Column(name="comDate",length=8)
private String comDate;

public String getComDate() {
     return comDate;
}

public void setComDate(String comDate) {
     this.comDate = comDate;
}



@Column(name="comCreatedBy",length=10)
private String comCreatedBy;

public String getComCreatedBy() {
     return comCreatedBy;
}

public void setComCreatedBy(String comCreatedBy) {
     this.comCreatedBy = comCreatedBy;
}



@Column(name="comSolomonID",length=5)
private String comSolomonID;

public String getComSolomonID() {
     return comSolomonID;
}

public void setComSolomonID(String comSolomonID) {
     this.comSolomonID = comSolomonID;
}


}
