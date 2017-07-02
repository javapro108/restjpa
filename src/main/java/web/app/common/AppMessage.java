package web.app.common;

import java.util.Date;

public class AppMessage {
	private String type;
	private String message;
	private String objType;
	private String objID;
	private Date time;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
	}
	public String getObjID() {
		return objID;
	}
	public void setObjID(String objID) {
		this.objID = objID;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	} 
	
}
