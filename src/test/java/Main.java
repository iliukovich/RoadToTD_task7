import framework.utils.JsonUtils;
import framework.utils.XmlUtils;
import models.Order;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH_JSON = "src/test/resources/order.json";
    private static final String SERIALIZE_JSON_PATH = "target/order.json";
    private static final String FILE_PATH_XML = "src/test/resources/order.xml";
    private static final String SERIALIZE_XML_PATH = "target/order.xml";

    private static void jsonDeserialization() {
        Order order = JsonUtils.mapToObject(FILE_PATH_JSON, Order.class);

        System.out.println(order.getOrderID());
        System.out.println(order.getShopperEmail());
        System.out.println(order.getShopperName());
    }

    private static void xmlDeserialization() {
        Order order = XmlUtils.mapToObject(FILE_PATH_XML, Order.class);

        assert order != null;
        System.out.println(order.getOrderID());
    }

    private static Order createOrderObject() {

        Order order = new Order();

        order.setOrderID(98765);
        order.setShopperName("Stepan Stepanov");
        order.setShopperEmail("stepanov@gmail.com");

        List<Product> productsList = new ArrayList<>();
        Product productOne = new Product(12, "Ordinary product", 2);
        Product productTwo = new Product(5, "Just a product", 1);
        productsList.add(productOne);
        productsList.add(productTwo);
        order.setContents(productsList);
        order.setOrderCompleted(true);

        return order;
    }

    private static void jsonSerialization() {
        JsonUtils.writeToFile(SERIALIZE_JSON_PATH, createOrderObject());
    }

    private static void xmlSerialization() {
        XmlUtils.writeToFile(SERIALIZE_XML_PATH, createOrderObject());
    }

    public static void main(String[] args) {
//        xmlDeserialization();
//        jsonDeserialization();
//        jsonSerialization();
        xmlSerialization();
    }

}
