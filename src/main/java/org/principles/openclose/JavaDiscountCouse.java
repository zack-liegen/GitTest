package org.principles.openclose;

public class JavaDiscountCouse extends JavaCouse{
    public JavaDiscountCouse(Integer id, String name, Double price) {
        super(id, name, price);
    }
    @Override
    public Double getPrice() {
        return super.getPrice()-10.0;
    }
    public Double getOriginPrice() {
        return super.getPrice();
    }
}
