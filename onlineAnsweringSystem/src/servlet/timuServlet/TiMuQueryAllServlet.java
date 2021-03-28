package servlet.timuServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiMu;


import service.TiMuService;

public class TiMuQueryAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//通知service层 查询所有题库
		TiMuService tiMuService = new TiMuService();
		List<TiMu> allTiMu = tiMuService.queryTiMuAll();
		//存放数据在request域
		request.setAttribute("allTiMu", allTiMu);
		//转发到jsp
		request.getRequestDispatcher("/admin/timu/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}