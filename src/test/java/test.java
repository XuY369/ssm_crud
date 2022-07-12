import com.ssmcrud.bean.Department;
import com.ssmcrud.bean.Employee;
import com.ssmcrud.mapper.DepartmentMapper;
import com.ssmcrud.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        Department department = new Department(null, "开发部");
        List<Department> departments = departmentMapper.selectByExample(null);
        departments.forEach(department1 -> System.out.println(department1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for (int i=0;i<1000;i++){
            //        随机生成员工信息参数
            Integer[] radomNum={1,2,3};
            Random randomDid = new Random();
            int numindex = randomDid.nextInt(radomNum.length);
            String[] genderRadom=new String[]{"M","F"};
            Random randomGender = new Random();
            int genderIndex = randomGender.nextInt(2);
            String substring = UUID.randomUUID().toString().substring(0,5);
            mapper.insertSelective(new Employee(null,
                    substring,
                    genderRadom[genderIndex],
                    substring+"@XuY.com",
                    radomNum[numindex]));

        }
    }
}
