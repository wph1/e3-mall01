//package cn.e3.manager.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.usermodel.Paragraph;
//import org.apache.poi.hwpf.usermodel.Range;
//
///**
// *
// *
// * @version $Id$
// */
//public class POITest {
//    //https://blog.csdn.net/yelllowcong/article/details/78594213
//    /**
//     * @param args
//     * @throws Exception
//     * @throws IOException
//     */
//    public static void main(String[] args) throws Exception, IOException {
//
//        String inFile = "D:/bb.doc";
//        String outFile = "D:/eee.doc";
//
//        Map<String,String> params = new HashMap<String,String>();
//        params.put("${name}", "werw");//数据查询时间
//        params.put("${year}", "22");//生成文件时间
//        params.put("${month}", "22");//生成文件时间
//        params.put("${day}", "22");//生成文件时间
//        params.put("${xuehao}", "22");//生成文件时间
//        params.put("${banji}", "22");//生成文件时间
//
//        //获取修改模版后的代码
//        HWPFDocument doc = createTemplateDoc(inFile, params);
//
//        //保存doc文件
//        saveDoc(doc,outFile);
//    }
//    /**
//     * 输出文件
//     * @param doc
//     * @param outPath
//     */
//    private static void saveDoc(HWPFDocument doc,String outPath){
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(new File(outPath));
//            doc.write(out);
//        } catch (Exception e) {
//            // TODO 自動生成された catch ブロック
//            e.printStackTrace();
//        }finally{
//            if(out != null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    // TODO 自動生成された catch ブロック
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    /**
//     根据代码的code，格式化输出数据
//     * @param file
//     * @param map
//     * @return
//     * @throws IOException
//     * @throws FileNotFoundException
//     */
//    private static HWPFDocument createTemplateDoc(String file, Map<String, String> map) throws IOException,
//            FileNotFoundException {
//        //获取到文档
//        HWPFDocument doc = new HWPFDocument(new FileInputStream(file));
//        Range range = doc.getRange();
//        //查看段落数量
//        int paraNum = range.numParagraphs();
//        for(int i=0;i<paraNum;i++){
//            //获取段落
//            Paragraph paragraph =range.getParagraph(i);
//            if(paragraph.text().indexOf("$")>-1){
//                for(Map.Entry<String, String> entry:map.entrySet()){
//                    paragraph.replaceText(entry.getKey(), entry.getValue());
//                }
//            }
//        }
//        return doc;
//    }
//
//
//}