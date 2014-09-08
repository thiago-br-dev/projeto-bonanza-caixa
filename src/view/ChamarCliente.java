package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
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

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChamarCliente extends JDialog {

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
		setTitle("Bonanza Supermercados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChamarCliente.class.getResource("/view/img/icon_screen.png")));
		setResizable(false);
		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 150, 115);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnChamarCliente = new JButton("Chamar Cliente");
		btnChamarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//--------------------------------------------------------
				//solicitar chamado
				Chamada chamada = new Chamada();
				chamada.setCaixaId(File.ler());
				System.out.println(File.ler());
				try {
					fachada.inserirChamada(chamada);
					
					Thread t = new Thread(){
					    public void run(){
					    	
					    	int i = 0;
					        while (i == 0){
					            if(!btnChamarCliente.isEnabled()){
					                btnChamarCliente.setEnabled(true);
					                i++;
					            } else {
					                btnChamarCliente.setEnabled(false); //pode ser que o usuário apague o texto
					            }
					            
					            try {
					                sleep(3000); //meio segundo
					            } catch (InterruptedException e) {}
					         }
					    }
					};
					t.start();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnChamarCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChamarCliente.setBounds(5, 42, 135, 38);
		contentPane.add(btnChamarCliente);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(6, 5, 133, 30);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		final JLabel lblTrocarNmeroDo = new JLabel("Mudar Caixa");
		lblTrocarNmeroDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrocarNmeroDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				comboBox.setVisible(true);
				lblTrocarNmeroDo.setVisible(false);
				
			}
		});
		lblTrocarNmeroDo.setBounds(5, 13, 135, 14);
		lblTrocarNmeroDo.setForeground(Color.DARK_GRAY);
		lblTrocarNmeroDo.setFont(new Font("Cambria", Font.PLAIN, 15));
		contentPane.add(lblTrocarNmeroDo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ChamarCliente.class.getResource("/view/img/cadastrar_caixa.jpg")));
		label.setBounds(-200, -138, 611, 337);
		contentPane.add(label);
		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String itemSelecionado = (String) comboBox.getSelectedItem();
				System.out.println(itemSelecionado);
				
				// Gravar no TXT
				//----------------------------------------------------------------------
				String numeroCaixa = comboBox.getSelectedItem().toString();
				
				
				Caixa caixa = new Caixa();
				try {
					caixa = (Caixa) fachada.buscarPorCaixa(numeroCaixa);
					
					File.gravar(String.valueOf(caixa.getId()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//---------------------------------------------------------------------
				
				
				
				
			}
		});
		
		
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
		

		
		

	}
}