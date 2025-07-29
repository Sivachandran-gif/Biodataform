import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataForm extends JFrame 
{
    
private JTextField nameField, ageField, emailField, regNumberField, addressField;
private JComboBox genderComboBox;
private JTextArea displayArea;

public BiodataForm() 
{
setTitle("Biodata Form");
setSize(500, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(7, 2, 10, 10)); 

JLabel regNumberLabel = new JLabel("Reg Number:");
regNumberField = new JTextField(10);

JLabel nameLabel = new JLabel("Name:");
nameField = new JTextField(20);

JLabel ageLabel = new JLabel("Age:");
ageField = new JTextField(5);

JLabel emailLabel = new JLabel("Email:");
emailField = new JTextField(20);

JLabel genderLabel = new JLabel("Gender:");
genderComboBox = new JComboBox(new String[]{"Select", "Male", "Female", "Other"});

JLabel addressLabel = new JLabel("Address:");
addressField = new JTextField(30);

JButton submitButton = new JButton("Submit");
displayArea = new JTextArea(7, 30);
displayArea.setEditable(false);

        
add(regNumberLabel);
add(regNumberField);
add(nameLabel);
add(nameField);
add(ageLabel);
add(ageField);
add(emailLabel);
add(emailField);
add(genderLabel);
add(genderComboBox);
add(addressLabel);
add(addressField);
add(submitButton);
add(new JScrollPane(displayArea)); 

    
submitButton.addActionListener(new ActionListener() 
{
            
public void actionPerformed(ActionEvent e) 
{
handleSubmit();
}
});
}

private void handleSubmit() 
{
        
String name = nameField.getText().trim();
String ageText = ageField.getText().trim();
String email = emailField.getText().trim();
String regNumber = regNumberField.getText().trim();
String gender = (String) genderComboBox.getSelectedItem();
String address = addressField.getText().trim();

if (name.isEmpty() || ageText.isEmpty() || email.isEmpty() || regNumber.isEmpty() || gender.equals("Select") || address.isEmpty()) 
{

JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
return;
        
}

int age;
try 

{

age = Integer.parseInt(ageText);
if (age <= 18) 

{
                
throw new NumberFormatException(); 

}
} 

catch (NumberFormatException e) 

{
            
JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Input Error", JOptionPane.ERROR_MESSAGE);
return;
        
}

displayArea.setText("Reg Number: " + regNumber + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email +"\nGender: " + gender + "\nAddress: " + address);

    
nameField.setText("");
ageField.setText("");
emailField.setText("");
regNumberField.setText("");
genderComboBox.setSelectedIndex(0);
addressField.setText("");
    
}
public static void main(String arg[])
{
BiodataForm form = new BiodataForm();
form.setVisible(true);
}
}

