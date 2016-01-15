package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.text.JTextComponent;

import application.Database;

public class SendButtonListener implements MouseListener {

	private JTextComponent fieldMail;

	private JTextComponent fieldMessage;

	private JTextComponent fieldSubject;

	public SendButtonListener(JTextComponent fieldMail, JTextComponent fieldSubject, JTextComponent fieldMessage) {
		this.fieldMail = fieldMail;
		this.fieldSubject = fieldSubject;
		this.fieldMessage = fieldMessage;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Date date = new Date();
		
		String email = fieldMail.getText();
		String subject = fieldSubject.getText();
		String message = fieldMessage.getText();
		
//		DatabaseRecord record = new DatabaseRecord();
//		record.setMail(mail);
//		record.setSubject(subject);
//		Database.addRecord(record);
		
		Database.addRecord(date, email, subject, message); // eto udalit. postavit vyshe
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
		// TODO add label as argument, and change text if sent
		
	}

}
