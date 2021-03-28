package servlet.kcServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;


import service.MSGService;

public class QueryMSG_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int kcid = Integer.valueOf(request.getParameter("kcid"));
		MSGService msgService = new MSGService();
		List<MSG> allMSG = msgService.queryMSGAll();
		
		request.setAttribute("allMSG", allMSG);
		request.setAttribute("kcid", kcid);
		// 转发到jsp
		request.getRequestDispatcher("/admin/kc/addmsg_kc.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}