package org.example.Strategy;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws Exception {
        DiscountContext ctx = new DiscountContext();
        // 默认使用普通会员折扣:
        ctx.setStrategy("org.example.Strategy.UserDiscountStrategy");
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);
        // 使用满减折扣:
        ctx.setStrategy("org.example.Strategy.OverDiscountStrategy");
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);

    }
}
// 策略接口
interface DiscountStrategy {
    // 计算折扣额度:
    BigDecimal getDiscount(BigDecimal total);
}
// 打折策略
class UserDiscountStrategy implements DiscountStrategy {
    public BigDecimal getDiscount(BigDecimal total) {
        // 普通会员打九折:
        return total.multiply(new BigDecimal("0.9")).setScale(2, RoundingMode.DOWN);
    }
}
// 满减策略
class OverDiscountStrategy implements DiscountStrategy {
    public BigDecimal getDiscount(BigDecimal total) {
        // 满100减20优惠:
        return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? total.subtract(BigDecimal.valueOf(20)) : total;
    }
}
// 实施策略
class DiscountContext {
    // 持有某个策略:
    private DiscountStrategy strategy;
    // 设置新策略:
    public void setStrategy(String className) throws Exception {
        Class<?> clazz = Class.forName(className); // 加载类
        this.strategy = (DiscountStrategy) clazz.getDeclaredConstructor().newInstance();
    }
    public BigDecimal calculatePrice(BigDecimal total) {
        return this.strategy.getDiscount(total).setScale(2);
    }
}
