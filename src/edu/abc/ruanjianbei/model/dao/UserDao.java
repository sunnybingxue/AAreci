package edu.abc.ruanjianbei.model.dao;

import edu.abc.ruanjianbei.model.bean.UserBean;

public interface UserDao extends BaseDao {
	
	//�����¼�¼�
	public UserBean login(String account, String password);
	//��֤�û��Ƿ��Ѿ�����
	public boolean checkUserExist(String account);

}
