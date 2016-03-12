package test;

public class PrintStackTraceTest {

	@SuppressWarnings("null")
	/**
	 * This main will test the PrintStackTrace method using a NullPointerException.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("...Start main...");
		
		Object o = null;
		try {
			System.out.println( o.toString() );
		}
		catch (NullPointerException npe) {
			npe.printStackTrace();
			//System.exit(-1);
		}
		
		System.out.println("...End main...");
	}
	

}
