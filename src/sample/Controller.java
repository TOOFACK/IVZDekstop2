package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private TextField BPK;
    @FXML
    private TextField Oxygen;
    @FXML
    private TextField C1;

    @FXML
    private TextField C2;
    @FXML
    private TextField C3;
    @FXML
    private TextField C4;
    @FXML
    private TextField PDK1;

    @FXML
    private TextField QS;
    @FXML
    private TextField QF;

    @FXML
    private TextField PDK2;
    @FXML
    private TextField PDK3;
    @FXML
    private TextField PDK4;

    @FXML
    private TextField ans;
    @FXML
    private TextField ansK;


    public void onButtonCliked(){
        float[] C = new float[6];
        float[] PDK = new float[6];
        float Qf = 0;
        float Qs = 0;
        C[0] = Float.parseFloat(BPK.getText());
        if(C[0] <= 3){
            PDK[0] = 3;
        } else if(C[0] > 3 && C[0] < 15){
            PDK[0] = 2;
        } else {
            PDK[0] = 1;
        }
        PDK[1] = Float.parseFloat(Oxygen.getText());
        if(PDK[1] > 6){
            C[1] = 6;
        } else if (PDK[1] > 5 && PDK[1] <= 6) {
            C[1] = 12;
        } else if (PDK[1] > 4 && PDK[1] <= 5) {
            C[1] = 20;
        }
        else if (PDK[1] > 3 && PDK[1] <= 4) {
            C[1] = 30;
        }
        else if (PDK[1] > 2 && PDK[1] <= 3) {
            C[1] = 40;
        }
        else if (PDK[1] > 1 && PDK[1] <= 2) {
            C[1] = 50;
        }
        else if (PDK[1] > 0 && PDK[1] <= 1) {
            C[1] = 60;
        }
        C[2] = Float.parseFloat(C1.getText());

        C[3] = Float.parseFloat(C2.getText());

        C[4] = Float.parseFloat(C3.getText());

        C[5] = Float.parseFloat(C4.getText());


        PDK[2] = Float.parseFloat(PDK1.getText());

        PDK[3] = Float.parseFloat(PDK2.getText());

        PDK[4] = Float.parseFloat(PDK3.getText());

        PDK[5] = Float.parseFloat(PDK4.getText());


        Qf = Float.parseFloat((QF.getText()));
        Qs = Float.parseFloat((QS.getText()));


        float x = estimationWithK(C,PDK,(float)(Qs/Qf));
        float c = estimation(6,C,PDK);

        String ans1 = check(c);
        String ansK2 = checkwK(x);

        ans.setText(ans1);
        ansK.setText(ansK2);






    }


    public static float estimationWithK( float[] C, float[] PDK, float K){

        float sum = 0;
        float con = ((float)1/6 * K);
        for (int j = 0; j < 6; j++){
            sum = sum + (C[j]/PDK[j]);
        }


        return con * sum;

    }

    public static float estimation(int i, float[] C, float[] PDK){
        float sum = 0;

        float con = (float) 1/i;
        for ( int j = 0; j < i; j++){
            sum +=  (float)(C[j]/PDK[j]);

        }

        return con * sum;

    }
    public static String check(float ivz){
        String k = "lol";

        if(ivz <= 0.3){
            k= "Характеристика: I - очень чистая";
        } else if(ivz > 0.3 && ivz <= 1){
            k= "Характеристика: II - чистая";
        } else if(ivz > 1 && ivz <= 2.5){
            k= "Характеристика: III - умеренно загрязненная";
        } else if(ivz > 2.5 && ivz <= 4){
            k= "Характеристика: IV - загрязненная";
        } else if(ivz > 4 && ivz <= 6){
            k= "Характеристика: V - грязная";
        } else if(ivz > 6 && ivz <= 10){
            k= "Характеристика: VI - грязная";
        }else if(ivz > 10){
            k= "Характеристика: VII - черезвыяайно грязная";
        }
        return k;
    }

    public static String checkwK(float ivzK){
        String s = "lel";

        if(ivzK <= 0.2){
            s= "Характеристика: I - очень чистая";
        } else if(ivzK > 0.2 && ivzK <= 1){
            s= "Характеристика: II - чистая";
        } else if(ivzK > 1 && ivzK <= 2){
            s =  "Характеристика: III - умеренно загрязненная";
        } else if(ivzK > 2 && ivzK <= 4){
            s= "Характеристика: IV - загрязненная";
        } else if(ivzK > 4 && ivzK <= 6){
            s= "Характеристика: V - грязная";
        } else if(ivzK > 6 && ivzK <= 10){
            s= "Характеристика: VI - грязная";
        }else if(ivzK > 10){
            s= "Характеристика: VII - черезвыяайно грязная";
        }

        return s;
    }
}
