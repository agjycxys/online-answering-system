package servlet.msgServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;


import service.UsersService;

public class MSG_NameQueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String usersname = request.getParameter("usersname");
		UsersService usersService = new UsersService();
		List<Users> usersInfo = usersService.queryUsersByName(usersname);
		request.setAttribute("usersInfo", usersInfo);
		//转发jsp
		request.getRequestDispatcher("MSG/userInfo.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}