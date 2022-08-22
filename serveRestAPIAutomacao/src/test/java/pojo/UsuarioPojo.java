package pojo;

public class UsuarioPojo {
    private String usuarioNome;
    private String usuarioEmail;
    private String usuarioPassword;
    private boolean isAdministrador;


    public UsuarioPojo (String usuarioEmail, String usuarioPassword){
        this.usuarioEmail = usuarioEmail;
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public boolean isAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }
}
