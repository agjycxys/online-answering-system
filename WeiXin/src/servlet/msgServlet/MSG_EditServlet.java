package servlet.msgServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;

import service.MSGService;

public class MSG_EditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取参数
		String msgname = request.getParameter("msgname");
		String msgphone = request.getParameter("msgphone");
		String msgaccount = request.getParameter("msgaccount");
		String msgpwd = request.getParameter("msgpwd");
		int msgid = Integer.valueOf(request.getParameter("msgid"));
		MSG msg = new MSG();
		msg.setMsgname(msgname);
		msg.setMsgphone(msgphone);
		msg.setMsgaccount(msgaccount);
		msg.setMsgpwd(msgpwd);
		msg.setMsgid(msgid);
		MSGService msgService = new MSGService();
		msgService.editMSG(msg);
		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/MSGInfoServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}