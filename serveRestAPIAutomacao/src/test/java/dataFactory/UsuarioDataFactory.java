package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo usuarioLogin(String email, String password){
        return new UsuarioPojo(email, password);
    }

    public static UsuarioPojo cadastrarUsuario(String nome, String email, String password, boolean administrador){
        UsuarioPojo usuario = new UsuarioPojo(email, password);
        usuario.setUsuarioNome(nome);
        usuario.setIsAdministrador(administrador);
        return usuario;
    }

}
