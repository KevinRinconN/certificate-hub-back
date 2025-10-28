package com.bovintech.versionone.infrastructure.auth.rest.controller;

import com.bovintech.versionone.application.user.command.UserDeleteService;
import com.bovintech.versionone.application.user.command.UserUpdateService;
import com.bovintech.versionone.application.user.query.UserSearchService;
import com.bovintech.versionone.domain.user.model.GetUserDto;
import com.bovintech.versionone.domain.user.model.UpdateUserDto;
import com.bovintech.versionone.domain.user.model.UserSearchParams;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSearchService userSearchService;
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;
    @GetMapping
    public ResponseHandler<Page<GetUserDto>> search (@RequestParam(required = false) String firstnames,
                                    @RequestParam(required = false) String lastnames,
                                    @RequestParam(required = false) String email,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "username,asc") String sort){
        UserSearchParams params = new UserSearchParams(firstnames, lastnames, email, page, size, sort);

        return ResponseHandler.success("User data succesfully", userSearchService.execute(params));
    }

    @PutMapping("/{username}")
    public ResponseHandler<GetUserDto> updateUser(
            @PathVariable String username,
            @RequestBody UpdateUserDto request
    ) {
        var updatedUser = userUpdateService.execute(username, request);
        return ResponseHandler.success("Usuario actualizado correctamente", updatedUser);
    }

    @DeleteMapping("/{username}")
    public ResponseHandler<Void> deleteUser(@PathVariable String username) {
        userDeleteService.execute(username);
        return ResponseHandler.success("Usuario eliminado correctamente");
    }
}
