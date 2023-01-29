package com.example.quest.webApi.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/secret-info")

public class PrivateController {
    @GetMapping("/")
    @RolesAllowed("Admin")
    public String getSecretInfo() {
        return "secretinfo";
    }
}
