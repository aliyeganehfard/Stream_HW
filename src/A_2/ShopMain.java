package A_2;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShopMain {
    public static void main(String[] args) throws ParseException {

        List<Category> categoryList = Arrays.asList(
                new Category("a"),
                new Category("b"),
                new Category("c"),
                new Category("d"),
                new Category("e")
        );

        List<Product> productsList = Arrays.asList(
                new Product("aa", 1000, categoryList.get(0)),
                new Product("bb", 3000, categoryList.get(1)),
                new Product("cc", 5000, categoryList.get(2)),
                new Product("dd", 1900, categoryList.get(3)),
                new Product("ee", 1040, categoryList.get(1))
        );

        List<Customer> customerList = Arrays.asList(
                new Customer("ali"),
                new Customer("mahdi")
        );

        List<Order> orderList = Arrays.asList(
                new Order(Date.valueOf("2022-02-02"), productsList.get(0), customerList.get(0)),
                new Order(Date.valueOf("2022-02-03"), productsList.get(1), customerList.get(0)),
                new Order(Date.valueOf("2022-02-04"), productsList.get(2), customerList.get(0)),
                new Order(Date.valueOf("2022-02-05"), productsList.get(3), customerList.get(1)),
                new Order(Date.valueOf("2022-02-02"), productsList.get(4), customerList.get(1)),
                new Order(Date.valueOf("2022-02-03"), productsList.get(0), customerList.get(1)),
                new Order(Date.valueOf("2022-02-04"), productsList.get(1), customerList.get(1)),
                new Order(Date.valueOf("2022-02-05"), productsList.get(2), customerList.get(0)),
                new Order(Date.valueOf("2022-02-02"), productsList.get(3), customerList.get(1)),
                new Order(Date.valueOf("2022-02-03"), productsList.get(0), customerList.get(0))
        );

        // sort by category
        System.out.println("sort by category :");
        Predicate<Order> byCategory = order -> order.getProduct().getCategory().getCategory().equals("a");
        orderList.stream()
                .filter(byCategory)
                .forEach(System.out::println);

        System.out.println("");
        // sort by date
        System.out.println("sort by date : ");
        Predicate<Order> byDate =
                order -> order.getDate().after(Date.valueOf("2022-02-03")) &&
                        order.getDate().before(Date.valueOf("2022-02-06"));

        orderList.stream()
                .filter(byDate)
                .forEach(System.out::println);

        System.out.println();
        // cheap product
        System.out.println("cheapest product : ");
        System.out.println(productsList.stream()
                .filter(product -> product.getCategory().getCategory().equals("a"))
                .min(Comparator.comparing(Product::getPrice)));

        System.out.println();
        // average
        System.out.println("average : ");
        System.out.println(orderList.stream()
                .filter(order -> order.getDate().equals(Date.valueOf("2022-02-03")))
                .mapToDouble(order -> order.getProduct().getPrice()).average());

    }
}
