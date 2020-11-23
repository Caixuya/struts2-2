package action;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.YonghuDAO;
import po.Yonghu;

public class Login {
	//���������ͬ��������
	private String username;
	private String password;
	//Ϊͬ���������setter
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		YonghuDAO dao=new YonghuDAO();
		Boolean b=dao.check(username, password);
		if(b) {
			List<Yonghu> all=dao.getAll();
			ActionContext.getContext().getValueStack().set("users", all);
			//�������û�all�浽ActionContext.getContext().getValueStack().set("users", all);�����ѽ������ֵջ�У�
			//��ҳ����ʹ��<s:iterator value="users" var="user"></s:iterator>��
			//<s:property value="#user.username"/>����������ʾ
			return "ok";
		}else {
			ActionContext.getContext().getValueStack().set("message", "�û������������");
			return "error";
		}
		
	}
}
