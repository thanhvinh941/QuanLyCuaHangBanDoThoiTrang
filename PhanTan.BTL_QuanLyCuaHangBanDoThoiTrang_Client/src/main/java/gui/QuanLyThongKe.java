package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import org.hibernate.SessionFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import dao.ChiTietBanHangDAO;
import dao.ChiTietNhapKhoDAO;
import dao.ChuCuaHangDAO;
import dao.GenerateKeyDAO;
import dao.HoaDonBanHangDAO;
import dao.HoaDonNhapKhoDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import entity.ChiTietHoaDonBanHang;
import entity.ChiTietHoaDonNhapKho;
import entity.HoaDonBanHang;
import entity.HoaDonNhapKho;
import entity.KhachHang;
import entity.NhanVienBanHang;
import entity.SanPham;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;


public class QuanLyThongKe extends JPanel {
	private JComboBox cboNamKH;
	private JComboBox cboThang_KH;
	private JComboBox cboNamHDBH;
	private JComboBox cboThang_HDBH;
	private JComboBox cboNam_SP;
	private JComboBox cboThang_SP;
	private JFreeChart pieChart;
	private ChartPanel chartPanel;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblSoLuongSP;
	private JLabel lblSoLuongHDBH;
	private JLabel lblSoLuongKH;
	private JButton btnXemBieuDoSP;
	private JButton btnXemBieuDoHDBH;
	private JLabel lblSoLuongHDNK;
	private JComboBox cboThang_HDNK;
	private JComboBox cboNamHDNK;
	private JButton btnXemBieuDoHDNK;
	private JLabel lblSoLuongSPNhap;
	private JComboBox cboThangSPNhap;
	private JComboBox cboNamSPNhap;
	private JButton btnXemBieuDoSPNhap;
	
	public static void main(String[] args) throws RemoteException {
		QuanLyThongKe gui = new QuanLyThongKe();
		gui.setVisible(true);
	}
	
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public QuanLyThongKe() throws RemoteException {

		
		setBackground(Color.WHITE);
		setBounds(240, 0, 1298, 816);
	
		setLayout(null);
		
		JLabel lblQunLThng = new JLabel("Quản lý thống kê");
		lblQunLThng.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQunLThng.setBounds(10, 20, 358, 60);
		add(lblQunLThng);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(101, 101, 300, 277);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số lượng sản phẩm bán ra");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 280, 37);
		panel.add(lblNewLabel);
		
		lblSoLuongSP = new JLabel("");
		lblSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSoLuongSP.setBounds(136, 54, 129, 50);
		panel.add(lblSoLuongSP);
		
		lblSoLuongSP.setText(String.valueOf(demSoLuongSanPhamBanRa()));
		
		JLabel lblNewLabel_2 = new JLabel("Tháng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 128, 45, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Năm");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 171, 45, 20);
		panel.add(lblNewLabel_2_1);
		
		cboThang_SP = new JComboBox();
		cboThang_SP.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThang_SP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboThang_SP.setBounds(95, 128, 129, 25);
		panel.add(cboThang_SP);
		
		cboNam_SP = new JComboBox();
		cboNam_SP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNam_SP.setModel(new DefaultComboBoxModel(new String[] {"2021"}));
		cboNam_SP.setBounds(95, 171, 129, 25);
		panel.add(cboNam_SP);
		
		btnXemBieuDoSP = new JButton("Xem");
		btnXemBieuDoSP.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				int index = cboThang_SP.getSelectedIndex();
				String thang = cboThang_SP.getSelectedItem().toString();
				String nam = cboNam_SP.getSelectedItem().toString();
				
				if(index != 0) {
					pieChart = createChart(createDataset(), thang,nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        int month = Integer.parseInt(thang);
			        int year = Integer.parseInt(nam);
			        lblSoLuongSP.setText(String.valueOf(demSoLuongSanPhamBanRaTheoNgay(month, year)));
				} else {
					pieChart = createChart(createDataset(), "1 - 12",nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        lblSoLuongSP.setText(String.valueOf(demSoLuongSanPhamBanRa()));
				}
				
				
			}
		});
		btnXemBieuDoSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemBieuDoSP.setBounds(95, 225, 129, 35);
		panel.add(btnXemBieuDoSP);
		
		JLabel lblIconSP = new JLabel("");
		lblIconSP.setIcon(new ImageIcon(QuanLyThongKe.class.getResource("/img/icons8_t-shirt_60px.png")));
		lblIconSP.setBounds(20, 44, 60, 60);
		panel.add(lblIconSP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(501, 101, 300, 277);
		add(panel_1);
		
		JLabel lblSLngHa = new JLabel("Số lượng hóa đơn bán ra");
		lblSLngHa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSLngHa.setBounds(10, 10, 280, 37);
		panel_1.add(lblSLngHa);
		
		lblSoLuongHDBH = new JLabel("");
		lblSoLuongHDBH.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSoLuongHDBH.setBounds(141, 57, 129, 50);
		panel_1.add(lblSoLuongHDBH);
		
		lblSoLuongHDBH.setText(String.valueOf(demSoLuongHoaDonBH()));
		
		JLabel lblNewLabel_2_2 = new JLabel("Tháng");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 128, 45, 20);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Năm");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 171, 45, 20);
		panel_1.add(lblNewLabel_2_1_1);
		
		cboThang_HDBH = new JComboBox();
		cboThang_HDBH.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThang_HDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboThang_HDBH.setBounds(95, 128, 129, 25);
		panel_1.add(cboThang_HDBH);
		
		cboNamHDBH = new JComboBox();
		cboNamHDBH.setModel(new DefaultComboBoxModel(new String[] {"2021"}));
		cboNamHDBH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNamHDBH.setBounds(95, 171, 129, 25);
		panel_1.add(cboNamHDBH);
		
		btnXemBieuDoHDBH = new JButton("Xem");
		btnXemBieuDoHDBH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cboThang_HDBH.getSelectedIndex();
				String thang = cboThang_HDBH.getSelectedItem().toString();
				String nam = cboNamHDBH.getSelectedItem().toString();
				
				if(index != 0) {
					pieChart = createChart(createDataset(), thang,nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        int month = Integer.parseInt(thang);
			        int year = Integer.parseInt(nam);
			        lblSoLuongHDBH.setText(String.valueOf(demSoLuongHoaDonBHTheoThang(month, year)));
				} else {
					pieChart = createChart(createDataset(), "1 - 12",nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        lblSoLuongSP.setText(String.valueOf(demSoLuongHoaDonBH()));
				}
			}
		});
		btnXemBieuDoHDBH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemBieuDoHDBH.setBounds(95, 225, 129, 35);
		panel_1.add(btnXemBieuDoHDBH);
		
		JLabel lblIconSP_1 = new JLabel("");
		lblIconSP_1.setIcon(new ImageIcon(QuanLyThongKe.class.getResource("/img/icons8_purchase_order_60px_1.png")));
		lblIconSP_1.setBounds(20, 45, 60, 60);
		panel_1.add(lblIconSP_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(188, 143, 143));
		panel_1_1.setBounds(901, 101, 300, 277);
		add(panel_1_1);
		
		JLabel lblNew = new JLabel("Số lượng khách hàng");
		lblNew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNew.setBounds(10, 10, 238, 37);
		panel_1_1.add(lblNew);
		
		lblSoLuongKH = new JLabel();
		lblSoLuongKH.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSoLuongKH.setBounds(140, 57, 129, 50);
		panel_1_1.add(lblSoLuongKH);
		
		lblSoLuongKH.setText(String.valueOf(demSoLuongKhachHang()));
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tháng");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(10, 128, 45, 20);
		panel_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Năm");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 171, 45, 20);
		panel_1_1.add(lblNewLabel_2_1_1_1);
		
		cboThang_KH = new JComboBox();
		cboThang_KH.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThang_KH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboThang_KH.setBounds(95, 128, 129, 25);
		panel_1_1.add(cboThang_KH);
		
		cboNamKH = new JComboBox();
		cboNamKH.setModel(new DefaultComboBoxModel(new String[] {"2021"}));
		cboNamKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNamKH.setBounds(95, 171, 129, 25);
		panel_1_1.add(cboNamKH);
		
		JButton btnXemBieuDoKH = new JButton("Xem");
		btnXemBieuDoKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cboThang_KH.getSelectedIndex();
				String thang = cboThang_HDBH.getSelectedItem().toString();
				String nam = cboNamHDBH.getSelectedItem().toString();
				
				if(index != 0) {
					pieChart = createChart(createDataset(), thang,nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        int month = Integer.parseInt(thang);
			        int year = Integer.parseInt(nam);
			        lblSoLuongKH.setText(String.valueOf(demSoLuongKhachHang()));
				} else {
					pieChart = createChart(createDataset(), "1 - 12",nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        lblSoLuongSP.setText(String.valueOf(demSoLuongKhachHang() ));
				}
			}
		});
		btnXemBieuDoKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemBieuDoKH.setBounds(95, 225, 129, 35);
		panel_1_1.add(btnXemBieuDoKH);
		
		JLabel lblIconSP_1_1 = new JLabel("");
		lblIconSP_1_1.setIcon(new ImageIcon(QuanLyThongKe.class.getResource("/img/icons8_customer_60px_1.png")));
		lblIconSP_1_1.setBounds(20, 42, 60, 60);
		panel_1_1.add(lblIconSP_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(238, 130, 238));
		panel_1_2.setBounds(101, 462, 300, 277);
		add(panel_1_2);
		
		JLabel lblSLngHa_1 = new JLabel("Số lương hóa đơn nhập kho");
		lblSLngHa_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSLngHa_1.setBounds(10, 10, 280, 37);
		panel_1_2.add(lblSLngHa_1);
		
		lblSoLuongHDNK = new JLabel("0");
		lblSoLuongHDNK.setBackground(new Color(238, 130, 238));
		lblSoLuongHDNK.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSoLuongHDNK.setBounds(141, 57, 129, 50);
		panel_1_2.add(lblSoLuongHDNK);
		
		lblSoLuongHDNK.setText(String.valueOf(demSoLuongHoaDonNK()));
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Tháng");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(10, 128, 45, 20);
		panel_1_2.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Năm");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2.setBounds(10, 171, 45, 20);
		panel_1_2.add(lblNewLabel_2_1_1_2);
		
		cboThang_HDNK = new JComboBox();
		cboThang_HDNK.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThang_HDNK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboThang_HDNK.setBounds(95, 128, 129, 25);
		panel_1_2.add(cboThang_HDNK);
		
		cboNamHDNK = new JComboBox();
		cboNamHDNK.setModel(new DefaultComboBoxModel(new String[] {"2021"}));
		cboNamHDNK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNamHDNK.setBounds(95, 171, 129, 25);
		panel_1_2.add(cboNamHDNK);
		
		btnXemBieuDoHDNK = new JButton("Xem");
		btnXemBieuDoHDNK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cboThang_HDNK.getSelectedIndex();
				String thang = cboThang_HDNK.getSelectedItem().toString();
				String nam = cboNamHDNK.getSelectedItem().toString();
				
				
				if(index != 0) {
					pieChart = createChart(createDataset(), thang,nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        int month = Integer.parseInt(thang);
			        int year = Integer.parseInt(nam);
			        lblSoLuongHDNK.setText(String.valueOf(demSoLuongHoaDonNKTheoThang(month, year)));
				} else {
					pieChart = createChart(createDataset(), "1 - 12",nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        lblSoLuongHDNK.setText(String.valueOf(demSoLuongHoaDonNK() ));
				}
			}
		});
		btnXemBieuDoHDNK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemBieuDoHDNK.setBounds(95, 225, 129, 35);
		panel_1_2.add(btnXemBieuDoHDNK);
		
		JLabel lblIconSP_1_2 = new JLabel("");
		lblIconSP_1_2.setIcon(new ImageIcon(QuanLyThongKe.class.getResource("/img/icons8_add_list_40px.png")));
		lblIconSP_1_2.setBounds(20, 45, 60, 60);
		panel_1_2.add(lblIconSP_1_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(222, 184, 135));
		panel_1_2_1.setBounds(501, 462, 300, 277);
		add(panel_1_2_1);
		
		JLabel lblSLngHa_1_1 = new JLabel("Số lượng sản phẩm nhập vào");
		lblSLngHa_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSLngHa_1_1.setBounds(10, 10, 280, 37);
		panel_1_2_1.add(lblSLngHa_1_1);
		
		lblSoLuongSPNhap = new JLabel("0");
		lblSoLuongSPNhap.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSoLuongSPNhap.setBackground(new Color(238, 130, 238));
		lblSoLuongSPNhap.setBounds(141, 57, 129, 50);
		panel_1_2_1.add(lblSoLuongSPNhap);
		
		lblSoLuongSPNhap.setText(String.valueOf(demSoLuongSanPhamNhap()));
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Tháng");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setBounds(10, 128, 45, 20);
		panel_1_2_1.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Năm");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2_1.setBounds(10, 171, 45, 20);
		panel_1_2_1.add(lblNewLabel_2_1_1_2_1);
		
		cboThangSPNhap = new JComboBox();
		cboThangSPNhap.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThangSPNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboThangSPNhap.setBounds(95, 128, 129, 25);
		panel_1_2_1.add(cboThangSPNhap);
		
		cboNamSPNhap = new JComboBox();
		cboNamSPNhap.setModel(new DefaultComboBoxModel(new String[] {"2021"}));
		cboNamSPNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNamSPNhap.setBounds(95, 171, 129, 25);
		panel_1_2_1.add(cboNamSPNhap);
		
		btnXemBieuDoSPNhap = new JButton("Xem");
		btnXemBieuDoSPNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cboThangSPNhap.getSelectedIndex();
				String thang = cboThangSPNhap.getSelectedItem().toString();
				String nam = cboNamSPNhap.getSelectedItem().toString();
				
				
				if(index != 0) {
					pieChart = createChart(createDataset(), thang,nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        int month = Integer.parseInt(thang);
			        int year = Integer.parseInt(nam);
			        lblSoLuongSPNhap.setText(String.valueOf(demSoLuongSanPhamNhapTheoNgay(month, year)));
				} else {
					pieChart = createChart(createDataset(), "1 - 12",nam);
			        chartPanel = new ChartPanel(pieChart);
			        //pBieuDo.add(chartPanel);
			        
			        try {
						lblSoLuongSPNhap.setText(String.valueOf(demSoLuongSanPhamNhap() ));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnXemBieuDoSPNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemBieuDoSPNhap.setBounds(95, 225, 129, 35);
		panel_1_2_1.add(btnXemBieuDoSPNhap);
		
		JLabel lblIconSP_1_2_1 = new JLabel("");
		lblIconSP_1_2_1.setIcon(new ImageIcon(QuanLyThongKe.class.getResource("/img/icons8_tailor_shirt_pattern_40px.png")));
		lblIconSP_1_2_1.setBounds(20, 45, 60, 60);
		panel_1_2_1.add(lblIconSP_1_2_1);
		
	
		
	}
	
	private static JFreeChart createChart(PieDataset dataset, String thang, String nam) {
		String tittleChart = "Sáº£n pháº©m bĂ¡n Ä‘Æ°á»£c trong thĂ¡ng " +thang +" nÄƒm "+ nam;
        JFreeChart chart = ChartFactory.createPieChart(
                tittleChart, dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("NhĂ³m 0 - 14", new Double(25.0));
        dataset.setValue("NhĂ³m 15 - 59", new Double(66.0));
        dataset.setValue("NhĂ³m trĂªn 60", new Double(9.0));
        return dataset;
    }
    
    private int demSoLuongSanPham() {
    	SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<SanPham> listSP = null;
		try {
			listSP = sanphamDAO.layTatCaSanPham();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (SanPham sp : listSP) {
			dem++;
		}
    	return dem;
    }
    
    private int demSoLuongSanPhamBanRa() {
    	SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<SanPham> listSP = null;
		try {
			listSP = sanphamDAO.layTatCaSanPham();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	ChiTietBanHangDAO chiTietBanHangDAO = null;
		try {
			chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (SanPham sp : listSP) {
    		List<ChiTietHoaDonBanHang> listCTBH = null;
			try {
				listCTBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaSP(sp.getMaSanPham());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		for (ChiTietHoaDonBanHang cthdbh : listCTBH) {
				dem += cthdbh.getSoLuong();
			}
		}
    	return dem;
    }
    
    private int demSoLuongSanPhamNhap() throws RemoteException {
    	SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException  | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<SanPham> listSP = null;
		try {
			listSP = sanphamDAO.layTatCaSanPham();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ChiTietNhapKhoDAO cthdnkDAO = null;
		try {
			cthdnkDAO = (ChiTietNhapKhoDAO) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (SanPham sp : listSP) {
    		for (ChiTietHoaDonNhapKho cthdnk : cthdnkDAO.layDanhSachCTHoaDonNhapKhoTheoMaSP(sp.getMaSanPham())) {
				dem += cthdnk.getSoLuong();
			}
		}
    	return dem;
    }
    
    @SuppressWarnings("deprecation")
	private int demSoLuongSanPhamNhapTheoNgay(int thang, int nam) {
    	SanPhamDAO sanphamDAO = null;
    	int dem = 0;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException  | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<SanPham> listSP = null;
		try {
			listSP = sanphamDAO.layTatCaSanPham();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	ChiTietHoaDonNhapKho cthdnkDAO;
		try {
			cthdnkDAO = (ChiTietHoaDonNhapKho) Naming.lookup("rmi://localhost:9999/chitietnhapkho");
			
	    	for (SanPham sp : listSP) {
	    		List<ChiTietHoaDonNhapKho> listCTNK = null;
				try {
					listCTNK = ((ChiTietNhapKhoDAO) cthdnkDAO).layDanhSachCTHoaDonNhapKhoTheoMaSP(sp.getMaSanPham());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for (ChiTietHoaDonNhapKho cthdnk : listCTNK) {
	    			if (cthdnk.getHoaDonNhapKho().getNgayNhapKho().getMonth()  == thang - 1)
	    				dem += cthdnk.getSoLuong();
	    			else
	    				continue;
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return dem;
    }
    
    @SuppressWarnings("deprecation")
   	private int demSoLuongSanPhamBanRaTheoNgay(int thang, int nam) {
    	SanPhamDAO sanphamDAO = null;
		try {
			sanphamDAO = (SanPhamDAO) Naming.lookup("rmi://localhost:9999/sanpham");
		} catch (MalformedURLException | RemoteException  | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	List<SanPham> listSP = null;
		try {
			listSP = sanphamDAO.layTatCaSanPham();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       	ChiTietBanHangDAO chiTietBanHangDAO = null;
		try {
			chiTietBanHangDAO = (ChiTietBanHangDAO) Naming.lookup("rmi://localhost:9999/chitietbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	int dem = 0;
       	for (SanPham sp : listSP) {
       		List<ChiTietHoaDonBanHang> listCTBH;
			try {
				listCTBH = chiTietBanHangDAO.layDanhSachCTHoaDonBanHangTheoMaSP(sp.getMaSanPham());
				for (ChiTietHoaDonBanHang cthdbh : listCTBH) {
	       			if (cthdbh.getHoaDonBanHang().getNgayLapHoaDon().getMonth()  == thang - 1)
	       				dem += cthdbh.getSoLuong();
	       			else
	       				continue;
	   			}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		
   		}
       	return dem;
       }
    
    private int demSoLuongHoaDonBH() {
    	HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<HoaDonBanHang> listHDBH = null;
		try {
			listHDBH = hoaDonBanHangDAO.layTatCaHoaDonBanHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (HoaDonBanHang hoaDonBanHang : listHDBH) {
			dem++;
		}
    	return dem;
    }
    
    private int demSoLuongHoaDonBHTheoThang(int thang, int nam) {
    	HoaDonBanHangDAO hoaDonBanHangDAO = null;
		try {
			hoaDonBanHangDAO = (HoaDonBanHangDAO) Naming.lookup("rmi://localhost:9999/hoadonbanhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<HoaDonBanHang> listHDBH = null;
		try {
			listHDBH = hoaDonBanHangDAO.layTatCaHoaDonBanHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (HoaDonBanHang hoaDonBanHang : listHDBH) {
    		if(hoaDonBanHang.getNgayLapHoaDon().getMonth() == thang - 1)
    			dem++;
    		else
    			continue;
		}
    	return dem;
    }
    
    private int demSoLuongHoaDonNK() {
    	HoaDonNhapKhoDAO hoadonnkDAO = null;
		try {
			hoadonnkDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<HoaDonNhapKho> listHDNK = null;
		try {
			listHDNK = hoadonnkDAO.layTatCaHoaDonNhapKho();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (HoaDonNhapKho donNhapKho : listHDNK) {
			dem++;
		}
    	return dem;
    }
    
    private int demSoLuongHoaDonNKTheoThang(int thang, int nam) {
    	HoaDonNhapKhoDAO hoadonnkDAO = null;
		try {
			hoadonnkDAO = (HoaDonNhapKhoDAO) Naming.lookup("rmi://localhost:9999/hoadonnhapkho");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<HoaDonNhapKho> listHDNK = null;
		try {
			listHDNK = hoadonnkDAO.layTatCaHoaDonNhapKho();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (HoaDonNhapKho donNhapKho : listHDNK) {
    		if(donNhapKho.getNgayNhapKho().getMonth() == thang - 1)
    			dem++;
    		else
    			continue;
		}
    	return dem;
    }
    
    private int demSoLuongKhachHang() {
    	KhachHangDAO khachHangDAO = null;
		try {
			khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	List<KhachHang> listKH = null;
		try {
			listKH = khachHangDAO.layTatCaKhachHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (KhachHang khachHang : listKH) {
			dem++;
		} 
    	return dem;
    }
    
    private int demSoLuongKhachHangTheoThang(int thang, int nam) {
    	KhachHangDAO khachHangDAO = null;
		try {
			khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	List<KhachHang> listKH = null;
		try {
			listKH = khachHangDAO.layTatCaKhachHang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int dem = 0;
    	for (KhachHang khachHang : listKH) {
			dem++;
		} 
    	return dem;
    }
}
