package controlador;

public class Empleados {
	String user,pass,nombre,apepat,apemat,ci,nacimiento,dir,cel,tipo_user;

	public Empleados(String user, String pass, String nombre, String apepat, String apemat, String ci,
			String nacimiento, String dir, String cel, String tipo_user) {
		super();
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
		this.ci = ci;
		this.nacimiento = nacimiento;
		this.dir = dir;
		this.cel = cel;
		this.tipo_user = tipo_user;
	}
	
	public Empleados(String user, String pass, String nombre, String tipo_user) {
		super();
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.tipo_user = tipo_user;
	}



	public Empleados(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	
}
