package utils;
/**
 * 
 */

/**
 * @author Sammy Ndabo
 *
 */
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Helpers {
	// Pop System Notification
	public void displayTray(String notificationTitle, String notificationContent) throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Notification");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(notificationTitle, notificationContent, MessageType.INFO);
    }
	
	public int displayJOptionPane(String dialogContent) {
		 JOptionPane pane = new JOptionPane(dialogContent);
		 @SuppressWarnings("static-access")
		int d = pane.showConfirmDialog(null, null, dialogContent,
			      JOptionPane.YES_NO_CANCEL_OPTION,
			      JOptionPane.PLAIN_MESSAGE, null);
		 pane.setLocation(10,10);
		 pane.setVisible(true);
		 
		 return d;
	}
}
