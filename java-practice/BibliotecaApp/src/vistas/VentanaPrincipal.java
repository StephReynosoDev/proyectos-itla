package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
				
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
	public VentanaPrincipal(){
		
	
		setBackground(new Color(192, 192, 192));
		setType(Type.POPUP);
		setTitle("Sistema Bibliotecario SRS\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JMenu mnNewMenu = new JMenu("Archivo ");
		mnNewMenu.setBounds(4, 4, 101, 26);
		contentPane.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		mnNewMenu_1.setBounds(110, 6, 101, 26);
		contentPane.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Acerca de");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(4, 38, 582, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 40, 66, 26);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(63, 45, 105, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los Datos De el Libro");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(201, 11, 205, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(10, 83, 66, 26);
		panel.add(lblAutor);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 88, 105, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Genero");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 124, 66, 26);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Descripcion");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 161, 80, 26);
		panel.add(lblNewLabel_2_1_1);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Horror");
		rdbtnNewRadioButton.setBounds(64, 128, 57, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Manga");
		rdbtnNewRadioButton_1.setBounds(124, 128, 66, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Accion");
		rdbtnNewRadioButton_1_1.setBounds(192, 128, 66, 23);
		panel.add(rdbtnNewRadioButton_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(100, 164, 132, 22);
		panel.add(textArea);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Genero");
		table.setModel(modelo);
		
		table.setBounds(284, 132, 290, 80);
		panel.add(table);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(64, 128, 128));
		textField_3.setBounds(271, 40, 3, 183);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(313, 10, 86, 20);
		contentPane.add(textField_2);
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] fila = {
					    textField_2.getText(),
					    textField.getText(),
					    textField_1.getText(),
					    ""
					};
					modelo.addRow(fila);
			}
		});
		btnNewButton.setBounds(284, 55, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(370, 55, 89, 23);
		panel.add(btnEditar);
		int fila = table.getSelectedRow();
		if (fila >= 0) {
		    modelo.setValueAt(textField_2.getText(), fila, 0);
		    modelo.setValueAt(textField.getText(), fila, 1);
		    modelo.setValueAt(textField_1.getText(), fila, 2);
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			
				int fila = table.getSelectedRow();
				modelo.removeRow(fila);
			}
			
	
		});
		
		
		
		btnEliminar.setBounds(458, 55, 89, 23);
		panel.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscar = textField_4.getText().toLowerCase();
				for (int i = 0; i < modelo.getRowCount(); i++) {
				    String titulo = modelo.getValueAt(i, 1).toString().toLowerCase();
				    if (titulo.contains(buscar)) {
				        table.setRowSelectionInterval(i, i);
				        break;
				    }
				}
			}
		});
		btnBuscar.setBounds(485, 98, 89, 23);
		panel.add(btnBuscar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(284, 101, 205, 20);
		panel.add(textField_4);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(291, 4, 28, 26);
		contentPane.add(lblId);
		
	
	}
}
