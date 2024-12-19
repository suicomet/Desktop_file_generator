package desktop_gen_pack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main_gui implements ActionListener {

    private static JLabel welcome_text;
    private static JLabel name_label;
    private static JTextField name_textfield;
    private static JLabel comment_label;
    private static JTextField comment_textfield;
    private static JLabel icon_path_label;
    private static JButton icon_path_btn;
    private static JTextField icon_path_textfield;
    private static JLabel exec_path_label;
    private static JButton exec_path_btn;
    private static JTextField exec_path_textfield;
    private static JLabel categories_label;
    private static String cat_list [] = {"AudioVideo", "Application", "Game", "Graphics", "Office", "Other", "Utility"};
    private static JComboBox categories_drop_menu;
    private static JButton generate_btn;
    private static String succ_msg;
    private static String fail_msg;
    private static final int FONT_SIZE_LABEL = 20;
    private static final int FONT_CENTER_LABEL = 1;
    private static final String FONT_NAME_LABEL = "Dialog";

    public static void main(String[] args) throws Exception {
        
        JFrame window = new JFrame("Desktop file generator");
        JPanel panel = new JPanel();
        window.setSize(500, 540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        panel.setLayout(null);

        welcome_text = new JLabel("Desktop file generator");
        welcome_text.setBounds(40, 40, 420, 30);
        welcome_text.setFont(new Font(FONT_NAME_LABEL, 1, 24));
        welcome_text.setHorizontalAlignment(0); // 0 is center 
        panel.add(welcome_text);

        name_label = new JLabel("Name:");
        name_label.setBounds(20, 120, 100, 30);
        name_label.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        name_label.setHorizontalAlignment(0);
        panel.add(name_label);

        name_textfield = new JTextField();
        name_textfield.setBounds(150, 125, 330, 25);
        panel.add(name_textfield);

        comment_label = new JLabel("Comment:");
        comment_label.setBounds(20, 200, 110, 30);
        comment_label.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        comment_label.setHorizontalAlignment(0);
        panel.add(comment_label);

        comment_textfield = new JTextField();
        comment_textfield.setBounds(150, 200, 330, 25); // 480x
        panel.add(comment_textfield);
        
        icon_path_label = new JLabel("Icon Path:");
        icon_path_label.setBounds(20, 280, 120, 30);
        icon_path_label.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        icon_path_label.setHorizontalAlignment(0);
        panel.add(icon_path_label);

        icon_path_btn = new JButton("...");
        icon_path_btn.setBounds(150, 280, 50, 25);
        icon_path_btn.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        icon_path_btn.addActionListener(new Main_gui());
        panel.add(icon_path_btn);

        icon_path_textfield = new JTextField();
        icon_path_textfield.setBounds(220, 280, 260, 25);
        panel.add(icon_path_textfield);

        exec_path_label = new JLabel("Exec Path:");
        exec_path_label.setBounds(20, 360, 120, 30);
        exec_path_label.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        exec_path_label.setHorizontalAlignment(0);
        panel.add(exec_path_label);

        exec_path_btn = new JButton("...");
        exec_path_btn.setBounds(150, 360, 50, 25);
        exec_path_btn.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        exec_path_btn.addActionListener(new Main_gui());
        panel.add(exec_path_btn);
        
        exec_path_textfield = new JTextField();
        exec_path_textfield.setBounds(220, 360, 260, 25);
        panel.add(exec_path_textfield);
        
        categories_label = new JLabel("Categories:");
        categories_label.setBounds(18, 420, 120, 30);
        categories_label.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        categories_label.setHorizontalAlignment(0);
        panel.add(categories_label);

        categories_drop_menu = new JComboBox<>(cat_list);
        categories_drop_menu.setBounds(150, 420, 260, 25);
        panel.add(categories_drop_menu);
        
        generate_btn = new JButton("Generate");
        generate_btn.setBounds(150, 480, 200, 25);
        generate_btn.setFont(new Font(FONT_NAME_LABEL, FONT_CENTER_LABEL, FONT_SIZE_LABEL));
        generate_btn.addActionListener(new Main_gui());
        panel.add(generate_btn);


        window.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == icon_path_btn) {
            String file_path_icon = File_explorer.select_file();

            if (file_path_icon != null) {
                icon_path_textfield.setText(file_path_icon);
                icon_path_textfield.setEditable(false);
            }else{
                ;
            }
            
        }
        

        if (e.getSource() == exec_path_btn) {
            String file_path_exec = File_explorer.select_file();

            if (file_path_exec != null) {
                exec_path_textfield.setText(file_path_exec);
                exec_path_textfield.setEditable(false);
            }else{
                ;
            }
            
        }
        
        if (e.getSource() == generate_btn) {
            String name = name_textfield.getText();
            String comment = comment_textfield.getText();
            String exec = exec_path_textfield.getText();
            String icon = icon_path_textfield.getText();
            String type = String.valueOf(categories_drop_menu.getSelectedItem());

            Desktop_file_gen.create_desktop_file(name, comment, exec, icon, type);


        } else {
            
        }
    }
}
