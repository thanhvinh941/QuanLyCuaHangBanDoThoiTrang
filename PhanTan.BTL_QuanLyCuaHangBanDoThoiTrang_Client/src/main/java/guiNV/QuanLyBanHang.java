package guiNV;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.ChiTietBanHangDAO;
import dao.GenerateKeyDAO;
import dao.HoaDonBanHangDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dao_imp.ChiTietBanHangImp;
import dao_imp.GenerateKeyImp;
import dao_imp.HoaDonBanHangImp;
import dao_imp.KhachHangImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;
import gui.GiaoDienChinh_ChuCuaHang;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class QuanLyBanHang extends JPanel {

	private JTable table;
	private DefaultTableModel tableKHMode;
	private TableModel tablePQMode;
	private JTable tableKH;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable tableHDBH;
	private JTable tableSanPham;
	private JLabel lblHangSanXuat;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel pAnBoLocHDBH;
	private JPanel pBoLocHDBH;
	private JTable tableNhanVien;
	private JTable tableHDKho;
	private JPanel pBoLocHDKho;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtSDT_CMND;
	private DefaultTableModel model;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JTable tableCTHDBanHang;
	private JDateChooser dateChooser;
	private JLabel lblTenKH;

	/**
	 * Create the panel.
	 */
	public QuanLyBanHang() {
		setLayout(null);

		// Chức năng quản lý hóa đơn
		// ------------------------------------------------------------------------------------------------------------------------------------------

		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(240, 0, 1298, 839);

		JLabel lblQuanLyBanHang = new JLabel("Quản lý bán hàng");
		lblQuanLyBanHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyBanHang.setBounds(20, 21, 358, 60);
		add(lblQuanLyBanHang);

		JScrollPane scrollPaneCTHDBH = new JScrollPane();
		scrollPaneCTHDBH.setBounds(20, 495, 790, 236);
		add(scrollPaneCTHDBH);

		tableCTHDBanHang = new JTable();
		tableCTHDBanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPaneCTHDBH.setViewportView(tableCTHDBanHang);
		tableCTHDBanHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableCTHDBanHang.setBackground(Color.WHITE);
		tableCTHDBanHang.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"K\u00EDch th\u01B0\u1EDBc", "M\u00E0u", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1",
						"Th\u00E0nh ti\u1EC1n", "Ghi ch\u00FA" }));

		tableCTHDBanHang.setAutoCreateRowSorter(true);
		tableCTHDBanHang.setRowHeight(tableCTHDBanHang.getRowHeight() + 10);
		
		JLabel lblNewLabel_12 = new JLabel("Bảng hóa đơn");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12.setBounds(20, 110, 250, 34);
		add(lblNewLabel_12);

		JLabel lblNewLabel_12_1 = new JLabel("Bảng chi tiết hóa đơn");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12_1.setBounds(20, 451, 300, 34);
		add(lblNewLabel_12_1);

		JScrollPane scrollPaneHDBH = new JScrollPane();
		scrollPaneHDBH.setBounds(20, 160, 790, 240);
		add(scrollPaneHDBH);

		tableHDBH = new JTable();
		tableHDBH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableHDBH.getSelectedRow();
				String maHD = tableHDBH.getValueAt(row, 1).toString();
				model = (DefaultTableModel) tableCTHDBanHang.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				/*if (tableCTHDBanHang.getRowCount() != 0) {
					for (int i = 0; i <= tableCTHDBanHang.getRowCount(); i++) {
						model.removeRow(i);
					}
				} else*/
					showTableCTHDBH(maHD);
			}
		});
		tableHDBH.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn",
						"Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n", "Ghi ch\u00FA","Tiền khách đưa"}));
		scrollPaneHDBH.setViewportView(tableHDBH);
		tableHDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHDBH.setBackground(Color.WHITE);

		tableHDBH.setAutoCreateRowSorter(true);
		tableHDBH.setRowHeight(tableHDBH.getRowHeight() + 10);

		model = (DefaultTableModel) tableHDBH.getModel();
		showTable();

		/*
		 * pAnBoLocHDBH = new JPanel(); pAnBoLocHDBH.setBackground(Color.WHITE);
		 * pAnBoLocHDBH.setBounds(907, 430, 300, 301); pQuanLyHoaDon.add(pAnBoLocHDBH);
		 * pAnBoLocHDBH.setLayout(null);
		 */

		pBoLocHDBH = new JPanel();
		pBoLocHDBH.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pBoLocHDBH.setBackground(Color.WHITE);
		pBoLocHDBH.setBounds(907, 430, 300, 301);
		add(pBoLocHDBH);
		pBoLocHDBH.setLayout(null);

		JLabel lblNgayLapHoaDon = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHoaDon.setBounds(10, 20, 125, 35);
		pBoLocHDBH.add(lblNgayLapHoaDon);

		JLabel lblSinThoi = new JLabel("Số điện thoại hoặc");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi.setBounds(10, 80, 125, 24);
		pBoLocHDBH.add(lblSinThoi);

		txtSDT_CMND = new JTextField();
		txtSDT_CMND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTenKH.setText("");
			}
		});
		txtSDT_CMND.setBounds(145, 85, 140, 35);
		pBoLocHDBH.add(txtSDT_CMND);
		txtSDT_CMND.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(145, 20, 140, 35);
		pBoLocHDBH.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblSCmnd = new JLabel("số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSCmnd.setBounds(10, 104, 125, 24);
		pBoLocHDBH.add(lblSCmnd);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSDT_CMND.getText().equals("") && !dateChooser.getDate().equals(null))
					timkiemTheoThoiGian();
				else if(!txtSDT_CMND.getText().equals("") && dateChooser.getDate().equals(null)){
					timkiemTheoSDTorCMND();
				} else if(!txtSDT_CMND.getText().equals("") && !dateChooser.getDate().equals(null)) {
					timkiemTheoThoiGian();
					timkiemTheoSDTorCMND();
				}
					
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBounds(94, 185, 114, 35);
		pBoLocHDBH.add(btnTimKiem);
		
		JButton btnXoa = new JButton("Xóa bộ lọc");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSDT_CMND.setText("");
				dateChooser.setDate(null);
				
				xoaHetDuLieuTrenTableModel();
				showTable();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(94, 238, 114, 35);
		pBoLocHDBH.add(btnXoa);
		
		lblTenKH = new JLabel("");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKH.setBounds(145, 148, 140, 27);
		pBoLocHDBH.add(lblTenKH);

		JButton btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemHoaDonBanHang themHDBH = new ThemHoaDonBanHang();
				themHDBH.setVisible(true);
				themHDBH.setLocationRelativeTo(null);
				themHDBH.setAlwaysOnTop(true);
				themHDBH.setResizable(false);
			}
		});
		btnThemHD.setBackground(Color.CYAN);
		btnThemHD.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_add_40px.png")));
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemHD.setBounds(907, 195, 240, 60);
		add(btnThemHD);

		JButton btnCapnhatHD = new JButton("Cập nhật hóa đơn");
		btnCapnhatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CapNhatHoaDonBanHang capnhatHD = new CapNhatHoaDonBanHang();
				capnhatHD.setVisible(true);
				capnhatHD.setLocationRelativeTo(null);
				capnhatHD.setAlwaysOnTop(true);
				capnhatHD.setResizable(false);
				
				int row = tableHDBH.getSelectedRow();
				String ma = tableHDBH.getValueAt(row, 1).toString();
				String ngay = tableHDBH.getValueAt(row, 4).toString();
				String maKH = tableHDBH.getValueAt(row, 2).toString();
				String maNV = tableHDBH.getValueAt(row, 3).toString();
				Double tien = Double.parseDouble(tableHDBH.getValueAt(row, 7).toString());
				try {
					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					
					HoaDonBanHang bh = hoaDonBanHangDAO.layHoaDonTheoMa(ma);
					KhachHang kh = khachHangDAO.layKhachHangTheoMa(bh.getKhachHang().getMaKhachHang());
					NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(bh.getNhanVienBanHang().getMaNhanVien());
					capnhatHD.layMaHDBH(ma, df.parse(ngay), kh.getMaKhachHang(), nv.getMaNhanVien(), tien);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(ma);
			}
		});
		btnCapnhatHD.setBackground(Color.CYAN);
		btnCapnhatHD
				.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_update_40px_2.png")));
		btnCapnhatHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapnhatHD.setBounds(907, 300, 240, 60);
		add(btnCapnhatHD);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHetDuLieuTrenTableModel();
				model = (DefaultTableModel) tableHDBH.getModel();
				try {
					showTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(725, 138, 85, 21);
		add(btnNewButton);

	}

	protected void timkiemTheoSDTorCMND() {
		if(txtSDT_CMND.getText().length() == 10)
			timkiemTheoDienThoai();
		else if (txtSDT_CMND.getText().length() == 12)
			timkiemTheoCMND();
		
	}

	private void timkiemTheoDienThoai() {
		String sdt = txtSDT_CMND.getText().trim();
		int num = 1;
		// List<KhachHang> listKH = khachHangDAO.
		KhachHang kh;
		try {

			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			kh = khachHangDAO.layKhachHangTheoDienthoai(sdt);
			xoaHetDuLieuTrenTableModel();
			List<HoaDonBanHang> listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoMaKhachHang(kh.getMaKhachHang());
			for (HoaDonBanHang hdbh : listHDBH) {
				Date day = hdbh.getNgayLapHoaDon();
				double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
				model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
						hdbh.getNhanVienBanHang().getMaNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void timkiemTheoCMND() {
		String sdt = txtSDT_CMND.getText().trim();
		int num = 1;
		// List<KhachHang> listKH = khachHangDAO.
		KhachHang kh;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			kh = khachHangDAO.layKhachhangTheoCMND(sdt);
			xoaHetDuLieuTrenTableModel();
			List<HoaDonBanHang> listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoMaKhachHang(kh.getMaKhachHang());
			for (HoaDonBanHang hdbh : listHDBH) {
				Date day = hdbh.getNgayLapHoaDon();
				double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
				model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
						hdbh.getNhanVienBanHang().getMaNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void timkiemTheoThoiGian() {
		Date date = dateChooser.getDate();
		df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		int num = 1;
		List<HoaDonBanHang> listHDBH;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoNgay(df.format(date));
			xoaHetDuLieuTrenTableModel();
			for (HoaDonBanHang hdbh : listHDBH) {
				Date day = hdbh.getNgayLapHoaDon();
				double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
				model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
						hdbh.getNhanVienBanHang().getMaNhanVien(), df1.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableHDBH.getModel();
		dm.getDataVector().removeAllElements();
	}

	/*public void showcomboData() {
		for (HoaDonBanHang hdbh : listHDBH) {
			cboMaHD.addItem(hdbh.getMaHoaDonBanHang());
		}
	}*/

	public void showTable() {
		int num = 1;
		List<HoaDonBanHang> listHDBH;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			listHDBH = hoaDonBanHangDAO.layTatCaHoaDonBanHang();
			for (HoaDonBanHang hdbh : listHDBH) {
				Date day = hdbh.getNgayLapHoaDon();

				KhachHang kh = khachHangDAO.layKhachHangTheoMa(hdbh.getKhachHang().getMaKhachHang());
				NhanVienBanHang nv= nhanVienDAO.layNhanVienTheoMa(hdbh.getNhanVienBanHang().getMaNhanVien());
				double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
				model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), kh.getTenKhachHang(),
						nv.getTenNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public double tinhTongTienHoaDonBanHang(String maHDBH) {
		List<ChiTietHoaDonBanHang> listCTBH;
		double tongTien = 0;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			listCTBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaHDBH(maHDBH);
			for (ChiTietHoaDonBanHang ctbh : listCTBH) {
				SanPham sp = sanphamDAO.laySanPhamTheoMa(ctbh.getSanPham().getMaSanPham());
				tongTien += sp.getGiaSanPham() * ctbh.getSoLuong();
				System.out.println(tongTien);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(tongTien);
		return tongTien;
	}
	
	public void showTableCTHDBH(String ma) {
		ChiTietBanHangDAO chiTietBanHangDAO;
		try {
			chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			
			int num = 1;
			List<ChiTietHoaDonBanHang> listCTHDBH = null;
			try {
				listCTHDBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaHDBH(ma);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (ChiTietHoaDonBanHang cthdbh : listCTHDBH) {
				
				String maSP = cthdbh.getSanPham().getMaSanPham();
				SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
				double thanhTien = cthdbh.getSoLuong() * sp.getGiaSanPham();
				model.addRow(new Object[] { num, cthdbh.getSanPham().getMaSanPham(),
						sp.getTenSanPham(), sp.getKichThuoc(),
						sp.getMauSac(), loai.getTenLoai(),
						cthdbh.getSoLuong(), sp.getGiaSanPham(), thanhTien, "mua mới" });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
