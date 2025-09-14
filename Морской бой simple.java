import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SimpleDotTest {
    public static void main(String[] args) {
        int numofGuesses = 0;
        SimpleDot d = new SimpleDot();
        int random = (int) (Math.random() * 5);
        SayWhere helper = new SayWhere();
        int[] locs = {random, random+1, random + 2};
        d.setLocationCells(locs);
        boolean AreUwinning = false;
        while (AreUwinning == false) {
            numofGuesses++;
            String Userguess = helper.inputus("Введите число");
            String result = d.checkYourself(Userguess);
            if (result == "GG") {
                AreUwinning = true;
                System.out.println("Понадобилось " + numofGuesses + " попытОчки(чек your mom)");

            }

        }
    }


    static class SimpleDot {
        int[] locationCells;
        int Hits = 0;

        public void setLocationCells(int[] locs) {
            locationCells = locs;
        }

        public String checkYourself(String stringGuess) {
            int guess = Integer.parseInt(stringGuess);
            String result = "Ne popal";
            for (int cell : locationCells) {
                if (guess == cell) {
                    Hits++;
                    result = "Popal";
                    break;
                }
            }
            if (Hits == locationCells.length) {
                result = "GG";
            }
            System.out.println(result);
            return result;
        }
    }
}
class SayWhere{
    public String inputus(String prompt){
        String inputline = null;
        System.out.print(prompt+" ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputline = is.readLine();
            if (inputline.length()==0) return null;
        } catch (IOException e){
            System.out.println("IOExeption: "+ e);
        }
        return inputline;

    }
}

