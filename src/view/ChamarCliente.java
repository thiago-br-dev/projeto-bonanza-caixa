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

import util.File;
import facade.Fachada;
import models.Caixa;
import models.Chamada;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChamarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Fachada fachada;
	private ArrayList<Caixa> caixasBD;

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
		btnChamarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
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
		
		
		
		// informacoes dos caixas
		
		fachada = Fachada.getInstance();
		caixasBD = new ArrayList<Caixa>();
		
		try {
			caixasBD = (ArrayList<Caixa>) fachada.listarCaixa();
			
			for (Caixa caixa : caixasBD) {
				
				comboBox.addItem(caixa.getCaixa());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//--------------------------------------------------------
		//solicitar chamado
		Chamada chamada = new Chamada();
		chamada.setId(File.ler());
		
		

	}

}