/**
 * Правило конечного автомата, определяет цепочку символов на
 * которую отвечает и следующее состояние к которому может перейти
 */
class Rule implements RuleInterface {
    private final int state;
    private final char character;
    private final int nextState;

    Rule(int state, char character, int nextState) {
        this.state = state;
        this.character = character;
        this.nextState = nextState;
    }

    /**
     * Мето сообщает о том, может ли это правило применяться к определенному
     * состоянию, это необходимо для того чтобы найти следующее состояние
     *
     * @param state     Состояние которое проверяется
     * @param character Цепочка символов которая зарегистрирована на правило
     * @return true когда цепочка может быть применена и false когда не может
     */
    @Override
    public boolean isApplied(int state, char character) {
        return (this.state == state && this.character == character);
    }

    /**
     * Возвращает следующее состояние в которое можно перейти после этого
     *
     * @return Значение следующего состояния
     */
    @Override
    public int nextState() {
        return nextState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Rule{" +
                "state=" + state +
                ", character=" + character +
                '}';
    }
}
