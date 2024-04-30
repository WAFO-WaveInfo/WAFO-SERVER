package wafo.wafoserver.link;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.folder.Folder;
import wafo.wafoserver.link.dto.CreateLinkDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Link {

    @Id
    @GeneratedValue
    @Column(name = "link_id")
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String favicon_url;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public Link(final User user, final String url, final String title, final String favicon_url) {
        this.user = user;
        this.url = url;
        this.title = title;
        this.favicon_url = favicon_url;
    }

    /**
     * 연관관계 편의 메서드
     */
    private void registerFolder(final Folder folder) {
        this.folder = folder;
        folder.getLinks().add(this);
    }

    /**
     * 생성 메서드
     */
    public static Link create(CreateLinkDto linkDto) {
        Link link = new Link(
                linkDto.getUser(),
                linkDto.getUrl(),
                linkDto.getTitle(),
                linkDto.getFavicon_url()
        );

        link.registerFolder(linkDto.getFolder());

        return link;
    }
}
