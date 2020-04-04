package com.deepsm007;
import java.math.BigInteger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.deepsm007.Bumper;

public class ServerOperation extends UnicastRemoteObject implements Bumper {
	private static final long serialVersionUID = 1L;
	public static BigInteger bi;

	protected ServerOperation() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		bi = BigInteger.ZERO;
		try {
			Naming.rebind("//localhost/MyServer", new ServerOperation());
			System.err.println("RMI Server Started");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public boolean bump() throws RemoteException {
		bi = bi.add(BigInteger.ONE);
		return true;
	}

	@Override
	public BigInteger get() throws RemoteException {
		return bi;
	}
}

