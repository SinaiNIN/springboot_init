package com.example.user.authentication.api;

import com.example.item.domain.Item;
import com.example.user.authentication.domain.AppUser;
import com.example.user.authentication.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Path("user")
public class AppUserAPI {

    private AppUserService appUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Optional<AppUser> getByUserName(@QueryParam("name") String name) {
        return appUserService.getByUserName(name);
    }
}
