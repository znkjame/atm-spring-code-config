package th.ac.ku.atm;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ATMConfig {

    @Bean
    public DataSource dataSource(){
        return new DataSourceFile("customers.txt");
    }

    @Bean
    public Bank bank(){
        return new Bank("Ku Bank", dataSource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public AtmUI atmUI(){
        return new AtmUI(atm());
    }
}
