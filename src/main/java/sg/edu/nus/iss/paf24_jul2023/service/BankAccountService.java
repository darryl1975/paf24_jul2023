package sg.edu.nus.iss.paf24_jul2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.paf24_jul2023.exception.BankAccountNotFoundException;
import sg.edu.nus.iss.paf24_jul2023.model.BankAccount;
import sg.edu.nus.iss.paf24_jul2023.repository.BankAccountRepo;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepo bankAccountRepo;

    public BankAccount retrieveAccountById(Integer accountId) {
        BankAccount bankAccount = bankAccountRepo.getAccountById(accountId);

        return bankAccount;
    }

    public Boolean createAccount(BankAccount bankAccount) {
        return bankAccountRepo.createAccount(bankAccount);
    }

    // transactional: encompass in a single unit of work
    // writing of records to more than one tables or
    // update more than one records in the same table
    @Transactional
    public Boolean transferMoney(Integer withdrawAccountId, Integer depositAccountId, Float transferAmount) {
        // logic
        // 1. check that transferer exists
        Boolean bTranfererExists = false;
        BankAccount transfererBA = bankAccountRepo.getAccountById(withdrawAccountId);

        if (transfererBA != null) {
            bTranfererExists = true;
        }

        // 2. check that receiver exists
        Boolean bReceiverExists = false;
        BankAccount receiverBA = bankAccountRepo.getAccountById(depositAccountId);

        if (receiverBA != null) {
            bReceiverExists = true;
        }

        // 3. check transferer is active
        // 5. check that transferer is not blocked
        Boolean bTransfererAllowed = false;
        if (transfererBA.getIsActive() && !transfererBA.getIsBlocked()) {
            bTransfererAllowed = true;
        }

        // 4. check that receiver is active
        // 6. check that receiver is not blocked
        Boolean bReceiverAllowed = false;
        if (receiverBA.getIsActive() && !receiverBA.getIsBlocked()) {
            bReceiverAllowed = true;
        }

        // 7. check transferer has enough money to transfer to receiver
        Boolean bEnoughMoney = false;
        if (transfererBA.getBalance() > transferAmount) {
            bEnoughMoney = true;
        }


        return false;
    }

}
