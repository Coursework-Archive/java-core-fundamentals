package carvedrockfitness.order;

import carvedrockfitness.user.User;
import carvedrockfitness.user.UserController;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderController {
    private final OrderService orderService = new OrderService();
    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    static {
        LOGGER.setLevel(Level.FINE);
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(OrderController.class.getSimpleName() + ".log");
        } catch(IOException e) {
            e.printStackTrace();
        }

        fileHandler.setLevel(Level.FINE);
        LOGGER.addHandler(fileHandler);
    }


    //get all endpoint
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    //get by carvedrockfitness.user
    public List<Order> getAllOrdersByUser(User user) {
        return orderService.getAllOrdersByUser(user);
    }

    //post endpoint
    public boolean addOrder(Order order) {
        LOGGER.log(Level.FINE, "At the endpoint order, with order details: " + order);
        return orderService.addOrder(order);
    }

    //delete
    public boolean deleteOrder(Order order) {
        return orderService.deleteOrder(order);
    }

}
