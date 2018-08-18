package cn.e3.manager.controller;

/**
 * Created by 王鹏豪 on 2018/8/12.
 */
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Java Web根据模板导出word文件（spring MVC controller实现）
 * @author lmb
 * @date 2017-3-14
 *
 */
@Controller//https://www.cnblogs.com/duanrantao/p/8682897.html
public class ExportControl {

//    private static final Logger logger = Logger.getLogger(ExportControl.class);

    /**
     * 导出word
     * @param param
     * @param request
     * @param response
     */
    @RequestMapping(value = "/export")
    public void exportWord(HttpServletRequest request,HttpServletResponse response){
//        logger.debug("导出word文件开始>>>>>>>>>>>>>");
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
        InputStream is = getClass().getClassLoader().getResourceAsStream("bb.docx");
//        InputStream is = getClass().getClassLoader().getResourceAsStream("jianli.docx");
        xwpfUtil.exportWord(params,is,request,response,xwpfUtil);
//        logger.debug("导出word文件完成>>>>>>>>>>>>>");
    }

    /**
     * 组装word文档中需要显示数据的集合
     * @return
     */
    public static Map<String, Object> packageObject() {
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("${name}", "werw");//数据查询时间
//        params.put("${year}", "22");//生成文件时间
//        params.put("${month}", "22");//生成文件时间
//        params.put("${day}", "22");//生成文件时间
//        params.put("${xuehao}", "22");//生成文件时间
//        params.put("${banji}", "22");//生成文件时间
//
//        // ……
//        return params;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("${position}", "java开发");
        params.put("${N}", "java开发");
        params.put("${name}", "段然涛");
        params.put("${sex}", "男");
        params.put("${national}", "汉族");
        params.put("${birthday}", "生日");
        params.put("${address}", "许昌");
        params.put("${height}", "165cm");
        params.put("${biYeDate}", "1994-02-03");
        params.put("${landscape}", "团员");
        params.put("${zhuanYe}", "社会工作");
        params.put("${xueLi}", "本科");
        params.put("${school}", "江西科技师范大学");
        params.put("${phone}", "177");
        params.put("${eMail}", "157");
        return params;
    }
    @RequestMapping(value = "/export2")
    public void exportWordData(HttpServletRequest request,HttpServletResponse response){
        WordUtils wordUtil=new WordUtils();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("${position}", "java开发");
        params.put("${N}", "java开发");
        params.put("${name}", "段然涛");
        params.put("${sex}", "男");
        params.put("${national}", "汉族");
        params.put("${birthday}", "生日");
        params.put("${address}", "许昌");
        params.put("${height}", "165cm");
        params.put("${biYeDate}", "1994-02-03");
        params.put("${landscape}", "团员");
        params.put("${zhuanYe}", "社会工作");
        params.put("${xueLi}", "本科");
        params.put("${school}", "江西科技师范大学");
        params.put("${phone}", "177");
        params.put("${eMail}", "157");

        try{
            Map<String,Object> header = new HashMap<String, Object>();
            header.put("width", 100);
            header.put("height", 150);
            header.put("type", "jpg");
            header.put("content", WordUtils.inputStream2ByteArray(getClass().getClassLoader().getResourceAsStream("1.ico"), true));
            params.put("${header}",header);
            Map<String,Object> header2 = new HashMap<String, Object>();
            header2.put("width", 100);
            header2.put("height", 150);
            header2.put("type", "jpg");
            header2.put("content", WordUtils.inputStream2ByteArray(getClass().getClassLoader().getResourceAsStream("2.jpg"), true));
            params.put("${header2}",header2);
            List<String[]> testList = new ArrayList<String[]>();
            testList.add(new String[]{"1","1AA","1BB","1CC"});
            testList.add(new String[]{"2","2AA","2BB","2CC"});
            testList.add(new String[]{"3","3AA","3BB","3CC"});
            testList.add(new String[]{"4","4AA","4BB","4CC"});
//            String path="C:/Users/Administrator/Desktop/jar包/mobanFile.docx";  //模板文件位置
            InputStream is = getClass().getClassLoader().getResourceAsStream("name.docx");
            InputStream tempIs = getClass().getClassLoader().getResourceAsStream("name.docx");
            String fileName= new String("测试文档.docx".getBytes("UTF-8"),"iso-8859-1");    //生成word文件的文件名
            wordUtil.getWord(tempIs,is,params,testList,fileName,response);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}