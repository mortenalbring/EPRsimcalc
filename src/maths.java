import java.util.Vector;
import java.util.Collections;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
		/**
		 * Normalises vec1 by dividing by the maximum value found in vec1
		 */
		
		Vector vecnorm = new Vector();
		Object o = Collections.max(vec1);		
		for (int i=0;i<vec1.size();i++) {			
			vecnorm.add((Float)vec1.get(i) / (Float)o);
		}		
		return vecnorm;
	}
	
	public static matchSet matchValues(matchSet s) {
		/**
		 * Finds endpoints and truncates vector based on smallest endpoints
		 */
		
		Vector matchVecX = new Vector();
		Vector matchVecY = new Vector();
		
		float p;
		p = (Float)s.v1x.get(0);
		System.out.println(p);
		
		p = (Float)s.v2x.get(0);
		System.out.println(p);
		
		for(int j=0;j<s.v2x.size();j++) {
			//Loops through elements of v2x
			
			p = (Float)s.v2x.get(j);
			System.out.println(p);			
			float diff;
			float diffsmallest = 100000000;
			int diffsmallestpos = 0;
			
			for(int i=0;i<s.v1x.size();i++) {
				//Calculates the difference between v2x and v1x
				diff = Math.abs(((Float)s.v1x.get(i) - (Float)s.v2x.get(j)));
				if (diff < diffsmallest) {
					//Finds where difference is smallest and keeps track of that position
					diffsmallest = diff;
					diffsmallestpos = i;
				}	
			}
			//Adds those elements to a new vector
			matchVecX.add(s.v1x.get(diffsmallestpos));
			matchVecY.add(s.v1y.get(diffsmallestpos));
		}
		//Return those
		matchSet k = new matchSet(matchVecX,matchVecY,s.v2x,s.v2y);
		
		return k; 
		
	}
	
}
