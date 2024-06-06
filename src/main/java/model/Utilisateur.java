package model;

public class Utilisateur {
    private int id;
    private String username;
    private String password;
    private String role;
    private String numeroSecSoc; // Ajout de l'attribut numeroSecSoc
    private Assure assure; // Ajout de l'objet Assure

    // Constructor for creating a new user (without ID)
    public Utilisateur(String username, String password, String role, String numeroSecSoc) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.numeroSecSoc = numeroSecSoc;
    }

    // Constructor for updating an existing user (with ID)
    public Utilisateur(int id, String username, String password, String role, String numeroSecSoc) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.numeroSecSoc = numeroSecSoc;
    }

    public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumeroSecSoc() {
        return numeroSecSoc;
    }

    public void setNumeroSecSoc(String numeroSecSoc) {
        this.numeroSecSoc = numeroSecSoc;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }
}
