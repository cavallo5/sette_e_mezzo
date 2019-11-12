/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsetteemezzo;

/**
 * @author Vincenzo
 */
public class Carta {

    private int numero;   //il numero della carta
    private Seme seme;    //il seme della carta
    private float valorepunteggio = 0;  //il valore del punteggio della carta

   
    public Carta(int a, Seme b, float c) //costruttore della carta
    {
        this.numero = a;
        this.seme = b;
        this.valorepunteggio = c;
    }

    //metodi set
    /**
     * Modifica il numero della carta
     *
     * @param a numero della carta
     */
    private void setnumero(int a) {       //l'intero a diventa il nuovo numero
        numero = a;
    }

    /**
     * Modifica il seme della carta
     *
     * @param a seme della carta
     */
    private void setseme(Seme a) {         //il seme a diventa il nuovo seme
        seme = a;
    }

    /**
     * Modifica il valore del punteggio della carta
     *
     * @param a valore del punteggio della carta
     */
    public void setvalorepunteggio(float a) {    //il float a diventa il nuovo valorepunteggio
        valorepunteggio = a;
    }

    
    //metodi get
    /**
     * Restituisce il numero della carta
     *
     * @return il numero della carta
     */
    public int getnumero() {  //restituisce il numero della carta.
        return numero;
    }

    /**
     * Restituisce il seme della carta
     *
     * @return il seme della carta
     */
    public Seme getseme() {   //restituisce il seme della carta.
        return seme;
    }

    /**
     * Restituisce il valore del punteggio della carta
     *
     * @return il valore del punteggio della carta
     */
    public float getvalorepunteggio() {
        return valorepunteggio;
    }

  
    /**
     * Stampa una carta con numero e seme
     *
     * @return la stampa del numero e del seme della carta
     */
    @Override
    public String toString() {
        return +numero + " di " + seme + " con valore punteggio "+ valorepunteggio +"";
    }
    
    public boolean controllamatta() {
        boolean x = false;
        if (this.getseme() == Seme.DENARI && this.getnumero() == 10) {
            x = true;
        }
        return x;
    }

 
}