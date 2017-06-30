package vista;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controlador.Empleados;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private Empleados e;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Empleados e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		
		/*//
		((JPanel)getContentPane()).setOpaque(false); 
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/logopeque.jpg")); 
		label.setIcon(uno); 
		getLayeredPane().add(label,JLayeredPane.FRAME_CONTENT_LAYER); 
		label.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		///*/
		
		//URL url = Menu.class.getResource("/logo_ucb_med.gif");
		//ImageIcon icon = new ImageIcon(url);
		//label.setIcon(icon);
		//label.setBounds(287, 117, 255, 293);
		frame.dispose();
		frame.getContentPane().add(label);
		
		JButton Btinsc = new JButton("Registrar");
		Btinsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha nueva = new Ficha();
				frame.dispose();
				nueva.main(null);
			}
		});
		Btinsc.setBounds(345, 86, 134, 48);
		frame.getContentPane().add(Btinsc);
		
		JButton Btreport = new JButton("Reportes ");
		Btreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nueva = new Reportes();
				frame.dispose();
				nueva.main(null);
			}
		});
		Btreport.setBounds(135, 146, 134, 48);		
		frame.getContentPane().add(Btreport);
		
		
		JButton btsalir = new JButton("Cerrar Sesion");
		btsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home nuevo = new Home();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btsalir.setBounds(638, 429, 134, 42);
		frame.getContentPane().add(btsalir);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrar nuevo = new Administrar();
				frame.dispose();
				nuevo.main(null);
			}
		});
		btnAdministrar.setBounds(69, 233, 134, 45);
		frame.getContentPane().add(btnAdministrar);
		
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscribir nuevo = new Inscribir();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnInscribir.setBounds(560, 146, 134, 48);
		frame.getContentPane().add(btnInscribir);
		
		JButton btnNewButton = new JButton("Anular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anular nuevo = new Anular();
				nuevo.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(613, 231, 134, 48);
		frame.getContentPane().add(btnNewButton);
	}

}
