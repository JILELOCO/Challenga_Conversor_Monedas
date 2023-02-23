package ConversorMonedas;

import javax.swing.JOptionPane;

public class ConversorMonedas {
	public static void main(String[] args) {

		// Obtener el tipo de cambio actual
		double euroADolar = 1.22;
		double dolarAPesoMexicano = 20.33;
		double euroAPesoMexicano = 24.78;

		// Pedir al usuario que seleccione la moneda de origen
		String[] opciones = { "Euro", "Dólar", "Peso Mexicano" };
		int monedaOrigen = JOptionPane.showOptionDialog(null, "Seleccione la moneda de origen", "Conversor de Divisas",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		// Pedir al usuario que ingrese la cantidad a convertir
		String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad a convertir:");
		double cantidad = Double.parseDouble(input);

		// Realizar la conversión a la moneda de destino
		double resultado = 0;
		String monedaDestino = "";

		switch (monedaOrigen) {
		case 0: // Euro
			monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de destino",
					"Conversor de Divisas", JOptionPane.DEFAULT_OPTION, null, new String[] { "Dólar", "Peso Mexicano" },
					"Dólar");
			if (monedaDestino.equals("Dólar")) {
				resultado = cantidad * euroADolar;
			} else { // Peso Mexicano
				resultado = cantidad * euroAPesoMexicano;
			}
			break;
		case 1: // Dólar
			monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de destino",
					"Conversor de Divisas", JOptionPane.DEFAULT_OPTION, null, new String[] { "Euro", "Peso Mexicano" },
					"Euro");
			if (monedaDestino.equals("Euro")) {
				resultado = cantidad / euroADolar;
			} else { // Peso Mexicano
				resultado = cantidad * dolarAPesoMexicano;
			}
			break;
		case 2: // Peso Mexicano
			monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de destino",
					"Conversor de Divisas", JOptionPane.DEFAULT_OPTION, null, new String[] { "Euro", "Dólar" }, "Euro");
			if (monedaDestino.equals("Euro")) {
				resultado = cantidad / euroAPesoMexicano;
			} else { // Dólar
				resultado = cantidad / dolarAPesoMexicano;
			}
			break;
		}

		// Mostrar el resultado al usuario
		JOptionPane.showMessageDialog(null, String.format("%.2f %s equivale a %.2f %s", cantidad,
				opciones[monedaOrigen], resultado, monedaDestino));
	}
}
