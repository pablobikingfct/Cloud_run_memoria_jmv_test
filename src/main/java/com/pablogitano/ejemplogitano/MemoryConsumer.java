import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyProjectApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyProjectApplication.class, args);

        // Obtén una instancia del servicio MemoryService del contexto de la aplicación
        MemoryService memoryService = context.getBean(MemoryService.class);

        // Inicia la lógica de consumo de memoria
        memoryService.consumeMemory();
    }
}

@Service
public class MemoryService {

    public void consumeMemory() {
        List<byte[]> memoryHog = new ArrayList<>();
        while (true) {
            System.out.println("Add 1M to stack memory");

            try {
                memoryHog.add(new byte[1024 * 1024]); // Añade 1 MB a la lista
                Thread.sleep(100); // Espera 100 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@RestController
public class MemoryController {

    private final MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @GetMapping("/memory")
    public String getMemoryStatus() {
        // Lógica para obtener el estado actual del consumo de memoria
        // Puedes utilizar el servicio MemoryService para obtener el estado del proceso

        // Devuelve el estado actual como una cadena de texto
        return "Current memory status: ..."; // Actualiza esta línea con el estado actual de consumo de memoria
    }
}

