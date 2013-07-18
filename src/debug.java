import java.util.Enumeration;
import java.util.Vector;


public class debug {
	public static void spitOut(Vector v) {		
		Enumeration vEnum = v.elements();
		while(vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement());
			System.out.print("\n");
		}
	}
}
