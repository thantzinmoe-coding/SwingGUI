import CheckPassword.passwordCheck;
import Controller.UserController;
import Hash.PasswordHasher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

import Model.UserModel;

public class GUIAccCreate {
    private JLabel userLst;
    private JPasswordField Pass;
    private JPasswordField conPass;
    private JTextField txtPhNo;
    private JButton btnCancel;
    private JButton btnSignUp;
    private JPanel SignUp;
    private JTextField txtName;
    private JFrame frame;


//    public Object User = new Object(){
//        private String name = txtName.toString().trim();
//        private String phNo = txtPhNo.toString().trim();
//        private String Password = Pass.toString();
//        private String ConfirmPassword = conPass.toString();
//    };
    public void ClearControls()
    {
        txtName.setText("");
        txtPhNo.setText("");
        Pass.setText("");
        conPass.setText("");
        txtName.requestFocus();
    }
    public void ClearPassword()
    {
        Pass.setText("");
        conPass.setText("");
        Pass.requestFocus();
    }

    public GUIAccCreate() {
        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 370));
        frame.setResizable(false);
        frame.add(SignUp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearControls();
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                passwordCheck check = new passwordCheck();
                String hashedPassword = "";
                byte[] salt = PasswordHasher.generateSalt();
                String SaltBase64 = Base64.getEncoder().encodeToString(salt);
                UserModel userModel = new UserModel();
                try {
                    hashedPassword = PasswordHasher.hashPassword(String.valueOf(Pass.getText()), salt);
                } catch (NoSuchAlgorithmException e)
                {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                }
                if (Objects.equals(txtName.getText(), ""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter your Name!");
                    txtName.requestFocus();
                }
                else if (Objects.equals(txtPhNo.getText(), ""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter your Phone No!");
                    txtPhNo.requestFocus();
                }
                else if (Objects.equals(Pass.toString(), ""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter your Password!");
                    Pass.requestFocus();
                }
                else if (Objects.equals(conPass.toString(), ""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter confirm Password!");
                    conPass.requestFocus();
                } else if (!check.isValidPassword(Pass.getText())) {
                    ClearPassword();
                } else if (!Pass.getText().equals(conPass.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    ClearPassword();
                }
                else{

//                    ps.setString(1, txtName.getText());
//                    ps.setString(2, txtPhNo.getText());
//                    ps.setString(3, hashedPassword);
//                    ps.setBigDecimal(4, BigDecimal.valueOf(0));

                    userModel.setName(txtName.getText());
                    userModel.setPhoneNo(txtPhNo.getText());
                    userModel.setPassword(hashedPassword);
                    userModel.setAmount(BigDecimal.valueOf(0));
                    userModel.setSalt(SaltBase64);

                    UserController userController = new UserController();
                    userController.CreateUser(userModel);
                    ClearControls();
                }
//
//                System.out.println("Text Name "+txtName.getText());
//                System.out.println("Phone number "+txtPhNo.getText());

//                System.out.println("Text Name "+txtName.getText());
//                System.out.println("Phone number "+txtPhNo.getText());
//                System.out.println("Password "+Pass.getText());
//                System.out.println("Password "+conPass.getText());
//                System.out.println("Hashed password "+hashedPassword);

            }
        });
    }
}
