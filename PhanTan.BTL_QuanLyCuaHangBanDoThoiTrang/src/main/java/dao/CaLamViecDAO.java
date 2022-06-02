package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CaLamViec;
public interface CaLamViecDAO extends Remote{
	public boolean themCaLamViec(CaLamViec ca) throws RemoteException;
	public List<CaLamViec> layTatCaCacCaLamViec() throws RemoteException;
	
}
