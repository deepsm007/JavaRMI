package com.deepsm007;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ClientOperation {
	private static Bumper bumper;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		bumper = (Bumper) Naming.lookup("//localhost/MyServer");

		BigInteger ctr = BigInteger.ZERO;
		BigInteger n = new BigInteger("10000");
		long start = System.currentTimeMillis();
		while (!ctr.equals(n)) {
			bumper.bump();
			ctr = bumper.get();
		}
		long stop = System.currentTimeMillis();
		System.out.println(" Value --> " + bumper.get());
		System.out.println("Time in milli-seconds --> " + (stop - start));

	}
}

