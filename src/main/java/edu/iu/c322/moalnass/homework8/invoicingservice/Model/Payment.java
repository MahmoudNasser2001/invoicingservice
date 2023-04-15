package edu.iu.c322.moalnass.homework8.invoicingservice.Model;

public record Payment(int id,
                      String method,
                      String number,
                      Address billingAddress) {
}