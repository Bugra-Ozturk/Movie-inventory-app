import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmInventoryApp {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();

        try {
            FileReader fileReader = new FileReader("C:\\Users\\Buğra Öztürk\\Desktop\\bilgiler.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",", 5);

                int year = Integer.parseInt(tokens[0]);
                String title = tokens[1].trim();
                String genre = tokens[2].trim();
                String director = tokens[3].trim();
                String[] actorTokens = tokens[4].substring(1).split("\\)\\(");

                ArrayList<Actor> actors = new ArrayList<>();
                for (String actorToken : actorTokens) {
                    String[] actorData = actorToken.split(",");
                    String fullName = actorData[0].trim();
                    String gender = actorData[1].trim();
                    String citizenship = actorData[2].trim();

                    actors.add(new Actor(fullName, gender, citizenship));
                }

                Movie movie = new Movie(year, title, genre, director, actors);
                movieList.addMovie(movie);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start a loop to present options to the user
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("\nFilm Inventory Application");
            System.out.println("------------------------");
            System.out.println("1) Read information from file");
            System.out.println("2) Add a movie");
            System.out.println("3) View movie details");
            System.out.println("4) Delete a movie");
            System.out.println("5) Print all records from head");
            System.out.println("6) Print all records from tail");
            System.out.println("7) Print movies before 2000");
            System.out.println("8) Exit");

            System.out.print("Make your selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the empty line

            switch (choice) {
                case 1:
                    // Read information from the file
                    System.out.println("Reading information from the file...");
                    movieList = new DoublyLinkedList();

                    try {
                        FileReader fileReader = new FileReader("C:\\Users\\Buğra Öztürk\\Desktop\\bilgiler.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        String fileLine;
                        while ((fileLine = bufferedReader.readLine()) != null) {
                            String[] tokens = fileLine.split(",", 5);

                            int year = Integer.parseInt(tokens[0]);
                            String title = tokens[1].trim();
                            String genre = tokens[2].trim();
                            String director = tokens[3].trim();
                            String[] actorTokens = tokens[4].substring(1).split("\\)\\(");

                            ArrayList<Actor> actors = new ArrayList<>();
                            for (String actorToken : actorTokens) {
                                String[] actorData = actorToken.split(",");
                                String fullName = actorData[0].trim();
                                String gender = actorData[1].trim();
                                String citizenship = actorData[2].trim();

                                actors.add(new Actor(fullName, gender, citizenship));
                            }

                            Movie movie = new Movie(year, title, genre, director, actors);
                            movieList.addMovie(movie);
                        }

                        bufferedReader.close();
                        System.out.println("Information read successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Add a movie
                    System.out.println("Enter movie details:");
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Read the empty line

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Director: ");
                    String director = scanner.nextLine();

                    System.out.print("Actors (Full Name, Gender, Citizenship): ");
                    String actorInput = scanner.nextLine();
                    String[] actorTokens = actorInput.split("\\),\\(");

                    ArrayList<Actor> actors = new ArrayList<>();
                    for (String actorToken : actorTokens) {
                        String[] actorData = actorToken.split(",");
                        String fullName = actorData[0].trim();
                        String gender = actorData[1].trim();
                        String citizenship = actorData[2].trim();

                        actors.add(new Actor(fullName, gender, citizenship));
                    }

                    Movie newMovie = new Movie(year, title, genre, director, actors);
                    movieList.addMovie(newMovie);
                    System.out.println("Movie added successfully.");
                    break;

                case 3:
                    // View movie details
                    System.out.println("Enter the title of the movie to view: ");
                    String movieTitle = scanner.nextLine();

                    Movie requestedMovie = movieList.getMovieByTitle(movieTitle);
                    if (requestedMovie != null) {
                        System.out.println(requestedMovie.toString());
                    } else {
                        System.out.println("No movie found with the specified title.");
                    }
                    break;

                case 4:
                    // Delete a movie
                    System.out.println("Enter the title of the movie to delete: ");
                    String movieTitleToDelete = scanner.nextLine();

                    boolean removed = movieList.removeMovie(movieTitleToDelete);
                    if (removed) {
                        System.out.println("Movie deleted successfully.");
                    } else {
                        System.out.println("No movie found with the specified title.");
                    }
                    break;

                case 5:
                    // Print all records from head
                    System.out.println("Printing all movies from the head...");
                    movieList.printFromHead();
                    break;

                case 6:
                    // Print all records from tail
                    System.out.println("Printing all movies from the tail...");
                    movieList.printFromTail();
                    break;

                case 7:
                    // Print movies before 2000
                    System.out.println("Movies before 2000:");
                    movieList.printMoviesBeforeYear(2000);
                    break;

                case 8:
                    // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Program terminated.");
        scanner.close();
        movieList.saveToFile("C:\\Users\\Buğra Öztürk\\Desktop\\bilgiler.txt");

    }
}
