package numbersystem;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class numberSystemController {


    @FXML  private RadioButton fromBinaryRadioButton;

    @FXML  private ToggleGroup fromToggleGroup;

    @FXML  private RadioButton fromOctalRadioButton;

    @FXML  private RadioButton fromDecimalRadioButton;

    @FXML  private RadioButton fromHexadecimalRadioButton;

    @FXML  private RadioButton toBinaryRadioButton;

    @FXML  private ToggleGroup toToggleGroup;

    @FXML  private RadioButton toOctalRadioButton;

    @FXML  private RadioButton toDecimalRadioButton;

    @FXML  private RadioButton toHexadecimalRadioButton;

    @FXML  private TextField textField;

    @FXML  private TextArea resultField;

    @FXML  private Button convertButton;

    @FXML  private RadioButton ASCIIToChar;

    @FXML  private ToggleGroup ASCII;

    @FXML  private RadioButton charToASCII;

    @FXML  private Button clearButton;

    @FXML  private Button ASCIIConvertButton;


    private int counter = 0;



    @FXML
    void ASCIIConvertButtonPressed(ActionEvent event) {
        try {
            counter++;

            if(counter >= 2)
            {
                resultField.setText("");
            }

            ASCIIToChar.setToggleGroup(ASCII);
            charToASCII.setToggleGroup(ASCII);

            String inputField = textField.getText();


            ASCII_Char ascii = new ASCII_Char(inputField);


            ASCIIConvertButton.setDefaultButton(true);
            if (charToASCII.isSelected())
            {
                resultField.appendText(ascii.char_ascii());
            }
            if (ASCIIToChar.isSelected())
            {
                resultField.appendText(ascii.ascii_char());
            }

        }catch (NumberFormatException e)
        {
            textField.requestFocus();
        }

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        resultField.clear();
    }










    @FXML
    void convertButtonPressed(ActionEvent event) {
        counter++;

        if(counter >= 2)
        {
            resultField.setText("");
        }


        try {
            convertButton.setDefaultButton(true);
            String inputField = textField.getText();
            numberSystemConverter method = new numberSystemConverter(inputField);


            fromBinaryRadioButton.setToggleGroup(fromToggleGroup);
            toHexadecimalRadioButton.setToggleGroup(toToggleGroup);

            // Binary Input Conversion.
            if (fromBinaryRadioButton.isSelected())
            {
                if (toBinaryRadioButton.isSelected())
                {
                    resultField.setText("Please Choose other option from the TO/FROM radio buttons!!!");
                    textField.requestFocus();
                    textField.clear();
                }
                if (toDecimalRadioButton.isSelected())
                {
                    resultField.appendText(String.valueOf(method.binaryToDecimal()));
                }
                if (toOctalRadioButton.isSelected())
                {
                    resultField.appendText(String.valueOf(method.binaryToOctal()));
                }

                if (toHexadecimalRadioButton.isSelected())
                {
                    resultField.appendText(String.valueOf(method.binaryToHexadecimal()));
                }
            }

            // Octal Input Conversion.
            else if(fromOctalRadioButton.isSelected())
            {
                if (toBinaryRadioButton.isSelected())
                {
                    resultField.setText(method.octalToBinary());
                }
                else if (toOctalRadioButton.isSelected())
                {
                    resultField.setText("Please Choose other option from the TO/FROM radio buttons!!!");
                    textField.requestFocus();
                    textField.clear();
                }
                else if (toDecimalRadioButton.isSelected())
                {
                    resultField.setText(method.octalToDecimal());
                }
                else if (toHexadecimalRadioButton.isSelected())
                {
                    resultField.setText(method.octalToHexadecimal());
                }
            }

            // Decimal Input Coversion.
            else if (fromDecimalRadioButton.isSelected())
            {
                if (toBinaryRadioButton.isSelected())
                {
                    resultField.setText(method.decimalToBinary());
                }
                else if (toOctalRadioButton.isSelected())
                {
                    resultField.setText(method.decimalToOctal());
                }
                else if (toDecimalRadioButton.isSelected())
                {
                    resultField.setText("Please Choose other option from the TO/FROM radio buttons!!!");
                    textField.requestFocus();
                    textField.clear();
                }
                else if (toHexadecimalRadioButton.isSelected())
                {
                    resultField.setText(method.decimalToHexadecimal());
                }
            }

            // Hexadecimal Input Conversion.
            else if (fromHexadecimalRadioButton.isSelected())
            {
                if (toBinaryRadioButton.isSelected())
                {
                    resultField.setText(method.hexadecimalToBinary());
                }
                else if (toOctalRadioButton.isSelected())
                {
                    resultField.setText(method.hexadecimalToOctal());
                }
                else if (toDecimalRadioButton.isSelected())
                {
                    resultField.setText(method.hexadecimalToDecimal());
                }
                else if (toHexadecimalRadioButton.isSelected())
                {
                    resultField.setText("Please Choose other option from the TO/FROM radio buttons!!!");
                    textField.requestFocus();
                    textField.clear();
                }
            }

        } catch (NumberFormatException e)
        {
            textField.requestFocus();
        }
    }



    @FXML
    void fromRadioButtonSelected(ActionEvent event) {

    }

    @FXML
    void toRadioButtonSelected(ActionEvent event) {

    }

    @FXML
    void charToASCIISelected(ActionEvent event) {

    }


}
