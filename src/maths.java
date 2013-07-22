import java.util.Vector;

public class maths {
	public static Vector differentiate(Vector vec1, Vector vec2) {
		Vector vec3 = new Vector();
			
		for (int i=1;i<vec1.size();i++) {
			vec3.add( ((Float)vec1.get(i) - (Float)vec1.get(i-1)) / ((Float)vec2.get(i) - (Float)vec2.get(i-1)));
			System.out.println(vec3.get(i-1));
		}
		return vec3;	
	}
	
	
}
