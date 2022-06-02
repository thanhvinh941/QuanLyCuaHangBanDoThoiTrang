package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ChiTietBanHangDAO;
import entity.ChiTietHoaDonBanHang;
import entity.SanPham;

public class ChiTietBanHangImp extends UnicastRemoteObject implements ChiTietBanHangDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 332627645687465818L;
	private SessionFactory sessionFactory;
	public ChiTietBanHangImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.save(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean capNhatChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.update(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean xoaChiTietHoaDon(ChiTietHoaDonBanHang chiTietHoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();		
		try {
			session.delete(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public double tinhThanhTien(ChiTietHoaDonBanHang chiTietHoaDon) {
		int soLuong = chiTietHoaDon.getSoLuong();
		SanPham sanPham = chiTietHoaDon.getSanPham();
		double gia = sanPham.getGiaSanPham();
		if (soLuong > 0.0 && gia > 0)
		 return soLuong * gia;
		return 0;
	}

	@Override
	public List<ChiTietHoaDonBanHang> layDanhSachCTHoaDonBanHangTheoMaHDBH(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from ChiTietHoaDonBanHang cthd where cthd.maHoaDonBanHang like ?1";
		try {
			List<ChiTietHoaDonBanHang> danhSachCTHoaDonBanHang = session
					.createNativeQuery(query, ChiTietHoaDonBanHang.class)
					.setParameter(1, ma)
					.getResultList();
			tr.commit();
			return danhSachCTHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<ChiTietHoaDonBanHang> layDanhSachCTHoaDonBanHangTheoMaSP(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from ChiTietHoaDonBanHang cthd where cthd.maSanPham like ?1";
		try {
			List<ChiTietHoaDonBanHang> danhSachCTHoaDonBanHang = session
					.createNativeQuery(query, ChiTietHoaDonBanHang.class)
					.setParameter(1, ma)
					.getResultList();
			tr.commit();
			return danhSachCTHoaDonBanHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

}
