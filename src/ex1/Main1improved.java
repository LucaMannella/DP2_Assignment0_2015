package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1improved {

	/** A simple main that read a file given as parameter and prints on the screen
	 * the lines that not occurs in the file "dictionary.txt".
	 *
	 * In this exercise the file "dictionary.txt" must has just one word for each line
	 * and the program is able to find that words in the strings of the file given as
	 * command line parameter.
	 **/
	public static void main(String[] args) {
		int i=1;
		String buffer, token;
		StringTokenizer st;	
		Set<String> dictionary = new HashSet<String>();

		if(args.length < 1) {
			System.out.println("Something wrong on the parameters on the command line!");
			return;
		}
			
		try {
			//Buffer Reader + File Reader for reading Strings from a file.
			BufferedReader fpin1 = new BufferedReader(new FileReader("./dictionary2.txt"));
			BufferedReader fpin2 = new BufferedReader(new FileReader(args[0]));
			
			//preparing the dictionary
			buffer = fpin1.readLine();
			while(buffer != null) {
				try {	//using an inner try-catch for skip just a wrong line in the file
					dictionary.add(buffer);
					i++;
					buffer = fpin1.readLine();
				} catch (IOException e) {
					System.err.println("Reading error in line "+i+" of the file");				
				}
			}
			fpin1.close();	//this function should close also the inner buffer 
	
			//creating an object for writing a new file
			PrintWriter fpout = new PrintWriter(new FileWriter("./output.txt"));
			//printing on the screen the words that are not inside the dictionary
			i=1;
			buffer = fpin2.readLine();
			while(buffer != null) {
				try {	//using an inner try-catch for skip just a wrong line in the file
					st = new StringTokenizer(buffer, " ");
					while( st.hasMoreTokens() ) {
						token = st.nextToken().trim();
						if( !dictionary.contains(token) )
							System.out.println("The word: <<"+token+">> is not in the dictionary!");
						else
							fpout.println("Word <<"+token+">> found in line: "+i);
					}
					i++;
					buffer = fpin2.readLine();
				} catch (NoSuchElementException e) {
					System.err.println("Error with String Tokenizer in line "+i+" of the file");
				} catch (IOException e) {
					System.err.println("Reading error in line "+i+" of the file");
				}
			}
			fpin2.close();	//this function should close also the inner buffer 
			fpout.close();

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
		catch (Exception e) {
			System.err.println("Unpredicted Exception! "+e.getMessage()+"\n");
			e.printStackTrace();
			return;
		}
		
		System.out.println("\n"+"Operation completed!"+"\n");
	}

}
