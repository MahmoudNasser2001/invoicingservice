package edu.iu.c322.moalnass.homework8.invoicingservice.Repository;

import edu.iu.c322.moalnass.homework8.invoicingservice.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}