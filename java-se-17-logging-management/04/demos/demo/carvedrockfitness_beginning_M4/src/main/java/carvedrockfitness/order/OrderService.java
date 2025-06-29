package carvedrockfitness.order;

import carvedrockfitness.user.User;
import carvedrockfitness.user.UserRepository;
import carvedrockfitness.user.UserStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());

    //get all logic
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //get by carvedrockfitness.user logic
    public List<Order> getAllOrdersByUser(User user) {
        if (UserRepository.getDummyDataList().contains(user)) {
            return orderRepository.findByUser(user);
        } else {
            LOGGER.log(Level.WARNING, "The user wasn't found: " + user);
            try {
                throw new Exception("The carvedrockfitness.user.User doesn't exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    //add carvedrockfitness.order logic
    public boolean addOrder(Order order) {
        if (order.getOrderDateTime().isAfter(LocalDateTime.now())) {
            try {
                LOGGER.log(Level.WARNING, "Trying to place an order in the future, order details: " + order);
                throw new Exception("Can't place a carvedrockfitness.order.Order in the future!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (order.getProducts().size() < 1) {
            try {
                LOGGER.log(Level.WARNING, "Trying to place an order with no products, order details: " + order);
                throw new Exception("Order must consist of at least one carvedrockfitness.product.Product!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (order.getUser().getUserStatus() == UserStatus.BLOCKED) {
            try {
                LOGGER.log(Level.WARNING, "Trying to place an order by a blocked user, order details: " + order);
                throw new Exception("Order cannot be placed by blocked carvedrockfitness.user.User!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else if (order.getUser().getUserStatus() == UserStatus.PENDING) {
            try {
                LOGGER.log(Level.WARNING, "Trying to place an order by a pending user, order details: " + order);
                throw new Exception("Order cannot be placed by pending carvedrockfitness.user.User!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        LOGGER.log(Level.INFO, "Placing an order, order details: " + order);
        return orderRepository.save(order);
    }

    //delete logic
    public boolean deleteOrder(Order order) {
        if (order.getOrderStatus() == OrderStatus.COMPLETED) {
            try {
                throw new Exception("Can't cancel a completed carvedrockfitness.order.Order!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (order.getOrderStatus() == OrderStatus.CANCELLED) {
            try {
                throw new Exception("The carvedrockfitness.order.Order was already cancelled!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderRepository.remove(order);
    }

}
