package main.com.universitysystem.model;

public class User {

        private String id;
        private String username;
        private String password; // Hashed password for security
        private String email;
        // Other relevant attributes like role, etc.

        // Constructor
        public User(String id, String username, String password, String email) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.email = email;
        }



        // Constructor, getters, and setters


        public String getId() {
                return id;
        }

        public void setId(String id) {
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
