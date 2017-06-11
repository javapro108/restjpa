package web.app.jpamodel.contact;

public class FindParams {
	
	private String conName;
	private Boolean conInactive;
	
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public Boolean getConInactive() {
		return conInactive;
	}
	public void setConInactive(Boolean conInactive) {
		this.conInactive = conInactive;
	}
	
}
