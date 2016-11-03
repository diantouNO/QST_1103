package No4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * 运行命令
 * cat a | java -jar Mapper.jar "2015-12-31 18:00:00" "2015-12-31 19:00:00" | java -jar Reducer.jar
 */
public class ReducerOfIPFilter {
	public static void main(String[] args){
		//接受Map输出的IP
		Scanner scanner = new Scanner(System.in);
		//用Map来存储输出的IP
		Map map = new HashMap();
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			//将IP作为Key存储，去重
			map.put(line, 1);
		}
		//统计map中键值对的数量，即为满足条件的IP数量
		System.out.println(map.size());
	}
}
