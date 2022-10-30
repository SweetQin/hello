package org.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

/**
 * @description: 代码生成器 com.baomidou:mybatis-plus-generator:3.5.3
 * @since: 2022/10/30 14:40
 * @author: tianqin
 */
public class CodeGeneratorUtil {
    public static void main(String[] args) {
        FastAutoGenerator
                .create(
                        new DataSourceConfig.Builder(
                                "jdbc:mysql://localhost:3306/hello?serverTimeZone=GMT%2b8", // 数据库连接串
                                "username", // 数据库用户名
                                "password" // 数据库密码
                        )
                                .dbQuery(new MySqlQuery())
                                .schema("hello") // 数据库名
                                .typeConvert(new MySqlTypeConvert())
                                .keyWordsHandler(new MySqlKeyWordsHandler())
                )
                .globalConfig(builder -> builder
                        .author("tianqin")
                        .enableSwagger()
                        .outputDir("D:/code/helloworld/helloWorld/src/main/java"))
                .packageConfig(builder -> builder
                        .parent("com")
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "D:/code/helloworld/helloWorld/src/main/resources/mapper")))
                .execute();
    }
}
