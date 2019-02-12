package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            Properties defaultProps = new Properties();
            try (InputStream defaultInputStream = Main.class.getResourceAsStream(("MyDefaultValues.xml"))) {
                defaultProps.loadFromXML((defaultInputStream));
            }

            Properties userProps = new Properties(defaultProps);
            loadUserProps(userProps);

            String welcomeMessage = userProps.getProperty("welcomeMessage");
            String farewellMessage = userProps.getProperty("farewellMessage");

            System.out.println(welcomeMessage);
            System.out.println(farewellMessage);

            if (userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
                userProps.setProperty("welcomeMessage", "WelcomeBack");
                userProps.setProperty("farewellMessage", "Things Will be Familar Now");

                saveUserProp(userProps);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void saveUserProp(Properties userProps) throws IOException {

        try (OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))) {
            userProps.storeToXML(outputStream, null);
        }
    }

    private static void loadUserProps(Properties userProps) throws IOException {

        Path userFile = Paths.get("userValues.xml");
        if (Files.exists(userFile)) {
            try (InputStream newInputStream = Files.newInputStream(userFile)) {
                userProps.loadFromXML(newInputStream);
            }

        }


    }
}
