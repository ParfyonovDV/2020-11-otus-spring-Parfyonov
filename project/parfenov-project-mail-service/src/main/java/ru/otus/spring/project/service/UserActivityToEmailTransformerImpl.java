package ru.otus.spring.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ru.otus.spring.project.config.AppProps;
import ru.otus.spring.project.config.EmailConfiguration;
import ru.otus.spring.project.models.Report;
import ru.otus.spring.project.models.Result;
import ru.otus.spring.project.models.Script;

@RequiredArgsConstructor
@Service
public class UserActivityToEmailTransformerImpl implements UserActivityToEmailTransformer {

    private final AppProps appProps;
    private final EmailConfiguration emailConfiguration;

    @Override
    public SimpleMailMessage transform(Report report) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(appProps.getAdminEmail());
        mailMessage.setFrom(appProps.getServerEmail());

        String resultText = "";
        for(Result result : report.getResults()){
            resultText+= " Документ: " + result.getDocName() +
                    " сценарий: " + result.getName() +
                    " с ключом: " + result.getKey();
        }

        if(resultText.length() == 0){
            mailMessage.setSubject("Успешное тестирование!");
            mailMessage.setText(String.format("Внимание!!! Тестирование релиза завершено без ошибок"));
        }else {
            mailMessage.setSubject("Ошибки тестирования!");
            mailMessage.setText(String.format("Внимание!!! Во время тестирования %s " +
                            "обнаружено расхождение ожидаемого " +
                            "и фактического результата по следующим сценариям: %s"
                    ,
                    report.getName(), resultText));
        }
     //   emailConfiguration.getJavaMailSender().send(mailMessage);

        return mailMessage;
    }
}
