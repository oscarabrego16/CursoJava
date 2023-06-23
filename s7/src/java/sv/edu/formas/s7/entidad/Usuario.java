package sv.edu.formas.s7.entidad;
// Generated Apr 29, 2023 12:23:39 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="curso"
)
public class Usuario  implements java.io.Serializable {


     private String login;
     private String password;

    public Usuario() {
    }

    public Usuario(String login, String password) {
       this.login = login;
       this.password = password;
    }
   
     @Id 

    
    @Column(name="login", unique=true, nullable=false, length=15)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", nullable=false, length=100)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


