package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GenerateKeyDAO extends Remote{
 public String getKey(String table) throws RemoteException;
}
