package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.hibernate.SessionFactory;

import dao.ChuCuaHangDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.ChuCuaHang;
import entity.KhachHang;
import entity.NhanVienBanHang;
import entity.TaiKhoan;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import org.json.*;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuanLyNhanVien extends JPanel {

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
	
	

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel model;
	private JTextField txtTimKiem;
	private JLabel lblTimKiem;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public QuanLyNhanVien() {

	
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(240, 0, 1298, 839);
	

		JLabel lblQuanLyNhanVien = new JLabel("Quản lý nhân viên");
		lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQuanLyNhanVien.setBounds(20, 21, 358, 60);
	add(lblQuanLyNhanVien);

		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(20, 345, 1200, 376);
		add(scrollPaneNV);

		tableNhanVien = new JTable();
		tableNhanVien.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneNV.setViewportView(tableNhanVien);
		tableNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableNhanVien.setBackground(Color.WHITE);
		tableNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã nhân viên", "Tên nhân viên", 
				"Gi\u1EDBi t\u00EDnh", "S\u1ED1 CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", 
				"\u0110\u1ECBa ch\u1EC9", "Th\u00E0nh ph\u1ED1", "Ng\u00E0y sinh", "Ng\u00E0y v\u00E0o l\u00E0m", "Tình trạng"
			}
		) {
		});
		tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableNhanVien.getColumnModel().getColumn(1).setResizable(false);
		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(74);
		tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableNhanVien.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableNhanVien.setAutoCreateRowSorter(true);
		tableNhanVien.setRowHeight(tableNhanVien.getRowHeight() + 10);
		tableNhanVien.setDefaultEditor(Object.class, null);
		
		TableColumn colThanhPho = tableNhanVien.getColumnModel().getColumn(7);
		JComboBox cboTablecolumnThanhPho = new JComboBox();
		/*String strJSON ="{key: value}";
		JSONObject obj = new JSONObject(strJSON);
		
		String[] dsThanhPho = {"An Giang","BĂ  Rá»‹a â€“ VÅ©ng TĂ u","Báº¯c Giang", "Báº¡c LiĂªu"};
		for(int i = 0; i < 63; i++) {
			String s = "";
			if(i < 10 && s.length() < 2) {
				s = "0" + "i";
			}
			else s = "i"; 
			String username = obj.getJSONObject(s).getString("name");
		}*/
		
		/*//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Tinh_ThanhPho.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		/*cboTablecolumnGioiTinh.addItem("Tp.HCM");
		cboTablecolumnGioiTinh.addItem("TĂ¢y Ninh");
		colGioiTinh.setCellEditor(new DefaultCellEditor(cboTablecolumnGioiTinh));*/

		model = (DefaultTableModel) tableNhanVien.getModel();
		showTable();
		
		JPanel pLoc = new JPanel();
		pLoc.setBackground(Color.WHITE);
		pLoc.setBounds(305, 80, 930, 219);
		add(pLoc);
		pLoc.setLayout(null);
		
		JPanel pBoLocNV = new JPanel();
		pLoc.add(pBoLocNV);
		pBoLocNV.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pBoLocNV.setBackground(Color.WHITE);
		pBoLocNV.setBounds(0, 10, 910, 185);
		pBoLocNV.setLayout(null);
		String[] s = new String[122];
		String n = "1900";
		s[0] = "";
		for(int i = 1; i < 122 ; i++) {
			s[i] = n;
			int num = Integer.parseInt(n);
			System.out.println(num);
			num = num + 1;
			n = Integer.toString(num);
			System.out.println(num);
		}
		System.out.println(s);

		lblTimKiem = new JLabel("Tìm kiếm theo số điện thoại, tên, số CMND");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimKiem.setBounds(25, 40, 321, 35);
		pBoLocNV.add(lblTimKiem);

		// NĂºt tĂ¬m kiáº¿m nhĂ¢n viĂªn

		JButton btnTimKiemNV = new JButton("Tìm kiếm");
		btnTimKiemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*boolean rsTinhTrang = cboTinhTrang.getSelectedItem().toString().equals(""); 
				if(cboNamSinhNV.getSelectedItem().toString().equals("") && !cboGioiTinhNV.getSelectedItem().toString().equals(""))
					timkiemTheoGioiTinh();
				else if(!cboNamSinhNV.getSelectedItem().toString().equals("") && cboGioiTinhNV.getSelectedItem().toString().equals(""))
					timkiemTheoNam();
				else if(cboNamSinhNV.getSelectedItem().toString().equals("") && cboGioiTinhNV.getSelectedItem().toString().equals("") && !rsTinhTrang)
					timkiemTheoTinhTrang();
				else if(cboNamSinhNV.getSelectedItem().toString().equals("") && cboGioiTinhNV.getSelectedItem().toString().equals("") && rsTinhTrang)
					JOptionPane.showMessageDialog(null, "Nháº­p thĂ´ng tim tĂ¬m kiáº¿m");*/
				
				if(txtTimKiem.getText().length() == 10)
					timKiemTheoSDT();
				else if (txtTimKiem.getText().length() == 12)
					timKiemTheoSoCMND();
				else
					timKiemTheoTenNV();
			}

			
		});
		btnTimKiemNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiemNV.setBounds(132, 102, 175, 50);
		pBoLocNV.add(btnTimKiemNV);
		btnTimKiemNV.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/icons8_search_40px.png")));

		// NĂºt xĂ³a táº¥t cáº£ bá»™ lá»�c

		JButton btnXoaTatCaBoLocNV = new JButton("Xóa bộ lọc");
		btnXoaTatCaBoLocNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*cboNamSinhNV.setSelectedIndex(0);
				cboGioiTinhNV.setSelectedIndex(0);
				cboTinhTrang.setSelectedIndex(0);*/
				txtTimKiem.setText("");
				xoaHetDuLieuTrenTableModel();
				showTable();
			}
		});
		btnXoaTatCaBoLocNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaTatCaBoLocNV.setBounds(387, 102, 197, 50);
		pBoLocNV.add(btnXoaTatCaBoLocNV);
		btnXoaTatCaBoLocNV.setIcon(new ImageIcon(GiaoDienChinh_ChuCuaHang.class.getResource("/img/cancel.png")));
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setBounds(352, 40, 317, 35);
		pBoLocNV.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNhanVien themNV = null;
					themNV = new ThemNhanVien();
				themNV.setVisible(true);
				themNV.setLocationRelativeTo(null);
				themNV.setAlwaysOnTop(true);
				themNV.setResizable(false);
			}
		});
		btnThemNV.setBackground(Color.CYAN);
		btnThemNV.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/img/themKH.png")));
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemNV.setBounds(20, 100, 240, 60);
		add(btnThemNV);
		
		JButton btnCapNhatNV = new JButton("Cập nhật nhân viên");
		btnCapNhatNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CapNhatNhanVien capnhatNV = new CapNhatNhanVien();
				capnhatNV.setVisible(true);
				capnhatNV.setLocationRelativeTo(null);
				capnhatNV.setAlwaysOnTop(true);
				capnhatNV.setResizable(false);
				
				int row = tableNhanVien.getSelectedRow();
				String ma = tableNhanVien.getValueAt(row, 1).toString();
				capnhatNV.showData(ma);	
				if(!capnhatNV.isFocusableWindow()) {
					xoaHetDuLieuTrenTableModel();
					showTable();
				}
				QuanLyKhachHang gui = new QuanLyKhachHang();
				gui.setVisible(true);
			}
		});
		btnCapNhatNV.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/img/icons8_update_user_48px.png")));
		btnCapNhatNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhatNV.setBackground(Color.CYAN);
		btnCapNhatNV.setBounds(20, 175, 240, 60);
		add(btnCapNhatNV);
		
		JButton btnXoaNV = new JButton("Xóa nhân viên");
		btnXoaNV.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/img/icons8_trash_40px.png")));
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO nhanvienDAO = null;
				try {
					nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
				} catch (MalformedURLException | RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int row = tableNhanVien.getSelectedRow();
				String maNV = (String) tableNhanVien.getValueAt(row, 1);
				try {
					NhanVienBanHang nv = nhanvienDAO.layNhanVienTheoMa(maNV);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String ten = tableNhanVien.getValueAt(row, 2).toString();
				boolean gioiTinh = true;
				if(tableNhanVien.getValueAt(row, 3).equals("Nam"))
					gioiTinh = false;
				String cmnd = tableNhanVien.getValueAt(row, 4).toString();
				String sdt = tableNhanVien.getValueAt(row, 5).toString();
				String dc = tableNhanVien.getValueAt(row, 6).toString();
				String tp = tableNhanVien.getValueAt(row, 7).toString();
				String ngay = tableNhanVien.getValueAt(row, 8).toString();
				String ngayLam = tableNhanVien.getValueAt(row, 9).toString();
				
				
				
				df = new SimpleDateFormat("dd/MM/yyyy");
				try {
					NhanVienBanHang nhanVien = new NhanVienBanHang(maNV, ten, gioiTinh, cmnd, sdt, dc, tp, df.parse(ngay), df.parse(ngayLam), false);
					System.out.println(nhanVien);
					boolean rs = nhanvienDAO.capNhatNhanVien(nhanVien);
					TaiKhoanDAO taikhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
					TaiKhoan tk = taikhoanDAO.layThongTinTaiKhoanTheoTenDangNhap(maNV);
					ChuCuaHangDAO chucuahangDAO =  (ChuCuaHangDAO) Naming.lookup("rmi://localhost:9999/chucuahang");
					ChuCuaHang cch = chucuahangDAO.layThongTinChuCuaHang();
					ChuCuaHang chu = new ChuCuaHang(cch.getMaChuCuaHang());
					TaiKhoan taiKhoan = new TaiKhoan(maNV, "123456", "NhĂ¢n viĂªn", false, false, chu, nhanVien);
					taikhoanDAO.cpanhatTaiKhoan(taiKhoan);
					System.out.println(taiKhoan);
					/*if(rs) {
						JOptionPane.showMessageDialog(null, "XĂ³a thĂ´ng tin nhĂ¢n viĂªn thà€nh cĂ´ng");
						model.removeRow(row);
					
					} else 
						JOptionPane.showMessageDialog(null, "XĂ³a thĂ´ng tin nhĂ¢n viĂªn khĂ´ng thà€nh cĂ´ng");*/
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//NhanVienBanHang nv = new ;
			}
		});
		btnXoaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaNV.setBackground(Color.CYAN);
		btnXoaNV.setBounds(20, 255, 240, 60);
		add(btnXoaNV);
		
		JButton btnNewButton = new JButton("reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHetDuLieuTrenTableModel();
				model = (DefaultTableModel) tableNhanVien.getModel();
				showTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(1135, 323, 85, 21);
		add(btnNewButton);
		
		
	}
	
	private void timKiemTheoSoCMND() {
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String cmnd = txtTimKiem.getText();
		int num = 1;
		NhanVienBanHang nv = null;
		try {
			nv = nhanvienDAO.layNhanVienTheoSoCMND(cmnd);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();

			Date day = nv.getNgaySinh();
			Date day1 = nv.getNgayVaoLam();
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), 
					nv.isGioiTinh(), nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), df.format(day), df.format(day1), nv.isTinhTrang()?"Ä�ang lĂ m":"Nghá»‰" });

	}
	

	private void timKiemTheoSDT() {
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String sdt = txtTimKiem.getText();
		int num = 1;
		NhanVienBanHang nv = null;
		try {
			nv = nhanvienDAO.layNhanVienTheoSoDienthoai(sdt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();

			Date day = nv.getNgaySinh();
			Date day1 = nv.getNgayVaoLam();
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), 
					nv.isGioiTinh(), nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(),  df.format(day), df.format(day1), nv.isTinhTrang()?"Ä�ang lĂ m":"Nghá»‰" });

	}
	

	private void timKiemTheoTenNV() {
		String cmnd = txtTimKiem.getText();
		int num = 1;
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		List<NhanVienBanHang> listNV = null;
		try {
			listNV = nhanvienDAO.layDanhSachNhanVienTheoTen(cmnd);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xoaHetDuLieuTrenTableModel();
		for (NhanVienBanHang nv : listNV) {
			Date day = nv.getNgaySinh();
			Date day1 = nv.getNgayVaoLam();
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), 
					nv.isGioiTinh(), nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(),  df.format(day), df.format(day1), nv.isTinhTrang()?"Ä�ang lĂ m":"Nghá»‰"});
		}
			

	}

	/*protected void xoaTrangBoLoc() {
		cboGioiTinhNV.setSelectedIndex(0);
		cboNamSinhNV.setSelectedIndex(0);;

	}*/

	/*protected void timkiemTheoDienThoai() {
		String sdt = txtSDT.getText().trim();
		int num = 1;
		// List<KhachHang> listKH = khachHangDAO.
		KhachHang kh = khachHangDAO.layKhachHangTheoDienthoai(sdt);
		xoaHetDuLieuTrenTableModel();
		Date day = kh.getNgaySinh();
		model.addRow(new Object[] { num, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Ná»¯",
				kh.getSoCMND(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getThanhPho(), df.format(day) });
	}*/

	
	public void showTable() {
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int num = 1;
		try {
			for (NhanVienBanHang nv : nhanvienDAO.layTatCaNhanVien()) {
				Date day = nv.getNgaySinh();
				Date ngayVaoLam = nv.getNgayVaoLam();
				
				model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nữ" : "Nam",
						nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), df.format(day) ,df.format(ngayVaoLam), nv.isTinhTrang() ? "Đang làm": "Nghĩ"});
				num++;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	/*public void showcomboData() {
		List<NhanVienBanHang> listNV = nhanvienDAO.layTatCaNhanVien();
		for (NhanVienBanHang nv : listNV) {
			cboNamSinhNV.addItem(nv.getNgaySinh().getYear());
			cboGioiTinhNV.addItem(nv.isGioiTinh() ? "Nam" : "Ná»¯");
		}
	}*/
	
	/*@SuppressWarnings("deprecation")
	private void timkiemTheoNam() {
		String n =  cboNamSinhNV.getSelectedItem().toString();
		int nam = Integer.parseInt(n);
		System.out.println(nam);
		int num = 1;
		List<NhanVienBanHang> listNV = nhanvienDAO.layDanhSachNhanVienTheoNamSinh(nam);
		xoaHetDuLieuTrenTableModel();
		for (NhanVienBanHang nv : listNV) {
			if(nv.getNgaySinh().getYear() == nam) {
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Ná»¯" : "Nam",
					nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), nv.getNgaySinh() ,nv.getNgayVaoLam(), nv.isTinhTrang() ? "Ä�ang lĂ m": "Nghá»‰"});
			num++;
			} else 
				continue;
		}
	}*/
	
	/*private void timkiemTheoGioiTinh() {
		String s = cboGioiTinhNV.getSelectedItem().toString();
		int num = 1;
		boolean gt = true;
		if(s.equals("Nam"))
			gt = false;
		List<NhanVienBanHang> listNV = nhanvienDAO.layDanhSachNhanVienTheoGioiTinh(gt);
		xoaHetDuLieuTrenTableModel();
		for (NhanVienBanHang nv : listNV) {
			
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Ná»¯" : "Nam",
					nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), nv.getNgaySinh() ,nv.getNgayVaoLam(), nv.isTinhTrang() ? "Ä�ang lĂ m": "Nghá»‰"});
			num++;
			
		}
	}*/
	
	/*private void timkiemTheoTinhTrang() {
		int n = cboTinhTrang.getSelectedIndex();
		String s = cboTinhTrang.getSelectedItem().toString();
		int num = 0;
		boolean gt = true;
		if(n == 1)
			gt = false;
		List<NhanVienBanHang> listNV = nhanvienDAO.layDanhSachNhanVienTheoGioiTinh(gt);
		xoaHetDuLieuTrenTableModel();
		for (NhanVienBanHang nv : listNV) {
			
			model.addRow(new Object[] { num, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Ná»¯" : "Nam",
					nv.getSoCMND(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getThanhPho(), nv.getNgaySinh() ,nv.getNgayVaoLam(), nv.isTinhTrang() ? "Ä�ang lĂ m": "Nghá»‰"});
			num++;
			
		}
	}*/
	
	private static String parseEmployeeObject(JSONObject employee, String key) 
    {
		
			 //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get(key);
	         
	        //Get employee first name
	        String name = (String) employeeObject.get("name");   
	        
	        return name;
    }
}
