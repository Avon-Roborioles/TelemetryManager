package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ItemTypes.TelemetryItem;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TelemetryManager {

    private static TelemetryManager telemetryManager;
    private ArrayList<TelemetryItem> telemetryItems;
    private ArrayList<String> tagsToExclude;
    private ArrayList<String> tagsToInclude;
    private ArrayList<String> tempTelemetry=new ArrayList<>();

    public synchronized static TelemetryManager getInstance(){
        if (TelemetryManager.telemetryManager==null){
            TelemetryManager.telemetryManager=new TelemetryManager();
        }
        return telemetryManager;
    }
    private TelemetryManager(){
        telemetryItems=new ArrayList<TelemetryItem>();
        tagsToExclude=new ArrayList<String>();
    }
    public void addTelemetryItem(TelemetryItem item){
        if (!telemetryItems.contains(item)){
            telemetryItems.add(item);
        }
    }
    public void removeTelemetryItem(TelemetryItem item){
        if (telemetryItems.contains(item)){
            telemetryItems.remove(item);
        }
    }
    public void addExcludedTag(String tag){
        if (!tagsToExclude.contains(tag)) {
            tagsToExclude.add(tag);
        }
    }
    public void removeExcludedTag(String tag){
        tagsToExclude.remove(tag);
    }
    public void addIncludedTag(String tag){
        if (!tagsToInclude.contains(tag)) {
            tagsToInclude.add(tag);
        }
    }
    public void removeIncludedTag(String tag){
        tagsToInclude.remove(tag);
    }
    public void addTempTelemetry(String temp){
        tempTelemetry.add(temp);
    }

    public void print(Telemetry telemetry){
       print(telemetry::addLine, telemetry::update);
    }


    /**
     * This is a generic method to support telemetry for things like Panels or FTC Dashboard.
     * Look at the above method for an example with the normal telemetry for the Driver Hub
     * @param printer The method to add an item to the telemetry.
     * @param updater The method to update the telemetry
     */
    public void print(Consumer<String> printer, Runnable updater){
        for (int i=0;i<telemetryItems.size();i++){
            TelemetryItem item = telemetryItems.get(i);
            boolean isValid =true;
            //exclude
            for (int j=0;j<item.getTags().size();i++){
                if (!tagsToExclude.contains(item.getTags().get(j))){
                    isValid=false;
                }
            }
            //include
            for (int j=0;j<item.getTags().size();i++){
                if (tagsToInclude.contains(item.getTags().get(j))){
                    isValid=true;
                }
            }
            if (isValid) {
                printer.accept(telemetryItems.get(i).getItem());
            }
        }
        for (String temp :tempTelemetry){
            printer.accept(temp);
        }
        updater.run();
        //tempTelemetry= new ArrayList<>();
    }
    public void resetTempTelemetry(){
        tempTelemetry=new ArrayList<String>();
    }

    public void reset(){
        TelemetryManager.telemetryManager=null;
    }
}
