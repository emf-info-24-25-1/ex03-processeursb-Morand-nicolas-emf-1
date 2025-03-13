package processeur.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Application "CPU".
 *
 * Cette classe représente un CPU d'un ordinateur.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class CPU {

    /**
     * Cette constante (-1.0) représente une performance MIPS (Millions Instructions
     * Per Second) inconnue.
     */
    public static final double UNKNOWN_MIPS = -1.0;

    /**
     * Attribut qui représente le nom du CPU.
     */
    private String nom;

    /**
     * Attribut qui représente l'année de sortie du CPU.
     */
    private int annee;

    /**
     * Attribut qui représente le nombre de transistors utilisés dans le CPU.
     */
    private long transistors;

    /**
     * Attribut qui représente la performance en MIPS (Millions Instructions Per
     * Second) du CPU.
     */
    private double mips;

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on connaît la valeur de
     * chaque attribut.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     * @param mips        la performance en MIPS (Millions Instructions Per Second)
     *                    du CPU
     */
    public CPU(String nom, int annee, long transistors, double mips) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = mips;
    }

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on ne connaît pas la
     * performance du CPU. Dans ce cas, l'attribut
     * "mips" sera initialisé avec la valeur UNKNOWN_MIPS pour indiquer que cette
     * information n'est pas connue.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     */
    public CPU(String nom, int annee, long transistors) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
    }

    /**
     * Getter de l'attribut nom.
     *
     * @return la valeur de l'attribut nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut annee.
     *
     * @return la valeur de l'attribut annee
     */

    public int getAnnee() {
        return annee;
    }

    /**
     * Getter de l'attribut transistors.
     *
     * @return la valeur de l'attribut transistors
     */
    public long getTransistors() {
        return transistors;
    }

    /**
     * Getter de l'attribut mips.
     *
     * @return la valeur de l'attribut mips
     */
    public double getMips() {
        return mips;
    }

    @Override
    public String toString() {
        String retour = "";
        DecimalFormat formatage = new DecimalFormat("#,###");
        DecimalFormat formatageMips = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormatSymbols point = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('\'');
        point.setDecimalSeparator('.');
        point.setGroupingSeparator('\'');
        formatage.setDecimalFormatSymbols(symbols);
        formatageMips.setDecimalFormatSymbols(point);
        if (getMips() == UNKNOWN_MIPS) {
            retour = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors)
                    + " transitors et une puissance de calcul incronnue.";
        } else {
            retour = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors)
                    + " transitors et une puissance de calcul de " + formatageMips.format(mips) + " mips.";
        }
        return retour;

    }
}
