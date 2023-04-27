package edu.iu.c322.moalnass.homework8.invoicingservice.Controller;

import edu.iu.c322.moalnass.homework8.invoicingservice.Model.Invoice;
import edu.iu.c322.moalnass.homework8.invoicingservice.Model.InvoiceItem;
import edu.iu.c322.moalnass.homework8.invoicingservice.Model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicingController {

    private final WebClient orderService;

    public InvoicingController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @GetMapping("/{orderId}")
    public Invoice findByOrderId(@PathVariable int orderId) {
        Order order = orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .bodyToMono(Order.class).block();
        if(order == null) {
            throw new IllegalStateException("order with this id was not found.");
        }
        Invoice invoice = new Invoice();
        List<InvoiceItem> items = new ArrayList<>();

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItems(order.items());
        items.add(invoiceItem);

        invoice.setInvoiceItems(items);
        invoice.setTotal(order.total());
        invoice.setPayment(order.payment());
        return invoice;
    }
}