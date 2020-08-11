package com.bedbath.springbatchexercise2.config;

import com.bedbath.springbatchexercise2.model.Taxonomy;
import com.bedbath.springbatchexercise2.service.MessageService;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public class TaxonomyProcessor implements ItemProcessor<Taxonomy, Taxonomy> {

    private static final String TOPIC_NAME = "taxonomy";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaAdmin admin;

    @Autowired
    MessageService messageService;

    @Override
    public Taxonomy process(Taxonomy taxonomy) throws Exception {
        System.out.println("******************START Processor******************");
        sendMessage(taxonomy.toString());
        System.out.println("******************END Processor******************");
        return taxonomy;
    }

    public void sendMessage(String msg) {
        try (AdminClient client = AdminClient.create(admin.getConfigurationProperties())) {
            ListTopicsResult topics = client.listTopics();
            Set<String> names = topics.names().get();
            if (names.isEmpty()) {
                System.out.println("ERROR :: Topic is not present ");
            }
        } catch (InterruptedException | ExecutionException e) {
            messageService.sendEmail();
        }
        kafkaTemplate.send(TOPIC_NAME, msg);
    }

//    @KafkaListener(topics = TOPIC_NAME, groupId = "group-id",errorHandler = "voidSendToErrorHandler")
//    public void listen(String message) {
//        System.out.println("Received Messasge in group - group-id: " + message);
////        latch.countDown();
//    }

//    @Bean
//    public KafkaListenerErrorHandler voidSendToErrorHandler() {
//        System.out.println("******************Sending Email******************");
////        emailService.sendMessage("abhishek.kesharwani@idc.bedbath.com", "Test Subject from SpringExercise", "Text Message");
//        return null;
//    }


}


