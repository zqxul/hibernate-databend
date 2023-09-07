import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDatabendExample {
    public static void main(String[] args) {
        System.out.println("test print");
        // 配置Hibernate
        Configuration configuration = new Configuration();
        // 设置数据库连接属性
        configuration.setProperty("hibernate.connection.driver_class", "com.databend.jdbc.DatabendDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:databend://tn3ftqihs--xsmall-8cg3.gw.aws-us-east-2.default.databend.com:443/book_db?ssl=true");
        configuration.setProperty("hibernate.connection.username", "cloudapp");
        configuration.setProperty("hibernate.connection.password", "75wwsz0izzf4");

        // 设置其他Hibernate属性
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.show_sql", "true");

        // 添加实体类
        configuration.addAnnotatedClass(Article.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 创建会话
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // 创建一个Employee对象
        Article article = new Article();
        article.setId(1);
        article.setTitle("John Doe news");

        // 将对象保存到数据库中
        session.save(article);


        // 提交事务
        session.getTransaction().commit();

        // 关闭会话和会话工厂
        session.close();
        sessionFactory.close();


    }
}
