package ex2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Main2 {

	public static final String PATH = "it.polito.dp2.file";

	/** 
	 * This program checks the file "it.polito.dp2.file" (that have to contain some timestamps)
	 * and it prints on the screen the most recent timestamp.
	 **/ 
	public static void main(String[] args) {
		int i=1;
		String buffer;
		StringTokenizer st;
		int hour, minute, second, day, month, year;
		GregorianCalendar timestamp; 
		GregorianCalendar max = new GregorianCalendar(0, 0, 0);
		
		// Get the "it.polito.dp2.file" system property
		String dir = System.getProperty(PATH);
		System.out.println("Start reading: "+dir);
		try {
			//Buffer Reader + File Reader for reading Strings from a file.
			BufferedReader fpin = new BufferedReader(new FileReader(dir));
			i=1;
			while( (buffer = fpin.readLine()) != null ) {
				st = new StringTokenizer(buffer, " ");
				hour = Integer.valueOf( st.nextToken().trim() );
				minute = Integer.valueOf( st.nextToken().trim() );
				second = Integer.valueOf( st.nextToken().trim() );
				day = Integer.valueOf( st.nextToken().trim() );
				month = Integer.valueOf( st.nextToken().trim() );
				year = Integer.valueOf( st.nextToken().trim() );
				
				timestamp = new GregorianCalendar(year, month, day, hour, minute, second);
				if(timestamp.compareTo(max) > 0 )
					max = timestamp;
				i++;
			}
			fpin.close();
			
			String date = max.get(Calendar.DAY_OF_WEEK)+"/"+max.get(Calendar.MONTH)+"/"+max.get(Calendar.YEAR)+" at "
					+max.get(Calendar.HOUR)+":"+max.get(Calendar.MINUTE)+":"+max.get(Calendar.SECOND);
			System.out.println("The most recent timestamp is dated: "+date);
		}
		catch (FileNotFoundException e) {
			System.err.println("Impossible to open the file! "+e.getMessage()+"\n");
			e.printStackTrace();
			return;
		}
		catch (NumberFormatException e) {
			System.err.println("Line "+i+"It's impossible to convert a String in Integer! "+e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Reading error in line "+i+" of the file");
			e.printStackTrace();
		}
		
		System.out.println("\n"+"Operations completed!"+"\n");
	}

}
