package com.oocl.mnlbc.num5;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author barrepe
 *
 */

public class App6 {
	public static void main(String[] args) {
		Worker jame = new Worker("Jame",25,13000);
		Worker jameDup = new Worker("Jame",25,13000);
		if(jame.equals(jameDup)){
			System.out.println("Object is equal");
		}else{
			System.out.println("Object is not equal");
		}
		
	}
}
