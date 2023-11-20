package br.com.douglascugliari.dslist.services;

import br.com.douglascugliari.dslist.dto.GameMinDTO;
import br.com.douglascugliari.dslist.entities.Game;
import br.com.douglascugliari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}