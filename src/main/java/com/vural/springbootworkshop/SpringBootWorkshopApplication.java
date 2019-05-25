package com.vural.springbootworkshop;

import com.vural.springbootworkshop.model.Permission;
import com.vural.springbootworkshop.model.Role;
import com.vural.springbootworkshop.model.User;
import com.vural.springbootworkshop.repository.PermissionRepository;
import com.vural.springbootworkshop.repository.RoleRepository;
import com.vural.springbootworkshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootWorkshopApplication implements CommandLineRunner {

    Logger logger= LoggerFactory.getLogger(SpringBootWorkshopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWorkshopApplication.class, args);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Role admin=new Role("Admin");
        Permission write=new Permission("Write");
        User adminUser=new User();
        adminUser.setName("Admin User");
        adminUser.setEmail("admin@admin.com");
        adminUser.setPassword(passwordEncoder.encode("12345"));
        adminUser.addPermission(write);
        adminUser.addRole(admin);

        logger.info("New User is created ..." + userRepository.save(adminUser));

    }
}
