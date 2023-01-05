package eatda.clone.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class swaggerController {

    @GetMapping("/test")
    @ApiOperation(value = "테스트", notes = "테테스트")
    public String hello(){
        return "hi";
    }
}
