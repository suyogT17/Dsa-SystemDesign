package com.systemdesign.designpattern.singleton;


enum SingletonEnum {
    INSTANCE;

    int value;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
public class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum.getValue());
        singletonEnum.setValue(2);
        System.out.println(singletonEnum.getValue());
    }

}
