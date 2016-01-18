package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import event.MainPageSendButtonListener;
import event.MainPageViewSentItemsListner;

public class MainPage {

	private JFrame frmSendEmail;
	private JTextField textFieldAddressee;
	private JTextField textFieldSubject;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	private void initialize() { // Initialize the contents of the frame.
		frmSendEmail = new JFrame();
		frmSendEmail.setResizable(false);
		frmSendEmail.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/application/mailboxesgroup.png")));
		frmSendEmail.setBounds(100, 100, 450, 300);
		frmSendEmail.setTitle("Email Sender - main page");
		frmSendEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSendEmail.setSize(700, 447);
		frmSendEmail.getContentPane().setLayout(null);

		JLabel lblAuthorLabel = new JLabel("Emails from Mr. Aleksei Uljanov"); // Create author name
		lblAuthorLabel.setForeground(new Color(51, 102, 153));
		lblAuthorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthorLabel.setBounds(25, 13, 550, 28);
		frmSendEmail.getContentPane().add(lblAuthorLabel);
		
		JSeparator separator = new JSeparator(); // Create simple line
		separator.setBounds(24, 52, 649, 2);
		frmSendEmail.getContentPane().add(separator);

		textFieldAddressee = new JTextField(20); // Create new text field for email address
		textFieldAddressee.setPreferredSize(new Dimension(4, 20));
		textFieldAddressee.setText("@");
		textFieldAddressee.setBounds(168, 69, 505, 20);
		frmSendEmail.getContentPane().add(textFieldAddressee);
		textFieldAddressee.setColumns(10);
		
		JLabel lblTo = new JLabel("To..."); // Create comment for "textFieldAdressee" frame
		lblTo.setBounds(122, 71, 46, 17);
		frmSendEmail.getContentPane().add(lblTo);

		textFieldSubject = new JTextField(20); // Create new text field for "subject" of email
		textFieldSubject.setBounds(168, 97, 505, 20);
		textFieldSubject.setColumns(10);
		frmSendEmail.getContentPane().add(textFieldSubject);
		
		JLabel lblSubject = new JLabel("Subject"); // Create comment for "textFieldSubject" frame
		lblSubject.setBounds(122, 97, 46, 20);
		frmSendEmail.getContentPane().add(lblSubject);

		JTextArea JTextFieldMessege = new JTextArea(); // Create text area for message
		JTextFieldMessege.setLineWrap(true);
		JTextFieldMessege.setColumns(10);
		JTextFieldMessege.setText("Your text here...");
		JTextFieldMessege.setBounds(22, 152, 650, 242);
		frmSendEmail.getContentPane().add(JTextFieldMessege);

		JButton btnSendMail = new JButton("Send"); //Create "Send" button
		MainPageSendButtonListener sendBtnListener = new MainPageSendButtonListener(textFieldAddressee, textFieldSubject, JTextFieldMessege);
		sendBtnListener.setSentLabel();
		btnSendMail.addMouseListener(sendBtnListener);
		btnSendMail.setBounds(23, 69, 89, 48);
		frmSendEmail.getContentPane().add(btnSendMail);

		JButton btnSentItems = new JButton("View sent items"); //Create "View sent items" button
		btnSentItems.addMouseListener(new MainPageViewSentItemsListner());
		btnSentItems.setBounds(548, 13, 125, 30);
		frmSendEmail.getContentPane().add(btnSentItems);
		
		JLabel lblShowWarning = new JLabel("");
		lblShowWarning.setBounds(22, 128, 651, 20);
		frmSendEmail.getContentPane().add(lblShowWarning);

		}
	}

