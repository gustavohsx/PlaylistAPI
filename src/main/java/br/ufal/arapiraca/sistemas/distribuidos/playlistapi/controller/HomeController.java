package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HomeController {

    @GetMapping
    public ResponseEntity<String> getHome() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Conectado a API");
    }
}
