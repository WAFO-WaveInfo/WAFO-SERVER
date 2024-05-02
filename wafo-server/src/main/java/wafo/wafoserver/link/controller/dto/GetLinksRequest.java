package wafo.wafoserver.link.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class GetLinksRequest {
    Long userId;
}
