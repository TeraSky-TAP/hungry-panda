package org.example.hungry_panda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class DatabaseConfig {

    @Value("${spring.cloud-binding.claim-name}")
    private String binding;

    private String hostFilePath = binding + "/host";
    private String portFilePath = binding + "/port";
    private String databaseFilePath = binding + "/database";
    private String passwordFilePath = binding + "/password";
    private String usernameFilePath = binding + "/username";
    private String providerFilePath = binding + "/provider";
    private String typeFilePath = binding + "/type";

    private String dbUrl;
    private String type;
    private String provider;
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;

    @PostConstruct
    public void init() {

        type = readFileContent(typeFilePath); // postgresql
        provider = readFileContent(providerFilePath); // bitnami
        host = readFileContent(hostFilePath); // IP address
        port = readFileContent(portFilePath); // 5432
        database = readFileContent(databaseFilePath); // psql-1-q56pl
        username = readFileContent(usernameFilePath);
        password = readFileContent(usernameFilePath);

        System.setProperty("spring.datasource.username", username);
        System.setProperty("spring.datasource.password", password);

        dbUrl = "jdbc:" + type + "://" + host + ":" + port + "/" + database;

        System.setProperty("spring.datasource.url", dbUrl);
    }

    private String readFileContent(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}
