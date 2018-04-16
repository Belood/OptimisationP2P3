package ui;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Optimisation.Optimisation;
import Optimisation.SettingValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private ArrayList<Label> Q_label_list = new ArrayList();
	private ArrayList<Label> P_label_list = new ArrayList();
	private ArrayList<Double> P_list;
	private ArrayList<Integer> Q_list;
	private double eAm;
	private double Qt;

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

	protected boolean checkOptimisationParams() {
		boolean validate1=true, validate2=true, validate3 = true, validate4 = true, validate5 = true,validate6=true;
		String regex = "\\d+";
		if (T1_status) {
			if (Q1_Min.getText().matches(regex) && Q1_Max.getText().matches(regex)) {
				if (Integer.parseInt(Q1_Min.getText()) > Integer.parseInt(Q1_Max.getText())
						|| Integer.parseInt(Q1_Min.getText()) < 0) {
					Q1_Min.setStyle("-fx-background-color:red;");
					Q1_Max.setStyle("-fx-background-color:red;");
					validate1 = false;
				} else {
					Q1_Min.setStyle("-fx-background-color:white;");
					Q1_Max.setStyle("-fx-background-color:white;");
					validate1 = true;

				}
			} else {
				Q1_Min.setStyle("-fx-background-color:red;");
				Q1_Max.setStyle("-fx-background-color:red;");
				validate1 = false;
			}

		}
		if (T2_status) {
			if (Q2_Min.getText().matches(regex) && Q2_Max.getText().matches(regex)) {
				if (Integer.parseInt(Q2_Min.getText()) > Integer.parseInt(Q2_Max.getText())
						|| Integer.parseInt(Q2_Min.getText()) < 0) {
					Q2_Min.setStyle("-fx-background-color:red;");
					Q2_Max.setStyle("-fx-background-color:red;");
					validate2 = false;
				} else {
					Q2_Min.setStyle("-fx-background-color:white;");
					Q2_Max.setStyle("-fx-background-color:white;");
					validate2 = true;

				}
			} else {
				Q2_Min.setStyle("-fx-background-color:red;");
				Q2_Max.setStyle("-fx-background-color:red;");
				validate2 = false;
			}

		}
		if (T3_status) {
			if (Q3_Min.getText().matches(regex) && Q3_Max.getText().matches(regex)) {
				if (Integer.parseInt(Q3_Min.getText()) > Integer.parseInt(Q3_Max.getText())
						|| Integer.parseInt(Q3_Min.getText()) < 0) {
					Q3_Min.setStyle("-fx-background-color:red;");
					Q3_Max.setStyle("-fx-background-color:red;");
					validate3 = false;
				} else {
					Q3_Min.setStyle("-fx-background-color:white;");
					Q3_Max.setStyle("-fx-background-color:white;");
					validate3 = true;
				}
			} else {
				Q3_Min.setStyle("-fx-background-color:red;");
				Q3_Max.setStyle("-fx-background-color:red;");
				validate3 = false;
			}

		}
		if (T4_status) {
			if (Q4_Min.getText().matches(regex) && Q4_Max.getText().matches(regex)) {
				if (Integer.parseInt(Q4_Min.getText()) > Integer.parseInt(Q4_Max.getText())
						|| Integer.parseInt(Q4_Min.getText()) < 0) {
					Q4_Min.setStyle("-fx-background-color:red;");
					Q4_Max.setStyle("-fx-background-color:red;");
					validate4 = false;
				} else {
					Q4_Min.setStyle("-fx-background-color:white;");
					Q4_Max.setStyle("-fx-background-color:white;");
					validate4 = true;

				}
			} else {
				Q4_Min.setStyle("-fx-background-color:red;");
				Q4_Max.setStyle("-fx-background-color:red;");
				validate4 = false;
			}

		}
		if (T5_status) {
			if (Q5_Min.getText().matches(regex) && Q5_Max.getText().matches(regex)) {
				if (Integer.parseInt(Q5_Min.getText()) > Integer.parseInt(Q5_Max.getText())
						|| Integer.parseInt(Q5_Min.getText()) < 0) {
					Q5_Min.setStyle("-fx-background-color:red;");
					Q5_Max.setStyle("-fx-background-color:red;");
					validate5 = false;
				} else {
					Q5_Min.setStyle("-fx-background-color:white;");
					Q5_Max.setStyle("-fx-background-color:white;");
					validate5 = true;

				}
			} else {
				Q5_Min.setStyle("-fx-background-color:red;");
				Q5_Max.setStyle("-fx-background-color:red;");
				validate5 = false;
			}

		}
		try {
			Double.parseDouble(eAmont.getText());
			Double.parseDouble(Q_tot.getText());
			eAmont.setStyle("-fx-background-color:white;");
			Q_tot.setStyle("-fx-background-color:white;");
			validate6=true;
		}
		catch(NumberFormatException nfe) {
			eAmont.setStyle("-fx-background-color:red;");
			Q_tot.setStyle("-fx-background-color:red;");
			validate6=false;
		}

		boolean checkStatus = validate1 && validate2 && validate3 && validate4 && validate5&&validate6;
		return checkStatus;
	}

	protected void setOptimisationParams() {
		if (T1_status) {

			SettingValue.setMIN_FLOW_T1(Integer.parseInt(Q1_Min.getText()));
			SettingValue.setMAX_FLOW_T1(Integer.parseInt(Q1_Max.getText()));

		}
		if (!T1_status) {
			SettingValue.setMIN_FLOW_T1(0);
			SettingValue.setMAX_FLOW_T1(0);
		}
		if (T2_status) {
			SettingValue.setMIN_FLOW_T2(Integer.parseInt(Q2_Min.getText()));
			SettingValue.setMAX_FLOW_T2(Integer.parseInt(Q2_Max.getText()));
		}
		if (!T2_status) {
			SettingValue.setMIN_FLOW_T2(0);
			SettingValue.setMAX_FLOW_T2(0);
		}
		if (T3_status) {

			SettingValue.setMIN_FLOW_T3(Integer.parseInt(Q3_Min.getText()));
			SettingValue.setMAX_FLOW_T3(Integer.parseInt(Q3_Max.getText()));
		}
		if (!T3_status) {
			SettingValue.setMIN_FLOW_T3(0);
			SettingValue.setMAX_FLOW_T3(0);
		}
		if (T4_status) {

			SettingValue.setMIN_FLOW_T4(Integer.parseInt(Q4_Min.getText()));
			SettingValue.setMAX_FLOW_T4(Integer.parseInt(Q4_Max.getText()));
		}
		if (!T4_status) {
			SettingValue.setMIN_FLOW_T4(0);
			SettingValue.setMAX_FLOW_T4(0);
		}
		if (T5_status) {
			SettingValue.setMIN_FLOW_T5(Integer.parseInt(Q5_Min.getText()));
			SettingValue.setMAX_FLOW_T5(Integer.parseInt(Q5_Max.getText()));
		}
		if (!T5_status) {
			SettingValue.setMIN_FLOW_T5(0);
			SettingValue.setMAX_FLOW_T5(0);
		}
		eAm = Double.valueOf(eAmont.getText());
		Qt = Double.valueOf(Q_tot.getText());
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
		Double PuissanceTotale = 0.0;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for (int i = 0; i < 5; i++) {
			String Qi = Q_list.get(i).toString();
			String Pi = formatter.format(P_list.get(i));
			PuissanceTotale += P_list.get(i);
			Q_label_list.get(i).setText("Q" + (i + 1) + " : " + Qi + " m³/s");
			P_label_list.get(i).setText("P" + (i + 1) + " : " + Pi + " MW");
		}
		P_tot.setText("Total : " + formatter.format(PuissanceTotale) + " MW");
	}

	@FXML
	protected void optimise(ActionEvent event) {
		if (checkOptimisationParams()) {
			setOptimisationParams();
			try {
				Optimisation opt = new Optimisation();
				opt.optimise(eAm, Qt);
				P_list = opt.getResultP();
				Q_list = opt.getResultQ();
				showResults();
			} catch (ArrayIndexOutOfBoundsException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("Erreur de traitement");
				alert.setContentText("L'optmisation à échoué, changer eAmont et Qtot");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText("Erreur de paramètres");
			alert.setContentText("Paramètres incorrects veuillez les vérifier");
			alert.showAndWait();
		}

	}

}
