package test;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.myproject.utils.DateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordUtils {

	private WordUtils() {
		throw new AssertionError();
	}
	/**
	 *
	 * @param templateFolder 你的ftl文件位置
	 * @param ftlFile  你的ftl 文件名
	 * @param map  需要渲染 数据
	 * @param localPath  生成word文档的位置    
	 * @param title  word文档名
	 * @return
	 * @throws IOException
	 */
	public static String exportWord(String templateFolder, String ftlFile, Map map, String localPath, String title) throws IOException {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassicCompatible(true);
		configuration.setDirectoryForTemplateLoading(new File(templateFolder)); //读取ftl 模板位置
		try {
			String datePath = DateUtils.getNowTime("yyyy/MM/dd");
			//使用时间为文件夹生成word生成的位置
			String path = localPath + "/word/" + datePath; 
			//定义word文档名称
			String fileName = title + ".doc";  
			//创建文件夹
			File outFile = new File(path + "/" + fileName);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			//读取 模板内容
			Template template = configuration.getTemplate(ftlFile, "utf-8");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			template.process(map, out);

			out.flush();
			out.close();
			
			return path + "/" + fileName;
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return "";
	}
	

}