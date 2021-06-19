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
 * 添加商品
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		ProductDao productDao = new ProductDaoImpl();
		//1.接受表单提交信息
		String pname=request.getParameter("pname");
		int pno=Integer.parseInt(request.getParameter("pno"));
		double price=Double.valueOf(request.getParameter("price"));
		String category=request.getParameter("category");
		int num=Integer.parseInt(request.getParameter("num"));
		//操作类型（添加/删除）
		String type=request.getParameter("type");		
		//2.创建商品对象
		Product p=new Product();
		if("add".equals(type)) {
			//将表单信息赋值给商品对象
			p.setPno(pno);
			p.setPname(pname);
			p.setPrice(price);
			p.setCategory(category);
			p.setNum(num);
			// 向Product表插入一个商品信息		   
			boolean b=productDao.insert(p);
			if(b) {
				request.setAttribute("message", "插入成功！");
			}else {
				request.setAttribute("message", "插入失败！");
			}			
		}else {
			p.setPno(pno);
			p.setPname(pname);
			p.setPrice(price);
			p.setCategory(category);
			p.setNum(num);
			productDao.update(p);
		}
		ArrayList<Product> list=new ArrayList<Product>();
		list=productDao.findAllProduct();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/productList.jsp").forward(request,response);
	}
}
