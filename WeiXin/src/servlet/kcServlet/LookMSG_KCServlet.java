package servlet.kcServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MSG;


import service.MSGService;

public class LookMSG_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int kcid = Integer.valueOf(request.getParameter("kcid"));
		MSGService msgService = new MSGService();
		List<MSG> lookmsg_kc = msgService.lookmsg_kc(kcid);

		request.setAttribute("lookmsg_kc", lookmsg_kc);
		request.setAttribute("kcid", kcid);
		// 转发到jsp
		request.getRequestDispatcher("/admin/kc/lookmsg_kc.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}