import java.util.Enumeration;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class debug {
	public static void spitOut(Vector v) {		
		Enumeration vEnum = v.elements();
		while(vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement());
			System.out.print("\n");
		}
	}

	public static void spitOut(Vector v1,Vector v2) {
		for (int i=0;i<v1.size();i++) {
			System.out.print(v1.get(i));
			System.out.print(",");
			System.out.print(v2.get(i));
			System.out.print("\n");
		}
		
	}
	
	public static void writeOut(String filename,Vector v1,Vector v2) {
		File file = new File(filename);
		
		String content = "test";
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(filename), "utf-8"));
		    	
		    	for(int i=0;i<v1.size();i++) {
		    		String s;
		    		s = Float.toString((Float)v1.get(i));
		    		writer.write(s);
		    		writer.write(",");
		    		s = Float.toString((Float)v2.get(i));
		    		writer.write(s);
		    		writer.write("\n");
		    		
		    	}

		} catch (IOException ex){
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	
	}
	
}
