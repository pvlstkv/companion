package com.pvlstkv.companion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companion")
public class Controller {
    @GetMapping("/{statusCode}")
    public ResponseEntity<String> getStatusCode(@PathVariable int statusCode){
        HttpStatus httpStatus = HttpStatus.resolve(statusCode);
        if (httpStatus != null) {
            return ResponseEntity.status(httpStatus).body(httpStatus.getReasonPhrase());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Неверный статус код: " + statusCode);
        }

    }
}
