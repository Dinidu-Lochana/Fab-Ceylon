package com.fabCeylon.TheFabCeylon.Controller;

import com.fabCeylon.TheFabCeylon.domain.user.User;
import com.fabCeylon.TheFabCeylon.insfrastructure.jwt.JwtUtil;
import com.fabCeylon.TheFabCeylon.repository.UserRepository;
import com.fabCeylon.TheFabCeylon.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired private UserRepository userRepository;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserService usersService;

    @Autowired private UserDetailsService userDetailsService;

    public static final String TOKEN_PREFIX ="Bearer ";

    public static final String HEADER_STRING = "Authorization";
    @PostMapping("/signup")
    public User signupUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersService.signupUser(user);
    }

    @PostMapping("/signin")
    public void signin(@RequestBody User user , HttpServletResponse response) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getContactNumber(), user.getPassword()));
        } catch (Exception ex) {
            throw new Exception("Invalid username or password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getContactNumber());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        final User dbUser = usersService.getUserByContactNumber(user.getContactNumber());

        response.getWriter().write(new JSONObject()
                .put("userId",dbUser.getId())
                .toString()
        );

        response.addHeader("Access-Control-Expose-Headers","Authorization");
        response.addHeader("Access-Control-Allow-Headers","Authorization," +
                " X-PINGOTHER, Orgin, X-Requested-With, Content-Type, Accept, X-Custom-header");

        response.addHeader(HEADER_STRING, TOKEN_PREFIX+jwt);
    }

}
