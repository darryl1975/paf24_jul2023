package sg.edu.nus.iss.paf24_jul2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf24_jul2023.model.BankAccount;
import sg.edu.nus.iss.paf24_jul2023.service.BankAccountService;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {
    
    @Autowired
    BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<Boolean> createAccount(@RequestBody BankAccount bankAccount) {
        
        System.out.println("BankAccountController > createAccount > " + bankAccount.toString());
        Boolean bAccountCreated = bankAccountService.createAccount(bankAccount);

        if (bAccountCreated) {
            return ResponseEntity.ok().body(bAccountCreated);
        } else {
            // exception/custom exception handling
            return ResponseEntity.internalServerError().body(bAccountCreated);
        }
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getAccountbyId(@PathVariable("account-id") Integer id) {
        BankAccount bankAccount = bankAccountService.retrieveAccountById(id);

        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/transfer/{transferer-id}/receive/{receiver-id}/amount/{amount}")
    public ResponseEntity<Boolean> paynow(@PathVariable("transferer-id") Integer transferAccountId, @PathVariable("receiver-id") Integer receiveAccountId, @PathVariable("amount") Float transferAmount) {
        Boolean bTransferSuccess = bankAccountService.transferMoney(transferAccountId, receiveAccountId, transferAmount);

        return new ResponseEntity<Boolean>(bTransferSuccess, HttpStatus.OK);
    }

}
