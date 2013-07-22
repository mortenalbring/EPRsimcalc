import java.util.Vector;
import org.jfree.data.xy.XYSeries;


public class Experiment {
	public Vector field;
	public Vector epr;
	public String filename;
	public XYSeries data;
	
	public Experiment(String f) {
		filename = f;
	}
	
	
}
