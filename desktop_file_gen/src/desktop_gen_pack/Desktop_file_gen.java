package desktop_gen_pack;

import java.io.FileWriter;

public class Desktop_file_gen {
    private static String name_app;
    private static String comment_app;
    private static String icon_path = "";
    private static String exec_path;
    private static String type_app;
    
    public static void create_desktop_file(String name, String comment, String exec, String icon, String type ) {
        
        name_app = name;
        comment_app = comment;
        exec_path = exec;
        icon_path = icon;
        type_app = type;


        String desktop_file_contents = """
                [Desktop Entry]
                Encoding=UTF-8
                Name=%s
                Comment=%s
                Icon=%s 
                Exec=%s
                Terminal=false
                Type=%s
                """.formatted(name_app, comment_app, icon_path, exec_path, type_app);
                  
        
        
        String desktop_file_path = System.getProperty("user.home") + "/Desktop/" + name_app + ".desktop";
        


        try {
            FileWriter writer = new FileWriter(desktop_file_path);
            writer.write(desktop_file_contents);
            writer.close();

            Process process = Runtime.getRuntime().exec("chmod +x" + desktop_file_path);
            process.waitFor();

            System.out.println("Desktop file created succesfully at: " + desktop_file_path);
        } catch (Exception e) {
            System.err.println("error message while creating file: " + e.getMessage());
        }
    }



}
