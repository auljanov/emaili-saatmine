package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import event.SendButtonListener;

public class MainPage {

	private JFrame frmSendEmail;
	private JTextField textFieldAddressee;
	private JTextField textFieldSubject;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmSendEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSendEmail = new JFrame();
		frmSendEmail.setResizable(false);
		frmSendEmail.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/application/mailboxesgroup.png")));
		frmSendEmail.setBounds(100, 100, 450, 300);
		frmSendEmail.setTitle("Email Sender - main page");
		frmSendEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSendEmail.setSize(700, 447);
		frmSendEmail.getContentPane().setLayout(null);
		
		JLabel lblAuthorLabel = new JLabel("Emails from Mr. Aleksei Uljanov");
		lblAuthorLabel.setForeground(new Color(51, 102, 153));
		lblAuthorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthorLabel.setBounds(25, 13, 550, 28);
		frmSendEmail.getContentPane().add(lblAuthorLabel);

		
		textFieldAddressee = new JTextField();
		textFieldAddressee.setPreferredSize(new Dimension(4, 20));
		textFieldAddressee.setText("@");
		textFieldAddressee.setBounds(168, 69, 505, 20);
		frmSendEmail.getContentPane().add(textFieldAddressee);
		textFieldAddressee.setColumns(10);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(168, 97, 505, 20);
		textFieldSubject.setColumns(10);
		frmSendEmail.getContentPane().add(textFieldSubject);
		
		
		
		JTextArea JTextFieldMessege = new JTextArea();
		JTextFieldMessege.setText("Your text here...");
		JTextFieldMessege.setBounds(22, 152, 650, 242);
		frmSendEmail.getContentPane().add(JTextFieldMessege);
		
		JLabel lblTo = new JLabel("To...");
		lblTo.setBounds(122, 71, 46, 17);
		frmSendEmail.getContentPane().add(lblTo);
		
		
		JButton btnSendMail = new JButton("Send");
		SendButtonListener sendBtnListener = new SendButtonListener(textFieldAddressee, textFieldSubject, JTextFieldMessege);
		sendBtnListener.setSentLabel();
		btnSendMail.addMouseListener(sendBtnListener);
		btnSendMail.setBounds(23, 69, 89, 48);
		
		frmSendEmail.getContentPane().add(btnSendMail);
		
		JButton btnSentItems = new JButton("Sent Items");
		btnSentItems.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SentItems sentItemsWindow = new SentItems();
				sentItemsWindow.populateTable();
				
				sentItemsWindow.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		btnSentItems.setBounds(559, 13, 114, 30);
		frmSendEmail.getContentPane().add(btnSentItems);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(122, 97, 46, 20);
		frmSendEmail.getContentPane().add(lblSubject);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 52, 649, 2);
		frmSendEmail.getContentPane().add(separator);
		

	}
}
