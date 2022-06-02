package guiNV;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.JCalendarDemo;

import dao.ChiTietBanHangDAO;
import dao.GenerateKeyDAO;
import dao.HoaDonBanHangDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao_imp.GenerateKeyImp;
import dao_imp.KhachHangImp;
import dao_imp.MySessionFactory;
import entity.KhachHang;
import gui.GiaoDienChinh_ChuCuaHang;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooserBeanInfo;

public class QuanLyKhachHang extends JPanel {

	private JTable table;
	private DefaultTableModel tableKHMode;
	private TableModel tablePQMode;
	private JTable tableKH;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneKH;
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
	private JTextField txtTimKiem;
	private JTextField txtSDT;
	private JTextField textField_4;
	private JTextField textField_5;
	private DefaultTableModel model;
	private JPanel pCapNhatKH;
	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JDateChooser dateChooser;
	private JTextField txtNgay;
	private FormCapNhatKH capnhatKH;


	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		QuanLyKhachHang gui = new QuanLyKhachHang();
		gui.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang() {
		// ----------------------------------------------------------------------------------------------------------------------------------------------
		// Chức năng quản lý khách hàng
		setBackground(new Color(255, 255, 255));
		setBounds(240, 0, 1298, 839);
		setLayout(null);
		
		capnhatKH = new FormCapNhatKH();
		capnhatKH.setVisible(false);
		
		JLabel lblQuanLyKhachHang = new JLabel("Quản lý khách hàng");
		lblQuanLyKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyKhachHang.setBounds(20, 21, 358, 60);
		add(lblQuanLyKhachHang);

		scrollPaneKH = new JScrollPane();
		scrollPaneKH.setBounds(20, 345, 1255, 376);
		add(scrollPaneKH);

		tableKH = new JTable();
		tableKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableKH.getSelectedRow();
				txtTenKH.setText(tableKH.getValueAt(row, 2).toString());
				//cboGioiTinh.setSelectedItem(tableKH.getValueAt(row,3));
				txtCMND.setText(tableKH.getValueAt(row, 4).toString());
				txtSDT.setText(tableKH.getValueAt(row, 5).toString());
				txtDiaChi.setText(tableKH.getValueAt(row, 6).toString());
				txtThanhPho.setText(tableKH.getValueAt(row, 7).toString());
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tableKH.getValueAt(row, 8));
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPaneKH.setViewportView(tableKH);
		tableKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableKH.setBackground(Color.WHITE);
		tableKH.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"Gi\u1EDBi t\u00EDnh", "S\u1ED1 CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i",
						"\u0110\u1ECBa ch\u1EC9", "Th\u00E0nh ph\u1ED1", "Ng\u00E0y sinh" }) {
		});

		tableKH.setAutoCreateRowSorter(true);
		tableKH.setRowHeight(tableKH.getRowHeight() + 10);
		
		model = (DefaultTableModel) tableKH.getModel();
		showTable();

		JPanel pBoLocKH = new JPanel();
		pBoLocKH.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pBoLocKH.setBackground(new Color(255, 255, 255));
		pBoLocKH.setBounds(311, 110, 964, 166);
		add(pBoLocKH);
		pBoLocKH.setLayout(null);
		String[] s = new String[122];
		String n = "1930";
		s[1] = "";
		for(int i = 1; i < 92 ; i++) {
			s[i] = n;
			int num = Integer.parseInt(n);
			System.out.println(num);
			num = num + 1;
			n = Integer.toString(num);
			System.out.println(num);
		}

		// Nút tìm kiếm khách hàng

		JButton btnTimKiemKH = new JButton("Tìm kiếm");
		btnTimKiemKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(!txtCMND.getText().equals("")) {
					timKiemTheoSoCMND();
				} else if (!txtSDT.getText().equals("")){
					timkiemTheoDienThoai();
				}*/
				if(txtTimKiem.getText().length() == 10)
					timkiemTheoDienThoai();
				else if (txtTimKiem.getText().length() == 12)
					timKiemTheoSoCMND();
				else
					timkiemTheoTen();
				
			}
		});
		btnTimKiemKH.setBackground(Color.GREEN);
		btnTimKiemKH.setBounds(150, 95, 171, 47);
		pBoLocKH.add(btnTimKiemKH);
		btnTimKiemKH.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_search_40px.png")));

		// Nút xóa tất cả bộ lọc

		JButton btnXoaTatCaBoLoc = new JButton("Xóa tất cả bộ lọc");
		btnXoaTatCaBoLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaTatCaBoLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrangBoLoc();
			
			}
		});
		btnXoaTatCaBoLoc.setBounds(365, 95, 208, 47);
		pBoLocKH.add(btnXoaTatCaBoLoc);
		btnXoaTatCaBoLoc.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/cancel.png")));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setBounds(351, 33, 318, 35);
		pBoLocKH.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm theo tên, số CMND, số điện thoại:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(10, 33, 351, 35);
		pBoLocKH.add(lblTimKiem);

		// Điều chỉnh độ rộng của cột trong bản khách hàng

		tableKH.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableKH.getColumnModel().getColumn(1).setResizable(false);
		tableKH.getColumnModel().getColumn(1).setPreferredWidth(74);
		tableKH.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableKH.getColumnModel().getColumn(6).setPreferredWidth(100);

		JButton btnNewButton = new JButton("Thêm khách hàng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemKhachHang themKH = new ThemKhachHang();
				themKH.setVisible(true);
				themKH.setLocationRelativeTo(null);
				themKH.setAlwaysOnTop(true);
				themKH.setResizable(false);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setIcon(
				new ImageIcon(QuanLyKhachHang.class.getResource("/img/icons8_add_user_female_skin_type_7_40px.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(20, 180, 240, 60);
		add(btnNewButton);

		JButton btnCapNhatKhach = new JButton("Cập nhật khách hàng");
		btnCapNhatKhach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * CapNhatKhachHang capnhatKH = new CapNhatKhachHang();
				 * capnhatKH.setVisible(true); capnhatKH.setLocationRelativeTo(null);
				 * capnhatKH.setAlwaysOnTop(true); capnhatKH.setResizable(false);
				 * 
				 * KhachHang kh = khachHangDAO.layKhachHangTheoMa(tableKH.getColumnName(1));
				 * capnhatKH.layMa(tableKH.getColumnName(1));
				 */
				/*pCapNhatKH.setVisible(true);
				//pCapNhatKH.setLocation(null);
				pBoLocKH.setVisible(false);
				scrollPane.setVisible(false);
				tableKH.setVisible(false);*/
				
				//apnhatKH = new FormCapNhatKH();
				//capnhatKH.setVisible(true);
				/*capnhatKH.setLocationRelativeTo(null);
				capnhatKH.setAlwaysOnTop(true); 
				capnhatKH.setResizable(false);*/
				//capnhatKH.txtKh.setText("1");
				
				
				CapNhatKhachHang capnhatKH = new CapNhatKhachHang();
				capnhatKH.setVisible(true); capnhatKH.setLocationRelativeTo(null);
				capnhatKH.setAlwaysOnTop(true); capnhatKH.setResizable(false);
				int row = tableKH.getSelectedRow();
				String ma = tableKH.getValueAt(row, 1).toString();
				capnhatKH.showData(ma);	
				if(!capnhatKH.isFocusableWindow()) {
					xoaHetDuLieuTrenTableModel();
					showTable();
				}
				QuanLyKhachHang gui = new QuanLyKhachHang();
				gui.setVisible(true);
				
				
				
			}
		});
		btnCapNhatKhach.setBackground(Color.CYAN);
		btnCapNhatKhach.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/img/icons8_update_40px_2.png")));
		btnCapNhatKhach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhatKhach.setBounds(20, 260, 240, 60);
		add(btnCapNhatKhach);
		
		
		//Form cập nhật dữ liệu
		//---------------------------------------------------------------------------------------------------------------------------------------
		
		//pCapNhatKH.setFocusCycleRoot(true);
		// pCapNhatKH.setFocusableWindowState(true);
		// pCapNhatKH.setUndecorated(true);
		// pCapNhatKH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pCapNhatKH = new JPanel();
		add(pCapNhatKH);
		pCapNhatKH.setBounds(311, 100, 960, 220);
		pCapNhatKH.setVisible(false);
		pCapNhatKH.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 960, 210);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pCapNhatKH.add(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 80, 130, 25);
		contentPane.add(lblNewLabel);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setBounds(150, 80, 160, 25);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblSCmnd = new JLabel("Số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 130, 130, 25);
		contentPane.add(lblSCmnd);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 130, 160, 25);
		contentPane.add(txtCMND);

		JLabel lblNewLabel_2 = new JLabel("Cập nhật  khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 180, 130, 25);
		contentPane.add(lblNewLabel_1_1);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 179, 160, 25);
		contentPane.add(txtSDT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(350, 80, 130, 25);
		contentPane.add(lblNewLabel_1_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(500, 80, 160, 25);
		
		contentPane.add(txtDiaChi);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Thành phố");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(350, 130, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1);

		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(500, 130, 160, 25);
		contentPane.add(txtThanhPho);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(350, 180, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(500, 180, 160, -14);
		contentPane.add(calendarDemo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(500, 180, 160, 25);
		contentPane.add(dateChooser);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(700, 80, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);

		JComboBox cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cboGioiTinh.setBounds(800, 80, 110, 25);
		contentPane.add(cboGioiTinh);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCapNhat.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/img/updateKH.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(720, 120, 190, 40);
		contentPane.add(btnCapNhat);

		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pBoLocKH.setVisible(true);
				pCapNhatKH.setVisible(false);
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(720, 170, 190, 40);
		contentPane.add(btnThot);
		
		JButton btnBoLocTK = new JButton("Bộ lọc tìm kiếm");
		btnBoLocTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pBoLocKH.setVisible(true);
				//pCapNhatKH.setVisible(false);
				display();
			}
		});
		btnBoLocTK.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/img/boLoc.png")));
		btnBoLocTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBoLocTK.setBackground(Color.CYAN);
		btnBoLocTK.setBounds(20, 100, 240, 60);
		add(btnBoLocTK);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHetDuLieuTrenTableModel();
				model = (DefaultTableModel) tableKH.getModel();
				showTable();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(1190, 325, 85, 21);
		add(btnNewButton_1);
		
		
	}
	
	private void timkiemTheoTen() {
		String ten = txtTimKiem.getText();
		int num = 1;
		List<KhachHang> listKH;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			listKH = khachHangDAO.layDanhSachKhachHangTheoTen(ten);
			xoaHetDuLieuTrenTableModel();
			for (KhachHang kh : listKH) {
				Date day = kh.getNgaySinh();
				model.addRow(new Object[] { num, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nữ" : "Nam",
						kh.getSoCMND(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getThanhPho(), df.format(day) });
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

	private static void display() {
        String[] items = {"One", "Two", "Three", "Four", "Five"};
        JComboBox<String> combo = new JComboBox<>(items);
        JTextField field1 = new JTextField("1234.56");
        JTextField field2 = new JTextField("9876.54");
        JPanel panel = new JPanel();
        panel.add(combo);
        panel.add(new JLabel("Field 1:"));
        panel.add(field1);
        panel.add(new JLabel("Field 2:"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(combo.getSelectedItem()
                + " " + field1.getText()
                + " " + field2.getText());
        } else {
            System.out.println("Cancelled");
        }
    }

	protected void timKiemTheoSoCMND() {
		String cmnd = txtTimKiem.getText().trim();
		int num = 1;
		KhachHang kh;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			kh = khachHangDAO.layKhachhangTheoCMND(cmnd);
			xoaHetDuLieuTrenTableModel();
			Date day = kh.getNgaySinh();
			model.addRow(new Object[] { num, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nữ" : "Nam",
					kh.getSoCMND(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getThanhPho(), df.format(day) });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void xoaTrangBoLoc() {
		txtTimKiem.setText("");
		txtSDT.setText("");
		txtTenKH.setText("");
		xoaHetDuLieuTrenTableModel();
		showTable();

	}

	protected void timkiemTheoDienThoai() {
		String sdt = txtSDT.getText().trim();
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
			Date day = kh.getNgaySinh();
			model.addRow(new Object[] { num, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nữ" : "Nam",
					kh.getSoCMND(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getThanhPho(), df.format(day) });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showTable() {
		int num = 1;
		List<KhachHang> listKH;
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
			HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			listKH = khachHangDAO.layTatCaKhachHang();
			for (KhachHang kh : listKH) {
				Date day = kh.getNgaySinh();
				
				model.addRow(new Object[] { num, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nữ" : "Nam",
						kh.getSoCMND(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getThanhPho(), df.format(day) });
				num++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableKH.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	/*public void showcomboData() {
		List<KhachHang> listKH = khachHangDAO.layTatCaKhachHang();
		for (KhachHang kh : listKH) {
			cboNamSinh.addItem(kh.getNgaySinh().getYear());
			cboGioiTinh.addItem(kh.isGioiTinh() ? "Nữ" : "Nam");
		}
	}*/
	
	/*public String layMaKH_Update(String maKH, String ten, String sdt, String cmnd, String diaChi, String thanhPho, String ) {
		txtTenKH.setText(ten);
		return maKH;
	}*/

	public void setVisibleTrang(boolean rs) {
		setVisible(rs);
	}
	
	private class FormCapNhatKH extends JPanel {
		

		private JPanel contentPane;
		private JTextField txtTenKH;
		private JTextField txtCMND;
		private JTextField txtSDT;
		private JTextField txtDiaChi;
		private JTextField txtThanhPho;
		private JDateChooser dateChooser;
		private JComboBox cboGioiTinh;
		private JTextField txtMaKH;
		private JLabel lblMaKH;

		SimpleDateFormat df;
		//List<KhachHang> listKH =  khachHangDAO.layTatCaKhachHang();
		private JTextField txtNgaySinh;
	
		
		public FormCapNhatKH() {
			setFocusCycleRoot(true);
			setBounds(100, 100, 511, 604);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			//setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tên khách hàng:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 130, 130, 25);
			contentPane.add(lblNewLabel);
			
			txtTenKH = new JTextField();
			txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTenKH.setBounds(150, 130, 337, 25);
			contentPane.add(txtTenKH);
			txtTenKH.setColumns(10);
			
			JLabel lblSCmnd = new JLabel("Số CMND");
			lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSCmnd.setBounds(10, 180, 130, 25);
			contentPane.add(lblSCmnd);
			
			txtCMND = new JTextField();
			txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCMND.setColumns(10);
			txtCMND.setBounds(150, 180, 337, 25);
			contentPane.add(txtCMND);
			
			JLabel lblNewLabel_2 = new JLabel("Cập nhật  khách hàng");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel_2.setBounds(10, 0, 477, 60);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1_1.setBounds(10, 230, 130, 25);
			contentPane.add(lblNewLabel_1_1);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtSDT.setColumns(10);
			txtSDT.setBounds(150, 230, 337, 25);
			contentPane.add(txtSDT);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1_1_1.setBounds(10, 280, 130, 25);
			contentPane.add(lblNewLabel_1_1_1);
			
			txtDiaChi = new JTextField();
			txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDiaChi.setColumns(10);
			txtDiaChi.setBounds(150, 280, 337, 25);
			contentPane.add(txtDiaChi);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Thành phố");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1_1_1_1.setBounds(10, 330, 130, 25);
			contentPane.add(lblNewLabel_1_1_1_1);
			
			txtThanhPho = new JTextField();
			txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtThanhPho.setColumns(10);
			txtThanhPho.setBounds(150, 330, 337, 25);
			contentPane.add(txtThanhPho);
			
			JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày sinh:");
			lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1_1_1_1_1.setBounds(10, 380, 130, 25);
			contentPane.add(lblNewLabel_1_1_1_1_1);
			
			JCalendarDemo calendarDemo = new JCalendarDemo();
			calendarDemo.setBounds(150, 345, 337, -14);
			contentPane.add(calendarDemo);
			
			dateChooser = new JDateChooser();
			dateChooser.setBounds(150, 380, 337, 25);
			dateChooser.setDateFormatString("dd/MM/yyyy");
			contentPane.add(dateChooser);
			
			JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính:");
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
			contentPane.add(lblNewLabel_1_1_1_1_1_1);
			
			cboGioiTinh = new JComboBox();
			cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
			cboGioiTinh.setBounds(150, 430, 110, 25);
			contentPane.add(cboGioiTinh);
			
			JButton btnNewButton = new JButton("Cập nhật");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kiemtraUpdate();
					
				}
			});
			btnNewButton.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/img/updateKH.png")));
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(30, 490, 190, 50);
			contentPane.add(btnNewButton);
			
			JButton btnThot = new JButton("Thoát");
			btnThot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//GiaoDienChinh_ChuCuaHang gui = new GiaoDienChinh_ChuCuaHang();
					QuanLyKhachHang qlkh = new QuanLyKhachHang();
					//gui.setVisible(true);
					//qlkh.layMaKH_Update(txtMaKH.getText());
					qlkh.xoaHetDuLieuTrenTableModel();
					qlkh.showTable();
					setVisible(false);
					
				}
			});
			btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
			btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnThot.setBounds(277, 490, 190, 50);
			contentPane.add(btnThot);
			
			lblMaKH = new JLabel("Tên khách hàng:");
			lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMaKH.setBounds(10, 80, 130, 25);
			contentPane.add(lblMaKH);
			
			txtMaKH = new JTextField();
			txtMaKH.setEnabled(false);
			txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtMaKH.setColumns(10);
			txtMaKH.setBounds(150, 80, 337, 25);
			contentPane.add(txtMaKH);
		}
		
		public void showData(String maKH) {
			KhachHang kh;
			try {
				KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
				ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
				HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
				NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				kh = khachHangDAO.layKhachHangTheoMa(maKH);
				txtMaKH.setText(maKH);
		        txtTenKH.setText(kh.getTenKhachHang());
		        txtSDT.setText(kh.getSoDienThoai());
		        txtCMND.setText(kh.getSoCMND());
		        txtDiaChi.setText(kh.getDiaChi());
		        txtThanhPho.setText(kh.getThanhPho());
		        cboGioiTinh.setSelectedItem(kh.isGioiTinh());
		        
		        Date date;
		        df = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse( df.format(kh.getNgaySinh()) );
					dateChooser.setDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		public String layMa(String ma) {
			return ma;
		}
		
		public void showTableAfterUpdate() {
			
		}
		
		public boolean kiemtraUpdate() {
			String maKH = txtMaKH.getText();
			String tenKH = txtTenKH.getText();
			//String gioiTinh =  cboGioiTinh.getSelectedItem().toString();
			
			//Boolean gioiTinh = Boolean.parseBoolean(cboGioiTinh.getSelectedItem().toString());
			boolean gioiTinh = true;
			if(cboGioiTinh.getSelectedItem().equals("Nam"))
				gioiTinh = false;
			String cmnd = txtCMND.getText();
			String sdt  = txtSDT.getText();
			String diaChi = txtDiaChi.getText();
			String thanhPho = txtThanhPho.getText();
			Date ngaySinh = dateChooser.getDate();
			//String ngaySinh = txtNgaySinh.getText();
			
			df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
				ChiTietBanHangDAO chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
				HoaDonBanHangDAO hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
				NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				KhachHang kh = new KhachHang(maKH, tenKH, cmnd, sdt, diaChi, thanhPho, ngaySinh, gioiTinh);
				boolean rs = khachHangDAO.capNhatKhachHang(kh);
				if(khachHangDAO.capNhatKhachHang(kh)) {
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công");
					return true;
				} else 
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng không thành công");
					return false;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		public boolean kiemtraThoat() {
			boolean rs = true;
			
			return true;
		}
		
		public void setVisibleTrang(boolean rs) {
			setVisible(rs);
		}
		
	}	
}
