package lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx7 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과","딸기","배","바나나","수박","참외","바나나");
		
		
		list.stream().distinct().forEach(s->System.out.println(s));
		
		Stream<File> stream = Stream.of(new File("file1.txt"),new File("file2.txt"),new File("Ex1"),new File("Ex2.bak"),new File("email.test.java"));
		
		// 파일명을 모아서(map) 확장자가 없는 파일명은 제외(filter)하고, 확장자만 모으고(map)
		// 확장자 중복 제거(distinct) 후 출력(forEach)
		stream.map(File::getName)
			  .filter(f->f.indexOf(".")>-1)
			  .map(s->s.substring(s.lastIndexOf(".")+1))
			  .distinct().forEach(p -> System.out.print(p+"\t"));
		
	}
}
