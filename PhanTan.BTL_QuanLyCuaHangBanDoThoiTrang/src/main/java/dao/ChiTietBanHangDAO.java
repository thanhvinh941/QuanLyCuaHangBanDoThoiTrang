package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDonBanHang;

public interface ChiTietBanHangDAO extends Remote{
	public boolean themChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) throws RemoteException;
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) throws RemoteException;
	public boolean xoaChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) throws RemoteException;
	public double tinhThanhTien(ChiTietHoaDonBanHang chiTietHoaDon) throws RemoteException;
	public List<ChiTietHoaDonBanHang> layDanhSachCTHoaDonBanHangTheoMaHDBH(String ma) throws RemoteException;
	public List<ChiTietHoaDonBanHang> layDanhSachCTHoaDonBanHangTheoMaSP(String ma) throws RemoteException;
}
