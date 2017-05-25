package web.app.jpamodel.contact;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tblContactAffiliates", schema = "dbo")
public class TblContactAffiliates {

	@EmbeddedId
	private TblContactAffiliatesKey key;

	@Column(name = "cafStatus", length = 10)
	private Integer cafStatus;

	@Column(name = "cafstatus2", length = 10)
	private String cafstatus2;

}
