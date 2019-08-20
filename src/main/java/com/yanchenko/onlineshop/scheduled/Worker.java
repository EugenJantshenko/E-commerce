package com.yanchenko.onlineshop.scheduled;

import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.repository.WareRepository;
import com.yanchenko.onlineshop.service.impl.mailSerivces.SendReportToMailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Worker {

    @Autowired
    private WareRepository wareRepository;

    @Scheduled(fixedRate = 15000)
    public void checkWareLeft() {
        SendReportToMailImpl mailsender = new SendReportToMailImpl();
        Iterable<Ware> all = wareRepository.findAll();
        List<Ware> less10 = new ArrayList<>();
        all.forEach(item -> {
//            if (item.getCount() <=10) {
//                less10.add(item);
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
//        mailsender.SendEmail(mailMessage.toString());
//        System.out.println(wareRepository.count());
//
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }
//}
        });
    }
}
