package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangDAO extends Remote{
	public boolean themKhachHang(KhachHang khachHang) throws RemoteException;
	public boolean capNhatKhachHang(KhachHang khachHang) throws RemoteException;
	public boolean xoaKhachHang(String ma) throws RemoteException;
	public List<KhachHang> layTatCaKhachHang() throws RemoteException;
	public KhachHang layKhachHangTheoMa(String ma) throws RemoteException;
	public List<KhachHang> layDanhSachKhachHangTheoTen(String ten) throws RemoteException;
	public KhachHang layKhachHangTheoDienthoai(String sdt) throws RemoteException;
	public List<KhachHang> layDanhSachKhachhangTheoNamSinh(int nam) throws RemoteException;
	public KhachHang layKhachhangTheoCMND(String cmnd) throws RemoteException;
	public int taoMaKH() throws RemoteException;

}
