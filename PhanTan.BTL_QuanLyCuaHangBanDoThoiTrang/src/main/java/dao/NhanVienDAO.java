package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVienBanHang;

public interface NhanVienDAO extends Remote {
	public boolean themNhanVien(NhanVienBanHang nhanVien) throws RemoteException;
	public boolean capNhatNhanVien(NhanVienBanHang nhanVien) throws RemoteException;
	public boolean xoaNhanVien (String ma) throws RemoteException;
	public List<NhanVienBanHang> layTatCaNhanVien() throws RemoteException;
	public NhanVienBanHang layNhanVienTheoMa(String ma) throws RemoteException;
	public List<NhanVienBanHang> layDanhSachNhanVienTheoTen(String ten) throws RemoteException;
	public NhanVienBanHang layNhanVienTheoSoDienthoai(String sdt) throws RemoteException;
	public List<NhanVienBanHang> layDanhSachNhanVienTheoNamSinh(int nam) throws RemoteException;
	public List<NhanVienBanHang> layDanhSachNhanVienTheoNgayVaoLam(String date) throws RemoteException;
	public NhanVienBanHang capnhatTinhTrangNhanVien(String ma) throws RemoteException;
	public List<NhanVienBanHang> layDanhSachNhanVienTheoGioiTinh(boolean gt) throws RemoteException;
	public List<NhanVienBanHang> layDanhSachNhanVienTheoTinhTrang(boolean tinhTrang) throws RemoteException;
	public NhanVienBanHang layNhanVienTheoSoCMND(String cmnd) throws RemoteException;
	public List<NhanVienBanHang> layToanBoDanhSachNhanVien() throws RemoteException;
}
