package org.example;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/db1?useServerPrepStmts=true", "root", "")
                //设置全局配置
                .globalConfig(builder -> {
                    builder.author("Yushun Shao") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/mybatisplus-04-generator/src/main/java"); // 指定输出目录
                })
                //设置包名相关配置
                .packageConfig(builder -> {
                    builder.parent("org.example") // 设置父包名
                            .moduleName("User")
                            .entity("domain")     //实体类包名
                            .mapper("dao")        //数据层包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\SSM study\\MyBatisPlus\\mybatisplus-04-generator\\src\\main\\java\\org\\example\\User")); // 设置mapperXml生成路径
                })
                //策略设置
                .strategyConfig(builder -> {
                    builder.addInclude("tbl_user") // 设置需要生成的表名
                            .addTablePrefix("tbl_"); // 设置过滤表前缀

                })
                .execute();
    }
}
