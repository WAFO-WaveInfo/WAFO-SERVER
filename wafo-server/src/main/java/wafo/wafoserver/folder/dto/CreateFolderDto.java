package wafo.wafoserver.folder.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import wafo.wafoserver.account.user.User;

@Getter
@RequiredArgsConstructor
public class CreateFolderDto {
    private final String name;
    private final User user;
}
