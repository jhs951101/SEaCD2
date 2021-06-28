package pkg;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief 계정들을 모아 놓은 추상 클래스
 * 
 */
public abstract class Person{
	
	public static int ID = 0;
	
	protected AccountPanel infoPanel;
	
	protected int id;
	protected String name;
	protected String jumin;
	protected String phonenumner;
	protected String address;
	
	ArrayList<Object> orders = new ArrayList<Object>();
	
	abstract public void showInfo(Person C);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPhonenumner() {
		return phonenumner;
	}

	public void setPhonenumner(String phonenumner) {
		this.phonenumner = phonenumner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}