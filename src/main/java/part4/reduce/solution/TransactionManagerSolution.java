package part4.reduce.solution;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import model.Trader;
import model.Transaction;

public class TransactionManagerSolution {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();
				
		System.out.println("=====");
		// Biggest Transaction
		Optional<Transaction> biggestTrans = transactions.stream().max((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(biggestTrans.get());
		
		
		System.out.println("=====");
		
		// Accumulate Transaction amounts
		Transaction accumulateTrans = transactions.stream().reduce(
				new Transaction(null, 0, 0),				
				(t1, t2) -> 
				new Transaction(null, 
						Integer.max(t1.getYear(), t2.getYear()), 
						t1.getValue() + t2.getValue()));
		System.out.println(accumulateTrans);
	}

	private static List<Transaction> getTransactions() {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(
				new Transaction(brian, 2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
}
