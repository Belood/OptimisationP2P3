package Main;

import Optimisation.CalculatedData;

/**
 * Created by Etudes on 18/03/2018.
 */
public class Main {

    public static void main(String[] args) {

        CalculatedData calculatedData = new CalculatedData();
        calculatedData.updatePower(172.1); //ligne 1 du fichier excel de data
        calculatedData.print();
    }
}
