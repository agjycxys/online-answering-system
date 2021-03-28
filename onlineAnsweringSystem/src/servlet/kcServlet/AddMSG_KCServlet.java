package servlet.kcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MSGService;

public class AddMSG_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int msgid = Integer.valueOf(request.getParameter("msgid"));
		int kcid = Integer.valueOf(request.getParameter("kcid"));

		MSGService msgService = new MSGService();
		msgService.addmsg_kc(kcid, msgid);
		// 转发到jsp
		request.getRequestDispatcher("/QueryMSG_KCServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}