package servlet.msgServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;


import service.MSGService;

public class MSGInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	    int msgid = (int) request.getSession().getAttribute("msgid") ;
		MSGService msgService = new MSGService();
		List<MSG> msgInfo = msgService.queryMSGByMSGid(msgid);
		
		
		request.setAttribute("msgInfo", msgInfo);
		
		request.getRequestDispatcher("/MSG/msg_info.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}