package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.ModeloDatos;
import Clases.Procesos;
import Entidades.Estudiante;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPromedio extends JFrame implements ActionListener{
	private static Procesos misProcesos = null;
	private JTextField txtMateria;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JLabel lblResultado;
	
	private JButton btnConsultaIndividual;
	private JButton btnLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private ModeloDatos miModeloDatos;

	public VentanaPromedio() {
		misProcesos= new Procesos();
		miModeloDatos=new ModeloDatos();
		setTitle("Promedio estudiantes");
		setSize(659,572);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		
		btnConsultaIndividual = new JButton("Consultar");
		btnConsultaIndividual.setBounds(375, 275, 112, 21);
		btnConsultaIndividual.addActionListener(this);

		btnLista = new JButton("Lista");
		btnLista.setBounds(498, 275, 112, 21);
		btnLista.addActionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 319, 586, 206);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("SISTEMA CONTROL DE NOTAS");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 26, 606, 59);
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMateria.setBounds(348, 117, 72, 22);
		txtMateria = new JTextField();
		txtMateria.setBounds(430, 120, 180, 19);
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 120, 201, 19);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(24, 117, 72, 22);
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(106, 162, 96, 19);
		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota1.setBounds(24, 159, 72, 22);
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(309, 165, 96, 19);

		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota2.setBounds(227, 162, 72, 22);
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(513, 165, 96, 19);
		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNota3.setBounds(431, 162, 72, 22);
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultado.setBounds(24, 215, 586, 22);
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(106, 276, 201, 21);
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(409, 276, 201, 21);

		add(lblTitulo);
		add(lblMateria);
		add(txtMateria);
		add(btnLimpiar);
		add(btnCalcular);
		add(lblResultado);
		add(lblNota3);
		add(txtNota3);
		add(lblNota2);
		add(txtNota2);
		add(lblNota1);
		add(txtNota1);
		add(lblNombre);
		add(txtNombre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if (e.getSource()==btnCalcular) {
	System.out.println("Calcular");
	}else if(e.getSource()==btnLimpiar) {
	System.out.println("Limpiar");
	}
	if (e.getSource()==btnCalcular) {

		System.out.println("Calcular");
		calcular(); //llamamos al metodo calcular
		
	}else if(e.getSource()==btnLimpiar) {
			System.out.println("Limpiar");
			limpiar();
		
	}
	Procesos misProcesos;
	}
	
	private void calcular() {

		
		
		Estudiante miEstudiante = new Estudiante();
		miEstudiante.setNombre(txtNombre.getText());
		miEstudiante.setMateria(txtMateria.getText());
		miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
		miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
		miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));

		double promedio = misProcesos.CalcularPromedio(miEstudiante);
		miEstudiante.setPromedio(promedio);

		if (promedio != -1) {
		    lblResultado.setText("Resultado: " + "Hola " + miEstudiante.getNombre() + ", su promedio es: " + promedio);
		    lblResultado.setForeground(Color.blue);
		} else {
		    lblResultado.setText("Revise los datos, porq no pueden ser negativos ni mayores a 5");
		    lblResultado.setForeground(Color.red);
		}

		System.out.println("El promedio es: " + promedio);
		
		
	}
	private void limpiar() {
		txtNombre.setText("");
		txtMateria.setText("");
		txtNota1.setText("0");
		txtNota2.setText("0");
		txtNota3.setText("0");
		lblResultado.setText("Resultado: ");
		lblResultado.setForeground(Color.black);
		}
	
}
