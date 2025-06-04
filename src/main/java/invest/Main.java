package invest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Action> actions = getActions("src/main/java/invest/4_2_data.csv");

    }

    private static List<Action> getActions(String filePath) {
        List<Action> res = null;
        try (BufferedReader raeader = new BufferedReader(new FileReader(filePath))) {
             res = new ArrayList<>();
            String line;
            while((line = raeader.readLine()) != null) {
                String[] p = line.split(",");
                res.add(new Action(p[0], Integer.parseInt(p[1]),Integer.parseInt(p[2])));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }

        return res;
    }
}
