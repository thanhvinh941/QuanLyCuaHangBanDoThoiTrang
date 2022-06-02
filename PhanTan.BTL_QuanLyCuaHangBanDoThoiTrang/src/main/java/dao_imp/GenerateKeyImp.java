package dao_imp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.GenerateKeyDAO;

public class GenerateKeyImp	extends UnicastRemoteObject implements GenerateKeyDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -357934436679556978L;
	private SessionFactory sessionFactory;
	
	public GenerateKeyImp(SessionFactory sessionFactory) throws RemoteException{
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String getKey(String table) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String id = null;
		String prefix = null;
		if (table == "LoaiSanPham") {
			id = "maLoaiSanPham";
			prefix = "L";
		}
		if (table == "HangSanXuat") {
			id = "maHangSanXuat";
			prefix = "HSX";
		}
		if (table == "CaLamViec") {
			id = "maCa";
			prefix = "CA";
		}
		if (table == "ChuCuaHang") {
			id = "maChuCuaHang";
			prefix = "CCH";
		}
		if (table == "HoaDonBanHang") {
			id = "maHoaDonBanHang";
			prefix = "BH";
		}
		if (table == "HoaDonNhapKho") {
			id = "maHoaDonNhapKho";
			prefix = "NK";
		}
		if (table == "KhachHang") {
			id = "maKhachHang";
			prefix = "KH";
		}
		if (table == "NhanVienBanHang") {
			id = "maNhanVien";
			prefix = "NV";
		}
		if (table == "SanPham") {
			id = "maSanPham";
			prefix = "SP";
		}
		String query = "Select tb."+id+" from  "+table+" tb";
		
		try {
			
			final String finalPrefix = prefix;
			Stream<String> ids = session.createQuery(query, String.class).stream();
		    int max = (int) ids.map(o -> o.replace(finalPrefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
			tr.commit();
			System.out.println(max);
			return prefix + String.format("%03d", max + 1);
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

}
