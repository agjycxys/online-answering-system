package servlet.tikuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;


import service.TiKuService;

import dao.TiKuDao;
import domain.TiKu;

public class TiKuAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取请求参数
		String tkname = request.getParameter("tkname");
		String tkscore = request.getParameter("tkscore");
		//封装
		TiKu tiKu = new TiKu();
		tiKu.setTkname(tkname);
		tiKu.setTkscore(tkscore);
		
		TiKuService tiKuService = new TiKuService();
		tiKuService.addTiKu(tiKu);
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/tikuQueryAllServlet");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}