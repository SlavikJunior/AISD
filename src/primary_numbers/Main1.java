package primary_numbers;

public class Main1 {

    public static void main(String[] args) {


    }

    public static int cntOfPrimeNumbers(int diapason) {
        boolean[] primeNumbers = new boolean[diapason];
        for (int i = 2; i < diapason; i++) {
            if (isPrimeNumber(i)) {
                primeNumbers[i] = true;
                for (int j = i * i; j < diapason; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < diapason; i++) {
            if (primeNumbers[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }


    public static boolean isPrimeNumber(int n) {
        n = Math.abs(n);

        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int delitel = 3; delitel < Math.sqrt(n) + 1; delitel+=2) {
            if (n % delitel == 0) {
                return false;
            }
        }
        return true;
    }

    public static int cntOfPrimeNumberOnSegment(int a, int b) {
        int cnt = 0;
        for (int i = a; i <= b ; i++) {
            if (isPrimeNumber(i)) cnt ++;
        }
        return cnt;
    }
}
