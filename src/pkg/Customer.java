package pkg;

import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief Person�� ��� �޴� Customer Ŭ����
 * 
 */
public class Customer extends Person{
	
	public Customer(){}
	
	public Customer(int i, AccountPanel pa, String n, String j, String p, String a){
		id = i;
		infoPanel = pa;
		name = n;
		jumin = j;
		phonenumner = p;
		address = a;
	}

	public void showInfo(Person C) {
		
		infoPanel.addressLabel.setText("�ּ�: " + C.getAddress());
		infoPanel.juminLabel.setText("�ֹε�Ϲ�ȣ: " + C.getJumin());
		infoPanel.nameLabel.setText("�̸�: " + C.getName());
		infoPanel.phoneLabel.setText("�ڵ��� ��ȣ: " + C.getPhonenumner());
		
		infoPanel.typeLabel.setText("Type: Customer");
		
		infoPanel.orderlist.removeAllItems();
		for(int i=0; i<C.orders.size(); i++)
			infoPanel.orderlist.addItem((String) C.orders.get(i));
	}

}