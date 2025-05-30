package com.simsd.gui.components;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.simsd.ItemProducedInStore;
import com.simsd.ItemList;
import com.simsd.gui.MainWindow;

public class IPSCreatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtName, txtDesc, txtType, txtSellByDate, txtExpDate, txtPricePerUnit, txtUnit, txtQuantity, txtProducedDate;
	private ItemList<ItemProducedInStore> itemList;
	private MainWindow mainWindow;

	/**
	 * Create the panel.
	 */
	public IPSCreatePanel(MainWindow mw) {
		this.mainWindow = mw;
		itemList = mw.IPSList;
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Place_holder
		JLabel lblNewLabel_2 = new JLabel("     ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Create Store-Produced Item");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtName = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(txtName, gbc_textField);
		txtName.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtType = new JTextField();
		txtType.setText("ItemProducedInStore");
		txtType.setEnabled(false);
		GridBagConstraints gbc_textField2 = new GridBagConstraints();
		gbc_textField2.anchor = GridBagConstraints.WEST;
		gbc_textField2.insets = new Insets(0, 0, 5, 5);
		gbc_textField2.gridx = 2;
		gbc_textField2.gridy = 2;
		add(txtType, gbc_textField2);
		txtType.setColumns(20);
		//====================================
		
		JLabel lblNewLabel3 = new JLabel("SellBy Date:");
		GridBagConstraints gbc_lblNewLabel3 = new GridBagConstraints();
		gbc_lblNewLabel3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel3.gridx = 1;
		gbc_lblNewLabel3.gridy = 3;
		add(lblNewLabel3, gbc_lblNewLabel3);
		
		txtSellByDate = new JTextField();
		txtSellByDate.setText("" + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		GridBagConstraints gbc_textField3 = new GridBagConstraints();
		gbc_textField3.insets = new Insets(0, 0, 5, 5);
		gbc_textField3.anchor = GridBagConstraints.WEST;
		gbc_textField3.gridx = 2;
		gbc_textField3.gridy = 3;
		add(txtSellByDate, gbc_textField3);
		txtSellByDate.setColumns(20);
		//====================================
		
		JLabel lblNewLabel4 = new JLabel("Expire Date:");
		GridBagConstraints gbc_lblNewLabel4 = new GridBagConstraints();
		gbc_lblNewLabel4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel4.gridx = 1;
		gbc_lblNewLabel4.gridy = 4;
		add(lblNewLabel4, gbc_lblNewLabel4);
		
		txtExpDate = new JTextField();
		txtExpDate.setText("" + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		GridBagConstraints gbc_textField4 = new GridBagConstraints();
		gbc_textField4.insets = new Insets(0, 0, 5, 5);
		gbc_textField4.anchor = GridBagConstraints.WEST;
		gbc_textField4.gridx = 2;
		gbc_textField4.gridy = 4;
		add(txtExpDate, gbc_textField4);
		txtExpDate.setColumns(20);
		//====================================
		
		JLabel lblNewLabel5 = new JLabel("Price per Unit:");
		GridBagConstraints gbc_lblNewLabel5 = new GridBagConstraints();
		gbc_lblNewLabel5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel5.gridx = 1;
		gbc_lblNewLabel5.gridy = 5;
		add(lblNewLabel5, gbc_lblNewLabel5);
		
		txtPricePerUnit = new JTextField();
		txtPricePerUnit.setText("0.0");
		GridBagConstraints gbc_textField5 = new GridBagConstraints();
		gbc_textField5.insets = new Insets(0, 0, 5, 5);
		gbc_textField5.anchor = GridBagConstraints.WEST;
		gbc_textField5.gridx = 2;
		gbc_textField5.gridy = 5;
		add(txtPricePerUnit, gbc_textField5);
		txtPricePerUnit.setColumns(20);
		//====================================
		
		JLabel lblNewLabel6 = new JLabel("Unit:");
		GridBagConstraints gbc_lblNewLabel6 = new GridBagConstraints();
		gbc_lblNewLabel6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel6.gridx = 1;
		gbc_lblNewLabel6.gridy = 6;
		add(lblNewLabel6, gbc_lblNewLabel6);
		
		txtUnit = new JTextField();
		GridBagConstraints gbc_textField6 = new GridBagConstraints();
		gbc_textField6.insets = new Insets(0, 0, 5, 5);
		gbc_textField6.anchor = GridBagConstraints.WEST;
		gbc_textField6.gridx = 2;
		gbc_textField6.gridy = 6;
		add(txtUnit, gbc_textField6);
		txtUnit.setColumns(20);
		//====================================
		
		JLabel lblNewLabel7 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblNewLabel7 = new GridBagConstraints();
		gbc_lblNewLabel7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel7.gridx = 1;
		gbc_lblNewLabel7.gridy = 7;
		add(lblNewLabel7, gbc_lblNewLabel7);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("0.0");
		GridBagConstraints gbc_textField7 = new GridBagConstraints();
		gbc_textField7.insets = new Insets(0, 0, 5, 5);
		gbc_textField7.anchor = GridBagConstraints.WEST;
		gbc_textField7.gridx = 2;
		gbc_textField7.gridy = 7;
		add(txtQuantity, gbc_textField7);
		txtQuantity.setColumns(20);
		//====================================
		
		JLabel lblNewLabel8 = new JLabel("Description:");
		GridBagConstraints gbc_lblNewLabel8 = new GridBagConstraints();
		gbc_lblNewLabel8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel8.gridx = 1;
		gbc_lblNewLabel8.gridy = 8;
		add(lblNewLabel8, gbc_lblNewLabel8);
		
		txtDesc = new JTextField();
		GridBagConstraints gbc_textField8 = new GridBagConstraints();
		gbc_textField8.insets = new Insets(0, 0, 5, 5);
		gbc_textField8.anchor = GridBagConstraints.WEST;
		gbc_textField8.gridx = 2;
		gbc_textField8.gridy = 8;
		add(txtDesc, gbc_textField8);
		txtDesc.setColumns(40);
		//====================================
		
		JLabel lblNewLabel9 = new JLabel("Produce Date:");
		GridBagConstraints gbc_lblNewLabel9 = new GridBagConstraints();
		gbc_lblNewLabel9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel9.gridx = 1;
		gbc_lblNewLabel9.gridy = 9;
		add(lblNewLabel9, gbc_lblNewLabel9);
		

		txtProducedDate = new JTextField();
		txtProducedDate.setText("" + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		GridBagConstraints gbc_textField9 = new GridBagConstraints();
		gbc_textField9.insets = new Insets(0, 0, 5, 5);
		gbc_textField9.anchor = GridBagConstraints.WEST;
		gbc_textField9.gridx = 2;
		gbc_textField9.gridy = 9;
		add(txtProducedDate, gbc_textField9);
		txtProducedDate.setColumns(20);
		
		//=============================================
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 10;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSave = new JButton("O K");
		btnSave.addActionListener(_-> save());
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(_-> jumpToList());
		panel.add(btnCancel);
	}
	
	public void save() {

		if(!vailidInput()) {
			return;
		}

		ItemProducedInStore item = new ItemProducedInStore();
		item.setName(txtName.getText());
		item.setDescription(txtDesc.getText());
		item.setType(txtType.getText());
		item.setSellByDate(LocalDate.parse(txtSellByDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d")));
		item.setExpDate(LocalDate.parse(txtExpDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d")));
		item.setPricePerUnit(Float.parseFloat(txtPricePerUnit.getText()));
		item.setUnit(txtUnit.getText());
		item.setQuantity(Float.parseFloat(txtQuantity.getText()));
		item.setProduceDate(LocalDate.parse(txtProducedDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d")));
		item.setExpired(false);
		
		itemList.add(item);
		itemList.save();
		mainWindow.ipsListPage.doSearch();
		txtName.setText("");
		txtDesc.setText("");
		txtSellByDate.setText("" + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		txtExpDate.setText("" + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		txtPricePerUnit.setText("0.0");
		txtUnit.setText("");
		txtQuantity.setText("0.0");
		this.jumpToList();
	}
	
	public boolean vailidInput() {
		boolean rt = true;

		if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(
				    this, 
				    "Please input item's Name.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		try {
			LocalDate.parse(txtSellByDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d"));
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(
				    this, 
				    "Please check SellBy Date.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		try {
			LocalDate.parse(txtExpDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d"));
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(
				    this, 
				    "Please check Expire Date.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		try {
			LocalDate.parse(txtProducedDate.getText(), DateTimeFormatter.ofPattern("yyyy-M-d"));
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(
				    this, 
				    "Please check Produce Date.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		try {
			Float.parseFloat(txtPricePerUnit.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(
				    this, 
				    "Please check Price.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		try {
			Float.parseFloat(txtQuantity.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(
				    this, 
				    "Please check Quantity.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return false;
		}
		
		
		return rt;
	}
	
	public void jumpToList() {
		mainWindow.switchToPage(MainWindow.IPS_LIST_VIEW);
	}

}
