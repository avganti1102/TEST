package Ex5.Question4;

import java.time.LocalDate;
import java.util.Scanner;

public class Bao extends ThuVien {
	private LocalDate ngayPhatHanh;

	public LocalDate getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public Bao(String maTaiLieu, String NXB, int soBanPhatHanh,LocalDate ngayPhatHanh) {
		super(maTaiLieu, NXB, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Ngày phát hành: ");
		LocalDate ngay = LocalDate.now();
		sc.nextLine();
		
	}
	
	@Override
	public void output() {
		super.output();
		System.out.println("Ngày phát hành: "+ this.getNgayPhatHanh());
	}
	
}
