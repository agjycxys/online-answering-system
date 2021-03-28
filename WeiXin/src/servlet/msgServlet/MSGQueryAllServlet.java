package servlet.msgServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;


import service.MSGService;

public class MSGQueryAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 通知service层查询所有面试官
		MSGService msgService = new MSGService();
		List<MSG> allMSG = msgService.queryMSGAll();
		// 存放数据在request域
		request.setAttribute("allMSG", allMSG);
		// 转发到jsp
		request.getRequestDispatcher("/admin/msg/msg_list.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}