package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.Links;

public interface CompanyGuanXiDao extends BaseDao{
//	��ѯ������Ĺɶ�����Ͷ�����
	public ArrayList<Links> selectTouZiOutside(String corpName);
	public ArrayList<Links> selectRenZhiOutside(String corpName,String sql);
//	��ѯ������ɶ�������ְ���
	public ArrayList<Links> selectGuDongRenZhiOutside(String corpName);
//	��ѯ������߹�������ְ���
	public ArrayList<Links> selectGaoGuanRenZhiOutside(String corpName);
}
