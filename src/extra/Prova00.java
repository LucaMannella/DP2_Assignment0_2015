package extra;

/**
 * This class will be used for some testing in the assignment.
 * @author Luca
 */
public class Prova00 {

	public static void main(String[] args) {
		String wfrName = "MyWorkFlow1";
		String aName = "MyAction1";
		String role = "MyRole1";
		String id = wfrName+"_"+aName;
		
		String fields = "id=\""+id+"\" name=\""+aName+"\" role=\""+role+"\"";
		System.out.println("The builded String is: \n\t"+fields);

	}

}
