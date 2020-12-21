package com.company.builders;

import com.company.pizza.Pizza;
import com.company.types.CheeseName;
import com.company.types.PastryType;
import com.company.types.PizzaType;

public class PizzaBuilder implements Builder {
    private PizzaType pizzaName;
    private PastryType pastryType;
    private int diameter;
    private CheeseName cheeseName;
    private String ingredients;
    private boolean cheeseBoard;

    @Override
    public void setPizzaName(PizzaType pizzaName) {
        this.pizzaName = pizzaName;
    }

    @Override
    public void setPastryType(PastryType pastryType) {
        this.pastryType = pastryType;
    }

    @Override
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void setCheeseName(CheeseName cheeseName) {
        this.cheeseName = cheeseName;
    }

    @Override
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void setCheeseBoard(boolean cheeseBoard) {
        this.cheeseBoard = cheeseBoard;
    }

    public Pizza getResult(){
        return new Pizza(pizzaName, pastryType, diameter, cheeseName, ingredients, cheeseBoard);
    }
}
