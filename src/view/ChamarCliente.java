package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChamarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					
					ChamarCliente frame = new ChamarCliente();
					frame.setVisible(true);
					
				}
				
				catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}

	public ChamarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChamarCliente.class.getResource("/view/img/icon_screen.png")));
		setResizable(false);
		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 161, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChamarCliente = new JButton("Chamar Cliente");
		btnChamarCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChamarCliente.setBounds(10, 52, 135, 50);
		contentPane.add(btnChamarCliente);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 11, 133, 30);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		JLabel lblTrocarNmeroDo = new JLabel("Trocar N\u00FAmero do Caixa");
		lblTrocarNmeroDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				comboBox.setVisible(true);
				lblTrocarNmeroDo.setVisible(false);
				
			}
		});
		lblTrocarNmeroDo.setBounds(10, 19, 135, 14);
		contentPane.add(lblTrocarNmeroDo);
		
		
		
	}

}