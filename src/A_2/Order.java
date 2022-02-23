package A_2;


import java.sql.Date;

public class Order {
    private Date date;
    private Product product;
    private Customer customer;

    public Order(Date date, Product product, Customer customer) {
        this.date = date;
        this.product = product;
        this.customer = customer;
    }



    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
