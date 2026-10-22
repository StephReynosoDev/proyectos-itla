import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class Ventana extends JFrame {

	public Ventana() {
		JFrame ventana = new JFrame("Imitador");
		ventana.setSize(400, 375);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
	
		
		
		
		
		JPanel panel = new JPanel();
		JTextField texto = new JTextField(10);
		JTextField texto1 = new JTextField(10);
		ventana.add(panel);
		panel.add(texto);
		panel.add(texto1);
		 panel.add(new JLabel(""));
		ventana.setVisible(true);
	}
	
	
	
}
