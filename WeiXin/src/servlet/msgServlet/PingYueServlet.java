package servlet.msgServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Users_ZGTService;

public class PingYueServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String openid = request.getParameter("openid");
		int zgtscore = Integer.valueOf(request.getParameter("zgtscore"));
		Users_ZGTService users_ZGTService = new Users_ZGTService();
		users_ZGTService.AddZGTScore(openid, zgtscore);
		//评阅完成后将改变状态
		users_ZGTService.updateIsPY("0", openid);
		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/YuJuanServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}