package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SanPham;
public interface SanPhamDAO extends Remote {
	public boolean themSanPham(SanPham sanPham) throws RemoteException;
	public boolean capNhatSanPham(SanPham sanPham) throws RemoteException;
	public List<SanPham> layTatCaSanPham() throws RemoteException;
	public SanPham laySanPhamTheoMa(String ma) throws RemoteException;
	public List<SanPham> layDanhSachSanPhamTheoLoai(String loai) throws RemoteException;
	public List<SanPham> laySanPhamTheoSoLuong(int thapNhat, int caoNhat) throws RemoteException;
	public SanPham capnhatSoLuong(int sl) throws RemoteException;
	public int demTatCaSanPham() throws RemoteException;
	public List<SanPham> layTatCaSanPhamKhacKhong() throws RemoteException;
	public List<SanPham> layDanhSachSanPhamTheoHSX(String loai) throws RemoteException;
}
