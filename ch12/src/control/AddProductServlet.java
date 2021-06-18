package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Product;
import dao.ProductDao;
import dao.ProductDaoImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取表单信息
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pname = request.getParameter("pname");
		Double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		int num = Integer.parseInt(request.getParameter("num"));

		// 2.创建商品对象并给商品对象属性赋值
		Product pro = new Product(pno, pname, price, category, num);

		// 3.创建商品数据库访问层对象
		ProductDao proDao = new ProductDaoImpl();

		// 4.插入商品对象
		proDao.insert(pro);

		// 5.重定向到商品列表
		response.sendRedirect("ShowProductServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
