package com.example.prodigy_sd_01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    private JTextField tempInput;
    private JComboBox<String> unitInput;
    private JLabel resultCelsius;
    private JLabel resultFahrenheit;
    private JLabel resultKelvin;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel tempLabel = new JLabel("Enter Temperature:");
        tempLabel.setBounds(50, 30, 150, 25);
        add(tempLabel);

        tempInput = new JTextField();
        tempInput.setBounds(200, 30, 100, 25);
        add(tempInput);

        JLabel unitLabel = new JLabel("Select Unit:");
        unitLabel.setBounds(50, 70, 150, 25);
        add(unitLabel);

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        unitInput = new JComboBox<>(units);
        unitInput.setBounds(200, 70, 100, 25);
        add(unitInput);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 110, 100, 25);
        add(convertButton);

        resultCelsius = new JLabel("Celsius: ");
        resultCelsius.setBounds(50, 150, 300, 25);
        add(resultCelsius);

        resultFahrenheit = new JLabel("Fahrenheit: ");
        resultFahrenheit.setBounds(50, 180, 300, 25);
        add(resultFahrenheit);

        resultKelvin = new JLabel("Kelvin: ");
        resultKelvin.setBounds(50, 210, 300, 25);
        add(resultKelvin);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperature = Double.parseDouble(tempInput.getText());
                    String unit = (String) unitInput.getSelectedItem();
                    convertTemperature(temperature, unit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
    }

    private void convertTemperature(double temperature, String unit) {
        double celsius = 0, fahrenheit = 0, kelvin = 0;

        if (unit.equals("Celsius")) {
            celsius = temperature;
            fahrenheit = (temperature * 9/5) + 32;
            kelvin = temperature + 273.15;
        } else if (unit.equals("Fahrenheit")) {
            celsius = (temperature - 32) * 5/9;
            fahrenheit = temperature;
            kelvin = celsius + 273.15;
        } else if (unit.equals("Kelvin")) {
            celsius = temperature - 273.15;
            fahrenheit = (celsius * 9/5) + 32;
            kelvin = temperature;
        }

        resultCelsius.setText(String.format("Celsius: %.2f", celsius));
        resultFahrenheit.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        resultKelvin.setText(String.format("Kelvin: %.2f", kelvin));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}