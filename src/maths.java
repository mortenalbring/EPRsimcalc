import java.util.Vector;
import java.util.Collections;

public class maths {
	public static Vector differentiate(Vector vec1, Vector vec2) {
		/**
		 * Differentiates vector 1 with wrt. vector 2
		 * @param vec1 first vector
		 * @param vec2 second vector
		 * @return first derivative of first vector with regards to second vector
		 */
		
		Vector vec3 = new Vector();
			
		for (int i=1;i<vec1.size();i++) {
			vec3.add( ((Float)vec1.get(i) - (Float)vec1.get(i-1)) / ((Float)vec2.get(i) - (Float)vec2.get(i-1)));
		}
		int i=vec1.size()-1;
		vec3.add( ((Float)vec1.get(i) - (Float)vec1.get(i-1)) / ((Float)vec2.get(i) - (Float)vec2.get(i-1)));
		
		return vec3;	
	}
	
	public static Vector normalise(Vector vec1) {
		Vector vecnorm = new Vector();
		Object o = Collections.max(vec1);		
		for (int i=0;i<vec1.size();i++) {			
			vecnorm.add((Float)vec1.get(i) / (Float)o);
		}		
		return vecnorm;
	}	
}
