package com.company.builders;

import com.company.types.CheeseName;
import com.company.types.PastryType;
import com.company.types.PizzaType;

public interface Builder {
    void setPizzaName(PizzaType pizzaName);
    void setPastryType(PastryType pastryType);
    void setDiameter(int diameter);
    void setCheeseName(CheeseName cheeseName);
    void setIngredients(String ingredients);
    void setCheeseBoard(boolean cheeseBoard);
}
