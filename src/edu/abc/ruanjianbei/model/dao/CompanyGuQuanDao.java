package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.GuQuan;
import edu.abc.ruanjianbei.model.bean.Guquanxinxi;

public interface CompanyGuQuanDao extends BaseDao{
	
	//���Ҹ��˹ɶ���Ϣ
	public GuQuan Selectguquan(String comname);
	//���ҹ�˾�ɶ���Ϣ
	public ArrayList<Guquanxinxi> Selectcomguquan(String comname);
}
