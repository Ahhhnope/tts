package com.tts.letaskmanager.Service;

import com.tts.letaskmanager.DTO.LoginRequest;
import com.tts.letaskmanager.DTO.RegisterRequest;
import com.tts.letaskmanager.Entity.Role;
import com.tts.letaskmanager.Entity.User;
import com.tts.letaskmanager.Exception.BadRequestException;
import com.tts.letaskmanager.Exception.ResourceNotFoundException;
import com.tts.letaskmanager.Repository.RoleRepository;
import com.tts.letaskmanager.Repository.UserRepository;
import com.tts.letaskmanager.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public User register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email đã được sử dụng");
        }

        String roleName = (request.getRole() != null) ? request.getRole().toUpperCase() : "USER";
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException("Role không tồn tại: " + roleName));

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Email hoặc password không đúng"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Email hoặc password không đúng");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getRole().getName());
    }
}
