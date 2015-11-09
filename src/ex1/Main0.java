package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main0 {

	/** A simple main that read the file "dictionary.txt" and print it on the screen. **/ 
	public static void main(String[] args) {
		FileReader fRead = null;
		BufferedReader fpin = null;
		String buffer;
		Collection<String> stringhe = new ArrayList<String>();
		
		try {
			//the File Reader is thought for reading character by character
			fRead = new FileReader("./dictionary.txt");
			//the Buffer Reader allows to manage the Strings.
			fpin = new BufferedReader(fRead);
			
		} catch (FileNotFoundException e) {
			System.err.println("Impossible to open the file! "+e.getMessage());
			e.printStackTrace();
		}

		try {
			while((buffer = fpin.readLine()) != null) {
				stringhe.add(buffer);
			}
			fpin.close();
			fRead.close();
			
		} catch (IOException e) {
			System.err.println("Error during I/O operation! "+e.getMessage());
			e.printStackTrace();
		}
		
		//printing the collection.
		for(String s : stringhe) {
			System.out.println(s);
		}
	}

}
