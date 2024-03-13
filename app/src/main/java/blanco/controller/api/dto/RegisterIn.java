package blanco.controller.api.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterIn {
    
    @NotBlank
    public String name;

    @NotBlank
    public String password;

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }
}
