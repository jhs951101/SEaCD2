package pkg;

import java.awt.Image;
import java.io.File;

import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief 상품들을 모아 놓은 추상 클래스
 * 
 */
public abstract class Product {
	
	public static int ID = 0;
	
	protected ProductPanel infoPanel;
	
	protected int id;
	protected String name;
	protected int price;
	protected Image photo;
	protected File photoFile;
	protected String info;
	protected int salesmanID;
	protected int count;
	
	abstract public void showInfo(int id, Product P, String salesmanName);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(File photofile) {
		this.photoFile = photofile;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(int salesmanID) {
		this.salesmanID = salesmanID;
	}
	
}