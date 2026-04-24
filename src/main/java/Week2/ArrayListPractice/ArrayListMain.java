package Week2.ArrayListPractice;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> topMovies = new ArrayList<>();

        topMovies.add("Sinners");
        topMovies.add("Project Hail Mary");
        topMovies.add("Dune 2");

        System.out.println(topMovies);

        topMovies.add("Lord Of The Rings");
        topMovies.add("Good Will Hunting");

        System.out.println(topMovies);
        topMovies.add("Shawshank Redemption");
        topMovies.add("Over The Hedge");
        System.out.println(topMovies);

        topMovies.add("Kill Bill 1 & 2");
        topMovies.add("Oceans 11");
        topMovies.add("Iron Lung");

        //we are starting to have a lot of extra
        //space in the internal array
        //tradeoff: space (memory) vs. speed
        System.out.println(topMovies);
        topMovies.add("Ratatouille");
        System.out.println(topMovies);

        System.out.println("Second favorite movie is: " +
                topMovies.get(1));

        topMovies.set(1, "The Martian");

        System.out.println("Second favorite movie is: " +
                topMovies.get(1));
        System.out.println(topMovies);

        System.out.println(topMovies.contains("Shawshank Redemption"));
        System.out.println(topMovies.contains("Green Mile"));

        topMovies.clear();

        System.out.println(topMovies.contains("Shawshank Redemption"));
        System.out.println(topMovies.size());
        System.out.println(topMovies);
    }
}
