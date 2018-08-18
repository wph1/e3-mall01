package cn.e3.manager.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王鹏豪 on 2018/8/12.
 */
public class MyTest {
    public static void main(String[] args) throws Exception{
        /** 初始化配置文件 **/
        Configuration configuration = new Configuration();
        /** 设置编码 **/
        configuration.setDefaultEncoding("utf-8");
        /** 我的ftl文件是放在D盘的**/
        String fileDirectory = "D:\\";
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
        /** 加载模板 **/
        Template template = configuration.getTemplate("2010.ftl");
        /** 准备数据 **/
        Map<String,String> dataMap = new HashMap<>();
        /** 在ftl文件中有${textDeal}这个标签**/
        dataMap.put("name","王鹏豪");
        dataMap.put("year","2018");
        dataMap.put("month","8");
        dataMap.put("day","12");
        dataMap.put("xuehao","201800002");
        dataMap.put("banji","家里蹲");
        /** 指定输出word文件的路径 **/
        String outFilePath = "D:\\test.doc";
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);

        if(out != null){
            out.close();
        }
    }
}
