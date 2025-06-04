package ordering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalyses {

    public static void main(String[] args) {
        List<String> usersList = reading(Paths.get("res/Users.txt"));
        List<String> ordersList = reading(Paths.get("res/Orders.txt"));
        List<String> productsList = reading(Paths.get("res/Products.txt"));

        List<User> users = getUsers(usersList);
        List<Product> products = getProducts(productsList);
        List<Order> orders = getOrders(ordersList, products);

//        System.out.println(users);
//        System.out.println(products);
//        System.out.println(orders);

        Set<Product> orderedProducts = getOrderedProducts(orders);
        System.out.println(orderedProducts);
        Map<Product,Integer> productAndCntOfOrdered = getProductAndCntOfOrdered(orders, products);
        System.out.println(productAndCntOfOrdered);
        Map<Product, Set<User>> productAndOrderedUsers = getProductAndOrderedUsers(orders, users, orderedProducts);
        System.out.println(productAndOrderedUsers);
    }

    public static Map<Product, Set<User>> getProductAndOrderedUsers(List<Order> orders, List<User> users, Set<Product> orderedProducts) {
        Map<Product, Set<User>> productAndOrderedUsers = new HashMap<>();
        for (Product product : orderedProducts) {
            productAndOrderedUsers.put(product, new HashSet<>());
        }
        for (Order order : orders) {
            Integer userId = order.getUserId();
            User curUser = users.get(userId);
            List<Product> products = order.getProducts();
            for (Product product : products) {
                Set<User> orderedUsers = productAndOrderedUsers.get(product);
                orderedUsers.add(curUser);
                productAndOrderedUsers.put(product, orderedUsers);
            }
        }
        return productAndOrderedUsers;
    }

    public static Map<Product, Integer> getProductAndCntOfOrdered(List<Order> orders, List<Product> products) {
        Map<Product, Integer> productAndCntOfOrdered = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            productAndCntOfOrdered.put(products.get(i), 0);
        }
        for (Order order : orders) {
            List<Product> orderedProducts = order.getProducts();
            for (Product orderedProduct : orderedProducts) {
                productAndCntOfOrdered.put(orderedProduct, productAndCntOfOrdered.get(orderedProduct) + 1);
            }
        }
        return productAndCntOfOrdered;
    }

    public static Set<Product> getOrderedProducts(List<Order> orders) {
        Set<Product> orderedProducts = orders.stream()
                .flatMap(e -> e.getProducts().stream())
                .collect(Collectors.toSet());
        return orderedProducts;
    }

    public static List<Order> getOrders(List<String> ordersList, List<Product> products) {
        List<Order> orders;
        orders = ordersList.stream()
                .map(e -> {
                    String[] ps = e.split("#");
                    List<Product> curProducts = new ArrayList<>();
                    for (int i = 2; i < ps.length; i++) {
                        curProducts.add(products.get(Integer.parseInt(ps[i])));
                    }
                    return new Order(Integer.parseInt(ps[0]), Integer.parseInt(ps[1]), curProducts);
                })
                .collect(Collectors.toList());
        return orders;
    }

    public static List<User> getUsers(List<String> usersList) {
        List<User> users;
        users = usersList.stream()
                .map(e -> {
                    String[] ps = e.split("#");
                    return new User(Integer.parseInt(ps[0]), ps[1]);
                })
                .collect(Collectors.toList());
        return users;
    }

    public static List<Product> getProducts(List<String> productsList) {
        List<Product> products;
        products = productsList.stream()
                .map(e -> {
                    String[] ps = e.split("#");
                    return new Product(Integer.parseInt(ps[0]), ps[1]);
                })
                .collect(Collectors.toList());
        return products;
    }

    public static List<String> reading(Path path) {
        List<String> listOrders = null;
        try {
            listOrders = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }
        return listOrders;
    }
}
