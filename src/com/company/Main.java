package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static String array = "{}";

    public static void cocktailSort(int[] arr){
        boolean swap = true;
        while (swap){
            swap = false;
            for (int i = 0; i < arr.length-1; i++){
                if (arr[i] > arr[i+1]){
                    int x = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = x;
                    swap = true;
                }
            }
            if (!swap){
                break;
            }
            swap = false;
            for (int i = arr.length-1; i > 0; i--){
                if (arr[i] < arr[i-1]){
                    int x = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = x;
                    swap = true;
                }
            }
        }
    }

    public static void combSort(int[] arr){
        int width = arr.length;
        double dec = 1.247330950103979;
        boolean swap = true;
        while(swap || width > 1){
            swap = false;
            if (width > 1){
                width = (int)(width / dec);
            }
            for(int i = 0; i + width < arr.length; i++){
                if (arr[i] > arr[i+width]){
                    int x = arr[i+width];
                    arr[i+width] = arr[i];
                    arr[i] = x;
                    swap = true;
                }
            }
        }
    }

    public static void quickSort(int[] arr){
        int elem = arr[(int)(arr.length / 2)];
        int i = 0, j = arr.length-1;
        while (j > i) {
            while ((arr[i] < elem || arr[i] == arr[j]) &&  i < j) {
                i++;
            }
            while (arr[j] > elem && j > i) {
                j--;
            }
            int x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }
        if (arr.length > 2) {
            int[] first = Arrays.copyOfRange(arr, 0, i);
            int[] second = Arrays.copyOfRange(arr, i, arr.length);
            quickSort(first);
            quickSort(second);
            for (int k = 0; k < first.length; k++){
                arr[k] = first[k];
            }
            for (int k = 0; k < second.length; k++){
                arr[k+first.length] = second[k];
            }
        }
    }

    public static void gnomeSort(int[] arr){
        int i = 0;
        while(i < arr.length - 1){
            if (arr[i] > arr[i + 1]){
                int x = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = x;
                if(i > 0) {
                    i--;
                }
            }else{
                i++;
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            int max = i;
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[max]){
                    max = j;
                }
            }
            int x = arr[i];
            arr[i] = arr[max];
            arr[max] = x;
        }
    }

    public static void window(){
        JFrame wind = new JFrame("Сортировка массива");
        wind.setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().width - 250)/2), (int)((Toolkit.getDefaultToolkit().getScreenSize().height - 120)/2), 250, 120);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setResizable(false);
        wind.setLayout(null);

        JPanel butDel = new JPanel();
        butDel.setLayout(null);
        butDel.setBounds(0, wind.getHeight()-56, (int)wind.getWidth()/2, 40);

        JPanel addElemPanel = new JPanel();
        addElemPanel.setLayout(null);
        addElemPanel.setBounds(0, 0, (int)wind.getWidth()/2, 25);

        JPanel changeSort = new JPanel();
        changeSort.setLayout(null);
        changeSort.setBounds(addElemPanel.getWidth(), 0, (int)wind.getWidth()/2, 25);

        JPanel panel = new JPanel();
        //panel.setBounds(0, 0, wind.getWidth(), 25);

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, changeSort.getHeight(), wind.getWidth(), 40);

        JLabel strArr = new JLabel(array);
        strArr.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        panel.add(strArr);

        JTextField elem = new JTextField();
        elem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int x = Integer.parseInt(elem.getText());
                    if (!array.equals("{}")){
                        array = array.substring(0, array.length()-1) + ", }";
                    }
                    array = array.substring(0, array.length()-1) + elem.getText() + "}";
                    strArr.setText(array);
                    elem.setText("");
                }catch(NumberFormatException NF){
                    JOptionPane.showMessageDialog(null, "Введите целое число в верном формате");
                }
            }
        });
        elem.setBounds(0, 0, addElemPanel.getWidth() - 50, addElemPanel.getHeight());
        addElemPanel.add(elem);

        JButton add = new JButton("Добавить");
        add.setMargin(new Insets(0, 0, 0, 0));
        add.setFont(new Font("Times New Roman", 0, 10));
        add.setBounds(elem.getWidth(), 0, 50, addElemPanel.getHeight());
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int x = Integer.parseInt(elem.getText());
                    if (!array.equals("{}")){
                        array = array.substring(0, array.length()-1) + ", }";
                    }
                    array = array.substring(0, array.length()-1) + elem.getText() + "}";
                    strArr.setText(array);
                    elem.setText("");
                }catch(NumberFormatException NF){
                    JOptionPane.showMessageDialog(null, "Введите целое число в верном формате");
                }
            }
        });
        addElemPanel.add(add);

        String[] sorts = {
                "Selection sort",
                "Gnome sort",
                "Cocktail sort",
                "Quick sort",
                "Comb sort"
        };
        JComboBox sort = new JComboBox(sorts);
        sort.setBounds(0,0, changeSort.getWidth(), changeSort.getHeight());
        changeSort.add(sort);

        JButton del = new JButton("Удалить");
        del.setMargin(new Insets(0, 0, 0, 0));
        del.setFont(new Font("Times New Roman", 0, 10));
        del.setBounds(0, 0, butDel.getWidth()/2, 30);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] sp = array.split(", ");
                array = sp[0];
                for(int i = 1; i < sp.length-1; i++){
                    array += ", " + sp[i];
                }
                if (sp.length > 1) {
                    array += "}";
                }
                strArr.setText(array);
            }
        });
        butDel.add(del);

        JButton delAll = new JButton("Очистить");
        delAll.setMargin(new Insets(0, 0, 0, 0));
        delAll.setFont(new Font("Times New Roman", 0, 10));
        delAll.setBounds((int)butDel.getWidth()/2, 0, butDel.getWidth()/2, 30);
        delAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                array ="{}";
                strArr.setText(array);
            }
        });
        butDel.add(delAll);

        JButton useSort = new JButton("Сортировать");
        useSort.setBounds(wind.getWidth()/2, wind.getHeight() - 56, wind.getWidth()/2, 30);
        useSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!array.equals("{}")){
                    array = array.substring(1, array.length()-1);
                    String[] split = array.split(", ");
                    int[] arr = new int[split.length];
                    for(int i = 0; i < arr.length; i++){
                    arr[i] = Integer.parseInt(split[i]);
                }
                    switch (sorts[sort.getSelectedIndex()]){
                    case "Cocktail sort": cocktailSort(arr);
                        break;
                    case "Selection sort": selectionSort(arr);
                        break;
                    case "Gnome sort": gnomeSort(arr);
                        break;
                    case "Quick sort": quickSort(arr);
                        break;
                    case "Comb sort": combSort(arr);
                        break;
                }
                    array = "";
                    for (int i = 0; i < arr.length - 1; i++){
                        array += arr[i] + ", ";
                    }
                    array = "{" + array + arr[arr.length-1]+"}";
                    strArr.setText(array);
                }
            }
        });

        wind.getContentPane().add(addElemPanel);
        wind.getContentPane().add(changeSort);
        wind.getContentPane().add(scroll);
        wind.getContentPane().add(useSort);
        wind.getContentPane().add(butDel);
        wind.setVisible(true);
    }

    public static void main(String[] args) {
        window();
    }
}
