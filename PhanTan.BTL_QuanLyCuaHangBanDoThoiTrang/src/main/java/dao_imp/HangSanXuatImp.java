package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.HangSanXuatDAO;
import entity.HangSanXuat;

public class HangSanXuatImp extends UnicastRemoteObject implements HangSanXuatDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410024324489418487L;
	private SessionFactory sessionFactory;
	
	public HangSanXuatImp(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean themHangSanXuat(HangSanXuat hangSanXuat) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(hangSanXuat);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean capNhatHangSanXuat(HangSanXuat hangSanXuat) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(hangSanXuat);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<HangSanXuat> layTatCaHangSanXuat() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from HangSanXuat";
		try {
			List<HangSanXuat> danhSachHangSanXuat = session
					.createNativeQuery(query, HangSanXuat.class)
					.getResultList();
			tr.commit();
			return danhSachHangSanXuat;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	@Override
	public HangSanXuat layHangSanXuatTheoMa(String ma) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			HangSanXuat hsx = session.find(HangSanXuat.class, ma);
			tr.commit();
			return hsx;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<HangSanXuat> layHangSanXuatTheoTen(String ten) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from HangSanXuat hsx where hsx.tenHangSanXuat like N'%" + ten +"%' ";
		try {
			List<HangSanXuat> hsx = session
					.createNativeQuery(query,HangSanXuat.class)
					//.setParameter(1, ten)
					.getResultList();
			tr.commit();
			return hsx;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}
	
	@Override
	public HangSanXuat layHangSanXuatTheoTen1(String ten) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "select * from HangSanXuat hsx where hsx.tenHangSanXuat like N'%" + ten +"%' ";
		try {
			HangSanXuat hsx = session
					.createNativeQuery(query,HangSanXuat.class)
					//.setParameter(1, ten)
					.getSingleResult();
			tr.commit();
			return hsx;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

}
