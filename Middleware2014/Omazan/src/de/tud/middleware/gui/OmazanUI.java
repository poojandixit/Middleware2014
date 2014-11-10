package de.tud.middleware.gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class OmazanUI extends javax.swing.JFrame {

	//Fix for serial version ID
	private static final long serialVersionUID = 1L;
	
	public OmazanUI() {
		/*
		 *  TODO: Call the method to initiate the components
		 */
		initComponents();
		/*
		 *  TODO: Make Customer, product and Addedit panel visibility false
		 */
        pnlCustomerData.setVisible(false);
        pnlProductData.setVisible(false);
        pnlAddEdit.setVisible(false);
	}
	//@SuppressWarnings("unchecked")
	private void initComponents() {
		/*
		 *  TODO: Initiate the components
		 */
        pnlCustomerData = new javax.swing.JPanel();
        lblCustData = new javax.swing.JLabel();
        lblCustID = new javax.swing.JLabel();
        lblCustName = new javax.swing.JLabel();
        lblCustProduct = new javax.swing.JLabel();
        txtCustID = new javax.swing.JTextField();
        txtCustName = new javax.swing.JTextField();
        txtCustproduct = new javax.swing.JTextField();
        btnCusAdd = new javax.swing.JButton();
        btnCustCancel = new javax.swing.JButton();
        pnlProductData = new javax.swing.JPanel();
        lblProdData = new javax.swing.JLabel();
        lblProdID = new javax.swing.JLabel();
        lblProdName = new javax.swing.JLabel();
        lblProdDesc = new javax.swing.JLabel();
        txtProdID = new javax.swing.JTextField();
        txtProdName = new javax.swing.JTextField();
        txtProdDesc = new javax.swing.JTextField();
        btnProdAdd = new javax.swing.JButton();
        btnProdCancel = new javax.swing.JButton();
        pnlWelcome = new javax.swing.JPanel();
        lblwelcome = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        rdbtnAdmin = new javax.swing.JRadioButton();
        rdbtnCustomer = new javax.swing.JRadioButton();
        pnlAddEdit = new javax.swing.JPanel();
        lblAddEdit = new javax.swing.JLabel();
        rdbtnCustomerData = new javax.swing.JRadioButton();
        rdbtbProductData = new javax.swing.JRadioButton();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCustData.setText("Customer Details");

        lblCustID.setText("ID :");

        lblCustName.setText("Name :");

        lblCustProduct.setText("Product :");

        btnCusAdd.setText("Add");
       
        btnCusAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				/*
				 *  TODO: Insert Customer details into database
				 */
				int prodId = Integer.getInteger(txtProdID.getText());
				CustomerData custData = new CustomerData();
				custData.setId(Integer.getInteger(txtCustID.getText()));
				custData.setCustomerName(txtCustName.getText());
			//	custData.setItemsList(itemsList);
				/*
				 * Code for insertion in table in database
				 */
			}
        });

        btnCustCancel.setText("Cancel");
        btnCustCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of cancel button of customer data*/
                btnCustCancelActionPerformed(evt);
            }
        });
        /*UI of Customer data layout*/
        javax.swing.GroupLayout pnlCustomerDataLayout = new javax.swing.GroupLayout(pnlCustomerData);
        pnlCustomerData.setLayout(pnlCustomerDataLayout);
        pnlCustomerDataLayout.setHorizontalGroup(
            pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lblCustData))
                    .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                                .addComponent(btnCusAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnCustCancel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustName)
                                    .addComponent(lblCustProduct)
                                    .addComponent(lblCustID))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustID)
                                    .addComponent(txtCustproduct)
                                    .addComponent(txtCustName))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCustomerDataLayout.setVerticalGroup(
            pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustID)
                    .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustName)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustProduct)
                    .addComponent(txtCustproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusAdd)
                    .addComponent(btnCustCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblProdData.setText("Product Details");

        lblProdID.setText("ID :");

        lblProdName.setText("Name :");

        lblProdDesc.setText("Description :");

        btnProdAdd.setText("Add");

        btnProdCancel.setText("Cancel");
        
        btnProdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of Product cancel button*/
                btnProdCancelActionPerformed(evt);
            }
        });
        /*UI of product data layout*/
        javax.swing.GroupLayout pnlProductDataLayout = new javax.swing.GroupLayout(pnlProductData);
        pnlProductData.setLayout(pnlProductDataLayout);
        pnlProductDataLayout.setHorizontalGroup(
            pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDataLayout.createSequentialGroup()
                .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlProductDataLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lblProdData))
                    .addGroup(pnlProductDataLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductDataLayout.createSequentialGroup()
                                .addComponent(lblProdDesc)
                                .addGap(18, 18, 18)
                                .addComponent(txtProdDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductDataLayout.createSequentialGroup()
                                .addComponent(btnProdAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProdCancel))
                            .addGroup(pnlProductDataLayout.createSequentialGroup()
                                .addComponent(lblProdName)
                                .addGap(44, 44, 44)
                                .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductDataLayout.createSequentialGroup()
                                .addComponent(lblProdID)
                                .addGap(60, 60, 60)
                                .addComponent(txtProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        pnlProductDataLayout.setVerticalGroup(
            pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProdData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProdID)
                    .addComponent(txtProdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProdName)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProdDesc)
                    .addComponent(txtProdDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnlProductDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProdAdd)
                    .addComponent(btnProdCancel)))
        );

        lblwelcome.setText("Welcome to Omazan!!");

        lblLogin.setText("Login As: ");

        rdbtnAdmin.setText("Admin/Employee");
        rdbtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of Admin selection*/
                rdbtnAdminActionPerformed(evt);
            }
        });

        rdbtnCustomer.setText("Customer");
        /*UI of Welcome panel*/
        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblwelcome))
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblLogin)
                        .addGap(18, 18, 18)
                        .addComponent(rdbtnAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(rdbtnCustomer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addComponent(lblwelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(rdbtnAdmin)
                    .addComponent(rdbtnCustomer)))
        );

        lblAddEdit.setText("Add/Edit Data");

        rdbtnCustomerData.setText("Customer Data");
        rdbtnCustomerData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of customer selection*/
                rdbtnCustomerDataActionPerformed(evt);
            }
        });

        rdbtbProductData.setText("Product Data");
        rdbtbProductData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of Product selection*/
                rdbtbProductDataActionPerformed(evt);
            }
        });

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	/*Event generated on click of Go back button*/
                btnGoBackActionPerformed(evt);
            }
        });
        /*UI of Add and edit panel*/
        javax.swing.GroupLayout pnlAddEditLayout = new javax.swing.GroupLayout(pnlAddEdit);
        pnlAddEdit.setLayout(pnlAddEditLayout);
        pnlAddEditLayout.setHorizontalGroup(
            pnlAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEditLayout.createSequentialGroup()
                .addGroup(pnlAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddEditLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblAddEdit))
                    .addGroup(pnlAddEditLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(rdbtnCustomerData)
                        .addGap(34, 34, 34)
                        .addComponent(rdbtbProductData))
                    .addGroup(pnlAddEditLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnGoBack)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
       
        pnlAddEditLayout.setVerticalGroup(
            pnlAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnCustomerData)
                    .addComponent(rdbtbProductData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGoBack)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCustomerData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnlAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(pnlAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCustomerData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlProductData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>
	
	private void btnCustCancelActionPerformed(java.awt.event.ActionEvent evt) {                                              
		/*Action performed on click of cancel*/
        txtCustID.setText("");
        txtCustName.setText("");
        txtCustproduct.setText("");
        pnlAddEdit.setVisible(true);
        pnlCustomerData.setVisible(false);
        
    }  
	
	private void rdbtnAdminActionPerformed(java.awt.event.ActionEvent evt) {                                           
		/*Action performed on selection of "Admin"*/
        pnlAddEdit.setVisible(true);
        pnlWelcome.setVisible(false);
    }
	
	 private void rdbtnCustomerDataActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		 /*Action performed on selection of "Customer data" to add details*/
	        pnlAddEdit.setVisible((false));
	        pnlCustomerData.setVisible(true);
	    }
	 
	 private void rdbtbProductDataActionPerformed(java.awt.event.ActionEvent evt) {                                                 
		 /*Action performed on selection of "Product"*/
	        pnlAddEdit.setVisible(false);
	        pnlProductData.setVisible((true));
	    }
	 
	 private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {
		 /*Action performed on click of GoBack button*/
	        pnlAddEdit.setVisible((false));
	        pnlWelcome.setVisible((true));
	    }
	 
	 private void btnProdCancelActionPerformed(java.awt.event.ActionEvent evt) {                                              
	        /*Action performed on click of canceling product details*/
	        txtProdID.setText("");
	        txtProdName.setText("");
	        txtProdDesc.setText("");
	        pnlAddEdit.setVisible(true);
	        pnlProductData.setVisible(false);
	    } 
	
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OmazanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OmazanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OmazanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OmazanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OmazanUI().setVisible(true);
            }
        });
        
    }
	
	// Variables declaration                    
    private javax.swing.JButton btnCusAdd;
    private javax.swing.JButton btnCustCancel;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnProdAdd;
    private javax.swing.JButton btnProdCancel;
    private javax.swing.JLabel lblAddEdit;
    private javax.swing.JLabel lblCustData;
    private javax.swing.JLabel lblCustID;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblCustProduct;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblProdData;
    private javax.swing.JLabel lblProdDesc;
    private javax.swing.JLabel lblProdID;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblwelcome;
    private javax.swing.JPanel pnlAddEdit;
    private javax.swing.JPanel pnlCustomerData;
    private javax.swing.JPanel pnlProductData;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JRadioButton rdbtbProductData;
    private javax.swing.JRadioButton rdbtnAdmin;
    private javax.swing.JRadioButton rdbtnCustomer;
    private javax.swing.JRadioButton rdbtnCustomerData;
    private javax.swing.JTextField txtCustID;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustproduct;
    private javax.swing.JTextField txtProdDesc;
    private javax.swing.JTextField txtProdID;
    private javax.swing.JTextField txtProdName;
    // End of variables declaration   

}
