package wafo.wafoserver.link.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.folder.Folder;

@Getter
@RequiredArgsConstructor
public class CreateLinkDto {
    private final User user;
    private final Folder folder;
    private final String url;
    private final String title;
    private final String favicon_url;
}
