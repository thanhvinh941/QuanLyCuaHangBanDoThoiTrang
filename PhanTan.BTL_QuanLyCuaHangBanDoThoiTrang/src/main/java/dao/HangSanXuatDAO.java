package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HangSanXuat;

public interface HangSanXuatDAO extends Remote{
	public boolean themHangSanXuat(HangSanXuat hangSanXuat) throws RemoteException;
	public boolean capNhatHangSanXuat(HangSanXuat hangSanXuat) throws RemoteException;
	public List<HangSanXuat> layTatCaHangSanXuat() throws RemoteException;
	public HangSanXuat layHangSanXuatTheoMa(String ma) throws RemoteException;
	public List<HangSanXuat> layHangSanXuatTheoTen(String ten) throws RemoteException;
	public HangSanXuat layHangSanXuatTheoTen1(String ten) throws RemoteException;
}
