public class App {
    public static void main(String[] args) throws Exception {
        Item[] items = {
                new Item("CPU", 5000),
                new Item("Memory", 1000),
                new Item("Monitor", 2500)
        };

        Array array = new Array(items);
        Iterator iterator = array.iterator();
        while (iterator.next()) {
            System.out.println(iterator.current());
        }
    }
}
