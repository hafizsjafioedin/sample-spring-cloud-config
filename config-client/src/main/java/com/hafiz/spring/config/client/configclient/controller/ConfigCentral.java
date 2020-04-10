package com.hafiz.spring.config.client.configclient.controller;


import com.hafiz.spring.config.client.configclient.config.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


//@Component
@SpringBootApplication
@RestController
public class ConfigCentral {

	@Autowired
	private Environment env;
	
	

    @GetMapping(path="/config")
    public @ResponseBody Database show() {
        // This returns a JSON or XML with the banks

        Database db = new Database();
        db.setServer(env.getProperty("database.ip"));
        db.setUsername(env.getProperty("database.user"));
        db.setPassword(env.getProperty("database.password"));
        db.setName(env.getProperty("database.name"));

        return db;
    }
}
