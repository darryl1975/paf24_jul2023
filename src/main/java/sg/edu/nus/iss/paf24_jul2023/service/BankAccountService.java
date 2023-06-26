package sg.edu.nus.iss.paf24_jul2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf24_jul2023.model.BankAccount;
import sg.edu.nus.iss.paf24_jul2023.repository.BankAccountRepo;

@Service
public class BankAccountService {
    
    @Autowired
    BankAccountRepo bankAccountRepo;

    public BankAccount retrieveAccountById(Integer accountId) {
        return bankAccountRepo.getAccountById(accountId);
    }

    public Boolean createAccount(BankAccount bankAccount) {
        return bankAccountRepo.createAccount(bankAccount);
    }

}
