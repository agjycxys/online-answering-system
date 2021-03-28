package servlet.usersServlet;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.TiKu;
import domain.TiMu;
import domain.Users;

import service.KCService;
import service.KC_TKService;
import service.TK_TMService;
import service.TiKuService;
import service.UsersService;

public class AddUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 接收参数
		String usersname = request.getParameter("usersname");
		String xingbie = request.getParameter("xingbie");
		String dianhua = request.getParameter("dianhua");
		String xuexiao = request.getParameter("xuexiao");
		String zhuanye = request.getParameter("zhuanye");
		String xueli = request.getParameter("xueli");
		String wxname = request.getParameter("wxname");
		String openid = request.getParameter("openid");
		int kcid = Integer.valueOf(request.getParameter("kcid"));
		// 封装
		Users users = new Users();
		users.setUsersname(usersname);
		users.setXingbie(xingbie);
		users.setDianhua(dianhua);
		users.setXuexiao(xuexiao);
		users.setZhuanye(zhuanye);
		users.setXueli(xueli);
		users.setWxname(wxname);
		users.setOpenid(openid);
		users.setKcid(kcid);
		UsersService usersService = new UsersService();
		usersService.addUserInfo(users);

		// 取出一个tkid
		KC_TKService kc_TKService = new KC_TKService();
		int tkid = (int) kc_TKService.queryTKidByKCid(kcid);
		
		// 根据tkid查询题库中每个题目
		TK_TMService tk_TMService = new TK_TMService();
		List<TiMu> allTM = tk_TMService.queryTMByTKid(tkid);
		//根据tkid查询tkname
		TiKuService tiKuService = new TiKuService();
		String tkname = tiKuService.queryTKNameByTKid(tkid);
		//根据tkid查询已添加题目总分
		Object tmscores = tk_TMService.queryTMScoresBytkid(tkid);
		
		// 获取kcid的开考时间和结束时间
		KCService kcService = new KCService();
		String starttime = (String) kcService.queryStarttimeByKCid(kcid);
		String endtime = (String) kcService.queryEndtimeByKCid(kcid);
		Time jstime = jstime(starttime,endtime);
		
		// 储存题目
		request.setAttribute("tkid", tkid);
		request.setAttribute("allTM", allTM);
		request.setAttribute("starttime", starttime);
		request.setAttribute("jstime", jstime);
		request.setAttribute("openid", openid);
		request.setAttribute("tkname", tkname);
		request.setAttribute("tmscores", tmscores);
		request.setAttribute("kcid", kcid);
		// 转发到jsp
		request.getRequestDispatcher("users/exam.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public Time jstime(String starttime, String endtime) {
		DateFormat time = new SimpleDateFormat("HH:mm");
		try {
			Date startdate = time.parse(starttime);
			Date enddate = time.parse(endtime);
			Time djstime = new Time(enddate.getTime() - startdate.getTime() - 8
					* 60 * 60 * 1000);
			return djstime;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}