package sn.isi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.AppUser;
import sn.isi.service.AppUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAppUsers() {
        return appUserService.getAppUsers();
    }

    @GetMapping("/{id}")
    public AppUser getAppUser(@PathVariable("id") int id) {
        return appUserService.getAppUser(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppUser createAppUser(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("/{id}")
    public AppUser updateAppUser(@PathVariable("id") int id, @Valid @RequestBody AppUser appUser) {
        return appUserService.updateAppUser(id, appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteAppUser(@PathVariable("id") int id) {
        appUserService.deleteAppUser(id);
    }
}
