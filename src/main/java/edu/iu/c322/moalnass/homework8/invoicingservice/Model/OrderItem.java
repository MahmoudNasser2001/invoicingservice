package edu.iu.c322.moalnass.homework8.invoicingservice.Model;

public record OrderItem(int id,
                        String name,
                        int quantity,
                        float price) {
}