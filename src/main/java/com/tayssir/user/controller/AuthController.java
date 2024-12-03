package com.tayssir.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.user.entity.Agent;
import com.tayssir.user.entity.Laveur;
import com.tayssir.user.entity.Medecin;
import com.tayssir.user.entity.User;
import com.tayssir.user.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register/medecin")
    public ResponseEntity<String> registerMedecin(@RequestBody Medecin medecin) {
    	medecin.setRole("medecin");
        userService.saveUser(medecin);
        return ResponseEntity.ok("Medecin registered successfully");
    }

    @PostMapping("/register/agent")
    public ResponseEntity<String> registerAgent(@RequestBody Agent agent) {
    	agent.setRole("agent");
        userService.saveUser(agent);
        return ResponseEntity.ok("Agent registered successfully");
    }

    @PostMapping("/register/laveur")
    public ResponseEntity<String> registerLaveur(@RequestBody Laveur laveur) {
    	laveur.setRole("laveur");
        userService.saveUser(laveur);
        return ResponseEntity.ok("Laveur registered successfully");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> findByRole(@PathVariable String role) {
        List<User> users = userService.findByRole(role);
        return ResponseEntity.ok(users);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        userService.updateUser(id, updatedUser);
        return ResponseEntity.ok("User updated successfully");
    }

    // Delete User
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    
   

    @PostMapping("auth/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login successful. Welcome, " + user.getNom() + "!");
    }
   

}
