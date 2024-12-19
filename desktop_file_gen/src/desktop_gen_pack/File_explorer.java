package desktop_gen_pack;

import java.io.File;

import javax.swing.JFileChooser;

public class File_explorer {
    
    public static String select_file() {

        JFileChooser file_selector = new JFileChooser();
        file_selector.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = file_selector.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            
            File selected_file = file_selector.getSelectedFile();

            return selected_file.getAbsolutePath();


        } else {
            return null;
        }

    }





}
