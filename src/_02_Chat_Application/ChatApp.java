package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
JFrame frame;
JPanel panel;
JTextField tf;
JButton button;
Server server;
Client client;
public static void main(String[] args) {
	new ChatApp();
}
public ChatApp() {
	frame = new JFrame();
	panel = new JPanel();
	tf = new JTextField();
	button = new JButton("Send");
	int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "ChatApp", JOptionPane.YES_NO_OPTION);
	if(response == JOptionPane.YES_OPTION){
		server = new Server(8080);
	}else{
		String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
		String prtStr = JOptionPane.showInputDialog("Enter the port number");
		int port = Integer.parseInt(prtStr);
		client = new Client(ipStr, port);
		
	}
	frame.add(panel);
	panel.add(tf);
	panel.add(button);
	frame.setVisible(true);
	frame.pack();
	button.addActionListener((e)->{
		if (response == JOptionPane.YES_OPTION) {
			server.sendMessage(tf.getText());
		} else {
			client.sendMessage(tf.getText());
		}
	});
	if (response == JOptionPane.YES_OPTION) {
		server.start();
	} else {
		client.start();
	}
}
}

