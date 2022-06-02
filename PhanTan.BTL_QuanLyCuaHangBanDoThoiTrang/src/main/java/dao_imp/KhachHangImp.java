package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.KhachHangDAO;
import entity.KhachHang;

public class KhachHangImp extends UnicastRemoteObject implements KhachHangDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5702820307295265684L;
	private SessionFactory sessionFactory;
	public KhachHangImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themKhachHang(KhachHang khachHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean capNhatKhachHang(KhachHang khachHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public boolean xoaKhachHang(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			KhachHang kh = session.find(KhachHang.class, ma);
			session.delete(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return false;
	}

	@Override
	public List<KhachHang> layTatCaKhachHang() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh";
		try {
			List<KhachHang> danhSachKhachHang = session
					.createNativeQuery(query, KhachHang.class)
					.getResultList();
			tr.commit();
			return danhSachKhachHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public KhachHang layKhachHangTheoMa(String ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh where kh.maKhachHang like ?1";
		try {
			KhachHang kh = session
					.createNativeQuery(query, KhachHang.class)
					.setParameter(1, ma)
					.getSingleResult();
			tr.commit();
			return kh;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<KhachHang> layDanhSachKhachHangTheoTen(String ten) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh where kh.tenKhachHang like N'%"+ten+"%'";
		try {
			List<KhachHang> danhSachKhachHang = session
					.createNativeQuery(query, KhachHang.class)
					//.setParameter(1, ten)
					.getResultList();
			tr.commit();
			return danhSachKhachHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public KhachHang layKhachHangTheoDienthoai(String sdt) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh where soDienThoai like ?1";
		try {
			KhachHang kh = session
					.createNativeQuery(query, KhachHang.class)
					.setParameter(1, sdt)
					.getSingleResult();
			tr.commit();
			return kh;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public List<KhachHang> layDanhSachKhachhangTheoNamSinh(int nam) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh where year(kh.ngaySinh) like ?1";
		try {
			List<KhachHang> danhSachKhachHang = session
					.createNativeQuery(query, KhachHang.class)
					.setParameter(1, nam)
					.getResultList();
			tr.commit();
			return danhSachKhachHang;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
	
	@Override
	public KhachHang layKhachhangTheoCMND(String cmnd) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select * from KhachHang kh where soCMND like ?1";
		try {
			KhachHang kh = session
					.createNativeQuery(query, KhachHang.class)
					.setParameter(1, cmnd)
					.getSingleResult();
			tr.commit();
			return kh;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public int taoMaKH() throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String query = "Select count(maKhachHang) from KhachHang ";
		try {
			int num = session
					.createNativeQuery(query, KhachHang.class)
					.getMaxResults();
			tr.commit();
			return num;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return 0;
	}

}
