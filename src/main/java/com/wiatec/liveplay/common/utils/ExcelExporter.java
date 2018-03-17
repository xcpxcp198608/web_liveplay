package com.wiatec.liveplay.common.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author patrick
 */
public class ExcelExporter {

    private static final Logger logger = LoggerFactory.getLogger(ExcelExporter.class);

    private ExcelExporter() {

    }

    private static HSSFWorkbook workbook;

    private static HSSFSheet sheet;
    private static final int TITLE_START_POSITION = 0;

    private static final int DATE_HEAD_START_POSITION = 1;

    private static final int HEAD_START_POSITION = 2;

    private static final int CONTENT_START_POSITION = 3;

    public static String export(List<?> dataList, List<String> titleList, String sheetName) {
        return export(null, dataList, titleList, sheetName);
    }

    public static String export(HttpServletRequest request, List<?> dataList, List<String> titleList, String sheetName) {
        initHSSFWorkbook(sheetName);
        createTitleRow(dataList, titleList, sheetName);
        createDateHeadRow(titleList);
        createHeadRow(titleList);
        createContentRow(dataList, titleList);
        //autoSizeColumn(titleMap.size());
        try {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + ".xls";
            //如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
            // 本地测试路径
//            String outPath = "/Users/xuchengpeng/IdeaProjects/panel/src/main/resources/export/" + fileName;
            String outPath;
            if(request == null){
                outPath = "/home/java_app/panel/web/export/" + fileName;
            }else{
                outPath = PathUtil.getRealPath(request) + "export/" + fileName;
            }
            OutputStream out = new FileOutputStream(outPath);
            workbook.write(out);
            out.close();
            return outPath;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String copyFile(String filePath){
        // copy excel file
        try{
            File file = new File(filePath);
            String copyFilePath = "/home/static/panel/export/";
            FileUtils.copyFileToDirectory(file, new File(copyFilePath));
            Runtime.getRuntime().exec("chmod -R 777 " + copyFilePath);
            String[] strings = filePath.split("/");
            return strings[strings.length -1];
        }catch (Exception e){
            logger.error("Exception: ", e);
        }
        return "";
    }

    private static void initHSSFWorkbook(String sheetName) {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    private static void createTitleRow(List<?> dataList, List<String> titleList, String sheetName) {
        CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleList.size() - 1);
        sheet.addMergedRegion(titleRange);
        HSSFRow titleRow = sheet.createRow(TITLE_START_POSITION);
        HSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(sheetName + "  total: " + dataList.size());
    }

    private static void createDateHeadRow(List<String> titleList) {
        CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleList.size() - 1);
        sheet.addMergedRegion(dateRange);
        HSSFRow dateRow = sheet.createRow(DATE_HEAD_START_POSITION);
        HSSFCell dateCell = dateRow.createCell(0);
        dateCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    private static void createHeadRow(List<String> titleList) {
        // 第1行创建
        HSSFRow headRow = sheet.createRow(HEAD_START_POSITION);
        int i = 0;
        for (String title : titleList) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(title);
            i++;
        }
    }

    private static void createContentRow(List<?> dataList, List<String> titleList) {
        try {
            int i=0;
            for (Object obj : dataList) {
                HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
                int j = 0;
                for (String title : titleList) {
                    String method = "get" + title.substring(0, 1).toUpperCase() + title.substring(1);
                    Method m = obj.getClass().getMethod(method, null);
                    Object v = m.invoke(obj, null);
                    String value = "";
                    if(v != null){
                        value =   m.invoke(obj, null).toString();
                    }
                    HSSFCell textCell = textRow.createCell(j);
                    textCell.setCellValue(value);
                    j++;
                }
                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动伸缩列（如非必要，请勿打开此方法，耗内存）
     * @param size 列数
     */
    private static void autoSizeColumn(Integer size) {
        for (int j = 0; j < size; j++) {
            sheet.autoSizeColumn(j);
        }
    }
}
