package servlet.tikuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiKu;


import service.TiKuService;


public class TiKuDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		
		TiKuService tiKuService = new TiKuService();
		tiKuService.delTiKu(tkid);
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/tikuQueryAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}