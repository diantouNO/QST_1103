package No1;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//创建输入函数，实现输入
		Scanner scanner = new Scanner(System.in);
		//新建SimpleDateFormat对象inputFormat，日期的格式为yyyy-MM-dd HH:mm:ss
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//新建SimpleDateFormat对象outputFormat，日期的格式为yyyy/MM/dd HH:mm:ss
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//对输入的内容进行循环遍历
		while (scanner.hasNext()){
			//调到输入的下一条数据
			String line = scanner.nextLine();
			//新建日期对象，值为空
			Date lineDate = null;
			//声明时间戳变量，类型为long
			long lineTimestamp;
			//将时间转换的异常抛出
			try {
				//将inputFormat格式的时间转化为毫秒
				lineDate = inputFormat.parse(line);
				//将Date类型的对象转化为毫秒
				lineTimestamp = lineDate.getTime();
				//将运行完的结果进行输出
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}