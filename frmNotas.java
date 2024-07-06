package pjFormularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmNotas extends JFrame {

	private JPanel contentPane;
	private JTextField txtEstudiante;
	private JTextField txtBlanco;
	private JTextField txtCorrectas;
	private JTextField txtIncorrectas;
	private JList lstR;
	private JButton btnLimpiar;
	private JButton btnSalir;

	DefaultListModel moR=new DefaultListModel(); //ACAAAAAAAAAAAAAAAAAA
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNotas frame = new frmNotas();
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
	public frmNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(0, 0, 542, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTROL Y GESTION DE NOTAS\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 0, 542, 48);
		panel.add(lblNewLabel);
		
		txtEstudiante = new JTextField();
		txtEstudiante.setBorder(new TitledBorder(null, "NOMBRE DEL ESTUDIANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtEstudiante.setToolTipText("");
		txtEstudiante.setBounds(10, 59, 174, 48);
		contentPane.add(txtEstudiante);
		txtEstudiante.setColumns(10);
		
		txtBlanco = new JTextField();
		txtBlanco.setBorder(new TitledBorder(null, "CANTIDAD EN BLANCO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtBlanco.setBounds(30, 181, 174, 48);
		contentPane.add(txtBlanco);
		txtBlanco.setColumns(10);
		
		txtCorrectas = new JTextField();
		txtCorrectas.setBorder(new TitledBorder(null, "CANTIDAD DE CORRECTAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCorrectas.setBounds(30, 118, 174, 48);
		contentPane.add(txtCorrectas);
		txtCorrectas.setColumns(10);
		
		txtIncorrectas = new JTextField();
		txtIncorrectas.setBorder(new TitledBorder(null, "CANTIDAD DE INCORRECTAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtIncorrectas.setBounds(275, 118, 186, 48);
		contentPane.add(txtIncorrectas);
		txtIncorrectas.setColumns(10);
		
		JButton btnProcesar = new JButton("PROCESAR\r\n");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener nombre del estudiante
				String estudiante =txtEstudiante.getText();
				//Obtener cuantas respuestas correctas
				int correctas = Integer.parseInt(txtCorrectas.getText());
				//Obtener cuantas respuestas incorrectas
				int incorrectas = Integer.parseInt(txtIncorrectas.getText());
				//Obtener cuantas respuestas en blanco
				int blanco = Integer.parseInt(txtBlanco.getText());
				//Calcular nota o puntaje
				int puntaje = correctas*4 + incorrectas*-1 + blanco*0;
				//Imprimir
				moR.clear();
				moR.addElement("Estudiante: "+estudiante);
				moR.addElement("Correctas: "+correctas);
				moR.addElement("Incorrectas: "+incorrectas);
				moR.addElement("Blanco: "+blanco);
				moR.addElement("-----------------------------------");
				moR.addElement("Puntaje: "+puntaje);
			}
		});
		btnProcesar.setBounds(275, 181, 186, 48);
		contentPane.add(btnProcesar);
		
		lstR = new JList();
		lstR.setBounds(30, 251, 431, 167);
		contentPane.add(lstR);
		lstR.setModel(moR);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEstudiante.setText("");
				txtCorrectas.setText("");
				txtIncorrectas.setText("");
				txtBlanco.setText("");
				moR.clear();
			}
		});
		btnLimpiar.setBounds(30, 429, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(145, 429, 89, 23);
		contentPane.add(btnSalir);
	}

}
