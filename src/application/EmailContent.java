package application;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import event.SentItemsPageBackButtonClickListener;

public class EmailContent extends JFrame {

	private static final long serialVersionUID = 1L;

	public EmailContent(String message) {
		setResizable(false);
		setTitle("Email Sender - content page");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmailContent.class.getResource("/application/mailboxesgroup.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 447);

		JPanel contentPane = new JPanel(); // new JPanel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textAreaEmailContent = new JTextArea(); 
		textAreaEmailContent.setEditable(false);
		textAreaEmailContent.setBounds(21, 61, 650, 300);
		contentPane.add(textAreaEmailContent);

		JLabel lblEmailContent = new JLabel("Email content:");
		lblEmailContent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailContent.setBounds(20, 36, 651, 14);
		contentPane.add(lblEmailContent);

		JLabel lblNewLabel = new JLabel("Addressee:");
		lblNewLabel.setBounds(21, 11, 62, 20);
		contentPane.add(lblNewLabel);

		JTextArea textAreaAddressee = new JTextArea();
		textAreaAddressee.setEnabled(false);
		textAreaAddressee.setBounds(82, 11, 588, 20);
		contentPane.add(textAreaAddressee);

		JButton btnGoBack = new JButton("<- Go Back");
		btnGoBack.addMouseListener(new SentItemsPageBackButtonClickListener(this));
		btnGoBack.setToolTipText("to \"sent Items\" page");
		btnGoBack.setBounds(572, 377, 99, 30);
		contentPane.add(btnGoBack);
	}
}
