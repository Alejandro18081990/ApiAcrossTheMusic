package com.example.demo.musicoController;

import com.example.demo.entities.JamSession;
import com.example.demo.services.jamsServices.JamService;
import com.example.demo.services.jamsServices.JamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("apiATM/jams")
@RequiredArgsConstructor
public class JamController {

    @Autowired
    private JamServiceImpl jamServiceImpl;

    @GetMapping("/")
    public ResponseEntity<?> getAllJams() {
        return ResponseEntity.ok(jamServiceImpl.findAll());
    }
}
