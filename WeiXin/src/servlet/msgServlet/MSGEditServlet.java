package servlet.msgServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;

import service.MSGService;

public class MSGEditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求参数
		String msgaccout = request.getParameter("msgaccout");
		String msgpwd = request.getParameter("msgpwd");
		String msgname = request.getParameter("msgname");
		String msgphone = request.getParameter("msgphone");
		int msgid = Integer.valueOf(request.getParameter("msgid"));
		// 封装
		MSG msg = new MSG();
		msg.setMsgaccount(msgaccout);
		msg.setMsgpwd(msgpwd);
		msg.setMsgname(msgname);
		msg.setMsgphone(msgphone);
		msg.setMsgid(msgid);
		
		MSGService msgService = new MSGService();
		msgService.editMSG(msg);

		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/msgQueryAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}