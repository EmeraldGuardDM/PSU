package com.example;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        firstTask();
    }

    static void printStacks(Stack<Integer> fStack, Stack<Integer> sStack) {
        System.out.println(fStack);
        System.out.println(sStack);
        System.out.println();
    }

    static void swapStacks(Stack<Integer> fStack, Stack<Integer> sStack) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        tmpStack.addAll(fStack);
        fStack.clear();
        fStack.addAll(sStack);
        sStack.clear();
        sStack.addAll(tmpStack);
    }

    static void firstTask() {
        Stack<Integer> fStack = new Stack<Integer>();
        Stack<Integer> sStack = new Stack<Integer>();

        for (int i = 0; i < 10; i++) {
            fStack.push(i * 2);
            sStack.push(i *2 + 1);
        }

        printStacks(fStack, sStack);

        swapStacks(fStack, sStack);

        printStacks(fStack, sStack);
    }

    static void secondTask(){
        
    }
}
