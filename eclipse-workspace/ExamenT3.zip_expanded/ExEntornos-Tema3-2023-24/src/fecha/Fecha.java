package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int dia; //d�a
	private int mes; //mes
	private int anno; //a�o

	
	public Fecha() {

	}

	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anno = anio;
	}

	
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		
		anioCorrecto = anno > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0;
	}

	// M�todo diaSiguiente
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anno++;
			}
		}
	}

	// M�todo toString
	public String toString() {
		String fecha = "";
		if (dia < DIEZ && mes < DIEZ) {
			fecha = "0" + dia + "-0" + mes + "-" + anno;
		} else if (dia < DIEZ && mes >= DIEZ) {
			fecha = "0" + dia + "-" + mes + "-" + anno;
		} else if (dia >= DIEZ && mes < DIEZ) {
			fecha = dia + "-0" + mes + "-" + anno;
		} else {
			fecha = dia + "-" + mes + "-" + anno;
		}
		return fecha;
	}

}
