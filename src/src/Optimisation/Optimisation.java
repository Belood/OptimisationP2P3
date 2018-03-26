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

  //  int NB_LINE = SettingValue.NB_LINE;

    public void optimise(double eAmont,double max_flow){
    	SettingValue.MAX_FLOW=(int)Math.round(max_flow);
        int NB_LINE = SettingValue.NB_LINE;
        calculatedData.updatePower(eAmont);
        //calculatedData.print();
        int optimum[] = new int[5];

        //stage 5
        double stage5[][] = new double[NB_LINE][3];
        double Q5 = SettingValue.MIN_FLOW;
        double maxValue = 0;
        int maxValueIndex = 0;
        for(int i = 0; i < NB_LINE ; i++){
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
        double stage4[][] = new double[NB_LINE][NB_LINE+3];
        double Q4 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < NB_LINE ; i++){

            stage4[i][0]= Q4; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < NB_LINE+1 ; j++){

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
            stage4[i][NB_LINE+1]= maxValue; //f*4(s4)
            stage4[i][NB_LINE+2]= maxValueIndex; //s4*

            Q4 += SettingValue.DISCRETISATION;
        }




        //stage 3 turbine 3
        double stage3[][] = new double[NB_LINE][NB_LINE+3];
        double Q3 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < NB_LINE ; i++){

            stage3[i][0]= Q3; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < NB_LINE+1 ; j++){

                if (j<i+2){
                    stage3[i][j]= (calculatedData.power[2][j-1] + stage4[i-j+1][NB_LINE+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)
                    if(stage3[i][j] > maxValue){
                        maxValue = stage3[i][j];
                        maxValueIndex = j-1;
                    }
                    //stage3[i][j]= -888;
                }else{
                    stage3[i][j]= -1;
                }
            }
            stage3[i][NB_LINE+1]= maxValue; //f*4(s4)
            stage3[i][NB_LINE+2]= maxValueIndex; //s4*

            Q3 += SettingValue.DISCRETISATION;
        }




        //stage 2 turbine 2
        double stage2[][] = new double[NB_LINE][NB_LINE+3];
        double Q2 = SettingValue.MIN_FLOW;
        //remplissage ligne par ligne
        for (int i = 0 ; i < NB_LINE ; i++){

            stage2[i][0]= Q2; // j=0

            maxValue = 0;
            maxValueIndex = 0;

            for (int j = 1 ; j < NB_LINE+1 ; j++){

                if (j<i+2){
                    stage2[i][j]= (calculatedData.power[1][j-1] + stage3[i-j+1][NB_LINE+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)
                    if(stage2[i][j] > maxValue){
                        maxValue = stage2[i][j];
                        maxValueIndex = j-1;
                    }
                    //stage2[i][j]= -888;
                }else{
                    stage2[i][j]= -1;
                }
            }
            stage2[i][NB_LINE+1]= maxValue; //f*4(s4)
            stage2[i][NB_LINE+2]= maxValueIndex; //s4*

            Q2 += SettingValue.DISCRETISATION;
        }



        //stage 1 turbine 1
        double stage1[][] = new double[1][NB_LINE+3];
        double Q1 = SettingValue.MAX_FLOW;
        maxValue = 0;
        maxValueIndex = 0;
        for (int j = 1 ; j < NB_LINE+1 ; j++){

            stage1[0][j]= (calculatedData.power[0][j-1] + stage3[NB_LINE-j][NB_LINE+1]); //f4(i,j-1) = p4(j-1) + f5*(i-j+1)

            if(stage1[0][j] > maxValue){
                maxValue = stage1[0][j];
                maxValueIndex = j-1;
            }
        }
        stage1[0][NB_LINE+1]= maxValue;
        stage1[0][NB_LINE+2]= maxValueIndex;



        //backWard
        int sn = NB_LINE+1;
        int tempOpti;
        int powerValue;

        int Index_Min_T1 = SettingValue.MIN_FLOW_T1/SettingValue.DISCRETISATION;
        int Index_Max_T1 = SettingValue.MAX_FLOW_T1/SettingValue.DISCRETISATION;
        tempOpti = (int) stage1[0][NB_LINE+2];
        powerValue=(int) stage1[0][NB_LINE+1];
        if((tempOpti >= Index_Min_T1)&&(tempOpti <= Index_Max_T1))
            optimum[0] = tempOpti;
        else {
            if(tempOpti  < Index_Min_T1){
                optimum[0] = Index_Min_T1;
            }else if(tempOpti  > Index_Max_T1){
                optimum[0] = Index_Max_T1;
            }else
                optimum[0] = -1;
        }
        if(optimum[0] != -1)
            sn -= optimum[0];


        int Index_Min_T2 = SettingValue.MIN_FLOW_T2/SettingValue.DISCRETISATION;
        int Index_Max_T2 = SettingValue.MAX_FLOW_T2/SettingValue.DISCRETISATION;
        tempOpti = (int) stage2[sn-1][NB_LINE+2];
        if((tempOpti >= Index_Min_T2)&&(tempOpti <= Index_Max_T2))
            optimum[1] = tempOpti;
        else {
            if(tempOpti  < Index_Min_T2){
                optimum[1] = Index_Min_T2;
            }else if(tempOpti  > Index_Max_T2){
                optimum[1] = Index_Max_T2;
            }else
                optimum[1] = -1;
        }
        if(optimum[1] != -1)
            sn -= optimum[1];


        int Index_Min_T3 = SettingValue.MIN_FLOW_T3/SettingValue.DISCRETISATION;
        int Index_Max_T3 = SettingValue.MAX_FLOW_T3/SettingValue.DISCRETISATION;
        tempOpti = (int) stage3[sn-1][NB_LINE+2];
        if((tempOpti >= Index_Min_T3)&&(tempOpti <= Index_Max_T3))
            optimum[2] = tempOpti;
        else {
            if(tempOpti  < Index_Min_T3){
                optimum[2] = Index_Min_T3;
            }else if(tempOpti  > Index_Max_T3){
                optimum[2] = Index_Max_T3;
            }else
                optimum[2] = -1;
        }
        if(optimum[2] != -1)
            sn -= optimum[2];


        int Index_Min_T4 = SettingValue.MIN_FLOW_T4/SettingValue.DISCRETISATION;
        int Index_Max_T4 = SettingValue.MAX_FLOW_T4/SettingValue.DISCRETISATION;
        tempOpti = (int) stage4[sn-1][NB_LINE+2];
        if((tempOpti >= Index_Min_T4)&&(tempOpti <= Index_Max_T4))
            optimum[3] = tempOpti;
        else {
            if(tempOpti  < Index_Min_T4){
                optimum[3] = Index_Min_T4;
            }else if(tempOpti  > Index_Max_T4){
                optimum[3] = Index_Max_T4;
            }else
                optimum[3] = -1;
        }
        if(optimum[3] != -1)
            sn -= optimum[3];


        int Index_Min_T5 = SettingValue.MIN_FLOW_T5/SettingValue.DISCRETISATION;
        int Index_Max_T5 = SettingValue.MAX_FLOW_T5/SettingValue.DISCRETISATION;
        tempOpti = (int) stage5[sn-1][2];
        if((tempOpti >= Index_Min_T5)&&(tempOpti <= Index_Max_T5))
            optimum[4] = tempOpti;
        else {
            if(tempOpti  < Index_Min_T5){
                optimum[4] = Index_Min_T5;
            }else if(tempOpti  > Index_Max_T5){
                optimum[4] = Index_Max_T5;
            }else
                optimum[4] = -1;
        }
        if(optimum[4] != -1)
            sn -= optimum[4];




     /*   System.out.println("nbLine : "+NB_LINE);

        NumberFormat nf = new DecimalFormat("0.0");
        System.out.println("stage 5 : ");
        for(int i=0;i<NB_LINE;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<3;j++) {
                System.out.print(nf.format(stage5[i][j])+" | ");
            }
            System.out.println("");

        }

        System.out.println("stage 4 : ");
        for(int i=0;i<NB_LINE;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<NB_LINE+3;j++) {
                System.out.print(nf.format(stage4[i][j])+" | ");
            }
            System.out.println("");

        }

        System.out.println("stage 3 : ");
        for(int i=0;i<NB_LINE;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<NB_LINE+3;j++) {
                System.out.print(nf.format(stage3[i][j])+" | ");
            }
            System.out.println("");
        }


        System.out.println("stage 2 : ");
        for(int i=0;i<NB_LINE;i++) {
            System.out.print("line " + i +": ");
            for(int j=0;j<NB_LINE+3;j++) {
                System.out.print(nf.format(stage2[i][j])+" | ");
            }
            System.out.println(" ");

        }


        System.out.println("stage 1 : ");

            for(int j=0;j<NB_LINE+3;j++) {
                System.out.print(nf.format(stage1[0][j])+" | ");
            }


        System.out.println("");*/
        DecimalFormat formatter = new DecimalFormat("#0.000");
        System.out.println("Valeurs en entrée : eAmont="+formatter.format(eAmont)+"; Débit à répartir= "+SettingValue.MAX_FLOW);
        System.out.println("Optimum : ");
        for(int i=0;i<5;i++) {
        	int Qi=optimum[i]*SettingValue.DISCRETISATION;
            System.out.print("turbine "+(i+1)+": ");
            System.out.print( Qi+" m3/s => ");
            System.out.println(formatter.format(calculatedData.getPower(Qi, i+1, eAmont))+" MW");
        }



    }


}
