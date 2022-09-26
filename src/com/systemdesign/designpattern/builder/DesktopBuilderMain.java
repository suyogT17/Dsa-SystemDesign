package com.systemdesign.designpattern.builder;

public class DesktopBuilderMain {
    public static void main(String[] args) {

        HpDesktopBuilder hpDesktopBuilder = new HpDesktopBuilder();
        DellDesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();

        DesktopDirector hpDesktopDirector = new DesktopDirector(hpDesktopBuilder);
        DesktopDirector dellDesktopDirector = new DesktopDirector(dellDesktopBuilder);

        Desktop hpDesktop = hpDesktopDirector.buildDesktop();
        hpDesktop.specs();
        Desktop dellDesktop = dellDesktopDirector.buildDesktop();
        dellDesktop.specs();
    }
}

class Desktop {
    String monitor;
    String keyboard;
    String mouse;
    String motherboard;

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void specs(){
        System.out.println("Desktop Specs: ");
        System.out.println("Monitor : "+monitor);
        System.out.println("Keyboard : "+keyboard);
        System.out.println("Mouse : "+mouse);
        System.out.println("Motherboard : "+motherboard);
    }
}

interface DesktopBuilder{
    void buildMonitor();
    void buildKeyboard();
    void buildMouse();
    void buildMotherboard();
    Desktop getDesktop();
}

class DellDesktopBuilder implements DesktopBuilder{

    Desktop desktop;

    public DellDesktopBuilder(){
        this.desktop = new Desktop();
    }
    public void buildMonitor() {
        desktop.setMonitor("Dell Monitor");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("Dell Keyboard");
    }

    public void buildMouse() {
        desktop.setMouse("Dell Mouse");
    }

    public void buildMotherboard() {
        desktop.setMotherboard("Dell Motherboard");
    }

    public Desktop getDesktop(){
        return desktop;
    }
}

class HpDesktopBuilder implements DesktopBuilder{

    Desktop desktop;

    public HpDesktopBuilder(){
        this.desktop = new Desktop();
    }
    public void buildMonitor() {
        desktop.setMonitor("HP Monitor");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("HP Keyboard");
    }

    public void buildMouse() {
        desktop.setMouse("HP Mouse");
    }

    public void buildMotherboard() {
        desktop.setMotherboard("HP Motherboard");
    }

    public Desktop getDesktop(){
        return desktop;
    }
}

class DesktopDirector {
    DesktopBuilder desktopBuilder;

    public DesktopDirector(DesktopBuilder desktopBuilder){
        this.desktopBuilder = desktopBuilder;
    }

    Desktop buildDesktop(){
        desktopBuilder.buildMonitor();
        desktopBuilder.buildKeyboard();
        desktopBuilder.buildMouse();
        desktopBuilder.buildMotherboard();
        return desktopBuilder.getDesktop();
    }
}