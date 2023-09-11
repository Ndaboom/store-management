/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Sammy Ndabo
 */
public class AccountHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form Liste transactions et tri
     */
    Statement stmt;
    Connexion maConnexion=new Connexion();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    JLabel lblNewLabel_3 = new JLabel("0");
    JLabel lblNewLabel_5 = new JLabel("0");
    JLabel lblNewLabel_7 = new JLabel("0");
    float PAT, PVT, Profits,Tithes;
    
    public AccountHome() {
        initComponents();
        setLocation(8,32);
        getProfitsAndTithes();
        InitialialData();
        
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String str = formatter.format(date);
//        System.out.print(str);
    }
    
    private void InitialialData() {
    	DefaultTableModel model=new DefaultTableModel();
        model.addColumn("ID Produit");
        model.addColumn("Nom");        
        model.addColumn("Prix vente");
        model.addColumn("PVT");
        model.addColumn("Quantite vendu");
        model.addColumn("Date vente");
        
    	String requeteListeLivre="select * from withdrawals";
        try{
            stmt=maConnexion.ObtenirConnexion().createStatement();
            ResultSet resultat= stmt.executeQuery(requeteListeLivre);
            while(resultat.next()){
                model.addRow(new Object [] {resultat.getString("produit_id"),resultat.getString("nom_produit"),resultat.getString("prix_vente"), resultat.getString("prix_vente_total"),resultat.getString("quantite_vendu"),
                    resultat.getString("date_vente")});
            }
        }catch(SQLException ex){
        	System.out.println(ex);
        }
        //TableEmp.setModel(model);
        // Fetch total of incomes
        try{

            java.sql.Statement stmt1 = maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat = stmt1.executeQuery("SELECT ROUND(SUM(prix_vente_total),2) FROM withdrawals");
	        while(resultat.next()) {
	        	lblNewLabel_3.setText(resultat.getFloat(1)+ " $");
	        }
	
       }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
       }
    }
    
    private void getData(String input1,String input2) {
    	DefaultTableModel model=new DefaultTableModel();
        model.addColumn("ID Produit");
        model.addColumn("Nom");        
        model.addColumn("Prix vente");
        model.addColumn("PVT");
        model.addColumn("Quantite vendu");
        model.addColumn("Date vente");
    	String requeteListeLivre="select * from withdrawals where date_vente >= '"+input1+"' AND date_vente <= '"+input2+"'";
    	System.out.print("Comparing from "+input1+" to "+input2);
        try{
            stmt=maConnexion.ObtenirConnexion().createStatement();
            ResultSet resultat= stmt.executeQuery(requeteListeLivre);
            while(resultat.next()){
                model.addRow(new Object [] {resultat.getString("produit_id"),resultat.getString("nom_produit"),resultat.getString("prix_vente"), resultat.getString("prix_vente_total"),resultat.getString("quantite_vendu"),
                    resultat.getString("date_vente")});
            }
        }catch(SQLException ex){
        System.out.println(ex);
        }
        TableEmp.setModel(model);
   
        // Fetch total of incomes
        try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT ROUND(SUM(prix_vente_total),2) FROM withdrawals where date_vente >= '"+input1+"' AND date_vente <= '"+input2+"'");
	        while(resultat.next()) {
	        	lblNewLabel_3.setText(resultat.getString(1)+ " $");
	        }
	
       }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
       }
        
        // Fetch profits and tithes 
        
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM withdrawals where date_vente >= '"+input1+"' AND date_vente <= '"+input2+"'");
            
            while(resultat.next()) {
	        	PVT = resultat.getFloat(1);
	        	Profits = (resultat.getFloat("prix_vente") - resultat.getFloat("PA")) * resultat.getFloat("quantite_vendu");
	        }
            
            Tithes = Profits/10;
            
            lblNewLabel_5.setText(Profits+ " $");
            lblNewLabel_7.setText(Tithes+" $");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEmp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comptabilité"));

        TableEmp.setBackground(new java.awt.Color(204, 255, 204));
        TableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableEmp);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
       
        com.toedter.calendar.JDateChooser jDateChooser1 = new com.toedter.calendar.JDateChooser();
        com.toedter.calendar.JDateChooser jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
        
        Date d = new Date(0);
        jDateChooser1.setDate(d);
        jDateChooser2.setDate(d);
        
        jDateChooser1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(jDateChooser1 != null) {
					if(sdf.format(jDateChooser1.getDate()) != null && sdf.format(jDateChooser2.getDate()) != null) {
						getData(sdf.format(jDateChooser1.getDate()),sdf.format(jDateChooser2.getDate()));
					}
				}
			}
        	
        });
        
        jDateChooser2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(jDateChooser2 != null) {
				 if(sdf.format(jDateChooser1.getDate()) != "" && sdf.format(jDateChooser2.getDate()) != "") {
					getData(sdf.format(jDateChooser1.getDate()),sdf.format(jDateChooser2.getDate()));
				 }
				}
			}
        	
        });
        
        JLabel lblNewLabel = new JLabel("Limite 1");
        
        JLabel lblNewLabel_1 = new JLabel("Limite 2");
        
        panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBackground(new Color(255, 255, 255));
        


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(235)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
        					.addGap(157))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        					.addGap(47)
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jButton1)
        					.addComponent(lblNewLabel))
        				.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblNewLabel_1)))
        			.addGap(18)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(155, Short.MAX_VALUE))
        );
        panel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Entrees");
        lblNewLabel_2.setBounds(10, 33, 47, 14);
        panel.add(lblNewLabel_2);
        lblNewLabel_3.setBounds(67, 33, 110, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Benefices");
        lblNewLabel_4.setBounds(187, 33, 58, 14);
        panel.add(lblNewLabel_4);
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
        			.addGap(189))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(2))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 719, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(95, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Liste des ventes");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            TableEmp.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void getProfitsAndTithes() {
		System.out.println("Get profitsAndTithes function called");
		try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM withdrawals");
            
            while(resultat.next()) {
	        	PVT = resultat.getFloat(1);
	        	Profits = (resultat.getFloat("prix_vente") - resultat.getFloat("PA")) * resultat.getFloat("quantite_vendu");
	        }
            
            Tithes = Profits/10;
            lblNewLabel_5.setBounds(255, 33, 81, 14);
            panel.add(lblNewLabel_5);
            
            lblNewLabel_5.setText(Profits+ " $");
            
            JLabel lblNewLabel_6 = new JLabel("Dimes");
            lblNewLabel_6.setBounds(362, 33, 52, 14);
            panel.add(lblNewLabel_6);
            lblNewLabel_7.setBounds(461, 33, 118, 14);
            panel.add(lblNewLabel_7);
            lblNewLabel_7.setText(Tithes+" $");
            
	
        }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total incomes"+ e.toString());
        }
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private JPanel panel;
}
