import java.util.Vector;
import org.jfree.data.xy.XYSeries;

/**
 * Simulation contains parameters necessary for simulation
 */

public class Simulation {
	public double JCrCr = 0;
	public double JCrM = 0;
	public Vector field;
	public Vector epr;
	public XYSeries data;
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
