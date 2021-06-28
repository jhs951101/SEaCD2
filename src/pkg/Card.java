package pkg;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief Product�� ��� �޴� Card Ŭ����
 * 
 */
public class Card extends Product{
	
	public Card(){}
	
	public Card(int i, ProductPanel pa, String n, int p, File imgf, Image img, String ifo, int sid, int c){
		id = i;
		infoPanel = pa;
		name = n;
		price = p;
		photoFile = imgf;
		photo = img;
		info = ifo;
		salesmanID = sid;
		count = c;
	}
	
	public void showInfo(int id, Product P, String salesmanName){
		
		infoPanel.setProductId(id);
		
		infoPanel.imageLabel.setIcon(new ImageIcon(P.getPhoto()));
		infoPanel.Infolabel.setText("����: " + P.getInfo());
		infoPanel.Pricelabel.setText("����: " + P.getPrice());
		infoPanel.nameLabel.setText("��ǰ��: " + P.getName());
		infoPanel.SalesmanLabel.setText("�Ǹ���: " + salesmanName);
		infoPanel.countLabel.setText("����: " + P.getCount());
		
		infoPanel.typeLabel.setText("Type: ī��");
		
		infoPanel.btnOrder.setEnabled(true);
	}
	
}