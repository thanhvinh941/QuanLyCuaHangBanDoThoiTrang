package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDonNhapKho;

public interface ChiTietNhapKhoDAO extends Remote{
	public boolean themChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) throws RemoteException;
	public boolean capNhatChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) throws RemoteException;
	public boolean xoaChiTietNhapKho(ChiTietHoaDonNhapKho chiTietNhapKho) throws RemoteException;
	public List<ChiTietHoaDonNhapKho> layDanhSachCTHoaDonNhapKhoTheoMaHDBH(String ma) throws RemoteException;
	public List<ChiTietHoaDonNhapKho> layDanhSachCTHoaDonNhapKhoTheoMaSP(String ma) throws RemoteException;
}
