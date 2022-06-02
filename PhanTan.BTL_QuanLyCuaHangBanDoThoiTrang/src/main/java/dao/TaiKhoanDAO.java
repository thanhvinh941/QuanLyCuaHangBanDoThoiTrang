package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoanDAO extends Remote {
	public boolean themTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;
	public boolean capnhatTrangThai(TaiKhoan taiKhoan) throws RemoteException;
	public boolean cpanhatTaiKhoan(TaiKhoan taikhoan) throws RemoteException; 
	public boolean capNhatMatKhau(String tenDangNhap, String newPass) throws RemoteException;
	public int  kiemTraTaiKhoan(String tenDangNhap, String matKhau) throws RemoteException;
	boolean kiemtraTinhTrangDangNhap(Boolean tinhTrang, String tenDangNhap) throws RemoteException;
	public TaiKhoan layThongTinTaiKhoanTheoTenDangNhap(String ma) throws RemoteException;
	public TaiKhoan layThongTinTaiKhoanTheoTrangThai(boolean tinhTrang) throws RemoteException;
	public List<TaiKhoan> latTatCaThongTinTaiKhoan() throws RemoteException;
}
