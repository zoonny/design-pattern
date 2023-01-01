package strategy;

public class App {
    public static void main(String[] args) {
        SumPrinter printer = new SumPrinter();
        printer.print(new SimpleSumStrategy(), 10);
        printer.print(new GaussSumStrategy(), 10);
        printer.print(new SimpleSumStrategy(), 100);
        printer.print(new GaussSumStrategy(), 100);
    }
}
