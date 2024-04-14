package Seoul.tour.service;

import Seoul.tour.dto.MailDTO;

public interface IMailService {

    //메일 발송
    int doSendMail(MailDTO pDTO);


}
