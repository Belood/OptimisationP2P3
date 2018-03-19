package Optimisation;

/**
 * Created by Etudes on 18/03/2018.
 */
public class CalculatedData {

    int nbLine = SettingValue.MAX_FLOW/SettingValue.DISCRETISATION;

    double power[][] = new double[SettingValue.NB_TURBINE][nbLine];


    public void updatePower(double eAmont){



        //Turbine 1
        double Q1 = SettingValue.MIN_FLOW_T1;
        double hChute1 = 0;
        for(int iQrange = 0; iQrange < nbLine ; iQrange++){

            hChute1 = eAmont
                    -( -7.431*Math.pow(10,-7)*Math.pow(Q1,2)
                    + 4.185*Math.pow(10,-3)*Q1
                    + 137.1);

            power[0][iQrange]=
                    -1.255
                    +3.617*Math.pow(10,-2)*Q1
                    +7.946*Math.pow(10,-2)*hChute1
                    -4.216*Math.pow(10,-4)*Math.pow(Q1,2)
                    +9.083*Math.pow(10,-3)*hChute1*Q1
                    -1.256*Math.pow(10,-3)*Math.pow(hChute1,2);

            Q1 += SettingValue.DISCRETISATION;

        }

        //Turbine 2
        double Q2 = SettingValue.MIN_FLOW_T2;
        double hChute2 = 0;
        for(int iQrange = 0; iQrange < nbLine ; iQrange++){

            hChute2 = eAmont
                    -( -7.431*Math.pow(10,-7)*Math.pow(Q2,2)
                    + 4.185*Math.pow(10,-3)*Q2
                    + 137.1);

            power[1][iQrange]=
                    +6.512
                            +1.29*Math.pow(10,-2)*Q2
                            -3.332*Math.pow(10,-4)*Math.pow(Q2,2)
                            -3.924*Math.pow(10,-1)*hChute2
                            +5.932*Math.pow(10,-3)*Math.pow(hChute2,2)
                            +9.55*Math.pow(10,-3)*hChute2*Q2;

            Q2 += SettingValue.DISCRETISATION;

        }

        //Turbine 3
        /*
       Linear model Poly31:
     f(x,y) = p00 + p10*x + p01*y + p20*x^2 + p11*x*y + p30*x^3 + p21*x^2*y
Coefficients (with 95% confidence bounds):
       p00 =    -0.04865  (-0.1983, 0.101)
       p10 =     -0.2177  (-0.2252, -0.2103)
       p01 =     0.00169  (-0.00292, 0.006301)
       p20 =    0.003547  (0.003487, 0.003607)
       p11 =    0.006489  (0.006274, 0.006704)
       p30 =  -1.569e-05  (-1.582e-05, -1.556e-05)
       p21 =   2.124e-05  (1.98e-05, 2.268e-05) ////CORRECTION

Goodness of fit:
  SSE: 2947
  R-square: 0.9996
  Adjusted R-square: 0.9996
  RMSE: 0.2685
         */
       
        double Q3 = SettingValue.MIN_FLOW_T3;
        double hChute3 = 0;
        for(int iQrange = 0; iQrange < nbLine ; iQrange++){

            hChute3 = eAmont
                    -( -7.431*Math.pow(10,-7)*Math.pow(Q3,2)
                    + 4.185*Math.pow(10,-3)*Q3
                    + 137.1);

            power[2][iQrange]=
                    -4.865*Math.pow(10,-2)
                            -2.177*Math.pow(10,-1)*Q3
                            +1.69*Math.pow(10,-3)*hChute3
                            +3.543*Math.pow(10,-3)*Math.pow(Q3,2)
                            +6.489*Math.pow(10,-3)*hChute3*Q3
                            -1.569*Math.pow(10,-5)*Math.pow(Q3,3)
                            +2.214*Math.pow(10,-5)*Math.pow(Q3,2)*hChute3;////CORRECTION


            /*power[2][iQrange]=
                    -4.805*Math.pow(10,-2)
                            -2.177*Math.pow(10,-1)*Q3
                            +1.672*Math.pow(10,-3)*hChute3
                            +3.543*Math.pow(10,-3)*Math.pow(Q3,2)
                            +6.494*Math.pow(10,-3)*hChute3*Q3
                            -1.562*Math.pow(10,-5)*Math.pow(Q3,3)
                            -1.562*Math.pow(10,-5)*Math.pow(Q3,2)*hChute3;*/

            Q3 += SettingValue.DISCRETISATION;

        }

        //Turbine 4

        double Q4 = SettingValue.MIN_FLOW_T4;
        double hChute4 = 0;
        for(int iQrange = 0; iQrange < nbLine ; iQrange++){

            hChute4 = eAmont
                    -( -7.431*Math.pow(10,-7)*Math.pow(Q4,2)
                    + 4.185*Math.pow(10,-3)*Q4
                    + 137.1);

            power[3][iQrange]=
                    +9.054
                            +1.647*Math.pow(10,-2)*Q4
                            -6.098*Math.pow(10,-1)*hChute4
                            -3.383*Math.pow(10,-4)*Math.pow(Q4,2)
                            +9.936*Math.pow(10,-3)*hChute4*Q4
                            +1.016*Math.pow(10,-2)*Math.pow(hChute4,2);

            Q4 += SettingValue.DISCRETISATION;

        }

        //Turbine 5
        /*
        Linear model Poly22:
     f(x,y) = p00 + p10*x + p01*y + p20*x^2 + p11*x*y + p02*y^2
Coefficients (with 95% confidence bounds):
       p00 =       11.61  (9.62, 13.6)
       p10 =   -0.005742  (-0.00813, -0.003354)
       p01 =     -0.7456  (-0.8764, -0.6148)
       p20 =  -0.0004281  (-0.0004314, -0.0004248)
       p11 =     0.01077  (0.0107, 0.01084)////CORRECTION
       p02 =     0.01193  (0.009781, 0.01407)

Goodness of fit:
  SSE: 1.621e+04
  R-square: 0.9982
  Adjusted R-square: 0.9982
  RMSE: 0.6297
         */

        double Q5 = SettingValue.MIN_FLOW_T5;
        double hChute5 = 0;
        for(int iQrange = 0; iQrange < nbLine ; iQrange++){

            hChute5 = eAmont
                    -( -7.431*Math.pow(10,-7)*Math.pow(Q5,2)
                    + 4.185*Math.pow(10,-3)*Q5
                    + 137.1);

            power[4][iQrange]=
                    11.61
                            -5.742*Math.pow(10,-3)*Q5
                            -7.456*Math.pow(10,-1)*hChute5
                            -4.281*Math.pow(10,-4)*Math.pow(Q5,2)
                            +1.077*Math.pow(10,-2)*hChute5*Q5
                            +1.193*Math.pow(10,-2)*Math.pow(hChute5,2);

            /*power[4][iQrange]=
                    11.52
                            -7.534*Math.pow(10,-3)*Q5
                            -7.392*Math.pow(10,-1)*hChute5
                            -4.127*Math.pow(10,-4)*Math.pow(Q5,2)
                            -4.127*Math.pow(10,-4)*hChute5*Q5////CORRECTION
                            +1.181*Math.pow(10,-2)*Math.pow(hChute5,2);
                            */

            Q5 += SettingValue.DISCRETISATION;

        }

    }



    public void print(){

        for(int i=0;i<SettingValue.NB_TURBINE;i++) {
            System.out.println("Turbine "+(i+1)+":");
            for(int j=0;j<nbLine;j++) {
                System.out.println(power[i][j]);

            }
        }
    }




}
