package com.tayssir.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.user.service.AdminService;
import com.tayssir.user.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @PostMapping("/validate/{id}")
    public ResponseEntity<String> validateUser(@PathVariable Long id) {
        adminService.validateUser(id);
        return ResponseEntity.ok("User validated successfully");
    }

    @PostMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateUser(@PathVariable Long id) {
        adminService.deactivateUser(id);
        return ResponseEntity.ok("User deactivated successfully");
    }
    
    @GetMapping("/non-active-count")
    public ResponseEntity<Long> getNonActiveUsersCount() {
        Long count = userService.getNonActiveUsersCount();
        return ResponseEntity.ok(count);
    }
}
