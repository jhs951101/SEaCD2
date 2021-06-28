package pkg;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief Product를 상속 받는 Card 클래스
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
		infoPanel.Infolabel.setText("설명: " + P.getInfo());
		infoPanel.Pricelabel.setText("가격: " + P.getPrice());
		infoPanel.nameLabel.setText("상품명: " + P.getName());
		infoPanel.SalesmanLabel.setText("판매자: " + salesmanName);
		infoPanel.countLabel.setText("수량: " + P.getCount());
		
		infoPanel.typeLabel.setText("Type: 카드");
		
		infoPanel.btnOrder.setEnabled(true);
	}
	
}