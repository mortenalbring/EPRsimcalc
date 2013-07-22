import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;


public class fileIO {
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
}