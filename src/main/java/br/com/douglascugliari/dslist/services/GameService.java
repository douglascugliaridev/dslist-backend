package br.com.douglascugliari.dslist.services;

import br.com.douglascugliari.dslist.dto.GameDTO;
import br.com.douglascugliari.dslist.dto.GameListDTO;
import br.com.douglascugliari.dslist.dto.GameMinDTO;
import br.com.douglascugliari.dslist.entities.Game;
import br.com.douglascugliari.dslist.entities.GameList;
import br.com.douglascugliari.dslist.projections.GameMinProjection;
import br.com.douglascugliari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findGameByList(Long listId) {
        List<GameMinProjection> listGame = gameRepository.searchByList(listId);
        return listGame.stream().map(x -> new GameMinDTO(x)).toList();
    }
}