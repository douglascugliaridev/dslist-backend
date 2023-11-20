package br.com.douglascugliari.dslist.repositories;

import br.com.douglascugliari.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
