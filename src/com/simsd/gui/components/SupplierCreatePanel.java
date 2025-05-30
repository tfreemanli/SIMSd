package com.simsd.gui.components;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.simsd.Supplier;
import com.simsd.SupplierList;
import com.simsd.gui.MainWindow;

public class SupplierCreatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtName, txtDesc;
	private SupplierList splrList;
	private MainWindow mainWindow;

	/**
	 * Create the panel.
	 */
	public SupplierCreatePanel(MainWindow mw) {
		this.mainWindow = mw;
		splrList = mw.supplierList;
		

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
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 3;
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
		if(txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(
				    this,                // 父组件，通常是 JFrame 或 JPanel
				    "Please input Supplier's Name.",             // 提示内容
				    "Error",           // 标题
				    JOptionPane.ERROR_MESSAGE  // 图标类型：错误样式
				);
			return;
		}
		Supplier splr = new Supplier();
		splr.setName(txtName.getText());
		splr.setDescription(txtDesc.getText());
		splrList.add(splr);
		splrList.save();
		mainWindow.supplierListPage.doSearch();
		txtName.setText("");
		txtDesc.setText("");
		this.jumpToList();
	}
	
	public void jumpToList() {
		mainWindow.switchToPage(MainWindow.SUPPLIER_LIST_VIEW);
	}

}
