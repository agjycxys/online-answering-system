package servlet.usersServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.AllResult;
import domain.TiMu;
import domain.Users_ZGT;

import net.sf.json.JSONObject;

import service.AllResultService;
import service.TK_TMService;
import service.UsersService;
import service.Users_ZGTService;

public class ExamEndServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取参数
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		String openid = request.getParameter("openid");
		String[] answers = request.getParameterValues("answers");
		int kcid = Integer.valueOf(request.getParameter("kcid"));

		// 存储主观题
		Users_ZGT users_ZGT = new Users_ZGT();
		Users_ZGTService users_ZGTService = new Users_ZGTService();
		// 存储客观题成绩
		UsersService usersService = new UsersService();
		// 查询用户名字
		String usersname = (String) usersService.queryNameByOpenid(openid);
		// 根据tkid查询题库中每个题目
		TK_TMService tk_TMService = new TK_TMService();
		List<TiMu> allTM = tk_TMService.queryTMByTKid(tkid);
		int kgtscore = 0;
		// 存储用户的所有答案对错
		List<String> allAnswers = new ArrayList<String>();

		for (int i = 0; i < allTM.size(); i++) {
			TiMu tm = allTM.get(i);
			if (tm.getTmtype().equals("简答题")) {
				String usersZGT = answers[i];
				System.out.println(usersZGT);
				String tmname = tm.getTmname();
				users_ZGT.setTmid(tm.getTmid());
				users_ZGT.setUsersname(usersname);
				users_ZGT.setOpenid(openid);
				users_ZGT.setTmname(tmname);
				users_ZGT.setZgtanswer(usersZGT);
				users_ZGT.setTmscore(tm.getTmscore());
				// 存储主观题
				users_ZGTService.AddZGT(users_ZGT);
			} else {
				String usersXZ = answers[i];
				System.out.println(usersXZ);
				if (usersXZ.equals(tm.getAnswer())) {
					kgtscore = kgtscore + Integer.valueOf(tm.getTmscore());
					allAnswers.add("1");
				} else {
					kgtscore = kgtscore + 0;
					allAnswers.add("0");
				}
				// 将用户客观题成绩存储
				usersService.addKGTscore(kgtscore, openid);
			}
		}
		// 存储用户的答案对错
		String results = jhTozfc(allAnswers);
		AllResult allResult = new AllResult();
		allResult.setOpenid(openid);
		allResult.setKcid(kcid);
		allResult.setTkid(tkid);
		allResult.setResults(results);
		AllResultService allResultService = new AllResultService();
		allResultService.addResult(allResult);

		// 转换json发送
		JSONObject json = new JSONObject();
		json.put("kgtscore", kgtscore);
		PrintWriter out = response.getWriter(); // 向客户端发送字符数据
		out.println(json.toString());
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 将集合转换为字符串
	 * 
	 * @return
	 */
	public String jhTozfc(List<String> list) {
		String s = "";
		for (int i = 0; i < list.size(); i++) {
			if (s == "") {
				s = list.get(i);
			} else {
				s = s + "," + list.get(i);
			}
		}
		return s;
	}
}