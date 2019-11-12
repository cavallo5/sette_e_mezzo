/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsetteemezzo;

import java.util.Scanner;

/**
 *
 * @author Vincenzo
 */
public class Partita {

    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private MazzodiCarte mazzocentrale;   //mazzo di 40 carte napoletane

    /**
     * Genera una partita
     */
    public Partita() {           //costruttore

        this.mazzocentrale = new MazzodiCarte();   //mazzocentrale è un mazzo di carte vuoto
        this.mazzocentrale.mazzodi40carte();     //metto 40 carte nel mazzocentrale
        this.mazzocentrale.mischia(); //mischio il mazzocentrale
        this.giocatore1 = new Giocatore();
        this.giocatore2 = new Giocatore();
    }

    //metodi get
    /**
     * Restituisce il giocatore1
     *
     * @return il GiocatoreUmano 1
     */
    public Giocatore getgiocatore1() {
        return giocatore1;
    }

    /**
     * Restituisce il giocatore2
     *
     * @return il GiocatoreUmano 2
     */
    public Giocatore getgiocatore2() {
        return giocatore2;
    }

    /**
     * Restituisce il mazzocentrale
     *
     * @return il MazzodiCarte mazzocentrale
     */
    public MazzodiCarte getmazzocentrale() {    //restituisce il mazzocentrale
        return new MazzodiCarte(mazzocentrale);
    }

    //metodi set
    /**
     * Modifica il giocatore1
     *
     * @param a un GiocatoreUmano
     */
    private void setgiocatore1(Giocatore a) {       //Il giocatore a diventa il nuovo giocatore1
        giocatore1 = a;
    }

    /**
     * Modifica il giocatore2
     *
     * @param a un GiocatoreUmano
     */
    private void setgiocatore2(Giocatore a) {      //Il giocatore a diventa il nuovo giocatore2
        giocatore2 = a;
    }

    /**
     * Modifica il mazzocentrale
     *
     * @param a MazzodiCarte
     */
    private void setmazzocentrale(MazzodiCarte a) {     //Il mazzo di carte a diventa il mazzocentrale del tavolo
        mazzocentrale = new MazzodiCarte(a);
    }

    /**
     * Ferma la partita per la stampa dei mazzi attendendo l'imput del giocatore
     */
    private void stop() {
        System.out.println("Premere un tasto e il tasto invia per continuare ");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

    public Carta daiCarta(Giocatore a) {
        Carta daicarta = mazzocentrale.getmazzo().get(0);
        mazzocentrale.remove(0);
        return daicarta;
    }

    public float valorematta() {
        System.out.println("Vuoi dare un valore alla matta? Se metti no, la matta varrà sempre 1/2 Premere si/no");
        float a = (float) 1 / 2;
        Scanner in = new Scanner(System.in);
        String scelta = in.next();
        if ("si".equals(scelta)) {
            System.out.println("Indicare il valore della matta");
            Scanner ceck = new Scanner(System.in);
            String zeta = ceck.next();
            boolean x = false;
            do {
                if ("1".equals(zeta)) {
                    x = true;
                }
                if ("2".equals(zeta)) {
                    x = true;
                }
                if ("3".equals(zeta)) {
                    x = true;
                }
                if ("4".equals(zeta)) {
                    x = true;
                }
                if ("5".equals(zeta)) {
                    x = true;
                }
                if ("6".equals(zeta)) {
                    x = true;
                }
                if ("7".equals(zeta)) {
                    x = true;
                }
                if (x == true) {  //l'utente ha scelto una carta tra le posizioni
                    a = Integer.parseInt(zeta);

                }
                if (x == false) { //l'utente ha scelto una posizione della carta fuori dal mazzoinmano
                    System.out.println("------------------------------------------------- ");
                    System.out.println("ERRORE: ");
                    System.out.println("Non puoi dare questo numero a " + zeta + "");
                    System.out.println("------------------------------------------------- ");
                    System.out.println("Inserire nuovo valore ");
                    zeta = in.next(); //richiede una nuova posizione della carta da giocare
                }
            } while (x == false); //finchè non viene scelta una carta giusta
        }

        if ("no".equals(scelta)) {
            System.out.println("Ricorda che la matta vale 1/2");
        }

        return a;
    }

    public float valoreinmano(Giocatore a) {
        float somma = 0;
        float x = a.getcartanascosta().getvalorepunteggio();
        float y = a.getmazzocartevisibile().sommavaloripunteggimazzo();
        somma = x + y;
        return somma;
    }

    public float LogicadeiTurni(Giocatore a) {
        boolean verificamatta = false;
        Carta pescata, matta = null;
        System.out.println("Tocca al giocatore " + a.getnomegiocatore() + "");
        System.out.println("La carta coperta e'");
        System.out.println(a.getcartanascosta());
        Scanner in = new Scanner(System.in);
        boolean x = false;
        boolean y = false;
        float valoreinmano = a.getcartanascosta().getvalorepunteggio();
        verificamatta = a.getcartanascosta().controllamatta(); //verifica se la prima carta è il 10 di denari
        if (verificamatta) {
            matta = a.getcartanascosta();
        }


        do {
            System.out.println("Vuoi un'altra carta?   Premere si/no");
            String scelta = in.next();

            if ("si".equals(scelta)) {
                do {
                    x = true;
                    pescata = this.daiCarta(a);
                    a.getmazzocartevisibile().aggiungicarta(pescata);
                    System.out.println("Hai pescato " + pescata + "");



                    valoreinmano = this.valoreinmano(a);
                    if (valoreinmano > 7.5) {
                        System.out.println("Hai perso bastardo, hai fatto il botto, boom con " + valoreinmano + "");
                        valoreinmano = 0;
                        y = true;
                    } else {
                        if (valoreinmano == 7.5) {
                            y=true;
                            System.out.println("certo che non ti basta la fontana di trevi per pulirti il culo");
                            System.out.println("HAI PIU' CULO CHE SALUTE!!!");
                        } else {
                            System.out.println("Hai " + valoreinmano + "");
                            System.out.println("Vuoi un'altra carta?   Premere si/no");
                            Scanner ceck = new Scanner(System.in);
                            String altrascelta = ceck.next();

                            if ("no".equals(altrascelta)) {
                                y = true;
                            }
                        }
                    }
                } while (y != true);

            }

            if ("no".equals(scelta)) {
                x = true;
            }

            if (verificamatta==false) { //se la matta non è la prima carta
                verificamatta = a.getmazzocartevisibile().controllamatta(); //controlla nel mazzodicartevisibile
                if (verificamatta==true) {
                    matta = a.getmazzocartevisibile().matta();
                }
             }
        } while (x != true);

        if (verificamatta==true) {
            float pa = 0;
            pa = this.valorematta();
            matta.setvalorepunteggio(pa);
            valoreinmano = valoreinmano + matta.getvalorepunteggio() - (float) 1 / 2;
        }
        
        return valoreinmano;

    }

    public void Gioco() {

        boolean verificamatta;
        Carta matta;
        float p, q;
       
        Carta a = this.daiCarta(giocatore1);
        Carta b = this.daiCarta(giocatore2);


        giocatore1.setcartanascosta(a);
        giocatore2.setcartanascosta(b);

        this.stop();

 
            p = this.LogicadeiTurni(giocatore1);
 
            q = this.LogicadeiTurni(giocatore2);
       

        this.getgiocatore1().setpunteggio(p);
        this.getgiocatore2().setpunteggio(q);
        System.out.println(giocatore1);
        System.out.println(giocatore2);

        if (p < q) {
            System.out.println("Il giocatore " + giocatore2.getnomegiocatore() + " ha vinto");
        } else {
            if(p==q){
            System.out.println("Il giocatore " + giocatore2.getnomegiocatore() + " ha vinto perchè è il mazziere"); 
            }else
            {
                System.out.println("Il giocatore " + giocatore1.getnomegiocatore() + " ha vinto");
            }
        }


    }
}
