/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author MyLau
 */
@SuppressWarnings("serial")
public final class WithdrawalsHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form WithdrawalsHome
     */
    public boolean dataStatu;
    public String selected_product;
    public int selected_product_id;
    public int selected_product_quantity;
    public void getData(){
        try{

            java.sql.Statement stmt1 = maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM withdrawals");
            jTable1.setModel(DbUtils.resultSetToTableModel(resultat));

       }catch(SQLException e){
	
       }
    }
    
    @SuppressWarnings("unchecked")
	public void getProducts(){
        try{

            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat = stmt1.executeQuery("SELECT * FROM products WHERE quantite > 0");
 	        while(resultat.next()) {
 	        	jCMedicaments.addItem(resultat.getString("nom"));
 	        }
 	
       }catch(Exception e){
    	   JOptionPane.showMessageDialog(null,"Error loading total PVT"+ e.toString());
       }
    }
    

    public WithdrawalsHome() {
        initComponents();
        jCMedicaments.setEditable(false);
        jTId.setVisible(false);
        //jTAvance.setEditable(true);
        
        setLocation(8,32);
        
        getData();
        getProducts();
        dataStatu= true;
         SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
       
      }
      
    });
         pack();
    }
    
    Statement stmt;
    Connexion maConnexion = new Connexion(); 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "CallToPrintStackTrace", "rawtypes"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTQuantiteVendu = new javax.swing.JTextField();
        jLProduct = new javax.swing.JLabel();
        jLNIF = new javax.swing.JLabel();
        jCMedicaments = new javax.swing.JComboBox();
        jLNiveauEtude = new javax.swing.JLabel();
        jTPrixVente = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jBSauver = new javax.swing.JButton();
        jBNouveau = new javax.swing.JButton();
        jBQuitter = new javax.swing.JButton();
        jSupprimer = new javax.swing.JButton();
        jBImprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTSearch = new javax.swing.JTextField();
        jLTel1 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES SORTIES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Génerale"));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(new TitledBorder(null, "Enregistrer Sortie", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        jTQuantiteVendu.setText(" ");
        jTQuantiteVendu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAposteActionPerformed(evt);
            }
        });
        
        jTQuantiteVendu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                //jTAposteKeyTyped(evt);
            }
        });

        jLProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLProduct.setForeground(new java.awt.Color(255, 102, 102));
        jLProduct.setText("Medicament");

        jLNIF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNIF.setForeground(new java.awt.Color(255, 102, 102));
        jLNIF.setText("Prix de vente");
        jCMedicaments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSexeActionPerformed(evt);
                selected_product = jCMedicaments.getSelectedItem().toString();
            }
        });

        jLNiveauEtude.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNiveauEtude.setForeground(new java.awt.Color(255, 102, 102));
        jLNiveauEtude.setText("Quantite vendu");

        jTPrixVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSalaireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLProduct, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLNIF)
        				.addComponent(jLNiveauEtude))
        			.addGap(49)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jTQuantiteVendu, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        				.addComponent(jTPrixVente, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        				.addComponent(jCMedicaments, 0, 135, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLProduct, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCMedicaments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLNIF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTPrixVente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLNiveauEtude, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTQuantiteVendu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opérations"));

        jBSauver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_save.png"))); // NOI18N
        jBSauver.setText("Sauver");
        jBSauver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSauverActionPerformed(evt);
            }
        });

        jBNouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/all_new.png"))); // NOI18N
        jBNouveau.setText("Nouveau");
        jBNouveau.setMaximumSize(new java.awt.Dimension(101, 23));
        jBNouveau.setMinimumSize(new java.awt.Dimension(101, 23));
        jBNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNouveauActionPerformed(evt);
            }
        });

        jBQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/use_exit.png"))); // NOI18N
        jBQuitter.setText("Sortir");
        jBQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitterActionPerformed(evt);
            }
        });

        jSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_delete.png"))); // NOI18N
        jSupprimer.setText("Supprimer");
        jSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSupprimerActionPerformed(evt);
            }
        });

        jBImprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_print.png"))); // NOI18N
        jBImprimer.setText("Imprimer");
        jBImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jBNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSauver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSupprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBImprimer)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSauver)
                    .addComponent(jBNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBQuitter)
                    .addComponent(jSupprimer)
                    .addComponent(jBImprimer))
                .addGap(62, 62, 62))
        );

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche d'un employé"));

        jTSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTSearchKeyReleased(evt);
            }
        });

        jLTel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTel1.setForeground(new java.awt.Color(0, 51, 255));
        jLTel1.setText("ENTRER LE PRENOM");

        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTel1)
                    .addComponent(jTId))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6Layout.setHorizontalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel7, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6.setLayout(jPanel6Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jPAppli");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTAposteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAposteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAposteActionPerformed

    private void jTAposteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAposteKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTAposteKeyTyped

    private void jCSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSexeActionPerformed
        // TODO add your handling code here:
    	java.sql.Statement stmt1;
		try {
			stmt1 = maConnexion.ObtenirConnexion().createStatement();
			java.sql.ResultSet resultat= stmt1.executeQuery("SELECT id,quantite FROM products WHERE nom='"+jCMedicaments.getSelectedItem().toString()+"'");
			if(resultat.next()){
			    selected_product_id = resultat.getInt(1);
			    selected_product_quantity = resultat.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void jBSauverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSauverActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        String product_name_recup = jCMedicaments.getSelectedItem().toString();
        String prix_vente_recup = jTPrixVente.getText().trim();
        String quantite_vendu_recup =jTQuantiteVendu.getText().trim();
        
        if(jTPrixVente.getText().trim().length()>0 && jTQuantiteVendu.getText().trim().length()>0){

        if(dataStatu==true){
        	
        	if(selected_product_quantity >= Integer.parseInt(quantite_vendu_recup)) {
        	int remaining_quantity = selected_product_quantity - Integer.parseInt(quantite_vendu_recup);
        	float total_sold = Float.parseFloat(prix_vente_recup) * Float.parseFloat(quantite_vendu_recup);
        	String strNumber = Float.toString(total_sold);
            try{
        
            String requete="INSERT INTO withdrawals(produit_id,nom_produit,prix_vente,prix_vente_total,quantite_vendu)value ('"+selected_product_id+"','"+product_name_recup+"','"+prix_vente_recup+"','"+strNumber+"','"+quantite_vendu_recup+"')";
            stmt=maConnexion.ObtenirConnexion().createStatement();
            stmt.executeUpdate(requete);
            
            String requete1 ="UPDATE products SET quantite = '"+remaining_quantity+"' WHERE id='"+selected_product_id+"'";
            try{
                stmt=maConnexion.ObtenirConnexion().createStatement();
                stmt.executeUpdate(requete1);        
            }                                       
            catch(SQLException ex){
                System.err.println(ex);
            }
            
            JOptionPane.showMessageDialog(null,"Enregistrement réussi!");
            getData();
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null,e);
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Quelque chose n'a pas marché!");
            }
        	} else {
        		JOptionPane.showMessageDialog(null, "Quantité demandée est superieur a la quantité en Stock!");
        	}
       
      }else{
            
      try{
            stmt = maConnexion.ObtenirConnexion().createStatement();
            String requete="UPDATE withdrawals  SET nom_produit='"+product_name_recup+"',prix_vente='"+prix_vente_recup+"',quantite_vendu='"+quantite_vendu_recup+"' where id='"+jTId.getText()+"'";

      try{
            stmt = maConnexion.ObtenirConnexion().createStatement();
            stmt .executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Modification réussie!");
            getData();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        }
      catch(SQLException ex){
            System.err.println(ex);
        }
        }
        }else{
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
        }   
       
    }//GEN-LAST:event_jBSauverActionPerformed

    private void jBNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNouveauActionPerformed
        // TODO add your handling code here:
        dataStatu=true;
        
        jTPrixVente.setText("");
        jTQuantiteVendu.setText("");
        jCMedicaments.setSelectedIndex(0);
        
        getData();
     
    }//GEN-LAST:event_jBNouveauActionPerformed

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        dataStatu=false;
        try{
            int row=jTable1.getSelectedRow();
            String table1_click=(jTable1.getModel().getValueAt(row,0).toString());
            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * withdrawals AVANCE WHERE id ='"+table1_click+"'");

            if(resultat.next()){
                jCMedicaments.setSelectedItem(resultat.getString("nom_produit"));                
                jTPrixVente.setText(resultat.getString("prix_vente"));
                jTQuantiteVendu.setText(resultat.getString("quantite_vendu"));
            }

        }catch(SQLException e){

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupprimerActionPerformed
        // TODO add your handling code here:
        String requete="DELETE FROM AVANCE WHERE code='"+jTId.getText()+"'";
        try{
            stmt = maConnexion.ObtenirConnexion().createStatement();
            stmt.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Suppresion réussie!");          
      }                                           
      catch(SQLException ex){
            System.err.println(ex);
      }
       
        jCMedicaments.setSelectedItem("Masculin");
        jTPrixVente.setText("");
        jTQuantiteVendu.setText(""); 
        getData();
    }//GEN-LAST:event_jSupprimerActionPerformed

    private void jTSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyReleased
        // TODO add your handling code here:

        //String requete="select* from EMPLOYE where prenom LIKE '" + jTNom.getText() + "%'";
        dataStatu=false;
        
        try{
            java.sql.Statement stmt1 = maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM withdrawals where date_vente LIKE '" + jTSearch.getText().trim() + "%'");
            jTable1.setModel(DbUtils.resultSetToTableModel(resultat));
	
       }catch(Exception e){
	
	
       }
        
    }//GEN-LAST:event_jTSearchKeyReleased

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdActionPerformed

    private void jTSalaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSalaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSalaireActionPerformed

    private void jBImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimerActionPerformed
        // TODO add your handling code here:
        int detteRecup=0;
        String requete="SELECT SUM(prix_vente) AS nbMontant FROM withdrawals";
        try{
            stmt=maConnexion.ObtenirConnexion().createStatement();
            ResultSet resultat= stmt.executeQuery(requete);

                while(resultat.next()){

                    detteRecup=resultat.getInt("date_vente");
     
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String dateRecup;
        dateRecup = sdf.format(new Date());
        //final String dated=sdf.format(jTDateDebut.getDate());
        final String TOTAL=Integer.toString(detteRecup);

        
        if(jTPrixVente.getText().trim().length()>0 && jTPrixVente.getText().trim().length()>0 && jTQuantiteVendu.getText().trim().length()>0){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
 
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        int marge=30;
        int x = (int)pageFormat.getImageableX();
        int y = (int)pageFormat.getImageableY();
                 
        graphics.setFont(new Font("Times new roman", Font.BOLD, 20));
        graphics.setColor(Color.BLACK);
        graphics.drawString("                      FICHE SORTIES\n", x + marge, y + marge);
 
        graphics.drawLine(100, 40, 470, 40);    
    
        graphics.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        graphics.drawString(" *Nom", 130, 80);        
        graphics.drawString(jTPrixVente.getText(), 350, 80);
        
        graphics.drawString(" *Qte", 130, 110);
        graphics.drawString(jTQuantiteVendu.getText(), 350, 110);
        
        graphics.drawString(" *PV", 130, 140);
        graphics.drawString(jCMedicaments.getSelectedItem().toString(), 350, 140);
        
        graphics.drawString(" *PVT", 130, 170);
        graphics.drawString("0.0", 350, 170);      
                
        graphics.drawString(" *PV", 130, 200);
        graphics.drawString(jTPrixVente.getText()+" Gdes.", 350, 200);
        
        graphics.drawString(" *Montant dû", 130, 230);
        graphics.drawString((String) TOTAL+" Gdes.", 350, 230);
        
        graphics.drawString(" *Poste", 130, 270);
        graphics.drawString(jTQuantiteVendu.getText().trim(), 350, 270);
        
        graphics.drawString(" *Date de l'impression", 130, 300);
        graphics.drawString(dateRecup, 350, 300);
             
        //graphics.drawString(" *Type Congé", 130, 330);
        //graphics.drawString((String) jCTypeConge.getSelectedItem(), 350, 330);
        
        //graphics.drawString(" *Nbre. de Jours", 130, 360);
        //graphics.drawString(s1, 350, 360);

        return PAGE_EXISTS;
            }
 
        });
boolean doPrint = job.printDialog();
if(doPrint) {
    try {
         
        job.print();
    }
    catch (PrinterException e1) {
            JOptionPane.showMessageDialog(null, e1);
    }
}}else{
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un employé!");
        }
    }//GEN-LAST:event_jBImprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimer;
    private javax.swing.JButton jBNouveau;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jBSauver;
    private javax.swing.JComboBox jCMedicaments;
    private javax.swing.JLabel jLNIF;
    private javax.swing.JLabel jLNiveauEtude;
    private javax.swing.JLabel jLProduct;
    private javax.swing.JLabel jLTel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSupprimer;
    private javax.swing.JTextField jTQuantiteVendu;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTPrixVente;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JTable jTable1;
}
