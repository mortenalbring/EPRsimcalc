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
		//Initialises variables
		Vector field = new Vector();
		Vector abs = new Vector();
		Vector epr = new Vector();
		
		
		//Read in simulation file
		String filename = "src/sim/Cr7Mn_pJCrCr15.0000JCrMn15.0000.epr";
		Simulation simone = new Simulation(filename);
		simone.field = fileIO.readAndSplit(simone.filename,1);
		abs = fileIO.readAndSplit(simone.filename,2);
		
		//Differentiate absorption to get EPR
		simone.epr = maths.differentiate(abs,simone.field);
		//Normalise to max
		simone.epr = maths.normalise(simone.epr);
		
		//Set field and epr vector in to data XYseries
		simone.data = fileIO.vecToSeries(filename, simone.field, simone.epr);
		
		
		//Read in experiment file
		filename = "src/exp/Cr7Mnp_qband.txt";		
		Experiment Cr7Mnp = new Experiment(filename);
		Cr7Mnp.field = fileIO.readAndSplit(Cr7Mnp.filename,0);
		Cr7Mnp.epr = fileIO.readAndSplit(Cr7Mnp.filename,1);
		Cr7Mnp.data = fileIO.vecToSeries(filename, Cr7Mnp.field, Cr7Mnp.epr);
		//Set field and epr in to data XYseries
		
		System.out.println(Cr7Mnp.epr.size());
		System.out.println(simone.epr.size());
		
		//Make a collection of both experiment and simulation
		XYSeriesCollection setofdata;
		setofdata = new XYSeriesCollection();
		
		//Object m = maths.matchEnds(simone.field,simone.epr,Cr7Mnp.field,Cr7Mnp.epr);
		
		matchSet m = new matchSet(simone.field,simone.epr,Cr7Mnp.field,Cr7Mnp.epr);
		
		matchSet z = maths.matchValues(m);
		
		debug.spitOut(z.v1x, z.v2x);
		debug.writeOut("test.txt", z.v1x, z.v1y);
		          
		//Add simulation and experiment
		setofdata.addSeries(simone.data);
		setofdata.addSeries(Cr7Mnp.data);

		//Plot that shit
		Plot p = new Plot(setofdata);

		
	}
	
}
