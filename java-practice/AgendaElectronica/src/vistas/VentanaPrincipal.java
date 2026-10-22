package vistas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import conexion.Conexion;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtTitulo, txtDescripcion, txtFecha, txtHora, txtLugar;
    private JTable tabla;
    private DefaultTableModel modelo;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaPrincipal frame = new VentanaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaPrincipal() {
        setTitle("Agenda Electronica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null);

        // MENU
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnAcciones = new JMenu("Acciones");
        menuBar.add(mnAcciones);

        JMenuItem mGuardar = new JMenuItem("Guardar");
        JMenuItem mActualizar = new JMenuItem("Actualizar");
        JMenuItem mBorrar = new JMenuItem("Borrar");
        JMenuItem mBuscar = new JMenuItem("Buscar");
        mnAcciones.add(mGuardar);
        mnAcciones.add(mActualizar);
        mnAcciones.add(mBorrar);
        mnAcciones.add(mBuscar);

        JMenu mnInfo = new JMenu("Informacion");
        menuBar.add(mnInfo);
        JMenuItem mPerfil = new JMenuItem("Perfil del Estudiante");
        mnInfo.add(mPerfil);

        // PANEL
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(240, 240, 245));
        setContentPane(contentPane);

        // CAMPOS
        JLabel lblTitulo = new JLabel("Titulo:");
        lblTitulo.setBounds(10, 15, 80, 20);
        contentPane.add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(90, 12, 180, 26);
        contentPane.add(txtTitulo);

        JLabel lblDesc = new JLabel("Descripcion:");
        lblDesc.setBounds(10, 50, 90, 20);
        contentPane.add(lblDesc);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(90, 47, 180, 26);
        contentPane.add(txtDescripcion);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 85, 80, 20);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(90, 82, 100, 26);
        contentPane.add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(200, 85, 60, 20);
        contentPane.add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(240, 82, 80, 26);
        contentPane.add(txtHora);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setBounds(10, 120, 80, 20);
        contentPane.add(lblLugar);

        txtLugar = new JTextField();
        txtLugar.setBounds(90, 117, 180, 26);
        contentPane.add(txtLugar);

        // BOTONES
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 160, 100, 30);
        btnGuardar.setBackground(new Color(40, 120, 200));
        btnGuardar.setForeground(Color.WHITE);
        contentPane.add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(115, 160, 100, 30);
        btnBuscar.setBackground(new Color(80, 160, 80));
        btnBuscar.setForeground(Color.WHITE);
        contentPane.add(btnBuscar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(220, 160, 110, 30);
        btnActualizar.setBackground(new Color(200, 140, 30));
        btnActualizar.setForeground(Color.WHITE);
        contentPane.add(btnActualizar);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(335, 160, 100, 30);
        btnBorrar.setBackground(new Color(200, 50, 50));
        btnBorrar.setForeground(Color.WHITE);
        contentPane.add(btnBorrar);

        // TABLA
        tabla = new JTable();
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Titulo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Lugar");
        tabla.setModel(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 205, 760, 250);
        contentPane.add(scroll);

        cargarDatos();

        btnGuardar.addActionListener(e -> guardarEvento());
        mGuardar.addActionListener(e -> guardarEvento());

        btnBuscar.addActionListener(e -> buscarEvento());
        mBuscar.addActionListener(e -> buscarEvento());

        btnActualizar.addActionListener(e -> actualizarEvento());
        mActualizar.addActionListener(e -> actualizarEvento());

        btnBorrar.addActionListener(e -> borrarEvento());
        mBorrar.addActionListener(e -> borrarEvento());

        mPerfil.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                "Nombre: Tu Nombre\n" +
                "Matricula: Tu Matricula\n" +
                "Carrera: Tu Carrera\n" +
                "Institucion: ITLA",
                "Perfil del Estudiante",
                JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void guardarEvento() {
        try {
            Connection con = Conexion.getConexion();
            String sql = "INSERT INTO eventos (titulo, descripcion, fecha, hora, lugar) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtDescripcion.getText());
            ps.setString(3, txtFecha.getText());
            ps.setString(4, txtHora.getText());
            ps.setString(5, txtLugar.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Evento guardado correctamente");
            limpiarCampos();
            cargarDatos();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void buscarEvento() {
        modelo.setRowCount(0);
        try {
            Connection con = Conexion.getConexion();
            String sql = "SELECT * FROM eventos WHERE titulo LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtTitulo.getText() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("ideventos"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    rs.getString("lugar")
                });
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void actualizarEvento() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un evento de la tabla");
            return;
        }
        int id = (int) modelo.getValueAt(fila, 0);
        try {
            Connection con = Conexion.getConexion();
            String sql = "UPDATE eventos SET titulo=?, descripcion=?, fecha=?, hora=?, lugar=? WHERE ideventos=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtDescripcion.getText());
            ps.setString(3, txtFecha.getText());
            ps.setString(4, txtHora.getText());
            ps.setString(5, txtLugar.getText());
            ps.setInt(6, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Evento actualizado");
            limpiarCampos();
            cargarDatos();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void borrarEvento() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un evento de la tabla");
            return;
        }
        int id = (int) modelo.getValueAt(fila, 0);
        int conf = JOptionPane.showConfirmDialog(null, "Seguro que deseas borrar este evento?");
        if (conf == 0) {
            try {
                Connection con = Conexion.getConexion();
                String sql = "DELETE FROM eventos WHERE ideventos=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Evento borrado");
                cargarDatos();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        try {
            Connection con = Conexion.getConexion();
            String sql = "SELECT * FROM eventos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("ideventos"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    rs.getString("lugar")
                });
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error cargando datos: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtLugar.setText("");
    }
}