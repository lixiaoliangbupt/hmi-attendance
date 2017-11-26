import com.globot.hmi.attendance.TestUtil
import com.globot.hmi.attendance.ExecuteGenerator
import com.globot.hmi.attendance.BaseTest
import com.globot.hmi.attendance.util.Page
import org.junit.Test

class MybatisGenerator extends BaseTest {

    @Test
    void generate() {
        new ExecuteGenerator()
                .setDatabaseUrl("jdbc:mysql://127.0.0.1:3306/attendance?useUnicode=true&amp;characterEncoding=UTF-8")
                .setDatabaseUsername("root")
                .setDatabasePassword("p@ssw0rlD")
                .setJavaCodeBasePath(TestUtil.calculateJavaCodeDir())
                .setResourcesBasePath(TestUtil.calculateResourcesDir() + "/base/")
                .setPageClass(Page.class)
                .invoke()
    }

}
