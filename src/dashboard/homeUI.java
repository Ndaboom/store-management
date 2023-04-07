package dashboard;

import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import auth.Connexion;
import dashboard.homeUI;
import net.proteanit.sql.DbUtils;
import utils.Helpers;

public class homeUI extends javax.swing.JFrame{
	
	 public homeUI() {
	     initComponents();
	     this.setIconImage(new ImageIcon(getClass().getResource("icone_jar.png")).getImage());
	     setExtendedState(JFrame.MAXIMIZED_BOTH);
	     checkForExpiredProducts();
	     // setAlwaysOnTop(true);
	       
	 }
	 private void initComponents() {
		 jPAppli = new javax.swing.JPanel();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jSeparator1 = new javax.swing.JPopupMenu.Separator();
	        jMenuItem5 = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();
	        jMenuItem2 = new javax.swing.JMenuItem();
	        jSeparator2 = new javax.swing.JPopupMenu.Separator();
	        jMenuItem6 = new javax.swing.JMenuItem();
	        jMenu3 = new javax.swing.JMenu();
	        jMenuItem3 = new javax.swing.JMenuItem();
	        jSeparator3 = new javax.swing.JPopupMenu.Separator();
	        jMenuItem7 = new javax.swing.JMenuItem();
	        jMenu4 = new javax.swing.JMenu();
	        jMenuItem4 = new javax.swing.JMenuItem();
	        jSeparator4 = new javax.swing.JPopupMenu.Separator();
	        jMenuItem8 = new javax.swing.JMenuItem();
	        jMenu5 = new javax.swing.JMenu();
	        jMenu6 = new javax.swing.JMenu();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPAppli.setBackground(new java.awt.Color(204, 255, 204));
	        jPAppli.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SYSTEME DE GESTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 3, 24), new java.awt.Color(0, 0, 255))); // NOI18N
	        jPAppli.setName("jPAppli"); // NOI18N

	        javax.swing.GroupLayout jPAppliLayout = new javax.swing.GroupLayout(jPAppli);
	        jPAppli.setLayout(jPAppliLayout);
	        jPAppliLayout.setHorizontalGroup(
	            jPAppliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 1138, Short.MAX_VALUE)
	        );
	        jPAppliLayout.setVerticalGroup(
	            jPAppliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 551, Short.MAX_VALUE)
	        );

	        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-product.png"))); // NOI18N
	        jMenu1.setText("MEDICAMENTS");
	        jMenu1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenu1ActionPerformed(evt);
	            }
	        });

	        jMenuItem1.setText("Accueil");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItem1);
	        jMenu1.add(jSeparator1);

	        jMenuItem5.setText("Liste Medicaments");
	        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem5ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItem5);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/promotion 32.png"))); // NOI18N
	        jMenu2.setText("PROMOTION");

	        jMenuItem2.setText("Accueil");
	        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem2ActionPerformed(evt);
	            }
	        });
	        //jMenu2.add(jMenuItem2);
	        //jMenu2.add(jSeparator2);

	        jMenuItem6.setText("Liste Promotion");
	        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem6ActionPerformed(evt);
	            }
	        });
	        //jMenu2.add(jMenuItem6);

	        //jMenuBar1.add(jMenu2);

	        jMenu3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Conge 32.png"))); // NOI18N
	        jMenu3.setText("CONGE");

	        jMenuItem3.setText("Accueil");
	        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem3ActionPerformed(evt);
	            }
	        });
	        //jMenu3.add(jMenuItem3);
	        //jMenu3.add(jSeparator3);

	        jMenuItem7.setText("Liste Congé");
	        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem7ActionPerformed(evt);
	            }
	        });
	        //jMenu3.add(jMenuItem7);

	        //jMenuBar1.add(jMenu3);

	        jMenu4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/avance 32.png"))); // NOI18N
	        jMenu4.setText("Sortie");

	        jMenuItem4.setText("Accueil");
	        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem4ActionPerformed(evt);
	            }
	        });
	        jMenu4.add(jMenuItem4);
	        jMenu4.add(jSeparator4);

	        jMenuItem8.setText("Liste sorties");
	        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenu7MouseClicked(evt);
	            }
	        });
	        jMenu4.add(jMenuItem8);

	        jMenuBar1.add(jMenu4);

	        jMenu5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/divers 32.png"))); // NOI18N
	        jMenu5.setText("Comptabilité");
	        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jMenu8MouseClicked(evt);
	            }
	        });
	        jMenuBar1.add(jMenu5);

	        jMenu6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fermer 32.png"))); // NOI18N
	        jMenu6.setText("QUITTER");
	        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jMenu6MouseClicked(evt);
	            }
	        });
	        jMenuBar1.add(jMenu6);

	        setJMenuBar(jMenuBar1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPAppli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addComponent(jPAppli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );

	        jPAppli.getAccessibleContext().setAccessibleName("jPAppli");
	        pack();	 
	 }
	 
	 public void checkForExpiredProducts() {
		 try{
	            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
	            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT * FROM `products` WHERE date_expiration >= CURDATE()");
	            
	            // Look for products that expire in the next 30 days
	            java.sql.Statement stmt2 = maConnexion.ObtenirConnexion().createStatement();
	            java.sql.ResultSet resultat2 = stmt2.executeQuery("SELECT * FROM `products` WHERE date_expiration BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)");
	            
	            if(resultat.next() || resultat2.next()) {
	            	Helpers helpers = new Helpers();
	            	helpers.displayTray("Alert", "Certains de vos produits expirent...");
	            	ProductExpired expiredFrame = new ProductExpired();
	            	expiredFrame.setVisible(true);
	            	expiredFrame.setLocationRelativeTo(null);
	            	expiredFrame.setAlwaysOnTop(true);
	            }
	            
	       }catch(Exception e){
		
	       }
	 }
	 
	 private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
	        // TODO add your handling code here:
	        ProductHome addEmp=new ProductHome();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(addEmp);
	        addEmp.show();
	    }//GEN-LAST:event_jMenuItem1ActionPerformed

	    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
	        // TODO add your handling code here:
	        PromotionHome addEmp=new PromotionHome();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(addEmp);
	        addEmp.show();
	        
	    }//GEN-LAST:event_jMenuItem2ActionPerformed

	    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
	        // TODO add your handling code here:
	        CongeHome addEmp=new CongeHome();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(addEmp);
	        addEmp.show();
	    }//GEN-LAST:event_jMenuItem3ActionPerformed

	    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
	        // TODO add your handling code here:
	        System.exit(0);
	    }//GEN-LAST:event_jMenu6MouseClicked
	    
	    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
	        // TODO add your handling code here:
	    	AccountHome accountHome = new AccountHome();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(accountHome);
	        accountHome.show();
	    }
	    
	    private void jMenu7MouseClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
	        // TODO add your handling code here:
	    	System.out.println("Trying to display withdrawalsList");
	    	
	    	WidthdrawalsList widthdrawsList = new WidthdrawalsList();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(widthdrawsList);
	        widthdrawsList.show();
	    }//GEN-LAST:event_jMenu6MouseClicked

	    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
	        // TODO add your handling code here:
	        
	    }//GEN-LAST:event_jMenu1ActionPerformed

	    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
	        // TODO add your handling code here:
	        ProductList listeEmp=new ProductList();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(listeEmp);
	        listeEmp.show();
	    }//GEN-LAST:event_jMenuItem5ActionPerformed

	    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
	        // TODO add your handling code here:
	        ListeConge listeCon=new ListeConge();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(listeCon);
	        listeCon.show();
	    }//GEN-LAST:event_jMenuItem7ActionPerformed

	    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
	        // TODO add your handling code here:
	        WidthdrawalsList listePro=new WidthdrawalsList();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(listePro);
	        listePro.show();
	    }//GEN-LAST:event_jMenuItem6ActionPerformed

	    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
	        // TODO add your handling code here
	        WithdrawalsHome withdrawalsScreen =new WithdrawalsHome();
	        jPAppli.removeAll();
	        jPAppli.repaint();
	        jPAppli.add(withdrawalsScreen);
	        withdrawalsScreen.show();
	    }//GEN-LAST:event_jMenuItem4ActionPerformed

	    /**
	     * @param args the command line arguments
	     */
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
	            java.util.logging.Logger.getLogger(homeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(homeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(homeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(homeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new homeUI().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenu jMenu3;
	    private javax.swing.JMenu jMenu4;
	    private javax.swing.JMenu jMenu5;
	    private javax.swing.JMenu jMenu6;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem1;
	    private javax.swing.JMenuItem jMenuItem2;
	    private javax.swing.JMenuItem jMenuItem3;
	    private javax.swing.JMenuItem jMenuItem4;
	    private javax.swing.JMenuItem jMenuItem5;
	    private javax.swing.JMenuItem jMenuItem6;
	    private javax.swing.JMenuItem jMenuItem7;
	    private javax.swing.JMenuItem jMenuItem8;
	    private javax.swing.JPanel jPAppli;
	    private javax.swing.JPopupMenu.Separator jSeparator1;
	    private javax.swing.JPopupMenu.Separator jSeparator2;
	    private javax.swing.JPopupMenu.Separator jSeparator3;
	    private javax.swing.JPopupMenu.Separator jSeparator4;
	    // End of variables declaration//GEN-END:variables
	    Statement stmt;
	    Connexion maConnexion= new Connexion();
}
