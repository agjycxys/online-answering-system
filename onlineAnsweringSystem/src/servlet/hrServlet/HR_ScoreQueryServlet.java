package servlet.hrServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;


import service.UsersService;

public class HR_ScoreQueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取参数
		int minscore = Integer.valueOf(request.getParameter("minscore"));
		int maxscore = Integer.valueOf(request.getParameter("maxscore"));
		System.out.println(minscore);
		System.out.println(maxscore);
		UsersService usersService = new UsersService();
		List<Users> usersInfo = null;
		if (minscore == 0) {
			usersInfo = usersService.queryUsersByMaxScore(maxscore);
		}
		if (maxscore == 0) {
			usersInfo = usersService.queryUsersByMinScore(minscore);
		}
		if (minscore != 0 && maxscore != 0) {
			usersInfo = usersService.queryUsersByScore(minscore,maxscore);
		}
		request.setAttribute("usersInfo", usersInfo);
		// 转发jsp
		request.getRequestDispatcher("HR/userInfoByScore.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}