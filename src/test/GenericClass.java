package test;

public class GenericClass {
	
	private int intero;
	private String stringa;

	public GenericClass(int intero, String stringa) {
		this.intero = intero;
		this.stringa = stringa;
	}
	
	public int getIntero(){
		return intero;
	}
	
	public String getStringa(){
		return stringa;
	}
	
	@Override
	public String toString() {
		return "Key: "+intero+" String: "+stringa+"\n";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof GenericClass == false)
			return false;
		
		GenericClass o = (GenericClass)other;
		
		if( this.intero == o.getIntero() ) {
			if( this.stringa.equals(o.getStringa()))
				return true;
		}
		
		return false;
	}
}