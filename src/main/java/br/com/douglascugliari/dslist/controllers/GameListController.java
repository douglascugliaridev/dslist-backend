package br.com.douglascugliari.dslist.controllers;

import br.com.douglascugliari.dslist.dto.GameListDTO;
import br.com.douglascugliari.dslist.dto.GameMinDTO;
import br.com.douglascugliari.dslist.services.GameListService;
import br.com.douglascugliari.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable("listId")  Long listId){
        List<GameMinDTO> result = gameService.findGameByList(listId);
        return result;
    }
}
