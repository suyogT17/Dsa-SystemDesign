package com.systemdesign.designpattern.factory;

interface Button {
    void click();
}

class WinButton implements Button {
    public void click(){
        System.out.println("Windows button clicked");
    }
}

class MacButton implements Button {
    public void click(){
        System.out.println("Mac button clicked");
    }
}

interface CheckBox {
    void check();
}

class WinCheckBox implements CheckBox {
    public void check(){
        System.out.println("Windows checkbox checked");
    }
}

class MacCheckBox implements CheckBox {
    public void check(){
        System.out.println("Mac checkbox checked");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WinFactory implements GUIFactory{
    public Button createButton(){
        return new WinButton();
    }

    public CheckBox createCheckBox(){
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton(){
        return new MacButton();
    }

    public CheckBox createCheckBox(){
        return new MacCheckBox();
    }
}

class FactoryConfigurer {
    public static GUIFactory getFactory(String osName){
        if(osName.equals("WIN")) return new WinFactory();
        else return new MacFactory();
    }
}

class AbstractFactoryTest {
    public static void main(String ...args){
        GUIFactory guiFactory = FactoryConfigurer.getFactory("WIN");
        Button button = guiFactory.createButton();
        button.click();
        CheckBox checkbox = guiFactory.createCheckBox();
        checkbox.check();
    }
}