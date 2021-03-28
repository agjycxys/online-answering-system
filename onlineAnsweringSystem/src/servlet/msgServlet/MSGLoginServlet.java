package servlet.msgServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;

import service.MSGService;

public class MSGLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String msgaccount = request.getParameter("msgaccount");
		String msgpwd = request.getParameter("msgpwd");
		MSG msg = new MSG();
		msg.setMsgaccount(msgaccount);
		msg.setMsgpwd(msgpwd);
		MSGService msgService = new MSGService();
		MSG existmsg = msgService.login(msg);
		int msgid = (int) msgService.queryMSGid(msgaccount);
		// 根据处理结果显示信息(页面跳转)
		if (existmsg == null) {
			request.setAttribute("error", "用户名或密码不正确 !");
			request.getRequestDispatcher("MSG/msgLogin.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msgid", msgid);
			request.getRequestDispatcher("MSG/MSGMain.jsp").forward(
					request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}