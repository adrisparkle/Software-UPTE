package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Querry;

public class EstadisticoGenero {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadisticoGenero window = new EstadisticoGenero();
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
	public EstadisticoGenero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JComboBox cbGestion = new JComboBox();
		cbGestion.setBounds(176, 32, 224, 24);
		frame.getContentPane().add(cbGestion);
		try{
			Querry q = new Querry();
			ResultSet rs = q.Gestiones();
			while(rs.next()) {
				cbGestion.addItem(rs.getString("gestion"));
			}
		}catch(Exception e) {
		}
		
		JComboBox cbCurso = new JComboBox();
		cbCurso.setBounds(176, 75, 224, 24);
		frame.getContentPane().add(cbCurso);
		try{
			cbCurso.removeAllItems();
			Querry q = new Querry();
			ResultSet rs = q.Cursos();
			while(rs.next()) {
				cbCurso.addItem(rs.getString("nombres"));
			}
		}catch(Exception e) {
		}
		
		JComboBox cbParalelo = new JComboBox();
		cbParalelo.setBounds(176, 116, 224, 24);
		frame.getContentPane().add(cbParalelo);
		cbCurso.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        String curso = (String) cbCurso.getSelectedItem();
		        cbParalelo.removeAllItems();
		        try{
		        	Querry q = new Querry();
			        ResultSet rs = q.Paralelos(curso);
			        while(rs.next()) {
			        	cbParalelo.addItem(rs.getString("paralelo"));
			        }
		        }catch(Exception ev) {
		        }
		    }
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(302, 217, 98, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblGestion = new JLabel("GESTION:");
		lblGestion.setBounds(80, 32, 55, 15);
		frame.getContentPane().add(lblGestion);
		
		JLabel lblCurso = new JLabel("CURSO:");
		lblCurso.setBounds(80, 75, 55, 15);
		frame.getContentPane().add(lblCurso);
		
		JLabel lblParalelo = new JLabel("PARALELO: ");
		lblParalelo.setBounds(80, 121, 78, 15);
		frame.getContentPane().add(lblParalelo);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes nuevo1 = new Reportes();
				nuevo1.main(null);
				frame.dispose();
			}
		});
		btnAtras.setBounds(26, 217, 98, 25);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblGenero = new JLabel("GENERO:");
		lblGenero.setBounds(80, 168, 55, 15);
		frame.getContentPane().add(lblGenero);
		
		JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(176, 163, 224, 24);
		frame.getContentPane().add(cbGenero);
		cbGenero.addItem("Masculino");
		cbGenero.addItem("Femenino");
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gestion = (String) cbGestion.getSelectedItem();
				String curso = (String) cbCurso.getSelectedItem();
				String paralelo = (String) cbParalelo.getSelectedItem();
				String genero = (String) cbGenero.getSelectedItem();
				String num = "";
				try {
					ResultSet rs = null;
					Querry qqq = new Querry();
					rs = qqq.EstGenero(curso, gestion, paralelo, genero);
					if( rs!= null){
						 for(;rs.next();){
							 num=rs.getString("Total");
				               
						 }
						 JOptionPane.showMessageDialog(null, "Estadistico genero: "+num);
			        	
			        }
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "error: "+e1);
				}
			}
		});
	}

}
