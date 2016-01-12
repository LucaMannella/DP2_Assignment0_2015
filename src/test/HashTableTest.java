package test;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

	public static void main(String[] args) {
		
		Map<Integer, GenericClass> mappa = new Hashtable<Integer, GenericClass>();
		
		mappa.put(22, new GenericClass(22, "contengo 22"));
		mappa.put(11, new GenericClass(11, "contengo 11"));
		
		for(GenericClass obj : mappa.values()) {
			System.out.println(obj);
		}
		
		System.out.println("fine");
	}
	
}