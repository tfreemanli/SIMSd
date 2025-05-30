package com.simsd.gui.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.simsd.Supplier;
import com.simsd.gui.MainWindow;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class SupplierDetailPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	MainWindow mainWindow;
	JTextField txtName, txtDesc;
	Supplier supplier;
	/**
	 * Create the panel.
	 */
	public SupplierDetailPanel(MainWindow mw) {
		this.mainWindow = mw;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("     ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtDesc = new JTextField();
		GridBagConstraints gbc_textField2 = new GridBagConstraints();
		gbc_textField2.anchor = GridBagConstraints.WEST;
		gbc_textField2.insets = new Insets(0, 0, 5, 5);
		gbc_textField2.gridx = 2;
		gbc_textField2.gridy = 2;
		add(txtDesc, gbc_textField2);
		txtDesc.setColumns(30);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOK = new JButton("O K");
		btnOK.addActionListener(_-> save());
		panel.add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(_-> jumpToList());
		panel.add(btnCancel);

		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(_ -> delete());
		panel.add(btnDel);
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
		txtName.setText(supplier.getName());
		txtDesc.setText(supplier.getDescription());
	}
	
	public void delete() {
		//
		int confirm = JOptionPane.showConfirmDialog(
	            this,
	            "Are you sure you want to delete this item?",
	            "Confirm Delete",
	            JOptionPane.YES_NO_OPTION
	    );

	    if (confirm == JOptionPane.YES_OPTION) {
	        mainWindow.supplierList.remove(supplier);
	        mainWindow.supplierList.save();
	        mainWindow.supplierListPage.doSearch();
			txtName.setText("");
			txtDesc.setText("");
			this.jumpToList();
	    }
	}
	
	public void jumpToList() {
		mainWindow.switchToPage(MainWindow.SUPPLIER_LIST_VIEW);
	}
	
	public void save() {
		//
		if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(
				    this,                
				    "Please input Supplier's Name.",             
				    "Error",
				    JOptionPane.ERROR_MESSAGE
				);
			return;
		}
		supplier.setName(txtName.getText());
		supplier.setDescription(txtDesc.getText());
		//mainWindow.supplierList.set(supplier);
		mainWindow.supplierList.save();
        mainWindow.supplierListPage.doSearch();
		txtName.setText("");
		txtDesc.setText("");
		this.jumpToList();
	}

}
