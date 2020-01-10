(ns cipher.core
  (:require [clojure.string :as str]))

(def posicao-do-a (int \a))
(def qtd-total-alfabeto 26)

(defn to-int
  "Esta função retorna inteiro correspondente da letra"
  [caractere]
  (- (int caractere) posicao-do-a))

(defn to-char
  "Esta função retorna a letra correspondente ao inteiro informado"
  [numero]
  (char (+ numero posicao-do-a)))

(defn shift
  "Esta função retorna a letra correspondente à soma do caractere com a chave informada"
  [char chave]
  (-> (to-int char)
      (+ chave)
      (mod qtd-total-alfabeto)
      (to-char)))

(defn shift-palavra
  "Esta função retorna palavra encriptada"
  [palavra chave]
  (apply str (mapv #(shift % chave) palavra)))


(defn shift-frase
  "função para encrpitar a frase"
  [frase chave]
  (mapv #(shift-palavra % chave) (str/split frase #" ")))

(defn shift-frase
  "função para encrpitar a frase"
  [frase chave]
  (->> (str/split frase #" ")
       (mapv #(shift-palavra % chave))
       (str/join " ")))