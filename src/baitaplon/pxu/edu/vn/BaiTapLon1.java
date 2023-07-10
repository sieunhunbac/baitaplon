package baitaplon.pxu.edu.vn;

import java.util.Scanner;

public class BaiTapLon1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = nhapSoLuongSinhVien();
		System.out.println("n = " + n);
		// Tao cac mang 1 chieu chua hoten, dToan, dVan, dAnh va DTB
		String[] hoten = new String[n];
		double[] dToan = new double[n];
		double[] dVan = new double[n];
		double[] dAnh = new double[n];
		double[] dTB = new double[n];
		// Goi ham nhap du lieu
		nhapHoTenVaDiem(hoten, dToan, dVan, dAnh);
		// Xuat danh sach vua nhap
		inDSSV(hoten, dToan, dVan, dAnh, dTB);
		// Goi ham tinh diem trung binh
		dTB = tinhDTB(dToan, dVan, dAnh);
		// Xuat danh sach vua nhap
		inDSSV(hoten, dToan, dVan, dAnh, dTB);
		// sap xep 
		sapxepDSSV(hoten, dToan, dVan, dAnh, dTB);
		inDSSV(hoten, dToan, dVan, dAnh, dTB);
	}

	// Ham nhap so luong sinh vien N nguyen duong
	public static int nhapSoLuongSinhVien() {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhap so luong sinh vien n = ");
				n = sc.nextInt();
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
			return -1;
		}
	}

	// Ham nhap ho ten, diem Toan, Van Anh
	public static void nhapHoTenVaDiem(String[] hoten, double[] dToan, double[] dVan, double[] dAnh) {
		System.out.println("*************************************************************");
		try {
			for (int i = 0; i < hoten.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhap du lieu cho sinh vien thu " + (i + 1));
				System.out.print("Ho ten: ");
				hoten[i] = sc.nextLine();
				System.out.print("Diem Toan: ");
				dToan[i] = sc.nextDouble();
				System.out.print("Diem Van: ");
				dVan[i] = sc.nextDouble();
				System.out.print("Diem Anh: ");
				dAnh[i] = sc.nextDouble();
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
		System.out.println("*************************************************************");
	}

	// Ham tinh diem trung binh
	public static double[] tinhDTB(double[] dToan, double[] dVan, double[] dAnh) {
		double[] dtb = new double[dToan.length];
		for (int i = 0; i < dtb.length; i++) {
			dtb[i] = Math.round(((dToan[i] + dVan[i] + dAnh[i]) / 3) * 100.0) / 100.0;
		}
		return dtb;
	}

	// Ham sap xep sinh vien theo chieu giam dan cua diem trung binh
	public static void sapxepDSSV(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		for(int i = 0; i < dTB.length - 1; i++) {
			for(int j = i + 1; j < dTB.length; j++) {
				if(dTB[i] > dTB[j]) {
					double tam = dTB[i];
					dTB[i] = dTB[j];
					dTB[j] = tam;
					 tam = dToan[i];
					dToan[i] = dToan[j];
					dToan[j] = tam;
					tam = dVan[i];
					dVan[i] = dVan[j];
					dVan[j] = tam;
					tam = dAnh[i];
					dAnh[i] = dAnh[j];
					dAnh[j] = tam;
					String tam2= hoten[i];
					hoten[i] = hoten[j];
					hoten[j] = tam2;
				}
			}
		}
	}
			
			
			
		

	// Ham in danh sach sinh vien ra man hinh
	public static void inDSSV(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		System.out.println("*************************************************************");
		System.out.println("\t\t\t DANH SAH SINH VIEN");
		for (int i = 0; i < hoten.length; i++) {
			System.out.println(
					hoten[i] + "; Toan: " + dToan[i] + "; Van: " + dVan[i] + "; Anh: " + dAnh[i] + "; DTB: " + dTB[i]);
		}
		System.out.println("*************************************************************");
	}

	// Ham tim kiem sinh vien theo diem mon Toan
	public static void timkiemDiem(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {

	}

	// Ham tim kiem sinh vien theo ho ten
	public static void timHoTen(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {

	}
}
