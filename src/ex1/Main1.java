package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main1 {

	/** A simple main that read a file given as parameter and prints on the screen 
	 * the lines that not occurs in the file "dictionary.txt". **/ 
	public static void main(String[] args) {
		String buffer;
		Set<String> dictionary = new HashSet<String>();
		
		try {
			//the File Reader is thought for reading character by character
			FileReader fRead1 = new FileReader("./dictionary.txt");
			FileReader fRead2 = new FileReader(args[0]);
			//the Buffer Reader allows to manage the Strings.
			BufferedReader fpin1 = new BufferedReader(fRead1);
			BufferedReader fpin2 = new BufferedReader(fRead2);
			
			//preparing the dictionary
			while((buffer = fpin1.readLine()) != null) {
				dictionary.add(buffer);
			}
			fpin1.close();
			fRead1.close();
			
			//printing on the screen
			while((buffer = fpin2.readLine()) != null) {
				if( !dictionary.contains(buffer) )
					System.out.println("String: <<"+buffer+">> is not in the dictionary!");	
			}
			fpin2.close();
			fRead2.close();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Something wrong on the parameters of the command line! "+e.getMessage()+"\n");
			e.printStackTrace();
			return;
		}
		catch (FileNotFoundException e) {
			System.err.println("Impossible to open the file! "+e.getMessage()+"\n");
			e.printStackTrace();
			return;
		} 
		catch (IOException e) {
			System.err.println("Error during I/O operation! "+e.getMessage()+"\n");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("Unpredicted Exception! "+e.getMessage()+"\n");
			e.printStackTrace();
			return;
		}
		
		System.out.println("\n"+"Operation completed!"+"\n");
	}

}
