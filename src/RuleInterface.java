interface RuleInterface {
    boolean isApplied(int state, char character);

    int nextState();
}
