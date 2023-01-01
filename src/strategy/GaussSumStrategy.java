package strategy;

public class GaussSumStrategy implements SumStrategy {

    @Override
    public int get(int n) {
        return (n + 1) * n / 2;
    }

}
