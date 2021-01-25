package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.controller.MessageServiceForTest;
import br.com.thundercoders.model.UsuarioEntity;
import br.com.thundercoders.service.UsuarioService;

public class UsuarioTest {

    @DisplayName("Test MessageService.getCPF()") //E usada para fornecer um nome personalizado para a classe de teste e métodos de teste
    @Test   //no JUnit > 4 os métodos de teste são identificados com a anotação @Test
    void loginComprimentoCpfTest() {
        assertEquals(11, MessageServiceForTest.getCPF().getCpf().length());
    }

    @DisplayName("Test MessageService.getApelido()")
    @Test
    void loginComprimentoApelidoTest() {
        assertEquals(true, (MessageServiceForTest.getApelido().getNome().length() < 20));
    }


    //Exemplo em Aula
    @Test
    static void loginComprimentoTest() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin("Guirilima");

        UsuarioService service = new UsuarioService();

        assertTrue(service.loginComprimento(usuario.getLogin()));
    }

    @Test
    void loginComprimentoInvalidoTest() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin("Guirilimae3erwrereerere2233234ere");

        UsuarioService service = new UsuarioService();

        assertFalse(service.loginComprimento(usuario.getLogin()));
    }
}
