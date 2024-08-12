package com.bovintech.versionone.infrastructure.inspector.rest.controller;

import com.bovintech.versionone.application.inspector.command.InspectorCreateHandler;
import com.bovintech.versionone.application.inspector.command.InspectorDeleteHandler;
import com.bovintech.versionone.application.inspector.command.InspectorUpdateHandler;
import com.bovintech.versionone.application.inspector.query.InspectorSearchHandler;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorCreateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorUpdateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.query.InspectorSearchParams;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inspector")
@RequiredArgsConstructor
public class InspectorController {

    private final InspectorSearchHandler inspectorSearchHandler;
    private final InspectorCreateHandler inspectorCreateHandler;
    private final InspectorUpdateHandler inspectorUpdateHandler;
    private final InspectorDeleteHandler inspectorDeleteHandler;

    @GetMapping
    public ResponseHandler<Page<InspectorDTO>> search(@RequestParam(required = false) String firstname,
                                                      @RequestParam(required = false) String lastname,
                                                      @RequestParam(required = false) String occupation,
                                                      @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseHandler.success("", inspectorSearchHandler.execute(new InspectorSearchParams(firstname, lastname, occupation), pageable));
    }

    @PostMapping
    public ResponseHandler <InspectorShow> create(@RequestBody @Valid InspectorCreateDTO inspectorCreateDTO){
        return ResponseHandler.success("Inspector create successfully", inspectorCreateHandler.execute(inspectorCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseHandler<InspectorShow> update (@PathVariable Long id, @RequestBody @Valid InspectorUpdateDTO inspectorUpdateDTO){
        return ResponseHandler.success("Inspector update successfully", inspectorUpdateHandler.execute(id, inspectorUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseHandler<Void> execute (@PathVariable Long id){
        inspectorDeleteHandler.execute(id);
        return ResponseHandler.success("Inspector with id: "+id+ " delete successfully");
    }
}

