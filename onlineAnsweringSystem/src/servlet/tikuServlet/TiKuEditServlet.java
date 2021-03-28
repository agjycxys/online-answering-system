package servlet.tikuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiKu;


import service.TiKuService;

public class TiKuEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求参数
		String tkname = request.getParameter("tkname");
		String tkscore = request.getParameter("tkscore");
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		// 封装
		TiKu tiku = new TiKu();
		tiku.setTkname(tkname);
		tiku.setTkscore(tkscore);
		tiku.setTkid(tkid);
		TiKuService tiKuService = new TiKuService();
		tiKuService.editTiKu(tiku);
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/tikuQueryAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}