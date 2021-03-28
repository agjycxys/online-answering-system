package servlet.tikuServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiMu;


import service.TK_TMService;
import service.TiKuService;

public class LookTM_TKServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int tkid = Integer.valueOf(request.getParameter("tkid"));

		TK_TMService tk_TMService = new TK_TMService();
		List<TiMu> allTM = tk_TMService.queryTMByTKid(tkid);
		
		Object tmscores = tk_TMService.queryTMScoresBytkid(tkid);
		
		TiKuService tiKuService = new TiKuService();
		String tkscore = tiKuService.queryTKScoreByTkid(tkid);
		
		request.setAttribute("allTM", allTM);
		request.setAttribute("tkscore", tkscore);
		request.setAttribute("tmscores", tmscores);
		// 转发到jsp
		request.getRequestDispatcher("/admin/tiku/looktm_tk.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}