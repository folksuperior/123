/**
 * 
 */
package cn.yin.jx.action.stat;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.dao.common.SqlDao;
import cn.yin.jx.utils.FileUtil;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年3月1日
 */
public class StatChartAction extends BaseAction{
	//为了减化，省略了Service,而直接引入sqlDao.
	private SqlDao sqlDao;
	public void setSqlDao(SqlDao sqlDao) {
		this.sqlDao = sqlDao;
	}
	
 
	public String factorysale() throws Exception{
		String sql = "Select factory_name,sum(amount) samount "
				+ "from contract_product_c group by factory_name order by samount desc";
		List<String> list = sqlDao.executeSQL(sql);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<pie>");
		// 显示的厂家种类不超过8家，剩下的为“其他”
		int num = list.size();
		if(list.size() >= 16){
			num = 16;
		}
		for(int i = 0;i < num; i ++){
			sb.append("<slice title='"+list.get(i)+"' pull_out='true'>"+list.get(++i)+"</slice>");
		}
		if(list.size()>=16){
			Double count = 0d;
			for(int i = 16 ; i < list.size() ; i ++){
				String s = list.get(++i);
				Double d = new Double(s);
				count = count + d;
			}
			sb.append("<slice title='其他' pull_out='true'>"+count.toString()+"</slice>");
		}
	
		sb.append("</pie>");
		
		String sPath = ServletActionContext.getRequest().getRealPath("/")+"stat/chart/factorysale";
		FileUtil fileUtil = new FileUtil();
		fileUtil.createTxt(sPath, "data.xml", sb.toString(), "UTF-8");
		
		return "factorysale";
	} 
	
	public String productsale() throws Exception{
		String sql = "Select b.* from (select product_no,sum(cnumber) samount "
				+ "from contract_product_c group by product_no order by samount desc) b "
				+ "where rownum<16";
		List<String> list = sqlDao.executeSQL(sql);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<chart>");
		sb.append("<series>");
		
		for(int i = 0, j = 0 ; i < list.size(); i ++,j ++){
			sb.append("<value xid='"+j+"'>"+list.get(i++)+"</value>");
		}
		sb.append("</series>");
		sb.append("<graphs>");
		sb.append("<graph gid='30' color='#FFCC00' gradient_fill_colors='#111111, #1A897C'>");
		
		for(int i = 1, j = 0 ; i < list.size(); i ++,j ++){
			sb.append("<value xid='"+j+"' description='' url=''>"+list.get(i++)+"</value>");
		}
		
		sb.append("</graph>");
		sb.append("</graphs>");
		sb.append("<labels> ");
		sb.append("<label lid='0'>");
		sb.append("<x>0</x>");
		sb.append("<y>20</y>");
		sb.append("<rotate></rotate>");
		sb.append("<width></width>");
		sb.append("<align>center</align>");
		sb.append("<text_color></text_color>");
		sb.append("<text_size></text_size>");
		sb.append("<text>");
		sb.append("<![CDATA[<b>产品销量排行榜</b>]]>");
		sb.append("</text>");
		sb.append("</label>");
		sb.append("</labels>");
		sb.append("</chart>");
		
		String sPath = ServletActionContext.getRequest().getRealPath("/")+"stat/chart/productsale"; 
		
		FileUtil fileUtil = new FileUtil();
		
		fileUtil.createTxt(sPath, "data.xml", sb.toString(), "UTF-8");
		
		return "productsale";
	}
	
	
	public String productSaleJson(){
		String sql = "select factory_name,sum(amount) samount "
				+ "from contract_product_c group by factory_name order by samount desc";
		List list = sqlDao.executeSQL(sql);
		String colors[] = {"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215","#0D8ECF","#0D52D1","#2A0CD0","#8A0CCF","#CD0D74","#754DEB","#DDDDDD","#333333","#000000","","","","","","","","","","","","","","","","","","","",""};
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0,j = 0; i < list.size(); i ++){
			sb.append("{");
			sb.append("'factoryName':'"+list.get(i)+"',");
			sb.append("'samount':"+list.get(++i)+",");
			sb.append("'color':'"+colors[j++]+"'");
			sb.append("},");
		}
		sb.delete(sb.length()-1,sb.length());
		sb.append("]");
		this.put("factorysales", sb.toString());
		
		return "productSaleJson";
	}
	
	public String onlineinfo() throws Exception{
		String sql = "select a.a1,nvl(b.c,0)"
				+ "from (select * from online_info_t ) a "
				+ "left join(select to_char(login_time,'HH24') a1, count(*) c "
				+ "from login_log_p group by to_char(login_time,'HH24')) b "
				+ "on (a.a1 = b.a1) order by a.a1 ";
		List<String> list = sqlDao.executeSQL(sql);
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<chart>");
		sb.append("<series>");
		
		for(int i = 0,j = 0; i < list.size(); i ++,j ++){
			sb.append("<value xid='"+j+"'>"+list.get(i++)+"</value>");
		}
		
		sb.append("</series>");
		sb.append("<graphs><graph gid='30' color='#FFCC00' gradient_fill_colors='#111111, #1A897C'>");
		
		for(int i = 1,j = 0; i < list.size(); i ++,j++){
			sb.append("<value xid='"+j+"'>"+list.get(i++)+"</value>");
		}
		
		
		sb.append("</graph>");
		sb.append("</graphs>");
		sb.append("<labels> <label lid='0'><x>0</x><y>20</y><rotate></rotate> "
				+ "<width></width><align>center</align><text_color></text_color><text_size>"
				+ "</text_size><text><![CDATA[<b>在线登录人数统计</b>]]></text>      "
				+ "  </label></labels></chart>");
		sb.append("</chart>");
		
		String sPath = ServletActionContext.getRequest().getRealPath("/")+"stat/chart/onlineinfo";
		FileUtil fileUtil = new FileUtil();
		fileUtil.createTxt(sPath, "data.xml", sb.toString(), "UTF-8");
		return "onlineinfo";
	}
}
