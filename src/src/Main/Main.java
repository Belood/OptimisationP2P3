package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Optimisation.CalculatedData;
import Optimisation.Optimisation;
import Optimisation.SettingValue;

/**
 * Created by Etudes on 18/03/2018.
 */
public class Main {
	public static final String XLSX_FILE_PATH = "./data.xlsx";
	


	public static void main(String[] args) throws IOException, InvalidFormatException {
		//Recuperation des données du fichier excel
		ArrayList<Double> test_nivAmont=new ArrayList<Double>();
		ArrayList<Double> test_Qturb=new ArrayList<Double>();
		Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
		//System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		Sheet sheet = workbook.getSheet("Tests");
		//System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
		for (Row row : sheet) {
			test_nivAmont.add(row.getCell(1).getNumericCellValue());
			test_Qturb.add(row.getCell(0).getNumericCellValue());
		}
		//workbook.close();
		//System.out.println(test_nivAmont.size()+" "+test_Qturb.size());

        long testStarttime=System.nanoTime();
		Optimisation optimisation = new Optimisation();

		Sheet resultSheet=workbook.getSheet("Resultats");
		for(int i=0;i<test_nivAmont.size();i++) {
			long start=System.nanoTime();
	        optimisation.optimise(test_nivAmont.get(i),test_Qturb.get(i));
	        long end=System.nanoTime();
	        System.out.println("Temps de calcul du test numéro "+(i+1)+": "+(end-start)+" ns");
	        
	        ArrayList<Integer> resultQ=optimisation.getResultQ();
	        ArrayList<Double> resultP=optimisation.getResultP();
	        
	        Row row=resultSheet.createRow(i);
	        for(int c=0;c<5;c++) {
	        	Cell Q=row.createCell(2*c);
	        	Cell P=row.createCell(2*c+1);
	        	Q.setCellValue(resultQ.get(c));
	        	P.setCellValue(resultP.get(c));
	        }
	        
	        System.out.println("");
		}
		FileOutputStream fos=new FileOutputStream("testResult.xlsx");
		workbook.write(fos);
		fos.close();
		workbook.close();
		long testEndtime=System.nanoTime();
		System.out.println("Temps de calcul total pour les 200 tests: "+ (testEndtime-testStarttime)/1000000+" ms");
		

	}

 
}
