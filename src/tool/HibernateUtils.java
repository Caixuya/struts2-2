package tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration config;
	private static final SessionFactory sf;
	static{
		config=new AnnotationConfiguration().configure();		
		sf=config.buildSessionFactory();
	}	
	public static Session openSession(){
		return sf.openSession();
	}
	public static Date strToDate(String str) throws ParseException { 
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		   Date date =sdf.parse(str); 
		   return date;
	}


}
