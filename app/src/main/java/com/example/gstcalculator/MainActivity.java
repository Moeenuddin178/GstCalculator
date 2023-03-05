package com.example.gstcalculator;
import android.content.SharedPreferences;
import android.media.tv.AdRequest;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button Modul;
    private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-2939831193858166/3100794847";




    ArrayList<Integer> a = new ArrayList<Integer>();

    private static boolean newOperand = false;
    private Button add;
    private Double ans = 0.0;
    private LinearLayout calc_main_Layout;

    private Button clear;

    private Button delete;

    private Button divide;

    private boolean doubleBackToExitPressedOnce = false;

    private Button eight;

    private Button equal;

    private Button five;

    private Button four;

    private Button gst12m;

    private Button gst12p;

    private Button gst18m;

    private Button gst18p;

    private Button gst28m;

    private Button gst28p;

    private Button gst5m;

    private Button gst5p;

    private Button gst3m;

    private Button gst3p;

    private RelativeLayout layoutInputData;

    private RelativeLayout layoutViewData;

    private Button multiply;

    private Button nine;

    private Button one;

    private Button point;

    private Button seven;

    private Button six;

    private Button subtract;

    TextView textView;

    private TextView textView2;

    private TextView textView3;

    private TextView textViewCGST;

    private TextView textViewSGST;

    private Button three;

    private Button two;

    private Button zero;

    private Button zero2;

    private Button mod;

    SharedPreferences pref;

    String full_str = "";

    int totle_v = 0;


    String optr = "+";
    String nmbr = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


        SharedPreferences.Editor editor = pref.edit();
        editor.putString("count", "111");
        editor.putString("del", "1111");
        editor.putString("total_val", "abc");
        editor.apply();


    

        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.buttonZero);
        zero2 = findViewById(R.id.buttonZero2);
        point = findViewById(R.id.buttonPoint);


        add = findViewById(R.id.buttonAdd);
        subtract = findViewById(R.id.buttonSubtraction);
        multiply = findViewById(R.id.buttonMultiply);
        divide = findViewById(R.id.buttonDivide);
        mod = findViewById(R.id.buttonModul);
        delete = findViewById(R.id.buttonMinusValue);
        equal = findViewById(R.id.buttonEqual);
        clear = findViewById(R.id.buttonClearText);

        gst28m = findViewById(R.id.gst28m);
        gst28p = findViewById(R.id.gst28p);
        gst18m = findViewById(R.id.gst18m);
        gst18p = findViewById(R.id.gst18p);
        gst12m = findViewById(R.id.gst12m);
        gst12p = findViewById(R.id.gst12p);
        gst5m = findViewById(R.id.gst5m);
        gst5p = findViewById(R.id.gst5p);


        gst3m = findViewById(R.id.gst3m);
        gst3p = findViewById(R.id.gst3p);


        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        textView = findViewById(R.id.textView1);


        textViewCGST = findViewById(R.id.textViewCGST);
        textViewSGST = findViewById(R.id.textViewSGST);


        textView2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        //Do something after 100ms


                        String[] tokens = full_str.split("\\,");


                        int c = 1;
                        for (int i = 0; i < tokens.length; i++) {
                            tokens[i] = tokens[i].trim();
                            if (tokens[i].equals("+") || tokens[i].equals("-")
                                    || tokens[i].equals("x")
                                    || tokens[i].equals("÷") || tokens[i].equals("%")
                                    || tokens[i].equals("p28$")
                                    || tokens[i].equals("p18$")
                                    || tokens[i].equals("p12$") || tokens[i].equals("p5$")
                                    || tokens[i].equals("m5$") || tokens[i].equals("m12$") || tokens[i].equals("m18$")
                                    || tokens[i].equals("m28$")
                                    || tokens[i].equals("m3$")
                                    || tokens[i].equals("p3$")) {

                                optr = optr + "," + tokens[i];

//                oper[c]=tokens[i];
                                c++;
                            }

                        }

                        for (int i = 0; i < tokens.length; i++) {
                            tokens[i] = tokens[i].trim();
                            if (tokens[i].equals("+") || tokens[i].equals("-")
                                    || tokens[i].equals("x") || tokens[i].equals("÷")
                                    || tokens[i].equals("%")
                                    || tokens[i].equals("p28$")
                                    || tokens[i].equals("p18$")
                                    || tokens[i].equals("p12$") || tokens[i].equals("p5$")
                                    || tokens[i].equals("m5$") || tokens[i].equals("m12$") || tokens[i].equals("m18$")
                                    || tokens[i].equals("m28$")
                                    || tokens[i].equals("m3$")
                                    || tokens[i].equals("p3$")) {


                            } else {
//                number[i]=tokens[i];

                                if (i == 0) {
                                    nmbr = tokens[i];

                                } else {
                                    nmbr = nmbr + "," + tokens[i];

                                }

                            }

                        }


                        for (int i = 0; i < tokens.length; i++) {


                            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("x")
                                    || tokens[i].equals("÷") || tokens[i].equals("%")
                                    || tokens[i].equals("p28$")
                                    || tokens[i].equals("p18$")
                                    || tokens[i].equals("p12$") || tokens[i].equals("p5$")
                                    || tokens[i].equals("m5$") || tokens[i].equals("m12$") || tokens[i].equals("m18$")
                                    || tokens[i].equals("m28$")
                                    || tokens[i].equals("m3$")
                                    || tokens[i].equals("p3$")) {


                            } else {
                                tokens[i] = tokens[i].trim();
//                numbb[i] = Integer.parseInt(tokens[i]);
                            }


                        }


//        Toast.makeText(MainActivity.this,""+toke.length+" "+tok.length,Toast.LENGTH_LONG).show();

                        performOP();
//
                        String aa;

                        String pr = Double.toString(ans);
                        if (pr.contains(".")) {

                            ans = Double.parseDouble(new DecimalFormat("##.####").format(ans));

                            pr = Double.toString(ans);

                            String[] pointt = pr.split("\\.");

                            int idx = pointt.length - 1;


                            long myNum = 0;
                            try {
                                myNum = Integer.parseInt(pointt[idx]);
                            } catch (NumberFormatException nfe) {
//                                Toast.makeText(MainActivity.this,""+nfe,Toast.LENGTH_LONG).show();
                                String bar = pointt[idx].substring(0, 4);
                                myNum = Integer.parseInt(bar);
                            }


                            if (myNum > 0) {


                                aa = Double.toString(ans);


                            } else {
                                aa = pointt[0];
                            }

                        } else {
                            aa = Double.toString(ans);

                        }


                        if (aa.equals("0")) {
                            textView.setText("");
                        } else {
                            textView.setText("= " + aa);
                        }


                        ans = 0.0;
                        optr = "+";
                        nmbr = "";


                    }
                }, 100);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


            }
        });


        gst3p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {

                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double f = (dd / 100) * 3;

                            f = Double.parseDouble(new DecimalFormat("##.####").format(f));


                            Double cgst = f / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(f);
                            textView2.setText("+ " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "p3$" + ",";

                }
            }
        });


        gst3m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {

                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);

                            Double gst5m = 100 + 3.0;
                            gst5m = 100 / gst5m;
                            gst5m = dd * gst5m;

                            gst5m = dd - gst5m;


                            gst5m = Double.parseDouble(new DecimalFormat("##.####").format(gst5m));


                            Double cgst = gst5m / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(gst5m);
                            textView2.setText("- " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "m3$" + ",";

                }

            }
        });


        gst5m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {

                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);

                            Double gst5m = 100 + 5.0;
                            gst5m = 100 / gst5m;
                            gst5m = dd * gst5m;

                            gst5m = dd - gst5m;


                            gst5m = Double.parseDouble(new DecimalFormat("##.####").format(gst5m));


                            Double cgst = gst5m / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(gst5m);
                            textView2.setText("- " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "m5$" + ",";

                }

            }
        });


        gst12m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {

                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double gst5m = 100 + 12.0;
                            gst5m = 100 / gst5m;
                            gst5m = dd * gst5m;

                            gst5m = dd - gst5m;


                            gst5m = Double.parseDouble(new DecimalFormat("##.####").format(gst5m));


                            Double cgst = gst5m / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(gst5m);
                            textView2.setText("- " + s);
//                        newOperand = true;
                        }
                    }
                    full_str = full_str + "," + "m12$" + ",";

                }

            }
        });


        gst18m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double gst5m = 100 + 18.0;
                            gst5m = 100 / gst5m;
                            gst5m = dd * gst5m;

                            gst5m = dd - gst5m;


                            gst5m = Double.parseDouble(new DecimalFormat("##.####").format(gst5m));


                            Double cgst = gst5m / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(gst5m);
                            textView2.setText("- " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "m18$" + ",";

                }
            }
        });


        gst28m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);

                            Double gst5m = 100 + 28.0;
                            gst5m = 100 / gst5m;
                            gst5m = dd * gst5m;

                            gst5m = dd - gst5m;

                            gst5m = Double.parseDouble(new DecimalFormat("##.####").format(gst5m));


                            Double cgst = gst5m / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(gst5m);
                            textView2.setText("- " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "m28$" + ",";

                }

            }
        });


        gst5p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {

                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double f = (dd / 100) * 5;

                            f = Double.parseDouble(new DecimalFormat("##.####").format(f));


                            Double cgst = f / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(f);
                            textView2.setText("+ " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "p5$" + ",";

                }
            }
        });


        gst28p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {

                        if (!textView.getText().toString().equals("")) {


                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double f = (dd / 100) * 28;

                            f = Double.parseDouble(new DecimalFormat("##.####").format(f));


                            Double cgst = f / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);

                            String s = Double.toString(f);
                            textView2.setText("+ " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "p28$" + ",";

                }

            }
        });


        gst18p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double f = (dd / 100) * 18;

                            f = Double.parseDouble(new DecimalFormat("##.####").format(f));


                            Double cgst = f / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(f);
                            textView2.setText("+ " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "p18$" + ",";
                }

            }
        });


        gst12p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        if (!textView.getText().toString().equals("")) {
                            textDisplay = textDisplay.replace("= ", "");

                            textView3.setText(textDisplay);

                            double dd = Double.parseDouble(textDisplay);


                            Double f = (dd / 100) * 12;

                            f = Double.parseDouble(new DecimalFormat("##.####").format(f));


                            Double cgst = f / 2;
                            String ss = Double.toString(cgst);

                            textViewCGST.setText("CGST=" + ss);
                            textViewSGST.setText("SGST=" + ss);


                            String s = Double.toString(f);
                            textView2.setText("+ " + s);
//                        newOperand = true;
                        }
                    }

                    full_str = full_str + "," + "p12$" + ",";

                }

            }
        });


        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView2.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        textDisplay = textDisplay.concat("%");

                        textView2.setText(textDisplay);
                        newOperand = true;
                    }


                    full_str = full_str + "," + "%" + ",";

                    textViewCGST.setText("");
                    textViewSGST.setText("");

                }

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView2.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        textDisplay = textDisplay.concat("+");

                        textView2.setText(textDisplay);
                        newOperand = true;
                    }
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("op", "+");
                    editor.apply();


                    full_str = full_str + "," + "+" + ",";
                    textViewCGST.setText("");
                    textViewSGST.setText("");

                }

            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView2.getText().toString();

                if (!newOperand) {


                    if (!textView2.getText().toString().equals("")) {
                        textDisplay = textDisplay.concat("-");

                        textView2.setText(textDisplay);
                        newOperand = true;
                    }

                    full_str = full_str + "," + "-" + ",";
                    textViewCGST.setText("");
                    textViewSGST.setText("");
                }

            }
        });


        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView2.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        textDisplay = textDisplay.concat("÷");

                        textView2.setText(textDisplay);
                        newOperand = true;
                    }

                    full_str = full_str + "," + "÷" + ",";
                    textViewCGST.setText("");
                    textViewSGST.setText("");
                }

            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String textDisplay = textView2.getText().toString();

                if (!newOperand) {
                    if (!textView2.getText().toString().equals("")) {
                        textDisplay = textDisplay.concat("x");

                        textView2.setText(textDisplay);
                        newOperand = true;
                    }

                    full_str = full_str + "," + "x" + ",";
                    textViewCGST.setText("");
                    textViewSGST.setText("");
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                textViewCGST.setText("");
                textViewSGST.setText("");
                String str = textView2.getText().toString();

                if (!str.equals("") && str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                    textView2.setText(str);
                }

                if (str.length() > 0) {

                    char last_c = str.charAt(str.length() - 1);
                    if (last_c == '+' || last_c == 'x' || last_c == '÷' || last_c == '-') {

                    } else {
                        newOperand = false;
                    }
                }

                if (full_str.length() > 0) {


                    char f = full_str.charAt(full_str.length() - 1);

                    if (f == ',') {
                        full_str = full_str.substring(0, full_str.length() - 3);
                    } else {

                        full_str = full_str.substring(0, full_str.length() - 1);

                    }


//                    Toast.makeText(MainActivity.this,"fgdrgdgfgf "+full_str ,Toast.LENGTH_LONG).show();

                }

//


                SharedPreferences.Editor editor = pref.edit();
                editor.putString("del", "123");
                editor.apply();


//                Toast.makeText(MainActivity.this,""+last_c,Toast.LENGTH_SHORT).show();
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView2.setText("");
                textView3.setText("");
                textView.setText("");
                newOperand = false;

                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();

                full_str = "";
                textViewCGST.setText("");
                textViewSGST.setText("");


            }
        });


        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }

                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");


                char last_c = ' ';

                if (textDisplay.length() != 0) {
                    last_c = textDisplay.charAt(textDisplay.length() - 1);

                }


                if (textDisplay.length() == 0) {

                } else if (last_c == '.') {

                } else {


                    String[] tokens = full_str.split("\\,");


                    tokens[tokens.length - 1] = tokens[tokens.length - 1].trim();

                    if (!tokens[tokens.length - 1].contains(".")) {


                        textDisplay = textDisplay.concat(".");
                        textView2.setText(textDisplay);
                        full_str = full_str + ".";
                        textViewCGST.setText("");
                        textViewSGST.setText("");
                    }


                }


            }

        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                equal_fun();


                textView2.setText("");
                textView3.setText("");


                textViewCGST.setText("");
                textViewSGST.setText("");


            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("1");

                textView2.setText(textDisplay);
                newOperand = false;

                full_str = full_str + "1";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }

                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("2");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "2";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("3");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "3";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("4");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "4";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("5");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "5";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();


                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("6");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "6";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("7");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "7";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                perfo();
                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("8");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "8";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("9");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "9";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("0");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "0";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });


        zero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perfo();

                String tv1 = textView2.getText().toString();
                String tv2 = textView.getText().toString();

                if (tv1.equals("") && !tv2.equals("")) {
//                    textView2.setText("");
                    textView.setText("");
                    full_str = "";
                }


                String textDisplay = textView2.getText().toString();
                if (textDisplay.length() == 1 && textDisplay.equalsIgnoreCase("0"))
                    textView2.setText("");

                textDisplay = textDisplay.concat("00");

                textView2.setText(textDisplay);

                newOperand = false;

                full_str = full_str + "00";
                textViewCGST.setText("");
                textViewSGST.setText("");
            }
        });



    }


    private void perfo() {


        if (full_str.contains("$")) {
            String s = textView.getText().toString();
            s = s.replace("= ", "");


            textView2.setText("");
            textView3.setText("");
//            textView.setText("");


            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.apply();


            full_str = s;
            textView2.setText(s);
//            textView.setText(s);


//


        }

    }


    private void performOP() {

        String[] oper = optr.split("\\,");
        String[] tok = nmbr.split("\\,");


        Double[] numbb = new Double[tok.length];


        for (int i = 0; i < tok.length; i++) {

            try {


                numbb[i] = Double.parseDouble(tok[i]);


            } catch (Exception e) {

            }


        }


        try {

            for (int i = 0; i < oper.length; i++) {
                switch (oper[i]) {
                    case "+":
                        ans = ans + numbb[i];
                        break;
                    case "-":
                        ans = ans - numbb[i];
                        break;
                    case "x":
                        ans = ans * numbb[i];
                        break;
                    case "÷":
                        ans = ans / numbb[i];
                        break;
                    case "%":
                        ans = (ans / 100) * numbb[i];
                        break;
                    case "p28$":
                        Double f = (ans / 100) * 28;

                        String s = Double.toString(f);
//                        textView2.setText("+ "+s);
                        ans = ans + f;
                        break;
                    case "p18$":
                        Double ff = (ans / 100) * 18;

                        String ss = Double.toString(ff);
//                        textView2.setText("+ "+s);
                        ans = ans + ff;
                        break;

                    case "p12$":
                        Double fff = (ans / 100) * 12;

                        String sss = Double.toString(fff);

                        ans = ans + fff;
                        break;

                    case "p5$":
                        Double fff_ = (ans / 100) * 5;


                        ans = ans + fff_;
                        break;
                    case "m5$":


                        Double gst5m = 100 + 5.0;
                        gst5m = 100 / gst5m;
                        gst5m = ans * gst5m;

                        gst5m = ans - gst5m;

                        ans = ans - gst5m;


                        break;


                    case "p3$":
                        Double fff__ = (ans / 100) * 3;


                        ans = ans + fff__;
                        break;
                    case "m3$":


                        Double gst3m = 100 + 3.0;
                        gst3m = 100 / gst3m;
                        gst3m = ans * gst3m;

                        gst3m = ans - gst3m;

                        ans = ans - gst3m;


                        break;


                    case "m12$":


                        Double gst12m = 100 + 12.0;
                        gst12m = 100 / gst12m;
                        gst12m = ans * gst12m;

                        gst12m = ans - gst12m;

                        ans = ans - gst12m;


                        break;

                    case "m18$":


                        Double gst18m = 100 + 18.0;
                        gst18m = 100 / gst18m;
                        gst18m = ans * gst18m;

                        gst18m = ans - gst18m;

                        ans = ans - gst18m;


                        break;


                    case "m28$":


                        Double gst28m = 100 + 28.0;
                        gst28m = 100 / gst28m;
                        gst28m = ans * gst28m;

                        gst28m = ans - gst28m;

                        ans = ans - gst28m;


                        break;

                    default:
                        Toast.makeText(MainActivity.this, "INVALID CASE !!!", Toast.LENGTH_LONG).show();
                }
            }

        } catch (Exception e) {

        }


    }
    @Override
    public void onBackPressed() {
        finish();
        //  startActivity(new Intent(HistoryActivity.this, MainActivity.class));
    }

}