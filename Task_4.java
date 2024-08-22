package codsoft;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task_4 extends JFrame {
    private JComboBox<String> baseCurrencyCombo;
    private JComboBox<String> targetCurrencyCombo;
    private JTextField amountInput;
    private JLabel resultLabel;

    public Task_4() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY", "AUD", "CAD"};

        baseCurrencyCombo = new JComboBox<>(currencies);
        targetCurrencyCombo = new JComboBox<>(currencies);
        amountInput = new JTextField();
        resultLabel = new JLabel("Converted amount: ");

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(new JLabel("Base Currency:"));
        add(baseCurrencyCombo);
        add(new JLabel("Target Currency:"));
        add(targetCurrencyCombo);
        add(new JLabel("Amount:"));
        add(amountInput);
        add(new JLabel(""));
        add(convertButton);
        add(new JLabel(""));
        add(resultLabel);
    }

    private void convertCurrency() {
        String baseCurrency = (String) baseCurrencyCombo.getSelectedItem();
        String targetCurrency = (String) targetCurrencyCombo.getSelectedItem();
        String amountText = amountInput.getText();

        try {
            double amount = Double.parseDouble(amountText);
            double rate = fetchExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * rate;
            resultLabel.setText("Converted amount: " + String.format("%.2f", convertedAmount) + " " + targetCurrency);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid amount.");
        } catch (Exception e) {
            resultLabel.setText("Error fetching exchange rate.");
        }
    }

    private double fetchExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();


        String json = content.toString();
        String search = "\"" + targetCurrency + "\":";
        int startIndex = json.indexOf(search);
        if (startIndex == -1) {
            throw new Exception("Currency not found");
        }

        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = json.indexOf("}", startIndex);
        }

        String rateStr = json.substring(startIndex + search.length(), endIndex).trim();
        return Double.parseDouble(rateStr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task_4().setVisible(true);
            }
        });
    }
}
