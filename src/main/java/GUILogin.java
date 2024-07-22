import Controller.UserController;
import Model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.UserController.UserLogin;

public class GUILogin {
    private JLabel userLst;
    private JPasswordField Password;
    private JTextField txtPhNo;
    private JButton btnCancel;
    private JButton btnLogin;
    private JPanel Login;
    private JFrame frame;

    public void ClearControls()
    {
        txtPhNo.setText("");
        Password.setText("");
        txtPhNo.requestFocus();
    }

    public GUILogin() {

        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 350));
        frame.add(Login);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearControls();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel user = new UserModel();
                user.setPhoneNo(txtPhNo.getText());
                user.setPassword(Password.getText());

                boolean isValid = UserLogin(user.getPhoneNo(), user.getPassword());
                String result = isValid ? "Login Successful" : "Login Failed";
                JOptionPane.showMessageDialog(frame, result);
                ClearControls();
            }
        });
    }
}
