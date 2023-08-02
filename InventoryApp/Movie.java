import java.util.ArrayList;

class Movie {
    private int year;                      // Private field to store the year of the movie
    private String title;                  // Private field to store the title of the movie
    private String genre;                  // Private field to store the genre of the movie
    private String director;               // Private field to store the director of the movie
    private ArrayList<Actor> actors;       // Private field to store the list of actors in the movie

    // Constructor to initialize the Movie object with provided values
    public Movie(int year, String title, String genre, String director, ArrayList<Actor> actors) {
        this.year = year;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
    }
    public Movie(){
        this.setYear(0);
        this.setTitle(null);
        this.setGenre(null);
        this.setDirector(null);
        this.setActors(null);
    }
    public Movie(Movie movie){
        this.setYear(movie.getYear());
        this.setTitle(movie.getTitle());
        this.setGenre(movie.getGenre());
        this.setDirector(movie.getDirector());
        this.setActors(movie.actors);
    }

    // Getter method to retrieve the year of the movie
    public int getYear() {
        return year;
    }

    // Setter method to set the year of the movie
    public void setYear(int year) {
        this.year = year;
    }

    // Getter method to retrieve the title of the movie
    public String getTitle() {
        return title;
    }

    // Setter method to set the title of the movie
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method to retrieve the genre of the movie
    public String getGenre() {
        return genre;
    }

    // Setter method to set the genre of the movie
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter method to retrieve the director of the movie
    public String getDirector() {
        return director;
    }

    // Setter method to set the director of the movie
    public void setDirector(String director) {
        this.director = director;
    }

    // Getter method to retrieve the list of actors in the movie
    public ArrayList<Actor> getActors() {
        return actors;
    }

    // Setter method to set the list of actors in the movie
    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    // Override toString() method to provide a string representation of the Movie object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Year: ").append(year).append("\n");          // Append year information
        sb.append("Title: ").append(title).append("\n");        // Append title information
        sb.append("Genre: ").append(genre).append("\n");        // Append genre information
        sb.append("Director: ").append(director).append("\n");  // Append director information
        sb.append("Actors:\n");                                 // Append actors information

        // Loop through each actor and append their information with indentation
        for (Actor actor : actors) {
            sb.append("\t").append(actor.toString()).append("\n");
        }
        return sb.toString();
    }
}
