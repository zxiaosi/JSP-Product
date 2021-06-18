package dao;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.Product;
import jdbc.JDBCUtils;
public class ProductDaoImpl implements ProductDao {
	
	/**
	 * 插入一个商品
	 * @param Product 商品对象
	 * @return true | false
	 */
	public boolean insert(Product product) {
		try {
	    String sql = "insert into product(pno,pname,price,category,num) "+
					"values("
					+ product.getPno()
					+ ",'"
					+ product.getPname()
					+ "',"
					+ product.getPrice()
					+ ",'"
					+ product.getCategory()
					+ "',"
					+product.getNum()
					+ ")";
			boolean flag = JDBCUtils.executeUpdate(sql);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询所有商品数据
	 * @return list 商品集合
	 */
	public ArrayList<Product> findAllProduct() {
		// 定义商品集合
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			String sql = "select * from product";
			ResultSet rs = JDBCUtils.executeQuery(sql);
			// 循环遍历结果集并放入商品集合中
			while (rs.next()) {
				Product product = new Product();
				product.setPno(rs.getInt("pno"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setNum(rs.getInt("num"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据商品编号查询某个商品（编号唯一）
	 * @param pno 商品编号
	 * @return product 商品对象
	 */
	public Product findProductByPno(int pno) {
		try {
			String sql = "select * from Product where pno=" + pno;
			ResultSet rs = JDBCUtils.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setPno(rs.getInt("pno"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setCategory(rs.getString("category"));
				product.setNum(rs.getInt("num"));
				return product;
			}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
		/**
		 * 根据商品编号删除商品
		 * @param pno 商品编号
		 * @return true | false
		 */
		public boolean deleteProductByPno(int pno) {
			try {
				String sql = "delete from Product where pno=" + pno;
				boolean flag = JDBCUtils.executeUpdate(sql);
				return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 更新一个商品信息(根据商品编号pno)
		 * @param Product 商品对象
		 * @return true | false
		 */
		public boolean update(Product product) {
			try {
				String sql = "update product set pname='" + product.getPname()
						   + "',price="+product.getPrice()
						   + ",category='"+ product.getCategory()
						   + "',num="+product.getNum()
						   +" where pno=" + product.getPno();
				boolean flag = JDBCUtils.executeUpdate(sql);
				return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 带查询条件的查询所有商品数据
		 * @param p 商品对象
		 * @return list 商品集合
		 */
		public ArrayList<Product> findAllProduct(Product p) {
			// 定义商品集合
			ArrayList<Product> list = new ArrayList<Product>();
			try {
				String sql = "select * from product where 1=1 ";
				if(p.getPname()!=null&&!"".equals(p.getPname())) {
					sql+="and pname like '%"+p.getPname()+"%'";
				}
				if(p.getCategory()!=null&&!"".equals(p.getCategory())) {
					sql+="and category ='"+p.getCategory()+"'";
				}
				ResultSet rs = JDBCUtils.executeQuery(sql);
				// 循环遍历结果集并放入商品集合中
				while (rs.next()) {
					Product product = new Product();
					product.setPno(rs.getInt("pno"));
					product.setPname(rs.getString("pname"));
					product.setPrice(rs.getDouble("price"));
					product.setCategory(rs.getString("category"));
					product.setNum(rs.getInt("num"));
					list.add(product);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return null;
		}
	}
