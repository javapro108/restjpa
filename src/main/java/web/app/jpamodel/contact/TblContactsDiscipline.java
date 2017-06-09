package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "tblContactsDiscipline", schema = "dbo")
public class TblContactsDiscipline{

@EmbeddedId
private TblContactsDisciplineKey key;

public TblContactsDisciplineKey getKey() {
	return key;
}

public void setKey(TblContactsDisciplineKey key) {
	this.key = key;
}


}
