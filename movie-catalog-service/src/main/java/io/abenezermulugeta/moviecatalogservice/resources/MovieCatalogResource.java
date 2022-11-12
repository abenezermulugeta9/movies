package io.abenezermulugeta.moviecatalogservice.resources;

import io.abenezermulugeta.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        return Collections.singletonList(
                new CatalogItem("Avengers", "Avengers Description", 5)
        );
    }
}
