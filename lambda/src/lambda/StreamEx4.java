package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 : 배열이나 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해줌
//			코드의 간결성 유지, 매핑, 필터링과 같은 중간 처리 가능
public class StreamEx4 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("adc","def","apple","melon","text");
		
		List<String> upperList = new ArrayList<String>();
		//대문자로 변경한 후 출력
		for(String i:list) {
			 upperList.add(i.toUpperCase());
		}
		System.out.println(upperList);
		
		//stream 이용
//		Stream<String> stream = list.stream();
//		Stream<String> upper = stream.map(String::toUpperCase);
//		upper.forEach(s -> System.out.println(s));
		
		List<String> upperList2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperList2);
	}
}
