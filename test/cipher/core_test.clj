(ns cipher.core-test
  (:require [midje.sweet :refer :all]
            [cipher.core :as core]))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (fact "o caractere a é a primeira letra, na posição 0"
             (core/to-int \a) => 0)
       (fact "o caractere b é a segunda letra, na posição 1"
             (core/to-int \b) => 1)
       (fact "o caractere z é a segunda letra, na posição 25"
             (core/to-int \z) => 25))

(facts "recebe um número e retorna o caractere correspondente à posição representada"
       (tabular
           (core/to-char ?int) => ?result
            ?int ?result
            0      \a
            25     \z))

(facts "recebe um caractere e a chave e retorna o caractere criptografado"
       (tabular
         (core/shift ?char ?chave) => ?char-result
         ?char ?chave ?char-result
         \n     14     \b
         \f     12     \r))

(facts "recebe string e retorna encriptado"
       (fact ""
             (core/shift-palavra "banana" 14) => "pobobo"))

(facts "recebe frase e retorna encriptado"
       (fact ""
             (core/shift-frase "banana banana banana" 14) => "pobobo pobobo pobobo"))