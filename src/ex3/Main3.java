package ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {

	/** This program takes 2 files (filenames are taken from the command line)
	 *  and merge them in a third file (after an ascending sort).
	 *  
	 *  This exercise does not admit duplicate lines.
	 **/ 
	public static void main(String[] args) {
		int i;
		String buffer;
		Set<String> lines = new TreeSet<String>();
		
		try {
			//Buffer Reader + File Reader for reading Strings from a file.
			BufferedReader fpin1 = new BufferedReader(new FileReader(args[0]));
			BufferedReader fpin2 = new BufferedReader(new FileReader(args[1]));
			//creating an object for writing a new file
			PrintWriter fpout = new PrintWriter(new FileWriter("./output.txt"));
			
			i=1;	//reading first file
			System.out.println("Start reading: "+args[0]);
			buffer = fpin1.readLine();
			while(buffer != null) {
				try {	//using an inner try-catch for skip just a wrong line in the file
					lines.add(buffer);
					i++;
					buffer = fpin1.readLine();
				} catch (IOException e) {
					System.err.println("File 1 - Reading error in line "+i+" of the file");				
				}
			}
			fpin1.close();
			
			i=1;	//reading second file
			System.out.println("Start reading: "+args[1]);
			buffer = fpin2.readLine();
			while(buffer != null) {
				try {
					lines.add(buffer);
					i++;
					buffer = fpin2.readLine();
				} catch (IOException e) {
					System.err.println("File 2 - Reading error in line "+i+" of the file");				
				}
			}
			fpin2.close();
	
			//writing the third file (using the TreeSet it's already ordered)
			System.out.println("Start writing the output file...");
			for(String buf : lines) {
				fpout.println(buf);
			}
			fpout.close();
			System.out.println("The file <<output.txt>> was written");

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
		
		System.out.println("\n"+"Operations completed!"+"\n");
	}

}
