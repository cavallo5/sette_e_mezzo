package src;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Vincenzo
 */
public class MazzodiCarte {

    private ArrayList<Carta> mazzo;

    public MazzodiCarte() {
        mazzo = new ArrayList<Carta>(); //mazzo è un ArrayList di carte vuoto
    }

    /**
     * Inizializza MazzodiCarte
     *
     * @param a un MazzodiCarte
     */
    public MazzodiCarte(MazzodiCarte a) {
        mazzo = a.mazzo;
    }

    /**
     * Riempie il mazzo di 40 carte (carte classiche napoletane)
     */
    public void mazzodi40carte() {
        for (Seme s : Seme.values()) {   //ciclo generalizzato
            for (int i = 1; i <= 10; i++) {
                if (i < 8) {
                    mazzo.add(new Carta(i, s, i));
                }
                if (i >= 8) {
                    mazzo.add(new Carta(i, s, (float) 1 / 2));
                }
  
            }
        }
    }

    //metodi set
    /**
     * Modifica il mazzo di carte
     *
     * @param a ArrayList di carte
     */
    private void setmazzo(ArrayList<Carta> a) {   //l'ArrayList di carte a diventa il nuovo mazzo
        mazzo = a;
    }

    //metodi get
    /**
     * Restituisce l'ArrayList di carte mazzo
     *
     * @return l'ArrayList di carte
     */
    public ArrayList<Carta> getmazzo() {
        return mazzo;
    }

    /**
     * Stampa un mazzo di carte
     *
     * @return la stampa del mazzo da giocare con l'indice della posizione
     */
    @Override
    public String toString() {
        String s = "";
        int i = 0;
        for (Carta c : mazzo) {      //ciclo generalizzato
            s = s + c + "\n";
            i++;
        }
        return s;
    }

    /**
     * Mischia il mazzo di carte
     */
    public void mischia() {
        Collections.shuffle(mazzo);
    }

    /**
     * Restituisce il numero delle carte del mazzo di carte
     *
     * @return il numero delle carte rimanenti nel mazzo di carte
     */
    public int carterimanenti() {
        return mazzo.size();
    }

    /**
     * Somma i valori dei punteggi delle carte del mazzo di carte
     *
     * @return il punteggio delle carte del mazzo di carte
     */
    public float sommavaloripunteggimazzo() {
        float a = 0;
        float valorepunteggiocarta = 0;
        float somma = 0;
        int numerocarte = this.getmazzo().size(); //numero delle carte nel mazzo di carte
        for (int i = 0; i < numerocarte; i++) {

            valorepunteggiocarta = this.getmazzo().get(i).getvalorepunteggio();  //punteggio della carta 
            somma = somma + valorepunteggiocarta;

        }
        a = somma; //casting da float in int
        return a; //punteggio finale delle carte del mazzo

    }

    /**
     * Rimuove e restituisce la carta dalla posizione indicata nel mazzo di
     * carte
     *
     * @param x numero che rappresenta la posizione della carta da rimuovere
     * @return la carta rimossa dalla posizione indicata nel mazzo di carte
     */
    public Carta remove(int x) {
        return mazzo.remove(x);
    }

    /**
     * Aggiunge la carta al mazzo
     *
     * @param a carta
     */
    public void aggiungicarta(Carta a) {    //aggiunge la carta a alla fine del mazzo di carte

        mazzo.add(a);  //la carta a viene aggiunta alla fine del mazzo di carte

    }

    public boolean controllamatta() {

        boolean x = false;
        for (int i = 0; i < this.carterimanenti() && x; i++) {
            Carta verifica = this.getmazzo().get(i);
            if (verifica.getseme() == Seme.DENARI && verifica.getnumero() == 10) {
                x = true;
            }
        }
        return x;
    }

    public Carta matta() {
        Carta verifica = null;
        boolean x = false;
        for (int i = 0; i < this.carterimanenti() && x; i++) {
            verifica = this.getmazzo().get(i);
            if (verifica.getseme() == Seme.DENARI && verifica.getnumero() == 10) {
                x = true;
            }
        }
        return verifica;
    }
}
