package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDAO;
import dao.LoaiSanPhamDAO;
import dao.SanPhamDAO;
import entity.HangSanXuat;
import entity.LoaiSanPham;
import entity.SanPham;

import javax.swing.JLabel;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class XemSanPham extends JFrame {

	private JPanel contentPane;
	private JTable tableSanPham;
	private JLabel lblNewLabel;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XemSanPham frame = new XemSanPham();
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
	public XemSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 766, 387);
		contentPane.add(scrollPane);
		
		tableSanPham = new JTable();
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "H\u00E3ng", "Lo\u1EA1i", "Size", "M\u00E0u s\u1EAFc", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		scrollPane.setViewportView(tableSanPham);
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(15);
		
		tableSanPham.setAutoCreateRowSorter(true);
		tableSanPham.setRowHeight(tableSanPham.getRowHeight() + 10);
		tableSanPham.setDefaultEditor(Object.class, null);
		
		model = (DefaultTableModel) tableSanPham.getModel();
		try {
			showTableSanPham();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblNewLabel = new JLabel("Danh sách sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 554, 42);
		contentPane.add(lblNewLabel);
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
				model.addRow(new Object[] { num , sp.getMaSanPham(), sp.getTenSanPham(), hsx.getTenHangSanXuat(), 
						loai.getTenLoai(), sp.getKichThuoc(), sp.getMauSac(), sp.getSoLuong(), sp.getGiaSanPham() });
				num++;
			} 
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
