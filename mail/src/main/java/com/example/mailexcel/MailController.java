package com.example.mailexcel;

import com.alibaba.excel.EasyExcel;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.18
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    private final JavaMailSender javaMailSender;

    private final MailProperties mailProperties;

    private final Resource resource;

    public MailController(JavaMailSender javaMailSender,
                          MailProperties mailProperties, @Value("classpath:/herdityRankRule.json") Resource resource) {
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
        this.resource = resource;
    }

    @GetMapping("/json")
    public Object json() throws IOException {
        String s = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return s;
    }

    private String jsonRead(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }

    @PostMapping("/send")
    public String send() {
        byte[] bytes = excelToByteArray(data());
        email(bytes);
        return "OK";
    }

    @SneakyThrows
    private void email(byte[] attachment) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailProperties.getUsername());
        helper.setTo("zhaobingshuang@lasoplanet.com");
        helper.setText("内容：测试");
        helper.setSubject("主题：测试");
        // 附件
        helper.addAttachment("测试.xlsx", new ByteArrayResource(attachment));
        javaMailSender.send(message);
    }

    /**
     * 将 Excel 写入 ByteArrayOutputStream
     */
    private byte[] excelToByteArray(List<User> list) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        EasyExcel.write(outputStream, User.class).sheet("测试").doWrite(list);
        return outputStream.toByteArray();
    }

    /**
     * 数据
     */
    public static List<User> data() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "小明", 18));
        list.add(new User(2, "小红", 20));
        list.add(new User(3, "小华", 25));
        return list;
    }
}