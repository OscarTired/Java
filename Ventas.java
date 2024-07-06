package pjVENTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ventas extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-30,69
	 */
	private final JPanel panel = new JPanel();
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTable tProductos;
	//ACA XD
	int f;
	DefaultListModel moR=new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 815, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VENTAS DE BILLETERAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setFont(new Font("Swis721 BlkCn BT", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 811, 58);
		panel_1.add(lblNewLabel);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBorder(new TitledBorder(null, "PRECIO S/.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPrecio.setBounds(403, 69, 105, 36);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JComboBox cboMarca = new JComboBox();
		cboMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//ACAA
				String marca=cboMarca.getSelectedItem().toString();
				
				double precio=0;
				switch(marca) {
				case "Crepier":precio=150;break;
				case "Renzo Costa":precio=100;break;
				case "Caterpillar":precio=80;break;
				case "LaCoste":precio=120;
				}
				txtPrecio.setText(""+precio);
			}
		});
		cboMarca.setBorder(new TitledBorder(null, "BILLETERA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cboMarca.setBounds(22, 69, 191, 36);
		contentPane.add(cboMarca);
		//ACA PARA AGREGAR//
		cboMarca.addItem("Crepier");
		cboMarca.addItem("Renzo Costa");
		cboMarca.addItem("Caterpillar");
		cboMarca.addItem("LaCoste");
		
		txtCantidad = new JTextField();
		txtCantidad.setBorder(new TitledBorder(null, "CANTIDAD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCantidad.setBounds(260, 69, 105, 36);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 116, 737, 185);
		contentPane.add(scrollPane);
		
		tProductos = new JTable();
		tProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tProductos.getColumnModel().getColumn(0).setResizable(false);
		tProductos.getColumnModel().getColumn(1).setResizable(false);
		tProductos.getColumnModel().getColumn(1).setPreferredWidth(179);
		tProductos.getColumnModel().getColumn(2).setResizable(false);
		tProductos.getColumnModel().getColumn(2).setPreferredWidth(106);
		tProductos.getColumnModel().getColumn(3).setResizable(false);
		tProductos.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tProductos);
		
		JList lstEstadisticas = new JList();
		lstEstadisticas.setBorder(new TitledBorder(null, "ESTADISTICAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstEstadisticas.setBounds(32, 364, 737, 224);
		contentPane.add(lstEstadisticas);
		lstEstadisticas.setModel(moR);
		
		JButton btnEstadisticas = new JButton("ESTADISTICAS");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//aca
				int tCrepier=0, tCosta=0, tLacoste=0, tCaterpillar=0;
				double mCrepier=0, mCosta=0, mLacoste=0, mCaterpillar=0;
				for(int i=0;i<f;i++) {
					switch(tProductos.getValueAt(i, 1).toString()) {
					case "Crepier":
						tCrepier+=Integer.parseInt(tProductos.getValueAt(i, 2).toString());
						mCrepier+=Double.parseDouble(tProductos.getValueAt(i, 4).toString());
					break;
					case "Renzo Costa":
						tCosta+=Integer.parseInt(tProductos.getValueAt(i, 2).toString());
						mCosta+=Double.parseDouble(tProductos.getValueAt(i, 4).toString());
						break;
					case "LaCoste":
						tLacoste+=Integer.parseInt(tProductos.getValueAt(i, 2).toString());
						mLacoste+=Double.parseDouble(tProductos.getValueAt(i, 4).toString());
						break;
					case "Caterpillar":
						tCaterpillar+=Integer.parseInt(tProductos.getValueAt(i, 2).toString());
						mCaterpillar+=Double.parseDouble(tProductos.getValueAt(i, 4).toString());										
					}
				}
								
				moR.clear();
				moR.addElement("TOTAL DE CREPIER: "+tCrepier);
				moR.addElement("TOTAL DE RENZO COSTA: "+tCosta);
				moR.addElement("TOTAL DE CATERPILLAR: "+tCaterpillar);
				moR.addElement("TOTAL DE LACOSTE: "+tLacoste);
				moR.addElement("-----------------------------");
				moR.addElement("T MONTO CREPIER: "+mCrepier);
				moR.addElement("T MONTO RENZO COSTA: "+mCosta);
				moR.addElement("T MONTO CATERPILLAR: "+mCaterpillar);
				moR.addElement("T MONTO LACOSTE: "+mLacoste);
			}
		});
		btnEstadisticas.setBounds(32, 312, 737, 41);
		contentPane.add(btnEstadisticas);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//COD
				String marca=cboMarca.getSelectedItem().toString();
				int cantidad = Integer.parseInt(txtCantidad.getText());
				
				//asiganr precio
				double precio=0;
				switch(marca) {
				case "Crepier":precio=150;break;
				case "Renzo Costa":precio=100;break;
				case "Caterpillar":precio=80;break;
				case "LaCoste":precio=120;
				}
				
				double importe = precio*cantidad;
				
				//enviar info (filas y columnas)
				tProductos.setValueAt(f+1,  f, 0);
				tProductos.setValueAt(marca,  f, 1);
				tProductos.setValueAt(cantidad,  f, 2);
				tProductos.setValueAt(precio,  f, 3);
				tProductos.setValueAt(importe,  f, 4);
				f++;
			}
		});
		btnAgregar.setBounds(537, 69, 105, 36);
		contentPane.add(btnAgregar);
	}
}
