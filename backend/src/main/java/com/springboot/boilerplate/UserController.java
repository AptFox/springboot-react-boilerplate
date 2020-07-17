package com.springboot.boilerplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    //Access users at localhost:8080/api/users/{username}
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "username") String username) {
        LOG.info("Received request for user: {}", username);
        User user = userRepository.findByUsername(username.toLowerCase());
        return ResponseEntity.ok(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        LOG.info("Received addUser request for: {}", user);

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
