package br.inatel.cdg.test.mockito;


import br.inatel.cdg.BuscaDados;
import br.inatel.cdg.DadosService;
import br.inatel.cdg.Dados;
import br.inatel.cdg.test.DadosConst;
import com.google.gson.JsonElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaDados {

    @Mock
    private DadosService service;

    private BuscaDados buscaDados;

    private int getIntFromJsonElement(JsonElement element) {
        return Integer.parseInt(element.getAsString());
    }
    @Before
    public void setup(){buscaDados = new BuscaDados(service);}



    @Test
    public void testBuscaHorarioDoProfessor() {
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Renzo);

        Dados renzo = buscaDados.buscaDado(8);

        assertEquals(8, renzo.getHorarioDeAtendimento(), 0.1);
    }

    @Test
    public void testBuscaProfessorRenzo(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Renzo);

        Dados renzo = buscaDados.buscaDado(8);

        assertEquals("Renzo", renzo.getNomeDoProfessor());
        assertEquals(8, renzo.getHorarioDeAtendimento(),0.1);
        assertEquals(1, renzo.getPeriodo(), 0.1);
        assertEquals(1, renzo.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(renzo.getPredio().get(0)));

    }

    @Test
    public void testBuscaProfessorMarcelo(){
        Mockito.when(service.busca(9)).thenReturn(DadosConst.Marcelo);

        Dados marcelo = buscaDados.buscaDado(9);

        assertEquals("Marcelo", marcelo.getNomeDoProfessor());
        assertEquals(9, marcelo.getHorarioDeAtendimento(),0.1);
        assertEquals(2, marcelo.getPeriodo(), 0.1);
        assertEquals(2, marcelo.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(marcelo.getPredio().get(0)));

    }
    @Test
    public void testBuscaSalaDoProfessor() {
        Mockito.when(service.busca(9)).thenReturn(DadosConst.Marcelo);

        Dados marcelo = buscaDados.buscaDado(9);

        assertEquals(2, marcelo.getSala(), 0.1);
    } 

    @Test
    public void testBuscaProfessorChris(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Chris);

        Dados chris = buscaDados.buscaDado(8);

        assertEquals("Chris", chris.getNomeDoProfessor());
        assertEquals(10, chris.getHorarioDeAtendimento(),0.1);
        assertEquals(3, chris.getPeriodo(), 0.1);
        assertEquals(3, chris.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(chris.getPredio().get(0)));

    }

    @Test
    public void testBuscaProfessorJoao(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Joao);

        Dados joao = buscaDados.buscaDado(8);

        assertEquals("Joao", joao.getNomeDoProfessor());
        assertEquals(11, joao.getHorarioDeAtendimento(),0.1);
        assertEquals(4, joao.getPeriodo(), 0.1);
        assertEquals(4, joao.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(joao.getPredio().get(0)));

    }

    @Test
    public void testBuscaProfessorYvo(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Yvo);

        Dados yvo = buscaDados.buscaDado(8);

        assertEquals("Yvo", yvo.getNomeDoProfessor());
        assertEquals(12, yvo.getHorarioDeAtendimento(),0.1);
        assertEquals(5, yvo.getPeriodo(), 0.1);
        assertEquals(5, yvo.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(yvo.getPredio().get(0)));

    }

    @Test
    public void testBuscaNomeDoProfessorYvo(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Yvo);

        Dados yvo = buscaDados.buscaDado(8);

        assertEquals("Yvo", yvo.getNomeDoProfessor());
    }


    @Test
    public void testBuscaNomeDoProfessor() {
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Chris);

        Dados chris = buscaDados.buscaDado(8);

        assertEquals("Chris", chris.getNomeDoProfessor());
    }

    @Test
    public void testNomeDoProfessorCorreto() {
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Renzo);

        Dados renzo = buscaDados.buscaDado(8);

        assertEquals("Renzo", renzo.getNomeDoProfessor());
    }

    @Test
    public void testBuscaProfessorInexistente(){
        Mockito.when(service.busca(8)).thenReturn(DadosConst.INEXISTENTE);

        Dados inexistente = buscaDados.buscaDado(8);

        assertEquals("INEXISTENTE", inexistente.getNomeDoProfessor());
        assertEquals(00, inexistente.getHorarioDeAtendimento(),0.1);
        assertEquals(0, inexistente.getPeriodo(), 0.1);
        assertEquals(0, inexistente.getSala(), 0.1);
        assertEquals(1, getIntFromJsonElement(inexistente.getPredio().get(0)));

    }

    @Test
    public void testBuscaPeriodoDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals(0, professorInexistente.getPeriodo(), 0.1);
    }

    @Test
    public void testBuscaSalaDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals(0, professorInexistente.getSala(), 0.1);
    }

    @Test
    public void testBuscaHorarioDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals(00, professorInexistente.getHorarioDeAtendimento(), 0.1);
    }

    @Test
    public void testBuscaNomeDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals("INEXISTENTE", professorInexistente.getNomeDoProfessor());
    }

    @Test
    public void testBuscaPeriodoESalaDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals(0, professorInexistente.getPeriodo(), 0.1);
        assertEquals(0, professorInexistente.getSala(), 0.1);
    }

    @Test
    public void testBuscaDadosDoProfessorInexistente() {
        Mockito.when(service.busca(10)).thenReturn(DadosConst.INEXISTENTE);

        Dados professorInexistente = buscaDados.buscaDado(10);

        assertEquals("INEXISTENTE", professorInexistente.getNomeDoProfessor());
        assertEquals(0, professorInexistente.getHorarioDeAtendimento(), 0.1);
        assertEquals(0, professorInexistente.getPeriodo(), 0.1);
        assertEquals(0, professorInexistente.getSala(), 0.1);
    }

    @Test
    public void testNomeVazio() {
        String nomeVazio = "";
        assertFalse(buscaDados.verificaNome(nomeVazio));

    }

    @Test
    public void testNomeNulo() {
        String nomeNulo = null;
        assertFalse(buscaDados.verificaNome(nomeNulo));
    }

    @Test
    public void testNomeDoProfessorIncorreto() {
        Mockito.when(service.busca(8)).thenReturn(DadosConst.Marcelo);

        Dados marcelo = buscaDados.buscaDado(8);

        assertNotEquals("Renzo", marcelo.getNomeDoProfessor());
    }

}
