package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import po.Yonghu;
import tool.HibernateUtils;

public class YonghuDAO {
	
	public List<Yonghu> getAll(){
		Session s=HibernateUtils.openSession();
		Query q=s.createQuery("from Yonghu");
		List list =q.list();
		s.close();
		return list;
	}
	
	public Boolean check(String username,String password) {
		Session s=HibernateUtils.openSession();
		Query q=s.createQuery("from Yonghu where username=:u and password=:p");
		q.setString("u", username);
		q.setString("p", password);
		List list =q.list();
		if(list.size()!=0) {
			return true;
		}else {
			return false;
		}
		
	}

}
