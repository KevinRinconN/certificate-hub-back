package com.bovintech.versionone.application.user.command;

import com.bovintech.versionone.application.user.mapper.UserMapper;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.domain.user.model.GetUserDto;
import com.bovintech.versionone.domain.user.model.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetUserDto execute(String username, UpdateUserDto updateUserDto) {
        // Buscar usuario existente
        var existingUser = userRepository.getById(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar los campos
        if (updateUserDto.getFirstname() != null)
            existingUser.setFirstname(updateUserDto.getFirstname());
        if (updateUserDto.getLastname() != null)
            existingUser.setLastname(updateUserDto.getLastname());
        if (updateUserDto.getEmail() != null)
            existingUser.setEmail(updateUserDto.getEmail());
        if (updateUserDto.getRol() != null)
            existingUser.setRol(updateUserDto.getRol());
        if (updateUserDto.getLocked() != null)
            existingUser.setLocked(updateUserDto.getLocked());
        if (updateUserDto.getDisabled() != null)
            existingUser.setDisabled(updateUserDto.getDisabled());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        // 🔐 Actualizar contraseña si viene una nueva
        if (updateUserDto.getPassword() != null && !updateUserDto.getPassword().isBlank()) {
            String encodedPassword = bCryptPasswordEncoder.encode(updateUserDto.getPassword());
            existingUser.setPassword(encodedPassword);
        }

        // Guardar cambios
        var updatedUser = userRepository.update(existingUser);

        // Retornar DTO para mostrar
        return userMapper.toShow(updatedUser);
    }
}
