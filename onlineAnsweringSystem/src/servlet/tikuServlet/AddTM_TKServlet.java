package servlet.tikuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TK_TMService;

public class AddTM_TKServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		int tmid = Integer.valueOf(request.getParameter("tmid"));

		TK_TMService tk_TMService = new TK_TMService();
		tk_TMService.addtm_tk(tkid, tmid);
		// 转发到jsp
		request.getRequestDispatcher("/QueryTM_TKServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}