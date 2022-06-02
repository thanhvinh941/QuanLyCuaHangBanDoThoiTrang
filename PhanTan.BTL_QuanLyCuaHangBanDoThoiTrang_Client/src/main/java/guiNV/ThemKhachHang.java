package guiNV;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.demo.JCalendarDemo;

import dao.GenerateKeyDAO;
import dao.KhachHangDAO;
import dao_imp.GenerateKeyImp;
import dao_imp.KhachHangImp;
import dao_imp.MySessionFactory;
import entity.KhachHang;
import gui.QuanLyKhachHang;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooserBeanInfo;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JDayChooserBeanInfo;
import com.toedter.calendar.demo.DateChooserPanelBeanInfo;

public class ThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JTextField txtKh;
	private JComboBox cboGioiTinh;

	SimpleDateFormat df;
	private JDateChooser dateChooser;
	//String maKH = generateKeyDAO.getKey("KhachHang");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKhachHang frame = new ThemKhachHang();
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
	public ThemKhachHang() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int y = 80;
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Thêm khách hàng");
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
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		cboGioiTinh = new JComboBox<Object>();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboGioiTinh.setBounds(150, 430, 110, 25);
		contentPane.add(cboGioiTinh);
		
		
		
		JButton btnNewButton = new JButton("Thêm khách hàng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				//String ngaySinh = dateChooser.getDateFormatString();
				//String ngaySinh = txtNgaySinh.getText();
				Date ngaySinh = dateChooser.getDate(); 
				
				df = new SimpleDateFormat("dd/MM/yyyy");
				try {

					KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
					GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");
					KhachHang kh = new KhachHang(taoMa(), tenKH, cmnd, sdt, diaChi, thanhPho, ngaySinh, gioiTinh);
					if(khachHangDAO.themKhachHang(kh))
						JOptionPane.showMessageDialog(rootPane, "Thêm một khách hàng thành công");
					else 
						JOptionPane.showMessageDialog(rootPane, "Tạo mới không thành công");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/themKH.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(30, 490, 211, 50);
		contentPane.add(btnNewButton);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/*GiaoDienChinh_NhanVienBanHang gui = new GiaoDienChinh_NhanVienBanHang();
				QuanLyKhachHang qlkh = new QuanLyKhachHang();
				gui.setVisible(true);
				qlkh.showTable();*/
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(277, 490, 210, 50);
		contentPane.add(btnThot);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 80, 130, 25);
		contentPane.add(lblNewLabel_1);
		
		txtKh = new JTextField();
		txtKh.setEnabled(false);
		txtKh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKh.setColumns(10);
		txtKh.setBounds(150, 80, 337, 25);
		contentPane.add(txtKh);
		
		try {
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			txtKh.setText(taoMa());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 380, 337, 25);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser);
		
		//System.out.println(maKH);
	}
	
	private String taoMa() {
		String ma = "";
		try {
			int n=0;
			KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
			List<KhachHang> listKH = khachHangDAO.layTatCaKhachHang();
			for (KhachHang khachHang : listKH) {
				n++;
			}
			ma = "KH0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
}
