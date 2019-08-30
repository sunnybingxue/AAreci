package edu.abc.ruanjianbei.createdata;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.bean.T_CORP_STOCKBean;
import edu.abc.ruanjianbei.model.dao.CreateDataDao;
import edu.abc.ruanjianbei.model.dao.CreateDataDaoImp;

public class CORP_Data {
	
	private int ORG;//һ����˾Ψһ
	private int ID;//�����ҵ
	private int SEQ_ID;//ÿ���ܹ�˾����
	private String REG_NO;//ÿ����˾Ψһ
	private	String CORP_NAME;
	private	String ADDR;
	private	String BELONG_ORG;
	private	String BELONG_DIST_ORG;
	private	String BELONG_TRADE;
	private	String ECON_KIND;
	private	String ADMIT_MAIN;
	private	String START_DATE;
	private	String CHECK_DATE;
	private	String OPER_MAN_IDENT_NO;
	private	String OPER_MAN_NAME;
	private	String CORP_STATUS;
	private	float REG_CAPI;
	private	String FARE_TERM_START;
	private	String FARE_TERM_END;
	private	String FARE_SCOPE;
	private	String UNI_SCID;
	private	String TEL;
	private	String WEB_URL;
	private	String EMAIL;
	private	int PRAC_PERSON_NUM;
	private	String ORG_INST_CODE;
	private	String TAXPAY_NUM;
	private	String STAFF_SIZE;
	private	String ENGLISH_NAME;
	private	String FORMER_NAME;
	private	String CREATE_DATE;
	private	int CREATE_ORG;
	
	
	private CreateDataDao dao;
	

	public static void main(String[] args) throws Exception {
		new CORP_Data();
	}
	
	public CORP_Data() throws Exception {
		
		String[] zimu= {"A","B,","C","D","E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String xiaozimu= "abcdefghijklmnopqrstuvwxyz";
		
		String[] sheng= {"����","���","�ӱ�","ɽ��","���ɹ�","����","����","������","�Ϻ�","����","�㽭","����","����","����","ɽ��","����","����","����","�㶫","����","����","����","�Ĵ�","����","����","����","����","����","�ຣ","����","�½�","̨��","���","����",};
		String[] city876 = {"������","������","������","��̨��","ʯ��ɽ��","������","��ͷ����","��ɽ��","ͨ����","˳����","��ƽ��","������","������","ƽ����","������","������"};
		String[] city877 = {"��ƽ��","�Ӷ���","������","�Ͽ���","�ӱ���","������","������","������","������","������","������","������","��������","������","������","������"};
		String[] city878 = {"ʯ��ׯ","��ɽ","�ػʵ�","����","��̨","����","�żҿ�","�е�","����","�ȷ�","��ˮ"};
		String[] city879 = {"̫ԭ","��ͬ","��Ȫ","����","����","˷��","����","�˳�","����","�ٷ�","����"};
		String[] city880 = {"���ͺ���","��ͷ","�ں�","���","ͨ��","������˹","���ױ���","����׿��","�����첼","�˰���","���ֹ�����","��������"};
		String[] city881 = {"����","��ɽ","��˳","��Ϫ","����","����","Ӫ��","����","����","�̽�","����","����","��«��"};
		String[] city882 = {"����","����","��ƽ","��Դ","ͨ��","��ɽ","��ԭ","�׳�","�ӱ�"};
		String[] city883 = {"������","�������","����","�׸�","˫Ѽɽ","����","����","��ľ˹","��̨��","ĵ����","�ں�","�绯","���˰���"};
		String[] city884 = {"������","�����","������","������","������","�����","������","������","��ɽ��","�ζ���","�ֶ�����","��ɽ��","�ɽ���","������","������","������"};
		String[] city885 = {"�Ͼ�","����","����","����","����","��ͨ","���Ƹ�","����","�γ�","����","��","����","��Ǩ"};
		String[] city886 = {"����","����","����","����","����","��","����","��ɽ","̨��","��ˮ"};
		String[] city887 = {"�Ϸ�","�ߺ�","������","����","��","����","ͭ��","����","��ɽ","����","����","����","����","����","����","����"};
		String[] city888 = {"����","����","����","����","Ȫ��","����","��ƽ","����","����"};
		String[] city889 = {"�ϲ�","������","Ƽ��","�Ž�","����","ӥ̶","����","����","�˴�","����","����"};
		String[] city890 = {"����", "�ൺ", "�Ͳ�", "��ׯ", "��Ӫ", "��̨", "Ϋ��", "����", "̩��", "����", "����","����","����","����","�ĳ�","����","����"};
		String[] city891 = {"֣��","����","����","ƽ��ɽ","����","�ױ�","����","����","���","���","���","����Ͽ","����","����","����","�ܿ�","פ���","��Դ"};
		String[] city892 = {"�人","��ʯ","ʮ��","����","�˲�","����","����","Т��","����","�Ƹ�","����","����","��ʩ","����","Ǳ��","����","��ũ��"};
		String[] city893 = {"��ɳ","����","��̶","����","����","����","����","�żҽ�","����","����","����","����","¦��","������"};
		String[] city894 = {"����","�ع�","����","�麣","��ͷ","��ɽ","����","տ��","ï��","����","����","÷��","��β","��Դ","����","��ݸ","��ɽ","����","����","�Ƹ�"};
		String[] city895 = {"����","����","����","����","����","���Ǹ�","����","���","����","��ɫ","����","�ӳ�","����","����"};
		String[] city896 = {"����","����","��ָɽ","��","����","�Ĳ�","����","����","����","�Ͳ�","����","�ٸ�","��ɳ","����","�ֶ�","��ˮ","��ͤ","����","��ɳ"};
		String[] city897 = {"������","������","������","��ɿ���","������","ɳƺ����","��������","�ϰ���","������","�뽭��","������","�山��","������","ǭ����","������","������","�ϴ���","������","�ϴ���","ͭ����","�ɽ��","������","�ٲ���","������","��ƽ��","��¡��","�ǿ���","�ᶼ��","�潭��","����","������","�����","��ɽ��","��Ϫ��","ʯ����","��ɽ��","������","��ˮ��"};
		String[] city898 = {"�ɶ�","��֦��","��Ԫ","����","�˱�", "�㰲","����", "����", "�Թ�", "�ڽ�", "��ɽ", "�ϳ�", "�Ű�", "üɽ", "����", "��ɽ", "����","����","����","����","����","����","��ɽ��"};  
		String[] city899 = {"����","����ˮ","����","��˳","�Ͻ�","ͭ��","ǭ������","ǭ������","ǭ����"};
		String[] city900 = {"����","����","��Ϫ","��ɽ","��ͨ","����","�ն�","�ٲ�","������","�����","��ɽ��","��˫������","������","�º���","ŭ����","������"};
		String[] city901 = {"����","����","��֥","ɽ��","����","����","�տ�����"};
		String[] city902 = {"����","ͭ��","����","����","μ��","�Ӱ�","����","����","����","����"};
		String[] city903 = {"����","������","���","����","��ˮ","����","��Ҵ","ƽ��","��Ȫ","����","����","¤��","������","������"};
		String[] city904 = {"����","����","������","������","������","������","������","������"};
		String[] city905 = {"����","ʯ��ɽ","����","��ԭ","����"};
		String[] city906 = {"��³ľ��","��������","��³��","����","����","����������","����������","�����յ���","����������","��ʲ����","�������","������","���ǵ���","����̩����","ʯ����","������","ͼľ���","�����","����","���Ź�","˫��","�ɿ˴���","����"};
		String[] city907 = {"�����","�û���","������","̨����","��԰��","������","������","��¡","������","������","�±�","̨��","��Ͷ","̨����","������","̨����","������"};
		String[] city908 = {"������","������","����","����","�ͼ�����","��ˮ����","��������","������","������","�뵺��","������","Ԫ����","����","������","������","ɳ����","������","�ƴ�����"};
		String[] city909 = {"����������","ʥ����������","������","��������","��˳����","��ģ����","ʥ���ø�����"};
		
		String[] shi= {"�ɶ���","������","�人��","������","�Ͼ���","�����",
				"������","������","��ɳ��","������","�ൺ��","֣����","������","��ݸ��","������"};
		String[] qv= {"������","������","ɳƺ����","��������","�ϰ���","��ɿ���","�山��","������",
				"������","������","������","������","ǭ����","������","�뽭��","�ϴ���","������","������","�ϴ���"};
		String[] jiedao= {"������","�Ͼ�·","����·","���������","������","ת��·","ƽ��·","�ϴ��","��Ϫ�Ͻ�","�Ͻ�",
				"�����","����·","��ɽ·"};
		
		String[] hangye2= {"�������","��������","����ͷ���","רҵ��������","�������","����"};
		String[] hangye1= {"����","�ɿ�","��Դ","����","��Ѷ","���ز�","���","����","����","���캽��","����","�����","����","����","����","����","��ֽ","����","���","����","���","����","��е����","ũҵ","��ѯ","ҽ��","ס��","����","����","��֯"};
		
		String corpName1[]={"��","��","��","��","��","��","��","��","Ԫ","��","��","��","Ԫ","��","Э","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
	    String corpName2[]={"��","��","��","Э","ҫ","ʢ","��","��","��","��","��","��","ï","��","��","��","��","ΰ","»","ǧ","��","��","��","ǫ","��","��","��","��","��","��","�","��","��","��","��","��"};
		
		String[] jingyingfanwei1= {"��������������","���ۼ���ز�Ʒ��ѵ��","�����Ӧ�÷���","��·��","�ܵ���","�豸��װ��","���Ӳ�Ʒ��ͨ���豸��������","�������������������ۣ�","���Ӽ�����������"};
		String[] jingyingfanwei2= {"���","���硢","�ٻ���","����ԭ�ϼ���Ʒ��","������","�����������ۣ�","��Ʒ��Ϣ��ѯ��"};
		String[] jingyingfanwei3= {"�������Ƽ�,","ҽ����е��","�������","����Ļ���","��Ϸ��","���ڷ���","��ó��","����"};
		
		String[] gongsidalei= {"���ʹ�˾","���ʹ�˾","���ʹ�˾"};
		String guanlijv="���̹����";
		
		String country[]= {"�й�","����","�й�","����","�й�","�й�","Ӣ��","�й�","�ձ�","�й�","����˹","�й�","���ô�","�й�"};//����
		String firstname[]= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��"};
		String lastname1[]= {"��","��","��","�","��","��","��","��","��","ŵ","��","ҫ","��","��","��","ٻ","��","��","¹","��","��","��","��","ϼ"};
		String lastname2[]= {"ƽ","","չ","�","��","��","","","","ͩ","ͮ","��","ũ","","��","ٻ","��","��","","","","��","��","��"};
		
		String[] certificate_type= {"���֤"};
		String[] person_type= {"����","����","����","����","����","����","����","����","����",};
		
		dao=new CreateDataDaoImp();
		//�洢���ɵĹ�˾����
		int CorpNum=0;
		
		Random random=new Random();
		int num=0;
		//�洢��ҵ������Ϣ
		Map<Integer, String> map=new HashMap<Integer, String>();
		for(int i=0;i<hangye1.length;i++) {
			for(int j=0;j<hangye2.length;j++)
				map.put(num+1000, hangye1[i]+"��"+hangye2[j]+"ҵ");
				num++;
		}
		int shengIndex=0;
		for(shengIndex=0;shengIndex<sheng.length;shengIndex++)//ʡ��
		{
			ORG=876+shengIndex;
			
			int corpIndex=random.nextInt(1)+1;
			//ʹ��Set��Ϲ�˾���ֱ����ظ�
			Set cropName=new HashSet();
			for(int i=0;i<=corpIndex+10;i++) {
				int name1=random.nextInt(corpName1.length);
				int name2=random.nextInt(corpName2.length);
				int name3=random.nextInt(hangye1.length);
				cropName.add(corpName1[name1]+corpName2[name2]+hangye1[name3]);
			}
			Iterator it=cropName.iterator();
			for(int index=0;index<corpIndex;index++)//ÿ��ʡ���ж��ٹ�˾
			{
				CorpNum++;
				Integer[] keys = map.keySet().toArray(new Integer[0]);
				Integer randomkey=keys[random.nextInt(keys.length)];
				String randomvalue=map.get(randomkey);
				
				ID=randomkey;
				//������ҵ
				BELONG_TRADE=randomvalue;
				
				SEQ_ID=index+1;
				//System.out.println("��˾��ţ�"+SEQ_ID);
				
				//���ô���	
				int creditnum1=random.nextInt(10);
				int creditnum2=random.nextInt(10);
				int creditnum3=(int)((Math.random()*9+1)*100000);
				int creditnum4=(int)((Math.random()*9+1)*100000000);
				String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				char creditnum5=chars.charAt((int)(Math.random() * 26));
				REG_NO=""+creditnum1+creditnum2+creditnum3+creditnum4+creditnum5;
				//System.out.println("���ô��룺"+REG_NO);
				
				//��˾����
				String name=it.next().toString(); 
				CORP_NAME=sheng[shengIndex]+name+"���޹�˾";
				//System.out.println("��ҵ���ƣ�"+CORP_NAME);
				
				//��˾��ַ
				int shiindex=random.nextInt(shi.length);
				int qvindex=random.nextInt(qv.length);
				int jiedaoindex=random.nextInt(jiedao.length);
				int qvhao=random.nextInt(500);
				ADDR=sheng[shengIndex]+shi[shiindex]+qv[qvindex]+jiedao[jiedaoindex]+qvhao+"��";
				//System.out.println("��ҵ��ַ��"+ADDR);
				
				//�Ǽǻ���
				BELONG_ORG=shi[shiindex]+guanlijv;
				//System.out.println("�Ǽǻ��أ�"+BELONG_ORG);
				
				//��������
				BELONG_DIST_ORG=shi[shiindex]+qv[qvindex];
				//System.out.println("��������:"+BELONG_DIST_ORG);
				int hangye2index=random.nextInt(hangye2.length);
				
				//��˾����
				ECON_KIND="�������ι�˾";
				//System.out.println("��˾���ͣ�"+ECON_KIND);
				
				//��˾����
				int gongsidaleiindex=random.nextInt(gongsidalei.length);
				ADMIT_MAIN=gongsidalei[gongsidaleiindex];
				//System.out.println("��˾���ࣺ"+ADMIT_MAIN);
				
				//����
				int chenglinian=random.nextInt(55)+1960;
				int chengliyue=random.nextInt(12)+1;
				int chengliri=random.nextInt(28)+1;
				String yue,ri;
				if(chengliyue<10) {
					yue="0"+chengliyue;
				}else {
					yue=""+chengliyue;
				}
				if(chengliri<10) {
					ri="0"+chengliri;
				}else {
					ri=""+chengliri;
				}
				START_DATE=chenglinian+"/"+yue+"/"+ri;
				//System.out.println("�������ڣ�"+START_DATE);
				
				REG_CAPI=0;
				CREATE_DATE=chenglinian+"/"+yue+"/"+ri;
				
				//����
				int x=random.nextInt(firstname.length);
				int y=random.nextInt(lastname1.length);
				int z=random.nextInt(lastname2.length);
				OPER_MAN_NAME=firstname[x]+lastname1[y]+lastname2[z];
				
				int s1=(int)((Math.random()*9+1)*100000);
				int s2=random.nextInt(80)+1918;				
				int s3=random.nextInt(12)+1;
				int s4=random.nextInt(28)+1;
			
				if(s3<10) {
					yue="0"+s3;
				}else {
					yue=""+s3;
				}
				if(s4<10) {
					ri="0"+s4;
				}else {
					ri=""+s4;
				}
				int s5=Math.round((random.nextFloat()+1)*1000);
				OPER_MAN_IDENT_NO=""+s1+s2+yue+ri+s5;
				//System.out.println("���˱�ţ�"+OPER_MAN_IDENT_NO);
				//System.out.println("�������ƣ�"+OPER_MAN_NAME);
				
				//��Ӫ״̬
				CORP_STATUS="0"+(random.nextInt(4)+1);
				//System.out.println("��Ӫ״̬��"+CORP_STATUS);

				FARE_TERM_END="����";
				//System.out.println("��Ӫ����ֹ��"+FARE_TERM_END);
				
				//��Ӫ��Χ
				int jingyingfanwei1index=random.nextInt(jingyingfanwei1.length);
				int jingyingfanwei2index=random.nextInt(jingyingfanwei2.length);
				int jingyingfanwei3index=random.nextInt(jingyingfanwei3.length);
				int hangye1index=random.nextInt(hangye1.length);
				FARE_SCOPE=hangye1[hangye1index]+"��"+jingyingfanwei1[jingyingfanwei1index]+jingyingfanwei2[jingyingfanwei2index]+jingyingfanwei3[jingyingfanwei3index];
				FARE_SCOPE=FARE_SCOPE.substring(0, FARE_SCOPE.length()-1)+"��";
				//System.out.println("��Ӫ��Χ��"+FARE_SCOPE);
				
				//ע���
				Double dd=Math.random();
				String q1=dd.toString().substring(2, 13);
				String q2=dd.toString().substring(2, 6);
				UNI_SCID=q1+q2;
				//System.out.println("ע��ţ�"+UNI_SCID);
				
				//�绰
				dd=Math.random();
				String q3=dd.toString().substring(2, 5);
				String q4=dd.toString().substring(2, 9);
				TEL=q3+"-"+q4;
				//System.out.println("�绰��"+TEL);
				
				//����/����
				StringBuffer zhongjianzifu = new StringBuffer();
				for(int zhongjian=0;zhongjian<(random.nextInt(10)+5);zhongjian++)
				{				
					zhongjianzifu.append(xiaozimu.charAt(random.nextInt(xiaozimu.length())));
				}
				WEB_URL="www."+zhongjianzifu.toString()+".com.cn";
				//System.out.println("����:"+WEB_URL);
				EMAIL="jxsw@"+zhongjianzifu+".com.cn";
				//System.out.println("���䣺"+EMAIL);
				
				//��ҵ����
				PRAC_PERSON_NUM=random.nextInt(400)+100;
				//System.out.println("��ҵ������"+PRAC_PERSON_NUM);
				
				//��֯��������
				dd=Math.random();
				String q5=dd.toString().substring(2, 10);
				ORG_INST_CODE=q5+"-"+random.nextInt(10);
				//System.out.println("��֯��������:"+ORG_INST_CODE);
				
				//��˰��ʶ���
				TAXPAY_NUM=REG_NO;
				//System.out.println("��˰��ʶ��ţ�"+TAXPAY_NUM);
				
				//��Ա��ģ
				int q6=random.nextInt(1000)+200;
				STAFF_SIZE="100-"+q6+"��";
				//System.out.println("��Ա��ģ��"+STAFF_SIZE);
				
				StringBuffer danci = new StringBuffer();
				//Ӣ����
				for(int dancishuliang=0;dancishuliang<random.nextInt(3)+3;dancishuliang++)
				{
					for(int zhongjian=0;zhongjian<(random.nextInt(5)+5);zhongjian++)
					{				
						danci.append(xiaozimu.charAt(random.nextInt(xiaozimu.length())));
					}
					danci.append(' ');
				}
				ENGLISH_NAME=danci.toString();
				//System.out.println("Ӣ������"+ENGLISH_NAME);
				
				//������
				FORMER_NAME="null";
				//System.out.println("��������"+FORMER_NAME);
				
				String time=CREATE_DATE;
				String[] caifen1=time.split(" ");
				
				String[] caifen2=caifen1[0].split("/");
				int shengheinian=Integer.parseInt(caifen2[0]);
				int shengheiyue=Integer.parseInt(caifen2[1]);
				int shengheiri=Integer.parseInt(caifen2[2]);
				
				START_DATE=caifen1[0];				
				//System.out.println("��������"+START_DATE);
				
				CHECK_DATE=shengheinian+(random.nextInt(15)+1)+"/"+yue+"/"+ri;
				//System.out.println("��׼���ڣ�"+CHECK_DATE);
				
				FARE_TERM_START=caifen1[0];
				//System.out.println("��Ӫ������"+FARE_TERM_START);
				
				CREATE_ORG=ORG;
				//System.out.println("�����������룺"+CREATE_ORG);
				
				String sql="insert into T_CORP values( "+ORG+", "+ID+", "+SEQ_ID+", '"+REG_NO+"', '"+CORP_NAME+"', '"+ADDR+"', '"+BELONG_ORG+"', '"+BELONG_DIST_ORG+"', '"+BELONG_TRADE+"', '"+ECON_KIND+"', '"+ADMIT_MAIN+"', to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi'), to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi'), '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+CORP_STATUS+"', "+REG_CAPI+", to_date('"+FARE_TERM_START+"','yyyy-mm-dd hh24:mi'), '"+FARE_TERM_END+"', "+"'"+FARE_SCOPE+"', '"+UNI_SCID+"', '"+TEL+"', '"+WEB_URL+"', '"+EMAIL+"', "+PRAC_PERSON_NUM+", '"+ORG_INST_CODE+"', '"+TAXPAY_NUM+"', '"+STAFF_SIZE+"', '"+ENGLISH_NAME+"', "+FORMER_NAME+", to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi'), "+CREATE_ORG+" )";
				System.out.println(sql);
				
				//��˾���������
				dao.insertData(sql);
			}
		}
		System.out.println("��˾����"+CorpNum);
		for(int i=1;i<CorpNum-1;i++) {
			int j=i-1;
			//System.out.println("i:"+i+"  j:"+j);
			T_CORPBean company=dao.searchOneCorp("SELECT * from T_CORP WHERE rownum<="+i+" minus (SELECT * from T_CORP WHERE rownum<="+j+")");
			System.out.println("��ѯ�������������Ĺ�˾��Ϣ��"+company);
			
			
			int STOCK_ORG;
			int STOCK_ID;//ͬһ����˾��һ��
			int STOCK_SEQ_ID;
			String STOCK_TYPE;
			String COUNTRY;
			String CERTIFICATE_TYPE;
			String CERTIFICATE_NO;
			String STOCK_NAME;
			String STOCK_CAPI_TYPE;
			float STOCK_CAPI;
			float STOCK_CAPI_DOLLAR;
			float STOCK_CAPI_RMB;
			String STOCK_PERCENT;
			float STOCK_RATE_RMB=1.0f;
			float STOCK_RATE_DOLLAR=0.1579f;
			String CREATE_DATE;
			
			float renjiaozonge=0;
			//�洢һ����˾���йɶ���Ϣ
			ArrayList<T_CORP_STOCKBean> AllStock=new ArrayList<>();
			
			STOCK_ORG=company.getORG();
			STOCK_SEQ_ID=company.getSEQ_ID();
			CREATE_DATE=company.getCREATE_DATE().substring(0, 10);
			
			//���ƹɶ�����
			int number=random.nextInt(8)+1;
			//�����ѯ��˾��������ɹɶ�Ϊ��˾
			//�洢���ɵĹɶ�����
			ArrayList<String> stock_Corp=dao.searchData();
			//ȥ��������˾����һ��������
			for(int b=0;b<stock_Corp.size();b++) {
				if(stock_Corp.get(b).equals(company.getCORP_NAME())||stock_Corp.get(b)==company.getCORP_NAME()) {
					stock_Corp.remove(b);
				}
			}
			
			//����һ����˾�Ĺɶ�
			for(int index=0;index<number;index++) {
				//�����ɶ����
				STOCK_ID=index+1000;
				//System.out.println("�ɶ�������"+STOCK_ORG+","+STOCK_ID+","+STOCK_SEQ_ID);
				
				//�ɶ���
				if(stock_Corp.size()<=index) {
					int x=random.nextInt(firstname.length);
					int y=random.nextInt(lastname1.length);
					int z=random.nextInt(lastname2.length);
					STOCK_NAME=firstname[x]+lastname1[y]+lastname2[z];
					STOCK_TYPE="��Ȼ��";
					CERTIFICATE_TYPE="���֤";
					//���֤��
					int s1=(int)((Math.random()*9+1)*100000);
					int s2=random.nextInt(80)+1918;				
					int s3=random.nextInt(12)+1;
					int s4=random.nextInt(28)+1;
					String yue;
					String ri;
					if(s3<10) {
						yue="0"+s3;
					}else {
						yue=""+s3;
					}
					if(s4<10) {
						ri="0"+s4;
					}else {
						ri=""+s4;
					}
					int s5=Math.round((random.nextFloat()+1)*1000);
					CERTIFICATE_NO=""+s1+s2+yue+ri+s5;
				}else {
					STOCK_NAME=stock_Corp.get(index);
					STOCK_TYPE="��˾";
					CERTIFICATE_TYPE="null";
					CERTIFICATE_NO="null";
				}
				//System.out.println("�ɶ����ƣ�"+STOCK_NAME);
				//System.out.println("���֤�ţ�"+CERTIFICATE_NO);
				//����
				int n=random.nextInt(country.length);
				COUNTRY=country[n];
				//System.out.println("���ң�"+COUNTRY);
				
				STOCK_CAPI_TYPE="�����";
				
				//�ɶ��Ͻ�
				int renjiaoe=random.nextInt(500)+20;
				//������λС��
				DecimalFormat   fnum  =   new  DecimalFormat("#.00");    
				String   dd=fnum.format(renjiaoe*0.1579);
				float renjiaoedollor=Float.parseFloat(dd);
				
				STOCK_CAPI=renjiaoe*1.0f;
				STOCK_CAPI_RMB=renjiaoe*STOCK_RATE_RMB;
				STOCK_CAPI_DOLLAR=renjiaoedollor;
				
				renjiaozonge=renjiaozonge+renjiaoe;
				
				T_CORP_STOCKBean STOCK=new T_CORP_STOCKBean();//�洢һ����˾���ɵĹɶ���Ϣ
				STOCK.setORG(STOCK_ORG);
				STOCK.setSEQ_ID(STOCK_SEQ_ID);
				STOCK.setID(STOCK_ID);
				STOCK.setCERTIFICATE_NO(CERTIFICATE_NO);
				STOCK.setCERTIFICATE_TYPE(CERTIFICATE_TYPE);
				STOCK.setCOUNTRY(COUNTRY);
				STOCK.setCREATE_DATE(CREATE_DATE);
				STOCK.setSTOCK_CAPI(STOCK_CAPI);
				STOCK.setSTOCK_CAPI_DOLLAR(STOCK_CAPI_DOLLAR);
				STOCK.setSTOCK_CAPI_RMB(STOCK_CAPI_RMB);
				STOCK.setSTOCK_CAPI_TYPE(STOCK_CAPI_TYPE);
				STOCK.setSTOCK_NAME(STOCK_NAME);
				STOCK.setSTOCK_RATE_DOLLAR(STOCK_RATE_DOLLAR);
				STOCK.setSTOCK_RATE_RMB(STOCK_RATE_RMB);
				STOCK.setSTOCK_TYPE(STOCK_TYPE);
				
				AllStock.add(STOCK);
				
			}
			//���¹�˾���е�Ͷ�ʽ��
			dao.update("update T_CORP set REG_CAPI="+renjiaozonge+" where ORG="+company.getORG()+" and SEQ_ID="+company.getSEQ_ID()+" ");
			
			for(int o=0;o<number;o++)
			{
				T_CORP_STOCKBean t=AllStock.get(o);
				float bili=t.getSTOCK_CAPI()/renjiaozonge;
				//System.out.println("�ܶ"+renjiaozonge);
				//System.out.println("���˽�"+t.getSTOCK_CAPI());
				//System.out.println("����"+bili);
			
				DecimalFormat   fnum  =   new  DecimalFormat("#0.00");
				String dd=fnum.format(bili*100);
			
				t.setSTOCK_PERCENT(dd+"%");
				//System.out.println("ת��Ϊ�ٷֱ�:"+t.getSTOCK_PERCENT());
				
				String sql="insert into T_CORP_STOCK values("+t.getORG()+", "+t.getID()+", "+t.getSEQ_ID()+", "+"'"+t.getSTOCK_TYPE()+"', "+"'"+t.getCOUNTRY()+"', "+"'"+t.getCERTIFICATE_TYPE()+"', "+"'"+t.getCERTIFICATE_NO()+"', "+"'"+t.getSTOCK_NAME()+"', "+"'"+t.getSTOCK_CAPI_TYPE()+"', "+t.getSTOCK_CAPI()+", "+t.getSTOCK_CAPI_DOLLAR()+", "+t.getSTOCK_CAPI_RMB()+", "+"'"+t.getSTOCK_PERCENT()+"', "+t.getSTOCK_RATE_RMB()+", "+t.getSTOCK_RATE_DOLLAR()+", "+"to_date('"+t.getCREATE_DATE()+"','yyyy-mm-dd hh24:mi'))";
				System.out.println(sql);
				dao.insertData(sql);
				//��˾�͹ɶ����м���������
				String stockSql="insert into T_M_CORP_CORP_STOCK values("+company.getORG()+", "+company.getID()+", "+company.getSEQ_ID()+","+t.getORG()+", "+t.getID()+", "+t.getSEQ_ID()+")";
				System.out.println("�ɶ��м��"+stockSql);
				dao.insertData(stockSql);
			}
			System.out.println("-----------------------------------------------------------------");
			
			//������Ҫ��Ա��Ϣ
			int PERTAIN_ORG;
			int PERTAIN_ID;
			int PERTAIN_SEQ_ID;
			String PERTAIN_CERTIFICATE_TYPE;//֤������
			String PERSON_NAME;//��Ա����
			String PERSON_TYPE;//��Աְ��
			String PERTAIN_CERTIFICATE_NO;//֤�����
			String SELECT_TYPE="ѡ��";//������ʽ
			String HOLDPOST_START;//��ְ������
			String HOLDPOST_END="2222/12/12 12:12";//��ְ����ֹ
			String SEX;//�Ա�
			int AGE;//����
			String PERTAIN_COUNTRY;//����
			String PERTAIN_CREATE_DATE;//��������
			
			PERTAIN_ORG=company.getORG();
			PERTAIN_SEQ_ID=company.getSEQ_ID();
			PERTAIN_CREATE_DATE=company.getCREATE_DATE().substring(0, 10);
			int personnum=random.nextInt(10);
			for(int z=0;z<personnum;z++) {//ÿ����˾�ĳ�Ա
				PERTAIN_ID=z+1000;//������Ա���
				System.out.println("��Ҫ��Ա������"+PERTAIN_ORG+","+PERTAIN_ID+","+PERTAIN_SEQ_ID);
				//֤������
				int cert=random.nextInt(certificate_type.length);
				CERTIFICATE_TYPE=certificate_type[cert];
				//System.out.println(CERTIFICATE_TYPE);
				
				//��Ա����
				int x1=random.nextInt(firstname.length);
				int y1=random.nextInt(lastname1.length);
				int z1=random.nextInt(lastname2.length);
				PERSON_NAME=firstname[x1]+lastname1[y1]+lastname2[z1];
				//System.out.println("��Ա������"+PERSON_NAME);
				
				//ְ��
				int person=random.nextInt(person_type.length);
				PERSON_TYPE=person_type[person];
				//System.out.println(PERSON_TYPE);
				
				//���֤��
				int s1=(int)((Math.random()*9+1)*100000);
				int s2=random.nextInt(80)+1918;				
				int s3=random.nextInt(12)+1;
				int s4=random.nextInt(28)+1;
				String yue,ri;
				if(s3<10) {
					yue="0"+s3;
				}else {
					yue=""+s3;
				}
				if(s4<10) {
					ri="0"+s4;
				}else {
					ri=""+s4;
				}
				int s5=Math.round((random.nextFloat()+1)*1000);
				CERTIFICATE_NO=""+s1+s2+yue+ri+s5;
				//System.out.println("֤���ţ�"+CERTIFICATE_NO);
				
				//�Ա�
				int sex=random.nextInt(2);
				if(sex==0) {
					SEX="Ů";
				}else {
					SEX="��";
				}
				//System.out.println(SEX);
				
				//����
				int age=random.nextInt(40)+30;
				AGE=age;
				//System.out.println("����"+AGE);
				
				//����
				int coun=random.nextInt(country.length);
				COUNTRY=country[coun];
				//System.out.println("���ң�"+COUNTRY);
				
				//����
				int s6=random.nextInt(80)+1880;//�������
				int s7=random.nextInt(24);//����Сʱ
				int s8=random.nextInt(60);//������
				HOLDPOST_START=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
				
				String sql="insert into T_CORP_PERTAINS values("+PERTAIN_ORG+", "+PERTAIN_ID+", "+PERTAIN_SEQ_ID+", '"+CERTIFICATE_TYPE+"', '"+PERSON_NAME+"', '"+PERSON_TYPE+"', '"+CERTIFICATE_NO+"', '"+SELECT_TYPE+"', to_date('"+HOLDPOST_START+"','yyyy-mm-dd hh24:mi'),  to_date('"+HOLDPOST_END+"','yyyy-mm-dd hh24:mi'), '"+SEX+"', "+AGE+", '"+COUNTRY+"', to_date('"+PERTAIN_CREATE_DATE+"', 'yyyy-mm-dd hh24:mi'))";
				System.out.println("��Ҫ��Ա��"+sql);
				dao.insertData(sql);
				String pertainSql="insert into T_M_CORP_CORP_PERTAINS values("+company.getORG()+", "+company.getID()+", "+company.getSEQ_ID()+", "+PERTAIN_ORG+", "+PERTAIN_ID+", "+PERTAIN_SEQ_ID+")";
				System.out.println("��Ҫ��Ա�м��"+pertainSql);
				dao.insertData(pertainSql);
			}
			
			int DIST_ORG;//�������ش���
			int DIST_ID;//����ֹ�˾����
			int DIST_SEQ_ID;//����˾����
			String DIST_REG_NO;//��֧����ͳһ������ô���
			String DIST_NAME;//��֧��������
			String DIST_BELONG_ORG;
			int DIST_CORP_ORG;
			int DIST_CORP_ID;
			int DIST_CORP_SEQ_ID;
			String FARE_PLACE;//Ӫҵ����
			String OPER_MAN_IDENT_NO;//������֤�����
			String OPER_MAN_NAME;//����������
			String FARE_SCOPE;//��Ӫ��Χ
			String START_DATE;//��������
			String CHECK_DATE;//��׼����
			String DIST_CREATE_DATE;//����ʱ��
			
			DIST_ORG=company.getORG();
			DIST_SEQ_ID=company.getSEQ_ID();
			DIST_CREATE_DATE=company.getCREATE_DATE().substring(0, 10);
			
			DIST_CORP_ORG=company.getORG();
			DIST_CORP_ID=company.getID();
			DIST_CORP_SEQ_ID=company.getSEQ_ID();
			
			int creditnum1=random.nextInt(10);
			int creditnum2=random.nextInt(10);
			int creditnum3=(int)((Math.random()*9+1)*100000);
			
			int distnum=random.nextInt(10);
			for(int z=0;z<distnum;z++) {//ÿ����˾�ֹ�˾����
				//������˾���
				DIST_ID=z+1000;
				
				//��֧����ͳһ������ô���
				/*   ͳһ������ô������Ϊ18λ��ʹ�ð��������ֻ�Ӣ����ĸ��ʾ�������������ɡ�
				 * ��һ���֣���1λ����Ϊ�Ǽǹ����Ŵ��룻
				 * �ڶ����֣���2λ����Ϊ��ҵ����˰�������룻
				 * �������֣���3-8λ����Ϊ�Ǽǹ���������������룻
				 * ���Ĳ��֣���9-17λ����Ϊ�����ʶ�룻
				 * ���岿�֣���18λ����ΪУ���룬��ϵͳ�Զ����ɡ�*/	
				int creditnum4=(int)((Math.random()*9+1)*100000000);
				String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				char creditnum5=chars.charAt((int)(Math.random() * 26));
				DIST_REG_NO=""+creditnum1+creditnum2+creditnum3+creditnum4+creditnum5;
				//System.out.println("���ô��룺"+DIST_REG_NO);
				
				//������֤�����
				int s1=(int)((Math.random()*9+1)*100000);
				int s2=random.nextInt(80)+1918;				
				int s3=random.nextInt(12)+1;
				int s4=random.nextInt(28)+1;
				String yue,ri;
				if(s3<10) {
					yue="0"+s3;
				}else {
					yue=""+s3;
				}
				if(s4<10) {
					ri="0"+s4;
				}else {
					ri=""+s4;
				}
				int s5=Math.round((random.nextFloat()+1)*1000);
				OPER_MAN_IDENT_NO=""+s1+s2+yue+ri+s5;
				//System.out.println("֤���ţ�"+OPER_MAN_IDENT_NO);
				
				//������
				int x1=random.nextInt(firstname.length);
				int y1=random.nextInt(lastname1.length);
				int z1=random.nextInt(lastname2.length);
				OPER_MAN_NAME=firstname[x1]+lastname1[y1]+lastname2[z1];
				//System.out.println("�����ˣ�"+OPER_MAN_NAME);
				
				//����
				int s6=random.nextInt(55)+1960;//��˾�������
				int s7=random.nextInt(24);//��˾����Сʱ
				int s8=random.nextInt(60);//��˾������
				START_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
				CHECK_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
				
				//System.out.println("�ֹ�˾��������"+CREATE_DATE);
				
				//Ӫҵ����
				int shiindex=random.nextInt(shi.length);
				int qvindex=random.nextInt(qv.length);
				int jiedaoindex=random.nextInt(jiedao.length);
				int menpaihao=random.nextInt(500);
				FARE_PLACE=shi[shiindex]+qv[qvindex]+jiedao[jiedaoindex]+menpaihao+"��";
				//System.out.println("Ӫҵ������"+FARE_PLACE);
				
				//��֧��������
				DIST_NAME=company.getCORP_NAME()+shi[shiindex]+"�ֹ�˾";
				
				//��֧�����Ǽǻ���
				DIST_BELONG_ORG=shi[shiindex]+"��ҵ԰���г��ල�����";
				
				//��Ӫ��Χ
				int jingyingfanwei1index=random.nextInt(jingyingfanwei1.length);
				int jingyingfanwei2index=random.nextInt(jingyingfanwei2.length);
				int jingyingfanwei3index=random.nextInt(jingyingfanwei3.length);
				int hangye1index=random.nextInt(hangye1.length);
				FARE_SCOPE=hangye1[hangye1index]+"��"+jingyingfanwei1[jingyingfanwei1index]+jingyingfanwei2[jingyingfanwei2index]+jingyingfanwei3[jingyingfanwei3index];
				FARE_SCOPE=FARE_SCOPE.substring(0, FARE_SCOPE.length()-1)+"��";
				
				String sql="insert into T_CORP_DIST values("+DIST_ORG+", "+DIST_ID+", "+DIST_SEQ_ID+", '"+DIST_REG_NO+"', '"+DIST_NAME+"', '"+DIST_BELONG_ORG+"', "+DIST_CORP_ORG+", "+DIST_CORP_ID+", "+DIST_CORP_SEQ_ID+", '"+FARE_PLACE+"', '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+FARE_SCOPE+"', "+"to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi')"+")";
				System.out.println("�ֹ�˾��"+sql);
				dao.insertData(sql);
			}	
			
		}//��˾����
	}
}
