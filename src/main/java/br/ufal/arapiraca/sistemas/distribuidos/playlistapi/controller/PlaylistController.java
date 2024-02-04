package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.controller;

import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.link.LinkModel;
import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.link.LinkPostDTO;
import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.link.LinkRepository;
import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist.PlaylistModel;
import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist.PlaylistPostDTO;
import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/playlist")
@RestController
public class PlaylistController {
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    LinkRepository linkRepository;

    @GetMapping("/")
    public ResponseEntity<List<PlaylistModel>> getAllPlaylist() {
        return ResponseEntity.ok(playlistRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<LinkModel>> getAllLink(@PathVariable int id) {
        Optional<PlaylistModel> playlistModelOptional = playlistRepository.findById(id);
        if (playlistModelOptional.isPresent()) {
            List<LinkModel> linkModels = linkRepository.findAllByPlaylistId(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(linkModels);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }

    @PostMapping("/")
    public ResponseEntity<String> postPlaylist(@RequestBody PlaylistPostDTO playlistPostDTO) {
        PlaylistModel playlistModel = new PlaylistModel(playlistPostDTO.titulo(), playlistPostDTO.descricao());
        playlistRepository.save(playlistModel);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @PostMapping("/{id}/addlink")
    public ResponseEntity<String> addPlaylistLink(@PathVariable int id, @RequestBody LinkPostDTO linkPostDTO) {
        Optional<PlaylistModel> playlistModelOptional = playlistRepository.findById(id);
        if (playlistModelOptional.isPresent()) {
            if (linkPostDTO.titulo().length() > 200) {
                return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("O Título possui mais de 200 caracteres!");
            }
            if (linkPostDTO.descricao().length() > 500) {
                return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("A Descrição possui mais de 500 caracteres!");
            }
            PlaylistModel playlistModel = playlistModelOptional.get();
            LinkModel linkModel = new LinkModel(linkPostDTO.titulo(), linkPostDTO.descricao(), linkPostDTO.url(), playlistModel);
            linkRepository.save(linkModel);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable int id) {
        Optional<PlaylistModel> playlistModelOptional = playlistRepository.findById(id);
        if (playlistModelOptional.isPresent()) {
            PlaylistModel playlistModel = playlistModelOptional.get();
            playlistRepository.delete(playlistModel);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
    }
}
