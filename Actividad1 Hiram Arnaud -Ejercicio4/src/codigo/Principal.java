package codigo;

import java.io.File;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = new String("C:/Users/carlo/Documents/Actividad1-Ejercicio4/src/codigo/Lexer.flex");
		generarLexer(ruta);
	}

	public static void generarLexer(String ruta) {
		File archivo = new File(ruta);
		JFlex.Main.generate(archivo);
	}
}
