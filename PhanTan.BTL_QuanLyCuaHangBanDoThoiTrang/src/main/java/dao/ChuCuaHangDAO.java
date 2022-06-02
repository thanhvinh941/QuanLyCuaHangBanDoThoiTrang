package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.ChuCuaHang;

public interface ChuCuaHangDAO extends Remote{
	public ChuCuaHang layThongTinChuCuaHang() throws RemoteException;
	public boolean capnhatThongTinChuCuaHang() throws RemoteException;
	public ChuCuaHang layThongTinChuCuaHangTheoMa(String ma) throws RemoteException;
}
