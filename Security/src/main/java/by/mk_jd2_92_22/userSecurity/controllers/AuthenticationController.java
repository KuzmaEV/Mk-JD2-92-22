package by.mk_jd2_92_22.userSecurity.controllers;

import by.mk_jd2_92_22.userSecurity.model.dto.LoginDTO;
import by.mk_jd2_92_22.userSecurity.security.JwtProvider;
import by.mk_jd2_92_22.userSecurity.services.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/public")
public class AuthenticationController {

    private final CustomUserDetailsService detailsService;
    private final JwtProvider jwtProvider;
//    private PasswordEncoder encoder;

    public AuthenticationController(CustomUserDetailsService detailsService, JwtProvider jwtProvider) {
        this.detailsService = detailsService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO dto){
//        try {
//
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getMail(), dto.getPassword()));
//            UserFull user = dao.findByMail(dto.getMail()).orElseThrow(()->
//                    new UsernameNotFoundException("User doesn't exist"));
//            String token = jwtProvider.createToken(dto.getMail());
//
//            return ResponseEntity.ok(token);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
//        }

        final UserDetails user = detailsService.loadUserByUsername(dto.getMail());

        if(
//                !encoder.matches(
                !dto.getPassword().equals(user.getPassword())){
            throw new IllegalArgumentException("Пароль неверный");
        }

        return ResponseEntity.ok(jwtProvider.createToken(user.getUsername()));

    }

    @PostMapping("/logout")
    public void authenticate(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
