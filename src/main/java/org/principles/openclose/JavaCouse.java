package org.principles.openclose;

public class JavaCouse implements ICouse{
    private Integer id;
    private String name;
    private Double price;
    public JavaCouse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
