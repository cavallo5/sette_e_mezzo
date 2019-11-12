/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsetteemezzo;

import java.util.Scanner;

/**
 *
 * @author Vincenzo
 */
public class Giocatore {

    private String nomegiocatore; //stringa del nome del giocatore
    private MazzodiCarte mazzocartevisibile; //il mazzo di carte in mano del giocatore
    private Carta cartanascosta; //la carta che viene data
    private float punteggio; //punteggio del giocatore

    /**
     * Genera un giocatore e inizializza i suoi attributi
     */
    public Giocatore() {      //Costruttore
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il nome del giocatore");
        String nome = in.next();
        this.nomegiocatore = nome;
        this.mazzocartevisibile = new MazzodiCarte();  //mazzocartenascoste è un mazzo di carte vuoto
        this.punteggio = 0;

    }

    //metodi set
    /**
     * Modifica il nome del giocaotre
     *
     * @param a nome del giocatore
     */
    public void setnomegiocatore(String a) {
        this.nomegiocatore = a;
    }

    /**
     * Modifica il punteggio del giocatore
     *
     * @param a punteggio del giocatore
     */
    public void setpunteggio(float a) {
        this.punteggio = a;
    }

    public void setcartanascosta(Carta a) {
        cartanascosta = a;

    }

    //metodi get
    /**
     * Restituisce il nome del giocatore
     *
     * @return il nome del giocatore
     */
    public String getnomegiocatore() {
        return nomegiocatore;
    }

    /**
     * Restituisce una copia del MazzodiCarte mazzocartenascoste
     *
     * @return il mazzo di carte mazzocartenascoste
     */
    public MazzodiCarte getmazzocartevisibile() {
        return new MazzodiCarte(mazzocartevisibile);
    }

    /**
     * Restituisce il punteggio del giocatore
     *
     * @return il punteggio del giocatore
     */
    public float getpunteggio() {
        return punteggio;
    }


    public Carta getcartanascosta() {
        return cartanascosta;

    }

    /**
     * Stampa il giocatore con nomegiocatore e il mazzocartenascoste
     *
     * @return stringa con nomegiocatore e mazzocartenascoste
     */
    @Override
    public String toString() {
        return "il giocatore " + nomegiocatore + "  ha totalizzato: " + punteggio + "";
    }
    
  
}
