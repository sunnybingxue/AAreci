package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CompanyDao extends BaseDao{
	
	/*
	 * ͨ�������ֵ����ƥ��Ĺ�˾��
	 */
	public ArrayList<T_CORPBean> selectByCompanyName(String name);
	/*
	 * ͨ����˾����ѯ��˾�����Ϣ
	 */
	public T_CORPBean searchOneCompany(int org,int id,int seq_id);
	/*
	 * ͨ����˾����������ù�˾�Ĺɶ�
	 */
	public ArrayList<ChildrenBean> selectGuDongByCompanyName(String name,String type);
	/*
	 * ͨ����˾����������ù�˾�Ķ���Ͷ��
	 */
	public ArrayList<ChildrenBean> selectTouZiByCompanyName(String name,String type);

}
