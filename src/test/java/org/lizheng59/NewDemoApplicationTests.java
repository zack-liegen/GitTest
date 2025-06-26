package org.lizheng59;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
class NewDemoApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }
    @Test
    void postgresqlTest() {
        Long count = jdbcTemplate.queryForObject("select count(*) from test_table", Long.class);
        System.out.println("记录总数："+count);
    }

}
