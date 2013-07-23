import java.util.Enumeration;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class debug {
	/**
	 * Function that writes out elements of vector to system line
	 * @param v Vector
	 */
	public static void spitOut(Vector v) {		
		Enumeration vEnum = v.elements();
		while(vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement());
			System.out.print("\n");
		}
	}
	/**
	 * Function that writes out elements of vectors to system line
	 * @param v1 Vector one
	 * @param v2 Vector one
	 */

	public static void spitOut(Vector v1,Vector v2) {
		for (int i=0;i<v1.size();i++) {
			System.out.print(v1.get(i));
			System.out.print(",");
			System.out.print(v2.get(i));
			System.out.print("\n");
		}
		
	}

	/**
	 * Write vectors to file
	 * @param filename File to write vectors to
	 * @param v1 Vector one
	 * @param v2 Vector two
	 */
	public static void writeOut(String filename,Vector v1,Vector v2) {		
		Writer writer = null;
		
		try {
			//Open file
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(filename), "utf-8"));
		    
		    //Write vectors to file comma delimited
		    	for(int i=0;i<v1.size();i++) {
		    		writer.write(Float.toString((Float)v1.get(i)));
		    		writer.write(",");
		    		writer.write(Float.toString((Float)v2.get(i)));
		    		writer.write("\n");
		    		
		    	}

		} catch (IOException ex){
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	
	}
	
}
