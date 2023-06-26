package sg.edu.nus.iss.paf24_jul2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf24_jul2023.exception.BankAccountNotFoundException;
import sg.edu.nus.iss.paf24_jul2023.model.BankAccount;
import sg.edu.nus.iss.paf24_jul2023.repository.BankAccountRepo;

@Service
public class BankAccountService {
    
    @Autowired
    BankAccountRepo bankAccountRepo;

    public BankAccount retrieveAccountById(Integer accountId) {
        BankAccount bankAccount = bankAccountRepo.getAccountById(accountId);

        // System.out.println("BankAccountService > retrieveAccountById > " + bankAccount.toString());

        // if (bankAccount == null) {
        //     throw new BankAccountNotFoundException("Account Details cannot be retrieved.");
        // }

        return bankAccount;
    }

    public Boolean createAccount(BankAccount bankAccount) {
        return bankAccountRepo.createAccount(bankAccount);
    }

}
