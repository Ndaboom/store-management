package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auth.Connexion;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProductExpired extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public int row;
    String table1_click;
    Statement stmt;
    Connexion maConnexion= new Connexion();
    private JTable table_1;
    private int selected_product_id = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Look and feels
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductExpired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductExpired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductExpired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductExpired.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		// Look and feels
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductExpired frame = new ProductExpired();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public void getData(){
    	// Select all from products that are expiring in the next 30 days
        try{
            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT id,quantite,unite,nom,secteur,PAU,PAT,date_expiration FROM `products` WHERE date_expiration BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)");
            table_1.setModel(DbUtils.resultSetToTableModel(resultat));
       }catch(Exception e){
	
       }
    }
    
    public void getData1(){
    	// Select all from products that are expiring in the next 30 days
        try{
            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT id,quantite,unite,nom,secteur,PAU,PAT,date_expiration FROM `products` WHERE date_expiration >= CURDATE()");
            table.setModel(DbUtils.resultSetToTableModel(resultat));
       }catch(Exception e){
	
       }
    }

	/**
	 * Create the frame.
	 */
	public ProductExpired() {
		setBounds(100, 100, 618, 339);
		setTitle("Alert!!!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 602, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alert!!! Ces produits expirent dans les prochains 30 jours...");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 390, 22);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(20, 44, 428, 83);
		table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(453, 95, 139, 49);
		panel_1.setBackground(new Color(204,255,204));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton jSupprimer = new JButton();
		jSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, null, "Supprimer le medicament selectionné?",
					      JOptionPane.YES_NO_CANCEL_OPTION,
					      JOptionPane.PLAIN_MESSAGE, null);
					      if(res == 0) {
					    	  deleteProduct();
					      } else if (res == 1) {
					         System.out.println("Operation cancelled");
				}		
			}
		});
		jSupprimer.setBounds(10, 11, 119, 25);
		panel_1.add(jSupprimer);
		jSupprimer.setIcon(new ImageIcon(ProductExpired.class.getResource("/Image/user_delete.png")));
		jSupprimer.setText("Supprimer");
		
		JLabel lblProduitsDejaExpires = new JLabel("Produits déjà expirés");
		lblProduitsDejaExpires.setForeground(Color.RED);
		lblProduitsDejaExpires.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduitsDejaExpires.setBounds(20, 156, 390, 22);
		panel.add(lblProduitsDejaExpires);
		
		table_1 = new JTable();
		table_1.setBounds(20, 190, 428, 83);
		table_1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panel.add(table_1);
		
		getData();
		getData1();
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            jTable1MouseClicked(evt);
	        }
	    });
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            jTable1MouseClicked1(evt);
	        }
	    });
	}
	
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:  
        try{
            row = table.getSelectedRow();
            table1_click= (table.getModel().getValueAt(row,0).toString());
            java.sql.Statement stmt1=maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT id FROM products WHERE id='"+table1_click+"'");

            if(resultat.next()){
                selected_product_id = resultat.getInt("id");
            }

        }catch(Exception e){

        }
    }
	
	private void jTable1MouseClicked1(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:  
        try{
            row = table_1.getSelectedRow();
            table1_click= (table_1.getModel().getValueAt(row,0).toString());
            java.sql.Statement stmt1=maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT id FROM products WHERE id='"+table1_click+"'");

            if(resultat.next()){
                selected_product_id = resultat.getInt("id");
            }

        }catch(Exception e){

        }
    }
	
	public void deleteProduct() {
		if(table1_click != "") { 
			
	        String requete="DELETE FROM products WHERE id='"+table1_click+"'";
	        System.out.println(table1_click);
	        
	        try{
	            stmt=maConnexion.ObtenirConnexion().createStatement();
	            stmt.executeUpdate(requete);
	            getData1();
	            getData();
	            JOptionPane.showMessageDialog(null, "Suppresion réussie!");         
	        }catch(SQLException ex) {
	            System.err.println(ex);
	        }
	        
	        } else {
	            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un medicament!"); 
	        }
	}
}
