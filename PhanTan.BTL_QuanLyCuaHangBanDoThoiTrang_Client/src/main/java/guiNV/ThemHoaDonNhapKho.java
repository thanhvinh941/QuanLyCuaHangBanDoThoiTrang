package guiNV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.persistence.Table;
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
import dao.ChiTietNhapKhoDAO;
import dao.ChuCuaHangDAO;
import dao.GenerateKeyDAO;
import dao.HangSanXuatDAO;
import dao.HoaDonBanHangDAO;
import dao.HoaDonNhapKhoDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import dao_imp.ChiTietBanHangImp;
import dao_imp.ChiTietNhapKhoImp;
import dao_imp.ChuCuaHangImp;
import dao_imp.GenerateKeyImp;
import dao_imp.HangSanXuatImp;
import dao_imp.HoaDonBanHangImp;
import dao_imp.HoaDonNhapKhoImp;
import dao_imp.KhachHangImp;
import dao_imp.LoaiSanPhamImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import dao_imp.SanPhamImp;
import dao_imp.TaiKhoanImp;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.ChuCuaHang;
import entity.HangSanXuat;
import entity.HoaDonBanHang;
import entity.HoaDonNhapKho;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;
import entity.TaiKhoan;
import gui.GiaoDienChinh_ChuCuaHang;
import guiNV.QuanLyKho;

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

public class ThemHoaDonNhapKho extends JFrame {

	private JPanel contentPane;
	private JPanel pThemHDBH;
	private JTable tableSanPham;
	private JTable tableChiTietHDBH;
	private JTextField txtSL;
	private JTextField txtCapnhatSoLuong;
	private DefaultTableModel model;
	private JLabel lblTongTien;
	private JLabel lblDonViTien;
	private JLabel lblDonViTien1;
	private JLabel lblMaHD;
	private JLabel lblNgay;
	private JLabel lblTenNV;
	private JPanel pBoLocTK;
	private JPanel pNhapSP;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	private JTextField txtMaHSX;
	private JTextField txtTenHSX;
	private JTextField txtSDT_HSX;
	private JTextField txtDiaChi_HSX;
	private JTextField txtThanhPho_HSX;
	private JTextField txtQuocGia_HSX;
	private JPanel pNhapHSX;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTextField txtMoTaLoai;
	private JPanel pChuaNut;
	private JPanel pNhapLoaiSP;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox cboHSX;
	private JComboBox cboLoai;
	private JComboBox cboSize;
	private JComboBox cboMau;
	private JLabel lblThongBao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHoaDonNhapKho frame = new ThemHoaDonNhapKho();
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
	public ThemHoaDonNhapKho() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pThemHDBH = new JPanel();
		pThemHDBH.setBounds(0, 0, 1500, 786);
		pThemHDBH.setLayout(null);
		pThemHDBH.setBackground(new Color(127, 255, 212));
		contentPane.add(pThemHDBH);

		pBoLocTK = new JPanel();
		pBoLocTK.setBounds(0, 88, 663, 688);
		pBoLocTK.setBackground(new Color(127, 255, 212));
		pThemHDBH.add(pBoLocTK);

		pNhapSP = new JPanel();
		pNhapSP.setBounds(15, 88, 640, 528);
		pNhapSP.setBackground(new Color(127, 255, 212));
		//pThemHDBH.add(pNhapSP);
		pNhapSP.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 150, 25);
		pNhapSP.add(lblNewLabel_1);

		txtMaSP = new JTextField();
		txtMaSP.setEnabled(false);
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSP.setBounds(170, 10, 176, 25);
		pNhapSP.add(txtMaSP);
		txtMaSP.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 60, 150, 25);
		pNhapSP.add(lblNewLabel_1_1);

		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(170, 60, 176, 25);
		pNhapSP.add(txtTenSP);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hãng sản xuất:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 110, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1);

		cboHSX = new JComboBox();
		cboHSX.setBounds(170, 110, 176, 25);
		pNhapSP.add(cboHSX);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 160, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1_1);

		cboLoai = new JComboBox();
		cboLoai.setBounds(170, 160, 176, 25);
		pNhapSP.add(cboLoai);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Kích thước:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 210, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Màu sắc");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 260, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1_1_1_1);

		cboSize = new JComboBox();
		cboSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSize.setModel(new DefaultComboBoxModel(new String[] { "S", "M", "L", "XL", "XXL", "XXXL" }));
		cboSize.setBounds(170, 210, 176, 25);
		pNhapSP.add(cboSize);

		cboMau = new JComboBox();
		cboMau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboMau.setModel(new DefaultComboBoxModel(
				new String[] { "Đỏ", "Cam", "Vàng", "Xanh Dương", "Xanh Lá", "Tràm", "Tím", "Trắng ", "Đen" }));
		cboMau.setBounds(170, 260, 176, 25);
		pNhapSP.add(cboMau);

		showComboBox();

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Số lượng:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 310, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1_1_1_1_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(170, 310, 176, 25);
		pNhapSP.add(txtSoLuong);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Giá sản phẩm:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(10, 360, 150, 25);
		pNhapSP.add(lblNewLabel_1_1_1_1_1_1_1_1);

		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGia.setColumns(10);
		txtGia.setBounds(170, 360, 176, 25);
		pNhapSP.add(txtGia);

		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = txtMaSP.getText();
				String ten = txtTenSP.getText();
				String tenHSX = cboHSX.getSelectedItem().toString();
				HangSanXuat hsx;
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					hsx = hsxDAO.layHangSanXuatTheoTen1(tenHSX);
					HangSanXuat hang = new HangSanXuat(hsx.getMaHangSanXuat());
					String tenLoai = cboLoai.getSelectedItem().toString();
					LoaiSanPham loai = loaispDAO.layLoaiSanPHamTheoTen(tenLoai);
					LoaiSanPham loaiSP = new LoaiSanPham(loai.getMaLoaiSanPham());
					String size = cboSize.getSelectedItem().toString();
					String mau = cboMau.getSelectedItem().toString();
					int sl = Integer.parseInt(txtSoLuong.getText());
					double gia = Double.parseDouble(txtGia.getText());

					SanPham sp = new SanPham(ma, ten, gia, size, mau, sl, hang, loaiSP);
					boolean rs = sanphamDAO.themSanPham(sp);
					if (rs) {
						//JOptionPane.showMessageDialog(null, "Thêm mới sản phẩm thành công.");
						lblThongBao.setText("Thêm mới sản phẩm thành công.");
						xoaHetDuLieuTrenTableModel();
						showTableSanPham();
						
						model = (DefaultTableModel) tableChiTietHDBH.getModel();
						int n = tableChiTietHDBH.getSelectedColumnCount();
						int row = tableSanPham.getSelectedColumnCount();
						String loaiSanPham = tableSanPham.getValueAt(row, 3).toString();
						String ten_HSX = tableSanPham.getValueAt(row, 2).toString();
						/*model.addRow(new Object[] { n + 1,sp.getMaSanPham(), sp.getTenSanPham(), sp.getHangSanXuat().getTenHangSanXuat(),
							sp.getLoaiSanPham().getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(),
							sp.getGiaSanPham() });*/
						model.addRow(new Object[] { n + 1,sp.getMaSanPham(), sp.getTenSanPham(), ten_HSX,
								loaiSanPham, sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(),
								sp.getGiaSanPham(), sp.getSoLuong() * sp.getGiaSanPham() });
					} else
						//JOptionPane.showMessageDialog(null, "Thêm mới sản phẩm không thành công");
						lblThongBao.setText("Thêm mới sản phẩm không thành công");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnThemSP.setIcon(new ImageIcon(ThemHoaDonNhapKho.class.getResource("/img/icons8_add_40px.png")));
		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSP.setBounds(54, 435, 176, 50);
		pNhapSP.add(btnThemSP);

		JButton btnThoatNhap = new JButton("Thoát");
		btnThoatNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pNhapSP.setVisible(false);
				pThemHDBH.add(pBoLocTK);
				pBoLocTK.setVisible(true);

				txtTenSP.setText("");
				cboHSX.setSelectedIndex(0);
				cboLoai.setSelectedIndex(0);
				cboSize.setSelectedIndex(0);
				cboMau.setSelectedIndex(0);
				txtSoLuong.setText("");
				txtGia.setText("");
			}
		});
		btnThoatNhap.setIcon(new ImageIcon(ThemHoaDonNhapKho.class.getResource("/img/cancel.png")));
		btnThoatNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoatNhap.setBounds(271, 435, 176, 50);
		pNhapSP.add(btnThoatNhap);

		pChuaNut = new JPanel();
		pChuaNut.setBounds(356, 60, 274, 325);
		pChuaNut.setBackground(new Color(127, 255, 212));
		pNhapSP.add(pChuaNut);

		JButton btnThemHang = new JButton("Thêm hãng sản xuất");
		btnThemHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pChuaNut.setVisible(false);
				pNhapSP.add(pNhapHSX);
				pNhapHSX.setVisible(true);

				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					txtMaHSX.setText(taoMaHSX());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pChuaNut.setLayout(null);
		btnThemHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemHang.setBounds(40, 50, 193, 25);
		pChuaNut.add(btnThemHang);

		JButton btnThemLoaiSP = new JButton("Thêm loại sản phẩm");
		btnThemLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pChuaNut.setVisible(false);
				pNhapSP.add(pNhapLoaiSP);
				pNhapLoaiSP.setVisible(true);

				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					txtMaLoai.setText(taoMaLoaiSP());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThemLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemLoaiSP.setBounds(40, 100, 193, 25);
		pChuaNut.add(btnThemLoaiSP);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		scrollPaneSanPham.setBounds(10, 180, 640, 366);
		pBoLocTK.add(scrollPaneSanPham);

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
		try {
			showTableSanPham();
		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		// Combobox hãng sản xuất
		JComboBox cboHangSanXuat = new JComboBox();
		cboHangSanXuat.setEditable(true);
		cboHangSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboHangSanXuat.setBounds(121, 12, 141, 35);
		pBoLocTK.add(cboHangSanXuat);

		JLabel lblMaSP;
		pBoLocTK.setLayout(null);
		lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(10, 22, 81, 15);
		pBoLocTK.add(lblMaSP);

		// Combobox loại sản phẩm
		JComboBox cboLoaiSP = new JComboBox();
		cboLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboLoaiSP.setModel(new DefaultComboBoxModel(new String[] { "Áo thun", "Áo khoác", "Áo len" }));
		cboLoaiSP.setBounds(430, 12, 127, 35);
		pBoLocTK.add(cboLoaiSP);

		JLabel lblLoaiSP;
		lblLoaiSP = new JLabel("Loại sản phẩm");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiSP.setBounds(301, 22, 102, 15);
		pBoLocTK.add(lblLoaiSP);

		JButton btnTimSP = new JButton("Tìm kiếm");
		btnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimSP.setBounds(10, 78, 160, 49);
		pBoLocTK.add(btnTimSP);

		JLabel lblNewLabel_13 = new JLabel("Thêm hóa đơn nhập kho");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_13.setBounds(20, 21, 459, 60);
		pThemHDBH.add(lblNewLabel_13);

		JButton btnNewButton_1 = new JButton("Xóa tất cả bộ lọc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/cancel.png")));
		btnTimSP.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_search_40px.png")));
		btnNewButton_1.setBounds(193, 78, 200, 49);
		pBoLocTK.add(btnNewButton_1);

		pNhapLoaiSP = new JPanel();
		pNhapLoaiSP.setBounds(356, 160, 274, 225);
		pNhapLoaiSP.setBackground(new Color(127, 255, 212));
		// pNhapSP.add(pNhapLoaiSP);
		pNhapLoaiSP.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Mã loại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 0, 63, 25);
		pNhapLoaiSP.add(lblNewLabel_5);

		txtMaLoai = new JTextField();
		txtMaLoai.setEnabled(false);
		txtMaLoai.setBounds(73, 0, 183, 25);
		pNhapLoaiSP.add(txtMaLoai);
		txtMaLoai.setColumns(10);

		JLabel lblNewLabel_5_1 = new JLabel("Tên loại:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(10, 40, 63, 25);
		pNhapLoaiSP.add(lblNewLabel_5_1);

		txtTenLoai = new JTextField();
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(73, 40, 183, 25);
		pNhapLoaiSP.add(txtTenLoai);

		JLabel lblNewLabel_5_1_1 = new JLabel("Mô tả:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(10, 80, 63, 25);
		pNhapLoaiSP.add(lblNewLabel_5_1_1);

		txtMoTaLoai = new JTextField();
		txtMoTaLoai.setColumns(10);
		txtMoTaLoai.setBounds(73, 80, 183, 25);
		pNhapLoaiSP.add(txtMoTaLoai);

		JButton btnThemLoai = new JButton("Thêm");
		btnThemLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = txtMaLoai.getText();
				String ten = txtTenLoai.getText();
				String moTa = txtMoTaLoai.getText();

				LoaiSanPham loai = new LoaiSanPham(ma, ten, moTa);
				boolean rs = false;
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					rs = loaispDAO.themLoaiSanPham(loai);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (rs) {
					//JOptionPane.showMessageDialog(null, "Thêm mới thành công loại sản phẩm");
					lblThongBao.setText("Thêm thành công một loại sản phẩm.");
					DefaultComboBoxModel modelHSX = (DefaultComboBoxModel) cboLoai.getModel();
					showComboBox();
				}else
					//JOptionPane.showMessageDialog(null, "Thêm mới loại sản phẩm không thành công");
					lblThongBao.setText("Thêm thành công không thành loại sản phẩm");
			}
		});
		btnThemLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemLoai.setBounds(25, 127, 85, 35);
		pNhapLoaiSP.add(btnThemLoai);

		JButton btnThoatLoai = new JButton("Thoát");
		btnThoatLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pNhapLoaiSP.setVisible(false);
				pNhapSP.add(pChuaNut);
				pChuaNut.setVisible(true);

				txtTenLoai.setText("");
				txtMoTaLoai.setText("");
				lblThongBao.setText("");
			}
		});
		btnThoatLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoatLoai.setBounds(146, 127, 85, 35);
		pNhapLoaiSP.add(btnThoatLoai);

		pNhapHSX = new JPanel();
		pNhapHSX.setBounds(373, 110, 257, 275);
		pNhapHSX.setBackground(new Color(127, 255, 212));
		// pNhapSP.add(pNhapHSX);
		pNhapHSX.setLayout(null);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Mã hãng:");
		lblNewLabel_1_1_1_2.setBounds(0, 0, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtMaHSX = new JTextField();
		txtMaHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaHSX.setEnabled(false);
		txtMaHSX.setColumns(10);
		txtMaHSX.setBounds(101, 0, 156, 25);
		pNhapHSX.add(txtMaHSX);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Tên hãng:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1.setBounds(0, 40, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2_1);

		txtTenHSX = new JTextField();
		txtTenHSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenHSX.setColumns(10);
		txtTenHSX.setBounds(101, 40, 156, 25);
		pNhapHSX.add(txtTenHSX);

		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1_1.setBounds(0, 80, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2_1_1);

		txtSDT_HSX = new JTextField();
		txtSDT_HSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT_HSX.setColumns(10);
		txtSDT_HSX.setBounds(101, 80, 156, 25);
		pNhapHSX.add(txtSDT_HSX);

		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(0, 120, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2_1_1_1);

		txtDiaChi_HSX = new JTextField();
		txtDiaChi_HSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi_HSX.setColumns(10);
		txtDiaChi_HSX.setBounds(101, 120, 156, 25);
		pNhapHSX.add(txtDiaChi_HSX);

		JLabel lblNewLabel_1_1_1_2_1_1_1_1 = new JLabel("Thành phố:");
		lblNewLabel_1_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1_1_1_1.setBounds(0, 160, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2_1_1_1_1);

		txtThanhPho_HSX = new JTextField();
		txtThanhPho_HSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThanhPho_HSX.setColumns(10);
		txtThanhPho_HSX.setBounds(101, 160, 156, 25);
		pNhapHSX.add(txtThanhPho_HSX);

		JLabel lblNewLabel_1_1_1_2_1_1_1_1_1 = new JLabel("Quốc gia:\r\n");
		lblNewLabel_1_1_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1_1_1_1_1.setBounds(0, 200, 96, 25);
		pNhapHSX.add(lblNewLabel_1_1_1_2_1_1_1_1_1);

		txtQuocGia_HSX = new JTextField();
		txtQuocGia_HSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuocGia_HSX.setColumns(10);
		txtQuocGia_HSX.setBounds(101, 200, 156, 25);
		pNhapHSX.add(txtQuocGia_HSX);

		JButton btnThemHSX = new JButton("Thêm");
		btnThemHSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ma = txtMaHSX.getText();
				String ten = txtTenHSX.getText();
				String sdt = txtSDT_HSX.getText();
				String dc = txtDiaChi_HSX.getText();
				String tp = txtThanhPho_HSX.getText();
				String qg = txtQuocGia_HSX.getText();

				HangSanXuat hsx = new HangSanXuat(ma, ten, sdt, dc, tp, qg);
				boolean rs  = false;
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					rs = hsxDAO.themHangSanXuat(hsx);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (rs) {
					//JOptionPane.showMessageDialog(null, "Thêm thành công một nhà sản xuất.");
					lblThongBao.setText("Thêm thành công một nhà sản xuất.");
					DefaultComboBoxModel modelHSX = (DefaultComboBoxModel) cboHSX.getModel();
					showComboBox();
				} else
					//JOptionPane.showMessageDialog(null, "Thêm nhà sản xuất không thành công");
					lblThongBao.setText("Thêm không thành công một nhà sản xuất.");
			}
		});
		btnThemHSX.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHSX.setBounds(30, 240, 85, 35);
		pNhapHSX.add(btnThemHSX);

		JButton btnThoat_HSX = new JButton("Thoát");
		btnThoat_HSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pNhapHSX.setVisible(false);
				pNhapSP.add(pChuaNut);
				pChuaNut.setVisible(true);

				txtMaHSX.setText("");
				txtTenHSX.setText("");
				txtSDT_HSX.setText("");
				txtDiaChi_HSX.setText("");
				txtThanhPho_HSX.setText("");
				txtQuocGia_HSX.setText("");
				lblThongBao.setText("");
			}
		});
		btnThoat_HSX.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat_HSX.setBounds(144, 240, 85, 35);
		pNhapHSX.add(btnThoat_HSX);
		
		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThongBao.setBounds(373, 10, 257, 36);
		pNhapSP.add(lblThongBao);

		JButton btnThemMoiSP = new JButton("Thêm mới sản phẩm");
		btnThemMoiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pThemHDBH.remove(pBoLocTK);
				pBoLocTK.setVisible(false);
				pThemHDBH.add(pNhapSP);
				pNhapSP.setVisible(true);

				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					txtMaSP.setText(taoMaSP());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThemMoiSP.setIcon(new ImageIcon(ThemHoaDonNhapKho.class.getResource("/img/icons8_add_40px.png")));
		btnThemMoiSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemMoiSP.setBounds(411, 78, 240, 49);
		pBoLocTK.add(btnThemMoiSP);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(665, 0, 835, 786);
		pThemHDBH.add(panel);
		panel.setLayout(null);

		JLabel lblHoaDonBanHang = new JLabel("HÓA ĐƠN NHẬP KHO");
		lblHoaDonBanHang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblHoaDonBanHang.setBounds(262, 10, 339, 53);
		panel.add(lblHoaDonBanHang);

		JLabel lblHangSanXuat_1_2 = new JLabel("Tên nhân viên");
		lblHangSanXuat_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHangSanXuat_1_2.setBounds(10, 127, 106, 35);
		panel.add(lblHangSanXuat_1_2);

		JLabel lblNewLabel = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(459, 73, 97, 13);
		panel.add(lblNewLabel);

		lblNgay = new JLabel("");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgay.setBounds(572, 73, 143, 13);
		panel.add(lblNgay);
		lblNgay.setText(df.format(new java.util.Date()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 815, 310);
		panel.add(scrollPane);

		tableChiTietHDBH = new JTable();
		tableChiTietHDBH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int soLuong = (int) tableChiTietHDBH.getValueAt(row, 7);
				txtCapnhatSoLuong.setText(String.valueOf(soLuong));
				
				int capnhatSoLuong = Integer.parseInt(txtCapnhatSoLuong.getText());
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
				String maHD = lblMaHD.getText();

				/*
				 * NhanVienBanHang nv = (NhanVienBanHang)
				 * nhanVienDAO.layDanhSachNhanVienTheoTen(lblTenNV.getText()); String maNV =
				 * nv.getMaNhanVien(); NhanVienBanHang nhanVien = new NhanVienBanHang(maNV);
				 */

				ChuCuaHang cch;
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					cch = chucuahangDAO.layThongTinChuCuaHang();
					String maCCH = cch.getMaChuCuaHang();
					ChuCuaHang chu = new ChuCuaHang(maCCH);

					String ngay = lblNgay.getText();

					NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(maCCH);
					String maNV = nv.getMaNhanVien();
					NhanVienBanHang nhanVien = new NhanVienBanHang(maNV);
					
					HoaDonNhapKho hdnk = new HoaDonNhapKho(maHD, df.parse(ngay), nhanVien, chu);
					boolean rs = hoaDonNhapKhoDAO.themHoaDon(hdnk);
					luuThongTinChiTietHDBH();
					capnhatSanPham();
					if (rs) {
						JOptionPane.showMessageDialog(rootPane, "Tạo hóa đơn  thành công");
					} else
						JOptionPane.showMessageDialog(rootPane, "Tạo mới hóa đơn không thành công");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				// Lưu thông tin chi tiết hóa đơn
				// String maCTHD = (String) tableChiTietHDBH.getValueAt(rowTableCTHDBH, 1);

				// Cập nhật lại số lượng sản phẩm
			}
		});
		btnThemSPVaoHDBH_1
				.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_checked_checkbox_40px.png")));
		btnThemSPVaoHDBH_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemSPVaoHDBH_1.setBounds(75, 635, 172, 50);
		panel.add(btnThemSPVaoHDBH_1);

		JButton btnThemSPVaoHDBH_1_1 = new JButton("Cập nhật");
		btnThemSPVaoHDBH_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int sl = (int) tableChiTietHDBH.getValueAt(row, 7);
				int capnhatSL = Integer.parseInt(txtCapnhatSoLuong.getText());
				int capnhatSlChoBangSP = (int) tableChiTietHDBH.getValueAt(row, 7) - capnhatSL;
				int num = tableSanPham.getRowCount();
				String maSP = tableChiTietHDBH.getValueAt(row, 1).toString();
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(capnhatSL >= 1 && capnhatSlChoBangSP > 0) {
					tableChiTietHDBH.setValueAt(capnhatSL, row, 7);
					double capnhatThanhTien = capnhatSL * (double) tableChiTietHDBH.getValueAt(row, 8);
					tableChiTietHDBH.setValueAt(capnhatThanhTien, row, 9);
					if (kiemtraDongChuaMaSP(maSP) != -1) {
						int n = kiemtraDongChuaMaSP(maSP);
						tableSanPham.setValueAt( (int) tableSanPham.getValueAt(n, 6) - capnhatSlChoBangSP, n, 6);
						//int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
						//tableSanPham.setValueAt(newSoLuong, row, 6);
						//tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(row, 7)* (double) tableChiTietHDBH.getValueAt(row, 8), n, 9);
						//double capnhatTongTien = tableChiTietHDBH.getValueAt(row, 7) 
						lblTongTien.setText(String.valueOf(tinhTongTien()));
					}
				}
			}
		});
		btnThemSPVaoHDBH_1_1
				.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/icons8_update_40px_2.png")));
		btnThemSPVaoHDBH_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemSPVaoHDBH_1_1.setBounds(667, 162, 158, 50);
		panel.add(btnThemSPVaoHDBH_1_1);

		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenNV.setBounds(192, 127, 183, 35);
		panel.add(lblTenNV);
		
		layThongTinNhanVien();

		try {

			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
			HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
			ChuCuaHang cch = chucuahangDAO.layThongTinChuCuaHang();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				//GDChucnangQLKho_NV gui = new GDChucnangQLKho_NV();
				//gui.setVisible(true);
			}
		});
		btnThoat.setIcon(new ImageIcon(ThemHoaDonBanHang.class.getResource("/img/cancel.png")));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(598, 635, 172, 50);
		panel.add(btnThoat);

		lblDonViTien = new JLabel("");
		lblDonViTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonViTien.setBounds(330, 550, 45, 35);
		panel.add(lblDonViTien);

		lblDonViTien1 = new JLabel("");
		lblDonViTien1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonViTien1.setBounds(330, 650, 45, 35);
		panel.add(lblDonViTien1);

		JLabel lblMHan = new JLabel("Mã hóa đơn:");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMHan.setBounds(10, 74, 81, 13);
		panel.add(lblMHan);

		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaHD.setBounds(101, 74, 97, 13);
		panel.add(lblMaHD);

		txtCapnhatSoLuong = new JTextField();
		txtCapnhatSoLuong.setBounds(526, 170, 96, 35);
		panel.add(txtCapnhatSoLuong);
		txtCapnhatSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCapnhatSoLuong.setColumns(10);

		JLabel lblNewLabel_3_1_1 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1.setBounds(434, 178, 82, 18);
		panel.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableChiTietHDBH.getSelectedRow();
				int sl = (int) tableChiTietHDBH.getValueAt(row, 7);
				String maSP = tableChiTietHDBH.getValueAt(row, 1).toString();
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.removeRow(row);
				if (kiemtraDongChuaMaSP(maSP) != -1) {
					int n = kiemtraDongChuaMaSP(maSP);
					tableSanPham.setValueAt( (int) tableSanPham.getValueAt(n, 6) - sl, n, 6);
					//int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
					//tableSanPham.setValueAt(newSoLuong, row, 6);
					//tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(row, 7)* (double) tableChiTietHDBH.getValueAt(row, 8), n, 9);
					//double capnhatTongTien = tableChiTietHDBH.getValueAt(row, 7) 
					lblTongTien.setText(String.valueOf(tinhTongTien()));
					int num = tableChiTietHDBH.getRowCount();
					for(int i = 0; i < num; i++) {
						tableChiTietHDBH.setValueAt(i + 1, i, 0);
					}
				}
				
			}
		});
		btnXoa.setIcon(new ImageIcon(ThemHoaDonNhapKho.class.getResource("/img/icons8_trash_40px.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(344, 635, 172, 50);
		panel.add(btnXoa);

		JButton btnThemSPVaoHDBH = new JButton("Thêm vào kho");
		btnThemSPVaoHDBH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableSanPham.getSelectedRow();
				String maSP = tableSanPham.getValueAt(row, 0).toString();
				SanPham sp;
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
					HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
					NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					sp = sanphamDAO.laySanPhamTheoMa(maSP);
					// ChiTietHoaDonNhapKho ctnk =
					// chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaSP(maSP);
					int num = tableChiTietHDBH.getRowCount();
					int sl = Integer.parseInt(txtSL.getText());
					double thanhTien = sl * sp.getGiaSanPham();
					model = (DefaultTableModel) tableChiTietHDBH.getModel();
					HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
					LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());

					if (kiemtraSoLuongMua(sl, row)) {
						if (num == 0) {
							// thanhTien = (double) tableChiTietHDBH.getValueAt(num, 7) *
							// sp.getGiaSanPham();
							// double tien = 0;
							// tien = thanhTien + (double) tableChiTietHDBH.getValueAt(num, 7) *
							// sp.getGiaSanPham();
							model.addRow(new Object[] { num + 1, sp.getMaSanPham(), sp.getTenSanPham(),
									hsx.getTenHangSanXuat(), loai.getTenLoai(),
									sp.getKichThuoc(), sp.getMauSac(), sl, sp.getGiaSanPham(), thanhTien });
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) + sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							// tableChiTietHDBH.setValueAt(tien, num, 9);
							lblTongTien.setText(String.valueOf(tinhTongTien()));
							lblDonViTien.setText("VND");
						} else if (kiemtraMaSP(maSP) == -1) {
							model.addRow(new Object[] { num + 1, sp.getMaSanPham(), sp.getTenSanPham(),
									hsx.getTenHangSanXuat(), loai.getTenLoai(),
									sp.getKichThuoc(), sp.getMauSac(), sl, sp.getGiaSanPham(), thanhTien });
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) + sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							lblTongTien.setText(String.valueOf(tinhTongTien()));
						} else if (kiemtraMaSP(maSP) != -1) {
							int n = kiemtraMaSP(maSP);
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(n, 7) + sl, n, 7);
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) + sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(row, 7)
									* (double) tableChiTietHDBH.getValueAt(row, 8), n, 9);
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
		btnThemSPVaoHDBH.setBounds(440, 592, 210, 50);
		pBoLocTK.add(btnThemSPVaoHDBH);

		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSL.setBounds(258, 600, 96, 35);
		pBoLocTK.add(txtSL);
		txtSL.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nhập số lượng cần thêm vào kho");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 592, 233, 50);
		pBoLocTK.add(lblNewLabel_2);
		
		txtMaSP.setText(taoMa());
		txtMaHSX.setText(taoMaHSX());
		txtMaLoai.setText(taoMaLoaiSP());
		lblMaHD.setText(taoMa());

	}

	public void showComboBox() {
		List<HangSanXuat> listHSX;
		try {

			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
			HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
			listHSX = hsxDAO.layTatCaHangSanXuat();
			DefaultComboBoxModel modelHSX = (DefaultComboBoxModel) cboHSX.getModel();
			for (HangSanXuat hsx : listHSX) {
				modelHSX.addElement(hsx.getTenHangSanXuat());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List<LoaiSanPham> listLoaiSP;
		try {

			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
			HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
			listLoaiSP = loaispDAO.layTatCaLoaiSanPham();
			DefaultComboBoxModel modelLoaiSP = (DefaultComboBoxModel) cboLoai.getModel();
			for (LoaiSanPham loai : listLoaiSP) {
				modelLoaiSP.addElement(loai.getTenLoai());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		DefaultComboBoxModel modelSize = (DefaultComboBoxModel) cboSize.getModel();
		modelSize.addElement(new String[] { "S", "M", "L", "XL", "XXL", "XXXL" });

		DefaultComboBoxModel modelMau = (DefaultComboBoxModel) cboMau.getModel();
		modelMau.addElement(new String[] { "Đỏ", "Xanh Dương", "Xanh Lá", "Vàng", "Trắng", "Đen", "Cam", "Tràm" });
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

	/*public void showTableCTHDBH(String ma) {
		int num = 1;
		List<ChiTietHoaDonBanHang> listCTHDBH = chiT.layDanhSachCTHoaDonBanHangTheoMaSP(ma);
		for (ChiTietHoaDonBanHang cthdbh : listCTHDBH) {
			double thanhTien = cthdbh.getSoLuong() * cthdbh.getSanPham().getGiaSanPham();
			model.addRow(new Object[] { num, cthdbh.getSanPham().getMaSanPham(), cthdbh.getSanPham().getTenSanPham(),
					cthdbh.getSanPham().getKichThuoc(), cthdbh.getSanPham().getMauSac(),
					cthdbh.getSanPham().getLoaiSanPham(), cthdbh.getSoLuong(), cthdbh.getSanPham().getGiaSanPham(),
					thanhTien });
			num++;
		}
	}*/

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void xoaHetDuLieuTrenTableModelCTHDNK() {
		DefaultTableModel dm = (DefaultTableModel) tableChiTietHDBH.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void showTableSanPham() throws RemoteException {
		SanPhamDAO sanphamDAO;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			
			int num = 1;
			for (SanPham sp : sanphamDAO.layTatCaSanPham()) {
				HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
				LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
				HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
				LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), hsx.getTenHangSanXuat(), 
						loai.getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });
				num++;
			} 
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	private int kiemtraMaSP(String ma) {
		int row = tableChiTietHDBH.getRowCount();
		int n = -1;
		for (int i = 0; i < row; i++) {
			if (tableChiTietHDBH.getValueAt(i, 1).toString().equals(ma)) {
				n = i;
				break;
			}
		}
		return n;
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

	private void luuThongTinChiTietHDBH() {
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			String maSP = tableChiTietHDBH.getValueAt(i, 1).toString();
			SanPham sp = new SanPham(maSP);
			String maHD = lblMaHD.getText();
			HoaDonNhapKho hd = new HoaDonNhapKho(maHD);
			int soLuong = (int) tableChiTietHDBH.getValueAt(i, 7);
			double gia = (double) tableChiTietHDBH.getValueAt(i, 8);

			ChiTietHoaDonNhapKho cthdnk = new ChiTietHoaDonNhapKho(soLuong, gia, sp, hd);
			try {

				KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
				ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
				HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
				ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
				HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
				NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
				TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
				ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
				HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
				LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
				GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
				chiTietNhapKhoDAO.themChiTietNhapKho(cthdnk);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(cthdnk);
		}
	}

	private void capnhatSanPham() {
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			String maSP = tableChiTietHDBH.getValueAt(i, 1).toString();
			SanPham sp;
			try {

				KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
				ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
				HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
				ChiTietNhapKhoDAO chiTietNhapKhoDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
				HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
				NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
				TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
				ChuCuaHangDAO chucuahangDAO = (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
				HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
				LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
				GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
				sp = sanphamDAO.laySanPhamTheoMa(maSP);
				int soLuongChoVaoKho = (int) tableChiTietHDBH.getValueAt(i, 7);
				int soLuongConLai = sp.getSoLuong() + soLuongChoVaoKho;
				HangSanXuat hsx = new HangSanXuat(sp.getHangSanXuat().getMaHangSanXuat());
				LoaiSanPham loai = new LoaiSanPham(sp.getLoaiSanPham().getMaLoaiSanPham());
				SanPham sanPham = new SanPham(maSP, sp.getTenSanPham(), sp.getGiaSanPham(), sp.getKichThuoc(),
						sp.getMauSac(), soLuongConLai, hsx, loai);
				// SanPham sanPham = new SanPham(maSP, soLuongConLai);
				System.out.println(sanPham);
				boolean rs = sanphamDAO.capNhatSanPham(sanPham);
				System.out.println(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * if (rs) { JOptionPane.showMessageDialog(rootPane,
			 * "Tạo hóa đơn  thành công"); } else JOptionPane.showMessageDialog(rootPane,
			 * "Tạo mới hóa đơn không thành công");
			 */
		}
	}

	private boolean kiemtraSoLuongMua(int sl, int row) {
		boolean rs = false;
		sl = Integer.parseInt(txtSL.getText());
		int numMax = (int) tableSanPham.getValueAt(row, 6);
		if (numMax == 0) {
			JOptionPane.showMessageDialog(null, "Lỗi: Sản phẩm đã hết, vui lòng chọn sản phẩm khác.");
		} else if (sl <= 0) {
			JOptionPane.showMessageDialog(null, "Lỗi: Không nhập số âm hoặc số 0.");
			txtSL.setText("1");
			txtSL.selectAll();
			txtSL.requestFocus();
			return rs;
		} else if (sl > numMax) {
			JOptionPane.showMessageDialog(null, "Lỗi: Bạn đã nhập quá số lượng của sản phẩm.");
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
	
	public void layThongTinNhanVien() {
		ChuCuaHang cch = new ChuCuaHang("CCH001");
		//NhanVienBanHang nvbh = nhanvienDAO.layDanhSachNhanVienTheoTinhTrang(true);
		//NhanVienBanHang nv = new NhanVienBanHang()));
		TaiKhoanDAO taikhoanDAO;
		try {
			TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
			TaiKhoan tk = taiKhoanDAO.layThongTinTaiKhoanTheoTrangThai(true);
			//System.out.println(tk);
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");

			NhanVienBanHang nv = nhanVienDAO.layNhanVienTheoMa(tk.getNhanVienBanHang().getMaNhanVien());
			lblTenNV.setText(nv.getTenNhanVien());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String taoMa() {
		String ma = "";
		try {
			int n=0;
			HoaDonNhapKhoDAO hoaDonNhapKhoDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
			List<HoaDonNhapKho> listHDNK = hoaDonNhapKhoDAO.layTatCaHoaDonNhapKho();
			for (HoaDonNhapKho khachHang : listHDNK) {
				n++;
			}
			if(n < 9)
				ma = "NK00" + String.valueOf(n+1);
			else if(n > 10 && n < 99)
				ma = "NK0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
	private String taoMaSP() {
		String ma = "";
		try {
			int n=0;
			SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
			List<SanPham> listSP = sanphamDAO.layTatCaSanPham();
			for (SanPham khachHang : listSP) {
				n++;
			}
			if(n < 9)
				ma = "SP00" + String.valueOf(n+1);
			else if(n > 10 && n < 99)
				ma = "SP0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
	private String taoMaHSX() {
		String ma = "";
		try {
			int n=0;
			HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
			List<HangSanXuat> listHSX = hsxDAO.layTatCaHangSanXuat();
			for (HangSanXuat khachHang : listHSX) {
				n++;
			}
			if(n < 9)
				ma = "HSX00" + String.valueOf(n+1);
			else if(n > 10 && n < 99)
				ma = "HSX0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
	private String taoMaLoaiSP() {
		String ma = "";
		try {
			int n=0;
			LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
			List<LoaiSanPham> listLoai = loaispDAO.layTatCaLoaiSanPham();
			for (LoaiSanPham khachHang : listLoai) {
				n++;
			}
			if(n < 9)
				ma = "L00" + String.valueOf(n+1);
			else if(n > 9 && n < 99)
				ma = "L0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
}
