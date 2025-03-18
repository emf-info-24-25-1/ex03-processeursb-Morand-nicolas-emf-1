package processeur.services;

import processeur.ctrl.Controller;
import processeur.models.CPU;

/**
 * Service de notre application MVC "Processeur" pouvant gérer des CPUs.
 *
 * Cette classe représente le service CPU de notre application MVC "Processeur".
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class ServiceCPU {

    /**
     * Constantes indiquant le nombre maximum de CPUs que peut contenir notre liste.
     */
    public static final int NBRE_CPU = 20;

    /**
     * Attribut contenant le tableau des CPUs.
     */
    private CPU[] tableauCPU;

    /**
     * Attribut contenant la référence au contrôleur de l'application MVC "Processeur".
     */
    private Controller refCtrl;

    /**
     * Constructeur de la classe ServiceCPU. 
     * Initialise le tableau des CPUs et le contrôleur.
     */
    public ServiceCPU(Controller refCtrl) {
        this.tableauCPU = new CPU[NBRE_CPU];
        this.refCtrl = refCtrl;
    }

    /**
     * Cette méthode permet de stocker un nouveau CPU dans notre liste.
     * 
     * @param cpu le nouveau CPU à stocker dans notre liste
     * @return vrai si une place libre a été trouvée et le CPU a été ajouté
     */
    public boolean ajouterUnNouveau(CPU cpu) {
        for (int i = 0; i < NBRE_CPU; i++) {
            if (tableauCPU[i] == null) {
                tableauCPU[i] = cpu;
                return true;
            }
        }
        return false; // Aucun espace disponible
    }

    /**
     * Cette méthode permet d'obtenir la liste actuelle des CPUs sans les valeurs null.
     *
     * @return un tableau contenant uniquement les CPUs non nulls
     */
    public CPU[] obtenirLaListe() {
        int count = nombreDeCPUDansLaListe();
        CPU[] liste = new CPU[count];
        int index = 0;

        for (CPU cpu : tableauCPU) {
            if (cpu != null) {
                liste[index++] = cpu;
            }
        }

        return liste;
    }

    /**
     * Cette méthode permet de connaître le nombre de CPUs contenus dans notre liste.
     *
     * @return le nombre de CPUs contenus dans notre liste
     */
    public int nombreDeCPUDansLaListe() {
        int compteur = 0;
        for (CPU cpu : tableauCPU) {
            if (cpu != null) {
                compteur++;
            }
        }
        return compteur;
    }

    /**
     * Cette méthode permet de connaître la taille de la liste de CPU.
     *
     * @return la taille du tableau de CPU
     */
    public int tailleDeLaListe() {
        return tableauCPU.length;
    }

    /**
     * Cette méthode permet d'obtenir un CPU de notre liste en fonction de son indice.
     * 
     * @param indice l'indice du CPU à obtenir
     * @return le CPU demandé ou null si l'indice est hors limites
     */
    public CPU obtenirUnElement(int indice) {
        if (indice >= 0 && indice < tableauCPU.length) {
            return tableauCPU[indice];
        }
        return null;
    }

    /**
     * Getter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @return la référence au contrôleur
     */
    public Controller getRefCtrl() {
        return refCtrl;
    }

    /**
     * Setter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @param refCtrl référence au contrôleur
     */
    public void setRefCtrl(Controller refCtrl) {
        this.refCtrl = refCtrl;
    }
}
