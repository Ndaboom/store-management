package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auth.Connexion;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ProductExpired extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public int row;
    String table1_click;
    Statement stmt;
    Connexion maConnexion= new Connexion();
    private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT quantite,unite,nom,secteur,PAU,PAT,date_expiration FROM `products` WHERE date_expiration BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)");
            table.setModel(DbUtils.resultSetToTableModel(resultat));
       }catch(Exception e){
	
       }
    }
    
    public void getData1(){
    	// Select all from products that are expiring in the next 30 days
        try{
            java.sql.Statement stmt1= maConnexion.ObtenirConnexion().createStatement();
            java.sql.ResultSet resultat= stmt1.executeQuery("SELECT quantite,unite,nom,secteur,PAU,PAT,date_expiration FROM `products` WHERE date_expiration >= CURDATE()");
            table_1.setModel(DbUtils.resultSetToTableModel(resultat));
       }catch(Exception e){
	
       }
    }

	/**
	 * Create the frame.
	 */
	public ProductExpired() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(453, 44, 139, 83);
		panel_1.setBackground(new Color(204,255,204));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton jSupprimer = new JButton();
		jSupprimer.setBounds(10, 11, 119, 25);
		panel_1.add(jSupprimer);
		jSupprimer.setIcon(new ImageIcon(ProductExpired.class.getResource("/Image/user_delete.png")));
		jSupprimer.setText("Supprimer");
		
		JLabel lblProduitsDejaExpires = new JLabel("Produits deja expires ");
		lblProduitsDejaExpires.setForeground(Color.RED);
		lblProduitsDejaExpires.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduitsDejaExpires.setBounds(20, 156, 390, 22);
		panel.add(lblProduitsDejaExpires);
		
		table_1 = new JTable();
		table_1.setBounds(20, 190, 428, 83);
		panel.add(table_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(204, 255, 204));
		panel_1_1.setBounds(453, 190, 139, 83);
		panel.add(panel_1_1);
		
		JButton jSupprimer_1 = new JButton();
		jSupprimer_1.setIcon(new ImageIcon(ProductExpired.class.getResource("/Image/user_delete.png")));
		jSupprimer_1.setText("Supprimer");
		jSupprimer_1.setBounds(10, 11, 119, 25);
		panel_1_1.add(jSupprimer_1);
		
		getData();
		getData1();
	}
}
