package edu.abc.ruanjianbei.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.Graphdata;
import edu.abc.ruanjianbei.model.bean.GuQuan;
import edu.abc.ruanjianbei.model.bean.Guquanxinxi;
import edu.abc.ruanjianbei.model.bean.Links;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.dao.CompanyDao;
import edu.abc.ruanjianbei.model.dao.CompanyDaoImpl;
import edu.abc.ruanjianbei.model.dao.CompanyGuQuanDao;
import edu.abc.ruanjianbei.model.dao.CompanyGuQuanDaoImpl;
import edu.abc.ruanjianbei.model.dao.CompanyGuanXiDao;
import edu.abc.ruanjianbei.model.dao.CompanyGuanXiDaoImpl;
import edu.abc.ruanjianbei.model.dao.CompanyPertainsDao;
import edu.abc.ruanjianbei.model.dao.CompanyPertainsDaoImp;

@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CompanyDao companydao;
    private CompanyPertainsDao companypertainsdao;
    private CompanyGuanXiDao companyguanxi;
    private CompanyGuQuanDao guquandao;
    public CompanyServlet() {
        super();
        companydao=new CompanyDaoImpl();
        companypertainsdao=new CompanyPertainsDaoImp();
        companyguanxi=new CompanyGuanXiDaoImpl();
        guquandao=new CompanyGuQuanDaoImpl();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String methodName = request.getParameter("method");
		//System.out.println("CompanyServlet:"+methodName);
		switch (methodName) {
		case "searchAll":
			searchAll(request,response);
			break;
		case "searchName":
			searchName(request,response);
			break;
		case "touzizupu":
			touzizupu(request,response);
			break;
		case "yisiguanxi":
			yisiguanxi(request,response);
			break;
		case "corpzupu":
			corpzupu(request,response);
			break;
		case "guquanjiegou":
			guquanjiegou(request,response);
			break;
		default:
			break;
		}
	}
	/*
	 * ��������Ĺ�˾��\������ѯ��˾����Ϣ
	 */
	protected void searchAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("CorpName");
		String org=request.getParameter("ORG");
		String id=request.getParameter("ID");
		String seq_id=request.getParameter("SEQ_ID");
		if(org!=""&&id!=""&&seq_id!="") {
			T_CORPBean companymeg=companydao.searchOneCompany(Integer.valueOf(org),Integer.valueOf(id),Integer.valueOf(seq_id));
			request.setAttribute("companymeg", companymeg);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	/*
	 * ������˾��ģ��ƥ��
	 */
	protected void searchName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("CorpName");
		ArrayList<T_CORPBean> companys = companydao.selectByCompanyName(name);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(companys);
		
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	/*
	 * ��ʾͶ�������е�Ͷ����Ϣ
	 */
	protected void touzizupu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CORP_NAME = request.getParameter("CORP_NAME");
		String org=request.getParameter("ORG");
		String id=request.getParameter("ID");
		String seq_id=request.getParameter("SEQ_ID");
		//System.out.println("Ͷ�����ײ�ѯ��˾���ƣ�"+CORP_NAME+","+org+","+id+","+seq_id);
		
		String companyLevel=request.getParameter("companyLevel");
		String stockLevel=request.getParameter("stockLevel");
		//System.out.println("�ɶ��㼶��"+stockLevel);
		//System.out.println("����Ͷ�ʲ㼶��"+companyLevel);

		//�洢��ѯ������������
		ArrayList<ChildrenBean> allData=new ArrayList<>();
		
		//��ӽڵ�����
		ArrayList<ChildrenBean> node=levelNode(CORP_NAME);
		allData.addAll(node);
		
		//��ѯ�ɶ��㼶��Ϣ
		ArrayList<ChildrenBean> firstStockLevelData=new ArrayList<>();
		//�洢ÿ�������ĸ��˹ɶ�����
		ArrayList<ChildrenBean> stockData=new ArrayList<>();
		firstStockLevelData=companydao.selectGuDongByCompanyName("�ɶ�",CORP_NAME);
		stockData=searchStock(firstStockLevelData,firstStockLevelData, Integer.parseInt(stockLevel));
		allData.addAll(stockData);
		
		//��ѯ����Ͷ�ʲ㼶��Ϣ
		ArrayList<ChildrenBean> firstCompayLevelData=new ArrayList<>();
		//�洢ÿ�������Ĺ�˾�ɶ�����
		ArrayList<ChildrenBean> companyData=new ArrayList<>();
		firstCompayLevelData =companydao.selectTouZiByCompanyName("����Ͷ��",CORP_NAME);
		companyData=searchCompany(firstCompayLevelData,firstCompayLevelData, Integer.parseInt(companyLevel));
		allData.addAll(companyData);
		
		ToJSONString(response, allData);
		
	}

	/*
	 * ���Ͷ�����׽ڵ���Ϣ
	 */
	public ArrayList<ChildrenBean> levelNode(String CORP_NAME) {
		ArrayList<ChildrenBean> node=new ArrayList<>();
		ChildrenBean root=new ChildrenBean(CORP_NAME, "", "");
		ChildrenBean root1=new ChildrenBean("�ɶ�", CORP_NAME, "");
		ChildrenBean root2=new ChildrenBean("����Ͷ��", CORP_NAME, "");
		node.add(root);
		node.add(root1);
		node.add(root2);
		return node;
	}
	/*
	 *�����ҵ���׽ڵ���Ϣ 
	 */
	public ArrayList<ChildrenBean> corpLevelNode(String CORP_NAME){
		ArrayList<ChildrenBean> node=new ArrayList<>();
		ChildrenBean root=new ChildrenBean(CORP_NAME, "", "");
		ChildrenBean root1=new ChildrenBean("�ɶ�", CORP_NAME, "");
		ChildrenBean root2=new ChildrenBean("����Ͷ��", CORP_NAME, "");
		ChildrenBean root3=new ChildrenBean("�߹�", CORP_NAME, "");
		ChildrenBean root4=new ChildrenBean("��������", CORP_NAME, "");
		ChildrenBean root5=new ChildrenBean("��Ժ����", CORP_NAME, "");
		ChildrenBean root6=new ChildrenBean("��ʷ�ɶ�", CORP_NAME, "");
		ChildrenBean root7=new ChildrenBean("��ʷ����", CORP_NAME, "");
		node.add(root);
		node.add(root1);
		node.add(root2);
		node.add(root3);
		node.add(root4);
		node.add(root5);
		node.add(root6);
		node.add(root7);
		return node;
	}
	/*
	 * ����ѯ��������ת��Ϊjson��ʽ����ǰ̨
	 */
	protected void ToJSONString(HttpServletResponse response, ArrayList<ChildrenBean> stockData) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper=new ObjectMapper();
		String jsonString =mapper.writeValueAsString(stockData);
		//System.out.println("��ѯ����json����"+jsonString);
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
		
	}
	/*
	 * ��ʾ��ҵ������Ϣ
	 */
	protected void corpzupu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CORP_ORG = request.getParameter("CORP_ORG");
		String CORP_SEQ_ID = request.getParameter("CORP_SEQ_ID");
		//System.out.println("��ҵ���ף�"+CORP_ORG+","+CORP_SEQ_ID);
		String CORP_NAME = request.getParameter("CORP_NAME");
		//System.out.println("��ҵ���׹�˾����"+CORP_NAME);
		//�洢��ѯ������������Ϣ
		ArrayList<ChildrenBean> allData=new ArrayList<>();
		
		
		ArrayList<ChildrenBean> CompayLevelData=companydao.selectTouZiByCompanyName("����Ͷ��", CORP_NAME);
		ArrayList<ChildrenBean> StockLevelData=companydao.selectGuDongByCompanyName("�ɶ�", CORP_NAME);

		ArrayList<ChildrenBean> corpMember=companypertainsdao.selectMemberByCompany("�߹�",CORP_NAME,Integer.parseInt(CORP_ORG),Integer.parseInt(CORP_SEQ_ID));
		//System.out.println("��һ��ɶ�����"+StockLevelData);
		allData.addAll(corpMember);
		allData.addAll(searchStockCorp(StockLevelData,StockLevelData,10));
		allData.addAll(searchCompanyCorp(CompayLevelData,CompayLevelData,10));
		//��ӽڵ���Ϣ
		allData.addAll(corpLevelNode(CORP_NAME));
		
		ToJSONString(response, allData);
		
	}
	/*
	 * ͨ���ݹ��ѯ�ɶ��㼶����(��ҵ����)
	 */
	public ArrayList<ChildrenBean> searchStockCorp(ArrayList<ChildrenBean> stockLevelData,ArrayList<ChildrenBean> leveldata,int level){
		//�洢һ�����Ϣ
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		//�洢һ���ڵ�����Ϣ
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectGuDongByCompanyName(childrenBean.getId(), childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
				stockLevelData.addAll(levelData);
				searchStockCorp(stockLevelData,levelData, (level-1));
		}
		return stockLevelData;
	}
	/*
	 * ͨ���ݹ��ѯ����Ͷ�ʲ㼶����(��ҵ����)
	 */
	public ArrayList<ChildrenBean> searchCompanyCorp(ArrayList<ChildrenBean> companyLevelData,ArrayList<ChildrenBean> leveldata,int level){
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		//���ݹ鵽�ڶ������
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectTouZiByCompanyName(childrenBean.getId(), childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
				companyLevelData.addAll(levelData);
				searchCompanyCorp(companyLevelData,levelData,(level-1));
		}
		
		return companyLevelData;
	}
	/*
	 * ͨ���ݹ��ѯ�ɶ��㼶����
	 */
	public ArrayList<ChildrenBean> searchStock(ArrayList<ChildrenBean> stockLevelData,ArrayList<ChildrenBean> leveldata,int level){
		//�洢һ�����Ϣ
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		//�洢һ���ڵ�����Ϣ
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectGuDongByCompanyName(childrenBean.getId(), childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
			if(levelData.isEmpty()) {
				//����ǰ��ҳ�棬�Ƿ��в㼶��ϵ
				ChildrenBean flag=new ChildrenBean("stockLevelWarning","","û�и���ɶ��㼶��");
				stockLevelData.add(flag);
			}else {
				stockLevelData.addAll(levelData);
				searchStock(stockLevelData,levelData, (level-1));
			}
		}
		return stockLevelData;
	}
	/*
	 * ͨ���ݹ��ѯ����Ͷ�ʲ㼶����
	 */
	public ArrayList<ChildrenBean> searchCompany(ArrayList<ChildrenBean> companyLevelData,ArrayList<ChildrenBean> leveldata,int level){
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		//���ݹ鵽�ڶ������
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectTouZiByCompanyName(childrenBean.getId(), childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
			if(levelData.isEmpty()) {
				//����ǰ��ҳ�棬�Ƿ��в㼶��ϵ
				ChildrenBean flag=new ChildrenBean("companyLevelWarning","","û�и������Ͷ�ʲ㼶��");
				companyLevelData.add(flag);
			}else {
				companyLevelData.addAll(levelData);
				searchCompany(companyLevelData,levelData,(level-1));
			}
		}
		return companyLevelData;
	}
	

	/*
	 * ��ʾ��˾���ɶ�֮������ƹ�ϵ
	 */
	protected void yisiguanxi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CORP_NAME = request.getParameter("CORP_NAME");
		//System.out.println("���ƹ�ϵ����˾��"+CORP_NAME);
		ArrayList<Links> graphlinks=new ArrayList<>();
		ArrayList<Links> GuDongTouZi=companyguanxi.selectTouZiOutside(CORP_NAME);
		ArrayList<Links> GuDongRenZhi=companyguanxi.selectGuDongRenZhiOutside(CORP_NAME);
		ArrayList<Links> GaoGuanRenZhi=companyguanxi.selectGaoGuanRenZhiOutside(CORP_NAME);
		//System.out.println("GuDongTouZi "+GuDongTouZi);
		//System.out.println("GuDongRenZhi "+GuDongRenZhi);
		//System.out.println("GaoGuanRenZhi "+GaoGuanRenZhi);
		graphlinks.addAll(GuDongTouZi);
		graphlinks.addAll(GuDongRenZhi);
		graphlinks.addAll(GaoGuanRenZhi);
		HashSet<Graphdata> TouZiGuDong=new HashSet<>();
		HashSet<Graphdata> RenZhiGuDong=new HashSet<>();
		HashSet<Graphdata> RenZhiGaoGuan=new HashSet<>();
		for (Links link : GuDongTouZi) {
			String source=link.getSource();
			String target=link.getTarget();
			Graphdata gudong=new Graphdata(source, 0, "true");
			Graphdata gongsi=new Graphdata(target, 1, "true");
			TouZiGuDong.add(gudong);
			RenZhiGuDong.add(gongsi);
		}
		for (Links link : GuDongRenZhi) {
			String source=link.getSource();
			String target=link.getTarget();
			Graphdata gudong=new Graphdata(source, 0, "true");
			Graphdata gongsi=new Graphdata(target, 1, "true");
			TouZiGuDong.add(gudong);
			RenZhiGuDong.add(gongsi);
		}
		for (Links link : GaoGuanRenZhi) {
			String source=link.getSource();
			String target=link.getTarget();
			Graphdata gaoguan=new Graphdata(source, 2, "true");
			Graphdata gongsi=new Graphdata(target, 1, "true");
			RenZhiGaoGuan.add(gaoguan);
			RenZhiGuDong.add(gongsi);
		}
		//System.out.println("%%% "+TouZiGuDong);
		//System.out.println("%%% "+RenZhiGuDong);
		//System.out.println("%%% "+RenZhiGaoGuan);
		
		TouZiGuDong.addAll(RenZhiGuDong);
		TouZiGuDong.addAll(RenZhiGaoGuan);
		
		Object[] alldata= {graphlinks,TouZiGuDong};
		ObjectMapper mapper=new ObjectMapper();
		String jsonString =mapper.writeValueAsString(alldata);
		//System.out.println("��ѯ����json����"+jsonString);
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	/*
	 * ��������Ĺ�˾����ѯ��˾�Ĺ�Ȩ�ṹ
	 */
	protected void guquanjiegou(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("CORP_NAME");
		GuQuan guquandata=guquandao.Selectguquan(name);
		sortbypercent(guquandata.getGudongxinxi());
		ArrayList<Guquanxinxi> comguquan=guquandao.Selectcomguquan(name);
		sortbypercent(comguquan);
		guquandata.setComxinxi(comguquan);
		ObjectMapper mapper=new ObjectMapper();
		String jsonString =mapper.writeValueAsString(guquandata);
		//System.out.println("��ѯ���Ĺ�Ȩjson����"+jsonString);
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	/*
	 * ���ɶ�����Ϣͨ����ռ�ٷֱȽ��н�������
	 */
	public void sortbypercent(ArrayList<Guquanxinxi> guquan) {
		Collections.sort(guquan, new Comparator<Guquanxinxi>() {
			@Override
			public int compare(Guquanxinxi o1, Guquanxinxi o2) {
				String guquanbili1=o1.getGuquanbili();
				String guquanbili2=o2.getGuquanbili();
				//System.out.println("��Ȩ�����Ƚϣ�"+guquanbili1);
				//System.out.println("��Ȩ�����Ƚϣ�"+guquanbili2);
				double bili1=Double.valueOf(guquanbili1.substring(0, guquanbili1.lastIndexOf("%")));
				double bili2=Double.valueOf(guquanbili2.substring(0, guquanbili2.lastIndexOf("%")));
				//System.out.println("��Ȩ����ת����"+bili1+","+bili2);
				if(bili1>bili2) {
					return -1;
				}else {
					return 1;
				}
			}
			
		});
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
