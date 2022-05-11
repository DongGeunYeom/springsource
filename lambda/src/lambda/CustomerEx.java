package lambda;

import java.util.ArrayList;
import java.util.List;

public class CustomerEx {

	public static void main(String[] args) {
		
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer("이순신", 40, 100));
		customerList.add(new Customer("김유신", 20, 100));
		customerList.add(new Customer("홍길동", 13, 50));
		customerList.add(new Customer("성춘향", 18, 70));
		customerList.add(new Customer("이원굉", 21, 200));
		customerList.add(new Customer("이거니", 60, 5000));
		// 고객 명단 출력
		customerList.stream().map(n->n.getName()).forEach(n -> System.out.println(n));
		System.out.println();
		
		// 총 여행 경비 계산
		long total = customerList.stream().mapToInt(n->n.getPrice()).sum();
		System.out.println("총 여행 경비 : "+total);

		// 고객 중 20세 이상인 사람의 이름을 정렬하여 출력
		customerList.stream().filter(c-> c.getAge() >=20).map(c -> c.getName()).sorted().forEach(n -> System.out.println(n));
		
	}

}
