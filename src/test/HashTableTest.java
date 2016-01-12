package test;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

	public static void main(String[] args) {
		
		Map<Integer, AnotherClass> mappa = new Hashtable<Integer, AnotherClass>();
		
		mappa.put(22, new AnotherClass(22, "contengo 22"));
		mappa.put(11, new AnotherClass(11, "contengo 11"));
		
		for(AnotherClass obj : mappa.values()) {
			System.out.println(obj);
		}
		
		System.out.println("fine");
	}

	
	public static class AnotherClass {
		
		private int intero;
		private String stringa;

		public AnotherClass(int intero, String stringa) {
			this.intero = intero;
			this.stringa = stringa;
		}
		
		public int getIntero(){
			return intero;
		}
		
		public String getStringa(){
			return stringa;
		}
		
		public String toString() {
			return "Key: "+intero+" String: "+stringa+"\n";
		}
	}
	
}