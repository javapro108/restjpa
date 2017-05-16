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
	private String addrType;
	
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
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
    
	@Override
	public boolean equals(Object o) {
        
		if (this == o) return true;
        
        if (!(o instanceof ObjectAddressKey)) return false;
        
        ObjectAddressKey that = (ObjectAddressKey) o;
        
        if (Objects.equals(this.getObjectType(), that.getObjectType()) 
        	&& Objects.equals(this.getObjectId(),   that.getObjectId())
        	&& Objects.equals(this.getAddrType(),   that.getAddrType())){
        	return true;
        } else {
        	return false;
        }
        
    
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(getObjectType(), getObjectId(), getAddrType());
    }

}
