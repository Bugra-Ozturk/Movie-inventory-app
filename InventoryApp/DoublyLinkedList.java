import java.io.*;

class DoublyLinkedList {
    private Node head;   // Private field to store the head (first node) of the doubly linked list
    private Node tail;   // Private field to store the tail (last node) of the doubly linked list

    // Constructor to create an empty DoublyLinkedList
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to check if the DoublyLinkedList is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to add a movie to the DoublyLinkedList in a sorted order
    public void addMovie(Movie movie) {
        Node newNode = new Node(movie);
        if (isEmpty()) {
            // If the list is empty, make the new node the head and tail
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current != null) {
                // Compare the year and title of the current movie with the new movie
                if (current.getMovie().getYear() > movie.getYear()) {
                    break;
                } else if (current.getMovie().getYear() == movie.getYear()) {
                    if (current.getMovie().getTitle().compareTo(movie.getTitle()) > 0) {
                        break;
                    }
                }
                current = current.getNext();
            }
            if (current == head) {
                // If the new movie should be inserted at the beginning of the list
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            } else if (current == null) {
                // If the new movie should be inserted at the end of the list
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
            } else {
                // If the new movie should be inserted in between two nodes
                newNode.setNext(current);
                newNode.setPrev(current.getPrev());
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
            }
        }
    }

    // Method to print the movies in the DoublyLinkedList from the head (first node) to the tail (last node)
    public void printFromHead() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getMovie().toString());
            current = current.getNext();
        }
    }

    // Method to print the movies in the DoublyLinkedList from the tail (last node) to the head (first node)
    public void printFromTail() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.getMovie().toString());
            current = current.getPrev();
        }
    }

    // Method to print the movies in the DoublyLinkedList that have a year before a given year
    public void printMoviesBeforeYear(int year) {
        Node current = head;
        while (current != null) {
            if (current.getMovie().getYear() < year) {
                System.out.println(current.getMovie().toString());
            }
            current = current.getNext();
        }
    }

    // Method to remove a movie from the DoublyLinkedList based on its title
    public boolean removeMovie(String title) {
        Node current = head;
        while (current != null) {
            if (current.getMovie().getTitle().equals(title)) {
                Node prevNode = current.getPrev();
                Node nextNode = current.getNext();

                if (prevNode != null) {
                    prevNode.setNext(nextNode);
                } else {
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.setPrev(prevNode);
                } else {
                    tail = prevNode;
                }

                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Method to get a movie from the DoublyLinkedList based on its title
    public Movie getMovieByTitle(String title) {
        Node current = head;
        while (current != null) {
            if (current.getMovie().getTitle().equalsIgnoreCase(title)) {
                return current.getMovie();
            }
            current = current.getNext();
        }
        return null;
    }

    // Method to save the movies in the DoublyLinkedList to a file
    public void saveToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Node current = head;
            while (current != null) {
                bufferedWriter.write(current.getMovie().toString());
                current = current.getNext();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
