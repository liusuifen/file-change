package com.example.pdftoword.util;

import com.itextpdf.text.pdf.BaseFont;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
@Component
public class PdfUtil {

    /**
     * pdf文档转换为Word
     * @param path
     */
    public void pdfToWord(String path) {
        try {
            String pdfFile = path;
            PDDocument doc = PDDocument.load(new File(pdfFile));
            //获取pdf的页数
            int pagenumber = doc.getNumberOfPages();
            pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
            String fileName = pdfFile + ".doc";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);// 排序
            stripper.setStartPage(1);// 设置转换的开始页
            stripper.setEndPage(pagenumber);// 设置转换的结束页
            stripper.writeText(doc, writer);//内容写入转换
            writer.close();
            doc.close();
            System.out.println("pdf转换word成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * word文档转换为pdf
     * @param wordFile
     * @param pdfFile
     */
    public void wordToPdf(String wordFile, String pdfFile) {
        ActiveXComponent app = null;
        System.out.println("开始转换...");
        // 开始时间
         long start = System.currentTimeMillis();
        try {
            // 打开word
            app = new ActiveXComponent("Word.Application");
            // 获得word中所有打开的文档
            Dispatch documents = app.getProperty("Documents").toDispatch();
            System.out.println("打开文件: " + wordFile);
            // 打开文档
            Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
            // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
            File target = new File(pdfFile);
            if (target.exists()) {
                target.delete();
            }
            System.out.println("另存为: " + pdfFile);
            Dispatch.call(document, "SaveAs", pdfFile, 17);
            // 关闭文档
            Dispatch.call(document, "Close", false);
        } catch (Exception e) {
            System.out.println("转换失败" + e.getMessage());
        } finally {
            // 关闭office
            app.invoke("Quit", 0);
        }
    }

    public static boolean htmlToPdf2(String outputFile, String url)
            throws Exception {
        File outFile = new File(outputFile);
        if (!outFile.exists()) {
            outFile.getParentFile().mkdirs();
        }
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        String fontPath="/simsun.ttc";
        // 解决中文支持问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.flush();
        os.close();
        System.out.println("文件转换成功");
        return true;
    }


}
