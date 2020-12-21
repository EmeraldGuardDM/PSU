package com.company.director;

import com.company.builders.Builder;
import com.company.types.CheeseName;
import com.company.types.PastryType;
import com.company.types.PizzaType;

public class Director {
    public void createMargherita(Builder builder){
        builder.setPizzaName(PizzaType.MARGHERITA);
        builder.setPastryType(PastryType.THICK);
        builder.setDiameter(32);
        builder.setCheeseName(CheeseName.RICOTTA);
        builder.setIngredients("Tomato, cucumber, pepper, ham, onion, hen");
        builder.setCheeseBoard(false);
    }

    public void createCarbonara(Builder builder){
        builder.setPizzaName(PizzaType.CARBONARA);
        builder.setPastryType(PastryType.THICK);
        builder.setDiameter(32);
        builder.setCheeseName(CheeseName.BRIE);
        builder.setIngredients("Cucumber, pepper, ham, onion, hen, olives");
        builder.setCheeseBoard(true);
    }

    public void createRomana(Builder builder){
        builder.setPizzaName(PizzaType.ROMANA);
        builder.setPastryType(PastryType.THIN);
        builder.setDiameter(28);
        builder.setCheeseName(CheeseName.COLBY);
        builder.setIngredients("Tomato, cucumber, pepper, ham, onion, olives, pineapple");
        builder.setCheeseBoard(false);
    }

    public void createAmericana(Builder builder){
        builder.setPizzaName(PizzaType.AMERICANA);
        builder.setPastryType(PastryType.THICK);
        builder.setDiameter(28);
        builder.setCheeseName(CheeseName.CHEDDAR);
        builder.setIngredients("Tomato, cucumber, onion, hen, sausage, bacon");
        builder.setCheeseBoard(true);
    }

    public void createPadana(Builder builder){
        builder.setPizzaName(PizzaType.PADANA);
        builder.setPastryType(PastryType.THIN);
        builder.setDiameter(32);
        builder.setCheeseName(CheeseName.GOUDA);
        builder.setIngredients("Tomato, cucumber, pepper, ham, onion, hen, bacon, olives");
        builder.setCheeseBoard(true);
    }

    public void createMimosa(Builder builder){
        builder.setPizzaName(PizzaType.MIMOSA);
        builder.setPastryType(PastryType.THICK);
        builder.setDiameter(32);
        builder.setCheeseName(CheeseName.SWISS);
        builder.setIngredients("Tomato, cucumber, pepper, ham, onion, hen, sausage");
        builder.setCheeseBoard(false);
    }
}
