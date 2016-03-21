package com.ewangz.javaarchitecture;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by aaronqin on 16/3/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        Application.class,
        AbstractTests.MongoConfiguration.class
})
@WebAppConfiguration
public abstract class AbstractTests {
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).alwaysDo(print())
                .addFilters().build();
    }

    @After
    public void tearDown() {
    }

    @Configuration
    public static class MongoConfiguration extends AbstractMongoConfiguration {
        @Autowired
        private Environment env;

        @Override
        protected String getDatabaseName() {
            return "memory";
        }

        @Override
        public Mongo mongo() throws Exception {
            return new Fongo(getDatabaseName()).getMongo();
        }
    }

}
