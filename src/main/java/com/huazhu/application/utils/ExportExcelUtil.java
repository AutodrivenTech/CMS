package com.huazhu.application.utils;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 导出excel
 **/
@Slf4j
public class ExportExcelUtil {

    public static void exportExcel(List data, String fileName) throws Exception{


        if(CollectionUtils.isEmpty(data)){
            throw new RuntimeException("导出结果集中无数据");
        }
        if(StringUtils.isBlank(fileName)){
            throw new RuntimeException("导出文件名不能为空");
        }
        String savePath = new File(".").getCanonicalPath()+fileName+ExcelTypeEnum.XLSX.getValue();
        log.info("savePath:{}",savePath);
        OutputStream out = new FileOutputStream(savePath);
        Class clazz = data.get(0).getClass();
        log.info("class",clazz);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0,clazz);
            writer.write((List<? extends BaseRowModel>)data, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        excelDownload(savePath,fileName+ExcelTypeEnum.XLSX.getValue());
    }



    private static void excelDownload(String path,String fileName) throws UnsupportedEncodingException {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(path);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }

        }catch(Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(in != null) {
                try {
                    in.close();
                    out.close();
                }catch(Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }

        File file = new File(path);
        file.delete();
    }


    public static void exportExcel(List data, String fileName,Object object) throws Exception{
        if(CollectionUtils.isEmpty(data)){
            throw new RuntimeException("导出结果集中无数据");
        }
        if(StringUtils.isBlank(fileName)){
            throw new RuntimeException("导出文件名不能为空");
        }
        String savePath = new File(".").getCanonicalPath()+File.separator+fileName+ExcelTypeEnum.XLSX;
        log.info("savePath:{}",savePath);
        OutputStream out = new FileOutputStream(savePath);
        Class clazz = data.get(0).getClass();
        log.info("class",clazz);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0,clazz);
            writer.write((List<? extends BaseRowModel>)data, sheet1);
            writer.finish();
            addExcel(savePath,object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        excelDownload(savePath,fileName+ExcelTypeEnum.XLSX.getValue());
    }

    private static void addExcel(String excelPath, Object object) throws Exception{
        FileInputStream fs = new FileInputStream(excelPath);//获取excel
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        //获取工作表
        XSSFSheet sheet = wb.getSheetAt(0);
        //获取第一行(即:字段列头,便于赋值)
        XSSFRow row = sheet.getRow(0);
        //向excel中添加数据
        FileOutputStream out = new FileOutputStream(excelPath);
        //在现有行号后追加数据
        row = sheet.createRow(sheet.getLastRowNum()+1);

        //获取属性
        Field[] fields = object.getClass().getDeclaredFields();
        int rows=3;
        row.createCell(rows).setCellValue("合计");
        for (Field field:fields) {
            field.setAccessible(true);
            rows++;
            row.createCell(rows).setCellValue(field.get(object)==null?"0":String.valueOf(field.get(object)));
        }
        out.flush();
        wb.write(out);
        wb.close();
    }

}