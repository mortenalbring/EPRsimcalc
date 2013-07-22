import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Iterator;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Reads in datafile
		Vector field = new Vector();
		Vector abs = new Vector();
		Vector epr = new Vector();
		
		
		String filename = "src/sim/Cr7Mn_pJCrCr15.0000JCrMn15.0000.epr";
		Simulation simone = new Simulation(filename);
		
		simone.field = fileIO.readAndSplit(simone.filename,1);
		abs = fileIO.readAndSplit(simone.filename,2);
		simone.epr = maths.differentiate(abs,simone.field);
		simone = new Simulation(0.2,0.3,field,epr);
		
		filename = "src/exp/Cr7Mnp_qband.txt";		
		Experiment Cr7Mnp = new Experiment(filename);
		Cr7Mnp.field = fileIO.readAndSplit(Cr7Mnp.filename,0);
		Cr7Mnp.epr = fileIO.readAndSplit(Cr7Mnp.filename,1);
		
		
		XYSeriesCollection setofdata;
		setofdata = new XYSeriesCollection();
		
		XYSeries d = new XYSeries(filename);
		for(int i=0;i<Cr7Mnp.field.size();i++) {
			d.add((Float)Cr7Mnp.field.get(i),(Float)Cr7Mnp.epr.get(i));
		}
		setofdata.addSeries(d);

		Plot p = new Plot(setofdata);
		
		

	}

}
