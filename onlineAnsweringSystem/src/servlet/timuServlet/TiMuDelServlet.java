package servlet.timuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TiMuService;

public class TiMuDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int tmid = Integer.valueOf(request.getParameter("tmid"));
		TiMuService tiMuService = new TiMuService();
		tiMuService.delTiMu(tmid);
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/timuQueryAllServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}