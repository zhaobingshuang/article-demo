package com.example.client;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
public class FileController {

    private final FileFeignClient fileFeignClient;

    public FileController(FileFeignClient fileFeignClient) {
        this.fileFeignClient = fileFeignClient;
    }

    @RequestMapping("/test")
    public Object test() {
        return "ok";
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) {

        return fileFeignClient.upload(file);
    }

    @GetMapping("/download")
    public void download(HttpServletResponse servletResponse) {
        Response response = fileFeignClient.download();

        Response.Body body = response.body();
        for(Object key : response.headers().keySet()){
            List<String> kList = (List)response.headers().get(key);
            for(String val : kList){
                servletResponse.setHeader(key.toString(), val);
            }
        }

        try (InputStream inputStream = body.asInputStream();
             OutputStream outputStream = servletResponse.getOutputStream()) {
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            outputStream.write(b);
            outputStream.flush();
        } catch (IOException e) {
            log.error("导出Excel失败", e);
        }
    }
}
