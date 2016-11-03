package No4;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Locale locale = Locale.US;
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long beginDate = 0;
		long endDate = 0;
		//判断输入的长度是否大于1，至少需要两个时间
		if (args.length > 1) {
			beginDate = inputFormat.parse(args[0]).getTime();
			endDate = inputFormat.parse(args[1]).getTime();
		}
		Scanner scanner = new Scanner(System.in);
		String patternIP = "(\\d+.\\d+.\\d+.\\d+)"; // 匹配IP
		String patternIPandTime = "(\\[.*\\])"; // 匹配IP和时间
		Pattern rIP = Pattern.compile(patternIP);
		Pattern rIPandTime = Pattern.compile(patternIPandTime);

		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String strIp = null;
			String strTime = null;
			long lineTimestamp = 0;
			Date lineDate = null;
			Matcher mIP = rIP.matcher(line);
			if (mIP.find()) {
				strIp = mIP.group(1);
			}
			Matcher mIPandTime = rIPandTime.matcher(line);
			if (mIPandTime.find()) {
				strTime = mIPandTime.group(1).substring(1, 21);
				lineDate = regularFormat.parse(strTime);
				lineTimestamp = lineDate.getTime();
			}
			// 对在时间区间内的数据进行输出，将满足时间条件的IP输出
			if (lineTimestamp >= beginDate && lineTimestamp <= endDate)
				System.out.println(strIp);
		}
	}
}
