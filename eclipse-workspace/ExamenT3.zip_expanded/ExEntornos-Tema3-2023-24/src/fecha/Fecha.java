package fecha;

/**
 * Clase {@code fecha} que va a contener todo lo relacionado 
 * fechas teniendo atributos como el dia, mes y año
 * 
 * @version 1.0
 * @author jm.maya
 */
public class Fecha {
<<<<<<< HEAD
=======
	public static final int DIEZ = 10;
	private int dia; //d�a
	private int mes; //mes
	private int anno; //a�o

>>>>>>> PMD-Refactor
	
	/**
	 * Atributos privado d que va a hacer las veces de dia.
	 */
	private int d; //d�a
	
	/**
	 * Atributos privado m que va a hacer las veces de mes.
	 */
	private int m; //mes
	
	/**
	 * Atributos privado a que va a hacer las veces de año.
	 */
	private int a; //a�o

	/**
	 * Constructor de la clase fecha.
	 */
	public Fecha() {

	}

	/**
	 * Constructor de la clase fecha para crear un objeto fecha
	 * 
	 * @param dia dia que se indica para almacenarlo en el atributo.
	 * @param mes mes que se indica para almacenarlo en el atributo.
	 * @param anio año que se indica para almacenarlo en el atributo.
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anno = anio;
	}

	
	/**
	 * Metodo que comprueba que la fecha sea correcta
	 * controlando los limites tanto de dias como de mes
	 * y que el año sea mayor al año 0
	 * 
	 * @return boolean (true o false) estado de que las tres fechas sean correcta o no. 
	 */
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

<<<<<<< HEAD
	/**
	 * Metodo privado para comprobar si el año es bisiesto
	 * solo se llama por atributos de la propia clase.
	 * 
	 * @return boolean (true si es bisiesto) (false si no lo es).
	 */
=======
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
>>>>>>> PMD-Refactor
	private boolean esBisiesto() {
		return anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0;
	}

<<<<<<< HEAD
	/**
	 * Metodo para pasar al dia siguiente incrementando el dia
	 * y comprobando si hay que incrementar el mes y año
	 * llamando a su vez al metodo {@code fechaCorrecta}
	 */
	public void diaSiguiente() {
		d++;
=======
	// M�todo diaSiguiente
	public void nextDay() {
		dia++;
>>>>>>> PMD-Refactor
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anno++;
			}
		}
	}

<<<<<<< HEAD
	/**
	 * Método que devuelve un string con la
	 * informacion de los atributos formando la fecha
	 * actual registrada.
	 * 
	 * @return string con la fecha registrada.
	 */
=======
	// M�todo toString
>>>>>>> PMD-Refactor
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
