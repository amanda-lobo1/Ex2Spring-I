package com.example.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {
    char [] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    String [] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
    ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
    "...-", ".--", "-..-", "-.--", "--.."};

    @GetMapping("conversor/{palavraConvertida}")
    public String conversorMorse (@PathVariable String palavraConvertida){
        String input = palavraConvertida.toLowerCase();
        char[] caracters = input.toCharArray();
        String codMorse = "";

        for (char c : caracters) {
            for (int j = 0; j < letras.length; j++) {
                if (letras[j] == c) {
                    codMorse += morse[j] + " ";
                }
            }
        }
        return  palavraConvertida + " : " + codMorse;
    }
}
