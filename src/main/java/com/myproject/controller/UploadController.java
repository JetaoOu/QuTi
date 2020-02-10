package com.myproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.service.AnswerService;
import com.myproject.service.UserService;
import com.myproject.utils.UploadUtitls;


@RestController
@RequestMapping("/Upload")
public class UploadController {
	
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/excel")
	public String upLoadExcel(@RequestParam MultipartFile excel) throws IOException{			
		System.out.println(excel.getContentType());       //文件类型
		System.out.println(excel.getName());				//文件参数名
		System.out.println(excel.getSize()); 				//文件大小
		System.out.println(excel.getBytes());				//文件字节
		System.out.println(excel.getClass());				//文件类
		System.out.println(excel.getInputStream());		//文件io本身
		
	    
	    InputStream fis = null;
        Workbook wookbook = null;
        try {
            fis = excel.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);// 得到工作簿
        } catch (Exception ex) {
            try {
                // 这里需要重新获取流对象，因为前面的异常导致了流的关闭
                fis = excel.getInputStream();
                // 2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(fis);// 得到工作簿
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Sheet sheet = wookbook.getSheetAt(0);// 得到一个工作表
        int totalRowNum = sheet.getLastRowNum();// 获得数据的总行数
        String Lat ;//纬度
        String Lng ;//经度

        // 获得所有数据
        UserController userController = new UserController();
        for (int i = 1; i <= totalRowNum; i++) {
        	
  
            // 获得第i行对象
            Row row = sheet.getRow(i);
            // 获得纬度
            Cell cell = row.getCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            
            Lat = cell.getStringCellValue();
            // 获得经度 
            cell = row.getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            Lng =  cell.getStringCellValue();
            userService.addExcel(Lng, Lat);
            
            
        }
        
        return "上传成功";
	}
	
	@RequestMapping("/image")
	public String upLoadImage(@RequestParam MultipartFile picture) throws IOException{			
		System.out.println(picture.getContentType());       //文件类型
		System.out.println(picture.getName());				//文件参数名
		System.out.println(picture.getSize()); 				//文件大小
		System.out.println(picture.getBytes());				//文件字节
		System.out.println(picture.getClass());				//文件类
		System.out.println(picture.getInputStream());		//文件io本身
		
		//获取到tomcat的WEB-INF/classes
		String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
		//截取掉包括/WEB-INF/后面的内容
		String rootPath = classpath.substring(0, classpath.indexOf("/webapps/"));
		//webapps/项目名/resource
		String path = rootPath + "/webapps/resource";
		String projectPath = rootPath + "/webapps/myproject-questionnaire/resource";
		//生成唯一文件名ID
		String uuidFileName = UploadUtitls.getUuidFileName(picture.getOriginalFilename());
		//生成该唯一ID目录名
		String realPath = UploadUtitls.getPath(uuidFileName);
		//webapps/项目名/resource/目录名/
		String url = path + realPath;
		String projectUrl = projectPath + realPath;
		File file = new File(url);
		File projectFile = new File(projectUrl);
		
		if(!file.exists()){
			file.mkdirs();
		}
		if(!projectFile.exists()){
			file.mkdirs();
		}
		
		//具体文件路径
		String URL = url + "/" + uuidFileName;
		String projectURL = projectUrl + "/" + uuidFileName;
		//生成目标文件
		File dictFile = new File(URL);
		File projectDictFile = new File(projectURL);
		
		FileUtils.copyInputStreamToFile(picture.getInputStream(), dictFile); 
		FileUtils.copyInputStreamToFile(picture.getInputStream(), projectDictFile); 
		//复制上传文件给目标文件
		//截取包括/resource/后的路径
		String MKV = URL.substring(URL.indexOf("/resource/"), URL.length());
	
		return MKV;
	}
//	
//	@RequestMapping("/word")
//	public void downloadCzsc(String questiongroupnumber, HttpServletRequest request,HttpServletResponse response) {
//		System.out.println(questiongroupnumber);
//
//		  try {
//			    // 获取目标文件的绝对路径
//			  	String srcFile = this.getClass().getResource("/").getPath().replaceFirst("/", ""); 
//			    String rootPath = srcFile.substring(0, srcFile.indexOf("/webapps/"));    
//			    String path = rootPath + "/webapps/resource/wordresource/"+"template.docx";  
//			    String templatePath = rootPath + "/webapps/resource/wordresource/"+"test.docx";
//			    
//			    List<String> optionsContent = new ArrayList<>();
//			    optionsContent.add("5高");
//			    optionsContent.add("4中上");
//			    optionsContent.add("3中");
//			    optionsContent.add("2中下");
//			    optionsContent.add("1低");
//			    optionsContent.add("平均分数");
//			    
//			    QuestionGroupEntity QuestionGroupEntity = questiongroupService.findByGroupNum(questiongroupnumber);
//			    List<QuestionWord> QuestionWord = new ArrayList<>(optionsContent.size());
//			    for(QuestionEntity questionEntity : QuestionGroupEntity.getQuestionList()) {
//			    	List<String> percent = new ArrayList<>();
//			    	for(options options : questionEntity.getOptionsList()) {
//			    		Long count = answerService.CountOptionID(options.getOptionsid());
//			    		percent.add(""+count);
//			    	}
//			    	QuestionWord questionWord = new QuestionWord(questionEntity.getQuestion().getContent(), percent, "avg");
//			    	QuestionWord.add(questionWord);
//			    }
//			  
//			    QuestionGroupWord QuestionGroupWord = new QuestionGroupWord("问卷内容", "问题组内容", QuestionWord, optionsContent, "备注内容");
//			   
//			    
//			    
////			    List<String> percent1 = new ArrayList<>();
////			    percent1.add("1");
////			    percent1.add("2");
////			    percent1.add("3");
////			    percent1.add("4");
////			    percent1.add("5");
////			    percent1.add("6");
////			    List<String> percent2 = new ArrayList<>();
////			    percent2.add("10");
////			    percent2.add("20");
////			    percent2.add("30");
////			    percent2.add("40");
////			    percent2.add("50");
////			    percent2.add("60");
////			    QuestionWord questionWord1 = new QuestionWord("1.人文社会科学素养、良好职业规范", percent1, "avg");
////			    QuestionWord questionWord2 = new QuestionWord("2.数学和其他自然科学知识的应用能力", percent2, "avg");
////			    QuestionWord questionWord3 = new QuestionWord("3.计算思维能力", percent1, "avg");
////			    QuestionWord questionWord4 = new QuestionWord("4.算法设计与程序实现能力", percent1, "avg");
////			    QuestionWord questionWord5 = new QuestionWord("5.计算机应用设计与开发能力", percent1, "avg");
////			    QuestionWord questionWord6 = new QuestionWord("6.信息工程项目集成与管理能力", percent1, "avg");
////			    QuestionWord questionWord7 = new QuestionWord("7.团队合作与沟通能力", percent1, "avg");
////			    QuestionWord questionWord8 = new QuestionWord("8.外文应用与跨文化交流能力", percent1, "avg");
////			    List<QuestionWord> QuestionWord = new ArrayList<>();
////			    QuestionWord.add(questionWord1);
////			    QuestionWord.add(questionWord2);
////			    QuestionWord.add(questionWord3);
////			    QuestionWord.add(questionWord4);
////			    QuestionWord.add(questionWord5);
////			    QuestionWord.add(questionWord6);
////			    QuestionWord.add(questionWord7);
////			    QuestionWord.add(questionWord8);
////			    List<String> optionsContent = new ArrayList<>();
////			    optionsContent.add("5高");
////			    optionsContent.add("4中上");
////			    optionsContent.add("3中");
////			    optionsContent.add("2中下");
////			    optionsContent.add("1低");
////			    optionsContent.add("平均分数");
////			    QuestionGroupWord QuestionGroupWord = new QuestionGroupWord("问卷内容", "问题组内容", QuestionWord, optionsContent, "备注内容");
//			    
//			    
//			    
//			    Map<String, Object> wordDataMap = new HashMap<String, Object>();// 存储报表全部数据
//		        Map<String, Object> parametersMap = new HashMap<String, Object>();// 存储报表中不循环的数据
//	
//		        List<Map<String, Object>> table1 = new ArrayList<Map<String, Object>>();
//		        for(QuestionWord element : QuestionGroupWord.getQuestionWord()) {
//		        	Map<String, Object> Map = new HashMap<>();
//			        Map.put("Question", element.getContent());
//			        Map.put("Percent", element.getPercent());
//			        Map.put("Avg", element.getAvg());
//			        table1.add(Map);
//		        }
//
//		        Map<String, Object> MapOption = new HashMap<>();
//		        List<String> Cells = new ArrayList<>();	        
//		        for(String value : optionsContent) {
//		        	Cells.add(value);
//		        }
//		        MapOption.put("Cells", Cells);
//		        table1.add(MapOption);
//		        
//		        wordDataMap.put("table1", table1);
////		        wordDataMap.put("table2", table2);
//		        
//		        wordDataMap.put("parametersMap", parametersMap);
//		        File file = new File(templatePath);//改成你本地文件所在目录
//	
//		        // 读取word模板
//		        FileInputStream fileInputStream = new FileInputStream(file);
//		        WordTemplate template = new WordTemplate(fileInputStream);
//	
//		        // 替换数据
//		        template.replaceDocument(wordDataMap);
//	
//		        //生成文件
//		        File outputFile=new File(path);//改成你本地文件所在目录
//		        FileOutputStream fos  = new FileOutputStream(outputFile);
//		        template.getDocument().write(fos);
//			        
//	            // 设置文件MIME类型
//	            // response.setContentType(getServletContext().getMimeType(filename));
//	//            response.setContentType(new MimetypesFileTypeMap().getContentType("template.doc"));
//	            
//	            response.setContentType("application/octet-stream");
//	            // 设置Content-Disposition
//	            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("统计结果.docx", "UTF-8"));
//	            
//	//            response.setCharacterEncoding("UTF-8");
//	            // 读取目标文件
//	            InputStream in = new FileInputStream(path);
//	            //通过response将目标文件写到客户端
//	            OutputStream out = response.getOutputStream();	 
//	            // 写文件
//	            int b;
//	            while ((b = in.read()) != -1) {
//	                out.write(b);
//	            }	 
//	            in.close();
//	            out.close();
//	         } catch (Exception e) {
//	            try {
//	                response.sendRedirect("/error/error.jsp");
//	            } catch (IOException e1) {
//	                e1.printStackTrace();
//	            }
//	            e.printStackTrace();
//	        }
//		}
//	
	@SuppressWarnings("deprecation")
    public static void getDataFromExcel(String filePath) {
        FileInputStream fis = null;
        Workbook wookbook = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);// 得到工作簿
        } catch (Exception ex) {
            try {
                // 这里需要重新获取流对象，因为前面的异常导致了流的关闭
                fis = new FileInputStream(filePath);
                // 2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(filePath);// 得到工作簿
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Sheet sheet = wookbook.getSheetAt(0);// 得到一个工作表
        int totalRowNum = sheet.getLastRowNum();// 获得数据的总行数
        String Lat ;//纬度
        String Lng ;//经度

        // 获得所有数据
        for (int i = 1; i <= totalRowNum; i++) {
            // 获得第i行对象
            Row row = sheet.getRow(i);
            // 获得纬度
            Cell cell = row.getCell(0);
            Lat = cell.getStringCellValue();
            // 获得经度
            cell = row.getCell(1);
            Lng =  cell.getStringCellValue();
            System.out.println("用户名：" + Lng + ",密码：" + Lat);
            
            
        }
    }


}
