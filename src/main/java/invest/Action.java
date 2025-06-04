package invest;

public class Action {

    private String company;
    private int price;
    private int profit;

    public Action(String company, int price, int profit) {
        this.company = company;
        this.price = price;
        this.profit = profit;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getProfit() {
        return profit;
    }
}
