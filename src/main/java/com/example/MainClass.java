package com.example;

public class MainClass {
    public static void main(String[] args) {
        Friend friend = new Friend();
        friend.setName("anton");
        friend.setAge(20);
        friend.setSkinColor("white");
        System.out.println(friend.getName() + " " + friend.getAge() + " " + friend.getSkinColor());
    }
}
