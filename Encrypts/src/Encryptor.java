import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Encryptor extends JFrame {

	ENCRYPTS ENC = ENCRYPTS.getINSTANCE();
	private JPanel contentPane;
	private JTextField KeyField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encryptor frame = new Encryptor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Encryptor() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AR\\Desktop\\CNC1_Nod_Emblem.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JButton decrypButton = new JButton("לפענח");
		decrypButton.setToolTipText("פענוח הטקסט המוצפן ");
		
		
		JButton encrypButton = new JButton("להצפין");
		encrypButton.setToolTipText("הצפנת הטקסט שלך ");
		
		JTextArea MyTextArea = new JTextArea();
		MyTextArea.setToolTipText("הכנס את הטקסט שלך כאן");
		MyTextArea.setBackground(Color.WHITE);
		
		KeyField = new JTextField();
		KeyField.setBackground(new Color(255, 255, 153));
		KeyField.setToolTipText("המפתח שלך - שמור עליו במקום בטוח");
		KeyField.setColumns(10);
		
		JButton KeyButton = new JButton("טען מפתח");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(MyTextArea, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(KeyField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(KeyButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
						.addComponent(decrypButton, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
						.addComponent(encrypButton, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(MyTextArea, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(encrypButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(decrypButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(KeyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(KeyButton))))
					.addContainerGap())
		);
		encrypButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ENC.setStatement(MyTextArea.getText());
				ENC.encryp();
				MyTextArea.setText(ENC.getEncrypted());
			}
		});
		
		decrypButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        ENC.setStatement(MyTextArea.getText());
				ENC.setEncrypted(MyTextArea.getText());
				MyTextArea.setText(ENC.getDencrypted());
			}
		});
		
		KeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(KeyButton.getText()=="טען מפתח")
				{
					ENC.setKeyWord(KeyField.getText());
					ENC.setStatement(MyTextArea.getText());
					KeyButton.setText("זרוק מפתח");
					KeyField.setEnabled(false);
				}
				else
				{
					ENC.setKeyWord("");
					ENC.setStatement(MyTextArea.getText());
					KeyButton.setText("טען מפתח");
					KeyField.setEnabled(true);
					KeyField.setText("");
				}
			
				
			}
		});
		
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
