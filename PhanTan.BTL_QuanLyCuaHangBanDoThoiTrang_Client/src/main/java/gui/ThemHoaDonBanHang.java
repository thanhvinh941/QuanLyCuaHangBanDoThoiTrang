package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.SessionFactory;

import dao.ChiTietBanHangDAO;
import dao.ChuCuaHangDAO;
import dao.GenerateKeyDAO;
import dao.HangSanXuatDAO;
import dao.HoaDonBanHangDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import dao_imp.ChiTietBanHangImp;
import dao_imp.ChuCuaHangImp;
import dao_imp.GenerateKeyImp;
import dao_imp.HoaDonBanHangImp;
import dao_imp.KhachHangImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import dao_imp.SanPhamImp;
import dao_imp.TaiKhoanImp;
import entity.ChiTietHoaDonBanHang;
import entity.ChuCuaHang;
import entity.HangSanXuat;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThemHoaDonBanHang extends JFrame {

	private JPanel contentPane;
	private JPanel pThemHDBH;
	private JTable tableSanPham;
	private JTable tableChiTietHDBH;
	private JTextField txtSL;
	private JTextField txtCapnhatSL;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel model;
	private JTextField txtTienKhachDua;
	private JLabel lblTongTien;
	private JLabel lblTenKH;
	private JLabel lblTienTraLai;
	private JLabel lblDonViTien;
	private JLabel lblDonViTien1;
	private JLabel lblMaHD;
	private JLabel lblNgay;
	private JLabel lblTenNV;
	private JTextField txtLuaChonKhachHang;
	private JPanel pThongTinHDBH;
	private JLabel lblLoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHoaDonBanHang frame = new ThemHoaDonBanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemHoaDonBanHang() {
		//setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pThemHDBH = new JPanel();
		pThemHDBH.setBounds(0, 0, 1550, 860);
		pThemHDBH.setLayout(null);
		pThemHDBH.setBackground(new Color(127, 255, 212));
		contentPane.add(pThemHDBH);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(15, 250, 640, 291);
		pThemHDBH.add(scrollPaneSanPham);

		tableSanPham = new JTable();
		tableSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableSanPham.getSelectedRow();
				int soLuong = (int) tableSanPham.getValueAt(row, 6);
				txtSL.setText("1");
				txtSL.selectAll();
				txtSL.requestFocus();
			}
		});
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneSanPham.setViewportView(tableSanPham);
		tableSanPham.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"H\u00E3ng s\u1EA3n xu\u1EA5t", "Lo\u1EA1i", "Size", "M\u00E0u", "S\u1ED1 l\u01B0\u1EE3ng",
						"Gi\u00E1" }));
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(0).setMinWidth(10);
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(4).setMinWidth(10);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(6).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(7).setPreferredWidth(15);
		tableSanPham.setDefaultEditor(Object.class, null);

		model = (DefaultTableModel) tableSanPham.getModel();
		showTableSanPham();

		// Combobox hãng sản xuất
		JComboBox cboHangSanXuat = new JComboBox();
		cboHangSanXuat.setEditable(true);
		cboHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboHangSanXuat.setBounds(128, 110, 120, 35);
		pThemHDBH.add(cboHangSanXuat);

		JLabel lblMaSP;
		lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(15, 110, 90, 35);
		pThemHDBH.add(lblMaSP);

		// Combobox loại sản phẩm
		JComboBox cboLoaiSP = new JComboBox();
		cboLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboLoaiSP.setModel(new DefaultComboBoxModel(new String[] { "Áo thun", "Áo khoác", "Áo len" }));
		cboLoaiSP.setBounds(403, 110, 120, 35);
		pThemHDBH.add(cboLoaiSP);

		JLabel lblLoaiSP;
		lblLoaiSP = new JLabel("Loại sản phẩm");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP.setBounds(288, 110, 90, 35);
		pThemHDBH.add(lblLoaiSP);

		JButton btnTimSP = new JButton("Tìm kiếm");
		btnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimSP.setBounds(15, 165, 190, 50);
		pThemHDBH.add(btnTimSP);

		JLabel lblNewLabel_13 = new JLabel("Thêm hóa đơn bán hàng");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_13.setBounds(20, 21, 459, 60);
		pThemHDBH.add(lblNewLabel_13);

		JButton btnNewButton_1 = new JButton("Xóa tất cả bộ lọc");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/cancel.png")));
		btnTimSP.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_search_40px.png")));
		btnNewButton_1.setBounds(230, 165, 190, 50);
		pThemHDBH.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(665, 0, 1500, 800);
		pThemHDBH.add(panel);
		panel.setLayout(null);

		JLabel lblHoaDonBanHang = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblHoaDonBanHang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblHoaDonBanHang.setBounds(262, 10, 339, 53);
		panel.add(lblHoaDonBanHang);

		JLabel lblHangSanXuat_1 = new JLabel("Số cmnd hoặc số điên thoại:");
		lblHangSanXuat_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHangSanXuat_1.setBounds(10, 100, 263, 35);
		panel.add(lblHangSanXuat_1);

		JLabel lblHangSanXuat_1_1 = new JLabel("Tên khách hàng");
		lblHangSanXuat_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHangSanXuat_1_1.setBounds(10, 150, 122, 35);
		panel.add(lblHangSanXuat_1_1);

		JLabel lblHangSanXuat_1_2 = new JLabel("Tên nhân viên");
		lblHangSanXuat_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHangSanXuat_1_2.setBounds(10, 200, 106, 35);
		panel.add(lblHangSanXuat_1_2);

		JLabel lblNewLabel = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(460, 73, 97, 13);
		panel.add(lblNewLabel);

		lblNgay = new JLabel("");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgay.setBounds(572, 73, 143, 13);
		panel.add(lblNgay);
		lblNgay.setText(df.format(new java.util.Date()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 815, 282);
		panel.add(scrollPane);

		tableChiTietHDBH = new JTable();
		tableChiTietHDBH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int soLuong = (int) tableChiTietHDBH.getValueAt(row, 7);
				txtCapnhatSL.setText(String.valueOf(soLuong));

			}
		});
		tableChiTietHDBH.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableChiTietHDBH.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"H\u00E3ng s\u1EA3n xu\u1EA5t", "Lo\u1EA1i", "Size", "M\u00E0u", "S\u1ED1 l\u01B0\u1EE3ng",
						"Gi\u00E1", "Th\u00E0nh ti\u1EC1n" }));
		tableChiTietHDBH.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableChiTietHDBH.getColumnModel().getColumn(1).setPreferredWidth(75);
		tableChiTietHDBH.getColumnModel().getColumn(4).setPreferredWidth(35);
		tableChiTietHDBH.getColumnModel().getColumn(7).setPreferredWidth(35);
		scrollPane.setViewportView(tableChiTietHDBH);
		tableChiTietHDBH.setDefaultEditor(Object.class, null);

		JLabel lblHangSanXuat_1_3 = new JLabel("Tổng tiền:");
		lblHangSanXuat_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHangSanXuat_1_3.setBounds(10, 550, 106, 35);
		panel.add(lblHangSanXuat_1_3);

		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBounds(196, 550, 129, 35);
		panel.add(lblTongTien);

		JButton btnThemSPVaoHDBH_1 = new JButton("Hoàn thành");
		btnThemSPVaoHDBH_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowTableSP = tableSanPham.getSelectedRow();
				int rowTableCTHDBH = tableChiTietHDBH.getSelectedRow();

				// Lưu thông tin hóa đơn
				KhachHang kh;
				String maHD = lblMaHD.getText();
				double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
				String thongtinKH = txtLuaChonKhachHang.getText();
				String maKH = "";
				if (thongtinKH.length() == 10 || thongtinKH.length() == 11) {
					try {
						KhachHangDAO khachHangDAO;
						try {
							khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
							kh = (KhachHang) khachHangDAO.layKhachHangTheoDienthoai(thongtinKH);
							maKH = kh.getMaKhachHang();
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				} else if (thongtinKH.length() == 9 || thongtinKH.length() == 12) {
					try {
						KhachHangDAO khachHangDAO;
						try {
							khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
							kh = (KhachHang) khachHangDAO.layKhachhangTheoCMND(thongtinKH);
							maKH = kh.getMaKhachHang();
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

				KhachHang khachHang = new KhachHang(maKH);

				/*
				 * NhanVienBanHang nv = (NhanVienBanHang)
				 * nhanVienDAO.layDanhSachNhanVienTheoTen(lblTenNV.getText()); String maNV =
				 * nv.getMaNhanVien(); NhanVienBanHang nhanVien = new NhanVienBanHang(maNV);
				 */

				ChuCuaHang cch;
				try {
					ChuCuaHangDAO chucuahangDAO = null;
					try {
						chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					} catch (MalformedURLException | NotBoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					cch = chucuahangDAO.layThongTinChuCuaHang();
					String maCCH = cch.getMaChuCuaHang();
					ChuCuaHang chu = new ChuCuaHang(maCCH);

					String ngay = lblNgay.getText();
					NhanVienDAO nhanVienDAO = null;
					try {
						nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					} catch (MalformedURLException | NotBoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(maCCH);
					String maNV = nv.getMaNhanVien();
					NhanVienBanHang nhanVien = new NhanVienBanHang(maNV);

					try {
						HoaDonBanHang hdbh = new HoaDonBanHang(maHD, df.parse(ngay), "Mua mới", tienKhachDua, khachHang, nhanVien, chu);
						HoaDonBanHangDAO hoaDonBanHangDAO = null;
						try {
							hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						boolean rs = hoaDonBanHangDAO.themHoaDonBanHang(hdbh);
						luuThongTinChiTietHDBH();
						capnhatSanPham();
						if (rs) {
							JOptionPane.showMessageDialog(rootPane, "Tạo hóa đơn  thành công");
						} else
							JOptionPane.showMessageDialog(rootPane, "Tạo mới hóa đơn không thành công");
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Lưu thông tin chi tiết hóa đơn
					// String maCTHD = (String) tableChiTietHDBH.getValueAt(rowTableCTHDBH, 1);

					// Cập nhật lại số lượng sản phẩm
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				

			}
		});
		btnThemSPVaoHDBH_1
				.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_checked_checkbox_40px.png")));
		btnThemSPVaoHDBH_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemSPVaoHDBH_1.setBounds(559, 544, 172, 50);
		panel.add(btnThemSPVaoHDBH_1);

		JButton btnCapNhatSoLuong = new JButton("Cập nhật");
		btnCapNhatSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int sl = (int) tableChiTietHDBH.getValueAt(row, 7);
				int capnhatSL = Integer.parseInt(txtCapnhatSL.getText());
				int capnhatSlChoBangSP = (int) tableChiTietHDBH.getValueAt(row, 7) - capnhatSL;
				int num = tableSanPham.getRowCount();
				String maSP = tableChiTietHDBH.getValueAt(row, 1).toString();
				try {
					SanPhamDAO sanphamDAO = null;
					try {
						sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					} catch (MalformedURLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (capnhatSL >= 1 && capnhatSlChoBangSP > 0) {
					tableChiTietHDBH.setValueAt(capnhatSL, row, 7);
					double capnhatThanhTien = capnhatSL * (double) tableChiTietHDBH.getValueAt(row, 8);
					tableChiTietHDBH.setValueAt(capnhatThanhTien, row, 9);
					if (kiemtraDongChuaMaSP(maSP) != -1) {
						int n = kiemtraDongChuaMaSP(maSP);
						tableSanPham.setValueAt((int) tableSanPham.getValueAt(n, 6) + capnhatSlChoBangSP, n, 6);
						// int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
						// tableSanPham.setValueAt(newSoLuong, row, 6);
						// tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(row, 7)*
						// (double) tableChiTietHDBH.getValueAt(row, 8), n, 9);
						// double capnhatTongTien = tableChiTietHDBH.getValueAt(row, 7)
						lblTongTien.setText(String.valueOf(tinhTongTien()));
					}
				}
			}
		});
		btnCapNhatSoLuong.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_update_40px_2.png")));
		btnCapNhatSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhatSoLuong.setBounds(682, 192, 143, 50);
		panel.add(btnCapNhatSoLuong);

		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenNV.setBounds(262, 200, 183, 35);
		panel.add(lblTenNV);

		ChuCuaHang cch;
		try {
			ChuCuaHangDAO chucuahangDAO = null;
			try {
				chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
			} catch (MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cch = chucuahangDAO.layThongTinChuCuaHang();
			lblTenNV.setText(cch.getTenChuCuaHang());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		lblTenKH = new JLabel("");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenKH.setBounds(262, 150, 183, 35);
		panel.add(lblTenKH);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				GDChucnangQLBanHang gui = null;
				try {
					gui = new GDChucnangQLBanHang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				QuanLyBanHang qlbh = null;
				try {
					qlbh = new QuanLyBanHang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gui.setVisible(true);
				try {
					qlbh.showTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThoat.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/cancel.png")));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(559, 682, 172, 50);
		panel.add(btnThoat);

		//showComboBox();

		JPanel pThemMoiKhachHang = new JPanel();
		pThemMoiKhachHang.setBorder(new TitledBorder(null,
				"Th\u00EAm m\u1EDBi kh\u00E1ch h\u00E0ng n\u1EBFu ch\u01B0a c\u00F3 trong h\u1EC7 th\u1ED1ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThemMoiKhachHang.setBounds(506, 113, 319, 64);
		panel.add(pThemMoiKhachHang);
		pThemMoiKhachHang.setLayout(null);

		JButton btnNewButton_2 = new JButton("Thêm mới khách hàng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ThemMoiKhachHangTrongHoaDon themKH = new ThemMoiKhachHangTrongHoaDon();
				themKH.setVisible(true);
				themKH.setLocationRelativeTo(null);
				themKH.setAlwaysOnTop(true);
				themKH.setResizable(false);

				//DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cboLuaChonKH.getModel();
				//model.addElement(generateKeyDAO.getKey("KhachHang"));

				// display();
			}
		});
		btnNewButton_2.setBounds(62, 20, 215, 35);
		pThemMoiKhachHang.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblHangSanXuat_1_3_1 = new JLabel("Tiền khách đưa:");
		lblHangSanXuat_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHangSanXuat_1_3_1.setBounds(10, 600, 172, 35);
		panel.add(lblHangSanXuat_1_3_1);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
				double tongTien = Double.parseDouble(lblTongTien.getText());
				double tienTraLai = tienKhachDua - tongTien;
				System.out.println(tienTraLai);
				if (tienTraLai < 0) {
					txtTienKhachDua.selectAll();
					txtTienKhachDua.requestFocus();
					JOptionPane.showMessageDialog(rootPane, "Số tiền mà khách hàng trả không đủ");
				} else {
					lblTienTraLai.setText(String.valueOf(tienTraLai));
					lblDonViTien1.setText("VND");
				}
			}
		});
		/*
		 * txtTienKhachDua.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() ==
		 * KeyEvent.VK_ENTER) { double tienKhachDua =
		 * Double.parseDouble(txtTienKhachDua.getText()); double tongTien =
		 * Double.parseDouble(lblTongTien.getText()); double tienTraLai = tienKhachDua -
		 * tongTien; System.out.println(tienTraLai); if (tienTraLai < 0) {
		 * txtTienKhachDua.selectAll(); txtTienKhachDua.requestFocus();
		 * lblTongTien.setText(""); //JOptionPane.showMessageDialog(null,
		 * "Số tiền mà khách hàng trả không đủ"); } else {
		 * lblTienTraLai.setText(String.valueOf(tienTraLai));
		 * lblDonViTien1.setText("VND"); } } } });
		 */
		txtTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienKhachDua.setBounds(196, 600, 129, 35);
		panel.add(txtTienKhachDua);
		txtTienKhachDua.setColumns(10);

		JLabel lblHangSanXuat_1_3_1_1 = new JLabel("Tiền trả lại:");
		lblHangSanXuat_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHangSanXuat_1_3_1_1.setBounds(10, 650, 172, 35);
		panel.add(lblHangSanXuat_1_3_1_1);

		lblTienTraLai = new JLabel("");
		lblTienTraLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienTraLai.setBounds(196, 650, 129, 35);
		panel.add(lblTienTraLai);

		JLabel lblHangSanXuat_1_3_1_1_1 = new JLabel("Hình thức thanh toán:");
		lblHangSanXuat_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHangSanXuat_1_3_1_1_1.setBounds(10, 700, 246, 35);
		panel.add(lblHangSanXuat_1_3_1_1_1);

		lblDonViTien = new JLabel("");
		lblDonViTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonViTien.setBounds(330, 550, 45, 35);
		panel.add(lblDonViTien);

		lblDonViTien1 = new JLabel("");
		lblDonViTien1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonViTien1.setBounds(330, 650, 45, 35);
		panel.add(lblDonViTien1);

		JLabel lblVnd = new JLabel("VND");
		lblVnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVnd.setBounds(330, 600, 45, 35);
		panel.add(lblVnd);

		JLabel lblMHan = new JLabel("Mã hóa đơn:");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMHan.setBounds(10, 74, 81, 13);
		panel.add(lblMHan);

		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaHD.setBounds(101, 74, 97, 13);
		panel.add(lblMaHD);
		lblMaHD.setText(taoMa());
		/*try {
			GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
			lblMaHD.setText(generateKeyDAO.getKey("HoaDonBanHang"));
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		txtLuaChonKhachHang = new JTextField();
		txtLuaChonKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nhap = txtLuaChonKhachHang.getText();
				KhachHang kh;
				if (nhap.length() == 10 || nhap.length() == 11) {
					try {
						KhachHangDAO khachHangDAO = null;
						try {
							khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						kh = khachHangDAO.layKhachHangTheoDienthoai(nhap);
						lblTenKH.setText(kh.getTenKhachHang());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else if (nhap.length() == 9 || nhap.length() == 12) {
					try {
						KhachHangDAO khachHangDAO = null;
						try {
							khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						kh = khachHangDAO.layKhachhangTheoCMND(nhap);
						lblTenKH.setText(kh.getTenKhachHang());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				if (lblTenKH.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu ");

			}
		});
		txtLuaChonKhachHang.setBounds(262, 100, 183, 35);
		panel.add(txtLuaChonKhachHang);
		txtLuaChonKhachHang.setColumns(10);

		txtCapnhatSL = new JTextField();
		txtCapnhatSL.setBounds(576, 200, 96, 35);
		panel.add(txtCapnhatSL);
		txtCapnhatSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCapnhatSL.setColumns(10);

		JLabel lblNewLabel_3_1_1 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1.setBounds(484, 208, 82, 18);
		panel.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int sl = (int) tableChiTietHDBH.getValueAt(row, 7);
				String maSP = tableChiTietHDBH.getValueAt(row, 1).toString();
				try {
					SanPhamDAO sanphamDAO = null;
					try {
						sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					} catch (MalformedURLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.removeRow(row);
				if (kiemtraDongChuaMaSP(maSP) != -1) {
					int n = kiemtraDongChuaMaSP(maSP);
					tableSanPham.setValueAt((int) tableSanPham.getValueAt(n, 6) + sl, n, 6);
					// int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
					// tableSanPham.setValueAt(newSoLuong, row, 6);
					// tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(row, 7)*
					// (double) tableChiTietHDBH.getValueAt(row, 8), n, 9);
					// double capnhatTongTien = tableChiTietHDBH.getValueAt(row, 7)
					lblTongTien.setText(String.valueOf(tinhTongTien()));
					int num = tableChiTietHDBH.getRowCount();
					for(int i = 0; i < num; i++) {
						tableChiTietHDBH.setValueAt(i + 1, i, 0);
					}
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_trash_40px.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(559, 611, 172, 50);
		panel.add(btnXoa);
		
		pThongTinHDBH = new JPanel();
		pThongTinHDBH.setBounds(0, 53, 1500, 807);
		
		pThongTinHDBH.setBackground(new Color(127, 255, 212));
		pThongTinHDBH.setLayout(null);
		panel.add(pThongTinHDBH);
		
		JPanel pThongTinKH = new JPanel();
		pThongTinKH.setBounds(0, 66, 835, 689);
		pThongTinKH.setLayout(null);
		//panel.add(pThongTinKH);

		JButton btnThemSPVaoHDBH = new JButton("Thêm vào hóa đơn");
		btnThemSPVaoHDBH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableSanPham.getSelectedRow();
				String maSP = tableSanPham.getValueAt(row, 0).toString();
				SanPham sp;
				try {
					SanPhamDAO sanphamDAO = null;
					try {
						sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					} catch (MalformedURLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sp = sanphamDAO.laySanPhamTheoMa(maSP);
					int num = tableChiTietHDBH.getRowCount();
					int sl = Integer.parseInt(txtSL.getText());
					System.out.println(sl);
					double thanhTien = sl * sp.getGiaSanPham();
					model = (DefaultTableModel) tableChiTietHDBH.getModel();
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
					LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());

					if (kiemtraSoLuongMua(sl, row)) {
						if (num == 0) {
							model.addRow(new Object[] { num + 1, sp.getMaSanPham(), sp.getTenSanPham(),
									hsx.getTenHangSanXuat(), loai.getTenLoai(),
									sp.getKichThuoc(), sp.getMauSac(), sl, sp.getGiaSanPham(), thanhTien });
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							lblTongTien.setText(String.valueOf(tinhTongTien()));
							lblDonViTien.setText("VND");
						} else if (kiemtraMaSP(maSP) == -1) {
							model.addRow(new Object[] { num + 1, sp.getMaSanPham(), sp.getTenSanPham(),
									hsx.getTenHangSanXuat(), loai.getTenLoai(),
									sp.getKichThuoc(), sp.getMauSac(), sl, sp.getGiaSanPham(), thanhTien });
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							lblTongTien.setText(String.valueOf(tinhTongTien()));
						} else if (kiemtraMaSP(maSP) != -1) {
							int n = kiemtraMaSP(maSP);
							
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(n, 7) + sl, n, 7);
							
							//Cập nhật lại số lượng cho bảng sản phẩm
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							
							double thanhTienNew = (int) tableChiTietHDBH.getValueAt(n, 7)
									* (double) tableChiTietHDBH.getValueAt(row, 8);
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(n, 7) * sp.getGiaSanPham(), n, 9);
							
							lblTongTien.setText(String.valueOf(tinhTongTien()));
							
							
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		btnThemSPVaoHDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSPVaoHDBH.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_add_list_40px.png")));
		btnThemSPVaoHDBH.setBounds(414, 585, 210, 50);
		pThemHDBH.add(btnThemSPVaoHDBH);

		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSL.setBounds(184, 595, 96, 35);
		pThemHDBH.add(txtSL);
		txtSL.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nhập số lượng cần mua:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(15, 585, 159, 50);
		pThemHDBH.add(lblNewLabel_2);
		
		lblLoi = new JLabel("");
		lblLoi.setForeground(Color.RED);
		lblLoi.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblLoi.setBounds(15, 673, 640, 50);
		pThemHDBH.add(lblLoi);
	}

	private static void display() {
		String[] items = { "One", "Two", "Three", "Four", "Five" };
		JComboBox<String> combo = new JComboBox<>(items);
		JTextField field1 = new JTextField("1234.56");
		JTextField field2 = new JTextField("9876.54");
		JPanel panel = new JPanel();
		panel.add(combo);
		panel.add(new JLabel("Field 1:"));
		panel.add(field1);
		panel.add(new JLabel("Field 2:"));
		panel.add(field2);
		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println(combo.getSelectedItem() + " " + field1.getText() + " " + field2.getText());
		} else {
			System.out.println("Cancelled");
		}
	}

	public void showTableCTHDBH(String ma) {
		int num = 1;
		List<ChiTietHoaDonBanHang> listCTHDBH;
		try {
			ChiTietBanHangDAO chiTietBanHangDAO = null;
			try {
				chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			} catch (MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listCTHDBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaSP(ma);
			for (ChiTietHoaDonBanHang cthdbh : listCTHDBH) {
				double thanhTien = cthdbh.getSoLuong() * cthdbh.getSanPham().getGiaSanPham();
				model.addRow(new Object[] { num, cthdbh.getSanPham().getMaSanPham(), cthdbh.getSanPham().getTenSanPham(),
						cthdbh.getSanPham().getKichThuoc(), cthdbh.getSanPham().getMauSac(),
						cthdbh.getSanPham().getLoaiSanPham(), cthdbh.getSoLuong(), cthdbh.getSanPham().getGiaSanPham(),
						thanhTien });
				num++;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showTableSanPham() {
		int num = 1;
		List<SanPham> listSP;
		try {
			SanPhamDAO sanphamDAO = null;
			try {
				sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			} catch (MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listSP = sanphamDAO.layTatCaSanPhamKhacKhong();
			for (SanPham sp : listSP) {
				model.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), sp.getHangSanXuat().getMaHangSanXuat(),
						sp.getLoaiSanPham().getMaLoaiSanPham(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(),
						sp.getGiaSanPham() });
				num++;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*private void showComboBox() {
		List<KhachHang> listKH = khachHangDAO.layTatCaKhachHang();
		for (KhachHang kh : listKH) {
			model.addElement(kh.getMaKhachHang());

		}
	}*/

	private int kiemtraMaSP(String ma) {
		int row = tableChiTietHDBH.getRowCount();
		int n = -1;
		for (int i = 0; i < row; i++) {
			if (tableChiTietHDBH.getValueAt(i, 1).toString().equalsIgnoreCase(ma)) {
				n = i;
				break;
			}
		}
		return n;
	}

	private void luuThongTinChiTietHDBH() {
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			String maSP = tableChiTietHDBH.getValueAt(i, 1).toString();
			SanPham sp = new SanPham(maSP);
			String maHD = lblMaHD.getText();
			HoaDonBanHang hd = new HoaDonBanHang(maHD);
			int soLuong = (int) tableChiTietHDBH.getValueAt(i, 7);

			ChiTietHoaDonBanHang cthdbh = new ChiTietHoaDonBanHang(soLuong, sp, hd);
			try {
				ChiTietBanHangDAO chiTietBanHangDAO = null;
				try {
					chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
				} catch (MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				chiTietBanHangDAO.themChiTietHoaDon(cthdbh);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(cthdbh);
		}
	}

	private void capnhatSanPham() {
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			String maSP = tableChiTietHDBH.getValueAt(i, 1).toString();
			SanPham sp;
			try {
				SanPhamDAO sanphamDAO = null;
				try {
					sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
				} catch (MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sp = sanphamDAO.laySanPhamTheoMa(maSP);
				int soLuongMua = (int) tableChiTietHDBH.getValueAt(i, 7);
				int soLuongConLai = sp.getSoLuong() - soLuongMua;
				HangSanXuat hsx = new HangSanXuat(sp.getHangSanXuat().getMaHangSanXuat());
				LoaiSanPham loai = new LoaiSanPham(sp.getLoaiSanPham().getMaLoaiSanPham());
				SanPham sanPham = new SanPham(maSP, sp.getTenSanPham(), sp.getGiaSanPham(), sp.getKichThuoc(),
						sp.getMauSac(), soLuongConLai, hsx, loai);
				// SanPham sanPham = new SanPham(maSP, soLuongConLai);
				System.out.println(sanPham);
				boolean rs = sanphamDAO.capNhatSanPham(sanPham);
				System.out.println(rs);
				/*
				 * if (rs) { JOptionPane.showMessageDialog(rootPane,
				 * "Tạo hóa đơn  thành công"); } else JOptionPane.showMessageDialog(rootPane,
				 * "Tạo mới hóa đơn không thành công");
				 */
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private boolean kiemtraSoLuongMua(int sl, int row) {
		boolean rs = false;
		sl = Integer.parseInt(txtSL.getText());
		int numMax = (int) tableSanPham.getValueAt(row, 6);
		if (numMax == 0) {
			JOptionPane.showMessageDialog(rootPane, "Lỗi: Sản phẩm đã hết, vui lòng chọn sản phẩm khác.");
			//lblLoi.setText("Lỗi: Sản phẩm đã hết, vui lòng chọn sản phẩm khác.");
			return rs;
		} else if (sl <= 0) {
			JOptionPane.showMessageDialog(rootPane, "Lỗi: Không nhập số âm hoặc số 0.");
			//lblLoi.setText("Lỗi: Không nhập số âm hoặc số 0.");
			txtSL.setText("1");
			txtSL.selectAll();
			txtSL.requestFocus();
			return rs;
		} else if (sl > numMax) {
			JOptionPane.showMessageDialog(rootPane, "Lỗi: Bạn đã nhập quá số lượng của sản phẩm.");
			//lblLoi.setText("Lỗi: Bạn đã nhập quá số lượng của sản phẩm.");
			txtSL.setText(String.valueOf(numMax));
			txtSL.selectAll();
			txtSL.requestFocus();
			return rs;
		}
		return true;
	}

	private double tinhTongTien() {
		double tongTien = 0;
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			tongTien += (double) tableChiTietHDBH.getValueAt(i, 9);
		}
		return tongTien;
	}

	public void themVaoLuaChonKh(String s) {
		txtLuaChonKhachHang.setText(s);
	}

	private int kiemtraDongChuaMaSP(String ma) {
		int row = tableSanPham.getRowCount();
		int n = -1;
		for (int i = 0; i < row; i++) {
			if (tableSanPham.getValueAt(i, 0).toString().equals(ma)) {
				n = i;
				break;
			}
		}
		return n;
	}
	
	private String taoMa() {
		String ma = "";
		try {
			int n=0;
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			List<HoaDonBanHang> listHDBH = hoaDonBanHangDAO.layTatCaHoaDonBanHang();
			for (HoaDonBanHang khachHang : listHDBH) {
				n++;
			}
			if(n < 9)
				ma = "BH00" + String.valueOf(n+1);
			else if(n > 10 && n < 99)
				ma = "BH0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
}