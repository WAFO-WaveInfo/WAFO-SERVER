package wafo.wafoserver.folder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.folder.dto.CreateFolderDto;
import wafo.wafoserver.link.Link;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Folder {

    @Id
    @GeneratedValue
    @Column(name = "folder_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    // temp constructor
    public Folder(String name, User user) {
        this.name = name;
        this.user = user;
    }

    /**
     * 연관관계 편의 메서드
     */
    private void regisUser(final User user) {
        this.user = user;
        user.getFolders().add(this);
    }

    /**
     * 생성 메서드
     */
    public static Folder create(CreateFolderDto folderDto) {
        Folder folder = new Folder(folderDto.getName());
        folder.regisUser(folderDto.getUser());

        return folder;
    }
}
