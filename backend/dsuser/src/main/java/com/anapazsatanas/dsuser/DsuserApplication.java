package com.anapazsatanas.dsuser;

import com.anapazsatanas.dsuser.clientrepository.ClientRepository;
import com.anapazsatanas.dsuser.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class DsuserApplication implements CommandLineRunner {
    private final ClientRepository clientRepository;

    public DsuserApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DsuserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client client1=new Client(null,"Ana Paula","22703063091",3.5, Instant.now(),2);
        Client client2=new Client(null,"Ana Maria","953.166.650-40",9.5, Instant.now(),5);
        Client client3=new Client(null,"Ana Clara","846.699.280-40",3.0, Instant.now(),1);
        Client client4=new Client(null,"Ana Francisca","182.877.630-02",3.5, Instant.now(),11);
        Client client5=new Client(null,"Ana Santana","160.563.190-67",3.9, Instant.now(),3);
        Client client6=new Client(null,"Ana Lucia","047.915.990-47",13.5, Instant.now(),8);
        Client client7=new Client(null,"Ana Luiza","101.621.790-06",33.5, Instant.now(),4);
        Client client8=new Client(null,"Ana Julia","249.660.110-78",31.5, Instant.now(),1);
        Client client9=new Client(null,"Ana Linz","174.066.330-68",4.5, Instant.now(),0);
        Client client10=new Client(null,"Ana Mariana","657.253.050-74",23.5, Instant.now(),6);

        clientRepository.saveAll(Arrays.asList(client1,client2,client3,client4,client5,client6,client7,client8,client9,client10));

    }
}
