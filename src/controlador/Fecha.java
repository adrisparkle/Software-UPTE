package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
	public static String sacarfecha() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ahora = LocalDate.now();
		String fecha = ahora.format(fmt);
		return fecha;
	}
}
