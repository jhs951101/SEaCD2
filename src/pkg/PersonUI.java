package pkg;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief 계정을 추가/수정 할 때 사용되는 UI 클래스
 * 
 */
public class PersonUI extends JFrame{
	
	PersonUI thisClass = this;
	
	private JPanel content;
	private JLabel label;
	JTextField textFieldName;
	private JLabel label_1;
	JTextField textFieldJumin;
	private JLabel label_2;
	JTextField textFieldPhoneNumber;
	private JLabel label_4;
	JRadioButton CustomerRadioButton;
	JRadioButton SalesmanRadioButton;
	
	private ButtonGroup btnGroup;
	
	private ManagementUI frame;
	private JLabel label_3;
	JTextField textFieldAddress;
	private JButton btnOK;
	
	private char mode;
	private int id;
	
	public PersonUI() {
		
		frame = null;
		
		setTitle("Add or Modify Person Information");
		setBounds(200, 200, 500, 500);
		setVisible(true);
		setResizable(false);
		
		initialize();
		
	}
	
	public PersonUI(ManagementUI f, char m, int i) {
		
		frame = f;
		mode = m;
		id = i;
		
		setTitle("Add or Modify Person Information");
		setBounds(200, 200, 500, 500);
		setVisible(true);
		setResizable(false);
		
		initialize();
	}
	
	private void initialize(){
		
		content = new JPanel();
		content.setBackground(new Color(204, 255, 255));
		content.setLayout(null);
		
		setContentPane(content);
		
		label = new JLabel("\uC774\uB984: ");
		label.setFont(new Font("돋움", Font.PLAIN, 20));
		label.setBounds(17, 33, 54, 21);
		content.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(75, 30, 191, 27);
		content.add(textFieldName);
		textFieldName.setColumns(10);
		
		label_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638: ");
		label_1.setFont(new Font("돋움", Font.PLAIN, 20));
		label_1.setBounds(17, 124, 134, 21);
		content.add(label_1);
		
		textFieldJumin = new JTextField();
		textFieldJumin.setBounds(157, 121, 320, 27);
		content.add(textFieldJumin);
		textFieldJumin.setColumns(10);
		
		label_2 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638: ");
		label_2.setFont(new Font("돋움", Font.PLAIN, 20));
		label_2.setBounds(17, 166, 114, 21);
		content.add(label_2);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(136, 163, 341, 27);
		content.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		label_4 = new JLabel("\uC120\uD0DD: ");
		label_4.setFont(new Font("돋움", Font.PLAIN, 20));
		label_4.setBounds(17, 77, 54, 21);
		content.add(label_4);
		
		CustomerRadioButton = new JRadioButton("Customer");
		CustomerRadioButton.setBackground(new Color(204, 255, 255));
		CustomerRadioButton.setBounds(75, 73, 111, 29);
		content.add(CustomerRadioButton);
		
		SalesmanRadioButton = new JRadioButton("Salesman");
		SalesmanRadioButton.setBackground(new Color(204, 255, 255));
		SalesmanRadioButton.setBounds(194, 73, 111, 29);
		content.add(SalesmanRadioButton);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(CustomerRadioButton);
		btnGroup.add(SalesmanRadioButton);
		
		label_3 = new JLabel("\uC8FC\uC18C: ");
		label_3.setFont(new Font("돋움", Font.PLAIN, 20));
		label_3.setBounds(17, 212, 54, 21);
		content.add(label_3);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(74, 209, 403, 27);
		content.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnOK = new JButton("\uD655\uC778");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldName.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "이름을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldJumin.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "주민등록번호를 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!isNumber(textFieldJumin.getText()))
					JOptionPane.showMessageDialog(thisClass, "주민등록번호: 유효한 값을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldPhoneNumber.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "핸드폰 번호를 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!isNumber(textFieldPhoneNumber.getText()))
					JOptionPane.showMessageDialog(thisClass, "핸드폰번호: 유효한 값을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldAddress.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "주소를 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!CustomerRadioButton.isSelected()
						&& !SalesmanRadioButton.isSelected())
					JOptionPane.showMessageDialog(thisClass, "타입을 선택해주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(thisClass, "계정이 정상적으로 등록 되었습니다", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					
					if(mode == 'm'){
						if(CustomerRadioButton.isSelected())
							frame.persons.set(id, new Customer(id, frame.accContent, textFieldName.getText(),
									textFieldJumin.getText(), textFieldPhoneNumber.getText(), textFieldAddress.getText()));
						else if(SalesmanRadioButton.isSelected())
							frame.persons.set(id, new Salesman(id, frame.accContent, textFieldName.getText(),
									textFieldJumin.getText(), textFieldPhoneNumber.getText(), textFieldAddress.getText()));
						
						frame.list.removeAll();
						
						thisClass.dispose();
						return;
					}
					
					if(CustomerRadioButton.isSelected())
						frame.persons.add(new Customer(Person.ID, frame.accContent, textFieldName.getText(),
								textFieldJumin.getText(), textFieldPhoneNumber.getText(), textFieldAddress.getText()));
					
					else if(SalesmanRadioButton.isSelected())
						frame.persons.add(new Salesman(Person.ID, frame.accContent, textFieldName.getText(),
								textFieldJumin.getText(), textFieldPhoneNumber.getText(), textFieldAddress.getText()));
					
					Person.ID++;
					frame.list.removeAll();
					
					thisClass.dispose();
				}
			}
		});
		btnOK.setBounds(180, 386, 125, 29);
		content.add(btnOK);
	}
	
	/**
	 * 
	 * @param num : 숫자로만 구성되어 있는지 검사받을 string형 변수
	 */
	public boolean isNumber(String num){  // string 값이 숫자인지 아닌지 판단하는 함수 ('-' 포함)
		
		for(int i=0; i<num.length(); i++){
			char c = num.charAt(i);
			
			if(c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && 
					c != '6' && c != '7' && c != '8' && c != '9' && c != '-')
				return false;
		}
		
		return true;
	}
}