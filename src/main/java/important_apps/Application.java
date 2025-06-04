package important_apps;

public class Application implements Comparable<Application> {

    private String name;
    private int value;
    private int size;
    private double ratio;
    private double downloadedPart;

    public Application(String name, int value, int size) {
        this.name = name;
        this.value = value;
        this.size = size;
        ratio = (double) value / size;
        downloadedPart = 100.0;
    }

    public double getRatio() {
        return ratio;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + "(Value:c" + value + ", Size: " + size +
                " MB, Ratio: " + String.format("%.2f", ratio) +
                ", DownloadedPart: " + String.format("%.2f", downloadedPart) + ")";
    }

    @Override
    public int compareTo(Application o) {
        double delta = ratio - o.ratio;
        double e = 0.000001;
        if (delta > 0)
            return 1;
        else if (delta < 0)
            return - 1;
        else {
            if (delta > e)
                return 1;
            else if (delta < e)
                return - 1;
            else
                return 0;
        }
    }
}
