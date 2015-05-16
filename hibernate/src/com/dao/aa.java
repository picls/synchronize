package com.dao;

public abstract class aa {
	
	public static void main(String args[]) {
		father f = new son();
		System.out.println(f.get());
  
		fa<String> r = new so();    
		String s = "123";
		r.f(s);          
		     
	}

}

class father {
	
	public Object get() {
		return "a";
	}
	
}

class son extends father {
	
	public Integer get() {
		return 0;
	}
	
}



	class fa<T>{   
	   public void f(T a){    
		   System.out.println("fa");
	   }
	}

	class so extends fa<String>{ 
	    public void f(String a){     
	    	System.out.println("so");
	    }
	} 
