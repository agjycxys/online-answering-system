package servlet.msgServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users_ZGT;


import service.MSGService;

public class YuJuanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int msgid = (int) request.getSession().getAttribute("msgid") ;
		MSGService msgService = new MSGService();
		List<Users_ZGT> usersZGT = msgService.queryUsers_zgtByMSGid(msgid);
		
		request.setAttribute("usersZGT", usersZGT);
		
		// 转发到jsp
		request.getRequestDispatcher("/MSG/user_zgt.jsp").forward(
				request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}