package com.deepsm007;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bumper extends Remote {

	public boolean bump() throws RemoteException;

	public BigInteger get() throws RemoteException;

}
