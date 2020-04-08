package com.example.pdftoword.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class pdfController {


//    /**
//     * 批量导出座次表
//     *
//     * @param roomId
//     * @return
//     */
//    @RequestMapping("/exportSeatNumPlanPDF")
//    @ResponseBody
//    public String exportSeatNumPlanPDF(String roomId, String subjectId, HttpServletRequest request, HttpServletResponse response) {
//        String path1 = System.getProperty("root") + File.separator + "resources" + File.separator + "PDF" + File.separator;
//        File file = new File(path1);
//
//        if (!file.exists() && !file.isDirectory()) {
//            System.out.println("//不存在");
//            file.mkdir();
//        }
//        if (subjectId==null||"".equals(subjectId)) {
//            return "考试科目id不能为空";
//        }
//        BufferedOutputStream out = null;
//        BufferedInputStream in = null;
//        String[] split = null;
//        if (null != roomId && !"".equals(roomId)) {
//            split = roomId.split(",");
//        }
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
//        String format = df.format(new Date());
//
//
//        String ip = SystemConstants.get("ip");
//        SystemConstants.get("ip");
//
//        String port = SystemConstants.get("port");
//        try {
//            System.out.println(roomId);
//            boolean b = PdfUtils.htmlToPdf2(path1 + format+"-座次表.pdf", "http://"+ip+":" + port + request.getContextPath() + "/stuexamroom/selectRoomDoorPDF?path=zdbpzcb&roomId=" + roomId+"&subjectId="+subjectId);
//            System.err.println(b);
//            if (b) {
//                File f = new File(path1 + format+"-座次表.pdf");
//                out = new BufferedOutputStream(response.getOutputStream());
//                in = new BufferedInputStream(new FileInputStream(f));
//                response.setContentType(new MimetypesFileTypeMap().getContentType(f));// 设置response内容的类型
//                String filename = format+"-座次表";
//                if (isMSBrowsers.isMSBrowser(request)) {
//                    filename = URLEncoder.encode(filename, "UTF-8");
//                } else {
//                    filename = new String(filename.getBytes("utf-8"), "ISO8859-1");
//                }
//                response.setHeader("Content-disposition", "attachment;filename=" + filename + "." + "pdf");// 设置头部信息
//                byte[] buffer = new byte[1024];
//                int length = 0;
//                while ((length = in.read(buffer)) > 0) {
//                    out.write(buffer, 0, length);
//                }
//                out.flush();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "网络异常";
//        } finally {
//            try {
//                out.close();
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "下载成功";
//    }
//    @RequestMapping("/selectRoomDoorPDF")
//    public ModelAndView selectRoomDoorPDF(String path, String roomId, String subjectId) {
//        String[] split = null;
//        if (!"".equals(roomId) && !"null".equals(roomId)) {
//            split = roomId.split(",");
//        }
//        List<Examroom> stuExamRoom = null;
//        try {
//            stuExamRoom = stuExamRoomService.selectRoomDoorPDF(split, subjectId);
//            System.out.println(stuExamRoom);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        Map<String, Object> ma = new HashMap<>(16);
//        ma.put("stuExamRooms", stuExamRoom);
//        return new ModelAndView("pages/dzBackEnd/" + path, ma);
//
//    }
}
