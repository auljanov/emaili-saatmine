package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import event.SentItemsBackButtonClickListener;
import event.SentItemsWindowListener;

public class SentItems extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;

	/*
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public SentItems() {
		setResizable(false);
		setTitle("Email Sender - sent items");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SentItems.class.getResource("/application/mailboxesgroup.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnGoBack = new JButton("<- Go Back");
		btnGoBack.addMouseListener(new SentItemsBackButtonClickListener(this));

		btnGoBack.setToolTipText("To main page");

		JLabel lblAllSentItems = new JLabel("All Sent Items:");
		lblAllSentItems.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(
										lblAllSentItems, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(573).addComponent(btnGoBack,
								GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(10, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblAllSentItems).addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));

		table = new JTable();
		table.setForeground(Color.BLUE);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(null, Database.COLUMNS) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setPreferredWidth(242);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(450);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

		addWindowListener(new SentItemsWindowListener());

		setVisible(true);
	}

	public void populateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		List<DatabaseRecord> records = Database.getRecords();

    	
    	for (DatabaseRecord record : records) {
    		List<String> row = new ArrayList<String>();
    		
    		row.add(Database.DATE_FORMAT.format(record.getDate()));
    		row.add(record.getEmail());
    		row.add(record.getSubject());
    		row.add(record.getMessage());
    		
    		model.addRow(row.toArray());
    	}

        
	}
	
}
