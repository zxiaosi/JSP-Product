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
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno=Integer.parseInt(request.getParameter("pno"));
		// 删除一个商品
		ProductDao productDao = new ProductDaoImpl();
		boolean b=productDao.deleteProductByPno(pno);
		if(b) {
			request.setAttribute("message", "删除成功！");
		}else {
			request.setAttribute("message", "删除失败！");
		}
		ArrayList<Product> list=new ArrayList<Product>();
		list=productDao.findAllProduct();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/productList.jsp").forward(request,response);
	}

}
