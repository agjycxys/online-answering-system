package servlet.kcServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiKu;


import service.KC_TKService;

public class LookTK_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int kcid = Integer.valueOf(request.getParameter("kcid"));
		KC_TKService kc_TKService = new KC_TKService();
		List<TiKu> alltk = kc_TKService.queryTkByKCid(kcid);
		request.setAttribute("alltk", alltk);
		// 转发到jsp
		request.getRequestDispatcher("/admin/kc/looktk_kc.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}