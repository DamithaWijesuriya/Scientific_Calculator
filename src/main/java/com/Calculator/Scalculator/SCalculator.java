package com.Calculator.Scalculator;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import static java.lang.System.out;
import static sun.java2d.cmm.ColorTransform.Out;

/**
 * Created by hsenid on 12/1/16.
 */
public class SCalculator extends javax.swing.JFrame {



    public SCalculator() {
        add(panelCalculator);

        //Zero to Nine
        btnzero.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "0");
            }
        });
        btnone.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "1");
            }
        });
        btntwo.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "2");
            }
        });
        btnthree.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "3");
            }
        });
        btnfour.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "4");
            }
        });
        btnfive.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "5");
            }
        });
        btnsix.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "6");
            }
        });
        btnseven.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "7");
            }
        });
        btneight.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "8");
            }
        });
        btnnine.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "9");
            }
        });
        btndecimalpoint.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + ".");
            }
        });

        //basic Operators

        Percentage.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "%");
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {

                if (!expression) {
                    InputText.setText(InputText.getText() + "+");
                    try {
                        OutputText.setText(operationSelection());
                    } catch (Exception e1) {
                        OutputText.setText(e1.getMessage());
                    }
                    Operator = "+";
                } else if (expression) {
                    InputText.setText(InputText.getText() + " + ");
                }
            }
        });

        btnminus.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                if (!expression) {
                    InputText.setText(InputText.getText() + "-");
                    try {
                        OutputText.setText(operationSelection());
                    } catch (Exception e1) {
                        OutputText.setText(e1.getMessage());
                    }
                    Operator = "-";
                } else if (expression) {
                    InputText.setText(InputText.getText() + " - ");
                }
            }
        });
        btnmultiplication.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                if (!expression) {
                    InputText.setText(InputText.getText() + "*");
                    try {
                        OutputText.setText(operationSelection());
                    } catch (Exception e1) {
                        OutputText.setText(e1.getMessage());
                    }
                    Operator = "*";
                } else if (expression) {
                    InputText.setText(InputText.getText() + " * ");
                }
            }
        });
        btndivision.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                if (!expression) {
                    InputText.setText(InputText.getText() + "÷");
                    try {
                        OutputText.setText(operationSelection());
                    } catch (Exception e1) {
                        OutputText.setText(e1.getMessage());
                    }
                    Operator = "÷";
                } else if (expression) {
                    InputText.setText(InputText.getText() + " / ");
                }
            }
        });
        btnXToPowery.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "^");
                Operator = "^";

            }
        });

        btnequals.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                try {
                    InputText.setText(InputText.getText() + "=");
                    if (!expression) {
                        if (Operator.equals("+")) {
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                            //history.addItem(operand + " = " + outputDisplay.getText());
                        } else if (Operator.equals("-")) {
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("*")) {
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("÷")) {
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Sin")) {

                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.sin(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Cos")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.cos(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());

                        } else if (Operator.equals("Tan")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.tan(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Asin")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.aSin(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Acos")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.aCos(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Atan")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.aTan(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("ln")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.loge(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("log")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.log10(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("!")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.factorial(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("C")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("P")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("^")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("√")) {
                            Operand = InputText.getText().substring(0, InputText.getText().length() - 1);
                            Converter = Functions.operandConverter(Operand);
                            Output = Functions.xSqrt(Double.parseDouble(Converter));
                            OutputText.setText(String.valueOf(Output));
                            History.addItem(InputText.getText() + OutputText.getText());
                        } else if (Operator.equals("Inverse")) {

                            OutputText.setText(operationSelection());
                            History.addItem(InputText.getText() + OutputText.getText());
                        }
                    } else if (expression) {

                        OutputText.setText(String.valueOf(Functions.evaluate(InputText.getText().substring(0, InputText.getText().length() - 1), 0)));
                        History.addItem(InputText.getText() + OutputText.getText());
                    }

                } catch (Exception e1) {
                    OutputText.setText(e1.getMessage());
                    e1.printStackTrace();
                }

            }
        });
        PlusOrMinus.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "±");
            }
        });

        OpenBraces.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + " ( ");
            }
        });
        CloseBraces.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + " ) ");
            }
        });


        //Trigonamitic
        btnsin.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Sin ");
                Operator = "Sin";
            }
        });
        btncos.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Cos");
                Operator = "Cos";
            }
        });
        btntan.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Tan");
                Operator = "Tan";
            }
        });
        btnAsin.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Asin");
                Operator = "Asin";
            }
        });
        btnaCos.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Acos");
                Operator = "Acos";
            }
        });
        btnaTan.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "Atan");
                Operator = "Atan";
            }
        });

        //Log function
        btnln.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "ln");
                Operator = "ln";
            }
        });
        btnlog.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "log");
                Operator = "log";
            }
        });
        //Factorial
        btnfactorialn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "!");
                Operator = "!";
            }
        });

        btnnPr.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "P");
                Operator = "P";
            }
        });
        btnnCr.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "C");
                Operator = "C";
            }
        });
        btnrootx.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "√");
                Operator = "√";
            }
        });
        btnE.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "ė");
                OutputText.setText(String.valueOf(Functions.E));

            }
        });
        btnclear.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText("");
                OutputText.setText("");
               /* operand1 = "";
                operand2 = Double.parseDouble(null);*/
                Operator = "";
                Operand = null;
                answer = 0;
                expression = false;



            }
        });

        btnoneOverX.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                InputText.setText(InputText.getText() + "1/");
                Operator = "Inverse";
            }
        });
        fXButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                expression = true;
            }
        });
        MPlus.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                Operand = InputText.getText();
                Operator = "M+";
                Functions.memoryOperation(Operand, Operator);

            }
        });
        MMinus.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                Operand = InputText.getText();
                Operator = "M-";
                Functions.memoryOperation(Operand, Operator);
            }
        });
        MCButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                Operand = InputText.getText();
                Operator = "clearM";
                Functions.memoryOperation(Operand, Operator);
            }
        });
        MR.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                OutputText.setText(String.valueOf(Functions.memory));
            }
        });

        Hex.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {

                String select = getCurrentBase();
                if (select.equals("hex")) {
                    OutputText.setText(InputText.getText());
                } else if (select.equals("dec")) {
                    OutputText.setText(Integer.toHexString(Integer.parseInt(InputText.getText())));
                } else if (select.equals("oct")) {
                    OutputText.setText(Integer.toHexString(Integer.parseInt(InputText.getText(), 8)));
                } else if (select.equals("bin")) {
                    OutputText.setText(Integer.toHexString(Integer.parseInt(InputText.getText(), 2)));
                }

            }

        });

        Dec.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String select = getCurrentBase();
                if (select.equals("Dec")) {
                    OutputText.setText(InputText.getText());
                } else if (select.equals("hex")) {
                    OutputText.setText(String.valueOf(Integer.parseInt(InputText.getText(), 16)));
                } else if (select.equals("oct")) {
                    OutputText.setText(String.valueOf(Integer.parseInt(InputText.getText(), 8)));
                } else if (select.equals("bin")) {
                    OutputText.setText(String.valueOf(Integer.parseInt(InputText.getText(), 2)));
                }
            }
        });
        Binary.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String select = getCurrentBase();
                if (select.equals("hex")) {
                    OutputText.setText(Integer.toBinaryString(Integer.parseInt(InputText.getText(), 16)));
                } else if (select.equals("dec")) {
                    OutputText.setText(Integer.toBinaryString(Integer.parseInt(InputText.getText())));
                } else if (select.equals("oct")) {
                    OutputText.setText(Integer.toBinaryString(Integer.parseInt(InputText.getText(), 8)));
                }
            }
        });
        Oct.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                String select = getCurrentBase();
                if (select.equals("hex")) {
                    OutputText.setText(Integer.toOctalString(Integer.parseInt(InputText.getText(), 16)));
                } else if (select.equals("bin")) {
                    OutputText.setText(Integer.toOctalString(Integer.parseInt(InputText.getText(), 2)));
                } else if (select.equals("dec")) {
                    OutputText.setText(Integer.toOctalString(Integer.parseInt(InputText.getText())));
                }
            }
        });


        historySaveButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter out = new PrintWriter(new FileOutputStream(new File("/home/hsenid/Documents/A.txt"), true));
                    out.print(History.getSelectedItem());
                    out.println(" ");
                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        fXButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {

                Graph G = new Graph();
                G.createAndShowGUI();
            }
        });
    }

    public static String getCurrentBase() {
        String[] choices = {"hex", "dec", "oct", "bin"};
        return JOptionPane.showInputDialog(null, "What is the base of the value you have entered?", "Choose base...", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]).toString();
    }


    private void initComponents() {
    }


    private JButton btnyrootx;
    private JPanel panelCalculator;
    private JButton btnln;
    private JButton btnfactorialn;
    private JButton btnoneOverX;
    private JButton btnzero;
    private JButton btndecimalpoint;
    private JButton btnequals;
    private JButton btnlog;
    private JButton btnnPr;
    private JButton btnnCr;
    private JButton btnone;
    private JButton btntwo;
    private JButton btnthree;
    private JButton btndivision;
    private JButton btnXToPowery;
    private JButton btnsin;
    private JButton btncos;
    private JButton btntan;
    private JButton btnfour;
    private JButton btnfive;
    private JButton btnsix;
    private JButton btnmultiplication;
    private JButton btnAsin;
    private JButton btnaCos;
    private JButton btnaTan;
    private JButton btnseven;
    private JButton btneight;
    private JButton btnnine;
    private JButton btnminus;
    private JButton btnPI;
    private JButton btnE;
    private JButton btnrootx;
    private JButton MR;
    private JButton btnclear;
    private JButton btnbackspace;
    private JButton btnPlus;
    private JTextPane InputText;
    private JTextField OutputText;
    private JButton Percentage;
    private JButton PlusOrMinus;
    private JButton MPlus;
    private JButton plotButton;
    private JRadioButton hexRadioButton;
    private JButton historySaveButton;
    private JButton OpenBraces;
    private JButton CloseBraces;
    private JButton fXButton;
    private JButton button3;
    private JButton button4;
    private JButton MMinus;
    private JButton MCButton;
    private JButton Hex;
    private JButton Dec;
    private JButton Binary;
    private JButton Oct;
    private JComboBox History;
    private JTextPane history;

    static String leftOperand;
    static String righOperand;
    String Operand;
    static double operand1;
    static double operand2;
    static String Operator;
    static boolean output = true;
    static double answer = 0;
    String Converter;
    double Output;
    boolean expression = false;

    public String operationSelection() throws Exception {
        String input = InputText.getText();
        String[] inputArr = input.split("");
        if (inputArr.length > 3) {
            if (output) {
                operand1 = Double.parseDouble(inputArr[0]);
                answer = operand1;
                output = false;
            } else {
                operand1 = Double.parseDouble(OutputText.getText());
            }
            operand2 = Double.parseDouble(inputArr[inputArr.length - 2]);
            Operator = inputArr[inputArr.length - 3];

        }

        if (Operator != null && Operator.equals("+")) {
            answer = Functions.add(operand1, operand2);
        } else if ((Operator != null && Operator.equals("-"))) {
            answer = Functions.substraction(operand1, operand2);
        } else if (Operator != null && Operator.equals("÷")) {
            answer = Functions.divide(operand1, operand2);
        } else if (Operator != null && Operator.equals("*")) {
            answer = Functions.multiplication(operand1, operand2);
        } else if (Operator != null && Operator.equals("%")) {
            answer = Functions.percentage(operand1, operand2);
        } else if (Operator != null && Operator.equals("C")) {

            if (operand2 > operand1)
                throw new Exception("Malformed exception!");
            answer = Functions.combination(operand1, operand2);


        } else if (Operator != null && Operator.equals("P")) {
            if (operand2 > operand1)
                throw new Exception("Malformed exception!");
            answer = Functions.permutation(operand1, operand2);
        } else if (Operator != null && Operator.equals("^")) {
            answer = Functions.xPowY(operand1, operand2);

        } else if (Operator != null && Operator.equals("/")) {

            if (operand2 == 0)
                throw new Exception("Malformed exception!");
            answer = Functions.divide(1, operand2);
        }

        return String.valueOf(answer);
    }


    public static void main(String[] args) {

        SCalculator Sc = new SCalculator();
        Sc.setVisible(true);
        Sc.setSize(1000, 430);
        Sc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class Operand {
    private double value;
    private boolean isLeft;

    public Operand(double value, boolean isLeft) {
        this.value = value;
        this.isLeft = isLeft;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }
}
