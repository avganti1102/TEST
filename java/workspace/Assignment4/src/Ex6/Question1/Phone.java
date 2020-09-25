package Ex6.Question1;

import java.util.Scanner;

public abstract class Phone{
	private String[] contacts;
	private String numb;
	private String name;
	
	public String[] getContacts() {
		return contacts;
	}
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
	public String getNumb() {
		return numb;
	}
	public void setNumb(String numb) {
		this.numb = numb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void insertContact(String name,String numb);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name,String newNumb);
	public abstract void searchContact(String name);
}
