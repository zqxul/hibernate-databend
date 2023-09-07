import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateMySQLExample {
    public static void main(String[] args) {
        System.out.println("test print");
        // 配置Hibernate
        Configuration configuration = new Configuration();
        // 设置数据库连接属性
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "w123456w");

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