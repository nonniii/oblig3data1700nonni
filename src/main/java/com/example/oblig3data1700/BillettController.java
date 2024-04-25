package com.example.oblig3data1700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillettController {

    @Autowired
    private BillettRepository rep;


    @PostMapping("/lagre")
    public ResponseEntity<Void> lagreBillett(@RequestBody Kinobilletter kinobillett) {
        rep.leggInn(kinobillett);
        return ResponseEntity.ok().build(); // Returnerer en HTTP 200 OK for å indikere suksess
    }


    @GetMapping("/hentAlle")
    public ResponseEntity<List<Kinobilletter>> hentAlleBilletter() {
        List<Kinobilletter> billetter = rep.hentAlle();
        return ResponseEntity.ok(billetter); // Returnerer billettene med en HTTP 200 OK
    }


    @DeleteMapping("/slettAlle")
    public ResponseEntity<Void> slettAlleBilletter() {
        rep.slettAlle();
        return ResponseEntity.ok().build(); // Returnerer en HTTP 200 OK for å indikere suksess
    }
}











