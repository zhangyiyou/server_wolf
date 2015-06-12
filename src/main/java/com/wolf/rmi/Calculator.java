package com.wolf.rmi;

import java.rmi.Remote;

//建立服务接口
public interface Calculator extends Remote {

	public long add(long a, long b) throws java.rmi.RemoteException;

	public long sub(long a, long b) throws java.rmi.RemoteException;

	public long mul(long a, long b) throws java.rmi.RemoteException;

	public long div(long a, long b) throws java.rmi.RemoteException;

}
