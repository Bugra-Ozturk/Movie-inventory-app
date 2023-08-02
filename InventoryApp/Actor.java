class Actor {
    private String fullName;  // Private field to store the full name of the actor
    private String gender;    // Private field to store the gender of the actor
    private String citizenship;  // Private field to store the citizenship of the actor

    // Constructor to initialize the Actor object with provided values
    public Actor(String fullName, String gender, String citizenship) {
        this.fullName = fullName;
        this.gender = gender;
        this.citizenship = citizenship;
    }
    public Actor(){
        this.setFullName(null);
        this.setGender(null);
        this.setCitizenship(null);
    }
    public Actor(Actor actor){
        this.setFullName(actor.getFullName());
        this.setGender(actor.getGender());
        this.setCitizenship(actor.getCitizenship());
    }

    // Getter method to retrieve the full name of the actor
    public String getFullName() {
        return fullName;
    }

    // Setter method to set the full name of the actor
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter method to retrieve the gender of the actor
    public String getGender() {
        return gender;
    }

    // Setter method to set the gender of the actor
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter method to retrieve the citizenship of the actor
    public String getCitizenship() {
        return citizenship;
    }

    // Setter method to set the citizenship of the actor
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    // Override toString() method to provide a string representation of the Actor object
    @Override
    public String toString() {
        return fullName + ", " + gender + ", " + citizenship;
    }
}
