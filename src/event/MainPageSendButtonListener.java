package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import application.Database;

public class MainPageSendButtonListener implements MouseListener {

	private JTextComponent fieldMail;

	private JTextComponent fieldMessage;

	private JTextComponent fieldSubject;
	

	// method for fields...
	public MainPageSendButtonListener(JTextComponent fieldMail, JTextComponent fieldSubject, JTextComponent fieldMessage) {
		this.fieldMail = fieldMail; 
		this.fieldSubject = fieldSubject;
		this.fieldMessage = fieldMessage;
	}

	@Override
	// action on the Send Button
	public void mouseClicked(MouseEvent e) {
		
		Date date = new Date();
		String email = fieldMail.getText();
		String subject = fieldSubject.getText();
		String message = fieldMessage.getText();
		
		Database.addRecord(date, email, subject, message); 
		
		JOptionPane.showMessageDialog(e.getComponent(), "Email was sent successfully!");
		
		fieldMail.setText("");
		fieldSubject.setText("");
		fieldMessage.setText("");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public void setSentLabel() {
		
	}

}
