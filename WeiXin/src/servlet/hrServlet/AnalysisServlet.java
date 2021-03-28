package servlet.hrServlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.AllResult;
import domain.KC;
import domain.TiMu;

import service.AllResultService;
import service.KCService;
import service.TK_TMService;
import service.TiKuService;

public class AnalysisServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取选中的kcid和tkid
		int kcid = Integer.valueOf(request.getParameter("kcid"));
		int tkid = Integer.valueOf(request.getParameter("tkid"));
		AllResultService allResultService = new AllResultService();
		List<AllResult> allResult = allResultService.queryResults(kcid, tkid);
		double sum = allResult.size();
		
		//获取考场名称
		KCService kcService = new KCService();
		KC kc = kcService.queryKCNameByKCid(kcid);
		//获取题库名称
		TiKuService tiKuService = new TiKuService();
		String tkname = tiKuService.queryTKNameByTKid(tkid);

		//获取题库中题目
		TK_TMService tk_TMService = new TK_TMService();
		List<TiMu> allTM = tk_TMService.queryTMByTKid(tkid);
		//存储每个题的正确率
		int[] results = new int[allResult.get(0).getResults().split(",").length];
		int[] s2 = new int[allResult.get(0).getResults().split(",").length];
		List<Object> list = new ArrayList<Object>();
		
		for(int i = 0;i<allResult.size();i++){
			String[] s1 =  allResult.get(i).getResults().split(",") ;
			for(int j = 0;j<s1.length;j++){
				s2[j] = Integer.valueOf(s1[j]);
			}
			for(int k = 0;k<s2.length;k++){
				results[k] = results[k]+s2[k];
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=0;i<results.length;i++){
			double d = results[i];
			double e = Double.valueOf(df.format(d/sum));
			list.add(e*100);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("allTM", allTM);
		request.setAttribute("kcname", kc.getKcname());
		request.setAttribute("tkname", tkname);
		// 转发到jsp
		request.getRequestDispatcher("admin/allResult/ecarts.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}