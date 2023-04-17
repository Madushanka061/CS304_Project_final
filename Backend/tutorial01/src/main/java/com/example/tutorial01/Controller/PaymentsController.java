package com.example.tutorial01.Controller;
import com.example.tutorial01.dto.PaymentsDTO;
import com.example.tutorial01.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/payment")
@CrossOrigin
public class PaymentsController {
}
