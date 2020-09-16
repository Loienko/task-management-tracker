package net.ukr.dreamsicle.tasksmanagementtracker.client;

import net.ukr.dreamsicle.tasksmanagementtracker.dto.UserDTO;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${core.service.name}", url = "${core.service.url}")
public interface ApiClient {

    @GetMapping(value = "/users/{name}/details")
    UserDTO userExistenceCheck(@PathVariable String name);
}
