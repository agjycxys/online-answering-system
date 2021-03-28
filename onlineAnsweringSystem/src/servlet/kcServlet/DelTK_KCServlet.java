package servlet.kcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.KC_TKService;

public class DelTK_KCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		
		KC_TKService kc_TKService = new KC_TKService();
		kc_TKService.deltk_kc(tkid);
		// 转发到jsp
		request.getRequestDispatcher("/QueryTK_KCServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}