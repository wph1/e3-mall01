package cn.e3.manager.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王鹏豪 on 2018/8/12.
 */
public class MyTest3 {
//https://blog.csdn.net/lmb55/article/details/64519658
    public static void main(String[] args) {
        Map<String,Object> params = packageObject();
		/*params格式如下：
		{
			${interfacetype11}=ecsClient, ${time1}=2017/03/14 14:36:15,${code2}=4114030153,  ${interfacetype10}=ecsClient, ${percentagecode10}=6.43%, ${percentagecode11}=17.74%,
			${text9}=返回欠费不能办理, ${percentagecode8}=67.71%, ${mainpercentage1}=98.57%, ${code1}=2107000024, ${svcname8}=GUSERBRAND,  ${text8}=2G用户主产品不在省份上报的列表中,
			${start1}=2017-03-13 ,  ${svcname9}=GUSERBRAND, ${percentagecode2}=18.06%, ${text10}=用户状态不处于有效期,  ${percentagecode1}=78.39%, ${text2}=4114030153,
			${interfacename1}=cu.tran.fusionflowquery, ${svctext1}=3G流量包查询, ${svctext2}=3G流量包查询,  ${svctext8}=用户品牌查询,${svctext9}=用户品牌查询,${svctext10}=用户品牌查询, ${svctext11}=用户品牌查询,
			${text11}=4114030153, ${interfacetype8}=ecsClient,  ${svcname11}=GUSERBRAND, ${end1}=2017-03-13 ,  ${interfacename10}=cu.tran.fusionflowquery, ${interfacetype9}=ecsClient,   ${svcname10}=GUSERBRAND, ${text1}=2G用户主产品不在省份上报的列表中, ${interfacename2}=cu.tran.fusionflowquery, ${interfacename11}=cu.tran.fusionflowquery,
			${code8}=2107000024, ${namelist1}=  1、3G流量包查询:24.26%  2、用户品牌查询:37.52%,
			${date1}=2017-03-13 ,  ${code9}=2114000061, ${code11}=4114030153,  ${svcname1}=G3GFLUX, ${code10}=2114000066,  ${svcname2}=G3GFLUX, ${interfacetype1}=ecsClient,
			${percentagecode9}=4.12%, ${interfacetype2}=ecsClient,  ${interfacename9}=cu.tran.fusionflowquery,
			${indexprovince1}=陕西,  ${interfacename8}=cu.tran.fusionflowquery
		}
		*/
        XwpfUtil xwpfUtil = new XwpfUtil();
        //读入word模板
//        InputStream is = getClass().getClassLoader().getResourceAsStream("wordTemplate.docx");
        try {
            FileInputStream is = new FileInputStream("D:/bb.docx");
           // xwpfUtil.exportWord(params,is,xwpfUtil);
        }catch (Exception e){

        }

    }
    /**
     * 组装word文档中需要显示数据的集合
     * @return
     */
    public static Map<String, Object> packageObject() {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("${name}", "werw");//数据查询时间
        params.put("${year}", "22");//生成文件时间
        params.put("${month}", "22");//生成文件时间
        params.put("${day}", "22");//生成文件时间
        params.put("${xuehao}", "22");//生成文件时间
        params.put("${banji}", "22");//生成文件时间

        // ……
        return params;
    }
}
