package Optimisation;
import Optimisation.CalculatedData;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Etudes on 18/03/2018.
 */
public class Optimisation {

    private CalculatedData calculatedData = new CalculatedData();

    int nbLine = SettingValue.MAX_FLOW/SettingValue.DISCRETISATION;

    public void optimise(double eAmont){

        calculatedData.updatePower(eAmont);
        calculatedData.print();
        int optimum[] = new int[5];

        //stage 5
        double stage5[][] = new double[nbLine][3];
        double Q5 = SettingValue.MIN_FLOW;
        double maxValue = 0;
        int maxValueIndex = 0;
        for(int i = 0; i < nbLine ; i++){
            stage5[i][0]=Q5; //S5
            stage5[i][1]=calculatedData.power[4][i]; //f5*(s5)

            if(stage5[i][1]>maxValue){
                maxValue = stage5[i][1];
                maxValueIndex = i;
            }
            stage5[i][2]=maxValueIndex; //x5*

            Q5 += SettingValue.DISCRETISATION;
        }



        //stage 4
        double stage4[][] = new double[nbLine][nbLine+3];
        double Q4 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < nbLine ; i++){

            stage4[i][0]= Q4; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < nbLine+1 ; j++){

                if (j<i+2){
                    stage4[i][j]= (calculatedData.power[3][j-1] + stage5[i-j+1][1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)
                    if(stage4[i][j] > maxValue){
                        maxValue = stage4[i][j];
                        maxValueIndex = j-1;
                    }
                   //stage4[i][j]= -888;
                }else{
                    stage4[i][j]= -1;
                }
            }
            stage4[i][nbLine+1]= maxValue; //f*4(s4)
            stage4[i][nbLine+2]= maxValueIndex; //s4*

            Q4 += SettingValue.DISCRETISATION;
        }




        //stage 3 turbine 3
        double stage3[][] = new double[nbLine][nbLine+3];
        double Q3 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < nbLine ; i++){

            stage3[i][0]= Q3; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < nbLine+1 ; j++){

                if (j<i+2){
                    stage3[i][j]= (calculatedData.power[2][j-1] + stage4[i-j+1][nbLine+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)
                    if(stage3[i][j] > maxValue){
                        maxValue = stage3[i][j];
                        maxValueIndex = j-1;
                    }
                    //stage3[i][j]= -888;
                }else{
                    stage3[i][j]= -1;
                }
            }
            stage3[i][nbLine+1]= maxValue; //f*4(s4)
            stage3[i][nbLine+2]= maxValueIndex; //s4*

            Q3 += SettingValue.DISCRETISATION;
        }




        //stage 2 turbine 2
        double stage2[][] = new double[nbLine][nbLine+3];
        double Q2 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < nbLine ; i++){

            stage2[i][0]= Q2; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < nbLine+1 ; j++){

                if (j<i+2){
                    stage2[i][j]= (calculatedData.power[1][j-1] + stage3[i-j+1][nbLine+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)
                    if(stage2[i][j] > maxValue){
                        maxValue = stage2[i][j];
                        maxValueIndex = j-1;
                    }
                    //stage2[i][j]= -888;
                }else{
                    stage2[i][j]= -1;
                }
            }
            stage2[i][nbLine+1]= maxValue; //f*4(s4)
            stage2[i][nbLine+2]= maxValueIndex; //s4*

            Q2 += SettingValue.DISCRETISATION;
        }



        //stage 1 turbine 1
        double stage1[][] = new double[1][nbLine+3];
        double Q1 = SettingValue.MAX_FLOW;
        maxValue = 0;
        maxValueIndex = 0;
        for (int j = 1 ; j < nbLine+1 ; j++){

            stage1[0][j]= (calculatedData.power[0][j-1] + stage3[nbLine-j][nbLine+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)

            if(stage1[0][j] > maxValue){
                maxValue = stage1[0][j];
                maxValueIndex = j-1;
            }
        }
        stage1[0][nbLine+1]= maxValue;
        stage1[0][nbLine+2]= maxValueIndex;



        //backWard
        int sn = nbLine;
        optimum[0] = (int) stage1[0][nbLine+2];
        sn -= optimum[0];
        optimum[1] = (int) stage2[sn-1][nbLine+2];
        sn -= optimum[1];
        optimum[2] = (int) stage3[sn-1][nbLine+2];
        sn -= optimum[2];
        optimum[3] = (int) stage4[sn-1][nbLine+2];
        sn -= optimum[3];
        optimum[4] = (int) stage5[sn-1][2];





        System.out.println("nbLine : "+nbLine);

        NumberFormat nf = new DecimalFormat("0.0");
        System.out.println("stage 5 : ");
        for(int i=0;i<nbLine;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<3;j++) {
                System.out.print(nf.format(stage5[i][j])+" | ");
            }
            System.out.println("");

        }

        System.out.println("stage 4 : ");
        for(int i=0;i<nbLine;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<nbLine+3;j++) {
                System.out.print(nf.format(stage4[i][j])+" | ");
            }
            System.out.println("");

        }

        System.out.println("stage 3 : ");
        for(int i=0;i<nbLine;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<nbLine+3;j++) {
                System.out.print(nf.format(stage3[i][j])+" | ");
            }
            System.out.println("");
        }


        System.out.println("stage 2 : ");
        for(int i=0;i<nbLine;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<nbLine+3;j++) {
                System.out.print(nf.format(stage2[i][j])+" | ");
            }
            System.out.println(" ");

        }


        System.out.println("stage 1 : ");

            for(int j=0;j<nbLine+3;j++) {
                System.out.print(nf.format(stage1[0][j])+" | ");
            }


        System.out.println("");

        System.out.println("Optimum : ");

        for(int i=0;i<5;i++) {
            System.out.print("turbine "+(i+1)+": ");
            System.out.println(optimum[i]+" x "+ SettingValue.DISCRETISATION +" m3/s");
        }



    }


}
