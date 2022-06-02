package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import com.toedter.calendar.JDateChooser;

import dao.ChiTietBanHangDAO;
import dao.ChiTietNhapKhoDAO;
import dao.GenerateKeyDAO;
import dao.HoaDonBanHangDAO;
import dao.HoaDonNhapKhoDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.HoaDonBanHang;
import entity.HoaDonNhapKho;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyKho extends JPanel {

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
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private DefaultTableModel model;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	List<ChiTietHoaDonNhapKho> listCTNhapKhoDAO;
	private JTable tableCTHDKho;
	private JDateChooser dateChooser;
	private JTextField txtTenNV;

	/**
	 * Create the panel.
	 */
	public QuanLyKho() {
		// ----------------------------------------------------------------------------------------------------------------------------------------
		// Chá»©c nÄƒng quáº£n lĂ½ kho

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(240, 0, 1298, 839);

		JLabel lblQuanLyKho = new JLabel("Quản lý kho");
		lblQuanLyKho.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyKho.setBounds(20, 21, 358, 60);
		add(lblQuanLyKho);

		JScrollPane scrollPaneCTKho = new JScrollPane();
		scrollPaneCTKho.setBounds(20, 495, 790, 236);
		add(scrollPaneCTKho);

		tableCTHDKho = new JTable();
		scrollPaneCTKho.setViewportView(tableCTHDKho);
		tableCTHDKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableCTHDKho.setBackground(Color.WHITE);
		tableCTHDKho.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"K\u00EDch th\u01B0\u1EDBc", "M\u00E0u", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1",
						"Th\u00E0nh ti\u1EC1n", "Ghi ch\u00FA" }));

		tableCTHDKho.setAutoCreateRowSorter(true);
		tableCTHDKho.setRowHeight(tableCTHDKho.getRowHeight() + 10);
		tableCTHDKho.setDefaultEditor(Object.class, null);

		JLabel lblBangHDKho = new JLabel("BẢNG HÓA ĐƠN ");
		lblBangHDKho.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBangHDKho.setBounds(20, 110, 250, 34);
		add(lblBangHDKho);

		JLabel lblBangCTHDKho = new JLabel("BẢNG CHI TIẾT NHẬP KHO");
		lblBangCTHDKho.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBangCTHDKho.setBounds(20, 451, 358, 34);
		add(lblBangCTHDKho);

		JScrollPane scrollPaneKho = new JScrollPane();
		scrollPaneKho.setBounds(20, 160, 790, 240);
		add(scrollPaneKho);

		tableHDKho = new JTable();
		tableHDKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableHDKho.getSelectedRow();
				String maHD = tableHDKho.getValueAt(row, 1).toString();
				model = (DefaultTableModel) tableCTHDKho.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				/*
				 * if (tableCTHDBanHang.getRowCount() != 0) { for (int i = 0; i <=
				 * tableCTHDBanHang.getRowCount(); i++) { model.removeRow(i); } } else
				 */
				showTableCTHDNK(maHD);
			}
		});

		tableHDKho.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Nh\u00E2n vi\u00EAn",
						"Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng ti\u1EC1n", "Ghi ch\u00FA" }));
		scrollPaneKho.setViewportView(tableHDKho);
		tableHDKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableHDKho.setBackground(Color.WHITE);

		tableHDKho.setAutoCreateRowSorter(true);
		tableHDKho.setRowHeight(tableHDKho.getRowHeight() + 10);
		tableHDKho.setDefaultEditor(Object.class, null);

		model = (DefaultTableModel) tableHDKho.getModel();
		showTable();

		/*
		 * pAnBoLocHDBH = new JPanel(); pAnBoLocHDBH.setBackground(Color.WHITE);
		 * pAnBoLocHDBH.setBounds(907, 430, 300, 301); pQuanLyHoaDon.add(pAnBoLocHDBH);
		 * pAnBoLocHDBH.setLayout(null);
		 */

		pBoLocHDKho = new JPanel();
		pBoLocHDKho.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pBoLocHDKho.setBackground(Color.WHITE);
		pBoLocHDKho.setBounds(877, 451, 320, 280);
		add(pBoLocHDKho);
		pBoLocHDKho.setLayout(null);

		JLabel lblNgayLapHoaDonKho = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHoaDonKho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHoaDonKho.setBounds(10, 20, 139, 35);
		pBoLocHDKho.add(lblNgayLapHoaDonKho);

		// Combobox tĂªn nhĂ¢n nháº­p hĂ³a Ä‘Æ¡n

		JLabel lblTenNhanVienNhapKho = new JLabel("Mã nhân viên");
		lblTenNhanVienNhapKho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNhanVienNhapKho.setBounds(10, 75, 125, 35);
		pBoLocHDKho.add(lblTenNhanVienNhapKho);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(170, 20, 140, 35);
		pBoLocHDKho.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTenNV.getText().equals("") && !dateChooser.getDate().equals(null))
					timkiemTheoThoiGian();
				else if (!txtTenNV.getText().equals("") && dateChooser.getDate().equals(null)) {
					timkiemTheoTenNV();
				} else if (!txtTenNV.getText().equals("") && !dateChooser.getDate().equals(null)) {
					timkiemTheoThoiGian();
					timkiemTheoTenNV();
				}
			}
		});
		btnTimKiem.setIcon(new ImageIcon(QuanLyKho.class.getResource("/img/icons8_search_40px.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiem.setBounds(65, 145, 197, 50);
		pBoLocHDKho.add(btnTimKiem);

		JButton btnXaBLc = new JButton("Xóa bộ lọc");
		btnXaBLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenNV.setText("");
				dateChooser.setDate(null);

				xoaHetDuLieuTrenTableModel();
				showTable();
			}

		});
		btnXaBLc.setIcon(new ImageIcon(QuanLyKho.class.getResource("/img/cancel.png")));
		btnXaBLc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXaBLc.setBounds(65, 205, 197, 50);
		pBoLocHDKho.add(btnXaBLc);

		txtTenNV = new JTextField();
		txtTenNV.setBounds(170, 75, 140, 35);
		pBoLocHDKho.add(txtTenNV);
		txtTenNV.setColumns(10);

		JButton btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemHoaDonNhapKho gui = null;
					gui = new ThemHoaDonNhapKho();
				gui.setVisible(true);
				gui.setLocationRelativeTo(null);
				gui.setAlwaysOnTop(true);
				gui.setResizable(false);
			}
		});
		btnThemHD.setBackground(Color.CYAN);
		btnThemHD.setIcon(new ImageIcon(QuanLyKho.class.getResource("/img/icons8_add_list_40px.png")));
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemHD.setBounds(908, 195, 240, 60);
		add(btnThemHD);

		JButton btnCpNhtHa = new JButton("Cập nhật hóa đơn");
		btnCpNhtHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CapNhatHoaDonNhapKho gui = null;
			
					try {
						gui = new CapNhatHoaDonNhapKho();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				gui.setVisible(true);
				gui.setLocationRelativeTo(null);
				gui.setAlwaysOnTop(true);
				gui.setResizable(false);

				int row = tableHDKho.getSelectedRow();
				String ma = tableHDKho.getValueAt(row, 1).toString();
				String maNV = tableHDKho.getValueAt(row, 2).toString();
				String ngay = tableHDKho.getValueAt(row, 3).toString();


					try {
						HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
						NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
						
						HoaDonNhapKho nk = hoaDonNhapKhoDAO.layHoaDonNhapKhoTheoMa(ma);
						gui.layMaHDKho(ma, df.parse(ngay), nk.getNhanVienBanHang().getMaNhanVien());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnCpNhtHa.setIcon(new ImageIcon(QuanLyKho.class.getResource("/img/icons8_update_40px_2.png")));
		btnCpNhtHa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCpNhtHa.setBackground(Color.CYAN);
		btnCpNhtHa.setBounds(908, 295, 240, 60);
		add(btnCpNhtHa);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHetDuLieuTrenTableModel();
				model = (DefaultTableModel) tableHDKho.getModel();
				showTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(725, 141, 85, 21);
		add(btnNewButton);
	}

	protected void timkiemTheoThoiGian() {
		HoaDonNhapKhoDAO hoaDonNhapKhoDAO;
		try {
			hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			Date date = dateChooser.getDate();
			df = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
			int num = 1;
			List<HoaDonNhapKho> listHDNK = hoaDonNhapKhoDAO.layDanhSachHoaDonNhapKhoTheoNgay(df.format(date));
			xoaHetDuLieuTrenTableModel();
			for (HoaDonNhapKho hdnk : listHDNK) {
				Date day = hdnk.getNgayNhapKho();
				double tongTien = tinhTongTienHoaDonNhapKho(hdnk.getMaHoaDonNhapKho());
				model.addRow(new Object[] { num, hdnk.getMaHoaDonNhapKho(), hdnk.getNhanVienBanHang().getMaNhanVien(),
						df.format(day), tongTien });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void timkiemTheoTenNV() {
		HoaDonNhapKhoDAO hoaDonNhapKhoDAO;
		try {
			hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			String ma = txtTenNV.getText();
			int num = 1;
			List<HoaDonNhapKho> listHDNK = hoaDonNhapKhoDAO.layDanhSachHoaDonNhapKhoTheoMaNhanVien(ma);
			xoaHetDuLieuTrenTableModel();
			for (HoaDonNhapKho hdnk : listHDNK) {
				Date day = hdnk.getNgayNhapKho();
				double tongTien = tinhTongTienHoaDonNhapKho(hdnk.getMaHoaDonNhapKho());
				model.addRow(new Object[] { num, hdnk.getMaHoaDonNhapKho(), hdnk.getNhanVienBanHang().getMaNhanVien(),
						df.format(day), tongTien });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableHDKho.getModel();
		dm.getDataVector().removeAllElements();
	}

	/*
	 * public void showcomboData() { for (HoaDonNhapKho hdnk : listHDNK) {
	 * cboMaHD.addItem(hdbh.getMaHoaDonBanHang()); } }
	 */

	public void showTable() {
		HoaDonNhapKhoDAO hoaDonNhapKhoDAO;
		try {
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			int num = 1;
			List<HoaDonNhapKho> listHDNK = hoaDonNhapKhoDAO.layTatCaHoaDonNhapKho();
			for (HoaDonNhapKho hdnk : listHDNK) {
				Date day = hdnk.getNgayNhapKho();
				double tongTien = tinhTongTienHoaDonNhapKho(hdnk.getMaHoaDonNhapKho());
				NhanVienBanHang nv= nhanVienDAO.layNhanVienTheoMa(hdnk.getNhanVienBanHang().getMaNhanVien());
				model.addRow(new Object[] { num, hdnk.getMaHoaDonNhapKho(), nv.getTenNhanVien(),
						df.format(day), tongTien });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double tinhTongTienHoaDonNhapKho(String maHDNK) {
		ChiTietNhapKhoDAO chiTietNhapKhoDAO = null;
		double tongTien = 0;
		try {
			chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			for (ChiTietHoaDonNhapKho ctnk : chiTietNhapKhoDAO.layDanhSachCTHoaDonNhapKhoTheoMaHDBH(maHDNK)) {
				tongTien += ctnk.getGiaNhap() * ctnk.getSoLuong();
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return tongTien;
	}

	public void showTableCTHDNK(String ma) {
		ChiTietNhapKhoDAO chiTietNhapKhoDAO = null;
		try {
			chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			int num = 1;
			List<ChiTietHoaDonNhapKho> listCTHDNK = chiTietNhapKhoDAO.layDanhSachCTHoaDonNhapKhoTheoMaHDBH(ma);
			
			for (ChiTietHoaDonNhapKho cthdnk : listCTHDNK) {
				double thanhTien = cthdnk.getSoLuong() * cthdnk.getGiaNhap();
				String maSP = cthdnk.getSanPham().getMaSanPham();
				SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
				model.addRow(new Object[] { num, cthdnk.getSanPham().getMaSanPham(),
						sp.getTenSanPham(), sp.getKichThuoc(),
						sp.getMauSac(), loai.getTenLoai(),
						cthdnk.getSoLuong(), cthdnk.getGiaNhap(), thanhTien, "mua mới" });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
