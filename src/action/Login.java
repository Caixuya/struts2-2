package action;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.YonghuDAO;
import po.Yonghu;

public class Login {
	//创建与参数同名的属性
	private String username;
	private String password;
	//为同名属性添加setter
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
			//把所有用户all存到ActionContext.getContext().getValueStack().set("users", all);（即把结果存入值栈中）
			//在页面中使用<s:iterator value="users" var="user"></s:iterator>和
			//<s:property value="#user.username"/>这两句来显示
			return "ok";
		}else {
			ActionContext.getContext().getValueStack().set("message", "用户名或密码错误");
			return "error";
		}
		
	}
}
