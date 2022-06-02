package dao_imp;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenerateKeyForNhanVienBangHang {
private SessionFactory sessionFactory;
	
	public GenerateKeyForNhanVienBangHang(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	//@Override
	public String getKey(String table) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String id = null;
		String prefix = null;
		if (table == "CaLamViec") {
			id = "maCa";
			prefix = "CA";
		}
		if (table == "ChuCuaHang") {
			id = "maChuCuaHang";
			prefix = "CCH";
		}
		if (table == "NhanVienBanHang") {
			id = "maNhanVien";
			prefix = "NV";
		}
		String query = "Select tb."+id+" from  "+table+" tb" + " where tb." +id+ " like 'NV%'";
		
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
