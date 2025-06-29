package org.principles.openclose;

public class Test {
    public static void main(String[] args) {
        ICouse javaCouse = new JavaCouse(96, "Java初级", 348d);
        JavaDiscountCouse javaDiscountCouse = (JavaDiscountCouse) javaCouse;
        System.out.println( "课程ID：" + javaDiscountCouse.getId() + " 课程名：" + javaDiscountCouse.getName() + " 课程价格：" + javaDiscountCouse.getPrice());
    }
}
