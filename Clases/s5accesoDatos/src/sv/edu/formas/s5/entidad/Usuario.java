package sv.edu.formas.s5.entidad;

public class Usuario {
    private String username;
    private String password;
    
    public Usuario(){}
    public Usuario(String u, String p){
    this.username= u;
    this.password=p;
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
    
    
}
