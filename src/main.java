import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Iterator;



public class main {
	public static Vector readAndSplit(String filename,int splitColNum) {
		/**
		 * Reads in a file and splits it by any string delimiter,
		 * and returns a vector corresponding to the column given.
		 * @param filename the file that is going to be read and split
		 * @param splitColNum the column number that will be returned
		 * @return a vector containing that column
		 */
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
	
	public static Vector differentiate(Vector vec1, Vector vec2) {
		Vector vec3 = new Vector();
			
		for (int i=1;i<vec1.size();i++) {
			vec3.add( ((Float)vec1.get(i) - (Float)vec1.get(i-1)) / ((Float)vec2.get(i) - (Float)vec2.get(i-1)));
			System.out.println(vec3.get(i-1));
		}
		return vec3;	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Reads in datafile
		Vector field = new Vector();
		Vector abs = new Vector();
		Vector epr = new Vector();
		
		String filename = "src/sim/Cr7Mn_pJCrCr15.0000JCrMn15.0000.epr";
		field = readAndSplit(filename,1);
		abs = readAndSplit(filename,2);
		epr = differentiate(abs,field);
		
		
		
	
		

	}

}
