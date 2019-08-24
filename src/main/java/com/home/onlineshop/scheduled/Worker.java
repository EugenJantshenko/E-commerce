package com.home.onlineshop.scheduled;

import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.interfaces.mailSerivces.SendReportToMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {


    private final WareRepository wareRepository;
    private final SendReportToMail sendReportToMail;

    @Autowired
    public Worker(WareRepository wareRepository, SendReportToMail sendReportToMail) {
        this.wareRepository = wareRepository;
        this.sendReportToMail = sendReportToMail;
    }

//    @Scheduled(fixedRate = 15000)
//    public void checkWareLeft() {
//        Iterable<Ware> all = wareRepository.findAll();
//        List<Ware> leftovers = new ArrayList<>();
//        all.forEach(item -> {
//            if (item.getCount() <=10) {
//                leftovers.add(item);
//            }
//        });
//        List<WareType> wares = StreamSupport.stream(all.spliterator(), false)
//                .filter(item -> item.getCount() <= 10)
//                .collect(Collectors.toList());
//
//        StringBuilder mailMessage = new StringBuilder();
//
//        for (WareType item : wares) {
//            //log.info(item.getWareName()+" is less"+" "+item.getCount());
//            mailMessage.append(item.getWareName()).append(" less").append(item.getCount()).append(" units. \n");
//        }
//        sendReportToMail.SendEmail(mailMessage.toString());
//        System.out.println(wareRepository.count());
//
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }
}
