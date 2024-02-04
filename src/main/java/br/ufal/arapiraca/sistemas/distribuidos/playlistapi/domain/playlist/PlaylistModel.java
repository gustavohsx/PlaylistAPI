package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "playlist")
@Entity(name = "playlist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlaylistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    @Basic(optional = false)
    @Column(name = "dtcadastro", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcadastro;
    @Basic(optional = false)
    @Column(name = "dtultalt", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtultalt;

    public PlaylistModel(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public PlaylistModel(String titulo) {
        this.titulo = titulo;
    }
}
