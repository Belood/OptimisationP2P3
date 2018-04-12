package Optimisation;

/**
 * Created by Etudes on 18/03/2018.
 */
public final class SettingValue {



	public static int MIN_FLOW=0;
	public static int MAX_FLOW;

	public static int MIN_FLOW_T1;
	public static int MAX_FLOW_T1;

	public static int MIN_FLOW_T2;
	public static int MAX_FLOW_T2;

	public static int MIN_FLOW_T3;
	public static int MAX_FLOW_T3;

	public static int MIN_FLOW_T4;
	public static int MAX_FLOW_T4;

	public static int MIN_FLOW_T5;
	public static int MAX_FLOW_T5;

	public static int DISCRETISATION = 5;

	public static int NB_TURBINE = 5;

	public static int NB_LINE;
	public static int getMIN_FLOW() {
		return MIN_FLOW;
	}

	public static void setMIN_FLOW(int mIN_FLOW) {
		MIN_FLOW = mIN_FLOW;
	}
	public static int getMAX_FLOW() {
		return MAX_FLOW;
	}

	public static void setMAX_FLOW(int mAX_FLOW) {
		MAX_FLOW = mAX_FLOW;
		NB_LINE =MAX_FLOW / DISCRETISATION;
	}

	public static int getMIN_FLOW_T1() {
		return MIN_FLOW_T1;
	}

	public static void setMIN_FLOW_T1(int mIN_FLOW_T1) {
		MIN_FLOW_T1 = mIN_FLOW_T1;
	}

	public static int getMAX_FLOW_T1() {
		return MAX_FLOW_T1;
	}

	public static void setMAX_FLOW_T1(int mAX_FLOW_T1) {
		MAX_FLOW_T1 = mAX_FLOW_T1;
	}

	public static int getMIN_FLOW_T2() {
		return MIN_FLOW_T2;
	}

	public static void setMIN_FLOW_T2(int mIN_FLOW_T2) {
		MIN_FLOW_T2 = mIN_FLOW_T2;
	}

	public static int getMAX_FLOW_T2() {
		return MAX_FLOW_T2;
	}

	public static void setMAX_FLOW_T2(int mAX_FLOW_T2) {
		MAX_FLOW_T2 = mAX_FLOW_T2;
	}

	public static int getMIN_FLOW_T3() {
		return MIN_FLOW_T3;
	}

	public static void setMIN_FLOW_T3(int mIN_FLOW_T3) {
		MIN_FLOW_T3 = mIN_FLOW_T3;
	}

	public static int getMAX_FLOW_T3() {
		return MAX_FLOW_T3;
	}

	public static void setMAX_FLOW_T3(int mAX_FLOW_T3) {
		MAX_FLOW_T3 = mAX_FLOW_T3;
	}

	public static int getMIN_FLOW_T4() {
		return MIN_FLOW_T4;
	}

	public static void setMIN_FLOW_T4(int mIN_FLOW_T4) {
		MIN_FLOW_T4 = mIN_FLOW_T4;
	}

	public static int getMAX_FLOW_T4() {
		return MAX_FLOW_T4;
	}

	public static void setMAX_FLOW_T4(int mAX_FLOW_T4) {
		MAX_FLOW_T4 = mAX_FLOW_T4;
	}

	public static int getMIN_FLOW_T5() {
		return MIN_FLOW_T5;
	}

	public static void setMIN_FLOW_T5(int mIN_FLOW_T5) {
		MIN_FLOW_T5 = mIN_FLOW_T5;
	}

	public static int getMAX_FLOW_T5() {
		return MAX_FLOW_T5;
	}

	public static void setMAX_FLOW_T5(int mAX_FLOW_T5) {
		MAX_FLOW_T5 = mAX_FLOW_T5;
	}

	public static int getDISCRETISATION() {
		return DISCRETISATION;
	}

	public static void setDISCRETISATION(int dISCRETISATION) {
		DISCRETISATION = dISCRETISATION;
	}

	public static int getNB_TURBINE() {
		return NB_TURBINE;
	}

	public static void setNB_TURBINE(int nB_TURBINE) {
		NB_TURBINE = nB_TURBINE;
	}

	public static int getNB_LINE() {
		return NB_LINE;
	}

	public static void setNB_LINE(int nB_LINE) {
		NB_LINE = nB_LINE;
	}


}
