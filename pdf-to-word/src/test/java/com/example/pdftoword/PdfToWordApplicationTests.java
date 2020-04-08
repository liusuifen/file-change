package com.example.pdftoword;

import com.example.pdftoword.util.PdfUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdfToWordApplicationTests {

    @Autowired
    PdfUtil pdfUtil;

    @Test
    void contextLoads() {
    }

    @Test
    public void wordToPdftest(){
    pdfUtil.wordToPdf("C:\\Users\\kayak-sz-0276\\Desktop\\学习资料\\redis\\01-VIP-Redis核心数据结构与核心原理.doc","C:\\Users\\kayak-sz-0276\\Desktop\\学习资料\\redis\\a.pdf");
    }

}
