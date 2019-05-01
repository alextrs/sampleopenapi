package com.test.oapi;

import static org.springframework.http.ResponseEntity.status;


import com.test.oapi.api.PetApi;
import com.test.oapi.api.dto.PetDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:/v1}")
public class PetsApiImpl implements PetApi {

    @Override
    public ResponseEntity<PetDto> getPetById(Long petId) {
        PetDto petDto = new PetDto();
        petDto.setId(petId);
        return status(HttpStatus.CREATED).body(petDto);
    }

    @Override
    public ResponseEntity<List<PetDto>> findPetsByTags(@NotNull @Valid List<String> tags, Optional<Integer> pageSize, Optional<String> restartRowId) {
        List<PetDto> list = new ArrayList<>();
        PetDto petDto = new PetDto();
        petDto.setName(tags.get(0) + "-" + tags.get(1));
        list.add(petDto);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
