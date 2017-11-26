package com.globot.hmi.attendance;

import com.globot.hmi.attendance.util.SpringBeanUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml",
        "classpath:applicationContext-mvc.xml",
        "classpath:applicationContext-mybatis.xml",
        "classpath:applicationContext-cache.xml"})
@Transactional("mybatisTransactionManager")
@Rollback(true)
public class BaseTest {
    private static String path;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Resource
    private ApplicationContext applicationContext;

    @Before
    public void setUpBefore() {
        SpringBeanUtil.setApplicationContext(applicationContext);
    }

//    //初始化代码放在静态代码块是因为命令行执行时同一个进程会运行多次setUpBeforeClass方法
//    static {
//        MtDefaultWebBaseTest.newInstant().init();
//    }



    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        log.info("run setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        log.info("run tearDownAfterClass");
    }

    @Test
    public void doNothing() {
        log.info("run doNothing");
    }
}