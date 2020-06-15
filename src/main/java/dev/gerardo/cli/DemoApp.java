package dev.gerardo.cli;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

import java.io.File;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {Comando1.class, Comando2.class},
        version= "version 1.1",
        footerHeading = "2020 - Demo\n",
        headerHeading = "Gerardo.Dev Tool Set\n",
        description = "App que hace varias cosas"
)
public class DemoApp {

}

@CommandLine.Command(name = "comando1", description = "Este comando ejecuta XYZ"
)
class Comando1 implements Runnable {
    @CommandLine.Option(names = {"-n", "--nombre"},
            description = "Nombre del usuario",
            required = true
    )
    String nombre;

    @CommandLine.Option(names = {"-s", "--sistema"}, description = "Sistema a configurar",
            defaultValue = "S001"
    )
    String sistema;

    @CommandLine.Option(names = {"-c", "--credencial"}, arity = "0..1",
            description = "Credencial", interactive = true)
    String credencial;

    @CommandLine.Parameters(index = "0", description = "Archivo de configuración", paramLabel = "Archivo")
    File archivo;

    @Override
    public void run() {
        System.out.println("Mi primer comando [" + nombre + "] sistema [" + sistema + "] Path ["
                + archivo.toPath() + "]");
        ;

    }
}


@CommandLine.Command(name = "comando2", description = "Este comando ejecuta ABC")
class Comando2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Mi segundo comando");
    }

}