package strategy;

public class SimpleSumStrategy implements SumStrategy {

    @Override
    public int get(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1;
        }
        return sum;
    }

}
