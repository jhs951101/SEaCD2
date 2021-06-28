package pkg;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief Person을 상속 받는 Salesman 클래스
 * 
 */
public class Salesman extends Person{
	
	public Salesman(){}
	
	public Salesman(int i, AccountPanel pa, String n, String j, String p, String a){
		id = i;
		infoPanel = pa;
		name = n;
		jumin = j;
		phonenumner = p;
		address = a;
	}

	public void showInfo(Person C) {
		
		infoPanel.addressLabel.setText("주소: " + C.getAddress());
		infoPanel.juminLabel.setText("주민등록번호: " + C.getJumin());
		infoPanel.nameLabel.setText("이름: " + C.getName());
		infoPanel.phoneLabel.setText("핸드폰 번호: " + C.getPhonenumner());
		
		infoPanel.typeLabel.setText("Type: Salesman");
		
		infoPanel.orderlist.removeAllItems();
		for(int i=0; i<C.orders.size(); i++)
			infoPanel.orderlist.addItem((String) C.orders.get(i));
	}
}