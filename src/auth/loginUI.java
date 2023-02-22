package auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;

import dashboard.homeUI;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class loginUI {

	private JFrame frmAuthentification;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Look and feel 
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		// Look and feel
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI window = new loginUI();
					window.frmAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.setBackground(Color.WHITE);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 437, 314);
		frmAuthentification.setResizable(false);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthentification.getContentPane().setLayout(null);
		frmAuthentification.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Entrez votre nom d'utilisateur");
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 428, 275);
		frmAuthentification.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 21, 167, 42);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(59, 99, 297, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur");
		lblNewLabel_1.setBounds(59, 74, 295, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe");
		lblNewLabel_2.setBounds(59, 145, 295, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Entrez votre mot de passe");
		passwordField.setBounds(59, 169, 295, 30);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.setBounds(162, 210, 112, 40);
		btnNewButton.setForeground(new java.awt.Color(0, 51, 255));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	login(evt);
            }
        });
		panel.add(btnNewButton);
	}
	
	Statement stmt;
	Connexion dbConnexion = new Connexion();
	
	 private void login(java.awt.event.ActionEvent evt) {
		 String requete ="select * from users where username ='"+textField.getText()+"' and password ='"+passwordField.getText()+"' ";
	        try{
	            
	            stmt= dbConnexion.ObtenirConnexion().createStatement();
	            ResultSet resultat= stmt.executeQuery(requete);

	        if(!resultat.next()){
	            JOptionPane.showMessageDialog(null, "Invalide login détails!", "Login Error",JOptionPane.ERROR_MESSAGE);
	            textField.setText(null);
	            passwordField.setText(null);
	        }else{
	             this.t1 = resultat.getString("username");
	             frmAuthentification.setVisible(false);
	          new homeUI().setVisible(true);                
	        }   
	            
	        }catch(Exception e){
	            System.out.println("--> Exception : " + e) ;  
	        }
	}
}
