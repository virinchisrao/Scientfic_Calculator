package com.example.caclcilo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;
import java.util.ResourceBundle;


public class MainActivity extends AppCompatActivity {

    private TextView previous;
    private EditText display;

    TextView user_input, sign_Box;
    Double num1, num2, answer;
    String sign, val_1, val_2;
    boolean has_Dot;


    private static boolean resultShown = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous= findViewById(R.id.previous);
        display= findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);


    }
    private void updateText(String strToAdd){
        String oldstr = display.getText().toString();
        int position = display.getSelectionStart();
        String leftstr=oldstr.substring(0,position),rightstr=oldstr.substring(position);

        display.setText(String.format("%s%s%s",leftstr,strToAdd,rightstr));
        display.setSelection(position+strToAdd.length());
    }


    public void zeroBTNPush(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTNPush(View view) {
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPush(View view) {
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view) {
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view){
           updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view) {
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPush(View view) {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }
    

    public void eightBTNPush(View view) {
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }

    public void decimalBTNPush(View view) {
        updateText(getResources().getString(R.string.decimalText));
    }

    public void parOBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void clearBTNPush(View view) {
         display.setText("");
         previous.setText("");
    }


    public void plusBTNPush(View view) {
        updateText(getResources().getString(R.string.addText));
        sign = "+";


    }

    public void minusBTNPush(View view) {
        updateText(getResources().getString(R.string.subtractText));
        sign = "-";
    }




    public void multiplyBTNPush(View view) {
        updateText(getResources().getString(R.string.multiplyText));
        sign = "*";
    }
    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
        sign = "/";
    }


    public void equalBTNPush(View view) {
        String userExp = display.getText().toString();

        previous.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }



        public void backspaceBTNPush(View view){
        int position = display.getSelectionStart();
        int textLen=  display.getText().length();

        if(position!=0 && textLen!=0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(position - 1, position, "");
            display.setText(selection);
            display.setSelection(position - 1);
        }
    }

    public void percentBTNPush(View view){
        updateText(getResources().getString(R.string.percent));
        String userExp = display.getText().toString();


    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }

}