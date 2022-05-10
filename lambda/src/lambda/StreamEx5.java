package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 스트림 : 배열이나 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해줌
//			코드의 간결성 유지, 매핑, 필터링과 같은 중간 처리 가능
public class StreamEx5 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("바둑","바나나","포도","딸기","바질", "강아지");
		
		// '바'로 시작하는 단어만 출력
		for(String i:list) {
			if(i.startsWith("바")) {
				System.out.println(i);
			}
		}
		
		//stream 이용
//		list.stream().filter(s -> s.startsWith("바")).forEach(s -> System.out.println(s));
//		list.stream().filter(s -> s.startsWith("바")).forEach(System.out::println);

		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("홍길동", 70));
		stuList.add(new Student("송혜교", 75));
		stuList.add(new Student("김지원", 88));
		stuList.add(new Student("정우성", 92));
		stuList.add(new Student("송중기", 93));
		
		//송으로 시작하는 학생 이름 출력
		for(Student stu:stuList) {
			if(stu.getName().startsWith("송")) {
				System.out.println(stu.getName());
			}
		}
		
		//stream
		//stuList.stream().filter(n -> n.getName().startsWith("송")).forEach(s -> System.out.println(s.getName()));
//		stuList.stream().map(n -> n.getName()).filter(s -> s.startsWith("송")).forEach(p -> System.out.println(p));
		
		// 80점 이상 점수 출력
		stuList.stream().map(s -> s.getJumsu()).filter(p -> p>=80).forEach(System.out::println);
	}
}
