import com.zay.dao.StudentDao;
import com.zay.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author ZhuAoYun
 * @Date 2020/10/1
 */
public class Test {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private StudentDao studentDao;
    /*public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> list = mapper.selectAll();
        for (Student student : list) {
            System.out.println("student = " + student);
        }
    }*/
    @Before
    public void before() throws IOException {
        is = Resources.getResourceAsStream("mybatis-config.xml");

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();

        studentDao = sqlSession.getMapper(StudentDao.class);
    }



    @org.junit.Test
    public void testSelectAll(){
        studentDao.selectAll().forEach(System.out::println);


    }
    @org.junit.Test
    public void testSelectOne(){
        Student student = studentDao.selectOne("A0005");
        System.out.println("student = " + student);
    }
    @org.junit.Test
    public void testInsert(){
        Student student=new Student("A0008","zxt",44);
        int insert = studentDao.insert(student);
        sqlSession.commit();
        System.out.println("insert = " + insert);
    }
    @org.junit.Test
    public void testUpdate(){
        Student student=new Student("A0008","zxt",24);
        int update = studentDao.update(student);
        sqlSession.commit();
        System.out.println("update = " + update);
    }
    @org.junit.Test
    public void testDelete(){
        int delete = studentDao.delete("A0008");
        sqlSession.commit();;
        System.out.println("delete = " + delete);
    }
    @After
    public void after(){
        System.out.println("Test.after");
    }
}
