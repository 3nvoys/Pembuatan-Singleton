import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie {
    String title;
    String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

class MovieDatabase {
    private static MovieDatabase instance = null;
    private List<Movie> movies;

    private MovieDatabase() {
        movies = new ArrayList<>();
    }

    public static MovieDatabase getInstance() {
        if (instance == null) {
            instance = new MovieDatabase();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> sortMoviesByGenre() {
        Collections.sort(movies, Comparator.comparing(movie -> movie.genre));
        return movies;
    }
}

public class Main {
    public static void main(String[] args) {
        MovieDatabase db = MovieDatabase.getInstance();


        db.addMovie(new Movie("Finding Nemo", "Animation"));
        db.addMovie(new Movie("The Sixth Sense", "Mystery"));
        db.addMovie(new Movie("The Lion King", "Animation"));
        db.addMovie(new Movie("The Godfather Part II", "Crime"));
        db.addMovie(new Movie("Ghostbusters", "Comedy"));
        db.addMovie(new Movie("The Exorcist", "Horror"));
        db.addMovie(new Movie("Groundhog Day", "Comedy"));
        db.addMovie(new Movie("The Princess Bride", "Adventure"));
        db.addMovie(new Movie("Braveheart", "Biography"));


        List<Movie> sortedMovies = db.sortMoviesByGenre();
        for (Movie movie : sortedMovies) {
            System.out.println(movie);
        }
    }
}
