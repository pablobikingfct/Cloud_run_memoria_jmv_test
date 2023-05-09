import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class MyProjectApplication {
    
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
        
        // Código para consumir memoria
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

    @GetMapping("/memory")
    public String getMemoryStatus() {
        // Lógica para obtener el estado actual del consumo de memoria
        // Puedes usar el código que generamos anteriormente para obtener el estado del proceso

        // Devuelve el estado actual como una cadena de texto
        return "Current memory status: ..."; // Actualiza esta línea con el estado actual de consumo de memoria
    }
}
