package ui;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Optimisation.Optimisation;
import Optimisation.SettingValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class IHMController {
	@FXML
	private Button T1;
	@FXML
	private VBox T1_Param;
	private boolean T1_status = false;
	@FXML
	private Button T2;
	@FXML
	private VBox T2_Param;
	private boolean T2_status = false;
	@FXML
	private Button T3;
	@FXML
	private VBox T3_Param;
	private boolean T3_status = false;
	@FXML
	private Button T4;
	@FXML
	private VBox T4_Param;
	private boolean T4_status = false;
	@FXML
	private Button T5;
	@FXML
	private VBox T5_Param;
	private boolean T5_status = false;
	@FXML
	private Button Optimise;
	@FXML
	private TextField Q1_Min;
	@FXML
	private TextField Q1_Max;
	@FXML
	private TextField Q2_Min;
	@FXML
	private TextField Q2_Max;
	@FXML
	private TextField Q3_Min;
	@FXML
	private TextField Q3_Max;
	@FXML
	private TextField Q4_Min;
	@FXML
	private TextField Q4_Max;
	@FXML
	private TextField Q5_Min;
	@FXML
	private TextField Q5_Max;
	@FXML
	private TextField eAmont;
	@FXML
	private TextField Q_tot;
	@FXML
	private Label Q1;
	@FXML
	private Label P1;
	@FXML
	private Label Q2;
	@FXML
	private Label P2;
	@FXML
	private Label Q3;
	@FXML
	private Label P3;
	@FXML
	private Label Q4;
	@FXML
	private Label P4;
	@FXML
	private Label Q5;
	@FXML
	private Label P5;
	@FXML
	private Label P_tot;
	@FXML
	private Button Optimiser;
	private ArrayList<Label> Q_label_list= new ArrayList();
	private ArrayList<Label> P_label_list=new ArrayList();
	private ArrayList<Double> P_list;
	private ArrayList<Integer> Q_list;

	@FXML
	protected void enable_disable(ActionEvent event) {
		Image enable = new Image(getClass().getResourceAsStream("img/turbine_on.png"));
		Image disable = new Image(getClass().getResourceAsStream("img/turbine_off.png"));
		if (event.getSource().equals(T1)) {
			if (!T1_status) {
				ImageView turbine_on = new ImageView(enable);
				turbine_on.setPreserveRatio(true);
				turbine_on.setFitWidth(128);
				T1.setGraphic(turbine_on);
				T1_Param.setDisable(false);
				T1_status = true;
				return;
			} else {
				ImageView turbine_off = new ImageView(disable);
				turbine_off.setPreserveRatio(true);
				turbine_off.setFitWidth(128);
				T1.setGraphic(turbine_off);
				T1_Param.setDisable(true);
				T1_status = false;
				return;
			}

		}
		if (event.getSource().equals(T2)) {
			if (!T2_status) {
				ImageView turbine_on = new ImageView(enable);
				turbine_on.setPreserveRatio(true);
				turbine_on.setFitWidth(128);
				T2.setGraphic(turbine_on);
				T2_Param.setDisable(false);
				T2_status = true;
				return;
			} else {
				ImageView turbine_off = new ImageView(disable);
				turbine_off.setPreserveRatio(true);
				turbine_off.setFitWidth(128);
				T2.setGraphic(turbine_off);
				T2_Param.setDisable(true);
				T2_status = false;
				return;
			}
		}
		if (event.getSource().equals(T3)) {
			if (!T3_status) {
				ImageView turbine_on = new ImageView(enable);
				turbine_on.setPreserveRatio(true);
				turbine_on.setFitWidth(128);
				T3.setGraphic(turbine_on);
				T3_Param.setDisable(false);
				T3_status = true;
				return;
			} else {
				ImageView turbine_off = new ImageView(disable);
				turbine_off.setPreserveRatio(true);
				turbine_off.setFitWidth(128);
				T3.setGraphic(turbine_off);
				T3_Param.setDisable(true);
				T3_status = false;
				return;
			}
		}
		if (event.getSource().equals(T4)) {
			if (!T4_status) {
				ImageView turbine_on = new ImageView(enable);
				turbine_on.setPreserveRatio(true);
				turbine_on.setFitWidth(128);
				T4.setGraphic(turbine_on);
				T4_Param.setDisable(false);
				T4_status = true;
				return;
			} else {
				ImageView turbine_off = new ImageView(disable);
				turbine_off.setPreserveRatio(true);
				turbine_off.setFitWidth(128);
				T4.setGraphic(turbine_off);
				T4_Param.setDisable(true);
				T4_status = false;
				return;
			}
		}
		if (event.getSource().equals(T5)) {
			if (!T5_status) {
				ImageView turbine_on = new ImageView(enable);
				turbine_on.setPreserveRatio(true);
				turbine_on.setFitWidth(128);
				T5.setGraphic(turbine_on);
				T5_Param.setDisable(false);
				T5_status = true;
				return;
			} else {
				ImageView turbine_off = new ImageView(disable);
				turbine_off.setPreserveRatio(true);
				turbine_off.setFitWidth(128);
				T5.setGraphic(turbine_off);
				T5_Param.setDisable(true);
				T5_status = false;
				return;
			}
		}
	}
	
	protected void setOptimisationParams() {
		if(T1_status) {
			SettingValue.setMIN_FLOW_T1(Integer.parseInt(Q1_Min.getText()));
			SettingValue.setMAX_FLOW_T1(Integer.parseInt(Q1_Max.getText()));
		}
		if(!T1_status) {
			SettingValue.setMIN_FLOW_T1(0);
			SettingValue.setMAX_FLOW_T1(0);
		}
		if(T2_status) {
			SettingValue.setMIN_FLOW_T2(Integer.parseInt(Q2_Min.getText()));
			SettingValue.setMAX_FLOW_T2(Integer.parseInt(Q2_Max.getText()));
		}
		if(!T2_status) {
			SettingValue.setMIN_FLOW_T2(0);
			SettingValue.setMAX_FLOW_T2(0);
		}
		if(T3_status) {
			SettingValue.setMIN_FLOW_T3(Integer.parseInt(Q3_Min.getText()));
			SettingValue.setMAX_FLOW_T3(Integer.parseInt(Q3_Max.getText()));
		}
		if(!T3_status) {
			SettingValue.setMIN_FLOW_T3(0);
			SettingValue.setMAX_FLOW_T3(0);
		}
		if(T4_status) {
			SettingValue.setMIN_FLOW_T4(Integer.parseInt(Q4_Min.getText()));
			SettingValue.setMAX_FLOW_T4(Integer.parseInt(Q4_Max.getText()));
		}
		if(!T4_status) {
			SettingValue.setMIN_FLOW_T4(0);
			SettingValue.setMAX_FLOW_T4(0);
		}
		if(T5_status) {
			SettingValue.setMIN_FLOW_T5(Integer.parseInt(Q5_Min.getText()));
			SettingValue.setMAX_FLOW_T5(Integer.parseInt(Q5_Max.getText()));
		}
		if(!T5_status) {
			SettingValue.setMIN_FLOW_T5(0);
			SettingValue.setMAX_FLOW_T5(0);
		}
	}
	protected void showResults() {
		Q_label_list.add(Q1);
		Q_label_list.add(Q2);
		Q_label_list.add(Q3);
		Q_label_list.add(Q4);
		Q_label_list.add(Q5);
		P_label_list.add(P1);
		P_label_list.add(P2);
		P_label_list.add(P3);
		P_label_list.add(P4);
		P_label_list.add(P5);
		Double PuissanceTotale=0.0;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for(int i=0;i<5;i++) {
			String Qi=Q_list.get(i).toString();
			String Pi=formatter.format(P_list.get(i));
			PuissanceTotale+=P_list.get(i);
			Q_label_list.get(i).setText("Q"+(i+1)+" : "+Qi+" m³/s");
			P_label_list.get(i).setText("P"+(i+1)+" : "+Pi+" MW");
		}
		P_tot.setText("Total : "+formatter.format(PuissanceTotale)+" MW");
	}
	@FXML
	protected void optimise(ActionEvent event) {
		setOptimisationParams();
		Double eAm=Double.valueOf(eAmont.getText());
		Double Qt=Double.valueOf(Q_tot.getText());
		Optimisation opt=new Optimisation();
		opt.optimise(eAm, Qt);
		P_list=opt.getResultP();
		Q_list=opt.getResultQ();
		showResults();
	}
	
	
}
