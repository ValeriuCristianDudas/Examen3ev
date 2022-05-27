package ejercicio2;

public class Localidad {
	private String denom;
	private int total;
	
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
	
	@Override
	public String toString() {
		return denom + " cuenta con " + total + " divorcios";
	}
}
