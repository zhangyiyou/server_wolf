package com.wolf.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.wolf.rmi.Calculator;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public long add(long a, long b) throws RemoteException {
		return a+b;
	}

	@Override
	public long sub(long a, long b) throws RemoteException {
		return a-b;
	}

	@Override
	public long mul(long a, long b) throws RemoteException {
		return a*b;
	}

	@Override
	public long div(long a, long b) throws RemoteException {
		return a/b;
	}

}
