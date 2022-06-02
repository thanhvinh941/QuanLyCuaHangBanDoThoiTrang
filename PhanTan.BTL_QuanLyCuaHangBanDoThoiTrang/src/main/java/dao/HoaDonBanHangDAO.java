package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDonBanHang;
public interface HoaDonBanHangDAO extends Remote{
	public boolean themHoaDonBanHang(HoaDonBanHang hoaDonBanHang) throws RemoteException;
	public boolean capNhatHoaDonBanHang(HoaDonBanHang hoaDonBanHang) throws RemoteException;
	public List<HoaDonBanHang> layTatCaHoaDonBanHang() throws RemoteException;
	public HoaDonBanHang layHoaDonTheoMa(String ma) throws RemoteException;
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoNgay(String date) throws RemoteException;
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoTenKhachHang(String tenKH) throws RemoteException;
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoMaKhachHang(String maKH) throws RemoteException;
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoMaNhanVien(String maNV) throws RemoteException;
	public List<HoaDonBanHang> layDanhSachHoaDonBanHangTheoTenNhanVien(String tenNV) throws RemoteException;
	public double tinhTongTien(String ma) throws RemoteException;
}
