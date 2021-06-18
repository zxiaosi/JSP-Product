package Entity;
/**
 * 商品实体类
 * @author Administrator
 * 
 */
public class Product {
	private int pno;			// 商品编号
	private String pname;		// 商品名称
	private double price;		// 商品价格
	private String category;	// 商品分类
	private int num;			// 库存量
	
	// 无参构造方法
	public Product() {
		
	}
	
	// 有参构造方法
	public Product(String pname, String category) {
		this.pname = pname;
		this.category = category;
	}
	
	public Product(int pno, String pname, double price, String category, int num) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.category = category;
		this.num = num;
	}
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
