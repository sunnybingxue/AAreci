package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CreateDataDao extends BaseDao{
	//�������ݿ����
	public Boolean insertData(String sql);
	
	//�������ݿ�,�����ѯ��˾��Ϣ
	public ArrayList<String> searchData();
	
	//��ҳ������˾һ����˾����Ϣ
	public T_CORPBean searchOneCorp(String sql);
		
}
