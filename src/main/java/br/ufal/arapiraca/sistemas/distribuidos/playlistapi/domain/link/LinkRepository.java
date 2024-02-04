package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.link;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<LinkModel, Integer> {
    public List<LinkModel> findAllByPlaylistId(int id);
}
