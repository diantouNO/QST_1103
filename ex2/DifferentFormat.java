package No2;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex2
 * 1. 修改代码，使程序在输入『31/Dec/2015:00:02:09』的时候，转化为时间戳并输出，把结果填写到README.md当中
 * 2. 和ex1对比，对多出来的代码进行注释
 * 3. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class DifferentFormat {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//将输入的日期语言转换成美国的有用常量
		Locale locale = Locale.US; 
		//输入的时期格式为31/Dec/2015:00:02:09，所以将日期格式改为dd/MMM/yyyy:HH:mm:ss
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale); //修改格式
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			Date lineDate = null;
			long lineTimestamp;
			try {
				lineDate = inputFormat.parse(line);
				lineTimestamp = lineDate.getTime();
				System.out.println(lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
