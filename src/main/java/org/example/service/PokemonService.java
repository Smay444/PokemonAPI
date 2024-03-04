package org.example.service;

import org.example.model.Pokemon;
import org.example.model.PokemonDetail;
import org.example.model.Results;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PokemonService {
    //connecting to the pokiapi

    private RestTemplate restTemplate = new RestTemplate();
    //set up your constant;
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    //write method to return a list of Pokemon

    public List<Pokemon> getPokemon(){
        Results rs = restTemplate.getForObject(API_URL, Results.class);
        return rs.getResults();
    }

    public List<Pokemon> getMorePokemon(int startVal){
        //https://pokeapi.co/api/v2/pokemon?offset=20&limit=20
        Results rs = restTemplate.getForObject(API_URL + "?offset=" +
                startVal + "&limit=20", Results.class);
        List<Pokemon> list = rs.getResults();
        for (Pokemon item: list){
            String url = item.getUrl(); // get the url so we can pull the index
            int pokemonIndex = url.indexOf("pokemon");
            String pokemonString = url.substring(pokemonIndex);
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1,
                    pokemonString.length() - 1); // strips off the /number/
            int id = Integer.parseInt(number);
            item.setId(id);
        }
        return list;
    }

    public PokemonDetail getPokemonDetailById(int id){
        PokemonDetail pokemonDetail = restTemplate.getForObject(API_URL + "/" + id, PokemonDetail.class);

        return pokemonDetail;
    }

}
