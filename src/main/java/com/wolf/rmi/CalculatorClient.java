package com.wolf.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {

	public static void main(String[] args) {
		try {
			Calculator calculator = (Calculator) Naming.lookup("rmi://127.0.0.1:8080/CalculatorService");
			
			System.out.println(calculator.add(1, 2));
			System.out.println(calculator.sub(1, 2));
			System.out.println(calculator.mul(1, 2));
			System.out.println(calculator.div(1, 2));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
