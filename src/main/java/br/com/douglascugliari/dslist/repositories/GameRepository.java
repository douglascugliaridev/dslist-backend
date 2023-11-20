package br.com.douglascugliari.dslist.repositories;

import br.com.douglascugliari.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}