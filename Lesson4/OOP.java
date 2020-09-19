package Lesson4;

public class OOP {
	/*----------OOP----------
	++ Đóng gói (Encapsulation)
	++ Kế thừa (Inheritance)
	++ Trừu tượng (Abstraction)
	++ Đa hình (Polymorphism)
	*/
	/*---------Đóng gói--------
	 * - Đóng gói dữ liệu(property-private) thành 1 unit
	 * - Chỉ cung cấp các method(getter, setter) ra ngoài
	 */
	Ví dụ:
		Account : ID, userName, pass
		-->ID: private
		-->userName : getter
		-->pass : setter
	/*---------Kế thừa--------
	 * - Ví dụ: có 1 lớp A có sẵn gồm (property và các method), có 1 lớp B khác muốn sử dụng lại những gì lớp A có
	 * --> class B kế thừa class A
	 */
		--> Lớp A : superClass hoặc parent
		--> Lớp B : subClass hoặc childClass
		
	/*--------Protected-------
	 * -Để lớp B(lớp con) sử dụng được các property của lớp A(lớp cha)
	 * --> Property của lớp cha phải khai báo là protected (hoặc public)	
	 */
	
	/*------super();------
	 * - Đại diện cho superClass
	 * - super.call();   :Gọi lại phương thức của lớp cha
	 * - super(name);  	:Gọi lại thuộc tính của lớp cha
	 * - Phương thức có thể trùng tên, các phương thức trùng tên sẽ khác nhau tại tham số truyền vào
	 * - Phương thức trùng tên gọi là: overload (đặt trồng)
	 */
		
	/*-------Override----------
	 * - Ghi đè phương thức
	 */
		
		Java hỗ trợ:
			++ Có thể kế thừa nhiều tầng
			++ Không thể kế thừa nhiều lớp
			
	/*---------Abstraction-------Trừu tượng
	 * - Cung cấp cho đối tượng khác các phương thức để sử dụng
	 * - Nhưng không cung cấp cách mà phương thức đó hoạt động
	 * Tác dụng:
	 * - Giảm độ phức tạp khi làm việc nhóm
	 * 
	 * NOTE:
	 * - Abstract class không biểu thị cho Abstraction
	 * - Nếu 1 lớp mà có ít nhất 1 phương thức Abstract thì lớp đó phải khai báo là Abstract
	 * --> Tất cả các lớp con của nó phải Override lại phương thức đó
	 * - Không thể khai báo instance của 1 lớp khi lớp đó có ít nhất 1 phương thức là abstract
	 */
		
		
		
		
		
		
}	
		
		
		

}
