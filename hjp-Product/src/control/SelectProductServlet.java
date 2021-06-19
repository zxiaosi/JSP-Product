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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDaoImpl();
		//1.接受表单提交信息
		String pname=request.getParameter("pname");
		String category=request.getParameter("category");
		Product p=new Product();
		p.setPname(pname);
		p.setCategory(category);
		ArrayList<Product> list=new ArrayList<Product>();
		list=productDao.findAllProduct(p);
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/productList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
