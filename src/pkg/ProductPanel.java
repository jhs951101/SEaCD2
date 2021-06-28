package pkg;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief ��ǰ ������ ��� �� ���Ǵ� JPanel
 * 
 */
public class ProductPanel extends JPanel {
	
	private int ProID;
	
	ManagementUI frame;
	JLabel imageLabel;
	JLabel nameLabel;
	JLabel typeLabel;
	JLabel Pricelabel;
	JLabel SalesmanLabel;
	JLabel Infolabel;
	JButton btnOrder;
	JLabel countLabel;
	
	public ProductPanel(ManagementUI f) {
		frame = f;
		
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		imageLabel = new JLabel("");
		imageLabel.setFont(new Font("����", Font.PLAIN, 18));
		imageLabel.setBounds(17, 15, 353, 249);
		add(imageLabel);
		
		nameLabel = new JLabel("");
		nameLabel.setFont(new Font("����", Font.PLAIN, 18));
		nameLabel.setBounds(17, 279, 353, 21);
		add(nameLabel);
		
		typeLabel = new JLabel("");
		typeLabel.setFont(new Font("����", Font.PLAIN, 18));
		typeLabel.setBounds(17, 315, 353, 21);
		add(typeLabel);
		
		Pricelabel = new JLabel("");
		Pricelabel.setFont(new Font("����", Font.PLAIN, 18));
		Pricelabel.setBounds(17, 351, 353, 21);
		add(Pricelabel);
		
		SalesmanLabel = new JLabel("");
		SalesmanLabel.setFont(new Font("����", Font.PLAIN, 18));
		SalesmanLabel.setBounds(17, 387, 353, 21);
		add(SalesmanLabel);
		
		Infolabel = new JLabel("");
		Infolabel.setFont(new Font("����", Font.PLAIN, 18));
		Infolabel.setVerticalAlignment(SwingConstants.TOP);
		Infolabel.setBounds(17, 459, 353, 183);
		add(Infolabel);
		
		btnOrder = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnOrder.setEnabled(false);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.list.removeAll();
				
				Product Pro = frame.products.get(ProID);
				Person Per = frame.persons.get(Pro.getSalesmanID());
				
				if(Pro.getCount() <= 0){
					JOptionPane.showMessageDialog(frame, "�˼��մϴ�. ǰ���� ��ǰ�Դϴ�.", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				ArrayList<Object> customers = new ArrayList<Object>();
				
				for(int i=0; i<frame.persons.size(); i++){
					Person P = frame.persons.get(i);
					
					if(P instanceof Customer)
						customers.add("ID:" + P.getId() + ", " + P.getName());
				}
				
				Object selectedValue = JOptionPane.showInputDialog(null,
						"���� ������ �ּ���", "Select",
						JOptionPane.INFORMATION_MESSAGE, null,
						customers.toArray(), customers.get(0));
				
				if(selectedValue != null){
					JOptionPane.showMessageDialog(frame, "�ֹ��� �Ϸ�Ǿ����ϴ�", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					
					int currentCount = Pro.getCount() - 1;
					Pro.setCount(currentCount);
					frame.products.set(ProID, Pro);
					
					String strValue = (String) selectedValue;
					
					Per.orders.add("CustomerID:" + strValue.substring(3, frame.findPointLoc(strValue)) + ", " + Pro.getName());
				}
			}
		});
		btnOrder.setBounds(121, 669, 125, 29);
		add(btnOrder);
		
		countLabel = new JLabel("");
		countLabel.setFont(new Font("����", Font.PLAIN, 18));
		countLabel.setBounds(17, 423, 353, 21);
		add(countLabel);
	}
	
	public void setProductId(int i){
		ProID = i;
	}
}