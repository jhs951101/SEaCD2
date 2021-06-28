package pkg;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief Customer ¶Ç´Â Salesman °èÁ¤À» ¶ç¿ï ¶§ »ç¿ëµÇ´Â JPanel
 * 
 */
public class AccountPanel extends JPanel {
	JLabel nameLabel;
	JLabel typeLabel;
	JLabel juminLabel;
	JLabel phoneLabel;
	JLabel addressLabel;
	JComboBox<String> orderlist;
	
	public AccountPanel() {
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
		nameLabel.setBounds(17, 279, 353, 21);
		add(nameLabel);
		
		typeLabel = new JLabel("");
		typeLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
		typeLabel.setBounds(17, 315, 353, 21);
		add(typeLabel);
		
		juminLabel = new JLabel("");
		juminLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
		juminLabel.setBounds(17, 351, 353, 21);
		add(juminLabel);
		
		phoneLabel = new JLabel("");
		phoneLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
		phoneLabel.setBounds(17, 387, 353, 21);
		add(phoneLabel);
		
		addressLabel = new JLabel("");
		addressLabel.setVerticalAlignment(SwingConstants.TOP);
		addressLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 18));
		addressLabel.setBounds(17, 423, 353, 57);
		add(addressLabel);
		
		orderlist = new JComboBox<String>();
		orderlist.setBounds(17, 495, 353, 27);
		add(orderlist);
	}
}