package com.company;

import com.company.builders.PizzaBuilder;
import com.company.director.Director;
import com.company.pizza.Pizza;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Director director = new Director();

        PizzaBuilder builder = new PizzaBuilder();

        director.createAmericana(builder);
        Pizza pizza = builder.getResult();

        director.createMargherita(builder);
        Pizza pizza2 = builder.getResult();

        System.out.println(pizza.print());
        System.out.println(pizza2.print());
    }
}
