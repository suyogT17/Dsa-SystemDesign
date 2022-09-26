package com.systemdesign.designpattern.command;

import java.util.Arrays;
import java.util.List;

//Driver

public class PlayWithTvRemote{
    public static void main(String[] args) {
        ElectronicDevice television = new Television();
        TVOn tvOn = new TVOn(television);
        DeviceButton onButton = new DeviceButton(tvOn);
        onButton.press();

        TVOff tvOff = new TVOff(television);
        DeviceButton offButton = new DeviceButton(tvOff);
        offButton.press();

        TVVolumeUp tvVolumeUp = new TVVolumeUp(television);
        DeviceButton volumeUpButton = new DeviceButton(tvVolumeUp);
        volumeUpButton.press();

        ElectronicDevice television2 = new Television();
        AllDeviceOff allDeviceOff = new AllDeviceOff(Arrays.asList(television, television2));
        DeviceButton allDeviceOffButton = new DeviceButton(allDeviceOff);
        allDeviceOffButton.press();
    }
}

//Receiver interface
interface ElectronicDevice {
    void on();
    void off();
    void up();
    void down();
}

//Concrete Receiver
class Television implements ElectronicDevice {
     int volume  =0 ;

     public void on(){
         System.out.println("TV On");
     }

    public void off(){
        System.out.println("TV Off");
    }

    public void up(){
         volume++;
        System.out.println("TV volume increased now is at "+volume);
    }

    public void down(){
         volume++;
        System.out.println("TV volume decreased now is at "+volume);
    }
}

interface Command {
    void execute();
}

class TVOn implements Command {

    ElectronicDevice electronicDevice;
    public TVOn(ElectronicDevice newDevice){
        electronicDevice = newDevice;
    }

    public void execute(){
        electronicDevice.on();
    }
}

class TVOff implements Command {

    ElectronicDevice electronicDevice;
    public TVOff(ElectronicDevice newDevice){
        electronicDevice = newDevice;
    }

    public void execute(){
        electronicDevice.off();
    }
}

class TVVolumeUp implements Command {

    ElectronicDevice electronicDevice;
    public TVVolumeUp(ElectronicDevice newDevice){
        electronicDevice = newDevice;
    }

    public void execute(){
        electronicDevice.up();
    }
}

class AllDeviceOff implements  Command {
     List<ElectronicDevice> devices;
     public AllDeviceOff(List<ElectronicDevice> devices){
         this.devices = devices;
     }

     public void execute(){
         devices.forEach(device -> device.off());
     }
}

//Invoker
class DeviceButton {

    Command command;
    public DeviceButton(Command newCommand){
        command = newCommand;
    }

    void press(){
        command.execute();
    }
}


