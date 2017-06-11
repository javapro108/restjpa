package web.app.jpamodel.company;

public class FindParams {
	
	private String comName;
	private Boolean comInactive;
	
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Boolean getComInactive() {
		return comInactive;
	}
	public void setComInactive(Boolean comInactive) {
		this.comInactive = comInactive;
	}
	
}
