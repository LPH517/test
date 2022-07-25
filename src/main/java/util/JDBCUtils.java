package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class JDBCUtils {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static{
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("mybaties加载配置文件失败");
        }
    }

    public static SqlSession getSession() {
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null ) {
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void remove() {
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null) {
            threadLocal.remove();
            sqlSession.close();
        }
    }
}
