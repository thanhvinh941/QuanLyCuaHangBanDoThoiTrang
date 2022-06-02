package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDonNhapKho;
public interface HoaDonNhapKhoDAO extends Remote{
	public boolean themHoaDon (HoaDonNhapKho hoaDonNK) throws RemoteException;
	public boolean capnhatHoaDon(HoaDonNhapKho hoaDonNK) throws RemoteException;
	public List<HoaDonNhapKho> layTatCaHoaDonNhapKho() throws RemoteException;
	public HoaDonNhapKho layHoaDonNhapKhoTheoMa(String ma) throws RemoteException;
	public List<HoaDonNhapKho> layDanhSachHoaDonNhapKhoTheoNgay(String date) throws RemoteException;
	public List<HoaDonNhapKho> layDanhSachHoaDonNhapKhoTheoMaNhanVien(String maNV) throws RemoteException;
	public List<HoaDonNhapKho> layDanhSachHoaDonNhapKhoTheoTenNhanVien(String tenNV) throws RemoteException;
	public double tinhTongTien(String ma) throws RemoteException;
}
