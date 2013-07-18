import java.util.Vector;
public class Simulation {
	public double JCrCr = 0;
	public double JCrM = 0;
	public Vector field;
	public Vector epr;
	public String filename;
	
	
	public Simulation(String f) {
		filename = f;
	}
	
	public Simulation(double a, double b, Vector f, Vector e) {
		JCrCr = a;
		JCrM = b;
		field = f;
		epr = e;
	}
}
