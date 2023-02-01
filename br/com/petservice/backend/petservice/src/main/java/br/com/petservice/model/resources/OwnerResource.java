package br.com.petservice.model.resources;

import br.com.petservice.model.entities.Owner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/owner")
public class OwnerResource {

    @PostMapping
    public String insert(@RequestBody @Validated Owner owner){
        return "a";
    }

}
