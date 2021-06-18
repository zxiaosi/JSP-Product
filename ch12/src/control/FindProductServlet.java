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
 * Servlet implementation class SelectProductServlet
 */
@WebServlet("/FindProductServlet")
public class FindProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取商品编号
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		// 2.通过商品编号找到商品
		ProductDao productDao = new ProductDaoImpl();
		Product pro = productDao.findProductByPno(pno);
		request.setAttribute("pro", pro);
		
		// 3.请求转发
		request.getRequestDispatcher("/findProduct.jsp").forward(request, response);
	}

}
