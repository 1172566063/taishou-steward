package com.zkl.taishou.common.utils;

import com.zkl.taishou.common.constants.ResultBean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.zkl.taishou.common.constants.ResultBean;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/12-14:56
 * @Version:
 */
public class CommonUtils {

    /**
     * 功能描述：文件复制
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/12 15:05
     */
    public static File FileCopy(File targetFile,File targetSite) {
        try {
            Files.copy(targetFile.toPath(),targetSite.toPath());
        }catch (IOException e){
            return null;
        }
        return targetSite;
    }

    public ResultBean makePdf() {
        // 模板路径
        String templatePath = "C:/债权债务确认函模板.pdf";
        // 生成的新文件路径
        String newPDFPath = "C:/myuser/债权债务确认函样板.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            form.setField("debentures","");

            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }

        return new ResultBean();
    }



    /**
     * 判断double是否是整数
     * @param dob
     * @return
     */
    public static boolean isIntegerForDouble(double dob) {
        double eps = 1e-10;  // 精度范围
        return dob-Math.floor(dob) < eps;
    }
}
