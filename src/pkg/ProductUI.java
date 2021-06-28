package pkg;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief 상품 정보를 추가/수정 할 때 사용되는 UI 클래스
 * 
 */
public class ProductUI extends JFrame{
	
	ProductUI thisClass = this;
	
	File photoFile = null; 
	
	private JPanel content;
	private JLabel label;
	JTextField textFieldName;
	private JLabel label_1;
	JTextField textFieldPrice;
	private JLabel label_2;
	JTextField textFieldPhoto;
	private JButton ButtonPhoto;
	private JLabel label_3;
	JTextArea textAreaInfo;
	private JLabel label_4;
	JRadioButton figureRadioButton;
	JRadioButton posterRadioButton;
	JRadioButton cardRadioButton;
	private JButton btnOK;
	
	private ButtonGroup btnGroup;
	
	private ManagementUI frame;
	private JLabel label_5;
	JComboBox<String> comboBox;
	
	private char mode;
	private int id;
	private JLabel label_6;
	private JTextField textFieldCount;
	
	public ProductUI() {
		
		frame = null;
		
		setTitle("Add or Modify Product");
		setBounds(200, 200, 500, 500);
		setVisible(true);
		setResizable(false);
		
		initialize();
		
	}
	
	public ProductUI(ManagementUI f, char m, int i) {
		
		frame = f;
		mode = m;
		id = i;
		
		setTitle("Add or Modify Product");
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
		
		label = new JLabel("\uC0C1\uD488\uBA85: ");
		label.setFont(new Font("돋움", Font.PLAIN, 20));
		label.setBounds(17, 33, 74, 21);
		content.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(94, 30, 191, 27);
		content.add(textFieldName);
		textFieldName.setColumns(10);
		
		label_1 = new JLabel("\uAC00\uACA9: ");
		label_1.setFont(new Font("돋움", Font.PLAIN, 20));
		label_1.setBounds(17, 124, 54, 21);
		content.add(label_1);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(75, 121, 210, 27);
		content.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		label_2 = new JLabel("\uC0AC\uC9C4: ");
		label_2.setFont(new Font("돋움", Font.PLAIN, 20));
		label_2.setBounds(17, 166, 54, 21);
		content.add(label_2);
		
		textFieldPhoto = new JTextField();
		textFieldPhoto.setEditable(false);
		textFieldPhoto.setBounds(75, 163, 291, 27);
		content.add(textFieldPhoto);
		textFieldPhoto.setColumns(10);
		
		ButtonPhoto = new JButton("\uCC3E\uC544\uBCF4\uAE30");
		ButtonPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (frame.jFileChooser1.showOpenDialog(frame) ==
						JFileChooser.APPROVE_OPTION) {
					photoFile = frame.jFileChooser1.getSelectedFile();
					textFieldPhoto.setText(photoFile.getPath());
				}
			}
		});
		ButtonPhoto.setBounds(372, 162, 105, 29);
		content.add(ButtonPhoto);
		
		label_3 = new JLabel("\uC124\uBA85: ");
		label_3.setFont(new Font("돋움", Font.PLAIN, 20));
		label_3.setBounds(17, 288, 54, 21);
		content.add(label_3);
		
		textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(75, 289, 402, 102);
		content.add(textAreaInfo);
		
		label_4 = new JLabel("\uD0C0\uC785: ");
		label_4.setFont(new Font("돋움", Font.PLAIN, 20));
		label_4.setBounds(17, 77, 54, 21);
		content.add(label_4);
		
		figureRadioButton = new JRadioButton("\uD53C\uADDC\uC5B4");
		figureRadioButton.setBackground(new Color(204, 255, 255));
		figureRadioButton.setBounds(75, 73, 87, 29);
		content.add(figureRadioButton);
		
		posterRadioButton = new JRadioButton("\uD3EC\uC2A4\uD130");
		posterRadioButton.setBackground(new Color(204, 255, 255));
		posterRadioButton.setBounds(171, 73, 87, 29);
		content.add(posterRadioButton);
		
		cardRadioButton = new JRadioButton("\uCE74\uB4DC");
		cardRadioButton.setBackground(new Color(204, 255, 255));
		cardRadioButton.setBounds(267, 73, 74, 29);
		content.add(cardRadioButton);
		
		btnOK = new JButton("\uD655\uC778");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldName.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "상품명을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldPrice.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "상품 가격을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!isNumber(textFieldPrice.getText())
						|| Integer.parseInt(textFieldPrice.getText())%10 != 0)
					JOptionPane.showMessageDialog(thisClass, "상품 가격: 유효한 값을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldPhoto.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "상품 사진을 넣어주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textAreaInfo.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "상품에 대한 설명을 입력해주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!figureRadioButton.isSelected()
						&& !posterRadioButton.isSelected()
						&& !cardRadioButton.isSelected())
					JOptionPane.showMessageDialog(thisClass, "상품 타입을 선택해주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(comboBox.getSelectedItem().equals(""))
					JOptionPane.showMessageDialog(thisClass, "판매자를 선택해주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(textFieldCount.getText().equals(""))
					JOptionPane.showMessageDialog(thisClass, "수량을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else if(!isNumber(textFieldCount.getText()))
					JOptionPane.showMessageDialog(thisClass, "수량: 유효한 값을 입력해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(thisClass, "상품이 정상적으로 등록 되었습니다", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					
					photoFile = frame.jFileChooser1.getSelectedFile();
					Image orginalImage = null;
					
					try {
						orginalImage = ImageIO.read(photoFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Image resizedImage = orginalImage.getScaledInstance(353, 249, Image.SCALE_SMOOTH);
					
					String str = (String) comboBox.getSelectedItem();
					String strid = str.substring(3, frame.findPointLoc(str));
					
					if(mode == 'm'){
						if(figureRadioButton.isSelected()){
							frame.products.set(id, new Figure(id, frame.proContent, textFieldName.getText(),
									Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
									Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
						}
						else if(posterRadioButton.isSelected()){
							frame.products.set(id, new Poster(id, frame.proContent, textFieldName.getText(),
									Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
									Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
						}
						else if(cardRadioButton.isSelected()){
							frame.products.set(id, new Card(id, frame.proContent, textFieldName.getText(),
									Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
									Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
						}
						
						frame.list.removeAll();
						
						thisClass.dispose();
						return;
					}
					
					if(figureRadioButton.isSelected()){
						frame.products.add(new Figure(Product.ID, frame.proContent, textFieldName.getText(),
								Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
								Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
					}
					else if(posterRadioButton.isSelected()){
						frame.products.add(new Poster(Product.ID, frame.proContent, textFieldName.getText(),
								Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
								Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
					}
					else if(cardRadioButton.isSelected()){
						frame.products.add(new Card(Product.ID, frame.proContent, textFieldName.getText(),
								Integer.parseInt(textFieldPrice.getText()), photoFile, resizedImage, textAreaInfo.getText(),
								Integer.parseInt(strid), Integer.parseInt(textFieldCount.getText())));
					}
					Product.ID++;
					frame.list.removeAll();
						
					thisClass.dispose();
				}
			}
		});
		btnOK.setBounds(187, 406, 125, 29);
		content.add(btnOK);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(figureRadioButton);
		btnGroup.add(posterRadioButton);
		btnGroup.add(cardRadioButton);
		
		label_5 = new JLabel("\uD310\uB9E4\uC790: ");
		label_5.setFont(new Font("돋움", Font.PLAIN, 20));
		label_5.setBounds(17, 206, 74, 21);
		content.add(label_5);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(94, 203, 191, 27);
		content.add(comboBox);
		
		comboBox.addItem("");
		for(int i=0; i<frame.persons.size(); i++){
			Person P = frame.persons.get(i);
			
			if(P instanceof Salesman) comboBox.addItem("ID:" + P.getId() + ", "+ P.getName());
		}
		
		label_6 = new JLabel("\uC218\uB7C9: ");
		label_6.setFont(new Font("돋움", Font.PLAIN, 20));
		label_6.setBounds(17, 249, 54, 21);
		content.add(label_6);
		
		textFieldCount = new JTextField();
		textFieldCount.setColumns(10);
		textFieldCount.setBounds(75, 247, 210, 27);
		content.add(textFieldCount);
	}
	
	/**
	 * 
	 * @param num : 숫자로만 구성되어 있는지 검사받을 string형 변수
	 */
	public boolean isNumber(String num){  // string 값이 숫자인지 아닌지 판단하는 함수
		
		for(int i=0; i<num.length(); i++){
			char c = num.charAt(i);
			
			if(c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && 
					c != '6' && c != '7' && c != '8' && c != '9')
				return false;
		}
		
		return true;
	}
}