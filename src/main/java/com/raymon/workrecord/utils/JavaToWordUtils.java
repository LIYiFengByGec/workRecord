package com.raymon.workrecord.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.raymon.workrecord.pojo.WordInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class JavaToWordUtils {
	public static void transWord(WordInfo wordInfo){
        try {
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("utf-8");
            //.xml 模板文件所在目录
            configuration.setClassForTemplateLoading(JavaToWordUtils.class, "/templates");
            Template template = configuration.getTemplate("metting.ftl");
            /** 指定输出word文件的路径 **/
            File docFile = new File("/usr/local/word/text.doc");
            FileOutputStream fos = new FileOutputStream(docFile);
            Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            template.process(wordInfo, bufferedWriter);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
