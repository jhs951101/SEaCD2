package pkg;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.List;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Ji-Hoon Shim
 * @date 2016-05-19
 * @brief 상품 관리 프로그램 UI 클래스
 * 
 */
public class ManagementUI extends JFrame {
	
	ManagementUI thisClass = this;
	
	JFileChooser jFileChooser1 = null;
	
	JPanel mainContent;
	ProductPanel proContent;
	AccountPanel accContent;
	List list;
	
	ArrayList<Product> products;
	ArrayList<Person> persons;
	
	private char showmode = 'd';  // showmode: p - 상품, c - Customer or Salesman
	
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnCustomer;
	private JMenu mnSalesman;
	private JMenuItem productAdd;
	private JMenuItem productModify;
	private JMenuItem productDelete;
	private JMenu menuPerson;
	private JMenuItem personAdd;
	private JMenuItem productShow;
	private JMenuItem customerShow;
	private JMenuItem salesmanShow;
	private JMenuItem personModify;
	private JMenuItem personDelete;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementUI frame = new ManagementUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ManagementUI() {
		
		setTitle("Product Management Program");
		setBounds(100, 100, 800, 800);
		setVisible(true);
		setResizable(false);
		
		initialize();
	}
	
	private void initialize(){
		
		products = new ArrayList<Product>();
		persons = new ArrayList<Person>();
		
		mainContent = new JPanel();
		mainContent.setBackground(new Color(0, 204, 102));
		mainContent.setLayout(null);
		
		setContentPane(mainContent);
		
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 153, 0));
		menuBar.setBounds(0, 0, 794, 31);
		mainContent.add(menuBar);
		
		mnNewMenu = new JMenu("Product");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		productAdd = new JMenuItem("Add");
		productAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean salesman = false;
				
				for(int i=0; i<persons.size(); i++){
					Person P = persons.get(i);
					
					if(P instanceof Salesman){
						salesman = true;
						break;
					}
				}
				
				if(!salesman){
					JOptionPane.showMessageDialog(thisClass, "판매자를 먼저 등록해 주세요", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				ProductUI proui = new ProductUI(thisClass, 'a', -1);
				proui.setVisible(true);
			}
		});
		mnNewMenu.add(productAdd);
		
		productModify = new JMenuItem("Modify");
		productModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strid = JOptionPane.showInputDialog(thisClass,
						"수정할 상품의 id를 입력해 주세요", "0");
				
				if(strid != null){
					int id = Integer.parseInt(strid);
					
					if( !(id >= 0 && id < products.size()) ){
						JOptionPane.showMessageDialog(thisClass, "존재하지 않는 id입니다", "Notice", 
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					Product P = products.get(id);
					
					ProductUI proui = new ProductUI(thisClass, 'm', id);
					proui.textFieldName.setText(P.getName());
					proui.textFieldPrice.setText(String.valueOf(P.getPrice()));
					proui.textFieldPhoto.setText(P.getPhotoFile().getPath());
					proui.textAreaInfo.setText(P.getInfo());
					proui.comboBox.setSelectedItem("");
					
					if(P instanceof Figure) proui.figureRadioButton.setSelected(true);
					else if(P instanceof Poster) proui.posterRadioButton.setSelected(true);
					else if(P instanceof Card) proui.cardRadioButton.setSelected(true);
					
					proui.setVisible(true);	
				}
			}
		});
		mnNewMenu.add(productModify);
		
		productDelete = new JMenuItem("Delete");
		productDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strid = JOptionPane.showInputDialog(thisClass,
						"삭제할 상품의 id를 입력해 주세요", "0");
				
				if(strid != null){
					int id = Integer.parseInt(strid);
					
					if( !(id >= 0 && id < products.size()) ){
						JOptionPane.showMessageDialog(thisClass, "존재하지 않는 id입니다", "Notice", 
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					JOptionPane.showMessageDialog(thisClass, "정상적으로 삭제 되었습니다", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					
					products.remove(id);
					
					for(int i=id; i<products.size(); i++){
						Product P = products.get(i);
						P.setId(id);
						products.set(id, P);
					}
					
					Product.ID--;
					list.removeAll();
				}
				
			}
		});
		mnNewMenu.add(productDelete);
		
		productShow = new JMenuItem("Show");
		productShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				
				for(int i=0; i<products.size(); i++)
					list.add("ID:" + products.get(i).getId() + ", " + products.get(i).getName());
				
				showmode = 'p';
			}
		});
		mnNewMenu.add(productShow);
		
		mnCustomer = new JMenu("Customer");
		mnCustomer.setForeground(new Color(255, 255, 255));
		menuBar.add(mnCustomer);
		
		customerShow = new JMenuItem("Show");
		customerShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				
				for(int i=0; i<persons.size(); i++){
					Person P = persons.get(i);
					
					if(P instanceof Customer)
						list.add("ID:" + P.getId() + ", " + P.getName());
				}
				showmode = 'c';
			}
		});
		mnCustomer.add(customerShow);
		
		mnSalesman = new JMenu("Salesman");
		mnSalesman.setForeground(new Color(255, 255, 255));
		menuBar.add(mnSalesman);
		
		salesmanShow = new JMenuItem("Show");
		salesmanShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				
				for(int i=0; i<persons.size(); i++){
					Person P = persons.get(i);
					
					if(P instanceof Salesman)
						list.add("ID:" + P.getId() + ", " + P.getName());
				}
				showmode = 'c';
			}
		});
		mnSalesman.add(salesmanShow);
		
		menuPerson = new JMenu("Person");
		menuPerson.setForeground(Color.WHITE);
		menuBar.add(menuPerson);
		
		personAdd = new JMenuItem("Add");
		personAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonUI perui = new PersonUI(thisClass, 'a', -1);
				perui.setVisible(true);
			}
		});
		menuPerson.add(personAdd);
		
		personModify = new JMenuItem("Modify");
		personModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strid = JOptionPane.showInputDialog(thisClass,
						"수정할 계정의 id를 입력해 주세요", "0");
				
				if(strid != null){
					int id = Integer.parseInt(strid);
					
					if( !(id >= 0 && id < persons.size()) ){
						JOptionPane.showMessageDialog(thisClass, "존재하지 않는 id입니다", "Notice", 
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					Person P = persons.get(id);
					
					PersonUI perui = new PersonUI(thisClass, 'm', id);
					perui.textFieldName.setText(P.getName());
					perui.textFieldJumin.setText(P.getJumin());
					perui.textFieldPhoneNumber.setText(P.getPhonenumner());
					perui.textFieldAddress.setText(P.getAddress());
					
					if(P instanceof Customer) perui.CustomerRadioButton.setSelected(true);
					else if(P instanceof Salesman) perui.SalesmanRadioButton.setSelected(true);
					
					perui.setVisible(true);	
				}
			}
		});
		menuPerson.add(personModify);
		
		personDelete = new JMenuItem("Delete");
		personDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strid = JOptionPane.showInputDialog(thisClass,
						"삭제할 계정의 id를 입력해 주세요", "0");
				
				if(strid != null){
					int id = Integer.parseInt(strid);
					
					if( !(id >= 0 && id < persons.size()) ){
						JOptionPane.showMessageDialog(thisClass, "존재하지 않는 id입니다", "Notice", 
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					JOptionPane.showMessageDialog(thisClass, "정상적으로 삭제 되었습니다", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					
					persons.remove(id);
					
					for(int i=id; i<persons.size(); i++){
						Person P = persons.get(i);
						P.setId(id);
						persons.set(id, P);
					}
					
					Person.ID--;
					list.removeAll();
				}
				
			}
		});
		menuPerson.add(personDelete);
		
		proContent = new ProductPanel(this);
		proContent.setBackground(new Color(204, 255, 204));
		proContent.setBounds(397, 37, 387, 713);
		proContent.setLayout(null);
		mainContent.add(proContent);
		
		accContent = new AccountPanel();
		accContent.setBackground(new Color(204, 255, 204));
		accContent.setBounds(397, 37, 387, 713);
		accContent.setLayout(null);
		
		list = new List();
		list.setMultipleMode(false);
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String strid = list.getSelectedItem().substring(3, findPointLoc(list.getSelectedItem()));
				int id = Integer.parseInt(strid);
				
				if(showmode == 'p'){
					Product P = products.get(id);
					String salesmanName = persons.get(P.getSalesmanID()).getName();
					
					accContent.setVisible(false);
					mainContent.remove(accContent);
					mainContent.add(proContent);
					proContent.setVisible(true);
					
					P.showInfo(id, P, salesmanName);
				}
				else if(showmode == 'c'){
					Person C = persons.get(id);
					
					proContent.setVisible(false);
					mainContent.remove(proContent);
					mainContent.add(accContent);
					accContent.setVisible(true);
					
					C.showInfo(C);
				}
			}
		});
		list.setFont(new Font("돋움", Font.PLAIN, 18));
		list.setBackground(new Color(204, 255, 153));
		list.setBounds(10, 37, 381, 713);
		mainContent.add(list);
		
		jFileChooser1 = new JFileChooser();
	}
	
	/**
	 * 
	 * @param str : ','가 들어가 있는 문장
	 */
	public int findPointLoc(String str){
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) == ',')
				return i;
		
		return -1;
	}
}