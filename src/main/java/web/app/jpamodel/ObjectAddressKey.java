package web.app.jpamodel;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ObjectAddressKey implements Serializable{
	
	@Column(name = "OBJECTTYPE", length = 10 )
	private String objectType;
	
	@Column(name = "OBJECTID")
	private long objectId;
	
	
	@Column(name = "ADDRTYPE")
	
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public long getObjectId() {
		return objectId;
	}
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}	
    
	@Override
	public boolean equals(Object o) {
        
		if (this == o) return true;
        
        if (!(o instanceof ObjectAddressKey)) return false;
        
        ObjectAddressKey that = (ObjectAddressKey) o;
        
        return Objects.equals(getObjectType(), that.getObjectType()) &&
                Objects.equals(getObjectId(), that.getObjectId());
    
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(getObjectType(), getObjectId());
    }

}
