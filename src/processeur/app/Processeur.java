package processeur.app;

import processeur.ctrl.Controller;
import processeur.services.ServiceCPU;
import processeur.views.View;

/**
 * Application "Processeur". 
 * Application qui fait un usage progressivement plus complexe de classes et objets.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class Processeur {

    /**
     * La méthode main() de l'application, là où tout commence.
     *
     * @param args les arguments du programme passés sur la ligne de commande
     */
    public static void main(String[] args) {
        // Création des objets de l'application
        View view = new View();
        Controller ctrl = new Controller(null, view);
        ServiceCPU service = new ServiceCPU(ctrl);

        // Mise en place des références croisées
        ctrl.setRefServiceCPU(service);
        ctrl.setRefView(view);
        view.setRefCtrl(ctrl);

        // Démarrer le contrôleur
        ctrl.start();
    }
}
