package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		BinaryOperator<Integer> totalidade = (acm, n) -> acm + n;
		/*Reduce ? um m?todo terminal, voc? pode usar BinaryOperator
		 * de par?metro para esta fun??o, geralmente usa-se uma 
		 * vari?vel para se conseguir o valor de reduce*/
		int total = nums.stream().reduce(totalidade).get();
		System.out.println(total);
		Integer total2 = nums.parallelStream().reduce(100,totalidade);
		System.out.println(total2);
		//Resultado foi um Opcional<Integer>
		nums.parallelStream().filter(n -> n > 5).reduce(totalidade)
		.ifPresentOrElse(System.out::println,null);
		
	}
}
