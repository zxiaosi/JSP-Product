package dao;

import java.util.ArrayList;

import Entity.Product;

/**
 * 数据库接口
 * @author Administrator
 *
 */
public interface ProductDao {
	/**
	 * 插入一个商品
	 * @param Product
	 * @return
	 */
	public boolean insert(Product product);
	
	/**
	 * 查询所有商品数据
	 * @return 商品集合
	 */
	public ArrayList<Product> findAllProduct();
	
	/**
	 * 根据学号获取商品信息
	 * @param sno 学号
	 * @return 查询商品对象
	 */
	public Product findProductByPno(int pno);
	
	/**
	 * 根据学号删除商品
	 * @param sno 学号
	 * @return true/false
	 */
	public boolean deleteProductByPno(int pno);
	
	/**
	 * 更新一个商品信息(根据商品号pno)
	 * @param Product
	 * @return true/false
	 */
	public boolean update(Product product);
	/**
	 * 带查询条件的查询所有商品数据
	 * @param p 查询条件
	 * @return 商品集合
	 */
	public ArrayList<Product> findAllProduct(Product p);
}
