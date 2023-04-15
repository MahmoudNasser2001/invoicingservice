package edu.iu.c322.moalnass.homework8.invoicingservice.Model;

import java.util.List;

public record Order(int id,
                    int customerId,
                    float total,
                    Address shippingAddress,
                    List<OrderItem> items,
                    Payment payment) {
}