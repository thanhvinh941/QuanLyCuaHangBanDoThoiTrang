package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.ChiTietBanHangDAO;
import dao.ChuCuaHangDAO;
import dao.GenerateKeyDAO;
import dao.HangSanXuatDAO;
import dao.HoaDonBanHangDAO;
import dao.KhachHangDAO;
import dao.LoaiSanPhamDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.ChuCuaHang;
import entity.HangSanXuat;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVienBanHang;
import entity.SanPham;

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
	private JPanel pTaoHoaDonBH;
	private JTextField txtLuaChonKhachHang;
	private JTextField txtTenKH;
	private JTextField txtTenNV;
	private JTable tableChiTietHDBH;
	private JTextField txtTongTien;
	private JTextField txtTienKhachDua;
	private JTextField txtTienTraLai;
	private JTable tableSP;
	private JTextField txtMaSP;
	private JTextField txtSL;
	private JPanel pXemThongTinBH;
	private JLabel lblThongBao;
	private JLabel lblMaHD;
	private JButton btnXoa;
	private JButton btnTaoHD;
	private JButton btnCapNhatHD;
	private JPanel pCapNhatHoaDonBH;
	
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public QuanLyBanHang() throws RemoteException {
		setLayout(null);

		// Chá»©c nÄƒng quáº£n lĂ½ hĂ³a Ä‘Æ¡n
		// ------------------------------------------------------------------------------------------------------------------------------------------

		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(240, 0, 1298, 839);

		
		//----------------------------------------------------------------------------------------------------------------------------
		//Xem thong tin hoa don ban hang
		pXemThongTinBH = new JPanel();
		pXemThongTinBH.setBackground(Color.WHITE);
		pXemThongTinBH.setBounds(10, 21, 1278, 754);
		add(pXemThongTinBH);
		pXemThongTinBH.setLayout(null);
		
		JLabel lblQuanLyBanHang = new JLabel("Quản lý bán hàng");
		lblQuanLyBanHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyBanHang.setBounds(20, 0, 314, 49);
		pXemThongTinBH.add(lblQuanLyBanHang);

		JScrollPane scrollPaneCTHDBH = new JScrollPane();
		scrollPaneCTHDBH.setBounds(20, 495, 790, 236);
		pXemThongTinBH.add(scrollPaneCTHDBH);

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
		tableCTHDBanHang.setDefaultEditor(Object.class, null);
		
		JLabel lblNewLabel_12 = new JLabel("BẢNG HÓA ĐƠN");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12.setBounds(20, 110, 250, 34);
		pXemThongTinBH.add(lblNewLabel_12);

		JLabel lblNewLabel_12_1 = new JLabel("BẢNG CHI TIẾT HÓA ĐƠN");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_12_1.setBounds(20, 451, 358, 34);
		pXemThongTinBH.add(lblNewLabel_12_1);

		JScrollPane scrollPaneHDBH = new JScrollPane();
		scrollPaneHDBH.setBounds(20, 160, 790, 240);
		pXemThongTinBH.add(scrollPaneHDBH);

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
		tableHDBH.setDefaultEditor(Object.class, null);

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
		pXemThongTinBH.add(pBoLocHDBH);
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
				if(txtSDT_CMND.getText().equals("") && !dateChooser.getDate().equals(""))
					try {
						timkiemTheoThoiGian();
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else if(!txtSDT_CMND.getText().equals("") && dateChooser.getDate().equals("")){
					try {
						timkiemTheoSDTorCMND();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(!txtSDT_CMND.getText().equals("") && !dateChooser.getDate().equals(null)) {
					try {
						timkiemTheoThoiGian();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
				try {
					showTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				/*ThemHoaDonBanHang themHDBH = new ThemHoaDonBanHang();
				themHDBH.setVisible(true);
				themHDBH.setLocationRelativeTo(null);
				themHDBH.setAlwaysOnTop(true);
				themHDBH.setResizable(false);*/
				
				add(pTaoHoaDonBH);
				pTaoHoaDonBH.setVisible(true);
				pXemThongTinBH.setVisible(false);
				
				/*btnTaoHD = new JButton("Thanh toán");
				btnCapNhatHD.setVisible(false);
				btnTaoHD.setBounds(520, 130, 186, 35);
				pTaoHoaDonBH.add(btnTaoHD);
				btnTaoHD.setVisible(true);*/
				
			}
		});
		btnThemHD.setBackground(Color.CYAN);
		btnThemHD.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_add_40px.png")));
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemHD.setBounds(907, 195, 240, 60);
		pXemThongTinBH.add(btnThemHD);

		JButton btnCapnhatHD = new JButton("Cập nhật hóa đơn");
		btnCapnhatHD.addActionListener(new ActionListener() {
			private JButton btnCapNhatHD;

			public void actionPerformed(ActionEvent e) {
				CapNhatHoaDonBanHang capnhatHD = null;
				try {
					capnhatHD = new CapNhatHoaDonBanHang();
				} catch (RemoteException | MalformedURLException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
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
					
					System.out.println(ma);
					System.out.println(kh.getMaKhachHang());
					System.out.println(nv.getMaNhanVien());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				/*add(pTaoHoaDonBH);
				pTaoHoaDonBH.setVisible(true);
				pXemThongTinBH.setVisible(false);
				
				btnCapNhatHD  = new JButton("Cập nhật");
				btnTaoHD.setVisible(false);
				btnCapNhatHD.setBounds(520, 130, 186, 35);
				pTaoHoaDonBH.add(btnCapNhatHD);
				btnCapNhatHD.setVisible(true);
				
				int row = tableHDBH.getSelectedRow();
				String ma = tableHDBH.getValueAt(row, 1).toString();
				String ngay = tableHDBH.getValueAt(row, 4).toString();
				String maKH = tableHDBH.getValueAt(row, 2).toString();
				String maNV = tableHDBH.getValueAt(row, 3).toString();
				Double tien = Double.parseDouble(tableHDBH.getValueAt(row, 7).toString());
				
				try {
					DefaultTableModel dm = (DefaultTableModel) tableChiTietHDBH.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
					HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
					
					lblMaHD.setText(ma);
					txtTenNV.setText(maNV);
					txtTenKH.setText(maKH);
					//txtMaSP.setText();
					txtTongTien.setText(tableHDBH.getValueAt(row, 5).toString());
					txtTienKhachDua.setText(tableHDBH.getValueAt(row, 7).toString());
					Double tongTienHD = (Double) tableHDBH.getValueAt(row, 5);
					Double tienKhachDua = (Double) tableHDBH.getValueAt(row, 7);
					txtTienTraLai.setText(String.valueOf(tienKhachDua - tongTienHD));
					
					HoaDonBanHang hd = hoaDonBanHangDAO.layHoaDonTheoMa(ma);
					KhachHang kh = khachHangDAO.layKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
					txtLuaChonKhachHang.setText(kh.getSoDienThoai());
					List<ChiTietHoaDonBanHang> listCTBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaHDBH(ma);
					int num = 1;
					double tongTien = 0;
					model = (DefaultTableModel) tableChiTietHDBH.getModel();
					for (ChiTietHoaDonBanHang cthdbh : listCTBH) {
						SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
						SanPham sp = sanphamDAO.laySanPhamTheoMa(cthdbh.getSanPham().getMaSanPham());
						HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
						LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
						HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
						LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
						double thanhTien = cthdbh.getSoLuong() * sp.getGiaSanPham();
						model.addRow(new Object[] { num, sp.getMaSanPham(), sp.getTenSanPham(),
								hsx.getTenHangSanXuat(),
								loai.getTenLoai(), sp.getKichThuoc(),
								sp.getMauSac(), cthdbh.getSoLuong(), sp.getGiaSanPham(),
								thanhTien });
						num++;
						tongTien += thanhTien;
					}
					
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		});
		btnCapnhatHD.setBackground(Color.CYAN);
		btnCapnhatHD
				.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_update_40px_2.png")));
		btnCapnhatHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapnhatHD.setBounds(907, 300, 240, 60);
		pXemThongTinBH.add(btnCapnhatHD);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHetDuLieuTrenTableModel();
				model = (DefaultTableModel) tableHDBH.getModel();
				try {
					showTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(725, 141, 85, 21);
		pXemThongTinBH.add(btnNewButton);
		
		//-----------------------------------------------------------------------------------------------------------------
		//Tao hoá đơn bán hàng
		pTaoHoaDonBH = new JPanel();
		pTaoHoaDonBH.setBackground(Color.WHITE);
		pTaoHoaDonBH.setBounds(10, 10, 1278, 803);
		//add(pTaoHoaDonBH);
		pTaoHoaDonBH.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 393, 49);
		pTaoHoaDonBH.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại \nhoặc số cmnd");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 80, 211, 35);
		pTaoHoaDonBH.add(lblNewLabel_1);
		
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
						txtTenKH.setText(kh.getTenKhachHang());
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
		txtLuaChonKhachHang.setBounds(270, 80, 186, 35);
		pTaoHoaDonBH.add(txtLuaChonKhachHang);
		txtLuaChonKhachHang.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(50, 130, 176, 35);
		pTaoHoaDonBH.add(lblNewLabel_1_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(270, 130, 186, 35);
		pTaoHoaDonBH.add(txtTenKH);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(50, 180, 176, 35);
		pTaoHoaDonBH.add(lblNewLabel_1_1_1);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(270, 180, 186, 35);
		pTaoHoaDonBH.add(txtTenNV);
		
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
			txtTenNV.setText(cch.getTenChuCuaHang());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(46, 698, 1210, -418);
		pTaoHoaDonBH.add(scrollPane_2);
		
		JButton btnThemKH = new JButton("Thêm khách hàng");
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemKH.setBounds(520, 80, 186, 35);
		pTaoHoaDonBH.add(btnThemKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(780, 80, 176, 35);
		pTaoHoaDonBH.add(lblNewLabel_1_2);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(960, 80, 186, 35);
		pTaoHoaDonBH.add(txtTongTien);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tiền khách đưa");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(780, 130, 176, 35);
		pTaoHoaDonBH.add(lblNewLabel_1_2_1);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
				double tongTien = Double.parseDouble(txtTongTien.getText());
				double tienTraLai = tienKhachDua - tongTien;
				System.out.println(tienTraLai);
				if (tienTraLai < 0) {
					txtTienKhachDua.selectAll();
					txtTienKhachDua.requestFocus();
					//JOptionPane.showMessageDialog(rootPane, "Số tiền mà khách hàng trả không đủ");
					lblThongBao.setText("Số tiền mà khách hàng trả không đủ");
				} else {
					txtTienTraLai.setText(String.valueOf(tienTraLai));
					//lblDonViTien1.setText("VND");
				}
			}
		});
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(960, 130, 186, 35);
		pTaoHoaDonBH.add(txtTienKhachDua);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tiền trả lại");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(780, 180, 180, 35);
		pTaoHoaDonBH.add(lblNewLabel_1_2_1_1);
		
		txtTienTraLai = new JTextField();
		txtTienTraLai.setColumns(10);
		txtTienTraLai.setBounds(960, 180, 186, 35);
		pTaoHoaDonBH.add(txtTienTraLai);
		
		btnTaoHD = new JButton("Thanh toán\r\n");
		btnTaoHD.addActionListener(new ActionListener() {
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

					String ngay = df.format(new java.util.Date());
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
						boolean rs = false;
						if(maHD.equalsIgnoreCase("BH001") || maHD.equalsIgnoreCase("BH002") || maHD.equalsIgnoreCase("BH003") || maHD.equalsIgnoreCase("BH004")|| maHD.equalsIgnoreCase("BH005") )
							rs  = hoaDonBanHangDAO.capNhatHoaDonBanHang(hdbh);
						else {
						rs = hoaDonBanHangDAO.themHoaDonBanHang(hdbh);
						luuThongTinChiTietHDBH();
						capnhatSanPham();
						if (rs) {
							//JOptionPane.showMessageDialog(rootPane, "Tạo hóa đơn  thành công");
							lblThongBao.setText("Tạo hóa đơn  thành công");
						} else
							//JOptionPane.showMessageDialog(rootPane, "Tạo mới hóa đơn không thành công");
							lblThongBao.setText("Tạo hóa đơn không thành công");
						}
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
		btnTaoHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTaoHD.setBounds(520, 130, 186, 35);
		pTaoHoaDonBH.add(btnTaoHD);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(pXemThongTinBH);
				pXemThongTinBH.setVisible(true);
				pTaoHoaDonBH.setVisible(false);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(520, 180, 186, 35);
		pTaoHoaDonBH.add(btnThoat);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(28, 536, 1208, 241);
		pTaoHoaDonBH.add(scrollPane_3);
		
		tableChiTietHDBH = new JTable();
		scrollPane_3.setViewportView(tableChiTietHDBH);
		tableChiTietHDBH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "H\u00E3ng", "Lo\u1EA1i", "Size", "M\u00E0u s\u1EAFc", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tableChiTietHDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(28, 306, 1208, 185);
		pTaoHoaDonBH.add(scrollPane_4);
		
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
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "H\u00E3ng", "Lo\u1EA1i", "Size", "M\u00E0u s\u1EAFc", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_4.setViewportView(tableSanPham);
		
		model = (DefaultTableModel) tableSanPham.getModel();
		showTableSanPham();
		
		txtMaSP = new JTextField();
		txtMaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSP = txtMaSP.getText();
				try {
					SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
					SanPham sp = sanphamDAO.laySanPhamTheoMa(maSP);
					model = (DefaultTableModel) tableSanPham.getModel();
					HangSanXuatDAO hsxDAO = (HangSanXuatDAO) Naming.lookup("rmi://localhost:9999/hangsanxuat");
					LoaiSanPhamDAO loaispDAO = (LoaiSanPhamDAO) Naming.lookup("rmi://localhost:9999/loaisanpham");
					HangSanXuat hsx = hsxDAO.layHangSanXuatTheoMa(sp.getHangSanXuat().getMaHangSanXuat());
					LoaiSanPham loai = loaispDAO.layLoaiSanPhamTheoMa(sp.getLoaiSanPham().getMaLoaiSanPham());
					
					//DefaultTableModel dm = (DefaultTableModel) tableSaP.getModel();
					//dm.getDataVector().removeAllElements();
					
					List<SanPham> listSP = sanphamDAO.layTatCaSanPham();
					boolean rs = false;
					for (SanPham sanPham : listSP) {
						if(sanPham.getMaSanPham().equals(maSP)) {
							rs = true;
							break;
						}	
					}
					if(rs) {
						/*model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), hsx.getTenHangSanXuat(), 
							loai.getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });*/
						int row = tableSanPham.getSelectedRowCount();
						for(int i = 0; i< row; i++) {
							if(tableSanPham.getValueAt(i, 0).toString().equals(maSP)) {
								tableSanPham.setRowSelectionInterval(i, i);
								
							}	
						}
						txtSL.setText("1");
						txtSL.selectAll();
						txtSL.requestFocus();
					} else {
						lblThongBao.setText("Mã sản phẩm không tồn tại");
						txtMaSP.selectAll();
						txtMaSP.requestFocus();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		txtMaSP.setBounds(155, 270, 96, 25);
		pTaoHoaDonBH.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập mã sản phẩm\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 270, 123, 25);
		pTaoHoaDonBH.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nhập số lượng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(301, 270, 123, 25);
		pTaoHoaDonBH.add(lblNewLabel_2_1);
		
		txtSL = new JTextField();
		txtSL.addActionListener(new ActionListener() {
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
							txtTongTien.setText(String.valueOf(tinhTongTien()));
							//txtDonViTien.setText("VND");
						} else if (kiemtraMaSP(maSP) == -1) {
							model.addRow(new Object[] { num + 1, sp.getMaSanPham(), sp.getTenSanPham(),
									hsx.getTenHangSanXuat(), loai.getTenLoai(),
									sp.getKichThuoc(), sp.getMauSac(), sl, sp.getGiaSanPham(), thanhTien });
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							txtTongTien.setText(String.valueOf(tinhTongTien()));
						} else if (kiemtraMaSP(maSP) != -1) {
							int n = kiemtraMaSP(maSP);
							
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(n, 7) + sl, n, 7);
							
							//Cập nhật lại số lượng cho bảng sản phẩm
							int newSoLuong = (int) tableSanPham.getValueAt(row, 6) - sl;
							tableSanPham.setValueAt(newSoLuong, row, 6);
							
							double thanhTienNew = (int) tableChiTietHDBH.getValueAt(n, 7)
									* (double) tableChiTietHDBH.getValueAt(row, 8);
							tableChiTietHDBH.setValueAt((int) tableChiTietHDBH.getValueAt(n, 7) * sp.getGiaSanPham(), n, 9);
							
							txtTongTien.setText(String.valueOf(tinhTongTien()));
							
							
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		txtSL.setColumns(10);
		txtSL.setBounds(413, 270, 96, 25);
		pTaoHoaDonBH.add(txtSL);
		
		btnXoa = new JButton("Xóa");
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
					txtTongTien.setText(String.valueOf(tinhTongTien()));
					int num = tableChiTietHDBH.getRowCount();
					for(int i = 0; i < num; i++) {
						tableChiTietHDBH.setValueAt(i + 1, i, 0);
					}
				}
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(1151, 501, 85, 25);
		pTaoHoaDonBH.add(btnXoa);
		
		lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThongBao.setBounds(434, 22, 737, 25);
		pTaoHoaDonBH.add(lblThongBao);
		
		JLabel lblNewLabel_3 = new JLabel("Mã hóa đơn");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(50, 230, 101, 13);
		pTaoHoaDonBH.add(lblNewLabel_3);
		
		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHD.setBounds(270, 230, 186, 13);
		pTaoHoaDonBH.add(lblMaHD);
		lblMaHD.setText(taoMa());
		
		
		

	}
	
	

	protected void timkiemTheoSDTorCMND() throws RemoteException {
		if(txtSDT_CMND.getText().length() == 10)
			timkiemTheoDienThoai();
		else if (txtSDT_CMND.getText().length() == 12)
			timkiemTheoCMND();
		
	}

	private void timkiemTheoDienThoai() throws RemoteException {
		KhachHangDAO khachHangDAO = null;
		try {
			khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sdt = txtSDT_CMND.getText().trim();
		int num = 1;
		// List<KhachHang> listKH = khachHangDAO.
		KhachHang kh = null;
		try {
			kh = khachHangDAO.layKhachHangTheoDienthoai(sdt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();
		HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HoaDonBanHang> listHDBH = null;
		try {
			listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoMaKhachHang(kh.getMaKhachHang());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (HoaDonBanHang hdbh : listHDBH) {
			Date day = hdbh.getNgayLapHoaDon();
			double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
			model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
					hdbh.getNhanVienBanHang().getMaNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
			num++;
		}
		
	}

	private void timkiemTheoCMND() throws RemoteException {
		KhachHangDAO khachHangDAO = null;
		try {
			khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sdt = txtSDT_CMND.getText().trim();
		int num = 1;
		// List<KhachHang> listKH = khachHangDAO.
		KhachHang kh = null;
		try {
			kh = khachHangDAO.layKhachhangTheoCMND(sdt);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();
		HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HoaDonBanHang> listHDBH = null;
		try {
			listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoMaKhachHang(kh.getMaKhachHang());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (HoaDonBanHang hdbh : listHDBH) {
			Date day = hdbh.getNgayLapHoaDon();
			double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
			model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
					hdbh.getNhanVienBanHang().getMaNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
			num++;
		}
	}
	
	protected void timkiemTheoThoiGian() throws RemoteException {
		HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = dateChooser.getDate();
		df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		int num = 1;
		List<HoaDonBanHang> listHDBH = null;
		try {
			listHDBH = hoaDonBanHangDAO.layDanhSachHoaDonBanHangTheoNgay(df.format(date));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();
		for (HoaDonBanHang hdbh : listHDBH) {
			Date day = hdbh.getNgayLapHoaDon();
			double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
			model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), hdbh.getKhachHang().getMaKhachHang(),
					hdbh.getNhanVienBanHang().getMaNhanVien(), df1.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
			num++;
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

	public void showTable() throws RemoteException {
		HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			int num = 1;
			List<HoaDonBanHang> listHDBH = null;
			try {
				listHDBH = hoaDonBanHangDAO.layTatCaHoaDonBanHang();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (HoaDonBanHang hdbh : listHDBH) {
				Date day = hdbh.getNgayLapHoaDon();
				KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
				NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				KhachHang kh = khachHangDAO.layKhachHangTheoMa(hdbh.getKhachHang().getMaKhachHang());
				NhanVienBanHang nv= nhanVienDAO.layNhanVienTheoMa(hdbh.getNhanVienBanHang().getMaNhanVien());
				double tongTien = tinhTongTienHoaDonBanHang(hdbh.getMaHoaDonBanHang());
				model.addRow(new Object[] { num, hdbh.getMaHoaDonBanHang(), kh.getTenKhachHang(),
						nv.getTenNhanVien(), df.format(day), tongTien, hdbh.getGhiChu(), hdbh.getTienKhachDua() });
				num++;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
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
	
	public void showTableSanPham() {
		int num = 1;
		List<SanPham> listSP;
		try {
			try {
				SanPhamDAO sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
				listSP = sanphamDAO.layTatCaSanPhamKhacKhong();
				for (SanPham sp : listSP) {
					model.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), sp.getHangSanXuat().getMaHangSanXuat(),
							sp.getLoaiSanPham().getMaLoaiSanPham(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(),
							sp.getGiaSanPham() });
					num++;
				}
			} catch (MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	private double tinhTongTien() {
		double tongTien = 0;
		int row = tableChiTietHDBH.getRowCount();
		for (int i = 0; i < row; i++) {
			tongTien += (double) tableChiTietHDBH.getValueAt(i, 9);
		}
		return tongTien;
	}
	
	private boolean kiemtraSoLuongMua(int sl, int row) {
		boolean rs = false;
		sl = Integer.parseInt(txtSL.getText());
		int numMax = (int) tableSanPham.getValueAt(row, 6);
		if (numMax == 0) {
			//JOptionPane.showMessageDialog(rootPane, "Lỗi: Sản phẩm đã hết, vui lòng chọn sản phẩm khác.");
			lblThongBao.setText("Lỗi: Sản phẩm đã hết, vui lòng chọn sản phẩm khác.");
			return rs;
		} else if (sl <= 0) {
			//JOptionPane.showMessageDialog(rootPane, "Lỗi: Không nhập số âm hoặc số 0.");
			lblThongBao.setText("Lỗi: Không nhập số âm hoặc số 0.");
			txtSL.setText("1");
			txtSL.selectAll();
			txtSL.requestFocus();
			return rs;
		} else if (sl > numMax) {
			//JOptionPane.showMessageDialog(rootPane, "Lỗi: Bạn đã nhập quá số lượng của sản phẩm.");
			lblThongBao.setText("Lỗi: Bạn đã nhập quá số lượng của sản phẩm.");
			txtSL.setText(String.valueOf(numMax));
			txtSL.selectAll();
			txtSL.requestFocus();
			return rs;
		}
		return true;
	}
	
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
