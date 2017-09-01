import java.util.Collection;

/**
 * Это детерминированный конечный автомат, он поддается правилам
 * детерминированности
 * <p>
 * <ol>
 * <li>
 * Не должно быть конфликтующих цепочек для перехода из одного
 * состояния в другое, это значит что для перехода из одного состояния
 * в другое у первого состояния не должно быть несколько правил с одной
 * и той же цепочкой символов
 * </li>
 * <li>
 * Не должно быть состояний переход из которых не определен
 * </li>
 * </ol>
 * <p>
 * Использовать автомат нужно следующим образом
 * <p>
 * {@code
 *  final DFARuleBook ruleBook = new DFARuleBook(Arrays.asList(
 *      new Rule(1, 'b', 1), new Rule(1, 'a', 2),
 *      new Rule(2, 'a', 3), new Rule(2, 'b', 2),
 *      new Rule(3, 'a', 3), new Rule(3, 'b', 3)
 *  ));
 *
 *  System.out.println(ruleBook.nextState(1, 'a'));
 *  System.out.println(ruleBook.nextState(2, 'a'));
 *  System.out.println(ruleBook.nextState(3, 'b'));
 * }
 */
class DFARuleBook {
    private final Collection<? extends RuleInterface> rules;

    /**
     * @param rules Список правил которыми может оперировать конечный автомат
     */
    DFARuleBook(Collection<? extends RuleInterface> rules) {
        this.rules = rules;
    }

    /**
     * Ищет следующее состояния которое идет после переданного состояния
     * с определенной цепочкой символов
     *
     * @param state     Начальное состояние
     * @param character Следующее состояние которое откликается на эту
     *                  цепочку символов
     * @return Следующее состояние
     * @throws NullPointerException Исключение выбрасывается когда автомату не
     *                              удалось найти подходящее следующее состояние
     */
    int nextState(int state, char character) {
        return findRule(state, character).nextState();
    }

    private RuleInterface findRule(int state, char character) {
        return rules.stream()
                .filter((rule) -> rule.isApplied(state, character))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
