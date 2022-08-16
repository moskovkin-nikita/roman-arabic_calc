public interface Operations {
    Integer sum();
    Integer diff();
    Integer multiply();
    Integer divide();

    boolean checkIn(String input);
    void getData(String input);
    String calculate(String input);

    boolean isParsable(String input);
}
