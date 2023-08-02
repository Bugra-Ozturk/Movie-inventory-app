class Node {
    private Movie movie;    // Private field to store a Movie object
    private Node prev;      // Private field to store a reference to the previous Node
    private Node next;      // Private field to store a reference to the next Node

    // Constructor to initialize the Node object with a Movie
    public Node(Movie movie) {
        this.movie = movie;
        this.prev = null;
        this.next = null;
    }

    // Getter method to retrieve the Movie stored in the Node
    public Movie getMovie() {
        return movie;
    }

    // Setter method to set the Movie stored in the Node
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // Getter method to retrieve the previous Node
    public Node getPrev() {
        return prev;
    }

    // Setter method to set the previous Node
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Getter method to retrieve the next Node
    public Node getNext() {
        return next;
    }

    // Setter method to set the next Node
    public void setNext(Node next) {
        this.next = next;
    }
}
