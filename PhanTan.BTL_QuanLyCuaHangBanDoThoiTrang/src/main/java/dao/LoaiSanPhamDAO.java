package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSanPham;

public interface LoaiSanPhamDAO extends Remote{
	public boolean themLoaiSanPham(LoaiSanPham loaiSP) throws RemoteException;
	public boolean capNhatLoaiSanPham(LoaiSanPham loaiSP) throws RemoteException;
	public List<LoaiSanPham> layTatCaLoaiSanPham() throws RemoteException;
	public LoaiSanPham layLoaiSanPhamTheoMa(String ma) throws RemoteException;
	public LoaiSanPham layLoaiSanPHamTheoTen(String ten) throws RemoteException;
}
