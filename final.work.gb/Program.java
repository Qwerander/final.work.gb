import menu.Menu;
import register.AnimalRegistry;
import utils.Counter;

public class Program {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        try (Counter counter = new Counter()) {
            Menu menu = new Menu(registry, counter);
            menu.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
