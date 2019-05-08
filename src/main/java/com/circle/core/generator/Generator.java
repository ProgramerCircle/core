package com.circle.core.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * @Description: 代码生成器
 * @Auther: yuan.liu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Generator {

    /**
     * 数据库连接信息
     */
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String driverName = "oracle.jdbc.driver.OracleDriver";
    private String userName = "CIRCLE";
    private String password = "CIRCLE";

    public static String scanner(String tip,String messages) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip );
        if(StringUtils.isNotEmpty(messages)){
            help.append("（"+messages+"）");
        }
        help.append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public void generate(){
        //com.baomidou.mybatisplus
        String packageName = scanner("包路径","当前项目的包路径,如com.baomidou.mybatisplus！");
        //demo
        String moduleName = scanner("模块名",null);
        //Demo
        String entityName = scanner("实体类名","注意首字母大写！");
        //TB_DEMO
        String tableName = scanner("表名","注意表名大小写区分！");
        //tom
        String author = scanner("作者",null);
        //true 删除ServiceImpl
        generate(packageName,moduleName,entityName,tableName,author);
    }

    public void generate(String packageName,String moduleName,String entityName,String tableName,String author){
        //获得当前项目路径
        String projectPath = System.getProperty("user.dir");
        //获得模块路径
        String modulePath = projectPath + "/src/main/java/" + packageName.replace(".","/")+"/"+moduleName;

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        //同名文件是否覆盖
        gc.setFileOverride(true);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        //不打开输出目录
        gc.setOpen(true);
        //xml二级缓存
        gc.setEnableCache(false);
        //生成xml默认resultMap
        gc.setBaseResultMap(true);
        //生成基本的sql
        gc.setBaseColumnList(false);
        gc.setEntityName(entityName);
        gc.setMapperName(entityName + "Mapper");
        gc.setControllerName(entityName + "Controller");
        gc.setServiceName(entityName + "Service");
        gc.setServiceImplName(entityName + "ServiceImpl");
        gc.setXmlName(entityName+"Mapper");
        mpg.setGlobalConfig(gc);

        //2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        //3.包路径配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(packageName);
        mpg.setPackageInfo(pc);

        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tableName);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.circle.core.entity.BaseEntity");
        // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        //5.设置freemarker模板, 需引入依赖
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //6.执行
        mpg.execute();
    }

    public static void main(String[] args) {
        new Generator().generate();
    }

}
