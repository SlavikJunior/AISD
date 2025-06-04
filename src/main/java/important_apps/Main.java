package important_apps;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int M = 30;

    public static void main(String[] args) {

        List<String> lines = reading(Paths.get("src/main/java/important_apps/Applications.txt"));
        List<Application> apps = getListOfApplications(lines);
        apps.sort((a1, a2) -> Double.compare(a1.getRatio(), a2.getRatio()) * - 1); // сортировка в обратном порядке
        System.out.println(apps);

        List<String> selectedApps = optimalDownloading(apps);
        System.out.println(selectedApps);
    }

    public static List<String> optimalDownloading(List<Application> sortedApps) {
        List<String> selectedApps = new ArrayList<>();
        double totalSize = 0.0, totalValue = 0.0;
        for (Application app : sortedApps) {
            if (totalSize >= M)
                break;
            double freeSpace = M - totalSize;
            double takenSize = Math.min(freeSpace, app.getSize());
            double takenValue = takenSize * app.getRatio();

            if (takenSize > 0) {
                selectedApps.add(String.format(
                        "%s (%.2f MB из %d MB, полезность: %.2f)",
                        app.getName(), takenSize, app.getSize(), takenValue
                ));
            }

            totalSize += takenSize;
            totalValue += takenValue;
        }

        selectedApps.add("Суммарная полезность: " + totalValue);
        return selectedApps;
    }

    public static List<Application> getListOfApplications(List<String> lines) {
        List<Application> apps = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            String[] parts = line.split(",");
            Application app = new Application(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            apps.add(app);
        }
        return apps;
    }

    public static List<String> reading(Path path) {
        List<String> result;
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
