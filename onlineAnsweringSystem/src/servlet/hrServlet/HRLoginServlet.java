package servlet.hrServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;

import service.AdminService;

public class HRLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 接受表单提交的参数
		String adname = request.getParameter("adname");
		String adpwd = request.getParameter("adpwd");
		// 封装到实体对象中
		Admin admin = new Admin();
		admin.setAdname(adname);
		admin.setAdpwd(adpwd);
		// 调用service层处理数据
		AdminService adminService = new AdminService();
		Admin existAdmin = adminService.login(admin);
		// 根据处理结果显示信息(页面跳转)
		if (existAdmin == null) {
			request.setAttribute("error", "用户名或密码不正确 !");
			request.getRequestDispatcher("HR/hrLogin.jsp").forward(request,
					response);
		} else {
			request.setAttribute("adname", admin.getAdname());
			request.getRequestDispatcher("HR/HRMain.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}