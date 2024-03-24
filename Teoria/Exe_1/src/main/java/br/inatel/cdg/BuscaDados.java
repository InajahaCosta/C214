package br.inatel.cdg;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaDados {

    DadosService dadosservice;

    public BuscaDados(DadosService service){ this.dadosservice = service;}

    public Dados buscaDado( int horarioDeAtendimento){

        String dadosJson = dadosservice.busca(horarioDeAtendimento);

        JsonObject jsonObject = JsonParser.parseString(dadosJson).getAsJsonObject();

        return new Dados(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsDouble(),
                jsonObject.get("periodo").getAsDouble(),
                jsonObject.get("sala").getAsDouble(),
                jsonObject.get("predio").getAsJsonArray());
    }

    public boolean verificaArrayListPredio(int sala){
        boolean predio = dadosservice.predio(sala);

        if (predio){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificaNome(String nome){
        if (nome == null) {
            return false;
        }

        String regex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nome);

        return matcher.matches();
    }
}
