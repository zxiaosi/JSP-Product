package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Product;
import dao.ProductDao;
import dao.ProductDaoImpl;

/**
 * Servlet implementation class SelectProductServlet
 */
@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.接受表单提交信息
		String pname = request.getParameter("pname");
		String category = request.getParameter("category");

		// 2.创建商品对象并给商品对象属性赋值
		Product p = new Product(pname, category);
		
		// 3.创建商品数据库访问层对象
		ProductDao productDao = new ProductDaoImpl();
		
		// 4.查找商品对象
		ArrayList<Product> list = productDao.findAllProduct(p);
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		
		// 5.请求跟转发页面
		request.getRequestDispatcher("/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
