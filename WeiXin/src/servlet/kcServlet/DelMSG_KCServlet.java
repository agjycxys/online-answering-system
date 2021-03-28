package servlet.kcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MSGService;

public class DelMSG_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int msgid = Integer.valueOf(request.getParameter("msgid"));
		MSGService msgService = new MSGService();
		msgService.delmsg_kc(msgid);
		// 转发到jsp
		request.getRequestDispatcher("/QueryMSG_KCServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}