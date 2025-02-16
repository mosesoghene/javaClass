import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Integer, Integer[]> pizzas = new HashMap<Integer, Integer[]>();

    public static void main(String[] args) {


    }

    public Map<Integer, Integer[]> getPizzas() {
        return pizzas;
    }

    public void setPizzas(int id, Integer[] pizza) {
        this.pizzas.put(id, pizza);
    }

    public int getPizzaPrice(int type, int guestNumber){
        Integer[] pizza = getPizzas().get(type);
        int numberOfBoxes = guestNumber / pizza[0];

        return 0;
    }
}