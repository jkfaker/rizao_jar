package org.example.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.GoodsMapper;
import org.example.pojo.Goods;
import org.example.pojo.GoodsImg;
import org.example.service.FileImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import java.util.UUID;

@Service
@Slf4j
public class FileImportServiceImpl implements FileImportService {

//    private static final String PATH = "C:\\Users\\29443\\Desktop\\uploads\\csv\\";
    private static final String PATH = "/root/uploads/csv/";

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     *上传并保存文件并交给addByFiles进行处理
     **/
    @Override
    @Transactional
    public void uploadFile(MultipartFile file) throws IOException, CsvException {
        log.info("uploadfile");
        //获取原始文件名
        String originalFilename;
        originalFilename = file.getOriginalFilename();
        // 查看文件类型是否合法
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));// 获取文件扩展名
//        if (extname.equals("csv")) {
//            log.info("此文件类型不合法！");
//            Exception e = new Exception("此文件类型不合法！");
//        }
        String newFileName = UUID.randomUUID().toString()+extname;//
        // 随机名+文件扩展名

        // 将文件存储在服务器的磁盘目录
        String filePath = PATH + newFileName;
        file.transferTo(new File(filePath));
        log.info("文件上传：{}",newFileName);
        addByFiles(filePath);
    }


    /**
    *使用csv文件批量导入文本数据
    **/
    @Override
    @Transactional
    public void addByFiles(String csvFilePath) throws IOException, CsvException {

        log.info(csvFilePath);
        File csvFile = new File(csvFilePath);
        CSVReader reader = new CSVReader(new FileReader(csvFile));
//         保存并跳过表头
        List<String> header = Arrays.asList(reader.readNext());
        // 处理表头(删除\uFEFF，删除空格)
        for (int i = 0; i < header.size(); i++) header.set(i, header.get(i).replace(" ", "").replace("\uFEFF", ""));

        log.info("使用csv文件批量添加的商品信息：{}",header);

//         读取csv主体数据
        List<String[]> lines = reader.readAll();
//         遍历数据并导入到数据库
        for (String[] line : lines) {
//      通过header匹配，将line映射到Goods对象中
            log.info("使用csv文件批量添加的商品信息：{},{},{},{},{}",line[0],line[1],line[2],line[3],line[4]);
            Goods goods = mapToEntity(header, Arrays.asList(line));
            log.info("批量存入数据库的商品数据：{}",goods);
            goodsMapper.add(goods);
        }
    }


    /**
     * 自定义一个私有方法完成header与csv数据的手动映射
     **/
    private Goods mapToEntity(List<String> header, List<String> data) {
        Goods goods = new Goods();
        System.out.println(header);
//        log.info("{}",header.indexOf("name"));
//        log.info("{}",header.indexOf("price"));
//        log.info("{}",header.indexOf("detail"));
//        log.info("{}",header.indexOf("producer"));
//        log.info("{}",header.indexOf("classification"));


        goods.setName(data.get(header.indexOf("name")));
        goods.setPrice(data.get(header.indexOf("price")));
        goods.setDetail(data.get(header.indexOf("detail")));
        goods.setProducer(data.get(header.indexOf("producer")));
        goods.setClassification(data.get(header.indexOf("classification")));
        return goods;
    }
}
