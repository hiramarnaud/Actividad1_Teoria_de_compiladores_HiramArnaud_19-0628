package codigo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("Actividad 1 - Ejercicio 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEntrada = new JTextField();
		txtEntrada.setFont(new Font("Tahoma", Font.PLAIN, 34));
		txtEntrada.setBounds(10, 11, 380, 47);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JTextArea txtSalida = new JTextArea();
		txtSalida.setBounds(10, 69, 585, 303);
		contentPane.add(txtSalida);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Escribiendo en un archivo, lo que se ponga en el text field
				File archivo = new File("archivo.txt");
				PrintWriter escribir;
				try {
					escribir = new PrintWriter(archivo);
					escribir.print(txtEntrada.getText());
					escribir.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Analizando con JFlex haciendo uso del archivo creado
				try {
					// Leyendo el archivo
					Reader lector = new BufferedReader(new FileReader("archivo.txt"));
					// Creando el analizador lógico en base al archivo
					Lexer lexer = new Lexer(lector);
					// String para el resultado final
					String resultado = "";
					
					while(true) {
						// Leyendo los tokens del archivo
						Tokens tokens = lexer.yylex();
						
						// Cuando se termina el contenido del archivo
						if(tokens == null) {
							resultado += "FIN";
							txtSalida.setText(resultado);
						}
						
						// Decisión de cada token
						switch(tokens) {
							case Identificador:
								resultado += lexer.lexeme + ": Es un " + tokens + "\n";
								break;
							default:
								resultado += "Simbolo no definido\n";
								break;
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnalizar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnAnalizar.setBounds(400, 11, 195, 47);
		contentPane.add(btnAnalizar);
		
	}

}
