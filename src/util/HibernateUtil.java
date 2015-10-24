package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	private static SessionFactory sessionFactory =
			buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
	//tratamento de erro de conexão	
            try {
			AnnotationConfiguration cfg = 
					new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (HibernateException e) {
		
			System.out.println("Criação inicial do objeto" +
					" SessionFactory falhou. Erro: "+e);
			throw new ExceptionInInitializerError(e);
		}
	}

}