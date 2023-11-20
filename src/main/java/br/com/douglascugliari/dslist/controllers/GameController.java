package br.com.douglascugliari.dslist.controllers;

import br.com.douglascugliari.dslist.dto.GameDTO;
import br.com.douglascugliari.dslist.dto.GameMinDTO;
import br.com.douglascugliari.dslist.entities.Game;
import br.com.douglascugliari.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable("id")  Long id){
        return gameService.findById(id);
    }
}