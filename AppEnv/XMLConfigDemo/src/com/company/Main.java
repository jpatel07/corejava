package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Storing to xml
        Properties prop = new Properties();
        prop.setProperty("displayName", "J Patel");
        prop.setProperty("accountNum","123-45-6789");
        try(OutputStream out = Files.newOutputStream(Paths.get("props.xml"))){
            prop.storeToXML(out, "My demo config");
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

        //Loading to xml
        Properties loadProps = new Properties();
        try(InputStream in = Files.newInputStream(
                                Paths.get("props.xml"))) {
            loadProps.loadFromXML(in);
            String val1 = loadProps.getProperty("displayName");
            String val2 = loadProps.getProperty("accountNum");
            System.out.println("displayName loaded: " + val1);
            System.out.println("accountNum loaded: " + val2 );

        } catch(Exception ex) {
            System.out.println("Error Loading config: " + ex.getMessage());
        }
    }
}
