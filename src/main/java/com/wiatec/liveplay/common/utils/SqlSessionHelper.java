package com.wiatec.liveplay.common.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by xuchengpeng on 12/06/2017.
 */
public class SqlSessionHelper {

    public static SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("WEB-INF/mybatis-configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sqlSessionFactory.openSession();
    }
}
