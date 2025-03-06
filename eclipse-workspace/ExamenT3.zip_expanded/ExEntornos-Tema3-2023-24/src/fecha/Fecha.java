package fecha;

/**
 * Clase {@code fecha} que va a contener todo lo relacionado 
 * fechas teniendo atributos como el dia, mes y año
 * 
 * @version 1.0
 * @author jm.maya
 */
public class Fecha {
	
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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Metodo que comprueba que la fecha sea correcta
	 * controlando los limites tanto de dias como de mes
	 * y que el año sea mayor al año 0
	 * 
	 * @return boolean (true o false) estado de que las tres fechas sean correcta o no. 
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Metodo privado para comprobar si el año es bisiesto
	 * solo se llama por atributos de la propia clase.
	 * 
	 * @return boolean (true si es bisiesto) (false si no lo es).
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Metodo para pasar al dia siguiente incrementando el dia
	 * y comprobando si hay que incrementar el mes y año
	 * llamando a su vez al metodo {@code fechaCorrecta}
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método que devuelve un string con la
	 * informacion de los atributos formando la fecha
	 * actual registrada.
	 * 
	 * @return string con la fecha registrada.
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
