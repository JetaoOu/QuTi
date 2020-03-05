package utils;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import test.WordUtils;

public class CreatUUID {
	
	@Test
	public void uuid() {
		
		System.out.println(com.myproject.utils.CreatUUID.uuid());
    }
	
	
	@Test
    public void exportSupplier() throws IOException {
//		E:\eclipseProject\myproject-questionnaire\src\test\java\test
		File directory = new File("src\\test\\java\\test");
		directory.getCanonicalPath(); //得到的是C:/test 
		directory.getAbsolutePath();//得到的是C:/test/. 

		ArrayList<String> testList = new ArrayList<String>();
		testList.add("1.人文社会科学素养、良好职业规范");
		testList.add("2.数学和其他自然科学知识的应用能力");
		testList.add("3.计算思维能力");
		testList.add("4.算法设计与程序实现能力");
		testList.add("5.计算机应用设计与开发能力");
		testList.add("6.信息工程项目集成与管理能力");
		testList.add("7.团队合作与沟通能力");
		testList.add("8.外文应用与跨文化交流能力");
		String templateFolder = directory.getCanonicalPath();
		 System.out.println(templateFolder);
		String ftlName = "模板.ftl";
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", "2019届（2015级）毕业生调查问卷结果");
		map.put("contents", testList);
		String root = templateFolder;
		String title = "test1";
		
		//  注意这里的参数，根据你自己业务出入，参数说明上面已经注明！
        String downLoadPath = WordUtils.exportWord(templateFolder,ftlName,map,root,title);
        String fileName = map.get("title").toString();
        System.out.println(fileName);

        File file = new File(downLoadPath);
        InputStream inputStream;
        inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
	}

}
