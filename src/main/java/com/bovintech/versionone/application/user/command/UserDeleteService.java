package com.bovintech.versionone.application.user.command;

import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;

    public void execute(String username) {
        // Buscar usuario existente
        var existingUser = userRepository.getById(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Eliminar usuario
        userRepository.delete(existingUser);
    }
}
