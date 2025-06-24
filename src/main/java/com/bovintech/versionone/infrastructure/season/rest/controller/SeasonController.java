package com.bovintech.versionone.infrastructure.season.rest.controller;

import com.bovintech.versionone.application.season.command.SeasonCreateHandler;
import com.bovintech.versionone.application.season.command.SeasonUpdateHandler;
import com.bovintech.versionone.application.season.query.SeasonFindHandler;
import com.bovintech.versionone.application.season.query.SeasonGetByIdHandler;
import com.bovintech.versionone.domain.season.model.SeasonCreateDTO;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.season.model.SeasonUpdateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/season")
@RequiredArgsConstructor
public class SeasonController {
    private final SeasonFindHandler seasonFindHandler;
    private final SeasonGetByIdHandler seasonGetByIdHandler;
    private final SeasonCreateHandler seasonCreateHandler;
    private final SeasonUpdateHandler seasonUpdateHandler;

    @GetMapping
    public ResponseHandler<Page<SeasonShow>> find (@RequestParam(required = false) String name,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(defaultValue = "id,asc") String sort){
        SeasonSearchParams seasonSearchParams = new SeasonSearchParams(name,page,size,sort);
        return ResponseHandler.success("Season data successfully", seasonFindHandler.execute(seasonSearchParams));
    }

    @GetMapping("/{id}")
    public ResponseHandler<SeasonShow> getById (@PathVariable Long id){
        return ResponseHandler.success("Season data successfully",seasonGetByIdHandler.execute(id));
    }

    @PostMapping
    public ResponseHandler<SeasonShow> create (@RequestBody @Valid SeasonCreateDTO seasonCreateDTO){
        return ResponseHandler.success("Season data successfully", seasonCreateHandler.execute(seasonCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseHandler<SeasonShow> update (@PathVariable Long id, @RequestBody @Valid SeasonUpdateDTO seasonUpdateDTO){
        return ResponseHandler.success("Season update date successfully", seasonUpdateHandler.execute(id, seasonUpdateDTO));
    }
}
