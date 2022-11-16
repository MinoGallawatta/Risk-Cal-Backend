package com.cdr.CDR;

import com.cdr.CDR.dto.DTO;
import com.cdr.CDR.mapper.DataMapper;
import com.cdr.CDR.structure.Properties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @CrossOrigin
    @PostMapping("/get")
    public Integer getData(@RequestBody Properties properties){
        return DataMapper.findData(properties);
    }
    @PostMapping("/post")
    public void postData(@RequestBody DTO dto){
        dto.getProperties().setHc();
        DataMapper.saveData(dto.getProperties(),dto.getCdrValue());
    }
}
