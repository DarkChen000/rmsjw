import com.itdr.pojo.Users;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

public class DemoTest {

    @Test
    public void test1() throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        Users query = qr.query("select * from user where u_id = ?", new BeanHandler<Users>(Users.class), 1);
        System.out.println(query.getUsername());
    }

    @Test
    public void test2(){
        byte a = 127;
        byte b = 127;
        a +=b;
        System.out.println(a);
    }
}
