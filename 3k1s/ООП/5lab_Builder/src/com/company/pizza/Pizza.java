package com.company.pizza;

import com.company.types.CheeseName;
import com.company.types.PastryType;
import com.company.types.PizzaType;

public class Pizza {
    private PizzaType pizzaName;
    private PastryType pastryType;
    private int diameter;
    private CheeseName cheeseName;
    private String ingredients;
    private boolean cheeseBoard;

    public Pizza(PizzaType pizzaName, PastryType pastryType, int diameter, CheeseName cheeseName, String ingredients, boolean cheeseBoard) {
        this.pizzaName = pizzaName;
        this.pastryType = pastryType;
        this.diameter = diameter;
        this.cheeseName = cheeseName;
        this.ingredients = ingredients;
        this.cheeseBoard = cheeseBoard;
    }

    public PizzaType getPizzaName() {
        return pizzaName;
    }

    public PastryType getPastryType() {
        return pastryType;
    }

    public int getDiameter() {
        return diameter;
    }

    public CheeseName getCheeseName() {
        return cheeseName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public boolean isCheeseBoard() {
        return cheeseBoard;
    }

    public String print(){
        String info = "";
        info += "Pizza name: " + pizzaName + "\n";
        info += "Pastry type: " + pastryType + "\n";
        info += "Diameter: " + diameter + "\n";
        info += "Cheese name: " + cheeseName + "\n";
        info += "Ingredients: " + ingredients + "\n";
        if(cheeseBoard == true){
            info += "Cheese board: Yes\n";
        }
        else{
            info += "Cheese board: NO\n";
        }
        return info;
    }
}
