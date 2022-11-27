package auth;

import javax.swing.JFrame;

public class login {
	JFrame frame;
	public login() {
		initComponent();
	}
	
	public void initComponent() {
		frame = new JFrame("Authentification");
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}
}
