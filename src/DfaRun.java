import java.util.Arrays;

public class DfaRun {
    public static void main(String[] args) {
        final DFARuleBook ruleBook = new DFARuleBook(Arrays.asList(
                new Rule(1, 'b', 1), new Rule(1, 'a', 2),
                new Rule(2, 'a', 3), new Rule(2, 'b', 2),
                new Rule(3, 'a', 3), new Rule(3, 'b', 3)
        ));

        System.out.println(ruleBook.nextState(1, 'a'));
        System.out.println(ruleBook.nextState(2, 'a'));
        System.out.println(ruleBook.nextState(3, 'b'));
    }
}
