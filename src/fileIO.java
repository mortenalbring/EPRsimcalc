import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.jfree.data.xy.XYSeries;


public class fileIO {
	/**
	 * Reads in a file and splits it by any string delimiter,
	 * and returns a vector corresponding to the column given.
	 * @param filename the file that is going to be read and split
	 * @param splitColNum the column number that will be returned
	 * @return a vector containing that column
	 */
	public static Vector readAndSplit(String filename,int splitColNum) {

		Vector col = new Vector(1,1);
		try{
			// Open file
			FileInputStream fstream = new FileInputStream(filename);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				String parts[] = strLine.split("\\s+");
				float s = Float.parseFloat(parts[splitColNum]);
				col.addElement(s);
			}
			//Close the input stream
			in.close();			 			  

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return col;
	}
	
	/**
	 * Makes an XYSeries out of two vectors
	 * @param seriesname Name of series
	 * @param a Vector 1
	 * @param b Vector 2
	 * @return
	 */
	public static XYSeries vecToSeries(String seriesname, Vector a, Vector b) {
	
		XYSeries c = new XYSeries(seriesname);
		for(int i=0;i<a.size();i++) {
			c.add((Float)a.get(i),(Float)b.get(i));
		}	
		return c;
	}
}
