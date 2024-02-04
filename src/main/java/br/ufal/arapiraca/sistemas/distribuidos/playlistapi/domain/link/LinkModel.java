package br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.link;

import br.ufal.arapiraca.sistemas.distribuidos.playlistapi.domain.playlist.PlaylistModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "link")
@Entity(name = "link")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LinkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    private String url;
    @ManyToOne
    @JoinColumn(name = "idplaylist")
    private PlaylistModel playlist;
    @Basic(optional = false)
    @Column(name = "dtcadastro", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcadastro;
    @Basic(optional = false)
    @Column(name = "dtultalt", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtultalt;

    public LinkModel(String titulo, String descricao, String url, PlaylistModel playlist) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.playlist = playlist;
    }

    public LinkModel(String titulo, String url, PlaylistModel playlist) {
        this.titulo = titulo;
        this.url = url;
        this.playlist = playlist;
    }
}
