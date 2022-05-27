package ejercicio2;

public class Localidad {
	private String denom;
	private int total;
	
	/**
	 * Pre: ---
	 * Post: Metodo constructor para el objeto respectivo
	 */
	public Localidad(String denom, int total) {
		super();
		this.denom = denom;
		this.total = total;
	}
	public String getDenom() {
		return denom;
	}
	public void setDenom(String denom) {
		this.denom = denom;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * Pre:
	 * Post: Metodo toString devuelve las variables en un formato para
	 * ser mostrado por pantalla
	 */
	@Override
	public String toString() {
		return denom + " cuenta con " + total + " divorcios";
	}
	
}
