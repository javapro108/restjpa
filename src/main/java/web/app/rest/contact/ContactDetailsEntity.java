package web.app.rest.contact;

import web.app.jpamodel.contact.sp.SpContactViewResults;

public class ContactDetailsEntity {
	
	private SpContactViewResults contact;

	public SpContactViewResults getContact() {
		return contact;
	}

	public void setContact(SpContactViewResults contact) {
		this.contact = contact;
	}
	
	
}
