package edu.abc.ruanjianbei.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.abc.ruanjianbei.model.bean.UserBean;
import edu.abc.ruanjianbei.model.dao.UserDao;
import edu.abc.ruanjianbei.model.dao.UserDaoImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        dao=new UserDaoImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName=request.getParameter("method");
		switch(methodName) {
			case "login":
				login(request,response);
				break;
			case "register":
				register(request,response);
				break;
			case "loginOff":
				loginOff(request,response);
				break;
			case "checkUserExists":
				checkUserExists(request,response);
			default:
				break;
		}
		
	}
	/*
	 * �����¼����
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account=request.getParameter("account").trim();
		String password=request.getParameter("password").trim();
		System.out.println("��¼����"+account+"\t"+password);
		UserBean user=dao.login(account, password);
		
		if(user!=null){
			//�Ự��Χ�ڴ洢�û�����
			request.getSession().setAttribute("loginedUser", user);
			String rememberMe=request.getParameter("rememberMe");
			System.out.println("��ס��"+rememberMe);
			//�û���ѡ�����û�������ͽ��û�������洢��cookie��
			if(rememberMe!=null) {
				
			}else {
			
			}

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.setAttribute("loginResultInfo", "userError");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	/*
	 * ����ע�᷽��
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account=request.getParameter("account").trim();
		String password=request.getParameter("password").trim();
		System.out.println("ע�����"+account+"\t"+password);
		UserBean user=new UserBean();
		user.setAccount(account);
		user.setPassword(password);
		boolean result=dao.add(user);
		if(result) {
			request.getSession().setAttribute("loginedUser", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("loginResultInfo", "registerError");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	/*
	 * ����ע������
	 */
	protected void loginOff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�˳���½");
		request.getSession().removeAttribute("loginedUser");
		response.sendRedirect("index.jsp");
	}
	/*
	 * ��֤ע����û��Ƿ����
	 */
	protected void checkUserExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ajax����û����Ƿ��Ѿ�����");
		String account=request.getParameter("account");
		boolean result=dao.checkUserExist(account);
		
		response.setContentType("text/html;charset=UTF-8");//(text/html   text/xml   text/json)
		//��ȡ��Ӧ����������
		PrintWriter out=response.getWriter();
		out.write(result+"");
		out.flush();
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
