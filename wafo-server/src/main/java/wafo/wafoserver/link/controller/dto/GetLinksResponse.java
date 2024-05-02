package wafo.wafoserver.link.controller.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import wafo.wafoserver.link.Link;

@Data
@AllArgsConstructor
public class GetLinksResponse {
    List<Link> links;
}
