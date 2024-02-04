package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Integer> {
}
