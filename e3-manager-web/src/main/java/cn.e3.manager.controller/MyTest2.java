package cn.e3.manager.controller;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.util.List;

/**
 * Created by 王鹏豪 on 2018/8/12.
 */
public class MyTest2 {
    //模板文件地址
    private static String inputUrl = "D:\\bb.docx";
    public  static  void runTest() throws  Exception{

        try {
            //解析docx模板并获取document对象
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //获取整个文本对象
            List<XWPFParagraph> allParagraph = document.getParagraphs();

            //获取XWPFRun对象输出整个文本内容
            StringBuffer tempText = new StringBuffer();
            for (XWPFParagraph xwpfParagraph : allParagraph) {
                List<XWPFRun> runList = xwpfParagraph.getRuns();
                for (XWPFRun xwpfRun : runList) {
                    tempText.append(xwpfRun.toString());
                }
            }
            System.out.println(tempText.toString());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        MyTest2.runTest();
    }
}
