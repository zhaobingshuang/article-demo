package com.example.service;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class FileController {

    @RequestMapping("/test")
    public Object test() {
        return "ok";
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (true) {
                String s = bufferedReader.readLine();
                System.out.println(s);
                if (s == null) {
                    break;
                }

            }
        }
        return file.getOriginalFilename();
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<DownloadData>();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
