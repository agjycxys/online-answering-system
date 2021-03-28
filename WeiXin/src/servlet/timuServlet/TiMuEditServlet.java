package servlet.timuServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiMu;


import service.TiMuService;

public class TiMuEditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String tmname = request.getParameter("tmname");
		String tmtype = request.getParameter("tmtype");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		String tmscore = request.getParameter("tmscore");
		int tmid = Integer.valueOf(request.getParameter("tmid"));
		//封装
		TiMu timu = new TiMu();
		timu.setTmname(tmname);
		timu.setTmtype(tmtype);
		timu.setOptionA(optionA);
		timu.setOptionB(optionB);
		timu.setOptionC(optionC);
		timu.setOptionD(optionD);
		timu.setAnswer(answer);
		timu.setTmscore(tmscore);
		timu.setTmid(tmid);
		
		TiMuService timuservice = new TiMuService();
		timuservice.editTiMu(timu);
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/timuQueryAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}