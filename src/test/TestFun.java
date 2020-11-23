package test;

import java.util.List;

import org.junit.Test;

import dao.YonghuDAO;
import po.Yonghu;

public class TestFun {
	@Test
	public void test1() {
		YonghuDAO dao=new YonghuDAO();
		List<Yonghu> all = dao.getAll();
		System.out.println(all.size());
	}
	
	@Test
	public void test2() {
		YonghuDAO dao=new YonghuDAO();
		System.out.println(dao.check("jason", "123456"));
		System.out.println(dao.check("jason", "321321"));
	}
}
