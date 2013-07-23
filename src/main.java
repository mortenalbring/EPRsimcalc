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
		
		System.out.println(simone.field.size());
		System.out.println(abs.size());
		
		simone.epr = maths.differentiate(abs,simone.field);
		
		simone.epr = maths.normalise(simone.epr);
		
		System.out.println(simone.epr.size());
		
		simone.data = fileIO.vecToSeries(filename, simone.field, simone.epr);
		
		
		
		filename = "src/exp/Cr7Mnp_qband.txt";		
		Experiment Cr7Mnp = new Experiment(filename);
		Cr7Mnp.field = fileIO.readAndSplit(Cr7Mnp.filename,0);
		Cr7Mnp.epr = fileIO.readAndSplit(Cr7Mnp.filename,1);
		Cr7Mnp.data = fileIO.vecToSeries(filename, Cr7Mnp.field, Cr7Mnp.epr);
		
		
		XYSeriesCollection setofdata;
		setofdata = new XYSeriesCollection();
		
		setofdata.addSeries(simone.data);
		setofdata.addSeries(Cr7Mnp.data);

		Plot p = new Plot(setofdata);
		
		

	}

}
