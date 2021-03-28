package servlet.hrServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MSGService;
import service.Users_ZGTService;
import domain.Users_ZGT;

public class IsPYInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Users_ZGTService users_ZGTService = new Users_ZGTService();
		List<Users_ZGT> usersZGT = users_ZGTService.queryAll();
		request.setAttribute("usersZGT", usersZGT);

		// 转发到jsp
		request.getRequestDispatcher("/HR/ispingyueReset.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}